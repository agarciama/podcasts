<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Creador</title>
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
        .form-container {
            width: 90%;
            max-width: 600px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
        form {
            display: grid;
            grid-template-columns: 1fr;
            grid-row-gap: 15px;
        }
        label {
            font-weight: bold;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="email"], textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            height: 100px;
        }
        .readonly {
            background-color: #e9e9e9;
        }
        .actions {
            text-align: right;
            margin-top: 20px;
        }
        .actions input[type="submit"] {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .actions input[type="submit"]:hover {
            background-color: #45A049;
        }

        .form-header {
            text-align: center;
            margin-bottom: 25px;
        }
        .form-header h1 {
            font-size: 2em;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .form-header p {
            font-size: 1.1em;
            color: #666;
            margin: 8px 0 0;
        }
        .delete-submit {
            background-color: #f44336 !important;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        .delete-submit:hover {
            background-color: #d32f2f !important;
        }

    </style>
</head>
<body>
<c:choose>
    <c:when test="${action == 'VIEW'}">
        <c:set var="readonly" value="readonly"/>
        <c:set var="submitLabel" value=""/>
        <c:set var="urlForm" value=""/>
        <c:set var="method" value=""/>
    </c:when>
    <c:when test="${action == 'UPDATE'}">
        <c:set var="readonly" value=""/>
        <c:set var="submitLabel" value="Editar"/>
        <c:set var="urlForm" value="${mvc.uri('updateCreadorById', {'id': creador.id})}"/>
        <c:set var="method" value="PUT"/>
    </c:when>
    <c:when test="${action == 'INSERT'}">
        <c:set var="readonly" value=""/>
        <c:set var="submitLabel" value="Añadir"/>
        <c:set var="urlForm" value="${mvc.uri('insertCreadorById')}"/>
        <c:set var="method" value="POST"/>
    </c:when>
    <c:when test="${action == 'DELETE'}">
        <c:set var="readonly" value="readonly"/>
        <c:set var="submitLabel" value="Eliminar"/>
        <c:set var="urlForm" value="${mvc.uri('removeCreadorById', {'id': creador.id})}"/>
        <c:set var="method" value="DELETE"/>
    </c:when>
    <c:otherwise>
        <c:set var="readonly" value="readonly"/>
        <c:set var="submitLabel" value=""/>
    </c:otherwise>
</c:choose>
<div class="form-header">
    <c:choose>
        <c:when test="${action == 'VIEW'}">
            <h1>¡Creador encontrado!</h1>
        </c:when>
        <c:when test="${action == 'UPDATE'}">
            <h1>Creador encontrado</h1>
            <p>Introduzca los datos a editar.</p>
        </c:when>
        <c:when test="${action == 'INSERT'}">
            <h1>Nuevo creador</h1>
            <p>Introduzca los datos para insertar un creador.</p>
        </c:when>
        <c:when test="${action == 'DELETE'}">
            <h1>Eliminar creador</h1>
            <p>Confirme que desea eliminar este creador.</p>
        </c:when>
        <c:otherwise>
            <h1>Formulario de creador</h1>
        </c:otherwise>
    </c:choose>
</div>
<div class="form-container">
    <form method="POST" action="${urlForm}" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="_method" value="${method}"/>
        <c:if test="${action != 'INSERT'}">
        <div>
            <label for="id">ID</label>
            <input type="text" id="id" name="id" value="${creador.id}" readonly class="readonly" />
        </div>
        </c:if>
        <div>
            <label for="nombre">Nombre</label>
            <input type="text" id="nombre" name="nombre" value="${creador.nombre}" ${readonly}/>
        </div>
        <div>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="${creador.email}" ${readonly}/>
        </div>
        <div>
            <label for="bio">Biografía</label>
            <textarea id="bio" name="bio" ${readonly}>${creador.bio}</textarea>
        </div>
        <c:if test="${action != 'VIEW'}">
            <div class="actions">
                <c:choose>
                    <c:when test="${action == 'DELETE'}">
                        <input type="submit"
                               value="${submitLabel}"
                               class="delete-submit"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit"
                               value="${submitLabel}"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:if>
    </form>
</div>
</body>
</html>