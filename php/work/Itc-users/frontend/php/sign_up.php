<html>
	<head>
	<meta charset="UTF-8">
	<link href="../css/form.css" rel="stylesheet">
	<script src="../js/form.js"></script>
	</head>
	<body onload="onload()">
	<div class="blok">
	<div id="form">
	<form action="login.php" method="post">
		<p><label id="name_val" name="name" for="name">NAME* : </label><input type="text" id="name" placeholder=" YOUR NAME"></input></p>
		<p><label id="lname_val" name="lname" for="lname">LAST NAME* : </label><input type="text" id="lname" placeholder=" LAST NAME"></input></p>
		<p><label id="mail_val" name="mail" for="mail">EMAIL* : </label><input type="text" name="mail" id="mail" placeholder=" YOUR EMAIL"></input></p>
		<p><label id="pass_val" name="pass" for="pass">PASSWORD* : </label><input type="password" id="pass" placeholder=" YOUR PASSWORD"></input></p>
<p class="hide" hidden>Date Of Birth:
		<select name="month" class="age" id="month" onChange="changeDate(this.options[selectedIndex].value);">
			<option value="na">Month</option>
			<option value="1">January</option>
			<option value="2">February</option>
			<option value="3">March</option>
			<option value="4">April</option>
			<option value="5">May</option>
			<option value="6">June</option>
			<option value="7">July</option>
			<option value="8">August</option>
			<option value="9">September</option>
			<option value="10">October</option>
			<option value="11">November</option>
			<option value="12">December</option>
		</select>
		<select name="day" class="age" id="day" onChange="day()">
			<option value="na">Day</option>
		</select>
		<select name="year" class="age" id="year" onChange="year()">
			<option value="na">Year</option>
		</select>
		</p>
		<p class="hide" hidden>Age : <input type="text" id="age" placeholder=" YOUR AGE" readonly></input></p>
		<p class="hide" hidden>
		<input type="radio" name="group">Male</input>
		<input type="radio" name="group">Female</input></p>
		<input type="button" OnClick='hide()' value="Hide"></input>
		<button type="submit" OnClick="return valid();" id="sign">Sign Up</button>
</form></div></div>
	</body>

</html>
