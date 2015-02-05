<!DOCTYPE html>
<html>
    <head>
        <style>
              table, td {
                  border: 1px solid black;
                  text-align: center
               } 
        </style>
    </head>
    <body>
    <?php 
        $buttonName = 'image';
        $header_1 = "Name Surename";
        $header_2 = "Status";
        $header_3 = "Favorite Movie";
        $header2_1 = "Student";
        $header2_2 = "Employee";
        $person_1 = "Stepan Chaparyan";
        $person_2 = "Vahan Levonyan";
        $person_3 = "Goe Julhakyan";
        $movie_1 = "Hatico";
        $movie_2 = "Lucy";
        $movie_3 = "Transporter";
    ?>
    <form action="data_reciever.php" method="post">
    <table style="width:80%" name="my_table">
        <tr>
            <td rowspan=2><?php echo $header_1; ?></td>
            <td colspan=2><?php echo $header_2; ?></td>        
            <td rowspan=2><?php echo $header_3; ?></td>
        </tr>
        <tr>
            <td><?php echo $header2_1; ?></td>      
            <td><?php echo $header2_2; ?></td>
        </tr>
        <tr>
            <td><?php echo $person_1; ?><form action="images/Stepan.jpeg">
                        <input type="submit" src="images/Stepan.jpeg" value="<?php echo $buttonName; ?>"></input></form></td>
            <td><input type="radio" name="status" value="student" checked></td>      
            <td><input type="radio" name="status" value="student" checked></td>
            <td><a href="https://www.youtube.com/watch?v=rUaTTljWZIs"><?php echo $movie_1; ?></td>
        </tr>
        <tr>
            <td><?php echo $person_2; ?><form action="images/vahan.jpg">
                        <input type="submit" src="images/vahan.jpg" value="<?php echo $buttonName; ?>"></input></form></td>
            <td><input type="radio" name="status1" value="student" checked></td>
            <td><input type="radio" name="status1" value="student" checked></td>
            <td><a href="https://www.youtube.com/watch?v=-hpupbliDbk"><?php echo $movie_2; ?></td>
         </tr>
         <tr>
            <td><?php echo $person_3; ?><form action="images/gor.png">
                        <input type="submit" src="images/gor.png" value="<?php echo $buttonName; ?>"></input></form></td>
            <td><input type="radio" name="status2" value="student" checked></td>
            <td><input type="radio" name="status2" value="student" checked></td>
            <td><a href="https://www.youtube.com/watch?v=qlG1tselOn4"><?php echo $movie_3; ?></td>
         </tr>
    <input type="submit">
    </table>
    </form>
</body>
</html>

