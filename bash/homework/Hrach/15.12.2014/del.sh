#!/bin/bash

for file in `ls $1`;
do
if [ `stat -c %s $1$file` -gt 1048576 ];
then rm -i $file
fi
done
