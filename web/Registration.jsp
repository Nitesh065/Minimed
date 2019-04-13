
<html>
    <head>   <style><%@include file="/WEB-INF/css/style.css"  %></style> </head>
  <body>
        <div class="search-head"><a href="index.jsp">Back To Home</a></div>
      <h3 style="text-align: center">Registration</h3>
      <h2 style="text-align: left">Please fill the form to create an account</h2>
      
       <hr>
      <form action="Data_Save" class="lf">
          <div class="container">
              <pre>
                    <label for="user_id">User_id</label>
                    <input type="text" name="user_id" placeholder="Enter User_id" required>
                    <label for="uname">Username</label>
                    <input type="text" name="username" placeholder="Enter Usename" required>
                    <label for="emai">Email</label>
                    <input type="text" name="email" placeholder="Enter Email" required> 
                    <label for="password">Password</label>
                    <input type="password" name="password" placeholder="Enter password" required> 
                     <label for="Mobile_no">Mobile_no</label>
                    <input type="number" name="Mobile_no" placeholder="Enter 10_digit_no" required>
                      <button type="submit" class="rbtn">Register</button>
              </pre>
          </div>
     
      </form>
      <p style="font-size: 135%">Already have an account?</p><a style="font-size: 130%"href="Login.jsp">Login</a>
  </body>
</html>

