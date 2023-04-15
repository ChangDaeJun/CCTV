<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<%@ page import="com.firstclass.childrenctv.ReportBoard.ReportBoardVO" %>
<head>
<link rel="stylesheet" href="/resources/css/reportboard_get_style.css">
</head>

<center>
    <h1>실종 아동 제보</h1>
        <table>
            <tr>
                <td>목격 시간</td>
                <td>${board.report_time }</td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><%= request.getParameter("user_name") %></td> <%--추후에 세션에서 userLoginID 받아오기 --%>
            </tr>
            <tr>
                <td>목격 위치</td>
                <td>${board.report_address}</td>
            </tr>
            <tr>
                <td>목격 내용</td>
                <td><textarea name="report_content" rows="50" cols="100" readonly="readonly">${board.report_content }</textarea></td>
            </tr>
        </table>
         <input type="button" value="목록" onclick="location.href='list?child_id=${board.child_id}'"/>
         
         <%-- 해당글의 작성자와 관리자만 수정 가능
         <%
    		HttpSession userSession = request.getSession();
    		UserVO userInfo = (UserVO) userSession.getAttribute("user");
    		ReportBoardVO reportboard = (ReportBoardVO) request.getAttribute("board");
    		if (userInfo != null) {
        		if (userInfo.getUser_id() == reportboard.getUser_id() || userInfo.getUser_grade.equalsIgnoreCase("admin")) {
			%>
			--%>
		<input type="button" value="수정" onclick="location.href='update?report_id=${board.report_id}'"/>
		<%--
		<%      
        		}
    		}
		%>
		--%>
         
         <%--
          <%
         	if(userInfo != null){
        		if(userInfo.getUser_grade().equalsIgnoreCase("admin")){
         %>
         --%>
         <input type="submit" value="글삭제" onclick="deletePost(${board.report_id})"/>
         <%--
         <%
        		}
         	}
         %>
         --%>
         
         
         

</center>

<script>
function deletePost(reportId) {
	  if (confirm("글을 삭제하시겠습니까?")) {
	    var xhr = new XMLHttpRequest();
	    xhr.open('POST', '/reportBoard/delete', true);
	    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
	    console.log("reportId는 뭘까요????????????????????????" +reportId);
	    var childId = "${board.child_id}";
	    xhr.onload = function () {
	      if (xhr.status === 200) {
	        alert('글이 삭제되었습니다.');
	        location.href = "list?child_id=" +${board.child_id};
	      } else {
	        alert('글 삭제에 실패하였습니다.');
	      }
	    };
	    xhr.send('report_id=' + reportId + '&child_id=' + childId); // report_id와 child_id 값을 key=value 형태로 전달
	  }
	}
  </script>


<%@ include file="../layout/footer.jsp"%>
