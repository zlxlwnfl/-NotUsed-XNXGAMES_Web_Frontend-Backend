function sendBoardWrite() {
	var boardType = $("#type").val();
	var boardSubType = $("#subType").val();
	var title = $('#title').val();
	var content = $('#content').val();
	var writer = $("#writer").val();
	var postType;
	
	if(boardType == "free" && boardSubType == "free") {
		postType= "free";
	}
	
	$.ajax({
		dataType: 'json',
	    type: 'POST',
		url: "http://localhost:8000/public/board/post/register",
		contentType :"application/json",
		data: JSON.stringify({
			boardType: boardType,
			boardSubType: boardSubType,
			title: title,
			content: content,
			writer: writer,
			postType: postType
		}),
	    success: function() {
	    	console.log("post register success");
	    },
	    error:function(request, status, error){
	    	console.log("code:"+request.status+"message:"+request.responseText+"error:"+error); 
	    }
	})
}

$(document).ready(function () {
	
	$("#register").on('click', function (event) {
		sendBoardWrite();
	});
	
});