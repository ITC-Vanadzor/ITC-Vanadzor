#!/bin/bash

ssh student@192.168.33.78 << EOF

echo $(((($1+$2))/2)) > ~/sum_average


exit 

EOF

scp student@192.168.33.78:~/sum_average ~/

cat ~/sum_average
 

