#!/bin/bash

# Author: Gor
# This script created new file and print all process into file 
# name: current date \Year-Month-Day.Hour.Minute.Second\
# ls..: paste all process into file

cd ~
name=`date +%Y-%m-%d.%H:%M:%S`
ls -la > "$name"

crontab -l > cron    # create crontab 
echo "* 01 * * * /REAL/PATH/proc_list.sh" >> cron	# past new cron
crontab cron	# install new cron into crontab
rm -r cron    # delete installed cron



