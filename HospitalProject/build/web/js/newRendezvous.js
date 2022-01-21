/* 
 * Plano: Pairnw ola ta randevouz molis kanei load h selida, pataei hmeromhnia o xrhsths, kai me to next eksafanizw
 *        to date attribute kai bgazw ena dropdown selector me tis diathesimes wres se afti thn hmeromhnia.
 *        Den einai optimal na pairnw ola ta randevouz molis kanei load h selida kai tha htan kalytero na 
 *        epairna ta randevouz gia to sygkekrimeno date omws sth bash den yparxei ksexwristo pedio gia 
 *        date kai time einai mazi se timestamp opote....
 * */

// TODO: afou parw ola ta dates mesw json sto window.onload,
//       pairnw to date tou xrhsth kai sto step 1 kanw style block to date attribute.
//       zwgrafizw to drop down selector me tis diathesimes wres based sto randevouz list;
//       kai apo kei synexizw
                


let randevouz_list; 

// First of all get all the existing rendezvous
window.onload = function () {
    // get ajax request all rendezvous

    console.log("Getting all Randevouz");
    $.ajax({
        type: 'GET',
        url: 'GetAllRandevouz',
        dataType: 'application\json',
        success: function() {
            // print the result
            console.log("Got all the rendevouz:\n");
        }, 
        error: function(error) {
            console.log("Failed to get All the Randevouz/n");
        }
    });
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