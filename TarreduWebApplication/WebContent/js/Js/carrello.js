
/* RIMUOVI PRODOTTO DAL CARRELLO */

function rimuoviDalCarrello(idProdotto, emailUtente) {

	$.ajax({
		type : "GET",
		url : "rimuoviDalCarrello",

		data : {
			idProdotto : idProdotto,
			emailUtente : emailUtente,

		},
		success : function() {
			$("#snackbar").text("RIMOSSO DAL CARRELLO");
			$("#snackbar").css({
				'background-color' : 'green'
			});
			showSnackbar();

			window.setTimeout(location.reload(), 1000);

		}

	})

}

function richiediPreventivo() {

	$("#snackbar").text("ELABORAZIONE DELLA RICHIESTA, ATTENDERE...");
	$("#snackbar").css({
		'background-color' : 'orange'
	});

	showSnackbar();

	var prodottiPerPreventivo = [];

	var richiesteAggiuntive = [];

	$('.selezionatoPerPreventivo:checkbox:checked').each(function() {

		prodottiPerPreventivo.push($(this).val());
	});

	$('.richiesta').each(function() {
		richiesteAggiuntive.push($(this).val());
	});

	if (prodottiPerPreventivo.length > 0) {
		$.ajax({
			type : "GET",
			url : "prodottiPreventivo",
			data : {
				prodotti : prodottiPerPreventivo,
				richieste : richiesteAggiuntive,
			},

			success : function() {

				$("#snackbar").text("PREVENTIVO INVIATO CON SUCCESSO");
				$("#snackbar").css({
					'background-color' : 'green'
				});

				showSnackbar();

				window.setTimeout(location.reload(), 1000);

			}

		})
	} else {
		$("#snackbar").text("DEVI SELEZIONARE ALMENO UN PRODOTTO");
		$("#snackbar").css({
			'background-color' : 'cyan'
		});

		showSnackbar();
	}

}




