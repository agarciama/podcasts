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
        .edit-button {
            display: inline-block;
            padding: 6px 12px;
            background-color: #2196F3;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 0.9em;
        }
        .edit-button:hover {
            background-color: #1976D2;
        }
        .add-button {
            display: inline-block;
            margin: 20px auto;
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 16px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 1em;
        }
        .add-button:hover {
            background-color: #43A047;
        }
        .actions-column {
            width: 120px;
            text-align: center;
        }

        .edit-button,
        .delete-button {
            padding: 6px 12px;
        }

        .action-buttons {
            display: flex;
            gap: 8px;
            justify-content: center;
        }

        .delete-button {
            display: inline-block;
            padding: 6px 12px;
            background-color: #f44336;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 0.9em;
        }
        .delete-button:hover {
            background-color: #d32f2f;
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
                <th class="actions-column">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="creador" items="${creadores}">

                <c:set var="hrefCreador" value="${mvc.uri('findCreadoresById', {'id': creador.id})}"/>
                <c:set var="hrefEditarCreador"    value="${mvc.uri('formUpdateCreadorByid', {'id': creador.id})}"/>
                <c:set var="hrefDeleteCreador"    value="${mvc.uri('formDeleteCreadorByid', {'id': creador.id})}"/>

                <tr>
                    <td><a href="${hrefCreador}">${creador.id}</a></td>
                    <td>${creador.nombre}</td>
                    <td>${creador.email}</td>
                    <td>${creador.bio}</td>
                    <td>
                        <div class="action-buttons">
                            <a href="${hrefEditarCreador}" class="edit-button">Editar</a>
                            <a href="${hrefDeleteCreador}"    class="delete-button">Eliminar</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div style="text-align:center; margin-bottom:15px;">
        <c:set var="hrefAdd" value="${mvc.uri('formInsertCreador')}"/>
        <a href="${hrefAdd}" class="add-button">Añadir Creador</a>
    </div>
</body>
</html>
