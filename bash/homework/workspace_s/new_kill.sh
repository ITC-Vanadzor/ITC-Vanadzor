#!/bin/bash
proc_kill()
{
    pid=$(ps -ef | grep $1 | cut -d ' ' -f 4 | head -n1 )
    echo $pid
    kill $pid
}
proc_kill $1
