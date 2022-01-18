$(document).ready(function () {
    $("#logInForm").submit(function(event) {

        console.log("Im in logIn");
         
        event.preventDefault();
        let data = $("#logInForm").serialize()
        $.ajax({
            url: "LogIn",
            data: "data",
            method: 'POST',
            dataType: 'application/json',
            contentType: 'application/json',
            success: function (response) {
                alert("Successful logIn attempt!!\nWelcome, " + response.username);
            },
            error: function(e) {
                alert("Unsuccessful LogIn attempt..");
            } 
        });
    });
});