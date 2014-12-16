#!/bin/bash
# the first argument of this script is the path, where script should find and interactively delete files that are greater then 1Mb

string2=`find "$1" -size +1M`
for i in $string2
    do  
    rm -i "$i"
    done
