function whetherShowManage() {
  var writerId = $("#writerId").text();
  var readerId = $("#readerId").val();

  if (writerId == readerId) $("#manage").show();
}

function getCommentList() {
  var postId = $("#postId").val();
  var readerId = $("#readerId").val();

  $.ajax({
    dataType: "json",
    type: "GET",
    url: "http://localhost:8000/public/board/comment?postId=" + postId,
    xhrFields: {
      withCredentials: true,
    },
    success: function (commentList) {
      var str = "";

      for (var i = 0; i < commentList.length; i++) {
        str += "<div>";
        str +=
          "<h5 style='display: inline; padding-left: 10px'>" +
          commentList[i].writerId +
          "</h5>";

        if (readerId == commentList[i].writerId) {
          // 댓글 작성자가 읽고 있다면
          str += "<div class='btn-group pull-right'>";
          str +=
            "<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' style='border: 0; outline: 0; padding: 0px' aria-expanded='false'>";
          str +=
            "<span class='glyphicon glyphicon-option-vertical' aria-hidden='true'></span>";
          str += "</button>";
          str +=
            "<input type='hidden' value='" + commentList[i].commentId + "' />";
          str += "<ul class='dropdown-menu' role='menu'>";
          str += "<li><a class='updateComment'>수정</a></li>";
          str += "<li><a class='deleteComment'>삭제</a></li>";
          str += "</ul></div>";
        }

        str += "<br>";
        str +=
          "<h5 style='color: DarkGray; display: inline-block'>" +
          commentList[i].regdate +
          "</ht>";
        str +=
          "<h5 class='pull-right' style='margin-right: 5px; color: DarkGray'>" +
          commentList[i].heartCount +
          "</h5>";
        str +=
          "<p style='background-color: aliceblue; padding: 10px; margin-bottom: 10px'>" +
          commentList[i].content +
          "</p>";
        str += "</div>";
      }

      $(".commentList").html(str);

      $(".updateComment").on("click", function (event) {
        var commentId = $(this).parent().parent().prev().val();
        var str = "";

        str += "<div>";
        str +=
          '<textarea id="modifyCommentContent" class="form-control" rows="5"></textarea>';
        str +=
          '<div style="width: 100%; text-align: right; margin-bottom: 10px">';
        str +=
          '<button type="button" id="modifyCommentRegister" class="btn btn-primary">수정</button>';
        str += "</div></div>";

        $(this).parent().parent().parent().parent().html(str);

        $("#modifyCommentRegister").on("click", function (event) {
          var content = $("#modifyCommentContent").val();

          $.ajax({
            type: "PUT",
            url: "http://localhost:8000/public/board/comment",
            contentType: "application/json",
            data: JSON.stringify({
              commentId: commentId,
              content: content,
            }),
            success: function () {
              getCommentList();
            },
            error: function (request, status, error) {
              console.log(
                "code:" +
                  request.status +
                  "message:" +
                  request.responseText +
                  "error:" +
                  error
              );
            },
          });
        });
      });

      $(".deleteComment").on("click", function (event) {
        var commentId = $(this).parent().parent().prev().val();

        $(this).parent().parent().parent().parent().remove();

        $.ajax({
          type: "DELETE",
          url:
            "http://localhost:8000/public/board/comment?commentId=" + commentId,
          success: function () {
            getCommentList();
          },
          error: function (request, status, error) {
            console.log(
              "code:" +
                request.status +
                "message:" +
                request.responseText +
                "error:" +
                error
            );
          },
        });
      });
    },
    error: function (request, status, error) {
      console.log(
        "code:" +
          request.status +
          "message:" +
          request.responseText +
          "error:" +
          error
      );
    },
  });
}

function deletePost() {
  var boardType = $("#boardType").val();
  var boardSubType = $("#boardSubType").val();
  var postId = $("#postId").val();

  $.ajax({
    type: "DELETE",
    url: "http://localhost:8000/public/board/post?postId=" + postId,
    xhrFields: {
      withCredentials: true,
    },
    success: function () {
      location.href =
        "/board/list?boardType=" + boardType + "&boardSubType=" + boardSubType;
    },
    error: function (request, status, error) {
      console.log(
        "code:" +
          request.status +
          "message:" +
          request.responseText +
          "error:" +
          error
      );
    },
  });
}

function insertComment() {
  var postId = $("#postId").val();
  var writerId = $("#readerId").val();
  var content = $("#commentContent").val();

  if (content == "") return;

  $.ajax({
    type: "POST",
    url: "http://localhost:8000/public/board/comment",
    contentType: "application/json",
    traditional: true,
    data: JSON.stringify({
      postId: postId,
      writerId: writerId,
      content: content,
    }),
    xhrFields: {
      withCredentials: true,
    },
    success: function () {
      getCommentList();
    },
    error: function (request, status, error) {
      console.log(
        "code:" +
          request.status +
          "message:" +
          request.responseText +
          "error:" +
          error
      );
    },
  });
}

function goList() {
  var boardCriteriaFormGoList = $("#boardCriteriaFormGoList");

  boardCriteriaFormGoList.submit();
}

function goModify() {
  var boardCriteriaFormGoModify = $("#boardCriteriaFormGoModify");

  boardCriteriaFormGoModify.submit();
}

$(document).ready(function () {
  whetherShowManage();

  getCommentList();

  $("#delete").on("click", function (event) {
    deletePost();
  });

  $("#commentRegister").on("click", function (event) {
    insertComment();
  });
});
