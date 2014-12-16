#!/bin/bash
#Created by Eduard Hakobyan

echo "Hello! Nermuceq te inch cavalic poqr faylern eq cankanum jnjel kilobaytnerov"; read size

for file in *;
  do
    file_size=$(du $file | awk '{print $1}');
    if [ $file_size -lt $size  ]; then
	echo "Are you sure to delete file $file with file size less than $size Kb? (y/n)"    
    read item   
	case "$item" in
        y|Y) 
			rm -f $file
			echo "$file fayl@ jnjelem."
            ;;
        n|N) echo "$file fayl@ karayi jnjem, bayc de vor cheq uzum(( "
            ;;
        *) echo "Ete patahakan urish stexni kpar ushadir exi opasni gorca, isk ete porcumeir tenas inch kgri sxal mutqi depqum, apa tesar ena ^_^ )) "
            ;;
esac
fi;
done

