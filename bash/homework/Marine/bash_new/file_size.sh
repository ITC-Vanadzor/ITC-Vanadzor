#!/bin/bash

cd $1
#$1 directory path
for file_name in ` ls $1 `
do
  if [ -f "$file_name" ]
    size_file = `stat -c %s "$i"`
    if [ ${size_file} -gt 1048576 ]; then
       rm -i "${file_name}"
    fi
  fi
done


