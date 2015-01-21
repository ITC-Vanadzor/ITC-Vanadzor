//Adding optiond elements in Select years
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
//Set days count, this function adding option elements in Select 
function addSelectDays(daysCount) {
	document.getElementById("day").innerHTML="";
  for(i=1;i<=daysCount;i++){
      var x = document.getElementById("day");
      var option = document.createElement("option");
      option.text = i;
      x.add(option);
  }
}
//Set month name, this function return count days for month
function getDaysCount(month){
	switch(month){
		case "February":
  		var curDate = new Date();
  		var curYear = curDate.getFullYear(); 
			if((curYear%4) == 0){
				return 29;
			}else{
				return 28;
			}
			break;
		case "April":
			return 30;
			break;
		case "June":
			return 30;
			break;
		case "September":
			return 30;
			break;
		case "November":
			return 30;
			break;
		default :
			return 31;
	}
}
function updateDays(){
	var month = document.getElementById("month").value;
	var daysCount = getDaysCount(month);
	addSelectDays(daysCount);
	updateAge();
}
function updateAge(){
	var birtDayStr = document.getElementById("month").value + " " + document.getElementById("day").value + "," + document.getElementById("year").value;
	var birtDayMs = Date.parse(birtDayStr);
	var birtDay = new Date(birtDayMs)
	var ageDifMs = Date.now() - birtDay;
	var ageDate = new Date(ageDifMs);
	var age=Math.abs(ageDate.getUTCFullYear() - 1970);
	document.getElementById("age").value = age;
}

//Validation
function resetErrorMessages(){
	document.getElementById("name");
	errors = document.getElementsByClassName("error");
	for(i = 0; i < errors.length; i++) {
		errors[i].classList.add("hidden");
	}
}
function validateForm(){
	validated = 0;
	resetErrorMessages();
	validField("name", /^[a-zA-Z ]+$/);
	validField("lastname", /^[a-zA-Z ]+$/);
	validField("email",/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/ );
	validField("password", /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$/);
	if(validated == 4){
		alert("Form successfuly sent");
		return true;
	}else{
		return false;
	}
}
//Validation Field
function validField(fieldId, pattern){
	var element = document.getElementById(fieldId);
	if(pattern.test(element.value)){
		validated++;
	}else{
		if(element.value == ""){
			element.parentNode.getElementsByClassName('error')[1].classList.remove('hidden');
		}else{
			element.parentNode.getElementsByClassName('error')[0].classList.remove('hidden');
		}
	}
}
