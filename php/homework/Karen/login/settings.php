<?php 
include 'header.php'; 
include 'function.php';
?>
<script src="js/functions.js"></script>
<?php 
    $login=$_COOKIE['login'];
    $tmpArray=$_POST;
    $jsAr = getJsonFile($file);
    $pageArr = $jsAr->$_COOKIE['login'];
    $tmpPicture = $pageArr->pictures;
    
    if(isset($_FILES['name'])){
        $uploads_dir = 'uploads';
        $tmp_name = $_FILES["pictures"]["tmp_name"];
        $name = $_FILES["pictures"]["name"];
        $name = $login . substr($name, strpos($name, '.'));
        move_uploaded_file($tmp_name, "$uploads_dir/$name");
        $tmpArray["pictures"]="$uploads_dir/$name";
    }else{
        $tmpArray['pictures']=$tmpPicture;
    }
    if (($pageArr->sex=='male')&&($tmpArray['pictures']=="uploads/famale.jpg")){
        $tmpArray['pictures'] = "uploads/male.jpg";
    }elseif (($pageArr->sex=='famale')&&($tmpArray['pictures']=="uploads/male.jpg")){
        $tmpArray['pictures'] = "uploads/famale.jpg";
    }
    if(isset($_POST['submit'])){
        $jsAr->$_COOKIE['login']=$tmpArray;
        updateDB($file,$jsAr);   
        header("Location: index.php");
    }
   
?>
<div class="form-container"id="form-container" >
    <form id="registerform" action="<?php echo $_SERVER['PHP_SELF']; ?>" onsubmit="//updateSettings();" method="post" enctype="multipart/form-data">
        <div class='input-text required'>
            <label>Change profil picture</label>
            <input type="file" name="pictures" id="file" value="Add photo*"/>
        </div>
        <div class='input-text required'>
            <input type="text" name="name" id="name" placeholder="Name*" value="<?php echo $pageArr->name; ?>"/>
            <p class="error hidden">Invalid Name! Check that name does not contain special symbols(e.g. %, $, #. @ etc.)</p>
            <p class="error hidden">This field can not be empty</p>
        </div>
        <div class='input-text required'>
            <input type="text" name="lastname" id="lastname" placeholder="Last name*" value="<?php echo $pageArr->lastname; ?>"/>
            <p class="error hidden">Invalid Last Name! Check that name does not contain special symbols(e.g. %, $, #. @ etc.)</p>
            <p class="error hidden">This field can not be empty</p>
        </div>
        <div class='input-text required'>
            <input type="text" name="email" id="email" placeholder="Email*" value="<?php echo $pageArr->email; ?>"/>
            <p class="error hidden">Invalid Email! Check the format of the email, input value should be of email format (e.g. user@example.com)</p>
            <p class="error hidden">This field can not be empty</p>
        </div>
        <div class='input-text required'>
            <input type="password" name="password" id="password" placeholder="Password*"  value="<?php echo $pageArr->password; ?>"/>
            <p class="error hidden">Invalid Name! Password should contain at least one digit, at least one lower case, at least one upper case, at least 6 from the mentioned characters</p>
            <p class="error hidden">This field can not be empty</p>
        </div>
        <div class="selects no-required">
            <div class='input-select'>
                <label>Year</label>
                <select name="year" id="year">
                <?php 
                    for ($i=1900;$i<=date("Y");$i++){
                        if($i==$pageArr->year){
                            echo "<option selected>$i</option>";
                        }else{
                            echo "<option>$i</option>";                                
                        }
                    }
                ?>
                </select>
            </div>
            <div class='input-select'>
                <label>Month</label>
                <select name="month" id="month" >
                    <?php 
                        $monts=array('January','February','March','April','May','June','July','August','September','October','November','December');
                        for ($i=0;$i<count($monts);$i++){
                            if($monts[$i]==$pageArr->month){
                                echo "<option selected>$monts[$i]</option>";
                            }else{
                                echo "<option>$monts[$i]</option>";                                
                            }
                        }
                    ?>
                </select>
            </div>
            <div class='input-select'>
                <label>Day</label>
                <select name="day" id="day" onchange="updateAge()"></select>
            </div>
        </div>
        <div class='input-text no-required'>
            <label>Age</label>
            <input type="text" name="age" id="age" placeholder="Age" disabled="disabled"/>
        </div>
        <div class="input-radios no-required">
            <div class='input-radio'>                
                <label>Male</label>
                <input type="radio" name="sex" id="male" value="male" <?php if ($pageArr->sex=='male'){echo "checked";} ?>/>
            </div>
            <div class='input-radio'>
                <label>Female</label>
                <input type="radio" name="sex" id="female" value="famale" <?php if ($pageArr->sex=='famale'){echo "checked";} ?>/>
            </div>
        </div>
        
        <!--Submit-->
        <div class='input-submit'>
            <input type="submit" name="submit" id="submit" value="Save changes"/>
        </div>
    </form>
</div>
<?php include 'footer.php'; ?>
