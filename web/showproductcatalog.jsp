<%-- 
    Document   : showproductcatalog
    Created on : May 7, 2019, 9:51:02 PM
    Author     : KRuser
--%>

<%@page import="model.Products"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
        <style>
            table {
                border-collapse: collapse;
                width: 70%;
            }
            th, td {
                text-align: center;
                padding: 8px;
                font-size: 16px;
            }
            tr:nth-child(even){background-color: #f2f2f2}
            th{
                color: white;
                background-color:#0303c4;
            }
            .input{
                width: 100%;
            }
            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 12px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                -webkit-transition-duration: 0.4s; /* Safari */
                transition-duration: 0.4s;
                cursor: pointer;
            }
            .button1 {
                background-color: #ffae00;
                color: black;
                border: 2px solid #0303c4;
                border-radius: 20px;
            }
            .button1:hover {
                background-color: #0303c4;
                color: white;
            }

            input[type=text] {
                width: 100%;
                padding: 10px 16px;
                margin: 4px 0;
                box-sizing: border-box;
                border: 3px solid #ccc;
                -webkit-transition: 0.5s;
                transition: 0.5s;
                outline: none;
                border-radius: 20px;
            }

            input[type=text]:focus {
                border: 3px solid #555;
            }

        </style>
    </head>
    <body>
    <center>
        <h1>DVD Catalog</h1>
        <table border="1">
            <tr class="headCatalog">
                <th>DVD Names</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>AddCart</th>
            </tr>
            <%
                List<Products> proList = (List<Products>) request.getAttribute("proList");
                Iterator<Products> itr = proList.iterator();
                Products pro = null;
                pro = itr.next();
                out.println("<tr>");
            %>
            <form name="addForm" action="AddCart" method="POST">
                <%
                    out.println("<td>" + pro.getMovie() + "</td>");
                    out.println("<td>" + pro.getRating() + "</td>");
                    out.println("<td>" + pro.getYearcreate() + "</td>");
                    out.println("<td>" + pro.getPrice() + "</td>");
                %>
                <%="<td>"%>
                <input type="text" name="quantity" value="" size="10" />
                <%="</td>"%>
                <%="<td>"%>
                <input type="submit" value="AddToCart" name="addCart1" class="input button button1"/>
                <%="</td>"%>
            </form>
            <%
                out.println("</tr>");
                pro = itr.next();
                out.println("<tr>");
            %>
            <form name="addForm" action="AddCart" method="POST">
                <%
                    out.println("<td>" + pro.getMovie() + "</td>");
                    out.println("<td>" + pro.getRating() + "</td>");
                    out.println("<td>" + pro.getYearcreate() + "</td>");
                    out.println("<td>" + pro.getPrice() + "</td>");
                %>
                <%="<td>"%>
                <input type="text" name="quantity" value="" size="10" />
                <%="</td>"%>
                <%="<td>"%>
                <input type="submit" value="AddToCart" name="addCart2" class="input button button1" />
                <%="</td>"%>
            </form>
            <%
                out.println("</tr>");
                pro = itr.next();
                out.println("<tr>");
            %>
            <form name="addForm" action="AddCart" method="POST">
                <%
                    out.println("<td>" + pro.getMovie() + "</td>");
                    out.println("<td>" + pro.getRating() + "</td>");
                    out.println("<td>" + pro.getYearcreate() + "</td>");
                    out.println("<td>" + pro.getPrice() + "</td>");
                %>
                <%="<td>"%>
                <input type="text" name="quantity" value="" size="10" />
                <%="</td>"%>
                <%="<td>"%>
                <input type="submit" value="AddToCart" name="addCart3"class="input button button1" />
            </form
            <%="</td>"%>
            </form>
            <%
                out.println("</tr>");
            %>
        </table>
    </center>
    <br/><br/>    
    <hr/>
</body>
</html>
