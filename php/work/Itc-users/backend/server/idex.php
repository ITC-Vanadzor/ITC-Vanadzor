<!DOCTYPE html>
<html>
<body>
<?php 
function get_user(){
    $curl=curl_init();
    curl_setopt($curl, CURLOPT_URL, "localhost/get_user.php");
    curl_setopt($curl,CURLOPT_POST, 1);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    $res = curl_exec($curl);
    if ($res == "OK") {
        echo "bo";
    } else {
        echo "fuuuu";
    }
    curl_close($curl);
}

?>
<script>
function send_request_POST(){
	<?php get_user() ?>
 }
</script>
<button  onclick="send_request_POST()"> Send request </button>
<div><?php echo $res; ?> </div>
<!--<form method="DELETE" action="send_request_DELETE()" id="php_form2" >
<input type="submit" value="Send DELETE">
</form> -->

</body>
</html>
