<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>${utente.nomeUtente}${utente.cognomeUtente}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Footer-with-social-icons.css">

<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery.dataTables.min.js"></script>

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

<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>

<link rel="stylesheet" type="text/css" href="css/profiloUtente.css" />
<link rel="stylesheet" type="text/css" href="css/snackbar.css" />
<script src="js/Js/profiloUtente.js"></script>
<script src="js/Js/lateralButtons.js"></script>
<script src="js/Js/login.js"></script>
<script src="js/Js/snackbar.js"></script>

<link rel="shortcut icon" href="images/TarreduLogo.png">
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
									<div class="containerCheckbox">
										<label>Ricordami <input type="checkbox"
											id="checkRicordami" onclick="controlla()"></label>
									</div>
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

	<input id="passwordPerVerifica" value="${utente.passwordUtente}"
		style="display: none;">
	<input id="emailUtenteLog" value="${emailUtenteLoggato}"
		style="display: none;">

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna Su</a> <a
			href="javascript:history.back()" id="backToPage">Torna Indietro</a>
	</div>

	<!-- Container con Dati personali, preventivi, preferiti e modififa dati personali -->
	<div class="container containerDatiPersonali">
		<h2>Il mio account</h2>

		<ul class="nav nav-tabs">
			<li><a data-toggle="tab" href="#home">Dati personali</a></li>
			<li class="active"><a data-toggle="tab" href="#menu1">Prodotti
					Preferiti</a></li>
			<li><a data-toggle="tab" href="#menu2">Confronta Prodotti</a></li>
			<li><a data-toggle="tab" href="#menu3">Storico Preventivi</a></li>
			<li><a data-toggle="tab" href="#menu4">Modifica dati
					personali</a></li>
			<li><a data-toggle="tab" href="#menu5">Modifica Password</a></li>
		</ul>

		<div class="tab-content">
			<!-- Dati personali utente -->
			<div id="home" class="tab-pane fade in">
				<h3>
					Dati personali <span class="glyphicon glyphicon-user"></span>
				</h3>
				<hr>
				<div class="containerCredenziali">
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Nome</div>
								<div class="panel-body">${utente.nomeUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Cognome</div>
								<div class="panel-body">${utente.cognomeUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Email</div>
								<div class="panel-body" id="emailUtenteLog">${utente.emailUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Password</div>
								<div class="panel-body">${utente.passwordUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Data di nascita</div>
								<div class="panel-body">${utente.datadiNascita}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Recapito telefonico</div>
								<div class="panel-body">${utente.numeroTelefonoUtente}</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- Prodotti preferiti utente -->
			<div id="menu1" class="tab-pane fade in active">
				<!--Inizio Box Prodotti -->

				<div class="container prodotti" style="padding-top: 2%;">

					<div class="row">
						<c:forEach var="prodotto" items="${prodottiPreferiti}">
							<div class="col-md-4 grid-item">
								<a href="prodotto?id=${prodotto.idProdotto}"><img
									class="img img-responsive img_grid"
									src="${prodotto.immaginePrincipale}"
									alt="${prodotto.nomeProdotto}"></a>
								<div>
									<div>
										<h4 class="titolo_prodotto">${prodotto.nomeProdotto}</h4>
										<div class="testo_prodotto">
											<p>${prodotto.descrizioneProdotto}.</p>
										</div>
										<button type="button" id="bottoneRimuovi"
											class="btn btn-danger"
											onclick="rimuoviDaiPreferiti('${prodotto.idProdotto}','${emailUtenteLoggato}')"style:"">
											<span class="glyphicon glyphicon-remove"></span> Rimuovi dai
											Preferiti
										</button>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>

				</div>
			</div>

			<!-- Confronta prodotti -->
			<div id="menu2" class="tab-pane fade in">

				<div class="container prodotti" style="padding-top: 2%;">
					<div class="container" style="text-align: right;">
					<button id="rimuoviBtn" class="btn btn-danger">Rimuovi riga selezionata</button>
					</div>
					<table width="100%" class="display" id="table" cellspacing="0">
						<thead>
							<tr>
								<th>Id Prodotto DB</th>
								<th>Nome</th>
								<th>Marca</th>
								<th>Tipo</th>
								<th>Ambiente</th>
								<th>Misure</th>
								<th>Prezzo</th>

							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Id Prodotto DB</th>
								<th>Nome</th>
								<th>Marca</th>
								<th>Tipo</th>
								<th>Ambiente</th>
								<th>Misure</th>
								<th>Prezzo</th>

							</tr>
						</tfoot>
						<tbody>

							<c:forEach var="prodotto" items="${prodottiPerConfronto}">

								<tr>
									<td>${prodotto.idProdotto}</td>
									<td><a href="prodotto?id=${prodotto.idProdotto}">${prodotto.nomeProdotto}</a></td>
									<td>${prodotto.marcaProdotto}</td>
									<td>${prodotto.tipoProdotto}</td>
									<td>${prodotto.ambienteProdotto}</td>
									<td>${prodotto.misureProdotto}</td>
									<td>${prodotto.prezzoProdotto}0€</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>


				</div>
			</div>


			<!-- Lista di preventivi richiesti dall' utente -->
			<div id="menu3" class="tab-pane fade">
				<div class="containerListaPreventivi">
					<h3>
						Preventivi <span class="glyphicon glyphicon-list-alt"></span>
					</h3>
				</div>
				<hr>
				<div class="container boxCarrello">
					<div class="row">
						<div class="col-sm-12 col-md-10 col-md-offset-1">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Codice Preventivo</th>
										<th>Data Preventivo</th>
										<th class="text-center">Lista Prodotti in preventivo</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listaPreventivi}" var="preventivo">
										<tr>
											<td class="col-sm-8 col-md-8">
												<div class="media">
													<div class="immaginePreventivo">
														<img class="media-object" src="images/preventivo.jpg"
															style="width: 72px; height: 72px;">

													</div>
													<div class="media-body">
														<br>
														<h4 class="media-heading">Codice Preventivo :
															${preventivo.idPreventivo}</h4>
													</div>
												</div>
											</td>
											<td class="col-sm-1 col-md-1 text-left"><strong>${preventivo.dataOraPreventivo}</strong></td>

											<td
												class="col-sm-1 col-md-1 text-center containerListaProdotti">
												<button type="button" class="btn btn-primary"
													data-toggle="modal"
													data-target="#<c:out value="${preventivo.idPreventivo}"/>myModal">
													Prodotti <span class="glyphicon glyphicon-modal-window"></span>
												</button> <!-- Modal -->
												<div class="modal fade"
													id="${preventivo.idPreventivo}myModal" role="dialog">
													<div class="modal-dialog">

														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<h3 class="modal-title">Lista dei prodotti in
																	preventivo</h3>
															</div>
															<div class="modal-body">
																<c:forEach items="${preventivo.listaProdotti}"
																	var="prodotto">
																	<div class="row">
																		<h4>${prodotto.nomeProdotto}</h4>
																		<div class="col-md-6">
																			<a href="prodotto?id=${prodotto.idProdotto}"><img
																				class="img img-responsive immagineProdotto"
																				style="width: 300px; height: 200px;"
																				src="${prodotto.immaginePrincipale}"
																				alt="${prodotto.nomeProdotto}"></a>
																		</div>
																		<div class="col-md-6">
																			<div class="containerCaratteristiche">
																				<div class="labelProdotto">
																					<label>Id: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<p>${prodotto.idProdotto}</p>
																				</div>
																				<div class="labelProdotto">
																					<label>Marca: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<p>${prodotto.marcaProdotto}</p>
																				</div>
																				<div class="labelProdotto">
																					<label>Venditore: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<div class="row venditoriProdotto">
																						<p>${prodotto.nomeNegozioVenditore}</p>
																					</div>
																				</div>
																				<div class="labelProdotto">
																					<label>Prezzo: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<p>
																					<p>${prodotto.prezzoProdotto}0€</p>
																					</p>
																				</div>
																				<button type="button" class="btn btn-primary"
																					data-toggle="modal" data-target="#myModal"
																					onclick="prodotto?id=${prodotto.idProdotto}">Apri</button>
																			</div>
																		</div>
																		<hr>
																	</div>
																</c:forEach>
															</div>

														</div>

													</div>

												</div>
											</td>

										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- Modifica dati personali utente -->
			<div id="menu4" class="tab-pane fade">
				<div class="containerTitoloForm">
					<h3>
						Modifica Dati Personali <span class="glyphicon glyphicon-pencil"></span>
					</h3>
				</div>
				<hr>
				<div class="containerFormDatipersonali">
					<form action="aggiornaDatiPersonali">
						<div class="containerDatiForm">
							<div class="row">
								<div class="col-md-1">
									<label for="nomeUtente">Nome utente</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="nomeUtente" name="nome"
										placeholder="Inserire nuovo nome utente"
										value="${utente.nomeUtente}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="cognomeUtente">Cognome Utente</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="cognomeUtente" name="cognome"
										placeholder="Inserire nuovo cognome utente"
										value="${utente.cognomeUtente}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="emailUtente">Email Utente</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="emailUtente" name="email"
										placeholder="Inserire nuova email utente"
										value="${utente.emailUtente}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="dataNascita">Data di nascita Utente</label>
								</div>
								<div class="col-md-8">
									<input type="date" name="bday" value="${utente.datadiNascita}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="recapitoTelefonico">Recapito Telefonico</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="recapitoTelefonico"
										name="recapitoTelefonicoUtente"
										placeholder="Inserire nuovo recapito telefonico"
										value="${utente.numeroTelefonoUtente}">
								</div>
							</div>
						</div>

						<div class="row containerSubmitButton">
							<div class="col-md-6">
								<button class="cancelButton" type="reset">Cancella
									tutto</button>
							</div>
							<div class="col-md-6">
								<button class="submitButton">Salva</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- Modifica password utente -->
			<div id="menu5" class="tab-pane fade">
				<div class="containerTitoloForm">
					<h3>
						Modifica Password <span class="glyphicon glyphicon-pencil"></span>
					</h3>
				</div>
				<hr>
				<div class="containerFormDatipersonali cambiaPassword">
					<form onsubmit="cambiaDati(); return false;">
						<div class="containerDatiForm">

							<div class="row">
								<div class="col-md-1">
									<label for="passwordUtente">Vecchia Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="oldPassword"
										placeholder="Inserire vecchia Password" name="oldPassword"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="passwordUtente">Nuova Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="newPassword"
										placeholder="Inserire nuova Password" name="newPassword"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="passwordUtente">Conferma Nuova Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="confirmNewPassword"
										placeholder="Confermare nuova Password"
										name="confirm-newPassword" required>
								</div>
							</div>


						</div>

						<div class="row containerSubmitButton">
							<div class="col-md-6">
								<button class="cancelButton" type="reset">Cancella
									tutto</button>
							</div>
							<div class="col-md-6">
								<button class="submitButton">Salva</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>

	<button type="button" class="btn btn-primary bottoneTornaSu">
		<a href="#top" style="color: #ffffff">Torna su...</a>
	</button>

	<div id="snackbar"></div>
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