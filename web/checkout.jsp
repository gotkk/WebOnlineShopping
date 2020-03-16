<%-- 
    Document   : checkout
    Created on : May 9, 2019, 9:50:17 AM
    Author     : KRuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
    </head>
    <body>
    <center>
        <h1>Your Order is confirmed!</h1>
        <h1>
            <%
                out.print("The ToTal amount is $");
                out.print(session.getAttribute("sum"));
            %>
        </h1>
    </center>
</body>
</html>
