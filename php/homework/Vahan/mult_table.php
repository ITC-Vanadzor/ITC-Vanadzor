<!DOCTYPE html>
<html>
<body>
<form name="myForm" method="post">
    Choose the number(between 1 and 9): 
    <input type="number" name="digit" min="1" max="9">
    <input type="submit">
</form>
<?php
$inputNumber = $_POST["digit"];
if ($inputNumber != null) {
    for ($x = 0; $x <= 10; $x++) {
        echo "$inputNumber" . "x" . "$x" . "=", $inputNumber*$x ."<br>";
    }
}
?>   

</body>
</html>
