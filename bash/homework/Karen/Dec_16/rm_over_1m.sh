#!/bin/bash
echo "Set Directory"; read dir
du -s ${dir}/* | while read size filename; do
if [ 1000 -gt $size ]; then
	rm -r -i "$filename"
fi
done
