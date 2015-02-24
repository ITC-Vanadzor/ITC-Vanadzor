<html>
<head>
<link rel="stylesheet" href="css/style.css"></link>
<script src="js/functions.js"></script>
</head>
<body onload="addSelectYears()">
<div class="wrapper">

<?php 
    if($_SERVER["REQUEST_METHOD"]!="POST"){
        echo "Invalid method"; 
    }else{
        var_dump($_POST);
    }
    
?>
</div>
</body>
</html>
