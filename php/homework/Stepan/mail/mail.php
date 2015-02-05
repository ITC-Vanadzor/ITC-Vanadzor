#!/usr/bin/php

<?php

$msg = "This is my first mail by php \n It is very easy";

if (mail('schaparian@yahoo.com','My first mail by php',$msg)){
   echo "Message Sent";
} else {
   echo "Message Failed";
}
?>

