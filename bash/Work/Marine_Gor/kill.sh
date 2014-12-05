#!/bin/bash
function terminate_process 
{

    if [ `ps -All | grep $1 | wc -l` -eq 0 ];
    then
        echo "sorry $1 not running..."
    else
        user_id=`whoami`
        ps -eo pid,comm,user | grep $1 | grep $user_id > file_name #| sed 's/ //g' file_name
        pid=`sed 's/[a-z]//g' file_name`
        kill -15 $pid
        rm -f file_name
    fi
}
terminate_process $1
