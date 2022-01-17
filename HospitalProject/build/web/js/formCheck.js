var allRequired = false;

function amkaCheck() {
    var amka = document.getElementById('amka').value;
    var birthday = document.getElementById('birthyear').value;

    // Check AMKA length
    if(amka.length < 11){
        amka.setCustomValidity("AMKA length is less than 11 characters");
        return false;
    } else if(amka.length > 11){
        amka.setCustomValidity("AMKA length is more than 11 characters");
        return false;
    }

    // Check day
    if(amka.charAt(0)  !== birthday.charAt(8) && amka.charAt(1) !== birthday.charAt(9)) {
        amka.setCustomValidity('Invalid amka (Day)');
        return false;
    }
    // Check month
    if(amka.charAt(2)  !== birthday.charAt(5) && amka.charAt(3) !== birthday.charAt(6)) {
        amka.setCustomValidity('Invalid amka (Month)');
        return false;
    }
    // Check year
    if(amka.charAt(4)  !== birthday.charAt(2) && amka.charAt(5) !== birthday.charAt(3)) {
        amka.setCustomValidity('Invalid amka (Year)');
        return false;
    }

    return true;
}

function termsBoxCheck() {
    var termsCheck = document.getElementById('termsCheck');
    if(termsCheck.checked == false){
        return false;
    } else if(termsCheck.checked == true){
        return true;
    }
}

// Function that executes when submit button is clicked 
function submitCheck() {
//    if(!amkaCheck() || !termsBoxCheck()) {
//        document.getElementById("btn").disabled = true;
//    }else {
//        document.getElementById("btn").disabled = false;
//    }
}