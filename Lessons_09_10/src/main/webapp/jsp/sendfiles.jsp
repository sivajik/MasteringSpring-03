<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>Please upload a file</h1>
        <form method="post" action="/lesson09/upload" enctype="multipart/form-data">
            <input type="file" name="txtfile"/><br>
            <input type="submit"/>
        </form>
</body>
</html>