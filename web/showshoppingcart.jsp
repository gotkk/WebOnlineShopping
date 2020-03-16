<%-- 
    Document   : showshoppintcart
    Created on : May 7, 2019, 11:01:04 PM
    Author     : KRuser
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Shoppingcart"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
        <style>
            .button2 {
                background-color: #0303c4; /* Green */
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                -webkit-transition-duration: 0.4s; /* Safari */
                transition-duration: 0.4s;
            }

            .button3:hover {
                box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
            }
        </style>
    </head>
    <body>
        <jsp:include page="showproductcatalog" flush="true"/>
    <center>
        <h1>Shopping Cart</h1>
        <table border="1">
            <tr>
                <th>DVD</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Remove</th>
            </tr>
            <jsp:include page="cartDetail.jsp" flush="true"/>   
        </table>
        <br /><br/>
        <form name="checkOutForm" action="CheckOut">
            <input type="submit" value="CheckOut" name="enterCheckOut" class="button2 button3"/>
        </form>
        <br /><br/>
    </center>
</body>
</html>
