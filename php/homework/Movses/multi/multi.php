<center>

<?php
$num1=$_POST['txt'];

for($i=1; $i<=10; $i++) { 
    echo $num1 . " " . "X" . " " . $i . " " . "=";
    echo " " . $i * $num1 . "<br>";
}

?>
</center>
