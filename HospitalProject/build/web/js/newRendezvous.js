
let randevouz_list; 

// First of all get all the existing rendezvous
window.onload = function () {
    // get ajax request all rendezvous

    console.log("Getting all Randevouz");

    //vanilla JS
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState === 4 && this.status === 200) {
        var response = JSON.parse(this.responseText);
        //   console.log("window.onload: " + this.responseText);
          randevouz_list = response;
       }
     };
   xhttp.open("GET", "GetAllRandevouz");
   xhttp.send();
}

//Get current date
function getCurrentDate() {
    // set the today's date
}

// first step of rendezvous booking
function step1(){
    //get ajax all the rendezvous in that particular date
    let date = document.getElementById("date_data").value;
    
    
    $.ajax({
        type: 'POST',
        data: "date=" + date,
        url: 'getRandevouzOnDate',
        dataType: 'application/json',
        success: function() {
            console.log("Step1: We successfully got the rendezvous for that date");
        },
        error: function(){
            console.log("Step1: Failed");
        }

    });
}

function showRandevouz(response) {
    var html_ran_list = document.getElementById('randevouz_list');

    for( var i=0; i<response.length; i++ ) {
        html_ran_list.innerHTML += "<br> <div id='randevouz_"+ response[i].randevouz_id +"'> randevouz_id<input type='text' id='randevouz_id' value='"+ response[i].randevouz_id +"'> <br>" +
        "doctor_id<input type='text' id='doctor_id' value='"+ response[i].doctor_id +"'> <br>" +
        "user_id<input type='text' id='user_id' value='"+ response[i].user_id +"'> <br>" +
        "date_time<input type='text' id='date_time' value='"+ response[i].date_time +"'> <br>" +
        "price<input type='text' id='price' value='"+ response[i].price +"'> <br>" +
        "doc_info<input type='text' id='doctor_info' value='"+ response[i].doctor_info +"'> <br>" +
        "user_info<input type='text' id='user_info' value='"+ response[i].user_info +"'> <br>" +
        "status<input type='text' id='status' value='"+ response[i].status +"'>" +
        "<button onclick='updateRandevouz("+ response[i].randevouz_id +")'>Update</button>" +
        "<button onclick='deleteRandevouz("+ response[i].randevouz_id +")'>Delete</button> </div> <br>";
    }
}

function updateRandevouz(randevouz_id){
    console.log("updateRandevouz(" + randevouz_id +")");
    let div_name = 'randevouz_' + randevouz_id;
    let ran_div = document.getElementById(div_name);

    let doctor_info = ran_div.children[10].value;
    let user_id     = ran_div.children[4].value;
    let status      = ran_div.children[14].value;

    let data = 'randevouz_id='+randevouz_id +'&user_id='+user_id 
    +'&doctor_info='+doctor_info +'&status='+status;

    console.log(data);

    // Ajax request to update the randevouz
    $.ajax({
        type: 'POST',
        url: 'UpdateRandevouz',
        data: data,
        success: function(success) {
            console.log("updateRandevouz("+ randevouz_id +") was successful!!");
           //rebuild randevouz list
           //reset old list first
        //    $('#' + div_name).empty();
        //    getDocList();
        //    return true;
        },
        error: function(e) {
           console.log("Couldnt update randevouz with id:" + randevouz_id);
        //    return false;
        }
    });
}

function deleteRandevouz(randevouz_id){
    console.log("deleteRandevouz(" + randevouz_id + ")");
    let div_name = 'randevouz_' + randevouz_id;
    let ran_div = document.getElementById(div_name);

    // Ajax request to delete the randevouz
    $.ajax({
        type: 'POST',
        url: 'DeleteRandevouz',
        data: "randevouz_id=" + randevouz_id,
        success: function(success) {
            console.log("deleteRandevouz("+ randevouz_id +") was successful!!");
           //rebuild randevouz list
           //reset old list first
           $('#' + div_name).empty();
        //    getDocList();
        //    return true;
        },
        error: function(e) {
           console.log("Couldnt delete randevouz with id:" + randevouz_id);
        //    return false;
        }
    });

}

// Shows all the currently booked randevouz
function getAllRandevouz() {
    showRandevouz(randevouz_list);
    //The button shall be clicked once only
    document.getElementById("getAllRandevouzBtn").onclick = null;
}

function newRandevouz(){
    var doctor_id = document.getElementById('new_doctor_id').value;
    var user_id   = document.getElementById('new_user_id').value;
    var date      = document.getElementById('new_date').value;
    var hours     = document.getElementById('new_hours').value;
    var minutes   = document.getElementById('new_minutes').value;
    var price     = document.getElementById("new_price").value;
    var doctor_info = document.getElementById('new_doc_info').value;
    var status    = document.getElementById('new_status').value;
    var user_info = document.getElementById('new_user_info').value;

    var data = 'doctor_id=' + doctor_id + '&user_id=' + user_id + 
                '&date=' + date + '&hours=' + hours + '&minutes=' + minutes;

//    alert('Data: ' + data);

    
    let doctor = {
        doctor_id: doctor_id,
        user_id: user_id,
        date: date,
        hours: hours,
        minutes: minutes,
        price: price, 
        status: status,
        doctor_info: doctor_info,
        user_info: user_info
    };
    
//    let json_doc = JSON.parse(doctor);
    
    console.log( Object.values(doctor) );
    console.log("The json: " + JSON.stringify(doctor) );
    
    // now the request
    $.ajax({
       type: 'POST',
       url: 'NewRandevouz',
       data: JSON.stringify(doctor),
       contentType: 'application/json',
       dataType: 'text',
       success: function(succ) {
           console.log("NewRandevouz Request was successful!!");
           
           alert("NewRandevouz: " + succ);
           
       },
       error: function(e){
           console.log("NewRandevouz Request was unsuccessful...");
           let response = this.responseText;
           alert("NewRandevouz: " + e);
       }
    });
  
    

}