// Get all the keys from document
var keys = document.querySelectorAll('#calculator span');
var operators = ['+', '-', 'x', '÷'];
var decimalAdded = false;

// Add onclick event to all the keys and perform operations
for(var i = 0; i < keys.length; i++) {
    keys[i].onclick = function(e) {
        // Get the input and button values
        var input = document.querySelector('.screen');
        var inputVal = input.innerHTML;
        var btnVal = this.innerHTML;
                                                    
        // Now, just append the key values (btnValue) to the input string and finally use javascript's eval function to get the result
        // If clear key is pressed, erase everything
        if(btnVal == 'C') {
            input.innerHTML = '';
            decimalAdded = false;
        }
        // If eval key is pressed, calculate and display the result
        else if(btnVal == '=') {
            var equation = inputVal;
            var lastChar = equation[equation.length - 1];

            // Replace all instances of x and ÷ with * and / respectively. This can be done easily using regex and the 'g' tag which will replace all instances of the matched character/substring
            equation = equation.replace(/x/g, '*').replace(/÷/g, '/');

            // Final thing left to do is checking the last character of the equation. If it's an operator or a decimal, remove it
            if(operators.indexOf(lastChar) > -1 || lastChar == '.')
                equation = equation.replace(/.$/, '');

            if(equation)
                input.innerHTML = eval(equation);

            decimalAdded = false;
        }
                                                                                                            
// Basic functionality of the calculator is complete. But there are some problems like 
// 1. No two operators should be added consecutively.
// 2. The equation shouldn't start from an operator except minus
// 3. not more than 1 decimal should be there in a number
                                                                            
// We'll fix these issues using some simple checks
                                                                    
// indexOf works only in IE9+
        else if(operators.indexOf(btnVal) > -1) {
            var lastChar = inputVal[inputVal.length - 1];
            if(inputVal != '' && operators.indexOf(lastChar) == -1) 
                input.innerHTML += btnVal;
            else if(inputVal == '' && btnVal == '-') 
                input.innerHTML += btnVal;
            if(operators.indexOf(lastChar) > -1 && inputVal.length > 1) {
                input.innerHTML = inputVal.replace(/.$/, btnVal);
            }
                                                                                               decimalAdded =false;
        }

        else if(btnVal == '.') {
            if(!decimalAdded) {
            input.innerHTML += btnVal;
            decimalAdded = true;
            }
        }
        else {
            input.innerHTML += btnVal;
        }
        
        e.preventDefault();
    }
}
