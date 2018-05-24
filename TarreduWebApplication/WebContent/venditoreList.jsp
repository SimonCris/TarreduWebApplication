<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Venditore</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Footer-with-social-icons.css">
<link rel="stylesheet" href="css/venditoreList.css">
<link rel="stylesheet" href="css/snackbar.css">

<script src="js/Js/venditoreList.js"></script>
<script src="js/Js/lateralButtons.js"></script>
<script src="js/Js/login.js"></script>
<script src="js/Js/snackbar.js"></script>

<link rel="shortcut icon" href="images/TarreduLogo.png">

<!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>
<!-- End WOWSlider.com HEAD section -->


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
	function initMap() {
		var posizione = {
			lat : ${venditore.latitudineVenditore},
			lng : ${venditore.longitudineVenditore}
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 16,
			center : posizione
		});
		var marker = new google.maps.Marker({
			position : posizione,
			title : '${venditore.nomeNegozio}',
			map : map
		});
	}
</script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAUvzMYr08iaxtaGH2K31C7lLifLHRL2g4&callback=initMap">
	
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
		<div class="headerContainer col-md-12">
			<img class="img img-responsive" src="images/headerImage.png"
				alt="headerImage" width="100%" height="100%">
		</div>
	</header>

	<div class="row" style="">

		<!-- Menu di navigazione principale -->
		<nav class="navbar navbar-inverse col-md-12" style="width: 100%;">
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
										name="cognome" required> <label><b>Data di
											Nascita</b></label> <input type="date"
										placeholder="Inserire Data di Nascita" name="dataDiNascita"
										required> <label><b>Numero di Telefono</b></label> <input
										type="text" placeholder="Inserire Numero di Telefono"
										name="numeroDiTelefono" required> <label><b>Email</b></label>
									<input id="emailUtente" type="text"
										placeholder="Inserire Indirizzo Email" name="email" required>
									<label><b>Password</b></label> <input id="psw" type="password"
										placeholder="Inserire Password" name="psw" required> <label><b>Ripetere
											Password</b></label> <input id="psw-repeat" type="password"
										placeholder="Reinserire Password" name="psw-repeat" required>
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

	<div class="container box_venditore">
		<div class="row" id="">
			<!-- Div a sinistra con descrizione Venditore e Contatti-->

			<div class="col-md-7 single-top-left">
				<h2 class="vendor_name">${venditore.nomeNegozio}</h2>
				<p class="separatore"></p>
				<div class="descrizione">
					<p id="descrizioneVenditore" style="">${venditore.descrizioneVenditore}</p>
				</div>

				<div class="info">
					<div class="col-sm-10">
						<h5 style="font-style: oblique">
							<b>Contatti :</b>
						</h5>
						<ul class="contatti">
							<li>${venditore.nomeTitolare}${venditore.cognomeTitolare}</li>
							<li><a href="mailto:${venditore.emailVenditore}">${venditore.emailVenditore}</a></li>
							<li>${venditore.indirizzoVenditore}</li>
							<li><a href="skype:${venditore.numeroTelefonicoVenditore}">${venditore.numeroTelefonicoVenditore}</a></li>
						</ul>
					</div>
				</div>

			</div>
			<!-- Fine Div a sinistra con descrizione Venditore e Contatti-->

			<!-- Fine Div a Destra con Mappa-->

			<h2 style="padding-left: 10%;">Come Raggiungerci</h2>
			<div class="col-md-5 mappa single-top-right" id="map"></div>
			<!--Fine  Div a destra con mappa-->

		</div>
	</div>


	<p class="titolo_sopra_prodotti">PRODOTTI</p>

	<!--Inizio Menu di selezione Tipo prodotti e Prezzo-->

	<div class="container" style="text-align: center;">

		<hr>
		<div class="container menu_selezione">
			<div class="row ">
				<div class="col-md-3 single-top-left ">
					<h4 class="titolo_menu_selezione">Seleziona Tipologia di
						Prodotto</h4>
					<select name="tipoProdotto " class="form-control "
						id="tipoProdotto">
						<option value="">---</option>
						<option value="Armadio">Armadio</option>
						<option value="Cassettiera">Cassettiera</option>
						<option value="Comodino">Comodino</option>
						<option value="Credenza">Credenza</option>
						<option value="Cucina">Cucina</option>
						<option value="Libreria">Libreria</option>
						<option value="Illuminazione">Illuminazione</option>
						<option value="Letto">Letto</option>
						<option value="Scrivania">Scrivania</option>
						<option value="Sedia">Sedia</option>
						<option value="Divano">Divano</option>
						<option value="Poltrona">Poltrona</option>
						<option value="Tavolo">Tavolo</option>
						<option value="Bagno">Bagno</option>
						<option value="Vetrina">Vetrina</option>
						<option value="Camera da Letto">Camera da Letto</option>


					</select>
				</div>
				<div class="col-md-3 single-top-left ">
					<h4 class="titolo_menu_selezione">Seleziona Ambiente</h4>
					<select name="ambienteProdotto" class="form-control"
						id="ambienteProdotto">
						<option value="---">---</option>
						<option value="Cucina">Cucina</option>
						<option value="Bagno">Bagno</option>
						<option value="Soggiorno">Soggiorno</option>
						<option value="Studio">Studio</option>
						<option value="Camera da Letto">Camera da letto</option>
						<option value="Sala da Pranzo">Sala da pranzo</option>
						<option value="Salotto">Salotto</option>
						<option value="Tutti">Tutti gli ambienti</option>
					</select>
				</div>
				<div class="col-md-3 single-top-left ">
					<h4 class="titolo_menu_selezione">Seleziona Marca</h4>
					<select name="marcaProdotto" class="form-control"
						id="marcaProdotto">

						<option value="---">---</option>
						<c:forEach var="marca" items="${marcheProdotti}">
							<option value="${marca}">${marca}</option>
						</c:forEach>
						<option value="Tutti">Tutte le marche</option>

					</select>
				</div>
				<div class="col-md-3 single-top-right ">
					<div>
						<h4 class="titolo_menu_selezione">Prezzo</h4>
						<select name="indirizzo " class="form-control" id="ordinaPrezzo">
							<option value="---">---</option>
							<option value="1">Crescente</option>
							<option value="2">Decrescente</option>
						</select>
					</div>
				</div>


			</div>
		</div>
		<!--Fine Menu di selezione Tipo prodotti e Prezzo-->

		<br>
		<div class="container" id="btnContainer" style="text-align: right;">
			<button class="btn" onclick="listView('${venditore.emailVenditore}')">
				<i class="fa fa-bars"></i> List
			</button>
			<button class="btn" onclick="gridView('${venditore.emailVenditore}')">
				<i class="fa fa-th-large"></i> Grid
			</button>
		</div>

		<!--Inizio Box Prodotti -->

		<div class="container prodotti" style="padding-top: 2%;">

			<div class="container rigaProdotto">
				<c:forEach var="prodotto" items="${prodotti}">
					<div
						class="container row riga grid-item ${prodotto.marcaProdotto} ${prodotto.tipoProdotto} ${prodotto.ambienteProdotto} "
						value="${prodotto.prezzoProdotto}">

						<div class="col-md-4 colProd" style="text-align: left;">
							<h4 class="titolo_prodotto">${prodotto.nomeProdotto}</h4>
							<a href="prodotto?id=${prodotto.idProdotto}"> <img
								class="img img-responsive img_grid" style="width: 150px; height: 150px;"
								src="${prodotto.immaginePrincipale}"
								alt="${prodotto.nomeProdotto}"></a>
							<p>
								<strong>Marca : </strong> ${prodotto.marcaProdotto}
							</p>
						</div>
						<div class="testo_prodotto col-md-4 colProd">
							<p>
								<strong>Tipo : </strong> ${prodotto.tipoProdotto}
							</p>

							<p>
								<strong>Ambiente : </strong> ${prodotto.ambienteProdotto}
							</p>
							<p>
								<strong>Prezzo : </strong> ${prodotto.prezzoProdotto}0 €
							</p>
						</div>

						<div class="testo_prodotto col-md-4 colProd">
							<p>
								<strong>Descrizione : </strong> ${prodotto.descrizioneProdotto}
							</p>
						</div>


					</div>
				</c:forEach>

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