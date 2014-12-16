#!/bin/bash
du -s ${1}/* | while read size filename; do
if [ 1000 -lt $size ]; then
	rm -r -i "$filename"
fi
done
