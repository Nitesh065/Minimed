<%-- 
    Document   : BuyProduct
    Created on : 8 Apr, 2019, 2:35:07 PM
    Author     : tushar
--%>


<%
    String id = (String) session.getAttribute("Pro_id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>

    <body>
        <form action="StoreProduct" method="post">
 
    <label for="Address"><b>Address</b></label>
    <input style=left:40%;top:60%" type="text" name="Address" placeholder="Enter Address" autofocus required/>
    <label for="Quantity">Quantity</label>
    <input type="number" name="Quantity" placeholder="Quantity" autofocus required/>
    <input type="submit" value="SUBMIT"/>
        </form>
    </body>
</html>
