#!/bin/bash

array=("" "" "" "" "" "" "" "" "")

vandak () {
    echo -e "\t $array[0] | $array[1] | $array[2] "
    echo -e "\t__________________________"
    echo -e "\t $array[4] | $array[5] | $array[6] "
    echo -e "\t__________________________"
    echo -e "\t $array[7] | $array[8] | $array[9] "
    }
vandak

krestik () {
    echo "x="
    $array read x
    echo "input x or o:"
    read y
array[x]=y
echo ${array[@]}
}
krestik


