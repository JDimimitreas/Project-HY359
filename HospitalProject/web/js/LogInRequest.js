function createTableFromJSON(data) {
    var html = "<table><tr><th>Category</th><th>Value</th></tr>";
    for (const x in data) {
        var category = x;
        var value = data[x];
        html += "<tr><td>" + category + "</td><td>" + value + "</td></tr>";
    }
    html += "</table>";
    return html;
}

$(document).ready(function() {
	$("#login").submit(function(event) {
		//event.preventDefault();
			$.ajax({
				url: 'LogIn',
				data: $("#login").serialize(),
				type: "GET",
				cache: false,
				success: function(response) {

                                    window.location.href = "welcome.jsp";
                                    console.log(response);
				},
				error: function(error) {
                                    console.log("Error!");
                                    //document.getElementById('username').setCustomValidity("Invalid username or password!");
                                    console.log(error);
				}
			});
	});
});