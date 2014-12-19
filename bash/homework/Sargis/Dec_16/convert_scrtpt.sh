#!/bin/bash
# $1 is source directory, $2 extension that will be changed, $3 final extension 
for i in $1/*.$2
do
     new_name=$(echo $i|sed 's/'$2'/'$3'/g')
     mv -v "$i" "$new_name"
done


