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
    // html_list.innerHTML += "<div><input type='text' id='doc_id' name='doc_id' value='"+ response[i].doctor_id +"'>" + 
    // "<button id='del_btn'>Delete</button>" + 
    // "<button id='verify_btn'>Verify</button></div><br>"
    // html_list.innerHTML += "<div>"
    // +"<div>Doc_Id: </div>"
    // +"<div id='doc_id'>"+ response[i].doctor_id +"</div> <div>Doc Username: </div> <div id='doc_username'>"+ response[i].username +"</div> <div>Certified: </div> <div id='certified'>"+ 
    // isCertified(response[i].certified) +"</div>"
    // +"<button id='del_btn'>Delete</button>"
    // +"<button id='verify_btn'>Verify</button>"
    // + "</div>";

    html_list.innerHTML += "<div>"
    +"Doc_Id<input type='text' id='doc_id' name='doc_id' value='"+ response[i].doctor_id +"' size='3'>"
    +"Doc_username<input type='text' id='doc_username' name='doc_username' size='10' value='"+ response[i].username +"'>"
    +"Certified:" + isCertified(response[i].certified)
    +" <button id='del_btn' onclick='deleteDoctor()'>Delete</button>"
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