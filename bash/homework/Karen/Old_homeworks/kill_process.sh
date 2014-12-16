#!/bin/bash
<<<<<<< HEAD
aa=$(ps -ef | grep chrome |cut -d" " -f4 | head -n1)
kill $aa

=======
kill $(ps -ef | grep firefox | tr -s " " | head -n 1 | cut -d " " -f2)
>>>>>>> 180e027dd3c4ecface859d4ba14bb886ad428106
