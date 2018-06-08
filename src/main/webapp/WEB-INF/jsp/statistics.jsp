<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	statistics jsp!!!

	<hr>
	情况统计   
	<br>
	<br> ${attendance.ename }
	<hr>
    <br>加班时间:${totalOverTimeMinutes }分钟,即${totalOverTimeHours }个小时
    <br>
	<br> 未打卡天数:${so.weidaka } 
	  			<c:if test="${not empty so.daysweidaka }">
	  			     具体未打卡信息:
		           <c:forEach items="${so.daysweidaka }" var="weidaka">
						${weidaka }
		           </c:forEach>
		        </c:if> 
    <br>		          
	<br> 迟到天数:${so.chidao }
	
	        <c:if test="${not empty so.dayschidao }">
	                                    具体迟到信息:
	   			<c:forEach items="${so.dayschidao }" var="chidao">
	                ${chidao }
	            </c:forEach>
	        </c:if>  
	<br>         
	<br> 早退天数:${so.zaotui }
	   		<c:if test="${not empty so.dayszaotui  }" >
	   			具体早退信息:<c:forEach items="${so.dayszaotui }" var="zaotui">
	                ${zaotui }
	         </c:forEach>
	   		</c:if>
	<br>   		
	<br> 上班未打卡天数:${so.shangbanweidaka }
	  		<c:if test="${not empty so.daysshangbanweidaka  }" >
	   			具体上班未打卡信息:<c:forEach items="${so.daysshangbanweidaka }" var="shangbanweidaka">
	                ${shangbanweidaka }
	         </c:forEach>
	   		</c:if>
	<br>   		
	<br> 下班未打卡天数:${so.xiabanweidaka } 
	        <c:if test="${not empty so.daysxiabanweidaka  }" >
	   			具体下班未打卡信息:<c:forEach items="${so.daysxiabanweidaka }" var="xiabanweidaka">
	                ${xiabanweidaka }
	         </c:forEach>
	   		</c:if> 
	 <br>  			
	 <br> 集中开发天数 :${so.jizhongkaifa }
	        <c:if test="${not empty so.daysjizhongkaifa  }" >
	   			具体集中开发信息:<c:forEach items="${so.daysjizhongkaifa }" var="jizhongkaifa">
	                ${jizhongkaifa }
	         </c:forEach>
	   		</c:if>	
	 
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
				
			})
			
			function submitEmpno(){
				var empno = $("#empno").val();
				var time = $("#time").val();
				$("#ifrID").attr("src","getSingleAttendanceByEmpno.do?empno="+empno+"&time="+time);
			}

			function getDateyymm(){
			$("#div_time").attr("style","display:block");
			var empno = $("#empno").val();
			
			$.post("getDateyymm.do",{empno:empno},function(data){
				$("#time").empty();
				$(data).each(function(i,json){
					$("#time").append("<option value="+json+">"+json+"</option>");
				});
			});
			
		
	}
</script>
</html>