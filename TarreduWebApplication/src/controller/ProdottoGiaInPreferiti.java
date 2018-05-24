package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;
import persistenceDAO.UtenteDAO;

/**
 * Questa servlet ricevuti un idProdotto e una emailUtente verifica se il
 * prodotto è già presente nei preferiti dell'utente.
 */

public class ProdottoGiaInPreferiti extends HttpServlet {

	private static final long serialVersionUID = 2157518226862247516L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
		String emailUtente = req.getParameter("emailUtente");
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UtenteDAO utenteDao = factory.getUtenteDAO();
		PrintWriter out = resp.getWriter();

		if (utenteDao.giaPreferito(idProdotto, emailUtente)) {
			out.write("true");
		} else {
			out.write("false");

		}

	}

}
