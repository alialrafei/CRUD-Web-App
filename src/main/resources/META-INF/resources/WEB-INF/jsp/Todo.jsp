<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <!DOCTYPE html>
    <html>

    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Add Todo Page </title>



    </head>

    <body>
        <div class="container">
            <h2>Enter Todo Details</h2>
            <form method="post">
                Description: <input type="text" name="description" required="required"/>
                <input type="submit" value="Add" class="btn btn-success"/>
            </form>
            
        </div>

    </body>

   
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src=" webjars/jquery/3.6.0/jquery.min.js"></script>

    </html>