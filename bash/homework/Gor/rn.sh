#!/bin/bash

path=$(gdialog --title "Path of files" --inputbox "Please insert path of files:" 50 60 2>&1)
old=$(gdialog --title "Current format" --inputbox "Please insert file format to change:" 50 60 2>&1)
new=$(gdialog --title "New format" --inputbox "Please insert new file format:" 50 60 2>&1)

cd ${path}
find . -name "*.$old" -exec rename -v 's/\.'$old'/\.'$new'/i' {} \;
