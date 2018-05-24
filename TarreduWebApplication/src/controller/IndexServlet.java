package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProdottoConImmagini;
import model.Venditore;
import persistenceDAO.DAOFactory;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.VenditoreDAO;


/**Questa servlet reperisce tutti i contenuti necessari per 
 * creare l'homepage ( prodotti più visti, in offerta) e la restituisce.
 */



public class IndexServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("utenteLoggato")==null) {
			session.setAttribute("utenteLoggato", false);

		}
	
		List<Venditore> venditori = null;

		List<ProdottoConImmagini> prodottiInOfferta = null;
		List<ProdottoConImmagini> prodottiPiuVisti = null;

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		ProdottoDAO prodotto = factory.getProdottoDAO();
		VenditoreDAO venditore = factory.getVenditoreDAO();
		
		prodottiInOfferta = prodotto.prodottiInOfferta();
		prodottiPiuVisti = prodotto.prodottiPerVisibilità();
		venditori = venditore.findAll();
		
		session.setAttribute("listaVenditori", venditori);
		session.setAttribute("prodottiInOfferta", prodottiInOfferta);
		session.setAttribute("prodottiPiuVisti", prodottiPiuVisti);

		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/index.jsp");
		dispacher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	

}
