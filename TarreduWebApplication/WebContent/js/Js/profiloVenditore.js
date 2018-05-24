/* Valida Email registrazione */
$(document).on("focusout", "#emailVenditore", function() {
	var input_val = $(this).val();
	var is_success = validate_email(input_val);

	if (!is_success) {

		$("#emailVenditore").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("FORMATO EMAIL NON CORRETTO");
		$("#snackbar").css({
			'background-color' : 'red'
		});
		showSnackbar();
	} else {

		$("#emailVenditore").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("FORMATO EMAIL CORRETTO");
		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		showSnackbar();

	}

});

// /* Validatore PASSWORD */
$(document).on("focusout", "#confirmNewPassword", function() {

	var oldPassword = $("#oldPassword").val();
	var password = $("#newPassword").val();
	var confirmPassword = $("#confirmNewPassword").val();

	if (password == confirmPassword && password != oldPassword) {
		$("#newPassword").css({
			'background-color' : '#7FFF00'
		});
		$("#confirmNewPassword").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("PASSWORD CORRETTE");
		showSnackbar();

	} else if (password == oldPassword) {
		$("#newPassword").css({
			'background-color' : 'red'
		});
		$("#confirmNewPassword").css({
			'background-color' : 'red'
		});
		$("#oldPassword").css({
			'background-color' : 'red'
		});
		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("LA VECCHIA E LA NUOVA PASSWORD SONO UGUALI");
		showSnackbar();

	}

	else {
		$("#newPassword").css({
			'background-color' : 'red'
		});
		$("#confirmNewPassword").css({
			'background-color' : 'red'
		});
		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("LE PASSWORD NON SONO UGUALI");
		showSnackbar();
	}

});

// Valida email vecchia confrontata alla nuova
$(document).on("focusout", "#oldPassword", function() {
	var password = $("#oldPassword").val();

	var confirmPassword = $("#passwordPerVerifica").val();

	if (password == confirmPassword) {
		$("#oldPassword").css({
			'background-color' : '#7FFF00'
		});

		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("LA VECCHIA PASSWORD E' CONFERMATA");
		showSnackbar();

	} else {
		$("#oldPassword").css({
			'background-color' : 'red'
		});

		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("VECCHIA PASSWORD ERRATA");
		showSnackbar();
	}

});

function cambiaDati() {

	var userPassword = $("#passwordPerVerifica").val();
	var oldPassword = $("#oldPassword").val();

	var newPassword = $("#newPassword").val();
	var confirmPassword = $("#confirmNewPassword").val();

	if (newPassword == confirmPassword) {

		$.ajax({
			type : "GET",
			url : "cambiaPasswordVenditore",

			data : {
				nuovaPassword : newPassword,
			},
			success : function() {
				$("#emailVenditore").css({
					'background-color' : '#7FFF00'
				});
				$("#snackbar").css({
					'background-color' : '#7FFF00'
				});
				$("#snackbar").text("PASSWORD MODIFICATA CON SUCCESSO");
				showSnackbar();

				window.setTimeout(window.location.replace('profiloVenditore'),
						1000);

			}
		})

	}

}

// rimuovo Prodotto

function rimuoviDaiProdotti(idProdotto) {

	$.ajax({
		type : "GET",
		url : "rimuoviProdottoDelVenditore",

		data : {
			idProdotto : idProdotto,

		},
		success : function() {
			$("#snackbar").text("RIMOSSO DAI PRODOTTI");
			$("#snackbar").css({
				'background-color' : 'green'
			});
			showSnackbar();

			window.setTimeout(location.reload(), 1000);

		}

	})

}

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

/* Apri modifica Prodotto */
function apriModificaProdotto(idProdotto) {
	window.open("modificaProdotto?id="+idProdotto, null,"height=800,width=1100,status=yes,toolbar=no,menubar=no,location=no");
}












