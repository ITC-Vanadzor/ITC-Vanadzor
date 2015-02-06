<?php
	require 'edit.php';
?>

<html>
<head>
	<meta charset="utf-8">
	<meta name="description" content="<?php echo $desc; ?>">
	<meta name="keywords" content="<?php echo $keyws; ?>">
	<meta name="author" content="<?php echo $author; ?>">
	<title><?php echo $gtitle; ?></title>  
	<link rel="stylesheet" href="css/style.css"
</head>

<body>
	<div class="container">
		<h1><?php echo $title; ?></h1>
		<div class="name">
			<h2><?php echo $names; ?></h2>
			<div><?php echo $chs; ?> &nbsp; <img src="images/Stepan.jpg" style="width: 6%;">&nbsp;
				<a href="#openModal">zoom</a>
					<div id="openModal" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Stepan.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $gm; ?> &nbsp; <img src="images/Marine.jpg" style="width: 8%;">&nbsp;
				<a href="#openModal1">zoom</a>
					<div id="openModal1" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Marine.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $he; ?> &nbsp; <img src="images/Eduard.jpg" style="width: 7%;">&nbsp;
				<a href="#openModal2">zoom</a>
					<div id="openModal2" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Eduard.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $jg; ?> &nbsp; <img src="images/Gor.jpg" style="width: 6%;">&nbsp;
				<a href="#openModal3">zoom</a>
					<div id="openModal3" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Gor.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $khm; ?> &nbsp; <img src="images/Movses.jpg" style="width: 9%;">&nbsp;
				<a href="#openModal4">zoom</a>
					<div id="openModal4" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Movses.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $ks; ?> &nbsp; <img src="images/non.jpg" style="width: 6%;">&nbsp;
				<a href="#openModal5">zoom</a>
					<div id="openModal5" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/non.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $kk; ?> &nbsp; <img src="images/Karen.jpg" style="width: 8%;">&nbsp;
				<a href="#openModal6">zoom</a>
					<div id="openModal6" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Karen.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $lv; ?> &nbsp; <img src="images/Vahan.jpg" style="width: 7%;">&nbsp;
				<a href="#openModal7">zoom</a>
					<div id="openModal7" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Vahan.jpg" width=100%>
						</div>
					</div>
			</div>
			<div><?php echo $mh; ?> &nbsp; <img src="images/Hrach.jpg" style="width: 6%;">&nbsp;
				<a href="#openModal8">zoom</a>
					<div id="openModal8" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
							<img src="images/Hrach.jpg" width=100%>
						</div>
					</div>
			</div>
		</div>
	  <div class="status">
			<h2 id="st"><?php echo $status; ?></h2>
			<div class="student">
				<h3><?php echo $student; ?></h2>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
				<div><input type="checkbox" name="student" value="student" checked></div>
			</div>
			<div class="employee">
				<h3><?php echo $employee; ?></h2>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>
				<div><input type="checkbox" name="employee" value="employee"></div>            </div>
		</div>
		<div class="movie">
			<h2><?php echo $movie; ?></h2>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
			<div><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></div>
		</div>
	</div>
</body>
</html>
