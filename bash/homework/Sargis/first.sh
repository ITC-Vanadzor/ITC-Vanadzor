#!/bin/bash
#qani vor chenq karogh file-i anvan mej ':' simvol@ ogtagorcel, poxenq ayn '-'-ov
#ogtagorcel em '$1' scripti 1in argument@ vorpesi karoghananq archivacnel voch miayn trvac file@, aylev cankacac ayl file
var1=`cut -d ' ' -f 2 $1 | head -n1 | tr ':' '-'`
var2=`cut -d ' ' -f 2 $1 | tail -1 | tr ':' '-'`
var="$var1"_"$var2"
echo $var
#echo $var2
tar -cjf ./"$1_$var.bz2" $1
