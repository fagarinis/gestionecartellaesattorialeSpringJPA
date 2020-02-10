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
 * Servlet implementation class ExecuteUpdateCartellaEsattorialeServlet
 */
@WebServlet("/ExecuteUpdateCartellaEsattorialeServlet")
public class ExecuteUpdateCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;
	
	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteUpdateCartellaEsattorialeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at (get): ").append(request.getContextPath());
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

		CartellaEsattoriale o = new CartellaEsattoriale();
		o.setId(Long.parseLong(request.getParameter("idInput")));
		o.setDenominazione(request.getParameter("denominazioneInput"));
		o.setDescrizione(request.getParameter("descrizioneInput"));
		o.setImporto(Double.parseDouble(request.getParameter("importoInput")));
		
		// nel caso non sia presente un contribuente con quel cf
		String cfInput = request.getParameter("cfInput");
		Contribuente contribuenteDaAssociare = contribuenteService.trovaDaCf(cfInput);
		if (contribuenteDaAssociare == null) {
			request.setAttribute("messaggioErrore",
					"Errore: Non è presente alcun contribuente con codice fiscale " + cfInput + " sul sistema");
			
			request.setAttribute("cartellaEsattorialeAttr", cartellaEsattorialeService.caricaSingolaCartellaEsattorialeEager(o.getId()));
			request.getRequestDispatcher("/cartellaesattoriale/update.jsp").forward(request, response);
			return;
		}
		
		o.setContribuente(contribuenteDaAssociare);
		cartellaEsattorialeService.aggiorna(o);

		request.setAttribute("resultListAttr", cartellaEsattorialeService.listAllCartelleEsattorialiEager());
		request.setAttribute("messaggioUpdate", "Modifica avvenuta con successo!");

		request.getRequestDispatcher("/cartellaesattoriale/result.jsp").forward(request, response);
	}

}
