<%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/24/2021
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test teacher rating page, i hate it</title>
</head>
<body>
<form>
<div id="drop_objects" style="float: left">
    <select id="object"></select>
</div>
    <div id="drop_mark_types" style="float: left">
        <select id="mark_type">
            <option>Select type of mark</option>
        </select>
    </div>
</form>

<script type="text/javascript">
    $(document).ready(function () {
        $.get("TestAjax2Servlet", function (responseJson) {
            $.each(responseJson, function (key, value) {
                $('#object').append('<option value="' + value.id + '">' + value.name + '</option>')
            });
        });
    });
</script>

<script>
    function newXMLHttpRequest() {

        var xmlreq = false;

        if (window.XMLHttpRequest) {
            xmlreq = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            try {
                xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (ex) {
                try {
                    xmlreq = new ActiveXObject("Mircrosoft.XMLHTTP");
                } catch (ex) {

                }
            }
        }
        return xmlreq;
    }
</script>
</body>
</html>
