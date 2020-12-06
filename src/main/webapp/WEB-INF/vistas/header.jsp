<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>${titulo}</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link href="/proyecto-limpio-spring-master/css/style.css"
	rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/7459688133.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<script src="/proyecto-limpio-spring-master/js/sweetalert2.all.min.js"></script>
	
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

<meta name="google-signin-client_id" content="944559455733-1q39bf2aqu04q1v5h71jbsngidb1qoh1.apps.googleusercontent.com">

</head>
<body>

	<header class="container-footer bebas bg-dark mb-5">
		<nav class="navbar navbar-expand-lg navbar-dark">
			<a class="navbar-brand logo text-white"
				href="/proyecto-limpio-spring-master/home">LOGO</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link text-light"
						href="/proyecto-limpio-spring-master/home">Home</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						href="/proyecto-limpio-spring-master/restaurantes">Restaurantes</a>
					</li>
					<li class="nav-item"><a class="nav-link text-light"
						href="/proyecto-limpio-spring-master/usuarios">Usuarios</a></li>
				</ul>
			</div>
			<div>
				<c:if test="${empty nombreUsuario}">
					<a class="text-light text-decoration-none mr-2" href="/proyecto-limpio-spring-master/login">Ingresar</a>
					<a class="text-light text-decoration-none" href="/proyecto-limpio-spring-master/registrate">Registrarse</a>
				</c:if>
			</div>
			<div>
				<c:if test="${not empty nombreUsuario}">
					<p class="text-light bienvenido">${nombreUsuario} | </p>
				</c:if>
			</div>
			<div>
				<c:if test="${not empty nombreUsuario}">
					<a class="text-light logout" onclick="logOutHeaderBtn()" href="/proyecto-limpio-spring-master/logout">Cerrar Sesión</a>
				</c:if>
			</div>
		</nav>
	</header>

	<main class="mx-auto">