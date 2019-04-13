<html>
    <head>   <style><%@include file="/WEB-INF/css/style.css"  %></style> </head>

    <body>
        <div class="search-head" ><a href="admin.jsp">Back To Your Home</a></div>
        <h3 style=" font-size: 30px; text-align:center">MiniMed</h3>
        <h3 style="font-size: 25px">Add-Products</h3>
        <hr>
        <form action="Save_Product" method="post" enctype="multipart/form-data">   
            <pre>
                    <input type="file" name="image">
                    <label for="Product_id">Product-id</label>
                    <input type="number" name="Product_id" placeholder="Enter Product_id" autofocus required>
                    <label for="Product_name">Product-name</label>
          -         <input type="text" name="Product_name" placeholder="Enter Product_name" autofocus required>
                    <label for="Product_description">Product-description</label>
                    <input type="text" name="Product_description" placeholder="Enter Product_description" autofocus required>
                    <label for="Product_category">Category</label>
                    <select name="Product_Category">
                             <option>Diabetic Care</option>
                             <option>Medical Devices</option>
                             <option>Homeopathy</option>
                             <option>First Aid Kit</option> 
                             <option>Ayurvedic</option>
                             <option>Shop-by-Concern</option>       
                    </select>
                    <label for="Product_price">Product-price</label>
                    <input type="number" name="Product_price" placeholder="Enter Product_price" autofocus required>
                    <label for="Quantity">Quantity</label>
                    <input type="number" name="Quantity" placeholder="Quantity" autofocus required>
                    <input type="file" name="image">
                    <input class="button" style="width: 40%;top: 110%" type="submit" value="Save">
            </pre>
        </form>
    </body>
</html>
