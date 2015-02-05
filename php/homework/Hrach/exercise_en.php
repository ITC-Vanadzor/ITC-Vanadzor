<?php
    $a="Hrach Mkrtchyan";
    $b="Eduard Hakobyan";
    $c="Hasmik Naslyan";
    $d="FName LName";
    $e="Employment";
    $f="Student";
    $g="Worker";
    $h="Favorite serial";
    $i="Full House";
    $j="Soy Gitano";
    $k="Interns";
?>

<table border="2" cellspacing="0"
    cellpadding="8" style="background-color:#cc0000; color:#ffffff">
    <tr >  
        <td rowspan="2"><?php echo $d ?></td>
        <td colspan="2"><?php echo $e ?></td>
        <td rowspan="2"><?php echo $h ?></td>
    </tr>
    <tr>
         <td><?php echo $f ?></td>
         <td><?php echo $g ?></td>
    </tr>
    <tr>
    <td><?php echo $a ?> <img src="https://scontent-a-fra.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/s720x720/10592633_817674194949734_6578777228316585940_n.jpg?oh=2bd373962da8a3479e7937b62e5ed0f7&oe=55263FF9" height="15"> <a href="https://scontent-a-fra.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/s720x720/10592633_817674194949734_6578777228316585940_n.jpg?oh=2bd373962da8a3479e7937b62e5ed0f7&oe=55263FF9"><button > © </button></a></td>
        <td><input type="radio" name="group1" > <br></td>
        <td><input type="radio" name="group1" > </td>
        <td> <a href="http://www.armeniatv.am/hy/tv-series/1411389369"><?php echo $i ?></a></td>
    </tr>
    <tr>
        <td><?php echo $b ?> <img src="https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xpa1/t31.0-8/10694392_825478390816998_3875722087065381560_o.jpg" height="15"> <a href="https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xpa1/t31.0-8/10694392_825478390816998_3875722087065381560_o.jpg"><button > © </button></a></td>
        <td><input type="radio" name="group3" ></td>
        <td><input type="radio" name="group3" ></td>
        <td> <a href="http://latino-serialo.ru/argentinskie_seriali_online/166-serial-cyganskaya-krov.html"><?php echo $j ?></a></td>
    </tr>
    <tr>
        <td><?php echo $c ?><img src="https://avatars2.githubusercontent.com/u/6958236?v=3&s=460" height="15"> <a href="https://avatars2.githubusercontent.com/u/6958236?v=3&s=460"><button > © </button></a></td>
        <td><input type="radio" name="group2" ></td>
        <td><input type="radio" name="group2" ></td>
        <td> <a href="http://interny.tnt-online.ru"><?php echo $k ?></a></td>
    </tr>
