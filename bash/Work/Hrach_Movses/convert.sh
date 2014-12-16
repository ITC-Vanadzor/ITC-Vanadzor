#!/bin/bash

rm ~/*.j*

for file in `seq 1 10`;
do
touch imag$file.jpg
touch image$file.jpeg
done

for file in *.jpeg;
do
mv $file ${file/.jpeg/.jpg}
done
