<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="it">


<head>
<title>Il tuo Carrello</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Footer-with-social-icons.css">
<link rel="stylesheet" href="css/carrello.css">
<link rel="stylesheet" href="css/snackbar.css">

<script src="js/Js/lateralButtons.js"></script>
<script src="js/Js/login.js"></script>
<script src="js/Js/snackbar.js"></script>
<script src="js/Js/carrello.js"></script>

<link rel="shortcut icon" href="images/TarreduLogo.png">


<!-- Smartsupp Live Chat script -->
<script type="text/javascript">
	var _smartsupp = _smartsupp || {};
	_smartsupp.key = '21b19ab74e96a08f193732a37ad89bc04bed9b7d';
	window.smartsupp || (function(d) {
		var s, c, o = smartsupp = function() {
			o._.push(arguments)
		};
		o._ = [];
		s = d.getElementsByTagName('script')[0];
		c = d.createElement('script');
		c.type = 'text/javascript';
		c.charset = 'utf-8';
		c.async = true;
		c.src = 'https://www.smartsuppchat.com/loader.js?';
		s.parentNode.insertBefore(c, s);
	})(document);
</script>
<script>
	window.onload = function() {
		fb_share.href = 'https://www.facebook.com/sharer/sharer.php?text=vieni a trovarci su Tarredu arredamenti&u='
				+ encodeURIComponent(location.href);

		tw_share.href = 'http://twitter.com/share?text=vieni a trovarci su Tarredu arredamenti&url='
				+ encodeURIComponent(location.href)
				+ '&hashtags=#tarredu,#unical,#siw,#grasso,#reale';

		go_share.href = 'https://plus.google.com/share?text=vieni a trovarci su Tarredu arredamenti&u='
				+ encodeURIComponent(location.href);
	}
</script>

</head>


<body>


	<!-- Sfondo -->
		<img class="img img-responsive" src="images/sfondoLegno.png" id="bg">



	<!-- Header -->
	<header class="container-fluid headerImage row" name="top">
		<div class="headerContainer col-md-12" style="text-align: center;">
			<img class="img img-responsive" src="images/headerImage.png"
				alt="headerImage" width="100%" height="100%">
		</div>
	</header>

	<div class="row" style="">

		<!-- Menu di navigazione principale -->
		<nav class="navbar navbar-inverse col-md-12"
			style="width: 100%;">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="navbarOggetto"><img id="logoButton"
						src="images/TarreduLogo.png" width="50" height="50"></li>
					<li class="navbarOggetto"><a href="index.jsp">Home</a></li>

					<li class="navbarOggetto"><a href="prodotti?stile=grid">Catalogo
							Prodotti</a></li>

					<li class="navbarOggetto"><a href="aboutUs.jsp">About us</a></li>
					<li class="dropdown navbarOggetto"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Venditori </a>
						<ul class="dropdown-menu">
							<c:forEach var="venditore" items="${listaVenditori}">

								<li><a class="nomeNegozio"
									href="venditore?id=${venditore.emailVenditore}&stile=grid"
									style="color: red;">${venditore.nomeNegozio}</a></li>

							</c:forEach>

						</ul></li>

				</ul>
				<ul class="nav navbar-nav navbar-right menuDestra">

					<c:if test="${utenteLoggato == true}">

						<li class="navbarOggetto"><a onclick="effettuaLogout()"
							class="nomeUtente" style="cursor: pointer;"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>

						<li class="navbarOggetto"><a href="utente" class="nomeUtente"><span
								class="glyphicon glyphicon-user user"></span> Benvenuto,
								${nomeUtente}</a></li>

						<li class="carrello navbarOggetto"><a href="carrello"><span
								class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>

					</c:if>

					<c:if test="${utenteLoggato == false  || empty utenteLoggato}">

						<li class="navbarOggetto">
							<!-- Form per il login --> <a href="#login"
							onclick="document.getElementById('login').style.display='block'">
								<span class="glyphicon glyphicon-log-in"></span> Login
						</a>
						</li>

							<div id="login" class="modal">

								<form class="modal-content animate" method="post"
									action="validaCredenzialiLogin">
									<div class="imgcontainer">
										<span
											onclick="document.getElementById('login').style.display='none'"
											class="close" title="Chiudi Login">&times;</span> <img
											src="images/userLogin.jpg" alt="Avatar" class="avatar"
											width=150 height=150>
									</div>

									<div class="containerModal">
										<label><b>Email Utente</b></label> <input
											class="inputLogIn EmailUtenteLogin" type="text"
											placeholder="Inserire Indirizzo Email" name="emailUtente"
											required> <label><b>Password</b></label> <input
											class="inputLogIn passwordLogin" type="password"
											placeholder="Inserire Password" name="psw" required>

										<button class="buttonLog" type="submit">Login</button>
										
									</div>

									<div class="containerModalBottom"
										style="background-color: #ffffff">
										<button type="button"
											onclick="document.getElementById('login').style.display='none'"
											class="cancelbtn">Cancel</button>
									</div>
								</form>
							</div>
						
						<li class="navbarOggetto">
							<!-- Form per la registrazione --> <a href="#registrazione"
							onclick="document.getElementById('registrazione').style.display='block'">
								<span class="glyphicon glyphicon-user user"></span> Registrati
						</a>
						</li>

							<div id="registrazione" class="modal">

								<form class="modal-content animateReg" method="post"
									action="registrazione">
									<div class="imgcontainerReg">
										<span
											onclick="document.getElementById('registrazione').style.display='none'"
											class="closeReg" title="Chiudi Registrazione">&times;</span>
									</div>
									<h1>Registrazione</h1>
									<p>Compila questo modulo per creare un account.</p>
									<hr>
									<div class="containerReg">

										<label><b>Nome</b></label> <input type="text"
											placeholder="Inserire Nome" name="nome" required> <label><b>Cognome</b></label>
										<input type="text" placeholder="Inserire Cognome"
											name="cognome" required> <label><b>Data
												di Nascita</b></label> <input type="date"
											placeholder="Inserire Data di Nascita" name="dataDiNascita"
											required> <label><b>Numero di Telefono</b></label> <input
											type="text" placeholder="Inserire Numero di Telefono"
											name="numeroDiTelefono" required> <label><b>Email</b></label>
										<input id="emailUtente" type="text"
											placeholder="Inserire Indirizzo Email" name="email" required>
										<label><b>Password</b></label> <input id="psw" type="password"
											placeholder="Inserire Password" name="psw" required>
										<label><b>Ripetere Password</b></label> <input id="psw-repeat"
											type="password" placeholder="Reinserire Password"
											name="psw-repeat" required>
									</div>
									<div class="containerRegButton"
										style="background-color: #ffffff">
										<button type="button"
											onclick="document.getElementById('registrazione').style.display='none'"
											class="cancelbtnReg">Cancel</button>
										<button class="buttonReg" type="submit">Registrati</button>
									</div>
								</form>

							</div>
						<li class="carrello navbarOggetto"><a onclick="chiediLogin()"
							style="cursor: pointer"><span
								class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
					</c:if>


				</ul>
			</div>
		</nav>
	</div>

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna Su</a> <a
			href="javascript:history.back()" id="backToPage">Torna Indietro</a>
	</div>

	<div class="container boxCarrello"
		style="background: aliceblue; border: 2px solid black; padding-bottom: 50px;">
		<div class="row">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Prodotto</th>
							<th>Seleziona Per Preventivo</th>
							<th>Richieste aggiuntive</th>
							<th class="text-center">Prezzo Consigliato</th>
							<th class="text-center">Rimuovi</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prodotto" items="${prodottiNelCarrello}">
							<tr>
								<td class="col-sm-8 col-md-6">
									<div class="media">
										<a class="thumbnail pull-left"
											href="prodotto?id=${prodotto.idProdotto}"> <img
											class="media-object" src="${prodotto.immaginePrincipale}"
											style="width: 72px; height: 72px;">
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												<a href="prodotto?id=${prodotto.idProdotto}">${prodotto.nomeProdotto}</a>
											</h4>
											<h4 class="media-heading">MARCA :
												${prodotto.marcaProdotto}</h4>
										</div>
									</div>
								</td>
								<td class="col-sm-1 col-md-1" style="text-align: center"><input
									type="checkbox" class="selezionatoPerPreventivo"
									value="${prodotto.idProdotto}"></td>
								<td class="containerListaRichiesta"><button type="button"
										class="btn btn-primary" data-toggle="modal"
										data-target="#<c:out value="${prodotto.idProdotto}"/>myModal">
										Richiesta <span class="glyphicon glyphicon-modal-window"></span>
									</button> <!-- Modal -->
									<div class="modal fade" id="${prodotto.idProdotto}myModal"
										role="dialog">
										<div class="modal-dialog"></div>

										<!-- Modal content-->
										<div class="modal-content">
											<h2>Inserire richiesta aggiuntiva</h2>
											<div class="containerFormRecensione">
												<form class="formRichiesta">
													<label>Richiesta</label> <br>
													<textarea class="richiesta" id="subject" name="subject"
														placeholder="Scrivi la richiesta aggiuntiva"
														style="height: 50%; width: 100%;"></textarea>
													<br> <br>

													<button type="button" class="btn btn-danger"
														title="nvia richiestaAggiuntiva">Click fuori
														dalla finestra per uscire</button>

												</form>
											</div>
										</div>
									</div></td>

								<td class="col-sm-1 col-md-1 text-center"><strong>${prodotto.prezzoProdotto}
										Euro</strong></td>

								<td class="col-sm-1 col-md-1">
									<button type="button" class="btn btn-danger"
										onclick="rimuoviDalCarrello('${prodotto.idProdotto}','${emailUtenteLoggato}')">
										<span class="glyphicon glyphicon-remove"></span> Rimuovi dal
										Carrello
									</button>
								</td>
							</tr>
						</c:forEach>
						<tr>
						<td>
							<button type="button" class="btn btn-success"
								onclick="richiediPreventivo()">
								RichiediPreventivo<span class="glyphicon glyphicon-play"></span>
							</button>
						</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<button type="button" class="btn btn-primary bottoneTornaSu">
		<a href="#top" style="color: #ffffff">Torna su...</a>
	</button>

	<div class="content"></div>
	<!-- Footer -->
	<footer id="myFooter">
		<div class="container" style="text-align: center">
			<div class="row">
				<div class="col-sm-3 myCols"></div>
				<div class="col-sm-3 myCols">
					<h5>Contatti</h5>
					<ul id="contattiFooter">
						<li><a>Francesco Marrara</a></li>
						<li><a>francmarrara@gmail.com</a></li>
						<li><a>Tel. 347 31 39 840</a></li>
						<li><a>Simone Crisafi</a></li>
						<li><a>xblack90@hotmail.it</a></li>
						<li><a>Tel: 347 73 53 491</a></li>
					</ul>
				</div>

				<div class="col-sm-3 myCols">
					<h5>Supporto</h5>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="aboutUs.jsp">Help desk</a></li>
					</ul>
				</div>
				<div class="col-sm-3 myCols"></div>

			</div>
		</div>
		<div class="social-networks">
			<a href="" id="tw_share" class="twitter"><i class="fa fa-twitter"></i></a>
			<a href="" id="fb_share" class="facebook"><i
				class="fa fa-facebook-official"></i></a> <a href="" id="go_share"
				class="google"><i class="fa fa-google-plus"></i></a>
		</div>
	</footer>
	<div id="snackbar"></div>


</body>

</html>