/* Valida Email registrazione */
$(document).on("focusout", "#emailUtente", function() {
	var input_val = $(this).val();
	var is_success = validate_email(input_val);

	if (!is_success) {

		$("#emailUtente").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("FORMATO EMAIL NON CORRETTO");
		$("#snackbar").css({
			'background-color' : 'red'
		});
		showSnackbar();
	} else {

		$("#emailUtente").css({
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
			url : "cambiaPassword",

			data : {
				nuovaPassword : newPassword,
			},
			success : function() {
				$("#emailUtente").css({
					'background-color' : '#7FFF00'
				});
				$("#snackbar").css({
					'background-color' : '#7FFF00'
				});
				$("#snackbar").text("PASSWORD MODIFICATA CON SUCCESSO");
				showSnackbar();

				window.setTimeout(window.location.replace('utente'), 1000);

			}
		})

	}

}

// rimuovo dai Preferiti un Prodotto

function rimuoviDaiPreferiti(idProdotto, emailUtente) {

	$.ajax({
		type : "GET",
		url : "rimuoviDaiPreferiti",

		data : {
			idProdotto : idProdotto,
			emailUtente : emailUtente,

		},
		success : function() {
			$("#snackbar").text("RIMOSSO DAI PREFERITI");
			$("#snackbar").css({
				'background-color' : 'green'
			});
			showSnackbar();

			window.setTimeout(location.reload(), 1000);

		}

	})

}

// Rimuovo prodotto da confronto

$(document).ready(function() {
	var table = $('#table').DataTable();

	$('#table tbody').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			$(this).removeClass('selected');
		} else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});

	$('#rimuoviBtn').click(function() {

		var valori= table.row('.selected').data();
		table.row('.selected').remove().draw(false);

		var email = $("#emailUtenteLog").val();
		
		
		 var valoriString = valori.toString();
         var idProdotto = valoriString.substr(0, valoriString.indexOf(','));
		
		$.ajax({
			type : "GET",
			url : "rimuoviDaConfronto",

			data : {
				idProdotto : idProdotto,
				emailUtente : email,

			},
			success : function() {
				$("#snackbar").text("RIMOSSO DAL CONFRONTO");
				$("#snackbar").css({
					'background-color' : 'green'
				});
				showSnackbar();

			}

		})

	});
});
