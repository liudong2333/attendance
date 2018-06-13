<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<table border="1" align="left">
		<tr>
		<td>姓名</td>
		<td>加班时间(分钟)</td>
		<td>加班时间(换算小时)</td>
		<td>未打卡天数</td>
		<td>迟到天数</td>
		<td>早退天数</td>
		<td>上班未打卡天数</td>
		<td>下班未打卡天数</td>
		<td>集中开发天数</td>
		</tr>
		<c:forEach items="${list_so }" var="so" >
		<!-- 设计个格式吧... -->
		<tr>
		<td>${so.name}</td>
		<td>${so.totaltimeminutes}分钟</td> 
		<td>${so.totaltimehours}小时</td>
		<td>${so.weidaka}天</td>
		<td>${so.chidao}天</td>
		<td>${so.zaotui}天</td>
		<td>${so.shangbanweidaka}天</td>
		<td>${so.xiabanweidaka}天</td>
		<td>${so.jizhongkaifa}天</td>
		</tr>
		</c:forEach>
		${yymm }月份，全部人员加班时间总和:${monthTotalMinutes }分钟，即${monthTotalHours }小时	
		</table>
		
			
	
		
		
</body>
</html>