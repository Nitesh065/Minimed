
<html>
  <head>   <style><%@include file="/WEB-INF/css/style.css"  %></style> </head>
  <body>
      <form action="Data_Save" class="fr">
          <div class="container">
              <h3>Registration</h3>
              <p>Please fill the form to create an account</p>
              <pre>
                    <label for="user_id">User_id</label>
                    <input type="text" name="user_id" placeholder="Enter User_id" required>
                    <label for="uname">Username</label>
                    <input type="text" name="username" placeholder="Enter Usename" required>
                    <label for="emai">Email</label>
                    <input type="text" name="email" placeholder="Enter Email" required> 
                    <label for="password">Password</label>
                    <input type="password" name="password" placeholder="Enter password" required> 
                    <label for="Mobile">Mobile</label>
                    <input type="number"placeholder="Enter 10-digit-number" required> 
                      <button type="submit" class="rbtn">Register</button>
              </pre>
          </div>
          <p>Already have an account?</p><a href="Login.jsp">Login</a>
      </form>
      
  </body>
</html>

