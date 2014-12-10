le=log
first=$(grep -m 1 -o "[0-9]\{4\}-[0-9]\{2\}-[0-9]\{2\} [0-9]\{2\}:[0-9]\{2\}:[0-9]\{2\}" $faile)
last=$(grep -o "[0-9]\{4\}-[0-9]\{2\}-[0-9]\{2\} [0-9]\{2\}:[0-9]\{2\}:[0-9]\{2\}" $faile | tail -n 1)
if [ -z $first || -z $last ]; then
ls -l /home/marine/Dekstop/log > a
second=$(grep  -o "[0-9]\{2\}:[0-9]\{2\}" a)
tar_name="log_"$second".tar.bz2"
else
first=${first// /_}
last=${last// /_}
tar_name="log_"$first"_"$last".tar.bz2" 
fi
tar cvjf tar_name log 
