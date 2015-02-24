<?php
 $regexp_name='/[a-zA-Z\s]/';
if (!filter_var($_POST['name'],FILTER_VALIDATE_REGEXP,$regexp_name)){
      $message = 'ong';
      echo $message;}
else{
echo "correct";
}
 $txt="aaa.txt";
//
 echo "aaa";
 $file=fopen($txt,'a+');
 foreach ($_POST as $key=>$value){
   echo "NNN";
$add_txt=$key."--".$value."/n ";//.$_POST['lastname']." ".$_POST['email'];
 //  echo "aaa" $add_text."\n";
 }
 fwrite($file,"NN");}
 fclose($file);
?>

<html>
<body>
aaa
</body>
</html>
