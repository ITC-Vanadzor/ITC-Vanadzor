#!/bin/bash

name=$(gdialog --title "Size" --inputbox "Please insert file size:" 50 60 2>&1)

a=$(find ./ -type f -size +${name}M)
rm=$(rm -i ${a})

if $a 
then
    echo ${a}
    $rm
else 
    $gdialog --title "ERROR" --infobox "Files not found" 20 60 2>&1
fi



