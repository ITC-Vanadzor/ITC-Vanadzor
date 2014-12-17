#!/bin/bash

# Autor: Gor
# This script will be search and remove files
# size: file size
# file: search files from size (Mb)
# remove: interactive remove files

echo "Please insert file size:"
read size
file=$(find ./ -type f -size +${size}M)
echo $file
remove=$(rm -i ${file})

if [[ -n ${file} ]]
	then
		echo $file
		${remove}
	else
		echo "ERROR: Files not found"
fi
