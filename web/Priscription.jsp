<html>
    <head><style><%@include file="/WEB-INF/css/style.css"  %></style> </head>
    <body>
        <div class="search-head"><a href="index.jsp">Back To Home</a></div>
        
        <form  action="SavePrescription" method="post" enctype="multipart/form-data">
            <hr>
            <pre>
            <label for="Address"><b>Address</b></label>
            <input style=left:40%;top:60%" type="text" name="Address" placeholder="Enter Address" autofocus required>
            <label for="Mobile"><b>Mobile</b></label>
            <input type="number" name="Mobile" placeholder="Enter 10_Digit no" autofocus required>
            <input style=" font-size: 120%;left: 20%;top: 60%;" type="file" name="img">
            <input class="button" type="submit" value="Save">
            </pre>
        </form>
    </body>
</html>