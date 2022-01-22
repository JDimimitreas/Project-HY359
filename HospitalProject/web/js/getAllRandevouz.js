function getAllRandevouz(){
    console.log('GetAllRandevouz\n');

    // $.ajax({
    //     type: "GET",
    //     url: "GetAllRandevouz",
    //     dataType: "application/json",
    //     success: function (response) {
    //         console.log("GetAllRandevouz was successfull");
    //     },
    //     error: function(error) {
    //         console.log('GetALlRandevouz failed');
    //     }
    // });

    //vanilla JS
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            var response = JSON.parse(this.responseText);
            showRandevouzList(response);
        }
    };
    xhttp.open('GET', 'GetAllRandevouz');
    xhttp.send();
}

function showRandevouzList(response) {
    var ran_list_html = document.getElementById('randevouz_list');
    
    for( var i=0; i<response.length; i++) {
        ran_list_html.innerHTML += "randevouz_id<input type='text' id='randevouz_id' value='" + response[i].randevouz_id + "'> <br>" +
        "doctor_id<input type='text' id='doctor_id' value='" + response[i].doctor_id + "'> <br>" +
        "user_id<input type='text' id='user_id' value='" + response[i].user_id + "'> <br>" +
        "date_time<input type='text' id='date_time' value='" + response[i].date_time + "'> <br>" +
        "price<input type='text' id='price' value='" + response[i].price + "'> <br>" +
        "doc_info<input type='text' id='doctor_info' value='" + response[i].doc_info + "'> <br>" +
        "user_info<input type='text' id='user_info' value='" + response[i].user_info + "'> <br>" +
        "status<input type='text' id='status' value='" + response[i].status + "'>" +
        "<button onclick='changeRandevouz()'>Change</button>" +
        "<button onclick='deleteRandevouz()'>Delete</button>";
    }
}



function changeRandevouz() {

}

function deleteRandevouz() {

}
