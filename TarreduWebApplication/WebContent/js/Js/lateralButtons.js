
/* Abilita bottone laterale */
$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 200) {
			$('#backToTopMenu').fadeIn(200);
		} else {
			$('#backToTopMenu').fadeOut(200);
		}
	});
});

/* Abilita bottone laterale indietro*/
$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 200) {
			$('#backToPage').fadeIn(200);
		} else {
			$('#backToPage').fadeOut(200);
		}
	});
});


