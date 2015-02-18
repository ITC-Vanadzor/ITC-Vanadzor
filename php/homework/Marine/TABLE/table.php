<!DOCTYPE html>
<html>
    <head>
        <style>
            table{
                text-align:center;
            }
        </style>
		<?php
			$name="NAME";
			$sname="SURNAME";
			$st="STATUS";
			$film="FILM";
			$stud="STUDENT";
			$em="EMPLOYEE";	
			$n_sn1="MARINE GRIGORYAN";
			$n_sn2="MOVSES KHACHATRYAN";
			$n_sn3="VAHAN LEVONYAN";
			$f1="Mail.ru";
			$f2="Yahoo.com";
echo $n_sn1;
		?>
    </head>
    <body>

        <table border="1" style="width:100%">
            <tr>
                <td rowspan="2"><?php echo $name,  $sname ?> </td>
                <td colspan="2"><?php echo $st ?></td>     
                <td rowspan="2"><?php echo $film ?></td>
            </tr>
            <tr>
                <td><?php echo $stud ?></td>
                <td><?php echo $em ?></td>     
            </tr>
            <tr>
                <form>
                    <td><?php echo $n_sn1 ?><form> <input type="Submit" value="Picture"><p><img scr="images/Marine.jpg"/> </p> </form></td>  
                    <td><input type="radio" name="status" value="student"/></td>      
                    <td><input type="radio" name="status" value="employee"/></td>
                    <td><a href="https://mail.ru/"><?php echo $f1 ?></a></td>
                </form>
            </tr>
            <tr>
                <form>
<<<<<<< HEAD
                    <td><?php echo $n_sn2 ?><form> <input type="Submit" value="Picture"><p><img scr="images/Mos.jpg"/> </p> </form></td>
=======
                    <td><?php echo $n_sn1?><form> <input type="Submit" value="Picture"><p><img scr="images/Mos.jpg"/> </p> </form></td>
>>>>>>> 7d73f4deca68e80afe44c85116656ca65d3c993c
                    <td><input type="radio" name="status" value="student"/></td>      
                    <td><input type="radio" name="status" value="employee"/></td>
                    <td><a href="https://mail.ru/"><?php echo $f1 ?></a></td>
                </form>
            </tr>
            <tr>
                <form>
<<<<<<< HEAD
                    <td><?php echo $n_sn3 ?><form> <input type="Submit" value="Picture"><p><img scr="images/Vahan.jpg"/> </p> </form></td>
=======
                    <td><?php echo $n_sn1?><form> <input type="Submit" value="Picture"><p><img scr="images/Vahan.jpg"/> </p> </form></td>
>>>>>>> 7d73f4deca68e80afe44c85116656ca65d3c993c
                    <td><input type="radio" name="status" value="student"/></td>      
                    <td><input type="radio" name="status" value="employee"/></td>
                    <td><a href="https://www.yahoo.com/"><?php echo $f2 ?></a></td>
                </form>
            </tr>
        </table>
    </body>
</html>

