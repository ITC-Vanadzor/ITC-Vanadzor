#!/bin/bash

file=log
first=$(grep -m 1 -o "[0-9]\{4\}-[0-9]\{2\}-[0-9]\{2\} [0-9]\{2\}:[0-9]\{2\}:[0-9]\{2\}" $file)

last=$(grep -o "[0-9]\{4\}-[0-9]\{2\}-[0-9]\{2\} [0-9]\{2\}:[0-9]\{2\}:[0-9]\{2\}" $file | tail -n 1)


if [ "$first" != "$last" ] && [ -n "$first" ]

then

first=${first// /_}
last=${last// /_}
first=${first//:/-}
last=${last//:/-}

tar_name="log_"$first"_"$last".tar.bz2"

else

tar_name="date -r log"
tae_name=${tar_name// /_}
tae_name=${tar_name//:/-}

fi

tar cvfj "$tar_name" log
