<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html lang="it">

<head>
<title>Modifica Prodotto</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="css/snackbar.css">
<script src="js/Js/snackbar.js"></script>
<link rel="shortcut icon" href="images/TarreduLogo.png">

<link rel="stylesheet" href="css/modificaProdotto.css">
<script src="js/Js/modificaProdotto.js"></script>

</head>
<body>

	<!-- Sfondo -->

	<img class="img img-responsive" src="images/sfondoLegno.png" id="bg">

	<div class="containerGenerale">
		<div class="container containerFormDatipersonali">
			<h2>Modifica Prodotto</h2>
			<hr>
			<form action="aggiornaProdotto" method="post"
				enctype="multipart/form-data">
				<div class="containerDatiForm">
				<div class="row riga">
						<div class="col-md-2">
							<label for="nomeProdotto">id Prodotto DB</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="idProdotto" name="idProdotto"
								placeholder=""
								value="${prodotto.idProdotto}" readonly>
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="nomeProdotto">Nome Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="nomeProdotto" name="nome"
								placeholder="Inserire nuovo nome prodotto"
								value="${prodotto.nomeProdotto}">
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="marcaProdotto">Marca Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="marcaProdotto" name="marca"
								placeholder="Inserire nuova marca prodotto"
								value="${prodotto.marcaProdotto}">
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="tipoProdotto">Tipo Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="tipoProdotto" name="tipo"
								placeholder="Inserire nuovo tipo del prodotto"
								value="${prodotto.tipoProdotto}">
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="ambienteProdotto">Ambiente Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="ambienteProdotto" name="ambiente"
								placeholder="Inserire nuovo ambiente del prodotto"
								value="${prodotto.ambienteProdotto}">
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="prezzoProdotto">Prezzo Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="prezzoProdotto" name="prezzo"
								placeholder="Inserire nuovo prezzo del prodotto"
								value="${prodotto.prezzoProdotto}">
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="misureProdotto">Misure Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="misureProdotto" name="misure"
								placeholder="Inserire nuove misure del prodotto"
								value="${prodotto.misureProdotto}">
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="coloriProdotto">Colori Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="coloriProdotto" name="colori"
								placeholder="Inserire i colori, separati da ',' "
								value="<c:forEach var="colore" items="${prodotto.coloriProdotto}"><c:out value="${colore}" />,</c:forEach>">
						</div>
					</div>
					<hr>
					<div class="row riga">
						<div class="col-md-2">
							<label for="descrizioneProdotto">Descrizione prodotto</label>
						</div>
						<div class="col-md-10">
							<textarea id="descrizioneProdotto" name="descrizioneProdotto"
								placeholder="Inserire una descrizione..."
								style="height: 50%; width: 90%;">${prodotto.descrizioneProdotto}</textarea>
						</div>
					</div>
					<hr>
					<div class="row riga inserireImmagine">
						<div class="col-md-2">
							<label for="eliminareImmagine">Eliminare immagine/i
								prodotto</label>
						</div>
						<div class="col-md-10 listaImmaginiProdotto row">

							<c:forEach var="immagineProdotto"
								items="${listaImmaginiProdotto}" varStatus="loop" begin="0"
								end="${dimensioneListaImmagini}" step="1">

								<div class="column containerFotoProdotto"
									style="width: 30%; height: 25%;">
									<img src="${immagineProdotto}"
										onclick="openModal();currentSlide(${loop.index})"
										class="hover-shadow cursor img img-responsive imgProdotto">
									<button type="button" id="bottoneRimuovi"
										class="btn btn-success"
										onclick="impostaComePrincipale('${prodotto.idProdotto}', '${immagineProdotto}')">
										<span class="glyphicon glyphicon-remove"></span>Imposta Come
										Principale
									</button>

									<button type="button" id="bottoneRimuovi"
										class="btn btn-danger"
										onclick="rimuoviImmagineProdotto('${prodotto.idProdotto}', '${immagineProdotto}')">
										<span class="glyphicon glyphicon-remove"></span> Rimuovi
										immagine
									</button>

								</div>

							</c:forEach>

							<!-- MODAL -->
							<div id="myModal" class="modal">
								<span class="close cursor" onclick="closeModal()">&times;</span>
								<div class="modal-content">

									<c:forEach var="immagineProdotto"
										items="${listaImmaginiProdotto}" varStatus="loop" begin="0"
										end="${dimensioneListaImmagini}" step="1">

										<div class="mySlides">
											<div class="numbertext">${loop.index}/
												${dimensioneListaImmagini}</div>
											<img src="${immagineProdotto}" style="width: 100%">
										</div>

									</c:forEach>

									<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a
										class="next" onclick="plusSlides(1)">&#10095;</a>

									<hr style="border: 0.5px solid black; width: 100%;">

									<c:forEach var="immagineProdotto"
										items="${listaImmaginiProdotto}" varStatus="loop" begin="0"
										end="${dimensioneListaImmagini}" step="1">

										<div class="column">
											<img class="demo cursor" src="${immagineProdotto}"
												style="width: 100%" onclick="currentSlide(${loop.index})">
										</div>


									</c:forEach>

								</div>
							</div>
						</div>
						<hr>
						<div class="row riga inserireImmagine">
							<div class="col-md-2">
								<label for="inserimentoImmagine">Inserire immagine
									prodotto</label>
							</div>
							<div class="col-md-10 listaImmagini">
								<input id="contatoreImmagini" value="1" name="contatoreImmagini"
									style="display: none;">
								<ol>
									<li><input type="file" name="pic1" accept="image/*"
										class=""></li>
								</ol>
								<button class ="btn btn-warning" id="aggiungiImmagine">Aggiungi Immagine</button>
							</div>
						</div>
						<hr>
						<div class="row riga">
							<div class="col-md-4">


								<c:if test="${offertaProdotto == true}">
									<label for="inOfferta">Prodotto in offerta? <strong>SI</strong>
									</label>
									<input type="checkbox" name="prodottoInOfferta"
										class="messageCheckbox" value="1" checked>
								</c:if>
								<c:if test="${offertaProdotto == false}">
									<label for="inOfferta">Prodotto in offerta? <strong>NO</strong>
									</label>
									<input type="checkbox" name="prodottoInOfferta"
										class="messageCheckbox" value="1">
								</c:if>
							</div>

						</div>
					</div>
					<hr>
					<div class="bottoni">
						<div class="row containerSubmitButton">
							<div class="col-md-6">
								<button class="btn btn-danger" type="reset">Ripristina Originali
									</button>
							</div>
							<div class="col-md-6">
								<button class="btn btn-success">Salva</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>

	</div>
	<div id="snackbar"></div>

</body>
</html>