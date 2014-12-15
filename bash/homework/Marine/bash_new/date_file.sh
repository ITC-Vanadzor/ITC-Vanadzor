#!/bin/bash

#  crontab -e hramanov bacum enq croni config fily ev grum enq        
#0 * * * * /home/marine/date_file.sh

str1=`date | cut -d ' ' -f 4`  
ls ~/ > home_"$str1"
