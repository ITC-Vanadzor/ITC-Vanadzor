#!/bin/bash

echo "Set directory files"; read dir
echo "Set files current type"; read cur_type
echo "Set files new type"; read new_type

for file in ${dir}/*.$cur_type
do
  mv "$file" "${file/.${cur_type}/.$new_type}"
done
