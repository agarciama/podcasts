<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Creadores</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            color: #333;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #444;
        }
        .table-container {
            width: 90%;
            max-width: 800px;
            margin: 0 auto;
            background: #fff;
            padding: 15px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        th, td {
            padding: 10px 12px;
            text-align: left;
        }
        thead th {
            background-color: #4CAF50;
            color: white;
            text-transform: uppercase;
            font-size: 0.9em;
        }
        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tbody tr:hover {
            background-color: #e0f7fa;
        }
        td {
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>
<h1>Lista de Creadores</h1>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Biografía</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="creador" items="${creadores}">
            <tr>
                <td>${creador.id}</td>
                <td>${creador.nombre}</td>
                <td>${creador.email}</td>
                <td>${creador.bio}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
