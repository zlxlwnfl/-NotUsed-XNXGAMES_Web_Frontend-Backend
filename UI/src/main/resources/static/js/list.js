var boardType, boardSubType, currentPageNum, amountData;

function getPostList() {
  $.ajax({
    dataType: "json",
    type: "GET",
    url: "http://localhost:8000/public/board/post/list",
    contentType: "application/json",
    data: JSON.stringify({
      boardType: boardType,
      boardSubType: boardSubType,
      currentPageNum: currentPageNum,
      amountData: amountData,
    }),
    xhrFields: {
      withCredentials: true,
    },
    success: function (postList) {
      var str = "";

      for (var i = 0; i < postList.length; i++) {
        str += "<tr>";
        str += "<td>" + postList[i].postId + "</td>";
        str += "<td>" + postList[i].postType + "</td>";
        str +=
          "<td><a href='/board/read?boardType=" +
          boardType +
          "&boardSubType=" +
          boardSubType +
          "&currentPageNum=" +
          currentPageNum +
          "&amountData=" +
          amountData +
          "&postId=" +
          postList[i].postId +
          "'>" +
          postList[i].title +
          "</a></td>";
        str += "<td>" + postList[i].writerId + "</td>";
        str += "<td>" + postList[i].heartCount + "</td>";
        str += "<td>" + postList[i].hits + "</td>";
        str += "<td>" + postList[i].regdate + "</td>";
        str += "</tr>";
      }

      $(".postList").html(str);
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

function getAmountPost() {
  $.ajax({
    dataType: "text",
    type: "GET",
    url: "http://localhost:8000/public/board/post/amount",
    data: {
      boardType: boardType,
      boardSubType: boardSubType,
    },
    xhrFields: {
      withCredentials: true,
    },
    success: function (amountPost) {
      createBoardPagination(amountPost);
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

function createBoardPagination(amountPost) {
  var startPage, endPage, realEndPage;

  endPage = Math.ceil(currentPageNum / 10) * 10;
  startPage = endPage - 9;
  realEndPage = Math.ceil(amountPost / 10);

  if (endPage > realEndPage) endPage = realEndPage;

  var str = "";

  str += '<nav><ul class="pagination">';

  if (startPage != 1) {
    str +=
      '<li class="paginateLi"><a href="' +
      (startPage - 1) +
      '" aria-label="Previous">';
    str += '<span aria-hidden="true">&laquo;</span>';
    str += "</a></li>";
  }

  for (var i = startPage; i <= endPage; i++) {
    str += '<li class="paginateLi"><a href="' + i + '">' + i + "</a></li>";
  }

  if (endPage != realEndPage) {
    str +=
      '<li class="paginateLi"><a href="' +
      (endPage + 1) +
      '" aria-label="Next">';
    str += '<span aria-hidden="true">&raquo;</span>';
    str += "</a></li>";
  }

  str += "</ul></nav>";

  $("#pagination").html(str);

  $(".paginateLi a").on("click", function (event) {
    event.preventDefault();

    var boardCriteriaFormGoList = $("#boardCriteriaFormGoList");

    boardCriteriaFormGoList
      .find("input[name='currentPageNum']")
      .val($(this).attr("href"));

    boardCriteriaFormGoList.submit();
  });
}

function goWrite() {
  var boardCriteriaFormGoWrite = $("#boardCriteriaFormGoWrite");

  boardCriteriaFormGoWrite.submit();
}

$(document).ready(function () {
  boardType = $("#boardType").val();
  boardSubType = $("#boardSubType").val();
  currentPageNum = $("#currentPageNum").val();
  amountData = $("#amountData").val();

  getPostList();
  getAmountPost();
});
