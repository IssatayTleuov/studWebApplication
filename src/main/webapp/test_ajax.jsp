<%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/19/2021
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test page</title>
</head>
<body>
<form style="float: left">
    <div class="input-field">
        <select id="objects">
            <option>Select object</option>
        </select>
    </div>
    <div class="input-field">
        <select id="mark-types">
            <option>Select type of mark</option>
        </select>
    </div>
</form>
    <script type="text/javascript">
        $(document).ready(function() {
        $.ajax({
            url: "TestAjaxServlet",
            method: "GET",
            data: {operation: 'objects'},
            success: function (data) {
                console.log(data);
                let obj = $.parseJSON(data);
                $.each(obj, function (key, value) {
                    $('#objects').append('<option value="'+ value.id +'">' + value.name + '</option>')
                });
                $('select').forSelect();
            },
            error: function () {
                $('#objects').append('<option>Objects unavailable</option>');
            },
            cache: false
        });
    });
</script>
</body>
</html>
