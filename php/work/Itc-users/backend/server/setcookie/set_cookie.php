<!DOCTYPE html>
<html>
<?php
    $cookie_name = "some_user";
    $cookie_value = "Poghos Poghosyan";
    setcookie($cookie_name, $cookie_value, time()+1200);
            
?>    
    <head>
        <meta charset="utf-8">
        <title>set_cookie</title>
    </head>
    <body>
    <div id="output"> 
    <?php
    
    function print_cookie(){
        global $cookie_name;
	global $cookie_value;
        if(!isset($_COOKIE[$cookie_name])) {
                echo "Cookie named '" . $cookie_name . "'is not set!"; 
        } else {
                echo "Cookie '".$cookie_name."' is set!<br>";
                    echo "Value is: ".$_COOKIE[$cookie_name];
        }
    }
    ?>
    </div>
    <script>
    function print_cook(){
	document.getElementById("output").innerHTML = "<?php print_cookie(); ?>";
    }
    </script>
    <button id="button" onclick="print_cook()"> Set Cookie </button>
    </body>
</html>
