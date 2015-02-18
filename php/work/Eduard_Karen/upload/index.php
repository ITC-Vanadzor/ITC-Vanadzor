<?php
?>

<?php include('header.php'); ?>
  <form action="upload.php" method="post" enctype="multipart/form-data">
    <input type="file" id="file" name="file"/>
   <input type="submit" value="Submit" id="submit" name="submit"/>

  </form>
<?php include('footer.php') ;?>
