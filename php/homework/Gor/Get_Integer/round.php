<?php
	function getInt($num, $den) {
		
		$res = intval($num / $den);	
		echo "$num / $den = $res <br><br>";
		echo var_dump($res);
	}
	
	getInt(17, 3)
?>