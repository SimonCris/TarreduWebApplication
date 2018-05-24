<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>${venditore.nomeNegozio}</title>
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

<!-- Smartsupp Live Chat script -->
<script type="text/javascript">
var _smartsupp = _smartsupp || {};
_smartsupp.key = '21b19ab74e96a08f193732a37ad89bc04bed9b7d';
window.smartsupp||(function(d) {
  var s,c,o=smartsupp=function(){ o._.push(arguments)};o._=[];
  s=d.getElementsByTagName('script')[0];c=d.createElement('script');
  c.type='text/javascript';c.charset='utf-8';c.async=true;
  c.src='https://www.smartsuppchat.com/loader.js?';s.parentNode.insertBefore(c,s);
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

<link rel="stylesheet" type="text/css" href="css/profiloUtente.css" />
<link rel="stylesheet" type="text/css" href="css/snackbar.css" />
<script src="js/Js/profiloVenditore.js"></script>
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


				</ul>
				<ul class="nav navbar-nav navbar-right menuDestra">

					<li class="navbarOggetto"><a onclick="effettuaLogout()"
						class="nomeUtente" style="cursor: pointer;"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>

					<li class="navbarOggetto"><a href="profiloVenditore"
						class="nomeVenditore"><span
							class="glyphicon glyphicon-user user"></span> Benvenuto,
							${venditore.nomeTitolare}</a></li>


				</ul>
			</div>
		</nav>
	</div>

	<input id="passwordPerVerifica" value="${venditore.passwordVenditore}"
		style="display: none;">

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna Su</a>
	</div>

	<!-- Container con Dati personali, preventivi, preferiti e modifica dati personali -->
	<div class="container containerDatiPersonali">
		<h2>Il mio negozio</h2>

		<ul class="nav nav-tabs">
			<li><a data-toggle="tab" href="#home">Dati personali</a></li>
			<li class="active"><a data-toggle="tab" href="#menu1">Prodotti</a></li>
			<li><a data-toggle="tab" href="#menu2">Storico Preventivi
					Ricevuti</a></li>
			<li><a data-toggle="tab" href="#menu3">Modifica dati
					personali</a></li>
			<li><a data-toggle="tab" href="#menu4">Modifica Password</a></li>
			<li><a data-toggle="tab" href="#menu5">Aggiungi Prodotto</a></li>
		</ul>

		<div class="tab-content">
			<!-- Dati personali venditore -->
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
								<div class="panel-body">${venditore.nomeTitolare}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Cognome</div>
								<div class="panel-body">${venditore.cognomeTitolare}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Email</div>
								<div class="panel-body">${venditore.emailVenditore}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Password</div>
								<div class="panel-body">${venditore.passwordVenditore}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Indirizzo Negozio</div>
								<div class="panel-body">${venditore.indirizzoVenditore}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Recapito telefonico</div>
								<div class="panel-body">${venditore.numeroTelefonicoVenditore}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Descrizione</div>
								<div class="panel-body">${venditore.descrizioneVenditore}</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- Prodotti del venditore -->
			<div id="menu1" class="tab-pane fade in active">
				<!--Inizio Box Prodotti -->

				<div class="container prodotti" style="padding-top: 2%;">

					<div class="row">
						<c:forEach var="prodotto" items="${prodottiDelVenditore}">
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
											onclick="rimuoviDaiProdotti('${prodotto.idProdotto}')">
											<span class="glyphicon glyphicon-remove"></span> Rimuovi dai
											Prodotti
										</button>
										<button type="button" id="bottoneRimuovi"
											class="btn btn-info"
											onclick="apriModificaProdotto('${prodotto.idProdotto}')">
											<span class="glyphicon glyphicon-pencil"></span> Modifica
										</button>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>

				</div>
			</div>
			<!-- Lista di preventivi richiesti dall' utente -->
			<div id="menu2" class="tab-pane fade">
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
										<th>Utente</th>
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
														<h4 class="media-heading">
															<strong>Codice Preventivo :
																${preventivo.idPreventivo}</strong>
														</h4>
													</div>
												</div>
											</td>
											<td class="col-sm-1 col-md-1 text-left"><strong>${preventivo.utente}</strong></td>
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
			<div id="menu3" class="tab-pane fade">
				<div class="containerTitoloForm">
					<h3>
						Modifica Dati Personali <span class="glyphicon glyphicon-pencil"></span>
					</h3>
				</div>
				<hr>
				<div class="containerFormDatipersonali">
					<form action="aggiornaDatiPersonaliVenditore">
						<div class="containerDatiForm">
							<div class="row">
								<div class="col-md-1">
									<label for="nomeVenditore">Nome venditore</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="nomeVenditore" name="nome"
										placeholder="Inserire nuovo nome venditore"
										value="${venditore.nomeTitolare}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="cognomeVenditore">Cognome venditore</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="cognomeVenditore" name="cognome"
										placeholder="Inserire nuovo cognome venditore"
										value="${venditore.cognomeTitolare}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="negozioVenditore">Negozio Venditore</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="negozioVenditore" name="negozio"
										placeholder="Inserire nuovo nome del negozio"
										value="${venditore.nomeNegozio}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="emailVenditore">Email Utente</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="emailUtente" name="email"
										placeholder="Inserire nuova email venditore"
										value="${venditore.emailVenditore}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="indirizzoVenditore">Indirizzo Venditore</label>
								</div>
								<div class="col-md-8">
									<input type="text" name="indirizzoVenditore"
										value="${venditore.indirizzoVenditore}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="recapitoTelefonico">Recapito Telefonico</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="recapitoTelefonico"
										name="recapitoTelefonicoVenditore"
										placeholder="Inserire nuovo recapito telefonico"
										value="${venditore.numeroTelefonicoVenditore}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="descrizioneVenditore">Descrizione venditore</label>
								</div>
								<div class="col-md-8">
									<textarea id="descrizioneVenditore" name="descrizioneVenditore"
										placeholder="Inserire una descrizione..."
										style="height: 50%; width: 100%;">${venditore.descrizioneVenditore}</textarea>
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
			<div id="menu4" class="tab-pane fade">
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
									<label for="passwordVenditore">Vecchia Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="oldPassword"
										placeholder="Inserire vecchia Password" name="oldPassword"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="passwordVenditore">Nuova Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="newPassword"
										placeholder="Inserire nuova Password" name="newPassword"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="passwordVenditore">Conferma Nuova Password</label>
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
			<div id="menu5" class="tab-pane fade">
				<div class="containerTitoloForm">
					<h3>
						Aggiungi un nuovo prodotto <span
							class="glyphicon glyphicon-floppy-save"></span>
					</h3>
				</div>
				<hr>
				<div class="containerFormDatipersonali">
					<form action="aggiungiProdottoVenditore" method="post"
						enctype="multipart/form-data">
						<div class="containerDatiForm">
							<div class="row">
								<div class="col-md-1">
									<label for="nomeProdotto">Nome Prodotto</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="nomeProdotto" name="nome"
										placeholder="Inserire nuovo nome prodotto" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="marcaProdotto">Marca Prodotto</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="marcaProdotto" name="marca"
										placeholder="Inserire nuova marca prodotto" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="tipoProdotto">Tipo Prodotto</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="tipoProdotto" name="tipo"
										placeholder="Inserire nuovo tipo del prodotto" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="ambienteProdotto">Ambiente Prodotto</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="ambienteProdotto" name="ambiente"
										placeholder="Inserire nuovo ambiente del prodotto" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="prezzoProdotto">Prezzo Prodotto</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="prezzoProdotto" name="prezzo"
										placeholder="Inserire nuovo prezzo del prodotto" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="misureProdotto">Misure Prodotto</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="misureProdotto" name="misure"
										placeholder="Inserire nuove misure del prodotto" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="coloriProdotto">Colori Prodotto</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="coloriProdotto" name="colori"
										placeholder="Inserire i colori, separati da ',' " value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="descrizioneProdotto">Descrizione prodotto</label>
								</div>
								<div class="col-md-8">
									<textarea id="descrizioneProdotto" name="descrizioneProdotto"
										placeholder="Inserire una descrizione..."
										style="height: 50%; width: 100%;"></textarea>
								</div>
							</div>

							<div class="row">
								<div class="col-md-1">
									<label for="inserimentoImmagine">Inserire immagine
										prodotto</label>
								</div>
								<div class="col-md-8 listaImmagini">
									<input id="contatoreImmagini" value="1"
										name="contatoreImmagini" style="display: none;">
									<ol>
										<li><input type="file" name="pic1" accept="image/*"
											class=""></li>
									</ol>
									<button class ="btn btn-warning" id="aggiungiImmagine">Aggiungi Immagine</button>
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="inOfferta">Prodotto in offerta?</label><input
										type="checkbox" name="prodottoInOfferta"
										class="messageCheckbox" value="1">
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