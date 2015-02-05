<?php
    function divide_int($a,$b){
        $c = $a/$b;
	echo "$a/$b=";
	echo $c."<br>";
	echo "rounded value=".(floor($c)."<br>");
	}
divide_int(20,7);
?>
