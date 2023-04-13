package it.beermeup.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beermeup.model.BeerDao;
import it.beermeup.model.Cart;

public class CatalogoControl extends HttpServlet {

	private static final long serialVersionUID = 6196656639099922613L;
	static BeerDao model = new BeerDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Azione richiesta
		String action = request.getParameter("action");
		
		//Recupero carrello (o creazione)
		Cart cart = (Cart)request.getSession().getAttribute("cart");
			if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		try {
			if (action != null) {
				
				//Richiesta prodotto
				if (action.equalsIgnoreCase("retrieveBeer")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
				}
				
				//Richiesta di tutti i prodotti
				else if(action.equalsIgnoreCase("retrieveAllBeers")) {
					String sort = request.getParameter("sort");
					request.removeAttribute("products");
					request.setAttribute("products", model.doRetrieveAll(sort));
				}
				
				//Aggiungi prodotto al carrello
				else if (action.equalsIgnoreCase("addToCart")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.addProduct(model.doRetrieveByKey(id));
					request.getSession().setAttribute("cart", cart);
					request.setAttribute("cart", cart);
				}
				
				//Rimozione prodotto dal carrello
				else if (action.equalsIgnoreCase("deleteFromCart")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.deleteProduct(model.doRetrieveByKey(id));
					request.getSession().setAttribute("cart", cart);
					request.setAttribute("cart", cart);
				}
			}			
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/catalogo.jsp");
		dispatcher.forward(request, response);		
	}
}
