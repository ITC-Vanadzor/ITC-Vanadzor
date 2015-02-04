<?php 

function setArgs(){
	global $rows,$colls,$textColor,$borderColor,$tdPadding,$fontSize;
		$rows        = 5;
	  $colls       = 15;
		$textColor   = "red";
		$borderColor = "green";
		$tdPadding   = "5px 10px";
		$fontSize    = "20px";
}
setArgs();
?>

<html>
<head>
	<title>HTML table</title>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<style>
	td{
		border: 1px solid <?php echo $borderColor; ?>;
		padding: <?php echo $tdPadding; ?>;
		color: <?php echo $textColor; ?>;
		font-size: <?php echo $fontSize; ?>;
	}	
		</style>
</head>
<body>
	<div class="wrapper">
		<table cellspacing="0">
			<?php for($i=1;$i<=$rows;$i++){ ?>
				<tr>
					<?php for($j=1;$j<=$colls;$j++){ ?>
						<td>
							<?php echo $i,", ",$j; ?>
						</td>
					<?php } ?>
				</tr>
			<?php } ?>
		</table>
	</div>
</body>
</html>

