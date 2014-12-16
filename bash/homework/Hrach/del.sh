#!/bin/bash

for file in `ls`;
do
if [ `du -b $file | grep -o '[0-9]*'` -gt 1048576 ];
then rm -i $file
fi
done
