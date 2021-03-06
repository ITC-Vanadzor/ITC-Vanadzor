#!/bin/bash

# Autor: Gor
# This script will be search and remove files
# size: file size
# file: search files from size (Mb)
# remove: interactive remove files

echo "Please insert file size:"
read size
file=$(find ./ -type f -size +${size}M)

if [[ -n "${file}" ]]
	then
		echo $file
		rm -i "${file}"
	else
		echo "ERROR: Files not found"
fi
