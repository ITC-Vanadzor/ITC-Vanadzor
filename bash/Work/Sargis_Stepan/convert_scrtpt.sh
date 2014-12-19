#!/bin/bash

for i in *.jpeg
do
    new_name=$(echo $i|sed 's/.jpeg/.jpg/g')
    mv $i ./$new_name
  done


