// Get All Doctors 
function getDocList(){
    console.log("getDocList()");

    $.ajax({
        url: "getDocList",
        method: 'GET',
        dataType: 'application/json',
        contentType: 'application/json',
        success: function (response) {
            alert("This is what i got");
        },
        error: function(e) {
            alert("Couldn't get DocList...");
        } 
    });
}