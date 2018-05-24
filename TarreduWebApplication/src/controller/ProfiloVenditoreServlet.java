package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Preventivo;
import model.ProdottoConImmagini;
import model.Venditore;
import persistenceDAO.DAOFactory;

public class ProfiloVenditoreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String emailVenditore = (String) req.getSession().getAttribute("emailVenditoreLoggato");

		Venditore venditore = new Venditore();

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		venditore = factory.getVenditoreDAO().findByPrimaryKey(emailVenditore);
		req.setAttribute("venditore", venditore);

		List<ProdottoConImmagini> prodottiDelVenditore = factory.getProdottoDAO()
				.findProductsByVenditoreProdottoConImmagini(emailVenditore);
		req.setAttribute("prodottiDelVenditore", prodottiDelVenditore);

		List<Preventivo> listaPreventivi = factory.getVenditoreDAO().getPreventiviVenditore(emailVenditore);
		req.setAttribute("listaPreventivi", listaPreventivi);
	
		

		RequestDispatcher dispacher = req.getRequestDispatcher("profiloVenditore.jsp");
		dispacher.forward(req, resp);

	}

}
