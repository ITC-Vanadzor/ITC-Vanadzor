function check (log,passwd) {
  var mail=document.getElementById("email").value;
  var pass=document.getElementById("password").value;
  var chk = document.getElementById("checkbox").checked;
  if (mail==log &&  pass==passwd){
    alert(chk);
  };
  jQuery.ajax({
    type: "POST",
    url: 'adddel.php',
    data: {functionname: 'add', argument: chk, 'pass':pass},
    success: function (data) {
      alert (data);
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

