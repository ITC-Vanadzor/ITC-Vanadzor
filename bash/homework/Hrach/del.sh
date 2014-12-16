#!/bin/bash

for file in `ls`;
do
size =`du -b $file | grep -o '[0-9]*'`
echo $size

if [ $size -gt 1048576 ];
then rm -i $file
fi
done
