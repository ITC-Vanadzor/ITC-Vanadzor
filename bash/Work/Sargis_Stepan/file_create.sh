#!/bin/bash
string1=`date | cut -d ' ' -f 4`  
echo $string1
ls > "$string1"
