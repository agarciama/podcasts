<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Podcast</title>
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
        <c:set var="urlForm" value="${mvc.uri('updatePodcastById', {'id': podcast.id})}"/>
        <c:set var="method" value="PUT"/>
    </c:when>
    <c:when test="${action == 'INSERT'}">
        <c:set var="readonly" value=""/>
        <c:set var="submitLabel" value="Añadir"/>
        <c:set var="urlForm" value="${mvc.uri('insertPodcast')}"/>
        <c:set var="method" value="POST"/>
    </c:when>
    <c:when test="${action == 'DELETE'}">
        <c:set var="readonly" value="readonly"/>
        <c:set var="submitLabel" value="Eliminar"/>
        <c:set var="urlForm" value="${mvc.uri('removePodcastById', {'id': podcast.id})}"/>
        <c:set var="method" value="DELETE"/>
    </c:when>
    <c:otherwise>
        <c:set var="readonly" value=""/>
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
<h1>Editar Podcast ${podcast.id}</h1>
<div class="form-container">
    <form method="POST"
          action="${urlForm}"
          enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="_method" value="${method}"/>

        <c:if test="${action != 'INSERT'}">
            <div>
                <label for="id">ID:</label>
                <input type="text"
                       id="id"
                       name="id"
                       value="${podcast.id}"
                       readonly/>
            </div>
        </c:if>

        <div>
            <label for="titulo">Título:</label>
            <input type="text"
                   id="titulo"
                   name="titulo"
                   value="${podcast.titulo}"
            ${readonly}
            />
        </div>

        <div>
            <label for="idCreador">ID Creador:</label>
            <input type="text"
                   id="idCreador"
                   name="idCreador"
                   value="${podcast.idCreador}"
            ${readonly}
            />
        </div>

        <div>
            <label for="descripcion">Descripción:</label><br/>
            <textarea id="descripcion"
                      name="descripcion"
                      rows="4"
                      cols="50"
            ${readonly}
            >${podcast.descripcion}</textarea>
        </div>

        <div>
            <label for="fechaInicio">Fecha inicio:</label>
            <input type="date"
                   id="fechaInicio"
                   name="fechaInicio"
                   value="${podcast.fechaInicio}" ${readonly}/>
        </div>

        <div>
            <label for="imagen">URL imagen:</label>
            <input type="text"
                   id="imagen"
                   name="imagen"
                   value="${podcast.imagen}" ${readonly}/>
        </div>

        <c:if test="${action != 'VIEW'}">
            <input type="submit" value="${submitLabel}"/>
        </c:if>
    </form>
</div>
</body>
</html>
