package it.gestionecartellaesattorialeSpringJPA.web.servlet.cartellaesattoriale;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale;
import it.gestionecartellaesattorialeSpringJPA.model.Contribuente;
import it.gestionecartellaesattorialeSpringJPA.service.CartellaEsattorialeService;
import it.gestionecartellaesattorialeSpringJPA.service.ContribuenteService;

/**
 * Servlet implementation class ExecuteInsertCartellaEsattorialeServlet
 */
@WebServlet("/ExecuteInsertCartellaEsattorialeServlet")
public class ExecuteInsertCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteInsertCartellaEsattorialeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at (GET): ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		String cf = request.getParameter("cfInput");
		Contribuente contribuenteAssociato = contribuenteService.trovaDaCf(cf);
		// controlla se effettivamente esiste un contribuente con il codice fiscale
		// inserito
		// dal input di cartellaEsattoriale/inserisciNuovo.jsp
		if (contribuenteAssociato == null) {
			request.setAttribute("messaggioErrore",
					"Inserimento Fallito: contribuente con codice fiscale '" + cf + "' non trovato sul sistema.");
			request.getRequestDispatcher("/cartellaesattoriale/inserisciNuovo.jsp").forward(request, response);
			return;
		}

		CartellaEsattoriale cartellaEsattoriale = new CartellaEsattoriale();
		cartellaEsattoriale.setDenominazione(request.getParameter("denominazioneInput"));
		cartellaEsattoriale.setDescrizione(request.getParameter("descrizioneInput"));
		cartellaEsattoriale.setImporto(Double.parseDouble(request.getParameter("importoInput")));
		cartellaEsattoriale.setContribuente(contribuenteAssociato);

		cartellaEsattorialeService.inserisciNuovo(cartellaEsattoriale);

		request.setAttribute("messaggioInsert", "Inserimento avvenuto con successo");
		request.getRequestDispatcher("/cartellaesattoriale/search.jsp").forward(request, response);
	}

}
