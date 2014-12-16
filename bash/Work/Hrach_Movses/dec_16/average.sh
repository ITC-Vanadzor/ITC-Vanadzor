#!/bin/bash

ssh student@192.168.33.78 << EOF

echo $(((($1+$2))/2)) > ~/sum_average

chmod 777 ~/sum_average

scp ~/sum_average employee@192.168.33.60:~/
 
exit 

EOF

cat ~/sum_average
 

