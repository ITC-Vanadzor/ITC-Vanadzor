<?php
	$num=$_POST['num'];
?>
<html>
	<head>
		<title>MULTIPLICATION</title>
	</head>
	<body>
		<?php
			function multiplication($num=1){
				$sum=1;
				for ($n=1;$n<10;$n++){
					$sum=$num*$n;
					echo "$num",'*',"$n=","$sum","\n","<br>";  
			}}
			multiplication($num);
		?>
	<body>

</html>

