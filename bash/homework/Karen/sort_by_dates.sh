FILES=./*.*
arr=()
for f in $FILES
do
file_date=$(date +%s -r $f)
arr[$file_date]=$f
done
for k in "${!arr[@]}"
do
    echo $k ' - ' ${arr["$k"]}
done |
sort -rn 
