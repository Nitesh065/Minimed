
<html>
    <head>
               <style><%@include file="/WEB-INF/css/style.css"  %></style>
    </head>
    <body style="background-image: url(images/back5.jpg);background-size:cover;">
         
        <div class="navbar">
            <div class="dropdown">
                <button class="dropbtn">MENU
                    <i class="fa fa-caret-down"></i>  
                </button>
                <div class="dropdown-content">
                    <a href="index.jsp">Home</a>
                    <a href="Explore.jsp">Explore</a>
                    <a href="Blogs.jsp">Doctor-Advise</a>
                    <a href="Login.jsp">Login</a>
                    
                </div>
            </div>
        </div>
        <hr>
        
  
  
        <form action="Login.jsp">
           
            <input  style="font-size: 20px; border: none" type="submit" value="UPLOAD PRESCRIPTION">
            
            
              <a class="dp" style="border: none;color: black;font-size: 20px" href="search.jsp">DON'T HAVE A PRESCRIPTION</a>
               
        </form>
    </body>
</html>
