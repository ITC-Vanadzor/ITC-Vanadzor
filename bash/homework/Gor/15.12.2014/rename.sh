#!/bin/bash

# Author: Gor
# This script will be change formates on your path (Directory)
# path: change your directory
# old_format: files old format
# new_format: files new format
 
echo "Please insert path of files:"
read path
echo "Please insert file format to change:"
read old_format
echo "Please insert new file format:"
read new_format

cd ${path}
find . -name "*.${old_format}" -exec rename -v 's/\.'${old_format}'/\.'$new_format'/i' {} \;
