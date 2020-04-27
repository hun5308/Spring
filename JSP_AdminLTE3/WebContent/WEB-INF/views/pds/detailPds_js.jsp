<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	
	var formObj = $("form[role='form']");

	$("#modifyBtn").on('click',function(){
		//alert('modify btn click');
		formObj.attr("action","modifyForm.do");
		formObj.submit();
	});
	
	$("#removeBtn").on("click", function(){
		var answer = confirm("정말 삭제하시겠습니까?");	
			formObj.attr("action", "remove.do");
			formObj.attr("method", "post");
			formObj.submit();
	});
	
	$("#listBtn").on("click", function(){
		window.opener.location.reload(true);
		window.close();
	});
</script>
