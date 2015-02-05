<?php
    //default args
    $tr1_td1    = "Name Surmane";
    $tr1_td2_3  = "status";
    $tr1_td4    = "link";
    $tr2_td2    = "student";
    $tr2_td3    = "employee";
            
    //replace values 
    if(isset($_GET['submit'])) {
        if(($_GET['tr1_td1'])!=""){
            $tr1_td1 = $_GET['tr1_td1'];
        }
        if(($_GET['tr1_td2_3'])!=""){
            $tr1_td2_3 = $_GET['tr1_td2_3'];
        }
        if(($_GET['tr1_td4'])!=""){
            $tr1_td4 = $_GET['tr1_td4'];
        }
        if(($_GET['tr2_td2'])!=""){
            $tr2_td2 = $_GET['tr2_td2'];
        }
        if(($_GET['tr2_td3'])!=""){
            $tr2_td3 = $_GET['tr2_td3'];
        }       
    }
?>

<?php include('header.php'); ?>
    <table>
        <tr>
            <td rowspan=2><?php echo $tr1_td1; ?></td>
            <td colspan=2><?php echo $tr1_td2_3; ?></td>
            <td rowspan=2><?php echo $tr1_td4; ?></td>
        </tr>
        <tr>
            <td><?php echo $tr2_td2; ?></td>
            <td><?php echo $tr2_td3; ?></td>
        </tr>
        <tr>
            <td>
                <span>Stepan</span>
                <a href="images/logo.png" class="pictureLink">Picture</a>
            </td>
        <form>
            <td><input type="radio" name="status" value="student"checked></td>
            <td><input type="radio" name="status" value="employee"></td>
        </form>
        <td><a href="http://google.com">google</a></td>
        </tr>
        <tr>
            <td>
                <span>Karen</span>
                <a href="images/instigate_logo.png" class="pictureLink">Picture</a>
            </td>
        <form>
            <td><input type="radio" name="status" value="student"></td>
            <td><input type="radio" name="status" value="employee"></td>
        </form>
        <td><a href="http://facebook.com">facebook</a></td>
        </tr>
        <tr>
            <td>
                <span>Eduard</span>
                <a href="images/instigatemobile_logo.png" class="pictureLink">Picture</a>
            </td>
        <form>
            <td><input type="radio" name="status" value="student"></td>
            <td><input type="radio" name="status" value="employee"></td>
        </form>
        <td><a href="http://dropbox.com">dropbox</a></td>
        </tr>
    </table>
<a href="settings.php">Settings</a>
<?php include('footer.php') ;?>