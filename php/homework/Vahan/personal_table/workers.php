<!Doctype html>
<html>
    <head>
        <style>
        table, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center
        }
        </style>
    </head>
    <body>
    <?php
    $full_name1 = $_POST["fname"] . " " . $_POST["lname"];
    $full_name2 = "Movses Khachatryan";
    $image_path1 = "images/Vahan.jpg";
    $image_path2 = "images/Movses.jpg";
    ?>
        <table style="width:100%">
            <tr>
                <td rowspan=2>Firstname Surname</td>
                <td colspan=2>Status</td>
                <td rowspan=2>Film</td>
            </tr>
            <tr>
                <td>Student</td>
                <td>Worker</td>
            </tr>
            <tr>
                <td><?php echo $full_name1 ?> 
                    <form action=<?php echo $image_path1 ?>> 
                        <input type="Submit" value="Picture"><p><img scr="images/Vahan.jpg"/> </p> 
                    </form> 
                </td>
                <form>
                    <td> <input type="radio" name="status" value="student" checked>Student</td>
                    <td> <input type="radio" name="status" value="worker">Worker</td>
                </form>
                <td> <a href="https://www.youtube.com/watch?v=QHWbzrCJ4nE">Chappie </td>
            </tr>
            <tr>
                <td> <?php echo $full_name2 ?> 
                    <form action=<?php echo $image_path2 ?>> 
                        <input type="Submit" value="Picture"><p><img scr="images/Movses.jpg"/> </p> 
                    </form>
                </td>
                <form>
                    <td> <input type="radio" name="status" value="student"checked >Student</td>
                    <td> <input type="radio" name="status" value="worker">Worker</td>
                </form>
                <td> <a href="https://www.youtube.com/watch?v=lGXHVlEklgQ"> Dumb and Dumber 2 </td>
            </tr>
        </body>
</html>
