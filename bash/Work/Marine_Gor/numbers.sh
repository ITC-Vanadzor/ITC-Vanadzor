#!/bin/bash

number_1=$1
number_2=$2
num=0
if [ -n ${number_1} -a ${number_2} ]
    then 
        num="$(( (${number_1} + ${number_2}) / 2 ))"
        echo $num > Number.txt
    else
        echo "ERROR: Paste two numbers" > Number.txt
fi


