function idOverlapCheck(memberId) {
	var csrfHeaderName = $("meta[name='_csrf_header']").attr("content");
	var csrfTokenValue = $("meta[name='_csrf']").attr("content");
	
	console.log("try id:" + memberId);
	
	$.ajax({
		dataType: 'text',
	    type: 'POST',
		url: "/join/idCheck",
		contentType :"application/text; charset=utf-8",
		data: memberId,
	    beforeSend: function(xhr) {
	    	xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	    },
	    success: function(result) {
	    	console.log(result);
	    	
	    	var str = "";
	    	
	    	if(result == "true") {
	    		str += "<div class='alert alert-success' role='alert'>POSSIBLE ID</div>"
	    	}else {
	    		str += "<div class='alert alert-danger' role='alert'>OVERLAPED ID</div>"
	    	}
	    	
	    	$(".idCheckResult").html(str);
	    },
	    error:function(request, status, error){
	    	console.log("code:"+request.status+"message:"+request.responseText+"error:"+error); 
	    }
	})
}

function idValidCheck() {
	$('#id').on("blur", function() {
		var inputId = $(this).val();
		var regIdPattern = /^[a-zA-Z0-9]{3,10}$/;
		
		var isValid = regIdPattern.test(inputId);
		
		if(!isValid) {
			document.getElementById("id").value = "";
		}
	});
}

function passwordValidCheck() {
	$('#password').on("blur", function() {
		var inputPassword = $(this).val();
		var regPasswordPattern = /^[a-zA-Z0-9]{6,15}$/;
		
		var isValid = regPasswordPattern.test(inputPassword);
		
		if(!isValid) {
			document.getElementById("password").value = "";
		}
	});
}

function passwordEqualCheck() {
	$('#passwordCheck').on("blur", function() {
		var password = $('#password').val();
		var passwordCheck = $('#passwordCheck').val();
		
		if(password != passwordCheck) {
			document.getElementById("passwordCheck").value = "";
		}
	})
}

function birthdateValidCheck() {
	$('#birthdate').on("blur", function() {
		var inputBirthdate = $(this).val();
		var regDatePattern = /^[0-9]{8}$/;
		
		var isValid = regDatePattern.test(inputBirthdate);
		
		if(!isValid) {
			document.getElementById("birthdate").value = "";
		}

		// 날짜 유효성 체크 필요
	});
}

$(document).ready(function () {
	
	idValidCheck();
	passwordValidCheck();
	passwordEqualCheck();
	birthdateValidCheck();
	
	$("#idCheck").on('click', function (event) {
		var memberId = $('#id').val();
		
		if(memberId != "") {
			idOverlapCheck(memberId);
		}
	});
	
});