<%-- 
    Document   : uploadcsv
    Created on : 29 Sep, 2017, 11:30:33 AM
    Author     : tcw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Food Bank CSV Upload</h1>
        
        <form action="UploadServlet" 
            method="post" enctype="multipart/form-data" >
            <input type="file" name="user" />
            <br />
            <input type="submit" name="Submit" value="Upload" />
        </form>
    </body>
</html>


