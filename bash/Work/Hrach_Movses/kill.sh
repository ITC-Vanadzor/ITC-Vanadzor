#!/bin/bash

if [ $# -eq 1 ]; then
    aa=`pidof $1`
else
    aa="$1 `pidof $2`"
fi
kill $aa
