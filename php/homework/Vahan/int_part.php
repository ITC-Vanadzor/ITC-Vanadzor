<form name="myForm" method="post">
    Input a float number and get the integer part of it:
    <input type="text" name="digit">
    <input type="submit">
</form>
<?php
$inputNumber = $_POST["digit"];
echo intval($inputNumber);
?>

