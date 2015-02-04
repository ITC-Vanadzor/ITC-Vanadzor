<html>
	<head>
		<title>
			Multiplication table
		</title>
	</head>
	<body>	
	<style>
	table {
	background: rgb(169,3,41);
	background: -moz-radial-gradient(center, ellipse cover, rgba(169,3,41,1) 0%, rgba(143,2,34,1) 44%, rgba(109,0,25,1) 100%);
	background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%,rgba(169,3,41,1)), color-stop(44%,rgba(143,2,34,1)), color-stop(100%,rgba(109,0,25,1)));
	background: -webkit-radial-gradient(center, ellipse cover, rgba(169,3,41,1) 0%,rgba(143,2,34,1) 44%,rgba(109,0,25,1) 100%);
	background: -o-radial-gradient(center, ellipse cover, rgba(169,3,41,1) 0%,rgba(143,2,34,1) 44%,rgba(109,0,25,1) 100%);
	background: -ms-radial-gradient(center, ellipse cover, rgba(169,3,41,1) 0%,rgba(143,2,34,1) 44%,rgba(109,0,25,1) 100%);
	background: radial-gradient(ellipse at center, rgba(169,3,41,1) 0%,rgba(143,2,34,1) 44%,rgba(109,0,25,1) 100%);
	}
	body {
	font-size:50px;
	text-align:center;
	}
	</style>
		<?php
		$name = "Name";
		$sname = " Surname";
		$emp = "Employment";
		$student = "Student";
		$worker = "Worker";
		$fav = "Favorite serial";
		$name1 = "Hrach Mkrtchyan";
		$name2 = "Eduard Hakobyan";
		$name3 = "Hasmik Naslyan";
		$zoom = "Zoom image";
		$serial_name1 = "Full House";	
		$serial_name2 = "Soy Gitano";
		$serial_name3 = "Interns";
		?>
<table border="2" cellspacing="0"
    cellpadding="8" style="background-color:#cc0000; color:#ffffff">
    <tr >  
        <td rowspan="2"><?php echo $name,$sname ?></td>
        <td colspan="2"><?php echo $emp ?></td>
        <td rowspan="2"><?php echo $fav ?></td>
    </tr>
    <tr>
        <td><?php echo $student ?></td>
        <td><?php echo $worker ?></td>
    </tr>
    <tr>
        <td><?php echo $name1 ?> <img src="https://scontent-a-fra.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/s720x720/10592633_817674194949734_6578777228316585940_n.jpg?oh=2bd373962da8a3479e7937b62e5ed0f7&oe=55263FF9" height="15"> <a href="https://scontent-a-fra.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/s720x720/10592633_817674194949734_6578777228316585940_n.jpg?oh=2bd373962da8a3479e7937b62e5ed0f7&oe=55263FF9"><img src="zoom.png" alt="Click to zoom" style="width:10%"></a></td>
        <td><input type="radio" name="group1" > <br></td>
        <td><input type="radio" name="group1" > </td>
        <td> <a href="http://www.armeniatv.am/hy/tv-series/1411389369"><?php echo $serial_name1 ?></a></td>
    </tr>
    <tr>
        <td><?php echo $name2 ?> <img src="https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xpa1/t31.0-8/10694392_825478390816998_3875722087065381560_o.jpg" height="15"> <a href="https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xpa1/t31.0-8/10694392_825478390816998_3875722087065381560_o.jpg"> <img src="zoom.png" alt="Click to zoom" style="width:10%"> </a></td>
        <td><input type="radio" name="group3" ></td>
        <td><input type="radio" name="group3" ></td>
        <td> <a href="http://latino-serialo.ru/argentinskie_seriali_online/166-serial-cyganskaya-krov.html"><?php echo $serial_name2 ?></a></td>
    </tr>
    <tr>
        <td><?php echo $name3 ?> <img src="https://avatars2.githubusercontent.com/u/6958236?v=3&s=460" height="15"> <a href="https://avatars2.githubusercontent.com/u/6958236?v=3&s=460"><img src="zoom.png" alt="Click to zoom" style="width:10%"></a></td>
        <td><input type="radio" name="group2" ></td>
        <td><input type="radio" name="group2" ></td>
        <td> <a href="http://interny.tnt-online.ru"><?php echo $serial_name3 ?></a></td>
    </tr>
	</body>
<html>

