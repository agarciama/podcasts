<%--
  Created by IntelliJ IDEA.
  User: alvaro
  Date: 29/5/25
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Error – Podcast no encontrado</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #fafafa;
      color: #333;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 500px;
      margin: 80px auto;
      background: #fff;
      padding: 30px 40px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      border-radius: 8px;
      text-align: center;
    }
    h1 {
      color: #d32f2f;
      margin-bottom: 20px;
      font-size: 1.8em;
    }
    p {
      margin-bottom: 30px;
      font-size: 1.1em;
    }
    .btn {
      display: inline-block;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      font-size: 1em;
    }
    .btn:hover {
      background-color: #45A049;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>¡Podcast no encontrado!</h1>
  <p>No existe ningún creador con esa identificación en la base de datos.</p>
  <c:set var="hrefList" value="${mvc.uri('findPodcasts')}"/>
  <a href="${hrefList}" class="btn">Volver a la lista de podcasts</a>
</div>

</body>
</html>
