#!/bin/bash

array=("" "" "" "" "" "" "" "" "")

vandak () {
    clear
    echo -e "\t ${array[0]:-0} | ${array[1]:-1} | ${array[2]:-2} "
    echo -e "\t__________________________"
    echo -e "\t ${array[3]:-3} | ${array[4]:-4} | ${array[5]:-5} "
    echo -e "\t__________________________"
    echo -e "\t ${array[6]:-6} | ${array[7]:-7} | ${array[8]:-8} "
}

WINo () {
    echo "Player 2 you Win"    
    break
}

WINx () { 
    echo "Player 1 you Win"
    break 
}

stugum_x () {
    if [ "x" == "${array[0]}" ] && [ "x" == "${array[1]}" ] && [ "x" == "${array[2]}" ] ; then
    WINx
    elif [ "x" == "${array[3]}" ] && [ "x" == "${array[4]}" ] && [ "x" == "${array[5]}" ] ; then
    WINx
    elif [ "x" == "${array[6]}" ] && [ "x" == "${array[7]}" ] && [ "x" == "${array[8]}" ] ; then
    WINx
    elif [ "x" == "${array[0]}" ] && [ "x" == "${array[3]}" ] && [ "x" == "${array[6]}" ] ; then
    WINx
    elif [ "x" == "${array[1]}" ] && [ "x" == "${array[4]}" ] && [ "x" == "${array[7]}" ] ; then
    WINx
    elif [ "x" == "${array[2]}" ] && [ "x" == "${array[5]}" ] && [ "x" == "${array[8]}" ] ; then
    WINx
    elif [ "x" == "${array[0]}" ] && [ "x" == "${array[4]}" ] && [ "x" == "${array[8]}" ] ; then
    WINx
    elif [ "x" == "${array[2]}" ] && [ "x" == "${array[4]}" ] && [ "x" == "${array[6]}" ] ; then
    WINx
    fi
}

stugum_o () {
    if [ "o" == "${array[0]}" ] && [ "o" == "${array[1]}" ] && [ "o" == "${array[2]}" ] ; then
    WINo
    elif [ "o" == "${array[3]}" ] && [ "o" == "${array[4]}" ] && [ "o" == "${array[5]}" ] ; then
    WINo
    elif [ "o" == "${array[6]}" ] && [ "o" == "${array[7]}" ] && [ "o" == "${array[8]}" ] ; then
    WINo
    elif [ "o" == "${array[0]}" ] && [ "o" == "${array[3]}" ] && [ "o" == "${array[6]}" ] ; then
    WINo
    elif [ "o" == "${array[1]}" ] && [ "o" == "${array[4]}" ] && [ "o" == "${array[7]}" ] ; then
    WINo
    elif [ "o" == "${array[2]}" ] && [ "o" == "${array[5]}" ] && [ "o" == "${array[8]}" ] ; then
    WINo
    elif [ "o" == "${array[0]}" ] && [ "o" == "${array[4]}" ] && [ "o" == "${array[8]}" ] ; then
    WINo
    elif [ "o" == "${array[2]}" ] && [ "o" == "${array[4]}" ] && [ "o" == "${array[6]}" ] ; then
    WINo
    fi
}


        krestik() {
        echo "PLAYER1: number for x"
        read i
        if [ "${array[i]}" == "o" ] || [ "${array[i]}" == "x" ]; 
        then 
            echo "Vandaky zbacvac e"
            krestik
        elif [ $i -ge 0 ] && [ $i -le 8 ];
        then
            array[i]=x
        else
            echo "input valid number"
            krestik
        fi
        }

        nolik () {
        echo "PLAYER2: number for o"
        read i
        if [ "${array[i]}" == "o" ] || [ "${array[i]}" == "x" ]; 
        then
            echo "Vandaky zbaxvac e"
            nolik
        elif [ $i -ge 0 ] && [ $i -le 8 ];
        then
            array[i]=o
        else
            echo "input valid number"
            nolik
        fi
        }
vandak
while true;
    do
        krestik
        vandak
        stugum_x
        nolik
        vandak
        stugum_o
    done
