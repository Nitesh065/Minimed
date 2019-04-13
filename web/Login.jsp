
<html>
    <head>   <style><%@include file="/WEB-INF/css/style.css"  %></style> </head>
    <body>
        <div class="search-head">
             <a  href="index.jsp">Back to Home</a>
         </div>
        <hr>
        <form action="Verify_User" class="lf">
            <pre>
            <div class="user">
                               <label for="uname"><b>Username</b></label>
                               <input type="text" name="username" placeholder="Enter Username" autofocus required>
                               <label for="password"><b>Password</b></label>
                               <input type="password" name="Password" placeholder="Enter Password" autofocus required>
                               <label for="utype"><b>User Type</b></label>
               
                               <select name="utype"><option value="nitesh">Buyer</option>><option>Admin</option></select><n>
                
                                   <input  class="button" type="submit" value="Login">
                                   <label <input type="checkbox" name="save">Save Password</label>
                              <input type="checkbox" name="save">
            </div>
            </pre>
        </form>
        <a href="Registration.jsp" style="font-size:130%;text-decoration: none" >New User</a>
    </body>
</html>
