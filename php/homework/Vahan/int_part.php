<form name="myForm" method="post">
    Divide the numbers and get the result(int part of it):
    <input type="text" name="digit_1">
    <input type="text" name="digit_2">
    <input type="submit" value="divide">
</form>
<?php
function divFloor($x, $y) {
    $z = $x/$y;
    return intval($z);
}
$inputNumber_1 = $_POST["digit_1"];
$inputNumber_2 = $_POST["digit_2"];
echo divFloor($inputNumber_1, $inputNumber_2);
?>

