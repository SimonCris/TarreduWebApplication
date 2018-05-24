//Funzione che ordina i prodotti per tipo

$(window).on('load', function() {
	$("#tipoProdotto").change(function() {
		var tipo = $("#tipoProdotto option:selected").attr("value");

		$('#ambienteProdotto').val("---");
		$('#marcaProdotto').val("---");
		if (tipo == 'Tutti') {
			$('.grid-item').each(function(i, obj) {
				$(this).show();
			})
		} else {
			$('.grid-item').each(function(i, obj) {

				if (!$(this).hasClass(tipo)) {
					$(this).hide();
				} else {
					$(this).show();

				}
			});
		}

	})

})

// Funzione che ordina i prodotti per ambiente

$(window).on('load', function() {
	$("#ambienteProdotto").change(function() {
		var tipo = $("#ambienteProdotto option:selected").attr("value");

		$('#tipoProdotto').val("---");
		$('#marcaProdotto').val("---");

		if (tipo == 'Tutti') {
			$('.grid-item').each(function(i, obj) {
				$(this).show();
			})
		} else {
			$('.grid-item').each(function(i, obj) {

				if (!$(this).hasClass(tipo)) {
					$(this).hide();
				} else {
					$(this).show();

				}
			});
		}
	})

})

// Funzione che ordina i prodotti per marca

$(window).on('load', function() {
	$("#marcaProdotto").change(function() {
		var tipo = $("#marcaProdotto option:selected").attr("value");
		$('#ambienteProdotto').val("---");
		$('#tipoProdotto').val("---");

		if (tipo == 'Tutti') {
			$('.grid-item').each(function(i, obj) {
				$(this).show();
			})
		} else {
			$('.grid-item').each(function(i, obj) {

				if (!$(this).hasClass(tipo)) {
					console.log($(this).attr("class"));
					$(this).hide();
				} else {
					$(this).show();

				}
			});
		}
	})

})

/* ordinamento per prezzo */
$(window).on('load', function() {

	$("#ordinaPrezzo").change(function() {

		var tipo = $("#ordinaPrezzo option:selected").attr("value");

		var mylist = $('.rigaProdotto');
		var listitems = mylist.children('.grid-item').get();

		if (tipo == '1') {
			// crescente
			listitems.sort(function(a, b) {
				var compA = parseFloat($(a).attr("value"));
				var compB = parseFloat($(b).attr("value"));
				return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
			})
		} else if (tipo == '2') {
			// decrescente

			listitems.sort(function(a, b) {
				var compA = parseFloat($(a).attr("value"));
				var compB = parseFloat($(b).attr("value"));
				return (compA > compB) ? -1 : (compA < compB) ? 1 : 0;
			})
		}

		mylist.append(listitems);

	})
})

/* List e grid view */

// List View
function listView() {
	window.location.replace("prodotti?stile=list");

}

// Grid View
function gridView() {
	window.location.replace("prodotti?stile=grid");

}
