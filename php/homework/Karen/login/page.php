<?php
include 'function.php';

$login = $_COOKIE['login'];
$pageArray = findLogin($login, $file);
//var_dump($pageArray);
?>
<div><a href="" onclick="deleteCookie('login');">Sign out</a></div>
<?php
if ($pageArray->pictures) {
    echo "<div><img src='" . $pageArray->pictures . "'  height='200' width='auto'  /></div>";
}
if ($pageArray->name) {
    echo "<b>Name : </b>" . $pageArray->name . "<br/>";
}
if ($pageArray->name) {
    echo "<b>Last name : </b>" . $pageArray->lastname . "<br/>";
}
if ($pageArray->email) {
    echo "<b>Email : </b>" . $pageArray->email . "<br/>";
}
if ($pageArray->sex) {
    echo "<b>Sex : </b>" . $pageArray->sex . "<br/>";
}
if (($pageArray->day) && ($pageArray->month) && ($pageArray->year)) {
    echo "<b>Birtday : </b>" . $pageArray->day . "-" . $pageArray->month . "-" . $pageArray->year . "<br/>";
}
?>

<div><a href="settings.php" >Settings</a></div>

<script>

function deleteCookie(c_name) {
    document.cookie = encodeURIComponent(c_name) + "=deleted; expires=" + new Date(0).toUTCString();
}
</script>