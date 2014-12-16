#!/bin/bash

#path directory` $1
#file type` $2
#new file type` $3
for file in $1/*.$2
do
  mv "$file" "${file/.$2/.$3}"
done
