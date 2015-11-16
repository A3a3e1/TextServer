<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="com.a3a3el.mvc.model.StringHandler" %>

<html>
<body>

<%
	StringHandler stringHandler = new StringHandler();
	List<String> stringList = stringHandler.getFullStringList();
	pageContext.setAttribute("stringList", stringList);
%>

<ol type="1">
	<c:forEach items="${stringList}" var="list">
		<li>${list}</li>
	</c:forEach>
</ol>

<form method="post">
	Add line:<br>
	<input type="text" name="line">
	<br><br>
	<input type="submit" value="Add">
</form>

</body>
</html>