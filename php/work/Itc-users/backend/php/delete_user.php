<html>
<body>
<?php
    if($_SERVER['REQUEST_METHOD']=='GET'){
	$_SERVER['REQUEST_METHOD']="DELETE";
                    
    }
    
echo $_SERVER['REQUEST_METHOD'];

?>
</body>
</html>
