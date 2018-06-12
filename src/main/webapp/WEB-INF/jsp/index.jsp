<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<title>Insert title here</title>
</head>
<body>
		主页！！！<br>
		<!-- 先暂时只上传一个文件.....用ajax,提示上传文件成功 -->
		<!-- <form action="FileUpload.do" enctype="multipart/form-data" method="post">
		上传文件<input type="file" name="file">
		     <input type="submit" value="提交上传">
		</form> -->
		<hr>
		 <form id="test_ajax" enctype="multipart/form-data">
		上传文件<input type="file" name="file" id="file">
		</form>
		<input type="button" id="submit" value="提交上传">	
		<hr>
		查询实验 :个人单月查询<br>  
		  
		员工姓名:<select id="empno" onchange="getDateyymmByEmpno()"></select><br>
		<div id="div_time">
		时间:<select id="time"></select>
		</div>
		<a href="javascript:submitEmpno()">查询</a> 
		
		<hr>
		查询实验:时间单月查询<br>
		时间:<select id="queryByTime"></select><br>
		<a href="javascript:submitTime()">查询</a> 
		<hr>
		
		
		
		<!-- 下面写个div？下面这个div给查询用 -->
		<div id="box2">
		<!-- 下面这个iframe可以复用吧 -->
		<iframe id="ifrID" frameBorder="0" width="100%" scrolling="yes" height="450"> 
		
		 </iframe>
		</div>
		
		
</body>
<script type="text/javascript">
	$(function (){
		//页面加载函数
		//ajax,为下拉框加载数据
		$.post("getEnames.do",function(data){
			$("#empno").append("<option value=0>==请选择==</option>");
			$(data).each(function(i,json){
				$("#empno").append("<option value="+json.empno+">"+json.ename+"</option>");
			});
		});
		
		// 先将年月字段隐藏
		$("#div_time").attr("style","display:none");
		
		//按时间查询实验
		$.post("getDateyymm.do",function(data){
			$("#queryByTime").empty();
			$(data).each(function(i,json){
				$("#queryByTime").append("<option value="+json+">"+json+"</option>");
			});
		});
		
	})
	
	function submitEmpno(){
		var empno = $("#empno").val();
		var time = $("#time").val();
		$("#ifrID").attr("src","getSingleAttendanceByEmpno.do?empno="+empno+"&time="+time);
	}
	
	function submitTime(){
		var time=$("#queryByTime").val();
		$("#ifrID").attr("src","getAttendancesByTime.do?time="+time);
	}
	
	function getDateyymmByEmpno(){
		$("#div_time").attr("style","display:block");
		var empno = $("#empno").val();
		
		$.post("getDateyymmByEmpno.do",{empno:empno},function(data){
			$("#time").empty();
			$(data).each(function(i,json){
				$("#time").append("<option value="+json+">"+json+"</option>");
			});
		});
		
		
	}
	
	$("#submit").click(function(){
		var formData=new FormData();
		formData.append("file",$("#file")[0].files[0]);
		var url="FileUpload.do";
		$.ajax({
			url:url,
			type:"post",
			data:formData,
			processData:false, 
			contentType:false,
			success :function(data){
				alert("文件导入成功!!");
				window.location.href="index.do";
			},
			error:function(data){
				alert("文件导入失败!!");
			}
		});
	});
</script>
</html>