// Get All Doctors 
function getDocList(){
    console.log("getDocList()");

   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
//        document.getElementById("demo").innerHTML = this.responseText;
        let response = JSON.parse(this.responseText);
        console.log("Successful requestoooo\n" + response[0].doctor_id);
        showDoctorsList(response);
       }
       else{
           console.log("Nothing");
       }
     };
   xhttp.open("GET", "getDocList");
   xhttp.send();
}

function showDoctorsList(response){ 
  let html_list = document.getElementById("doc_list");
  
  for(let i=0; i < response.length; i++){
    html_list.innerHTML += "<div>"
    +"Doc_Id<input type='text' id='doc_id' name='doc_id' value='"+ response[i].doctor_id +"' size='3'>"
    +"Doc_username<input type='text' id='doc_username' name='doc_username' size='10' value='"+ response[i].username +"'>"
    +"Certified:" + isCertified(response[i].certified)
    +" <button id='del_btn' onclick='deleteDoctor("+ response[i].doctor_id +")'>Delete</button>"
    +"<button id='certify_btn' onclick='certifyDoctor()'>certify</button>"
    +"</div><br>"
    
    console.log(isCertified(response[i]));
  }
}

function isCertified(response){
  if(response === 1){
    return 'Yes';
  } else if(response === 0){
    return 'No';
  }
}

function deleteDoctor(doctor_id){
  console.log("Deleting doctor with id:" + doctor_id);
    
    var data = {
        "doctor_id": doctor_id
    };
    
    
    console.log(JSON.stringify(data));
    
    $.ajax({
       type: 'POST',
       url: 'DeleteDoctor',
       data: "doctor_id=" + doctor_id,
       success: function(success) {
           alert("DeleteDoctor Successful id: " +doctor_id);
       },
       error: function(e) {
           console.log("Couldnt delete Doctor with id:" + doctor_id);
       }
    });
}