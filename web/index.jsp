
<html>
    <head>
        <style><%@include file="/WEB-INF/css/style.css"  %></style>

    </head>
    <body>
        <div class="navbar">
            <div class="dropdown">
                <button class="dropbtn">MENU
                    <i class="fa fa-caret-down"></i>  
                </button>
                <div class="dropdown-content">
                    <a href="index.jsp">Home</a>
                    <a href="#">Explore</a>
                    <a href="#">Doctor-Advise</a>
                    <a href="#">Cart</a>
                    <a href="Login.jsp">Login</a>
                </div>
            </div>
        </div>
        <hr>               
        <form action="SavePrescription" method="post" enctype="multipart/form-data">
            <input type="submit" value="UPLOAD PRESCRIPTION">
             <input type="file" name="img">
              <a class="dp" href="#">DON'T HAVE A PRESCRIPTION</a>         
        </form>
    </body>
</html>




