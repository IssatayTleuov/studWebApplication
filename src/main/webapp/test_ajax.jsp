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
<script type="text/javascript">
    var tbl = '';
    tbl +='<table class="table table-hover">'

    tbl +='<thead>';
      tbl +='<tr>';
      tbl +='<th>Student Name</th>';
      tbl +='<th>Marks</th>';
      tbl +='</tr>';
    tbl +='</thead>';

    tbl +=  '</tbody>';

</script>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url:"TestAjaxServlet",
            method: "GET",
            data: {operation: 'rating'},
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                let rat = $.parseJSON(data);
                $.each(rat, function(key, value) {
                    tbl += '<tr row_id="' + value.id + '">';
                    tbl += '<td><div class="row_data" edit_type="click" col_name="student_name">' + value.name + '</div></td>'
                    tbl += '<td><div class="row_data" edit_type="click" col_name="mark">' + value.mark + '</div></td>'

                    tbl +='<td>';

                    tbl +='<span class="btn_edit"> <a href="#" class="btn btn-link" ' + value.id +'"> Edit</a> | </span>'

                    tbl +='<span class="btn_save"> <a href="#" class="btn btn-link" ' + value.id +'"> Save</a> | </span>'
                    tbl +='<span class="btn_cancel"> <a href="#" class="btn btn-link" ' + value.id +'"> Cancel</a> | </span>'

                    tbl += '</td>';

                    tbl += '</tr>';

                });
            }
        })
    })
</script>
<script>
    tbl += '</tbody>';

    tbl += '</table>'
</script>
</body>
</html>
