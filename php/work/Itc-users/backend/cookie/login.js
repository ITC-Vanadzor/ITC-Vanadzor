function check (log,passwd) {
  alert("aa");
  var mail=document.getElementById("email").value;
  var pass=document.getElementById("password").value;
  var chk = document.getElementById("checkbox").checked;
  if (mail==log &&  pass==passwd){
    alert(chk);
  }
  jQuery.ajax({
    type: "POST",
    url: 'adddel.php',
    data: {functionname: 'add', arguments: chk},
    success: function (data) {
      alert ("yes");
    }
  });
}

function logout() {
  alert("close");
  jQuery.ajax({
    type: "POST",
    url: 'adddel.php',
    data: {functionname:'del'},
    success: function (data) {
        alert (data);
      }
    
  });
}

