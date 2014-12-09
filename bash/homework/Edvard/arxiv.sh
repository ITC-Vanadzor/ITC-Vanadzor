#!/bin/bash

a=`sed -n '1p;1q' ~/Downloads/log | awk '{print $2}' `
var=`echo "$a" | sed 's/,//g'`
b1=`tail -1 ~/Downloads/log  | awk '{print $2}' `
var2=`echo "$b1" | sed 's/,//g'`
var3='log'
c="$var3"_"$var"_"$var2".tar.bz2
tar -cvjf u.tar.bz2 ./log
sudo chmod 777 u.tar.bz2
mv u.tar.bz2 $c  
