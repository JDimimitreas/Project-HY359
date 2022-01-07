function checkStrongPass() {
    var password = document.getElementById('psw').value;

    var charOccur  = Array(password.length).fill(0);
    var maxOccur = 0;
    var uniqueChar = 0;

    var countNum = 0;


    for(var i = 0; i<password.length ;i++) {
        if(parseInt(password.charAt(i)) >= 0 && parseInt(password.charAt(i)) <= 9)  countNum++;
    }

    for(var i = 0; i<password.length ;i++) {
        for(var j = 0; j<password.length ;j++) {
            if(password.charAt(i) === password.charAt(j))
                charOccur[i]++;
        }
        if(charOccur[i] === 1)
            uniqueChar++;
        if(charOccur[i] > maxOccur)
            maxOccur = charOccur[i];
    }

    if(countNum >= password.length/2) {
        document.getElementById('pass-strength').innerHTML = 'weak';
    }else if(maxOccur >= password.length/2) {
        document.getElementById('pass-strength').innerHTML = 'weak';
    }else if(uniqueChar >= 8*password.length/10) {
        document.getElementById('pass-strength').innerHTML = 'strong';
    }else {
        document.getElementById('pass-strength').innerHTML = 'medium';
    }

    if(password === "")
        document.getElementById('pass-strength').innerHTML = 'Please enter a password for your account';
}