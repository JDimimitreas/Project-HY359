function doctorCheck() {
    var typeDefault = document.getElementById('typeDefault');
    var typeDoctor  = document.getElementById('typeDoctor');
    var specialty   = document.getElementById('specialty');
    var doc_text    = document.getElementById('doc_text');
    var info = document.getElementById('docDiv');
    if(typeDoctor.checked === true){
        info.style.display = 'block';
        document.getElementById('address').placeholder = '*Office Address';
    } else if(typeDefault.checked === true){
        info.style.display = 'none';
        document.getElementById('address').placeholder = '*Address (Optional)';
    }
}