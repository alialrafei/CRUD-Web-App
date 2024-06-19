<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
    <html>

    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" >
        <title>Add Todo Page </title>



    </head>

    <body>
        <div class="container">
            <h2>Enter Todo Details</h2>
            <form:form method="post" modelAttribute="todo">
               <!-- description field  -->
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" name="description" required="required" path="description"/> <!-- front end validation -->
                    <form:errors  path="description" cssClass="text-warning"/>
                </fieldset>
                <!-- target date -->
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" name="targetDate" required="required" path="targetDate"/> <!-- front end validation -->
                    <form:errors  path="targetDate" cssClass="text-warning"/>
                </fieldset>
               
                <form:input type="hidden" name="id"  path="id"/>
                <form:input type="hidden" name="done"  path="done"/>
                <input type="submit" value="Add" class="btn btn-success"/>
            </form:form>
            
        </div>

    </body>

   
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
    </script>
    </html>