#!/bin/bash

for i in * 
do
filesize=$(stat -c%s "$i")
if [ $filesize -gt 1048576 ]
    then rm -ri "$i"
  fi 
done
