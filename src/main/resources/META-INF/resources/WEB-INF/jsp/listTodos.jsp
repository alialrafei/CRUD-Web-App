<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <!DOCTYPE html>
    <html>

    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        
        <title>List Todo Page </title>



    </head>

    <body>
        <div class="container">

            <!-- <div>
                <h1>Welcome ${name} </h1>
            </div>
            <hr> -->
            <h2>Your todos</h2>
            <!-- <div>
                            Your Todos are: ${todos}

                        </div> -->
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done?</th>
                        <th></th>
                        <th></th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <!-- <td>${todo.id}</td> -->
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning"> Delete</a></td>
                            <td> <a href="update-todo?id=${todo.id}" class="btn btn-success"> Update</a></td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success"> Add Todo </a>

        </div>

    </body>

   
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src=" webjars/jquery/3.6.0/jquery.min.js"></script>

    </html>