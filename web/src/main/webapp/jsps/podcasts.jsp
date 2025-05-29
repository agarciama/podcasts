<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lista de Podcasts</title>
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
      margin-bottom: 15px;
    }
    .table-container {
      width: 90%;
      max-width: 900px;
      margin: 0 auto 20px;
      background: #fff;
      padding: 20px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
      border-radius: 8px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      table-layout: fixed;
    }
    thead th {
      background-color: #4CAF50;
      color: white;
      text-transform: uppercase;
      font-size: 0.9em;
      padding: 12px;
    }
    tbody td {
      padding: 12px;
      border-bottom: 1px solid #ddd;
      vertical-align: top;
      word-wrap: break-word;
    }
    tbody tr:nth-child(even) {
      background-color: #f2f2f2;
    }
    tbody tr:hover {
      background-color: #e0f7fa;
    }
    .no-data {
      text-align: center;
      color: #666;
      font-style: italic;
      margin-top: 20px;
    }
    /* Enlaces para IDs */
    .link-button {
      color: #2196F3;
      text-decoration: none;
      font-weight: bold;
    }
    .link-button:hover {
      text-decoration: underline;
    }
    /* Ajuste de columnas */
    th:nth-child(1), td:nth-child(1) { width: 8%; }
    th:nth-child(2), td:nth-child(2) { width: 12%; }
    th:nth-child(3), td:nth-child(3) { width: 15%; }
    th:nth-child(4), td:nth-child(4) { width: 35%; }
    th:nth-child(5), td:nth-child(5) { width: 15%; }
    th:nth-child(6), td:nth-child(6) { width: 15%; }

    /* Ajuste de la columna de acciones */
    .actions-column {
      width: 140px;
      text-align: center;
      vertical-align: middle;
    }
    /* Contenedor flex para los botones */
    .action-buttons {
      display: flex;
      justify-content: center;
      gap: 8px;
    }
    /* Botón “Editar” */
    .edit-button {
      display: inline-block;
      padding: 6px 12px;
      background-color: #2196F3;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      font-size: 0.9em;
      transition: background-color .2s;
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
    .delete-button {
      display: inline-block;
      padding: 6px 12px;
      background-color: #f44336;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      font-size: 0.9em;
      transition: background-color .2s;
    }
    .delete-button:hover {
      background-color: #d32f2f;
    }
  </style>
</head>
<body>
<h1>Lista de Podcasts</h1>
<div class="table-container">
  <c:if test="${empty podcasts}">
    <p class="no-data">No hay podcasts disponibles.</p>
  </c:if>
  <c:if test="${not empty podcasts}">
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>ID Creador</th>
        <th>Título</th>
        <th>Descripción</th>
        <th>Imagen</th>
        <th>Fecha Inicio</th>
        <th class="actions-column">Acciones</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="podcast" items="${podcasts}">
        <c:set var="hrefPodcast" value="${mvc.uri('findPodcastById', {'id': podcast.id})}"/>
        <c:set var="hrefCreador" value="${mvc.uri('findCreadoresById', {'id': podcast.idCreador})}"/>
        <c:set var="hrefUpdatePodcast" value="${mvc.uri('formUpdatePodcastByid', {'id': podcast.id})}"/>
        <c:set var="hrefDeletePodcast"    value="${mvc.uri('formDeletePodcastByid', {'id': podcast.id})}"/>

        <tr>
          <td><a href="${hrefPodcast}" class="link-button">${podcast.id}</a></td>
          <td><a href="${hrefCreador}" class="link-button">${podcast.idCreador}</a></td>
          <td>${podcast.titulo}</td>
          <td>${podcast.descripcion}</td>
          <td>
            <a href="${podcast.imagen}" target="_blank" class="link-button">
              Ver imagen
            </a>
          </td>
          <td>${podcast.fechaInicio}</td>
          <td>
            <div class="action-buttons">
              <a href="${hrefUpdatePodcast}" class="edit-button">Editar</a>
              <a href="${hrefDeletePodcast}" class="delete-button">Eliminar</a>
            </div>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
</div>
<div style="text-align:center; margin-bottom:15px;">
  <c:set var="hrefAdd" value="${mvc.uri('formInsertPodcast')}"/>
  <a href="${hrefAdd}" class="add-button">Añadir Podcast</a>
</div>
</body>
</html>
