#!/bin/bash
 
scp ~/numbers.sh student@192.168.33.77:~/
ssh student@192.168.33.77
#cd ~/Desktop
bash numbers.sh
exit



