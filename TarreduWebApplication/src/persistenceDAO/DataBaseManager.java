package persistenceDAO;

import model.Prodotto;
import model.Venditore;

public class DataBaseManager {

	private DAOFactory factory;
	private UtilDAO utilDao;

	private ProdottoDAO prodottoDao;
	private UtenteDAO utenteDao;
	private PreventivoDAO preventivoDao;
	private CarrelloDAO carrelloDao;
	private VenditoreDAO venditoreDao;
	private CommentoDAO commentoDao;

	public DataBaseManager() {

		factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		setUtilDao(factory.getUtilDAO());

		prodottoDao = factory.getProdottoDAO();
		utenteDao = factory.getUtenteDAO();
		preventivoDao = factory.getPreventivoDAO();
		carrelloDao = factory.getCarrelloDAO();
		venditoreDao = factory.getVenditoreDAO();
		commentoDao = factory.getCommentoDAO();

	}

	public void createVenditori() {

		// Antonella Mazzei Arredamenti, Cosenza

		Venditore mazzei = new Venditore();
		mazzei.setNomeNegozio("Antonella Mazzei Arredamenti");
		mazzei.setNomeTitolare("Antonella");
		mazzei.setCognomeTitolare("Mazzei");
		mazzei.setNumeroTelefonicoVenditore("+39 338 5378178");
		mazzei.setEmailVenditore("info@antonellamazzei.it");
		mazzei.setIndirizzoVenditore("Viale Cosmai 32, 87100 Cosenza (di fronte Guardia di Finanza)");
        mazzei.setDescrizioneVenditore("Antonella Mazzei Arredamenti è un nome che ha dietro una storia"
        		+ " fondata sulla passione per il mobile, per il legno, per il gusto di arredare.Quarant'anni"
        		+ " nel settore hanno portato l'azienda a crescere anno dopo anno, identificandosi in tre caratteristiche:cortesia,"
        		+ " qualità  e professionalità.Da Antonella Mazzei Arredamenti potrai trovare uno staff di professionisti capace di prendersi"
        		+ " cura delle tue esigenze, ma soprattutto in grado di valorizzare i tuoi spazi andando incontro ai tuoi desideri."
        		+ "Perchè la casa esprime il tuo gusto personale, che la rende unica ed eclusiva.");
 
        mazzei.setLatitudineVenditore("39.3191");
        mazzei.setLongitudineVenditore("16.248965");
        mazzei.setPasswordVenditore("ciaociao");
		venditoreDao.save(mazzei);

		// ----------------------------------------------------------

		// Scavolini Store, Cosenza

		Venditore scavoliniCosenza = new Venditore();
		scavoliniCosenza.setNomeNegozio("Scavolini Store Cosenza");
		scavoliniCosenza.setNomeTitolare("Gianluca");
		scavoliniCosenza.setCognomeTitolare("Mauro");
		scavoliniCosenza.setNumeroTelefonicoVenditore("0984 839164");
		scavoliniCosenza.setEmailVenditore("marazitamobilisas@libero.it");
		scavoliniCosenza.setIndirizzoVenditore("Via Verdi, 87036 Cosenza  (di fronte Guardia di Finanza)");
		scavoliniCosenza.setDescrizioneVenditore("Scavolini produce cucine da oltre 50 anni. Una lunghissima"
				+ " esperienza maturata nel tempo insieme ai gusti e alle tendenze di quasi tre generazioni di "
				+ "consumatori. Da attività artigianale si è trasformata in realtà industriale, percorrendo con tenacia"
				+ " e determinazione tutte le tappe della sua costruzione aziendale nel pieno rispetto del pubblico, e "
				+ "in sintonia con le esigenze del territorio in cui si trova ad operare.");
		
		scavoliniCosenza.setLatitudineVenditore("39.3469155");
		scavoliniCosenza.setLongitudineVenditore("16.2386041");
		scavoliniCosenza.setPasswordVenditore("ciaociao");
		venditoreDao.save(scavoliniCosenza);

		// ----------------------------------------------------------

		// Conforti Arredamenti, Rende

		Venditore confortiArredamenti = new Venditore();
		confortiArredamenti.setNomeNegozio("Conforti Arredamenti");
		confortiArredamenti.setNomeTitolare("Andrea");
		confortiArredamenti.setCognomeTitolare("Conforti");
		confortiArredamenti.setNumeroTelefonicoVenditore("0984 839164");
		confortiArredamenti.setEmailVenditore("info@confortiarredamenti.it");
		confortiArredamenti.setIndirizzoVenditore("S.S 107 Santo Stefano di Rende");
		confortiArredamenti.setDescrizioneVenditore("L’arte di Arredare La profonda conoscenza"
				+ " delle essenze del legno e della sua lavorazione, grande gusto estetico e tanta "
				+ "passione coltivata in famiglia, ci hanno portato nel corso di 40 anni a lavorare"
				+ " con creatività e voglia di fare per il raggiungimento della qualità dei nostri prodotti "
				+ "artigianali e nella scelta dei migliori marchi. La nostra azienda non si limita esclusivamente "
				+ "alla realizzazione ma si impegna ad interpretarla ed aggiornarla sotto gli aspetti più propriamente "
				+ "formali e stilistici avvalendosi della competenza di consulenti qualificati.");
		confortiArredamenti.setLatitudineVenditore("39.346013");
		confortiArredamenti.setLongitudineVenditore("16.195811");
		
		confortiArredamenti.setPasswordVenditore("ciaociao");
		venditoreDao.save(confortiArredamenti);

		// ----------------------------------------------------------
		// Poltrone e sofà, Rende

		Venditore poltroneSofa = new Venditore();
		poltroneSofa.setNomeNegozio("Poltrone & Sofa");
		poltroneSofa.setNomeTitolare("Mario");
		poltroneSofa.setCognomeTitolare("Rossi");
		poltroneSofa.setNumeroTelefonicoVenditore("0984 838196");
		poltroneSofa.setEmailVenditore("info@poltronesofarende.it");
		poltroneSofa.setIndirizzoVenditore("Via Giuseppe Verdi, 9, 87036 Quattromiglia CS");
		poltroneSofa.setDescrizioneVenditore("Nata a Forlì nel 1995, poltronesofà è diventata oggi il marchio leader"
				+ " in Italia nella produzione e vendita di divani e poltrone in tessuto. Da sempre, il nostro obiettivo"
				+ " è garantire ai nostri clienti un prodotto di alta qualità, di grande artigianalità, interamente italiano,"
				+ " al miglior prezzo di mercato possibile. Disponibilità e capillarità sono i capisaldi del nostro servizio."
				+ " Puntiamo sulla praticità, oltre che sull'estetica. Tutti i nostri divani sono infatti sfoderabili e lavabili.");
		
		poltroneSofa.setLatitudineVenditore("39.3400668");
		poltroneSofa.setLongitudineVenditore("16.2412138");
		
		poltroneSofa.setPasswordVenditore("ciaociao");
		venditoreDao.save(poltroneSofa);

		// Arredamenti due pi, Rende

		Venditore arredamentiDuePi = new Venditore();
		arredamentiDuePi.setNomeNegozio("ArredamentiDuePi");
		arredamentiDuePi.setNomeTitolare("Bruno");
		arredamentiDuePi.setCognomeTitolare("Polillo");
		arredamentiDuePi.setNumeroTelefonicoVenditore("0984 1900082");
		arredamentiDuePi.setEmailVenditore("info@arredamentiduepi.it");
		arredamentiDuePi.setIndirizzoVenditore("S.S.19 G.Verdi Rende");
		arredamentiDuePi.setDescrizioneVenditore("La DuePi Arredamenti opera nel settore degli "
				+ "arredi da circa 50 anni con un target rivolto ad una clientela che ambisce a realizzare "
				+ "e personalizzare lo spazio ideale in cui vivere. Il design, la modernità e la qualità dei "
				+ "marchi proposti dal'Azienda, coadiuvate dalla professionalità di architetti e designer, ne fanno"
				+ " un gruppo innovativo e competente nella gestione del progetto degli arredi. Lo spazio espositivo"
				+ " DuePi offre ai clienti una visione variegata e chiara sulla dimensione e gli ambienti da realizzare. "
				+ "Gli spazi raffinati del living, quelli funzionali e minimalisti dell'area Kitchen, connessi all'universo "
				+ "intimo dell'area di riposo, offrono soluzioni estetico-funzionali alle molteplici necessità del cliente del nostro tempo.");
		
		arredamentiDuePi.setLatitudineVenditore("39.308686");
		arredamentiDuePi.setLongitudineVenditore("16.2170517");
		
		arredamentiDuePi.setPasswordVenditore("ciaociao");
		venditoreDao.save(arredamentiDuePi);

		// ----------------------------------------------------------

	}

	public void createArmadi() {

		Prodotto prodotto = new Prodotto();

		// ARMADI LEFABLIER
		// ----------------------------------------------------------

		// Brahman

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Brahman");
		prodotto.setPrezzoProdotto(Double.parseDouble("4039.00"));
		prodotto.setMisureProdotto("295cm x 67cm x 255cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Dettagli eleganti ed essenziali per l’armadio a due ante scorrevoli \r\n"
				+ "Brahman dove un sottile profilo attraversa le ante scandendone la superficie in due parti.");
		prodotto.setUrlImmaginePrincipale("images/productImages/Brahman_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Brahman_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Brahman_02.jpg");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));

		prodottoDao.save(prodotto);

		// Giove

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Giove");
		prodotto.setPrezzoProdotto(Double.parseDouble("3820.00"));
		prodotto.setMisureProdotto("296cm x 68cm x 253cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Giove è un armadio dalla linea importante, ma allo stesso tempo dal gusto classico \r\n"
						+ "ed elegante frutto della maestria artigianale made in Le Fablier.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Giove_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Giove_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Giove_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Giove_03.jpg");

		prodottoDao.save(prodotto);

		// Astro

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Nero");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Astro");
		prodotto.setPrezzoProdotto(Double.parseDouble("4490.00"));
		prodotto.setMisureProdotto("300cm x 65cm x 255cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Armadio con due ante scorrevoli.");

		prodotto.setUrlImmaginePrincipale("images/productImages/Astro_01.jpg");

		prodotto.getUrlImmaginiProdotto().add("images/productImages/Astro_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Astro_02.jpg");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ARMADI MODULNOVA
		// ----------------------------------------------------------

		// MH6

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");

		prodotto.setMarcaProdotto("Modulnova");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("MH6");
		prodotto.setPrezzoProdotto(Double.parseDouble("3794.00"));
		prodotto.setMisureProdotto("500cm x 175cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Cucina ad isola MH6, con basi e fianchi in melaminico lava, top in laminato lava e piano snack in legno invecchiato abete nero.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Mh6_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Mh6_01.jpg");
		prodottoDao.save(prodotto);

		// Twenty

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Beige");

		prodotto.setMarcaProdotto("Modulnova");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Twenty");
		prodotto.setPrezzoProdotto(Double.parseDouble("4500.00"));
		prodotto.setMisureProdotto("600cm x 200cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"In resina cemento grigio con lavabo in granito nero assoluto e penisola in legno massello sabbiato.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));

		prodotto.setUrlImmaginePrincipale("images/productImages/Twenty_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Twenty_01.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ARMADI FLOU
		// ----------------------------------------------------------

		// Epoque

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Flou");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Epoque");
		prodotto.setPrezzoProdotto(Double.parseDouble("1730.00"));
		prodotto.setMisureProdotto("288cm x 259cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"E' una gamma di armadi caratterizzata da materiali di pregio, accuratezza delle lavorazioni e ampia modularita e varieta di ante e maniglie.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Epoque_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Epoque_01.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ARMADI LEMA
		// ----------------------------------------------------------

		// Fina

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Lema");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Fina");
		prodotto.setPrezzoProdotto(Double.parseDouble("3400.00"));
		prodotto.setMisureProdotto("600cm x 450cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Armadio quattro ante scorrevoli in vetro laccato con maniglia integrata nel profilo dell’anta. I pannelli presentano una cornice in alluminio anodizzato naturale.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Fina_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Fina_01.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createCassettiere() {

		Prodotto prodotto = new Prodotto();

		// CASSETTIERE LEFABLIER
		// ----------------------------------------------------------

		// Ayurveda

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Ayurveda");
		prodotto.setPrezzoProdotto(Double.parseDouble("1817.00"));
		prodotto.setMisureProdotto("65cm x 43cm x 160cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Forma rigorosa e gusto sofisticato del dettaglio, linee che delicatamente \r\n"
				+ "avvolgono la forma, giochi di trasparenze e di dettagli sussurrati.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Ayurveda_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Ayurveda_01.jpg");

		prodottoDao.save(prodotto);

		// Atha

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Atha");
		prodotto.setPrezzoProdotto(Double.parseDouble("1638.00"));
		prodotto.setMisureProdotto("74cm x 43cm x 130cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Funzionalità ed estetica sono racchiuse nel settimino Atha, dove i 7 cassetti sono intervallati \r\n"
						+ "solo da una delicata fascia a definire la cura e la maestria della lavorazione del rovere, oltre al top a vassoio.");

		prodotto.setUrlImmaginePrincipale("images/productImages/Atha_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Atha_01.jpg");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));

		prodottoDao.save(prodotto);

		// Zen

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Zen");
		prodotto.setPrezzoProdotto(Double.parseDouble("2571.00"));
		prodotto.setMisureProdotto("110cm x 43cm x 160cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Superfici che si incontrano e si abbracciano, accostate per generare nuove forme e nuovi dettagli.");
		prodotto.setUrlImmaginePrincipale("images/productImages/Zen_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Zen_01.jpg");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// CASSETTIERE DALE ITALIA
		// ----------------------------------------------------------

		// SideBoard A-141

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Porada");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("SideBoard A-141");
		prodotto.setPrezzoProdotto(Double.parseDouble("2570.00"));
		prodotto.setMisureProdotto("200x80cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Cassettiera molto comoda, stile vintage.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@confortiarredamenti.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/SideBoard_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/SideBoard_01.jpg");

		prodottoDao.save(prodotto);

		// CASSETTIERE DUE PI
		// ----------------------------------------------------------

		// Piroette

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.setMarcaProdotto("Porada");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Piroette");
		prodotto.setPrezzoProdotto(2670.00);
		prodotto.setMisureProdotto("62x107");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Piroette è una cassettiera alta dotata di sette cassetti,"
				+ " caratterizzata dalla torsione dei frontali e realizzata in massello di noce.");

		prodotto.setUrlImmaginePrincipale("images/productImages/Piroette_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Piroette_01.jpg");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));

		prodottoDao.save(prodotto);

		// EILEEN

		Prodotto cassettieraEileen = new Prodotto();

		cassettieraEileen.setAmbienteProdotto("Soggiorno");
		cassettieraEileen.setTipoProdotto("Cassettiera");
		cassettieraEileen.setMarcaProdotto("Rimadesio");
		cassettieraEileen.setNomeProdotto("Eileen");
		cassettieraEileen.getColoriProdotto().add("Grigio");
		cassettieraEileen.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		cassettieraEileen.setPrezzoProdotto(3300.00);
		cassettieraEileen.setMisureProdotto("200x45x80");
		cassettieraEileen.setOffertaProdotto(false);
		cassettieraEileen.setDescrizioneProdotto(
				"Dotata di struttura di sostegno in acciaio inox, due ante scorrevoli complanari in vetro laccato opaco e ripiani interni in vetro laccato.");
		cassettieraEileen.setUrlImmaginePrincipale("images/productImages/Eileen_01.jpg");
		cassettieraEileen.getUrlImmaginiProdotto().add("images/productImages/Eileen_01.jpg");

		prodottoDao.save(cassettieraEileen);

		// PITAGORA

		Prodotto cassettieraPitagora = new Prodotto();

		cassettieraPitagora.setAmbienteProdotto("Camera da Letto");
		cassettieraPitagora.setTipoProdotto("Cassettiera");
		cassettieraPitagora.setMarcaProdotto("Novamobili");
		cassettieraPitagora.setNomeProdotto("Pitagora");
		cassettieraPitagora.getColoriProdotto().add("Marrone");
		cassettieraPitagora.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		cassettieraPitagora.setPrezzoProdotto(226.00);
		cassettieraPitagora.setMisureProdotto("110x53x76");
		cassettieraPitagora.setOffertaProdotto(false);
		cassettieraPitagora.setDescrizioneProdotto(
				"Cassettiera a quattro cassetti prevista in due misure nelle finiture ecolegno, materico e laccato opaco.");
		cassettieraPitagora.setUrlImmaginePrincipale("images/productImages/Pitagora_01.jpg");
		cassettieraPitagora.getUrlImmaginiProdotto().add("images/productImages/Pitagora_01.jpg");

		prodottoDao.save(cassettieraPitagora);

		// DOTTY

		Prodotto cassettieraDotty = new Prodotto();
		cassettieraDotty.setAmbienteProdotto("Camera da Letto");
		cassettieraDotty.setTipoProdotto("Cassettiera");
		cassettieraDotty.setMarcaProdotto("Novamobili");
		cassettieraDotty.setNomeProdotto("Dotty");
		cassettieraDotty.getColoriProdotto().add("Grigio");
		cassettieraDotty.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		cassettieraDotty.setPrezzoProdotto(497.00);
		cassettieraDotty.setMisureProdotto("130x53x72");
		cassettieraDotty.setOffertaProdotto(false);
		cassettieraDotty.setDescrizioneProdotto(
				"Cassettiera a quatto cassetti laccata opaco. I cassetti inferiori sono dotati di sistema di apertura push-pull.");
		cassettieraDotty.setUrlImmaginePrincipale("images/productImages/Dotty_01.jpg");
		cassettieraDotty.getUrlImmaginiProdotto().add("images/productImages/Dotty_01.jpg");
		prodottoDao.save(cassettieraDotty);

	}

	public void createComodini() {
		// COMODINI LEFABLIER
		// ----------------------------------------------------------

		// Samsara

		Prodotto comodinoSamsara = new Prodotto();

		comodinoSamsara.setAmbienteProdotto("Camera Da Letto");
		comodinoSamsara.setTipoProdotto("Comodino");
		comodinoSamsara.setMarcaProdotto("Le Fablier");
		comodinoSamsara.setNomeProdotto("Samsara");
		comodinoSamsara.getColoriProdotto().add("Bianco");
		comodinoSamsara.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		comodinoSamsara.setPrezzoProdotto(516.00);
		comodinoSamsara.setMisureProdotto("Misure in cm (LxPxH) 55x38x51");
		comodinoSamsara.setOffertaProdotto(false);
		comodinoSamsara.setDescrizioneProdotto("Piccolo scrigno di dettagli. Non solo comodino, "
				+ "ma emblema della ricerca della cura del dettaglio.");
		comodinoSamsara.setUrlImmaginePrincipale("images/productImages/Samsara_01.jpg");
		comodinoSamsara.getUrlImmaginiProdotto().add("images/productImages/Samsara_01.jpg");

		prodottoDao.save(comodinoSamsara);

		// Zaffiro

		Prodotto comodinoZaffiro = new Prodotto();

		comodinoZaffiro.setAmbienteProdotto("Camera Da Letto");
		comodinoZaffiro.setTipoProdotto("Comodino");
		comodinoZaffiro.setMarcaProdotto("Le Fablier");
		comodinoZaffiro.setNomeProdotto("Zaffiro");
		comodinoZaffiro.getColoriProdotto().add("Bianco");
		comodinoZaffiro.getColoriProdotto().add("Nero");
		comodinoZaffiro.getColoriProdotto().add("Rosso");
		comodinoZaffiro.getColoriProdotto().add("Marrone");
		comodinoZaffiro.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		comodinoZaffiro.setPrezzoProdotto(542.00);
		comodinoZaffiro.setMisureProdotto("Misure in cm (LxPxH) 54x35x66");
		comodinoZaffiro.setOffertaProdotto(false);
		comodinoZaffiro.setDescrizioneProdotto(
				"Comodino con tre cassetti, circondati da un’elegante " + "cornice arrotondata e dolcemente morbida. ");
		comodinoZaffiro.setUrlImmaginePrincipale("images/productImages/Zaffiro_01.jpg");
		comodinoZaffiro.getUrlImmaginiProdotto().add("images/productImages/Zaffiro_01.jpg");
		prodottoDao.save(comodinoZaffiro);

		// Giglio

		Prodotto comodinoGiglio = new Prodotto();
		comodinoGiglio.setAmbienteProdotto("Camera Da Letto");
		comodinoGiglio.setTipoProdotto("Comodino");
		comodinoGiglio.setMarcaProdotto("Le Fablier");
		comodinoGiglio.setNomeProdotto("Giglio");
		comodinoGiglio.getColoriProdotto().add("Bianco");
		comodinoGiglio.getColoriProdotto().add("Nero");
		comodinoGiglio.getColoriProdotto().add("Grigio");
		comodinoGiglio.getColoriProdotto().add("Marrone");
		comodinoGiglio.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		comodinoGiglio.setPrezzoProdotto(436.00);
		comodinoGiglio.setMisureProdotto("Misure in cm Ø42x60h");
		comodinoGiglio.setOffertaProdotto(false);
		comodinoGiglio.setDescrizioneProdotto("Giglio è un comodo tavolino rotondo con piano d’appoggio,"
				+ "la cui funzione è adattabile a diversi ambienti.");
		comodinoGiglio.setUrlImmaginePrincipale("images/productImages/Giglio_01.jpg");
		comodinoGiglio.getUrlImmaginiProdotto().add("images/productImages/Giglio_01.jpg");
		prodottoDao.save(comodinoGiglio);

		// ----------------------------------------------------------

	}

	public void createCredenze() {

		// CREDENZE LEFABLIER
		// ----------------------------------------------------------

		// Dyhana

		Prodotto credenzaDyhana = new Prodotto();
		credenzaDyhana.setAmbienteProdotto("Soggiorno");
		credenzaDyhana.setTipoProdotto("Credenza");
		credenzaDyhana.setMarcaProdotto("Le Fablier");
		credenzaDyhana.setNomeProdotto("Dyhana");
		credenzaDyhana.getColoriProdotto().add("Bianco");
		credenzaDyhana.getColoriProdotto().add("Grigio");
		credenzaDyhana.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		credenzaDyhana.setPrezzoProdotto(2156.00);
		credenzaDyhana.setMisureProdotto("Misure in cm (LxPxH) 194x50x85");
		credenzaDyhana.setOffertaProdotto(false);
		credenzaDyhana
				.setDescrizioneProdotto("Un elegante gioco di superfici rivela i cassetti centrali che racchiudono"
						+ " la sartorialità artigianale della lavorazione del rovere, così come il ricercato top"
						+ " a vassoio, il delicato profilo che abbraccia tutto il mobile e lo zoccolo con piedi");
		credenzaDyhana.setUrlImmaginePrincipale("images/productImages/Dyhana_01.jpg");
		credenzaDyhana.getUrlImmaginiProdotto().add("images/productImages/Dyhana_01.jpg");
		prodottoDao.save(credenzaDyhana);

		// Gaya

		Prodotto credenzaGaya = new Prodotto();
		credenzaGaya.setAmbienteProdotto("Soggiorno");
		credenzaGaya.setTipoProdotto("Credenza");
		credenzaGaya.setMarcaProdotto("Le Fablier");
		credenzaGaya.setNomeProdotto("Gaya");
		credenzaGaya.getColoriProdotto().add("Bianco");
		credenzaGaya.getColoriProdotto().add("Grigio");
		credenzaGaya.getColoriProdotto().add("Marrone");
		credenzaGaya.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		credenzaGaya.setPrezzoProdotto(1701.00);
		credenzaGaya.setMisureProdotto("Misure in cm (LxPxH) 182x50x85");
		credenzaGaya.setOffertaProdotto(false);
		credenzaGaya.setDescrizioneProdotto("La bellezza e l’eleganza della forma pura,"
				+ " essenziale, che mostra tutta la sua forza espressiva è il segreto della credenza Gaya.");

		credenzaGaya.setUrlImmaginePrincipale("images/productImages/Gaya_01.jpg");
		credenzaGaya.getUrlImmaginiProdotto().add("images/productImages/Gaya_01.jpg");
		credenzaGaya.getUrlImmaginiProdotto().add("images/productImages/Gaya_02.jpg");

		prodottoDao.save(credenzaGaya);

		// Clematide

		Prodotto credenzaClematide = new Prodotto();
		credenzaClematide.setAmbienteProdotto("Soggiorno");
		credenzaClematide.setTipoProdotto("Credenza");
		credenzaClematide.setMarcaProdotto("Le Fablier");
		credenzaClematide.setNomeProdotto("Clematide");
		credenzaClematide.getColoriProdotto().add("Bianco");
		credenzaClematide.getColoriProdotto().add("Grigio");
		credenzaClematide.getColoriProdotto().add("Marrone");
		credenzaClematide.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		credenzaClematide.setPrezzoProdotto(2767.00);
		credenzaClematide.setMisureProdotto("Misure in cm (LxPxH) 197x53x88");
		credenzaClematide.setOffertaProdotto(false);
		credenzaClematide.setDescrizioneProdotto("La credenza Clematide, è una credenza "
				+ "dall’aspetto rigoroso caratterizzata da una particolare anta scorrevole a pannelli in noce canaletto");
		credenzaClematide.setUrlImmaginePrincipale("images/productImages/Clematide_01.jpg");
		credenzaClematide.getUrlImmaginiProdotto().add("images/productImages/Clematide_01.jpg");
		prodottoDao.save(credenzaClematide);

	}

	public void createCucine() {

		// CUCINE LEFABLIER
		// ----------------------------------------------------------

		// Le Gemme Comp 1

		Prodotto cucina = new Prodotto();

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Le Fablier");
		cucina.setNomeProdotto("Composizione 1 - Le Gemme");
		cucina.getColoriProdotto().add("Bianco");
		cucina.getColoriProdotto().add("Grigio");
		cucina.getColoriProdotto().add("Marrone");
		cucina.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		cucina.setPrezzoProdotto(7650.00);
		cucina.setMisureProdotto("Misure in cm (LxPxH) 540x38/59x216");
		cucina.setOffertaProdotto(false);
		cucina.setDescrizioneProdotto(
				"Forme e altezze diverse vengono " + "modulate per creare una nuova idea di spazio dove la cucina "
						+ "diventa anche zona living. Il top.");
		cucina.setUrlImmaginePrincipale("images/productImages/LeGemme_01.jpg");
		cucina.getUrlImmaginiProdotto().add("images/productImages/LeGemme_01.jpg");
		cucina.getUrlImmaginiProdotto().add("images/productImages/LeGemme_02.jpg");

		prodottoDao.save(cucina);

		// I Ciliegi Comp 1

		Prodotto cucinaICigliegiComp1 = new Prodotto();

		cucinaICigliegiComp1.setAmbienteProdotto("Cucina");
		cucinaICigliegiComp1.setTipoProdotto("Cucina");
		cucinaICigliegiComp1.setMarcaProdotto("Le Fablier");
		cucinaICigliegiComp1.setNomeProdotto("Composizione 1 - I Ciliegi");
		cucinaICigliegiComp1.getColoriProdotto().add("Marrone");
		cucinaICigliegiComp1.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		cucinaICigliegiComp1.setPrezzoProdotto(5894.00);
		cucinaICigliegiComp1.setMisureProdotto("Misure in cm (LxPxH) 360x38/59x216");
		cucinaICigliegiComp1.setOffertaProdotto(false);
		cucinaICigliegiComp1.setDescrizioneProdotto("Una cucina, che nasce dal gusto "
				+ "tradizionale  di un tempo, in cui qualità e materiale " + "fanno da protagonisti.");
		cucinaICigliegiComp1.setUrlImmaginePrincipale("images/productImages/iCiliegi_01.jpg");
		cucinaICigliegiComp1.getUrlImmaginiProdotto().add("images/productImages/iCiliegi_01.jpg");
		cucinaICigliegiComp1.getUrlImmaginiProdotto().add("images/productImages/iCiliegi_02.jpg");
		cucinaICigliegiComp1.getUrlImmaginiProdotto().add("images/productImages/iCiliegi_03.jpg");

		prodottoDao.save(cucinaICigliegiComp1);

		// Melograno Comp 1

		Prodotto cucinaMelogranoComp1 = new Prodotto();

		cucinaMelogranoComp1.setAmbienteProdotto("Cucina");
		cucinaMelogranoComp1.setTipoProdotto("Cucina");
		cucinaMelogranoComp1.setMarcaProdotto("Le Fablier");
		cucinaMelogranoComp1.setNomeProdotto("Composizione 1 - Melograno");
		cucinaMelogranoComp1.getColoriProdotto().add("Marrone");
		cucinaMelogranoComp1.getColoriProdotto().add("Bianco");
		cucinaMelogranoComp1.getColoriProdotto().add("Grigio");
		cucinaMelogranoComp1.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		cucinaMelogranoComp1.setPrezzoProdotto(6419.00);
		cucinaMelogranoComp1.setMisureProdotto("Misure in cm (LxPxH) 360+90x59/38x215+35");
		cucinaMelogranoComp1.setOffertaProdotto(false);
		cucinaMelogranoComp1.setDescrizioneProdotto("Cucina Componibile. La struttura dei mobili"
				+ " e dei ripiani è realizzata con pannelli in particelle di legno"
				+ " a bassa emissione di formaldeide (classe E 1).");
		cucinaMelogranoComp1.setUrlImmaginePrincipale("images/productImages/Melograno_01.jpg");
		cucinaMelogranoComp1.getUrlImmaginiProdotto().add("images/productImages/Melograno_01.jpg");
		cucinaMelogranoComp1.getUrlImmaginiProdotto().add("images/productImages/Melograno_02.jpg");

		prodottoDao.save(cucinaMelogranoComp1);

		// ----------------------------------------------------------

		// CUCINE SCAVOLINI
		// ----------------------------------------------------------

		// Madeleine

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Scavolini");
		cucina.setNomeProdotto("Madeleiene");
		cucina.getVenditoriProdotto().add(new Venditore("marazitamobilisas@libero.it"));
		cucina.setPrezzoProdotto(8043.00);
		cucina.setMisureProdotto("270x240x254");
		cucina.setOffertaProdotto(false);
		cucina.setDescrizioneProdotto(
				"Cucina Scavolini modello Madeleine angolare in legno castagno con tavolo e n.4 sedie.\n"
						+ "N.2 pensili a vetrina, colonna frigo comprensiva di frigorifero Ariston. Lavello Franke 2 vasche in Fragranite.");
		cucina.setUrlImmaginePrincipale("images/productImages/Madeleine_01.jpg");
		cucina.getUrlImmaginiProdotto().add("images/productImages/Madeleine_01.jpg");
		prodottoDao.save(cucina);

		// Sax

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Scavolini");
		cucina.setNomeProdotto("Sax");
		cucina.getVenditoriProdotto().add(new Venditore("marazitamobilisas@libero.it"));
		cucina.setPrezzoProdotto(9500.00);
		cucina.setMisureProdotto("245x275x215");
		cucina.setOffertaProdotto(false);
		cucina.setDescrizioneProdotto(
				"La cucina ideale per chi ama l’essenzialita’ delle forme,il design semplice ed attuale. Il modello Sax appartenendo alla linea “Basic” , ha dei costi molto contenuti,pur avendo a disposizione svariate finiture e numerose varianti di colore.");
		cucina.setUrlImmaginePrincipale("images/productImages/Sax_01.jpg");
		cucina.getUrlImmaginiProdotto().add("images/productImages/Sax_01.jpg");
		prodottoDao.save(cucina);

		// Grand Relais

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Beige");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Scavolini");
		cucina.setNomeProdotto("Grand Relais");
		cucina.getVenditoriProdotto().add(new Venditore("marazitamobilisas@libero.it"));
		cucina.setPrezzoProdotto(9750.00);
		cucina.setMisureProdotto("435x225");
		cucina.setOffertaProdotto(false);
		cucina.setDescrizioneProdotto(
				"Cucina Scavolini, modello Grand Relais con ante in finitutra nera, fornita di 2 colonne estraibili da 15cm.");
		cucina.setUrlImmaginePrincipale("images/productImages/Grand_Relais_01.jpg");
		cucina.getUrlImmaginiProdotto().add("images/productImages/Grand_Relais_01.jpg");
		prodottoDao.save(cucina);

		// ----------------------------------------------------------

		// CUCINE PEDINI
		// ----------------------------------------------------------

		// Arke

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");
		cucina.getColoriProdotto().add("Grigio");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Pedini");
		cucina.setNomeProdotto("Arke");
		cucina.getVenditoriProdotto().add(new Venditore("info@confortiarredamenti.it"));
		cucina.setPrezzoProdotto(9850.00);
		cucina.setMisureProdotto("800x300cm");
		cucina.setOffertaProdotto(false);
		cucina.setDescrizioneProdotto(
				"Arke accosta alla vasta gamma di materiali, finiture e colori una varieta' di legni pregiati, per dar vita a progetti destinati all’eccellenza.");
		cucina.setUrlImmaginePrincipale("images/productImages/Arke_01.jpg");
		cucina.getUrlImmaginiProdotto().add("images/productImages/Arke_01.jpg");
		prodottoDao.save(cucina);

		// Artika

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Pedini");
		cucina.setNomeProdotto("Artika");
		cucina.getVenditoriProdotto().add(new Venditore("info@confortiarredamenti.it"));
		cucina.setPrezzoProdotto(11550.00);
		cucina.setMisureProdotto("750x250cm");
		cucina.setOffertaProdotto(false);
		cucina.setDescrizioneProdotto("Artika rappresenta una cucina completa suddivisa in due blocchi.");
		cucina.setUrlImmaginePrincipale("images/productImages/Artika_01.jpg");
		cucina.getUrlImmaginiProdotto().add("images/productImages/Artika_01.jpg");

		prodottoDao.save(cucina);

	}

	public void createCameraDaLetto() {

		// CAMERE DA LETTO GIESSEGI
		// ----------------------------------------------------------

		// New Moon

		Prodotto cameraDaLetto = new Prodotto();

		cameraDaLetto.setAmbienteProdotto("Camera da Letto");
		cameraDaLetto.setTipoProdotto("Camera da Letto");
		cameraDaLetto.setMarcaProdotto("Giessegi");
		cameraDaLetto.setNomeProdotto("New Moon");
		cameraDaLetto.getColoriProdotto().add("Bianco");
		cameraDaLetto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		cameraDaLetto.setPrezzoProdotto(4930.00);
		cameraDaLetto.setMisureProdotto("Misure in cm (LxPxH) 277x66x262");
		cameraDaLetto.setOffertaProdotto(false);
		cameraDaLetto.setDescrizioneProdotto("Camera matrimoniale completa.");
		cameraDaLetto.setUrlImmaginePrincipale("images/productImages/NewMoon_01.jpg");
		cameraDaLetto.getUrlImmaginiProdotto().add("images/productImages/NewMoon_01.jpg");
		prodottoDao.save(cameraDaLetto);

		// ----------------------------------------------------------

		// CAMERE DA LETTO DUEPI
		// ----------------------------------------------------------

		// Terra R02

		Prodotto cameraLettoTerraR02 = new Prodotto();

		cameraLettoTerraR02.setAmbienteProdotto("Camera da Letto");
		cameraLettoTerraR02.setTipoProdotto("Camera da Letto");
		cameraLettoTerraR02.setMarcaProdotto("Nardi Interni");
		cameraLettoTerraR02.setNomeProdotto("Terra R02");
		cameraLettoTerraR02.getColoriProdotto().add("Grigio");
		cameraLettoTerraR02.getColoriProdotto().add("Lilla");
		cameraLettoTerraR02.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		cameraLettoTerraR02.setPrezzoProdotto(2025.00);
		cameraLettoTerraR02.setMisureProdotto("Misure in cm (LxPxH) 168x220x92");
		cameraLettoTerraR02.setOffertaProdotto(false);
		cameraLettoTerraR02.setDescrizioneProdotto(
				"Letto matrimoniale Notturno 2 con rivestimento in tessuto e base H 25 cm con piano a doghe regolabili.");
		cameraLettoTerraR02.setUrlImmaginePrincipale("images/productImages/TerraR02_01.jpg");
		cameraLettoTerraR02.getUrlImmaginiProdotto().add("images/productImages/TerraR02_01.jpg");
		prodottoDao.save(cameraLettoTerraR02);

		// CAMERE DA LETTO NARDI INTERNI
		// ----------------------------------------------------------

		// Terra R04

		cameraDaLetto = new Prodotto();

		cameraDaLetto.setAmbienteProdotto("Camera da Letto");
		cameraDaLetto.setTipoProdotto("Camera da Letto");
		cameraDaLetto.setMarcaProdotto("Nardi Interni");
		cameraDaLetto.setNomeProdotto("Terra R04");
		cameraDaLetto.getColoriProdotto().add("Lilla");
		cameraDaLetto.getColoriProdotto().add("Grigio");
		cameraDaLetto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		cameraDaLetto.setPrezzoProdotto(3100.00);
		cameraDaLetto.setMisureProdotto("Misure in cm (LxPxH) 168x220x92");
		cameraDaLetto.setOffertaProdotto(false);
		cameraDaLetto.setDescrizioneProdotto(
				"Spazio Ragazzi è un programma completo per la cameretta, che si articola attraverso composizioni con letti a terra, soluzioni con letti inseriti fra o sotto armadi a ponte e composizioni salvaspazio.");
		cameraDaLetto.setUrlImmaginePrincipale("images/productImages/TerraR04_01.jpg");
		cameraDaLetto.getUrlImmaginiProdotto().add("images/productImages/TerraR04_01.jpg");
		prodottoDao.save(cameraDaLetto);

		// ----------------------------------------------------------

	}

	public void createLibrerie() {

		// LIBRERIE LEFABLIER
		// ----------------------------------------------------------

		// Veda

		Prodotto libreriaVeda = new Prodotto();

		libreriaVeda.setAmbienteProdotto("Studio");
		libreriaVeda.setTipoProdotto("Libreria");
		libreriaVeda.setMarcaProdotto("Le Fablier");
		libreriaVeda.setNomeProdotto("Veda");
		libreriaVeda.getColoriProdotto().add("Marrone");
		libreriaVeda.getColoriProdotto().add("Bianco");
		libreriaVeda.getColoriProdotto().add("Grigio");
		libreriaVeda.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		libreriaVeda.setPrezzoProdotto(3721.00);
		libreriaVeda.setMisureProdotto("Misure in cm (LxPxH) 147x40x199");
		libreriaVeda.setOffertaProdotto(true);
		libreriaVeda.setDescrizioneProdotto(
				"Libreria a giorno realizzata con struttura in legno massello di Rovere. Le superfici sono trattate"
						+ "con finiture speciali per esaltare la venatura del legno.");
		libreriaVeda.setUrlImmaginePrincipale("images/productImages/Veda_01.jpg");
		libreriaVeda.getUrlImmaginiProdotto().add("images/productImages/Veda_01.jpg");
		prodottoDao.save(libreriaVeda);

		// ----------------------------------------------------------

	}

	public void createIlluminazioni() {

		Prodotto prodotto = new Prodotto();

		// ILLUMINAZIONE LEFABLIER
		// ----------------------------------------------------------

		// Hari

		prodotto.getColoriProdotto().add("Nero");
		prodotto.getColoriProdotto().add("Oro");
		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Argento");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Hari");
		prodotto.setPrezzoProdotto(Double.parseDouble("774.00"));
		prodotto.setMisureProdotto("50cm x 180cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Lampada da terra e da tavolo con stelo in pirex trasparente e \r\n"
				+ "paralume in tessuto con filo e prese in coordinato con il paralume.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Hari_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Hari_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Hari_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Hari_03.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Hari_04.jpg");

		prodottoDao.save(prodotto);

		// Reishi

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Ambra");
		prodotto.getColoriProdotto().add("Blu");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Reishi");
		prodotto.setPrezzoProdotto(Double.parseDouble("363.00"));
		prodotto.setMisureProdotto("15cm x 43cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Lampada da tavolo con struttra in pirex trasparente e bicchiere interno bianco, ambra o blu.");
		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Reishi_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Reishi_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Reishi_02.jpg");
		prodottoDao.save(prodotto);

		// Zeta

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Zeta");
		prodotto.setPrezzoProdotto(Double.parseDouble("565.00"));
		prodotto.setMisureProdotto("21cm x 21cm x 52cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Lampada da comodino con struttura cromata e paralume in lino avorio.");
		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Zeta_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Zeta_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Zeta_02.jpg");
		prodottoDao.save(prodotto);

		// Miss

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Giallo");
		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Nero");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Miss");
		prodotto.setPrezzoProdotto(Double.parseDouble("857.00"));
		prodotto.setMisureProdotto("48cm x 180cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Lampada con struttura cromata e stelo sagomato in pirex trasparente e paralume liscio bianco, giallo o nero.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));

		prodotto.setUrlImmaginePrincipale("images/productImages/Miss_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Miss_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Miss_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Miss_03.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ILLUMINAZIONE ARTEMIDE
		// ----------------------------------------------------------

		// Harry H

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Argento");

		prodotto.setMarcaProdotto("Artemide");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Harry H");
		prodotto.setPrezzoProdotto(Double.parseDouble("184.00"));
		prodotto.setMisureProdotto("47cm D");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"La lampada Harry H. e' un sistema ibrido che affianca LED e OLED valorizzando i pregi delle due tecnologie e combinandoli per offrire il massimo delle performance.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/HarryH_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/HarryH_01.jpg");
		prodottoDao.save(prodotto);

		// Lana

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Artemide");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Lana");
		prodotto.setPrezzoProdotto(Double.parseDouble("127.00"));
		prodotto.setMisureProdotto("12cm x 150cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Un’innovativa ottica stampata in policarbonato trasparente permette di guidare il flusso emesso dalla sorgente LED fino alla sezione di uscita.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Lana_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Lana_01.jpg");

		prodottoDao.save(prodotto);

		// Mendori

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Artemide");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Mendori");
		prodotto.setPrezzoProdotto(Double.parseDouble("651.00"));
		prodotto.setMisureProdotto("48cm x 50cm x 44cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Lampada da tavolo Mendori con sorgente a LED 8W, 3000K dimmer. IN-EI è un serie di lampade che si declina in tre varianti: a sospensione, da tavolo, da terra.");
		prodotto.setUrlImmaginePrincipale("images/productImages/Mendori_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Mendori_01.jpg");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createBagni() {

		// BAGNI SCAVOLINI
		// ----------------------------------------------------------

		// Idro

		Prodotto bagno = new Prodotto();

		bagno.getColoriProdotto().add("Blu");

		bagno.setAmbienteProdotto("Bagno");
		bagno.setTipoProdotto("Bagno");
		bagno.setMarcaProdotto("Scavolini");
		bagno.setNomeProdotto("Idro");

		bagno.getVenditoriProdotto().add(new Venditore("marazitamobilisas@libero.it"));
		bagno.setPrezzoProdotto(7670.00);
		bagno.setMisureProdotto("200x250");
		bagno.setOffertaProdotto(false);
		bagno.setDescrizioneProdotto(
				"Questa composizione del modello idro di Scavolini Bathrooms offre la possibilità di creare eleganti soluzioni d'arredo anche per gli spazi ridotti.");
		bagno.setUrlImmaginePrincipale("images/productImages/Idro_01.jpg");
		bagno.getUrlImmaginiProdotto().add("images/productImages/Idro_01.jpg");
		prodottoDao.save(bagno);

		// Lagu

		bagno = new Prodotto();

		bagno.getColoriProdotto().add("Bianco");

		bagno.setAmbienteProdotto("Bagno");
		bagno.setTipoProdotto("Bagno");
		bagno.setMarcaProdotto("Scavolini");
		bagno.setNomeProdotto("Lagu");
		bagno.getVenditoriProdotto().add(new Venditore("marazitamobilisas@libero.it"));
		bagno.setPrezzoProdotto(4150.00);
		bagno.setMisureProdotto("275x300");
		bagno.setOffertaProdotto(false);
		bagno.setDescrizioneProdotto(
				"Composizione molto attuale e completa particolarmente adatta a bagni abbastanza stretti.");
		bagno.setUrlImmaginePrincipale("images/productImages/Lagu_01.jpg");
		bagno.getUrlImmaginiProdotto().add("images/productImages/Lagu_01.jpg");

		prodottoDao.save(bagno);

		// Rivo

		bagno = new Prodotto();

		bagno.getColoriProdotto().add("Bianco");

		bagno.setAmbienteProdotto("Bagno");
		bagno.setTipoProdotto("Bagno");
		bagno.setMarcaProdotto("Scavolini");
		bagno.setNomeProdotto("Rivo");
		bagno.getVenditoriProdotto().add(new Venditore("marazitamobilisas@libero.it"));
		bagno.setPrezzoProdotto(5845.00);
		bagno.setMisureProdotto("320x275");
		bagno.setOffertaProdotto(false);
		bagno.setDescrizioneProdotto(
				"Altissima qualità per l’arredo bagno Scavolini modello Rivo impiallacciato legno. Base lavabo impiallacciata legno laccato opaco Frassino Visone composta da due basi con cassettoni.");
		bagno.setUrlImmaginePrincipale("images/productImages/Rivo_01.jpg");
		bagno.getUrlImmaginiProdotto().add("images/productImages/Rivo_01.jpg");

		prodottoDao.save(bagno);

	}

	public void createLetti() {

		Prodotto prodotto = new Prodotto();

		// LETTI LEFABLIER
		// ----------------------------------------------------------

		// Deva

		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Deva");
		prodotto.setPrezzoProdotto(Double.parseDouble("1530.00"));
		prodotto.setMisureProdotto("173cm x 212cm x 115cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Un’elegante bordatura in Rovere massello racchiude la preziosità della ricercata imbottitura della testata del letto Deva.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));

		prodotto.setUrlImmaginePrincipale("images/productImages/Deva_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Deva_01.jpg");

		prodottoDao.save(prodotto);

		// Sunrise

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Noce");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Sunrise");
		prodotto.setPrezzoProdotto(Double.parseDouble("4775.00"));
		prodotto.setMisureProdotto("175cm x 213cm x 101cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Letto con giroletto e testata sagomata imbottiti.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Sunrise_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Sunrise_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Sunrise_02.jpg");

		prodottoDao.save(prodotto);

		// Silicio

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Nero");
		prodotto.getColoriProdotto().add("Rosso");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Silicio");
		prodotto.setPrezzoProdotto(Double.parseDouble("1814.00"));
		prodotto.setMisureProdotto("172cm x 222cm x 111cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Morbidezza e calore esprime il letto Silicio. L’ampia testiera imbottita, che può essere rivestita in tessuto, in pelle o ecopelle, \r\n"
						+ "richiama le linee morbide e delicatamente voluttuose della testata e della pediera.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Silicio_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Silicio_01.jpg");

		prodottoDao.save(prodotto);

		// Ligustro

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Marrone");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Ligustro");
		prodotto.setPrezzoProdotto(Double.parseDouble("1097.00"));
		prodotto.setMisureProdotto("175cm x 222cm x 100cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Il letto Ligustro si compone di una testiera dalla forma rettilinea e squadrata, rifinita da una sofisticata imbottitura che avvolge anche la struttura del letto.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Ligustro_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Ligustro_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Ligustro_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Ligustro_03.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// LETTI FLOU
		// ----------------------------------------------------------

		// Angle

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Beige");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Flou");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Angle");
		prodotto.setPrezzoProdotto(Double.parseDouble("2670.00"));
		prodotto.setMisureProdotto("184cm x 235cm x 130cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Letto matrimoniale Angle, previsto in versione semplice o con paravento. La testata imbottita è disponibile in versione liscia o trapuntata capitonné con rivestimento totalmente sfoderabile in tessuto o pelle.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Angle_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Angle_01.jpg");
		prodottoDao.save(prodotto);

		// Notturno

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Amaranto");

		prodotto.setMarcaProdotto("Flou");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Notturno");
		prodotto.setPrezzoProdotto(Double.parseDouble("2025.00"));
		prodotto.setMisureProdotto("168cm x 220cm x 92cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Letto matrimoniale Notturno 2 con rivestimento in tessuto e base H 25 cm con piano a doghe regolabili.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Notturno_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Notturno_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createScrivanie() {

		// SCRIVANIE LEFABLIER
		// ----------------------------------------------------------

		// Atlas

		Prodotto scrivaniaAtlas = new Prodotto();

		scrivaniaAtlas.setAmbienteProdotto("Studio");
		scrivaniaAtlas.setTipoProdotto("Scrivania");
		scrivaniaAtlas.setMarcaProdotto("Le Fablier");
		scrivaniaAtlas.setNomeProdotto("Atlas");
		scrivaniaAtlas.getColoriProdotto().add("Marrone");
		scrivaniaAtlas.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		scrivaniaAtlas.setPrezzoProdotto(3572.00);
		scrivaniaAtlas.setMisureProdotto("Misure in cm (LxPxH) 200x90x78");
		scrivaniaAtlas.setOffertaProdotto(false);
		scrivaniaAtlas.setDescrizioneProdotto("Scrivania in linea classica.");

		scrivaniaAtlas.setUrlImmaginePrincipale("images/productImages/Atlas_01.jpg");
		scrivaniaAtlas.getUrlImmaginiProdotto().add("images/productImages/Atlas_01.jpg");
		scrivaniaAtlas.getUrlImmaginiProdotto().add("images/productImages/Atlas_02.jpg");
		scrivaniaAtlas.getUrlImmaginiProdotto().add("images/productImages/Atlas_03.jpg");

		prodottoDao.save(scrivaniaAtlas);

		// Summer

		Prodotto scrivaniaSummer = new Prodotto();

		scrivaniaSummer.setAmbienteProdotto("Studio");
		scrivaniaSummer.setTipoProdotto("Scrivania");
		scrivaniaSummer.setMarcaProdotto("Le Fablier");
		scrivaniaSummer.setNomeProdotto("Summer");
		scrivaniaSummer.getColoriProdotto().add("Marrone");
		scrivaniaSummer.getColoriProdotto().add("Nero");
		scrivaniaSummer.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		scrivaniaSummer.setPrezzoProdotto(4591.00);
		scrivaniaSummer.setMisureProdotto("MMisure in cm (LxPxH) 180x87x77");
		scrivaniaSummer.setOffertaProdotto(false);
		scrivaniaSummer.setDescrizioneProdotto("Summer è una scrivania dall’aspetto scultoreo, perfetta all’interno "
				+ "dello studio in cui si mostra in tutta la sua maestosità.");

		scrivaniaSummer.setUrlImmaginePrincipale("images/productImages/Summer_01.jpg");
		scrivaniaSummer.getUrlImmaginiProdotto().add("images/productImages/Summer_01.jpg");
		scrivaniaSummer.getUrlImmaginiProdotto().add("images/productImages/Summer_02.jpg");

		prodottoDao.save(scrivaniaSummer);

		// Yoga
		Prodotto scrivaniaYoga = new Prodotto();

		scrivaniaYoga.setAmbienteProdotto("Studio");
		scrivaniaYoga.setTipoProdotto("Scrivania");
		scrivaniaYoga.setMarcaProdotto("Le Fablier");
		scrivaniaYoga.setNomeProdotto("Yoga");
		scrivaniaYoga.getColoriProdotto().add("Marrone");
		scrivaniaYoga.getColoriProdotto().add("Bianco");
		scrivaniaYoga.getColoriProdotto().add("Grigio");
		scrivaniaYoga.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		scrivaniaYoga.setPrezzoProdotto(1436.00);
		scrivaniaYoga.setMisureProdotto("Misure in cm (LxPxH) 150x70x80");
		scrivaniaYoga.setOffertaProdotto(false);
		scrivaniaYoga.setDescrizioneProdotto("Forma sinuosa e ricercata per lo scrittoio Yoga,"
				+ " che unisce la funzionalità alla ricerca estetica.");
		scrivaniaYoga.setUrlImmaginePrincipale("images/productImages/Yoga_01.jpg");
		scrivaniaYoga.getUrlImmaginiProdotto().add("images/productImages/Yoga_01.jpg");
		prodottoDao.save(scrivaniaYoga);

		// ----------------------------------------------------------

	}

	public void createSedie() {

		// SEDIE LEFABLIER
		// ----------------------------------------------------------

		// Meissa

		Prodotto sediaMeissa = new Prodotto();

		sediaMeissa.setAmbienteProdotto("Sala da Pranzo");
		sediaMeissa.setTipoProdotto("Sedia");
		sediaMeissa.setMarcaProdotto("Le Fablier");
		sediaMeissa.setNomeProdotto("Meissa");
		sediaMeissa.getColoriProdotto().add("Marrone");
		sediaMeissa.getColoriProdotto().add("Bianco");
		sediaMeissa.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		sediaMeissa.setPrezzoProdotto(345.00);
		sediaMeissa.setMisureProdotto("Misure in cm (LxPxH) 46x49x92");
		sediaMeissa.setOffertaProdotto(false);
		sediaMeissa.setDescrizioneProdotto("Sedia con seduta imbottita in tessuto o pelle.");
		sediaMeissa.setUrlImmaginePrincipale("images/productImages/Meissa_01.jpg");
		sediaMeissa.getUrlImmaginiProdotto().add("images/productImages/Meissa_01.jpg");

		prodottoDao.save(sediaMeissa);

		// Margherita

		Prodotto sediaMargherita = new Prodotto();

		sediaMargherita.setAmbienteProdotto("Sala da Pranzo");
		sediaMargherita.setTipoProdotto("Sedia");
		sediaMargherita.setMarcaProdotto("Le Fablier");
		sediaMargherita.setNomeProdotto("Margherita");
		sediaMargherita.getColoriProdotto().add("Marrone");
		sediaMargherita.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		sediaMargherita.setPrezzoProdotto(407.00);
		sediaMargherita.setMisureProdotto("Misure in cm (LxPxH) 60x53x96");
		sediaMargherita.setOffertaProdotto(false);
		sediaMargherita.setDescrizioneProdotto("Sedia capotavola con seduta imbottita rivestita in tessuto.");
		sediaMargherita.setUrlImmaginePrincipale("images/productImages/Margherita_01.jpg");
		sediaMargherita.getUrlImmaginiProdotto().add("images/productImages/Margherita_01.jpg");
		prodottoDao.save(sediaMargherita);

		// Kunti

		Prodotto sediaKunti = new Prodotto();

		sediaKunti.getColoriProdotto().add("Marrone");
		sediaKunti.getColoriProdotto().add("Bianco");
		sediaKunti.getColoriProdotto().add("Grigio");

		sediaKunti.setAmbienteProdotto("Sala da Pranzo");
		sediaKunti.setTipoProdotto("Sedia");
		sediaKunti.setMarcaProdotto("Le Fablier");
		sediaKunti.setNomeProdotto("Kunti");
		sediaKunti.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		sediaKunti.setPrezzoProdotto(1436.00);
		sediaKunti.setMisureProdotto("Misure in cm (LxPxH) 55x56x89");
		sediaKunti.setOffertaProdotto(false);
		sediaKunti.setDescrizioneProdotto("Profilo essenziale ma solido per una seduta importante.");
		sediaKunti.setUrlImmaginePrincipale("images/productImages/Kunti_01.jpg");
		sediaKunti.getUrlImmaginiProdotto().add("images/productImages/Kunti_01.jpg");
		prodottoDao.save(sediaKunti);

		// ----------------------------------------------------------

		// SEDIE LEMA
		// ----------------------------------------------------------

		// Toa

		Prodotto sedia = new Prodotto();

		sedia.setAmbienteProdotto("Soggiorno");
		sedia.setTipoProdotto("Sedia");
		sedia.setMarcaProdotto("Lema");
		sedia.setNomeProdotto("Toa");
		sedia.getColoriProdotto().add("Nero");
		sedia.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		sedia.setPrezzoProdotto(270.00);
		sedia.setMisureProdotto("Misure in cm (LxPxH) 45x51x76");
		sedia.setOffertaProdotto(false);
		sedia.setDescrizioneProdotto(
				"Sedia con struttura leggera in metallo con quattro gambe coniche a sezione quadrata a cui si abbinano seduta e schienale in materiale plastico.");
		sedia.setUrlImmaginePrincipale("images/productImages/Toa_01.jpg");
		sedia.getUrlImmaginiProdotto().add("images/productImages/Toa_01.jpg");
		prodottoDao.save(sedia);

		// FillNoir

		sedia = new Prodotto();

		sedia.setAmbienteProdotto("Soggiorno");
		sedia.setTipoProdotto("Sedia");
		sedia.setMarcaProdotto("Lema");
		sedia.setNomeProdotto("FillNoir");
		sedia.getColoriProdotto().add("Beige");
		sedia.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		sedia.setPrezzoProdotto(199.00);
		sedia.setMisureProdotto("Misure in cm (LxPxH) 58x83x50");
		sedia.setOffertaProdotto(false);
		sedia.setDescrizioneProdotto(
				"Sedia con struttura in tubolare metallico verniciato nero opaco con dettagli in metallo finitura black-nikel (anche in oro lucido e bronzo chiaro), seduta e schienali imbottiti e rivestiti in tessuto.");
		sedia.setUrlImmaginePrincipale("images/productImages/FillNoir_1.jpg");
		sedia.getUrlImmaginiProdotto().add("images/productImages/FillNoir_1.jpg");
		prodottoDao.save(sedia);

		// ----------------------------------------------------------

	}

	public void createPoltrone() {

		// POLTRONE MATERASSI
		// ----------------------------------------------------------
		// Poltrona Spazio Relax

		Prodotto poltrona = new Prodotto();

		poltrona.getColoriProdotto().add("Rossa");

		poltrona.setAmbienteProdotto("Soggiorno");
		poltrona.setTipoProdotto("Poltrona");
		poltrona.setMarcaProdotto("Materassi");
		poltrona.setNomeProdotto("Poltrona Spazio Relax");
		poltrona.setPrezzoProdotto(990.00);
		poltrona.setMisureProdotto("Misure in cm (LxPxH) 78x74x105");
		poltrona.setOffertaProdotto(false);
		poltrona.setDescrizioneProdotto(
				"Poltrona con sollevamento, dispone di due motori per muovere indipendentemente schienale e pediera.");

		poltrona.getVenditoriProdotto().add(new Venditore("info@confortiarredamenti.it"));
		poltrona.setUrlImmaginePrincipale("images/productImages/SpazioRelax_01.jpg");
		poltrona.getUrlImmaginiProdotto().add("images/productImages/SpazioRelax_01.jpg");
		prodottoDao.save(poltrona);

		// ----------------------------------------------------------

		// POLTRONE LE FABLIER
		// ----------------------------------------------------------

		// PERSICA

		Prodotto poltronaPersica = new Prodotto();

		poltronaPersica.setAmbienteProdotto("Studio");
		poltronaPersica.setTipoProdotto("Poltrona");
		poltronaPersica.setMarcaProdotto("Le Fablier");
		poltronaPersica.setNomeProdotto("Persica");
		poltronaPersica.getColoriProdotto().add("Marrone");
		poltronaPersica.getColoriProdotto().add("Bianco");
		poltronaPersica.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		poltronaPersica.setPrezzoProdotto(1004.00);
		poltronaPersica.setMisureProdotto("Misure in cm (LxPxH) 57x66x98/108");
		poltronaPersica.setOffertaProdotto(false);
		poltronaPersica.setDescrizioneProdotto("La poltrona girevole Persica, dallo spirito versatile, è un"
				+ " elemento d’arredo perfetto per l’ufficio ma anche per la casa. ");
		poltronaPersica.setUrlImmaginePrincipale("images/productImages/Persica_01.jpg");
		poltronaPersica.getUrlImmaginiProdotto().add("images/productImages/Persica_01.jpg");
		poltronaPersica.getUrlImmaginiProdotto().add("images/productImages/Persica_02.jpg");
		prodottoDao.save(poltronaPersica);

		// APOLLO

		Prodotto poltronaApollo = new Prodotto();

		poltronaApollo.setAmbienteProdotto("Salotto");
		poltronaApollo.setTipoProdotto("Poltrona");
		poltronaApollo.setMarcaProdotto("Le Fablier");
		poltronaApollo.setNomeProdotto("Apollo");
		poltronaApollo.getColoriProdotto().add("Marrone");
		poltronaApollo.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		poltronaApollo.setPrezzoProdotto(1251.00);
		poltronaApollo.setMisureProdotto("Misure in cm (LxPxH) 71x69x88");
		poltronaApollo.setOffertaProdotto(false);
		poltronaApollo.setDescrizioneProdotto(
				"Linee nette per la poltroncina Apollo, " + "un elemento d’arredo dalla forma pulita e scultorea.");
		poltronaApollo.setUrlImmaginePrincipale("images/productImages/Apollo_01.jpg");
		poltronaApollo.getUrlImmaginiProdotto().add("images/productImages/Apollo_01.jpg");
		prodottoDao.save(poltronaApollo);

		// LUNETTA

		Prodotto poltronaLunetta = new Prodotto();

		poltronaLunetta.setAmbienteProdotto("Salotto");
		poltronaLunetta.setTipoProdotto("Poltrona");
		poltronaLunetta.setMarcaProdotto("Le Fablier");
		poltronaLunetta.setNomeProdotto("Lunetta");
		poltronaLunetta.getColoriProdotto().add("Grigio");
		poltronaLunetta.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		poltronaLunetta.setPrezzoProdotto(1338.00);
		poltronaLunetta.setMisureProdotto("Misure in cm (LxPxH) 68x77x81");
		poltronaLunetta.setOffertaProdotto(false);
		poltronaLunetta.setDescrizioneProdotto("Lunetta è una comoda poltroncina" + " dallo stile contemporaneo.");
		poltronaLunetta.setUrlImmaginePrincipale("images/productImages/Lunetta_01.jpg");
		poltronaLunetta.getUrlImmaginiProdotto().add("images/productImages/Lunetta_01.jpg");
		prodottoDao.save(poltronaLunetta);

		//
		// ----------------------------------------------------------

		// POLTRONE POLTRONE E SOFA'
		// ----------------------------------------------------------
		// MEDOLLA

		Prodotto poltronaMedolla = new Prodotto();

		poltronaMedolla.setAmbienteProdotto("Soggiorno");
		poltronaMedolla.setTipoProdotto("Poltrona");
		poltronaMedolla.setMarcaProdotto("Poltrone e Sofà");
		poltronaMedolla.setNomeProdotto("Medolla");
		poltronaMedolla.getColoriProdotto().add("Marrone");
		poltronaMedolla.getColoriProdotto().add("Grigio");
		poltronaMedolla.getVenditoriProdotto().add(new Venditore("info@poltronesofarende.it"));
		poltronaMedolla.setPrezzoProdotto(1020.00);
		poltronaMedolla.setMisureProdotto("Larghezza: 84cm, Profondità:89cm, Altezza: 100cm");
		poltronaMedolla.setOffertaProdotto(false);
		poltronaMedolla
				.setDescrizioneProdotto("L'alto schienale, la seduta e il poggiareni assicurano il massimo comfort.");
		poltronaMedolla.setUrlImmaginePrincipale("images/productImages/Medolla_01.jpg");
		poltronaMedolla.getUrlImmaginiProdotto().add("images/productImages/Medolla_01.jpg");
		poltronaMedolla.getUrlImmaginiProdotto().add("images/productImages/Medolla_02.jpg");
		poltronaMedolla.getUrlImmaginiProdotto().add("images/productImages/Medolla_03.jpg");
		prodottoDao.save(poltronaMedolla);

		// POLTRONE DUEPI
		// ----------------------------------------------------------
		// CLARISSA

		Prodotto poltronaClarissa = new Prodotto();

		poltronaClarissa.setAmbienteProdotto("Soggiorno");
		poltronaClarissa.setTipoProdotto("Poltrona");
		poltronaClarissa.setMarcaProdotto("Bontempi casa");
		poltronaClarissa.setNomeProdotto("Clarissa");
		poltronaClarissa.getColoriProdotto().add("Bianco");
		poltronaClarissa.getColoriProdotto().add("Nero");
		poltronaClarissa.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		poltronaClarissa.setPrezzoProdotto(747.00);
		poltronaClarissa.setMisureProdotto("67x92x89");
		poltronaClarissa.setOffertaProdotto(false);
		poltronaClarissa.setDescrizioneProdotto(
				"Poltrona sfoderabile con struttura in acciaio laccato bianco o nero. Seduta e schienale sono imbottiti e rivestiti in pelle, ecopelle o tessuto.");
		poltronaClarissa.setUrlImmaginePrincipale("images/productImages/Clarissa_01.jpg");
		poltronaClarissa.getUrlImmaginiProdotto().add("images/productImages/Clarissa_01.jpg");
		prodottoDao.save(poltronaClarissa);

		// DAYA

		Prodotto poltronaDaya = new Prodotto();

		poltronaDaya.setAmbienteProdotto("Soggiorno");
		poltronaDaya.setTipoProdotto("Poltrona");
		poltronaDaya.setMarcaProdotto("Bontempi casa");
		poltronaDaya.setNomeProdotto("Daya");
		poltronaDaya.getColoriProdotto().add("Nero");
		poltronaDaya.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		poltronaDaya.setPrezzoProdotto(115.00);
		poltronaDaya.setMisureProdotto("80x80x90");
		poltronaDaya.setOffertaProdotto(false);
		poltronaDaya.setDescrizioneProdotto(
				"Poltrona con base centrale girevole in acciaio cromato, scocca con inserto metallico, imbottita in poliuretano flessibile.");
		poltronaDaya.setUrlImmaginePrincipale("images/productImages/Daya_01.jpg");
		poltronaDaya.getUrlImmaginiProdotto().add("images/productImages/Daya_01.jpg");
		prodottoDao.save(poltronaDaya);

	}

	public void createDivani() {
		// DIVANI LEFABLIER
		// ----------------------------------------------------------

		// ALBA

		Prodotto divanoAlba = new Prodotto();

		divanoAlba.setAmbienteProdotto("Soggiorno");
		divanoAlba.setTipoProdotto("Divano");
		divanoAlba.setMarcaProdotto("Le Fablier");
		divanoAlba.setNomeProdotto("Alba");
		divanoAlba.getColoriProdotto().add("Grigio");
		divanoAlba.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		divanoAlba.setPrezzoProdotto(6008.00);
		divanoAlba.setMisureProdotto("Misure (LxPxH) in cm 244x105x98");
		divanoAlba.setOffertaProdotto(false);
		divanoAlba.setDescrizioneProdotto("Divano in stile moderno.");
		divanoAlba.setUrlImmaginePrincipale("images/productImages/Alba_01.jpg");
		divanoAlba.getUrlImmaginiProdotto().add("images/productImages/Alba_01.jpg");
		divanoAlba.getUrlImmaginiProdotto().add("images/productImages/Alba_02.jpg");

		prodottoDao.save(divanoAlba);

		// ----------------------------------------------------------

		// DIVANI POLTRONE & SOFA'
		// ----------------------------------------------------------

		// ALBA

		Prodotto divanoAlpe = new Prodotto();

		divanoAlpe.setAmbienteProdotto("Soggiorno");
		divanoAlpe.setTipoProdotto("Divano");
		divanoAlpe.setMarcaProdotto("Poltrone & Sofà");
		divanoAlpe.setNomeProdotto("Alpe");
		divanoAlpe.getColoriProdotto().add("Grigio");
		divanoAlpe.getColoriProdotto().add("Marrone");
		divanoAlpe.getVenditoriProdotto().add(new Venditore("info@poltronesofarende.it"));
		divanoAlpe.setPrezzoProdotto(544.00);
		divanoAlpe.setMisureProdotto("Misure: Larghezza:210cm , Profondità:	96cm, Altezza:	94cm");
		divanoAlpe.setOffertaProdotto(false);
		divanoAlpe.setDescrizioneProdotto("Un divano dalle linee morbide e avvolgenti, "
				+ "ispirato nel nome alla piccola frazione in provincia di Parma.");

		divanoAlpe.setAmbienteProdotto("images/productImages/Alpe_01.jpg");
		divanoAlpe.setUrlImmaginePrincipale("images/productImages/Alpe_01.jpg");
		divanoAlpe.getUrlImmaginiProdotto().add("images/productImages/Alpe_01.jpg");
		divanoAlpe.getUrlImmaginiProdotto().add("images/productImages/Alpe_02.jpg");
		divanoAlpe.getUrlImmaginiProdotto().add("images/productImages/Alpe_03.jpg");

		prodottoDao.save(divanoAlpe);

		// ARDIANO

		Prodotto divanoArdiano = new Prodotto();

		divanoArdiano.setAmbienteProdotto("Soggiorno");
		divanoArdiano.setTipoProdotto("Divano");
		divanoArdiano.setMarcaProdotto("Poltrone & Sofà");
		divanoArdiano.setNomeProdotto("Ardiano");
		divanoArdiano.getColoriProdotto().add("Rosso");
		divanoArdiano.getVenditoriProdotto().add(new Venditore("info@poltronesofarende.it"));
		divanoArdiano.setPrezzoProdotto(99.00);
		divanoArdiano.setMisureProdotto("Misure: Larghezza:	196cm, Profondità:	89cm, Altezza:	65cm");
		divanoArdiano.setOffertaProdotto(false);
		divanoArdiano.setDescrizioneProdotto(
				"Braccioli e schienali hanno la stessa altezza in questo sofà essenziale, con un'immagine giovane ed informale, "
						+ "che appare rigoroso ma equilibrato nelle sue linee a pozzetto.");
		divanoArdiano.setUrlImmaginePrincipale("images/productImages/Ardiano_01.jpg");
		divanoArdiano.getUrlImmaginiProdotto().add("images/productImages/Ardiano_01.jpg");
		divanoArdiano.getUrlImmaginiProdotto().add("images/productImages/Ardiano_02.jpg");
		divanoArdiano.getUrlImmaginiProdotto().add("images/productImages/Ardiano_03.jpg");
		divanoArdiano.getUrlImmaginiProdotto().add("images/productImages/Ardiano_04.jpg");
		prodottoDao.save(divanoArdiano);

		// BASTIGLIA

		Prodotto divanoBastiglia = new Prodotto();

		divanoBastiglia.setAmbienteProdotto("Soggiorno");
		divanoBastiglia.setTipoProdotto("Divano");
		divanoBastiglia.setMarcaProdotto("Poltrone & Sofà");
		divanoBastiglia.setNomeProdotto("Bastiglia");
		divanoBastiglia.getColoriProdotto().add("Grigio");
		divanoBastiglia.getColoriProdotto().add("Bianco");
		divanoBastiglia.getVenditoriProdotto().add(new Venditore("info@poltronesofarende.it"));
		divanoBastiglia.setPrezzoProdotto(1056.00);
		divanoBastiglia.setMisureProdotto(" Misure: Larghezza:	248cm, Profondità:	154cm, Altezza:	100cm");
		divanoBastiglia.setOffertaProdotto(false);
		divanoBastiglia
				.setDescrizioneProdotto("Un divano dalle linee rigorose ed essenziali che prende il nome dal paesino"
						+ " in provincia di Modena, famoso per il suo santuario.");
		divanoBastiglia.setUrlImmaginePrincipale("images/productImages/Bastiglia_01.jpg");
		divanoBastiglia.getUrlImmaginiProdotto().add("images/productImages/Bastiglia_01.jpg");
		divanoBastiglia.getUrlImmaginiProdotto().add("images/productImages/Bastiglia_02.jpg");
		divanoBastiglia.getUrlImmaginiProdotto().add("images/productImages/Bastiglia_03.jpg");

		prodottoDao.save(divanoBastiglia);

		// ----------------------------------------------------------

	}

	public void createTavoli() {

		Prodotto prodotto = new Prodotto();

		// TAVOLI LEFABLIER
		// ----------------------------------------------------------

		// Ekanta

		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Ekanta");
		prodotto.setPrezzoProdotto(Double.parseDouble("1822.00"));
		prodotto.setMisureProdotto("170/210cm x 90cm x 75cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Design fluido ed armonico per il tavolo Ekanta, caratterizzato da slanciate gambe in legno massello di Rovere che, unite alla struttura del piano del tavolo, \r\n"
						+ "conferiscono alla composizione una linea morbida ed elegante.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Ekanta_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Ekanta_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Ekanta_02.jpg");
		prodottoDao.save(prodotto);

		// Tulipano

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Tulipano");
		prodotto.setPrezzoProdotto(Double.parseDouble("2042.00"));
		prodotto.setMisureProdotto("180/264cm x 90cm x 79cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Tavolo rettangolare allungabile, struttura in legno massello di ciliegio.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Tulipano_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Tulipano_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Tulipano_02.jpg");

		prodottoDao.save(prodotto);

		// Cartesio

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");
		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Cartesio");
		prodotto.setPrezzoProdotto(Double.parseDouble("1765.00"));
		prodotto.setMisureProdotto("115/200cm x 115cm x 80cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Forma quadrata e accuratezza dei dettagli rendono il tavolo Cartesio un elemento di charme che diventa protagonista in ogni ambiente.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Cartesio_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Cartesio_01.jpg");
		prodottoDao.save(prodotto);

		// Muschio

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Marrone");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Muschio");
		prodotto.setPrezzoProdotto(Double.parseDouble("1555.00"));
		prodotto.setMisureProdotto("220cm x 100cm x 75cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Tavolo fisso in rovere dalle linee calde, con dimensioni che rimandano alla lavorazione artigianale.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Muschio_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Muschio_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// TAVOLI DI LAZZARO
		// ----------------------------------------------------------

		// Open90

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Di Lazzaro");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Open90");
		prodotto.setPrezzoProdotto(Double.parseDouble("211.00"));
		prodotto.setMisureProdotto("110/150cm x 70cm x 76cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto("Tavolo allungabile.");
		prodotto.setUrlImmaginePrincipale("images/productImages/Open90_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Open90_01.jpg");

		prodotto.getVenditoriProdotto().add(new Venditore("info@confortiarredamenti.it"));

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// TAVOLI FIAM
		// ----------------------------------------------------------

		// Atlas

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Celeste");

		prodotto.setMarcaProdotto("Fiam");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Atlas");
		prodotto.setPrezzoProdotto(Double.parseDouble("12600.00"));
		prodotto.setMisureProdotto("220cm x 100cm x 74cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Tavolo con piano rettangolare in vetro temperato (spessore 20 mm) poggiante su quattro gambe realizzate con sezioni di vetro scolpite a mano e incollate una sull’altra.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));

		prodotto.setUrlImmaginePrincipale("images/productImages/AtlasTavolo_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/AtlasTavolo_01.jpg");
		prodottoDao.save(prodotto);

		// 3Pod

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Fiam");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Studio");
		prodotto.setNomeProdotto("3Pod");
		prodotto.setPrezzoProdotto(Double.parseDouble("450.00"));
		prodotto.setMisureProdotto("143cm x 140cm x 73cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"La base del tavolo 3-Pod, si ispira al classico tripode: un segno continuo in acciaio cromato che sorregge un piano (rettangolare, tondo o a goccia) in vetro, legno o laccato.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/3Ppod_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/3Ppod_01.jpg");
		prodottoDao.save(prodotto);

		// Plie

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");

		prodotto.setMarcaProdotto("Fiam");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Plie");
		prodotto.setPrezzoProdotto(Double.parseDouble("4080.00"));
		prodotto.setMisureProdotto("200cm x 100cm x 74cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Tavolo rettangolare con base in vetro fumè e piano in rovere termotrattato. Pliè è composto da due basi in vetro sagomato e curvato.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Plie_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Plie_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// TAVOLI LEMA
		// ----------------------------------------------------------

		// Thera

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");

		prodotto.setMarcaProdotto("Lema");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Thera");
		prodotto.setPrezzoProdotto(Double.parseDouble("2570.00"));
		prodotto.setMisureProdotto("180cm x 90cm x 73cm");
		prodotto.setOffertaProdotto(false);
		prodotto.setDescrizioneProdotto(
				"Tavolo allungabile Thera di Marelli e Molteni. Il piano, che parte da 180cm e raggiunge una lunghezza massima di 240cm, è sorretto da gambe posizionate obliquamente rispetto al top in modo da creare un incastro geometrico armonico.");

		prodotto.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		prodotto.setUrlImmaginePrincipale("images/productImages/Thera_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("images/productImages/Thera_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createVetrine() {

		// VETRINE LEFABLIER
		// ----------------------------------------------------------

		// AMBROSIA

		Prodotto vetrinaAmbrosia = new Prodotto();

		vetrinaAmbrosia.setAmbienteProdotto("Soggiorno");
		vetrinaAmbrosia.setTipoProdotto("Vetrina");
		vetrinaAmbrosia.setMarcaProdotto("Le Fablier");
		vetrinaAmbrosia.setNomeProdotto("Ambrosia");
		vetrinaAmbrosia.getColoriProdotto().add("Marrone");
		vetrinaAmbrosia.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		vetrinaAmbrosia.setPrezzoProdotto(1632.00);
		vetrinaAmbrosia.setMisureProdotto("Misure in cm (LxPxH) 68x45x207");
		vetrinaAmbrosia.setOffertaProdotto(true);
		vetrinaAmbrosia.setDescrizioneProdotto("Argentiera 1 anta dx/sx.");
		vetrinaAmbrosia.setUrlImmaginePrincipale("images/productImages/Ambrosia_01.jpg");
		vetrinaAmbrosia.getUrlImmaginiProdotto().add("images/productImages/Ambrosia_01.jpg");
		vetrinaAmbrosia.getUrlImmaginiProdotto().add("images/productImages/Ambrosia_02.jpg");

		prodottoDao.save(vetrinaAmbrosia);

		// BALI

		Prodotto vetrinaBali = new Prodotto();

		vetrinaBali.setAmbienteProdotto("Soggiorno");
		vetrinaBali.setTipoProdotto("Vetrina");
		vetrinaBali.setMarcaProdotto("Le Fablier");
		vetrinaBali.setNomeProdotto("Bali");
		vetrinaBali.getColoriProdotto().add("Grigio");
		vetrinaBali.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		vetrinaBali.setPrezzoProdotto(1563.00);
		vetrinaBali.setMisureProdotto("Misure in cm (LxPxH) 120x43x184");
		vetrinaBali.setOffertaProdotto(false);
		vetrinaBali.setDescrizioneProdotto(
				"Eleganza e design moderno sono" + " racchiuse nell’argentiera a due ante Bali.");

		vetrinaBali.setUrlImmaginePrincipale("images/productImages/Bali_01.jpg");
		vetrinaBali.getUrlImmaginiProdotto().add("images/productImages/Bali_01.jpg");
		prodottoDao.save(vetrinaBali);

		// ABELIA

		Prodotto vetrinaAbelia = new Prodotto();

		vetrinaAbelia.setAmbienteProdotto("Studio");
		vetrinaAbelia.setTipoProdotto("Vetrina");
		vetrinaAbelia.setMarcaProdotto("Le Fablier");
		vetrinaAbelia.setNomeProdotto("Abelia");
		vetrinaAbelia.getColoriProdotto().add("Grigio");
		vetrinaAbelia.getVenditoriProdotto().add(new Venditore("info@antonellamazzei.it"));
		vetrinaAbelia.setPrezzoProdotto(1930.00);
		vetrinaAbelia.setMisureProdotto("Misure in cm (LxPxH) 69x45x206");
		vetrinaAbelia.setOffertaProdotto(false);
		vetrinaAbelia.setDescrizioneProdotto(
				"La vetrina Abelia, è una vetrina a colonna caratterizzata da una slanciata anta, inserite"
						+ " in una elegante struttura in legno di frassino spazzolato.");
		vetrinaAbelia.setUrlImmaginePrincipale("images/productImages/Abelia_01.jpg");
		vetrinaAbelia.getUrlImmaginiProdotto().add("images/productImages/Abelia_01.jpg");
		prodottoDao.save(vetrinaAbelia);

		// ----------------------------------------------------------

		// VETRINE DUE PI
		// ----------------------------------------------------------

		// ALAMBRA

		Prodotto vetrinaAlambra = new Prodotto();

		vetrinaAlambra.setAmbienteProdotto("Soggiorno");
		vetrinaAlambra.setTipoProdotto("Vetrina");
		vetrinaAlambra.setMarcaProdotto("Lema");
		vetrinaAlambra.setNomeProdotto("Alambra");
		vetrinaAlambra.getColoriProdotto().add("Grigio");
		vetrinaAlambra.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		vetrinaAlambra.setPrezzoProdotto(3600.00);
		vetrinaAlambra.setMisureProdotto("600x500");
		vetrinaAlambra.setOffertaProdotto(false);
		vetrinaAlambra.setDescrizioneProdotto(
				" La proposta a cassetti che si caratterizza per il particolare costruttivo a coda di rondine\" e l’escluviso sistema di scorrimento invisibile.");
		vetrinaAlambra.setUrlImmaginePrincipale("images/productImages/Alambra_01.jpg");
		vetrinaAlambra.getUrlImmaginiProdotto().add("images/productImages/Alambra_01.jpg");
		prodottoDao.save(vetrinaAlambra);

		// GLANCE

		Prodotto vetrinaGlance = new Prodotto();

		vetrinaGlance.setAmbienteProdotto("Camera da Letto");
		vetrinaGlance.setTipoProdotto("Vetrina");
		vetrinaGlance.setMarcaProdotto("Lema");
		vetrinaGlance.setNomeProdotto("Glance");
		vetrinaGlance.getColoriProdotto().add("Marrone");
		vetrinaGlance.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		vetrinaGlance.setPrezzoProdotto(2500.00);
		vetrinaGlance.setMisureProdotto("120x45x170 ");
		vetrinaGlance.setOffertaProdotto(false);
		vetrinaGlance.setDescrizioneProdotto(
				" Vetrina Glance dalle linee scultoree e massicce. Il modello ha struttura in rovere termotrattato, ante in cristallo e perimetro bordato in alluminio bronzato.");
		vetrinaGlance.setUrlImmaginePrincipale("images/productImages/Glance_01.jpg");
		vetrinaGlance.getUrlImmaginiProdotto().add("images/productImages/Glance_01.jpg");
		prodottoDao.save(vetrinaGlance);

		// GALERIST

		Prodotto vetrinaGalerist = new Prodotto();

		vetrinaGalerist.setAmbienteProdotto("Soggiorno");
		vetrinaGalerist.setTipoProdotto("Vetrina");
		vetrinaGalerist.setMarcaProdotto("Lema");
		vetrinaGalerist.setNomeProdotto("Galerist");
		vetrinaGalerist.getColoriProdotto().add("Argento");
		vetrinaGalerist.getVenditoriProdotto().add(new Venditore("info@arredamentiduepi.it"));
		vetrinaGalerist.setPrezzoProdotto(6866.00);
		vetrinaGalerist.setMisureProdotto("110x250");
		vetrinaGalerist.setOffertaProdotto(false);
		vetrinaGalerist.setDescrizioneProdotto(
				" Galerist deve il suo nome al modo in cui espone gli oggetti nello spazio: una vetrina che nasce da uno stilema classico e si reinventa per diventare arredo contemporaneo e di design.");
		vetrinaGalerist.setUrlImmaginePrincipale("images/productImages/Galerist_01.jpg");
		vetrinaGalerist.getUrlImmaginiProdotto().add("images/productImages/Galerist_01.jpg");
		prodottoDao.save(vetrinaGalerist);

	}

	public void dropDataBase() {

		utilDao.dropDatabase();

	}

	public void createDataBase() {

		utilDao.createDatabase();

	}

	public DAOFactory getFactory() {
		return factory;
	}

	public void setFactory(DAOFactory factory) {
		this.factory = factory;
	}

	public ProdottoDAO getProdottoDao() {
		return prodottoDao;
	}

	public void setProdottoDao(ProdottoDAO prodottoDao) {
		this.prodottoDao = prodottoDao;
	}

	public UtenteDAO getUtenteDao() {
		return utenteDao;
	}

	public void setUtenteDao(UtenteDAO utenteDao) {
		this.utenteDao = utenteDao;
	}

	public PreventivoDAO getPreventivoDao() {
		return preventivoDao;
	}

	public void setPreventivoDao(PreventivoDAO preventivoDao) {
		this.preventivoDao = preventivoDao;
	}

	public CarrelloDAO getCarrelloDao() {
		return carrelloDao;
	}

	public void setCarrelloDao(CarrelloDAO carrelloDao) {
		this.carrelloDao = carrelloDao;
	}

	public VenditoreDAO getVenditoreDao() {
		return venditoreDao;
	}

	public void setVenditoreDao(VenditoreDAO venditoreDao) {
		this.venditoreDao = venditoreDao;
	}

	public UtilDAO getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDAO utilDao) {
		this.utilDao = utilDao;
	}

	public CommentoDAO getCommentoDao() {
		return commentoDao;
	}

	public void setCommentoDao(CommentoDAO commentoDao) {
		this.commentoDao = commentoDao;
	}

}
