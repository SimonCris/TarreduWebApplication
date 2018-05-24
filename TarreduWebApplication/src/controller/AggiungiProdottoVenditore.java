package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Prodotto;
import model.Venditore;
import persistenceDAO.DAOFactory;

/**
 * Servlet implementation class CambiaAvatar
 */

public class AggiungiProdottoVenditore extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Prodotto p = new Prodotto();
		PrintWriter out = response.getWriter();
		String emailVenditore = (String) request.getSession().getAttribute("emailVenditoreLoggato");
		
		ServletContext sc = request.getSession().getServletContext();

		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("Nothing to upload");
			return;
		}
		FileItemFactory itemfactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemfactory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {

				Integer numeroImmagini = 0;

				if (!item.isFormField()) {
					if(!item.getName().equals("")) {
						

					String urlImmagine = "images/productImages/" + item.getFieldName() + "_" + item.getName();

					if (numeroImmagini == 0) {
						p.setUrlImmaginePrincipale(urlImmagine);
						p.getUrlImmaginiProdotto().add(urlImmagine);
						numeroImmagini++;
					} else {
						p.getUrlImmaginiProdotto().add(urlImmagine);
						numeroImmagini++;
					}

					File savedFile = new File(
							sc.getRealPath("") + "/images/productImages/" + item.getFieldName() + "_" + item.getName());

					item.write(savedFile);
					}

				} else {
					p.setValue(item.getFieldName(), item.getString());

				}

			}

			if (p.getOffertaProdotto() == null) {
				p.setOffertaProdotto(false);
				// Si veda lo switch di Prodotto.java per
				// il caso TRUE

			}

			// Aggiungo il venditore
			p.getVenditoriProdotto().add(new Venditore(emailVenditore));


			// CHIAMO IL DAO PER SALVARE IL PRODOTTO

			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			factory.getProdottoDAO().save(p);

		} catch (FileUploadException e) {
			out.write("cant upload");
			out.write(e.getMessage());
			out.write("<br>");

		} catch (Exception ex) {

			out.write("eccezione");
			out.write(ex.getMessage());
			out.write("<br>");

		}
		
		response.sendRedirect("profiloVenditore");

	}

}