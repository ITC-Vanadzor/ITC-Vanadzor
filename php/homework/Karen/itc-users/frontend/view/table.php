<?php
if (!$_POST['mail']) {
    header('Location: login.html');
} else if ($_POST['rememberme']) {
    setcookie('mail', $_POST['mail']);
} else {
    setcookie('mail', $_POST['mail'], time() + 1200);
}
if(!$_COOKIE["mail"]) {
    header('Location: login.html');
}
?>

<html>
    <head>
        <title>ITC users</title>
        <meta charset="UTF-8">
        <link href="../css/form.css" rel="stylesheet">
        <script src="../js/login.js"></script>
        <script src="../js/form.js"></script> <link rel="stylesheet" href="../css/style.css"/>
        <script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
        <script type="text/javascript" src="../js/functions.js"></script>
    </head>
    <body>
        <div id="overlay">		
            <div id="form">
                <form action="login.html" method="post">
                    <p>
                        <label id="name_val" name="name" for="name">NAME* : </label>
                        <input type="text" id="name" placeholder=" NAME" />
                    </p>
                    <p>
                        <label id="lname_val" for="lname">LAST NAME* : </label>
                        <input type="text" name="lname" id="lname" placeholder=" LAST NAME"/>
                    </p>
                    <p>
                        <label id="mail_val" for="mail">EMAIL* : </label>
                        <input type="text" name="mail" id="mail" placeholder=" EMAIL" />
                    </p>
                    <p>
                        <label id="pass_val" for="pass">PASSWORD* : </label>
                        <input type="password" name="pass" id="pass" placeholder=" PASSWORD" />
                    </p>
                    <p class="hide" hidden>Date Of Birth:
                        <select name="month" class="myage" id="month" onChange="changeDate(this.options[selectedIndex].value);">
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
                        <select name="day" class="myage" id="day" onChange="day_birdth()">
                            <option value="na">Day</option>
                        </select>
                        <select name="year" class="myage" id="year" onChange="year_birdth()">
                            <option value="na">Year</option>
                        </select>
                    </p>
                    <p class="hide" hidden>Age : 
                        <input type="text" id="age" placeholder=" AGE" readonly>
                    </p>
                    <p class="hide" hidden>
                        <input type="radio" name="group" value="Male" />
                        <input type="radio" name="group" value="Female" />
                    </p>
                    <input type="button" OnClick='hide()' value="Hide" />
                    <button type="submit" OnClick="return valid();" id="sign"></button>
                    <input type="button" OnClick="hide();
                            overlay()" value="Cancel" />
                </form>
            </div>
        </div>
        <div>
            <div id="header">
                <span>Welcome <?php echo $_COOKIE["mail"]; ?></span>
                <a href=""  onclick="signOut('mail');">
                    Log Out
                </a>
            </div>		
            <div id="panel">
                <button class="signup" onclick="hide();
                        overlay('Sign Up');
                        addYear()">
                    Add
                </button>
            </div>
            <div class="tableWrapper">
                <div class="tablePage" id="tablePage">

                </div>
                <div class="addUser">
                    <a href="#modal-dialog" onclick="addUser();" class="addUserLink">Add user</a>
                </div>           
            </div>
        </div>
    </body>
</html>
