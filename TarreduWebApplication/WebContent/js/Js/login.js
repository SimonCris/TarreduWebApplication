// FILE JAVASCRIPT CHE GESTISCE LOGIN, LOGOUT E REGISTRAZIONE.





/* VALIDATORE EMAIL */

var validate_email = function(email) {
	var pattern = /^([a-zA-A0-9_.-])+@([a-zA-Z0-9_.-])+([a-zA-Z])+/;
	var is_email_valid = false;
	if (email.match(pattern) != null) {
		is_email_valid = true;
	}
	return is_email_valid;
}

/* Valida Email registrazione UTENTE */
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

		$.ajax({
			type : "GET",
			url : "verificaMail",

			data : {
				email : input_val
			},
			success : function(data) {
				if (data == "false") {
					$("#emailUtente").css({
						'background-color' : '#7FFF00'
					});
					$("#snackbar").css({
						'background-color' : '#7FFF00'
					});
					$("#snackbar").text("EMAIL CORRETTA");
					showSnackbar();
				} else {
					$("#emailUtente").css({
						'background-color' : 'red'
					});
					$("#snackbar").css({
						'background-color' : 'red'
					});
					$("#snackbar").text("EMAIL GIA' REGISTRATA");
					showSnackbar();
				}
			}
		})
	}

});

/* Valida Email registrazione VENDITORE */
$(document).on("focusout","#emailVenditore", function() {
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

		$.ajax({
			type : "GET",
			url : "verificaMailVenditore",

			data : {
				email : input_val
			},
			success : function(data) {
				if (data == "false") {
					$("#emailVenditore").css({
						'background-color' : '#7FFF00'
					});
					$("#snackbar").css({
						'background-color' : '#7FFF00'
					});
					$("#snackbar").text("EMAIL CORRETTA");
					showSnackbar();
				} else {
					$("#emailVenditore").css({
						'background-color' : 'red'
					});
					$("#snackbar").css({
						'background-color' : 'red'
					});
					$("#snackbar").text("EMAIL GIA' REGISTRATA");
					showSnackbar();
				}
			}
		})
	}

});


/* Validatore PASSWORD UTENTE*/

$(document).on("focusout", "#psw-repeat", function() {
	var password = $("#psw").val();
	var confirmPassword = $("#psw-repeat").val();

	if (password == confirmPassword) {
		$("#psw").css({
			'background-color' : '#7FFF00'
		});
		$("#psw-repeat").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("PASSWORD MATCH");
		showSnackbar();

	} else {
		$("#psw").css({
			'background-color' : 'red'
		});
		$("#psw-repeat").css({
			'background-color' : 'red'
		});
		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("PASSWORD DOESN'T MATCH");
		showSnackbar();
	}

})


/* Validatore PASSWORD VENDITORE */

$(document).on("focusout", "#psw-repeat-Venditore", function() {
	var password = $("#pswVenditore").val();
	var confirmPassword = $("#psw-repeat-Venditore").val();

	if (password == confirmPassword) {
		$("#pswVenditore").css({
			'background-color' : '#7FFF00'
		});
		$("#psw-repeat-Venditore").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("PASSWORD MATCH");
		showSnackbar();

	} else {
		$("#pswVenditore").css({
			'background-color' : 'red'
		});
		$("#psw-repeat-Venditore").css({
			'background-color' : 'red'
		});
		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("PASSWORD DOESN'T MATCH");
		showSnackbar();
	}

})




/* REGISTRAZIONE */
function registrazione() {

	var utente = {
		nome : $("#nome").val(),
		cognome : $("#cognome").val(),
		dataDiNascita : $("#dataDiNascita").val(),
		numeroDiTelefono : $("#numeroDiTelefono").val(),
		emailUtente : $("#emailUtente").val(),
		password : $("#psw").val()
	}

	$.ajax({
		type : "GET",
		url : "registrazione",
		datatype : "json",
		data : JSON.stringify(utente),
		success : function() {
			$("#snackbar").css({
				'background-color' : '#7FFF00'
			});
			$("#snackbar").text("REGISTRAZIONE COMPLETATA");
			showSnackbar();
		}
	});
	console.log(utente);

}

/* Controllo LOGIN */

/* Valida email login */
$(document).on("focusout", ".EmailUtenteLogin", function() {
	var input_val = $(this).val();
	var is_success = validate_email(input_val);

	if (!is_success) {
		alert("Email format wrong");
	}

	$.ajax({
		type : "GET",
		url : "verificaMail",

		data : {
			email : input_val
		},
		success : function(data) {
			/* alert(data); */
		}
	})

});

function effettuaLogout() {

	$.ajax({
		type : "GET",
		url : "effettuaLogout",

		success : function() {
			$("#snackbar").text("LOGOUT EFFETTUATO");
			$("#snackbar").css({
				'background-color' : 'green'
			});
			showSnackbar();

			// window.setTimeout(location.reload(), 1000);
			window.location.replace('index.jsp');

		}

	})
}

// CHIEDI LOGIN

function chiediLogin() {
	$("#snackbar")
			.text(
					"PER EFFETTUARE QUESTA AZIONE DEVI ESSERE REGISTRATO ED EFFETTUARE IL LOGIN");
	$("#snackbar").css({
		'background-color' : 'red'
	});
	showSnackbar();
};


