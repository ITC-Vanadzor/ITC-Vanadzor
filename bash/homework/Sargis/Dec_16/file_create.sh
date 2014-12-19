#!/bin/bash
# you can run crontab -e and input the date and time, when you want this script # to run. for example we can run script
# on every hour at 35 minute by writing in cron config file this line
# 35 * * * * /home/sargis/Desktop/workspace/file_create.sh

string1=`date | cut -d ' ' -f 4`  
ls > ~/Desktop/"$string1"
crontab -l > aaa
echo "35 * * * * /home/sargis/Desktop/workspace/file_create.sh" >> aaa
crontab aaa
rm aaa

