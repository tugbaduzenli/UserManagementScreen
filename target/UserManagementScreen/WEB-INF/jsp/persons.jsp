<%--
  Created by IntelliJ IDEA.
  User: tugba
  Date: 01.05.2015
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<c:url value="/records" var="recordsUrl"/>
<c:url value="/create" var="addUrl"/>
<c:url value="/update" var="editUrl"/>
<c:url value="/delete" var="deleteUrl"/>
<html>
<head>
    <link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/resources/css/style.css"/>'/>
    <script type='text/javascript' src='<c:url value="/resources/js/jquery-1.6.4.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="/resources/js/custom.js"/>'></script>

    <title>User Records</title>

    <script type='text/javascript'>
        $(function() {
            // init
            urlHolder.records = '${recordsUrl}';
            urlHolder.add = '${addUrl}';
            urlHolder.edit = '${editUrl}';
            urlHolder.del = '${deleteUrl}';
            loadTable();

            $('#newBtn').click(function() {
                toggleForms('new');
                toggleCrudButtons('hide');
            });

            $('#editBtn').click(function() {
                if (hasSelected()) {
                    toggleForms('edit');
                    toggleCrudButtons('hide');
                    fillEditForm();
                }
            });

            $('#reloadBtn').click(function() {
                loadTable();
            });
            $('#deleteBtn').click(function() {
                if (hasSelected()) {
                    submitDeleteRecord();
                }
            });

            $('#newForm').submit(function() {
                event.preventDefault();
                submitNewRecord();
            });

            $('#editForm').submit(function() {
                event.preventDefault();
                submitUpdateRecord();
            });
            $('#closeNewForm').click(function() {
                toggleForms('hide');
                toggleCrudButtons('show');
            });

            $('#closeEditForm').click(function() {
                toggleForms('hide');
                toggleCrudButtons('show');
            });
        });
    </script>
</head>
<body>
<h1 id='banner'>Record System</h1>
<hr/>

<table id='tableUsers'>
    <caption></caption>
    <thead>
    <tr>
        <th></th>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
    </tr>
    </thead>
</table>

<div id='controlBar'>
    <input type='button' value='New' id='newBtn' />
    <input type='button' value='Delete' id='deleteBtn' />
    <input type='button' value='Edit' id='editBtn' />
    <input type='button' value='Reload' id='reloadBtn' />
</div>

<div id='newForm'>
    <form>
        <fieldset>
            <legend>Create New Record</legend>
            <label for='newId'>Id</label><input type='text' id='newId'/><br/>
            <label for='newFirstName'>First Name</label><input type='text' id='newFirstName'/><br/>
            <label for='newLastName'>Last Name</label><input type='text' id='newLastName'/><br/>
            <label for='newPhone'>Last Name</label><input type='text' id='newPhone'/><br/>
        </fieldset>
        <input type='button' value='Close' id='closeNewForm' />
        <input type='submit' value='Submit'/>
    </form>
</div>

<div id='editForm'>
    <form>
        <fieldset>
            <legend>Edit Record</legend>
            <input type='hidden' id='editUsername'/>
            <label for='editFirstName'>First Name</label><input type='text' id='editFirstName'/><br/>
            <label for='editLastName'>Last Name</label><input type='text' id='editLastName'/><br/>
            <label for='editRole'>Role</label>
            <select id='editRole'>
                <option value='1'>Admin</option>
                <option value='2' selected='selected'>Regular</option>
            </select>
        </fieldset>
        <input type='button' value='Close' id='closeEditForm' />
        <input type='submit' value='Submit'/>
    </form>
</div>

</body>
</html>
