#!/bin/bash
of="log_"
first_date=$(cut -d" " -f1,2 ~/homework/log | head -n1)
last_date=$(cut -d" " -f1,2 ~/homework/log | tail -n1)
filename=$first_date$last_date
filename_1=$(echo $filename | sed s/,/_/g | sed s/" "/_/g)
tar -czf ./"$of$filename_1" /home/vahan/homework/log

