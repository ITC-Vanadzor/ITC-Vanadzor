<!DOCTYPE html>
<html>
<body>
<script>
    
function send_request_POST(){
	<?php get_user() ?>;
}   
function get_user(){
    curl = curl_init()
 }
?>
<form method="POST" action="send_request_POST()" id="php_form">
<input type="submit" value="send POST"> 
</form>
<form method="DELETE" action="<?php  delete_user() ?>" id="php_form2" >
<input type="submit" value="Send DELETE">
</form>

</body>
</html>
