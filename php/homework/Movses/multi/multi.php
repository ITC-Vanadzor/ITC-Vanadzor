<?php
function mult() {
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $num1 = $_REQUEST['txt']; 
        return $num1;
        echo $num1;
    }
   // $num1=141341;
    for($i=1; $i<11; $i++) { 
        echo $num1 . " " . "X" . " " . $i . " " . "=";
        echo " " . $i * $num1 . "\n";
        } 
}
mult()
?>
