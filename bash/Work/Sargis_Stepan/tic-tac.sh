#!/bin/bash
# ALGORITHM
# 1.
#
#
array=('' '' '' '' '' '' '' '' '') 
board(){
    echo -e "\t___________________"
    echo -e "\t| ${array[0]} | ${array[1]} | ${array[2]} |"
    echo -e "\t___________________"
    echo -e "\t| ${array[3]} | ${array[4]} | ${array[5]} |"
    echo -e "\t___________________"
    echo -e "\t| ${array[6]} | ${array[7]} | ${array[8]} |"
    echo -e "\t___________________"
}
array[0]=x


board

