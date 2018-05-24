package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import persistenceDAO.DAOFactory;

public class ModificaProdotto extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2192874592348038238L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idProdotto = Integer.parseInt(req.getParameter("id"));
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		Prodotto prodotto = factory.getProdottoDAO().findByPrimaryKey(idProdotto);
	
		if(prodotto.getOffertaProdotto()) {
			req.setAttribute("offertaProdotto", true);
		}
		else {
			req.setAttribute("offertaProdotto", false);
		}
		
		List<String> immaginiProdotto = factory.getProdottoDAO().getImages(idProdotto);
		
		req.setAttribute("listaImmaginiProdotto", immaginiProdotto);
		req.setAttribute("dimensioneListaImmagini", immaginiProdotto.size());
		req.setAttribute("prodotto", prodotto);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("modificaProdotto.jsp");
		dispacher.forward(req, resp);
		
		
	}

}
