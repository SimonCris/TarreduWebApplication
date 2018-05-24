package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;

public class RimuoviImmagineProdotto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3699714486231592807L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String urlImmagine = req.getParameter("urlImmagine");
		Integer idProdotto = Integer.parseInt(req.getParameter("idProdotto"));

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		PrintWriter writer = resp.getWriter();
		ServletContext sc = req.getSession().getServletContext();

		String url = sc.getRealPath("") + "/" + urlImmagine;

		if (factory.getProdottoDAO().deleteImage(idProdotto, urlImmagine).equals(true)) {
			File file = new File(url);

			if (file.exists())
				file.delete();

			writer.write("true");
			
		} else
			writer.write("false");

	}

}
