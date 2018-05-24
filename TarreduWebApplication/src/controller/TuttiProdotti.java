package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoConImmagini;
import persistenceDAO.DAOFactory;

/**
 * Questa servlet prende tutti i prodotti presenti sul db e genera la pagina
 * corrispondente.
 */

public class TuttiProdotti extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> marcheProdotti = new ArrayList<>();
		List<String> ambientiProdotti = new ArrayList<>();

		String stileView = req.getParameter("stile");

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		List<ProdottoConImmagini> prodotti = factory.getProdottoDAO().findAllProductWithImages();

		req.setAttribute("prodotti", prodotti);

		marcheProdotti = factory.getProdottoDAO().getTutteLeMarche();
		req.setAttribute("marcheProdotti", marcheProdotti);
		req.setAttribute("ambientiProdotti", ambientiProdotti);

		if (stileView.equals("grid")) {
			RequestDispatcher dispacher = req.getRequestDispatcher("prodotti.jsp");
			dispacher.forward(req, resp);
		} else {

			RequestDispatcher dispacher = req.getRequestDispatcher("listaProdotti.jsp");
			dispacher.forward(req, resp);

		}

	}

}
