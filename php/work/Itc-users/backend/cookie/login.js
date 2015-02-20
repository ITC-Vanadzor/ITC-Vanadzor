function check (log,passwd) {
  var mail=document.getElementById("email").value;
  var pass=document.getElementById("password").value;
  var chk = document.getElementById("checkbox").checked;
  if (mail==log &&  pass==passwd){
    alert(chk);
  }
}    
