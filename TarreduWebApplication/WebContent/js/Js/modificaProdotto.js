/* Inserimento immagini */
$(document).ready(
		function() {

			var contatore = $("#contatoreImmagini").val();

			$("#aggiungiImmagine").click(
					function() {
						contatore++;
						$(".listaImmagini ol").append(
								"<li><input type=" + "file" + " name=" + "pic"
										+ contatore + " accept=" + "image/*"
										+ "" + ">" + "</li>");

						$("#contatoreImmagini").val(contatore);
						return false;

					});

		});

/* Modifico l'immagine principale del prodotto */
function rimuoviImmagineProdotto(idProdotto, immagineProdotto) {

	$.ajax({
		type : "GET",
		url : "rimuoviImmagineProdotto",

		data : {
			idProdotto : idProdotto,
			urlImmagine : immagineProdotto,
		},

		success : function(data) {
			if (data== "true") {
				
				$("#snackbar").text("IMMAGINE RIMOSSA");
				$("#snackbar").css({
					'background-color' : 'green'
				});
				showSnackbar();

				window.setTimeout(location.reload(), 1000);
			} else {
				
				$("#snackbar").text("NON E' POSSIBILE RIMUOVERE L'IMMAGINE");
				$("#snackbar").css({
					'background-color' : 'red'
				});
				showSnackbar();
			}
		}
	})

}



/* Rimuovo immagine dal prodotto */
function impostaComePrincipale(idProdotto, immagineProdotto) {

	$.ajax({
		type : "GET",
		url : "impostaComePrincipale",

		data : {
			idProdotto : idProdotto,
			urlImmagine : immagineProdotto,
		},

		success : function(data) {
			console.log(data)
			if (data == "true") {
				$("#snackbar").text("IMMAGINE IMPOSTATA COME PRINCIPALE");
				$("#snackbar").css({
					'background-color' : 'green'
				});
				showSnackbar();

			} else {
				$("#snackbar").text("L'IMMAGINE E' GIA' PRINCIPALE");
				$("#snackbar").css({
					'background-color' : 'red'
				});
				showSnackbar();
			}
		}
	})

}













/* MODAL IMAGES */
function openModal() {
	document.getElementById('myModal').style.display = "block";
}

function closeModal() {
	document.getElementById('myModal').style.display = "none";
}

var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
	showSlides(slideIndex += n);
}

function currentSlide(n) {
	showSlides(slideIndex = n);
}

function showSlides(n) {
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("demo");
	var captionText = document.getElementById("caption");
	if (n > slides.length) {
		slideIndex = 1
	}
	if (n < 1) {
		slideIndex = slides.length
	}
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
	captionText.innerHTML = dots[slideIndex - 1].alt;
}
