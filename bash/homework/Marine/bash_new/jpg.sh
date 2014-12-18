#!/bin/bash

# $1 directory path
# $2 file type
# $3 file new type

cd $1
for f in *.$2
do 
   mv "$f" "${f/.$2/.$3}" 
done
