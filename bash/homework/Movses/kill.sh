#!/bin/bash

PID=`ps -ef | grep $1 | grep -v grep | awk '{print $2}'`
echo $PID
kill -9 $PID
