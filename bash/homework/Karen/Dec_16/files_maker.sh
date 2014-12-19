#!/bin/bash

#directory path
echo "Set directory, where you can make directory or set your files."; read dir
#count files 
echo "Set count files."; read count
#type file 
echo "Set files type."; read file_type

if [ ! -d "$dir" ]; then
	mkdir -p $dir
fi

while [  $count -gt 0 ]; do
	touch ${dir}/file_${count}.${file_type}
	let count-- 
done
