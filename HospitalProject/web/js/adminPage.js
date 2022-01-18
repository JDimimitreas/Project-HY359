// Get All Doctors 
function getDocList(){
    console.log("getDocList()");

//    $.ajax({
//        url: "getDocList",
//        method: 'GET',
//        dataType: 'application/json',
//        contentType: 'application/json',
//        success: function (response) {
//            alert("This is what i got");
//        },
//        error: function(e) {
//            alert("Error, I got response: " );
//        } 
//    });


   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
//        document.getElementById("demo").innerHTML = this.responseText;
          console.log("Successful request!!");
       }
       else{
           console.log("Nothing");
       }
     };

   xhttp.open("GET", "getDocList");
   xhttp.send();

}