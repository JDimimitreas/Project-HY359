$(document).ready(function() {
	$("#login").submit(function() {
			$.ajax({
				url: 'LogIn',
				data: $("#login").serialize(),
				type: "GET",
				cache: false,
				success: function(response) {
                                    window.location.href = "welcome.jsp";
                                    console.log(response);;
				},
				error: function(error) {
                                    console.log(error);
				}
			});
	});
});