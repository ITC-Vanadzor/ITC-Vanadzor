#!/bin/bash

mast=("C" "D" "H" "S")

karti_arjeq=("A" "2" "3" "4" "5" "6" "7" "8" "9" "10" "J" "Q" "K")

array=()
karter () {
k=0
for l in `seq 0 1`
    do
        for i in `seq 0 3`
            do
                for j in `seq 0 12`
                    do
                        array[$k]=${mast[$i]}.${karti_arjeq[$j]}
                        let k++
                    done
            done 
    done
}
karter
shuf_array=$(shuf -e  ${array[@]}) 
k=0
for m in `seq 1 5`
do
    for t in `seq  $k $(($k+9))`
    do
        echo -n ${shuf_array[${t}]} "  " 
    done
    k=$(($k+10))
done
echo
