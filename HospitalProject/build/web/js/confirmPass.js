var password = document.getElementById('psw');
var confirm  = document.getElementById('confirm');

function confirmPass() {
    if (password.value == "") {
    	document.getElementById('pass-confirmed').innerHTML = "";
    	confirm.value = "";
    }else if (password.value !== "") {
	    if(password.value == confirm.value) {
	    	confirm.setCustomValidity('');
	        document.getElementById('pass-confirmed').innerHTML = '✓';
	    }else{
	    	confirm.setCustomValidity("Passwords Don't Match");
	        document.getElementById('pass-confirmed').innerHTML = '✖';
	    }
	}
}

function revealPassword() {
    if (password.type === "password" && confirm.type === "password") {
        password.type	= "text";
        confirm.type	= "text";
    } else {
        password.type	= "password";
        confirm.type	= "password";
    }
}

password.onchange = confirmPass;
confirm.onkeyup = confirmPass;