<?php include 'header.php'; ?>
<?php 
if ($_COOKIE['login']){
    include 'page.php';
}else{
    if($_REQUEST['err']==1){
        echo "<div class='error'>Incorrect login or password</div>";
    }
?>
<div class="form-container"id="form-container" >
    <form id="registerform" action="request_sign_in.php" onsubmit="return true" method="post">
        <div class='input-text required'>
            <input type="text" name="login" id="login" placeholder="Login*"/>
            <p class="error hidden">Invalid Login! Check that name does not contain special symbols(e.g. %, $, #. @ etc.)</p>
            <p class="error hidden">This field can not be empty</p>
        </div>
        <div class='input-text required'>
            <input type="password" name="password" id="password" placeholder="Password*"/>
            <p class="error hidden">Invalid Name! Password should contain at least one digit, at least one lower case, at least one upper case, at least 6 from the mentioned characters</p>
            <p class="error hidden">This field can not be empty</p>
        </div>
        <div class='input-text checkbox'>
            <input type="checkbox" name="remember" id="remember" />
            <label for="remember">remember me</label>
        </div>
        <!--Submit-->
        <div class='input-submit'>
            <input type="submit" name="submit" id="submit" value="Sign in"/>
        </div>
    </form>
    <a href="register.php">Create account</a>
</div>
<?php } ?>
<?php include 'footer.php'; ?>