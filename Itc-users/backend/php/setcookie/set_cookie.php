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
    /*
    function print_cookie(){
        if(!isset($_COOKIE[$cookie_name])) {
                echo $_COOKIE; 
        } else {
                echo "Cookie '".$cookie_name."' is set!<br>";
                    echo "Value is: ".$_COOKIE[$cookie_name];
        }
    }
     */
    echo $_COOKIE['some_user'];
    ?>
    </div>
    <button id="button" onclick="document.write('<?php print_cookie() ?>')"> Set Cookie </button>
    </body>
</html>
