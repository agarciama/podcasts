<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Inicio – Álvaro García Martín</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f7f7f7;
      color: #333;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 800px;
      margin: 60px auto;
      background: #fff;
      padding: 30px 40px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      border-radius: 8px;
    }
    h1 {
      text-align: center;
      color: #444;
      margin-bottom: 20px;
    }
    h2 {
      margin-top: 30px;
      color: #555;
      border-bottom: 1px solid #ddd;
      padding-bottom: 5px;
    }
    nav ul {
      list-style: none;
      padding: 0;
    }
    nav li {
      margin: 12px 0;
    }
    nav a {
      text-decoration: none;
      color: #2196F3;
      font-weight: bold;
      font-size: 1.05em;
    }
    nav a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Álvaro García Martín</h1>
  <nav>
    <h2>Creadores</h2>
    <ul>
      <li><a href="http://localhost:8080/web-1.0.0/web/creadores">Listar todos los creadores</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/form/creadores/insert">Formulario: Nuevo creador</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/creadores/CR1">Ver creador (ejemplo CR1)</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/form/creadores/update/CR1">Editar creador (ejemplo CR1)</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/form/creadores/delete/CR1">Eliminar creador (ejemplo CR1)</a></li>
    </ul>

    <h2>Podcasts</h2>
    <ul>
      <li><a href="http://localhost:8080/web-1.0.0/web/podcasts">Listar todos los podcasts</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/form/podcasts/insert">Formulario: Nuevo podcast</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/podcasts/PC1">Ver podcast (ejemplo PC1)</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/form/podcasts/update/PC1">Editar podcast (ejemplo PC1)</a></li>
      <li><a href="http://localhost:8080/web-1.0.0/web/form/podcasts/delete/PC1">Eliminar podcast (ejemplo PC1)</a></li>
    </ul>
  </nav>
</div>
</body>
</html>
