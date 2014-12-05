#!/bin/bash 
#pid=`ps "$1"`
#echo $pid
#(-f ("$pid")) &&  kill $pid
if ps -ef | grep -Fx "$1"
then 
    "$2" "$1"
