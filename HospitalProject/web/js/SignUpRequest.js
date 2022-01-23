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
	$("#form").submit(function(event) {
		event.preventDefault();
			$.ajax({
				url: 'SignUp',
				data: $("#form").serialize(),
				type: "POST",
				cache: false,
				success: function(response) {
                                    window.location.href = "welcome.jsp";
                                    console.log(response);;
				},
				error: function(error) {
                                    $("#main-container").html("User already exists, try again with a different user name.");
                                    console.log(error);
				}
			});
	});
});
