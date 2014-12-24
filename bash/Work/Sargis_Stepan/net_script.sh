#!/bin/bash

var1=50
var2=70
var=0
function average
{
    var=$(((var1 + var2)/2))
}
average
echo $var
scp "$0" employee@192.168.33.60:/home/employee
ssh employee@192.168.33.60 << EOF
  bash /home/employee/net_script.sh > aaa
  scp /home/employee/aaa student@192.168.33.78:/home/student
  exit
  EOF


