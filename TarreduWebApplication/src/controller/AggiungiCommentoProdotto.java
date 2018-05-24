package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.Commento;
import persistenceDAO.DAOFactory;


/**
 * Questa servlet riceve un oggetto di tipo JSON contenente 
 * Un commento relativo ad un prodotto, la sua valutazione ( da 1 a 5), 
 * e ovviamente l'id del prodotto e l'email dell'utente che effettua
 * la recensione. Si occupa poi di salvare tutto sul db.
 */

public class AggiungiCommentoProdotto extends HttpServlet{


	private static final long serialVersionUID = -1920482527706105632L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StringBuffer jsonReceived = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));		
		String line = reader.readLine();
		while (line != null){
			jsonReceived.append(line);
			line = reader.readLine();
		}		
		
		JSONObject json;
		Commento commento = new Commento();
		try {
			
			json = new JSONObject(jsonReceived.toString());
			
			commento.setIdProdotto((json.getInt("idProdotto")));
			commento.setEmailUtente((json.getString("emailUtente")));
			commento.setCommento((json.getString("recensioneVal")));
			commento.setValutazione((json.getInt("valutazione")));
			
			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			factory.getCommentoDAO().save(commento);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
