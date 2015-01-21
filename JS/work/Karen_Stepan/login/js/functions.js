function addSelectYears() {
  var curDate = new Date();
  var year = curDate.getFullYear(); 
  for(i=1900;i<=year;i++){
      var x = document.getElementById("year");
      var option = document.createElement("option");
      option.text = i;
      x.add(option);
  }
  addSelectDays(31);
}
function addSelectDays(daysCount) {
  for(i=1;i<=daysCount;i++){
      var x = document.getElementById("day");
      var option = document.createElement("option");
      option.text = i;
      x.add(option);
  }
}
