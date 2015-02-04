#!/bin/bash

#$1-file name
#$2-reversed file name
text=`cat $1`
echo $text | sed  's/\n/__X__/g' 
