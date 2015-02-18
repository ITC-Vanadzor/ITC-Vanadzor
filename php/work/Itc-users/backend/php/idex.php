<!DOCTYPE html>
<html>
<body>
<?php 
function get_user(){
    $curl=curl_init();
    curl_setopt_array($curl, array(
        CURLOPT_URL => 'http://get_user.php',
        CURLOPT_POST => 1
        )
    $res = curl_exec($curl);
    curl_close($curl);
}

?>
<script>
function send_request_POST(){
	<?php get_user() ?>;
 }
</script>
<form method="POST" action="send_request_POST()" id="php_form">
<input type="submit" value="send POST"> 
</form>
<form method="DELETE" action="send_request_DELETE()" id="php_form2" >
<input type="submit" value="Send DELETE">
</form>

</body>
</html>
