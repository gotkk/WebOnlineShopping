<%-- 
    Document   : cartDetail
    Created on : May 8, 2019, 1:08:00 PM
    Author     : KRuser
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Shoppingcart"%>
<%@page import="model.Products"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
    </head>
    <body>
            <%
                List<Shoppingcart> proList = (List<Shoppingcart>) session.getAttribute("cartLists");
                Iterator<Shoppingcart> itr = proList.iterator();
                Shoppingcart spc = null;
                while (itr.hasNext()) {
                    spc = itr.next();
                    out.println("<tr>");
                    
             %>
             <form name="removeForm" action="RemoveCart">
             <%
                    out.println("<td>" + spc.getMovie() + "</td>");
                    out.println("<td>" + spc.getRating() + "</td>");
                    out.println("<td>" + spc.getYearcreate() + "</td>");
                    out.println("<td>" + spc.getPrice() + "</td>");
                    out.println("<td>" + spc.getQuantity() + "</td>");
                    session.setAttribute("IDF", spc.getId());
            %>
            <%="<td>"%>
            <input type="hidden" value="<%=session.getAttribute("IDF")%>" name="removeID" />
            <input type="submit" value="Remove" name="remove" class="input button button1" />
            <%="</td>"%>
            </form>
            <%
                    out.println("</tr>");
                }
            %>
    </body>
</html>
