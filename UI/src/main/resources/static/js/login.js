/*
function tryLogin(memberId, password) {
	var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue = "${_csrf.token}";
	
	$.ajax({
		dataType: 'json',
	    type: 'POST',
		url: "/login",
		contentType :"application/x-www-form-urlencoded;charset=utf-8",
		data: {
			memberId : memberId,
			password : password
		},
	    beforeSend: function(xhr) {
	    	xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	    }
	});
};

$(document).ready(function () {

	$("#tryLogin").submit(function (event) {
		event.preventDefault();
		
		var memberId = $(this).find("input[id='id']").val();
		var password = $(this).find("input[id='password']").val();
		
		tryLogin(memberId, password);
	});
	
});
*/