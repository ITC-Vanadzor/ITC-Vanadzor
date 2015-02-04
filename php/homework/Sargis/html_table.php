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
    ?>
    <table style="width:80%">
        <tr>
            <td rowspan=2>Name Surename</td>
            <td colspan=2>Status</td>        
            <td rowspan=2>Favorite Film</td>
        </tr>
        <tr>
            <td>Student</td>      
            <td>Employee</td>
        </tr>
        <tr>
            <td>Stepan Chaparyan<form action="images/Stepan.jpeg">
                        <input type="image" src="images/Stepan.jpeg" value="<?php echo $buttonName; ?>"></input></form></td>
            <td><input type="radio" name="status" value="student" checked></td>      
            <td><input type="radio" name="status" value="student" checked></td>
            <td><a href="https://www.youtube.com/watch?v=rUaTTljWZIs">Hatico</td>
            </tr>
    </table>
</body>
</html>

