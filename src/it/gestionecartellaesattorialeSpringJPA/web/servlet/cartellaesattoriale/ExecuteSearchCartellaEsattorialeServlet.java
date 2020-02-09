package it.gestionecartellaesattorialeSpringJPA.web.servlet.cartellaesattoriale;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ExecuteSearchCartellaEsattorialeServlet
 */
@WebServlet("/ExecuteSearchCartellaEsattorialeServlet")
public class ExecuteSearchCartellaEsattorialeServlet extends HttpServlet {
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
	public ExecuteSearchCartellaEsattorialeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		CartellaEsattoriale cartellaEsattoriale = new CartellaEsattoriale();
		cartellaEsattoriale.setDenominazione(request.getParameter("denominazioneInput"));
		cartellaEsattoriale.setDescrizione(request.getParameter("descrizioneInput"));
		try {
			cartellaEsattoriale.setImporto(Double.parseDouble(request.getParameter("importoInput")));
		} catch (NumberFormatException e) {
		}

		String cf = request.getParameter("cfInput");
		Contribuente contribuenteAssociato = contribuenteService.trovaDaCf(cf);
		if (cf != "" && contribuenteAssociato == null) {
			request.setAttribute("messaggioErrore", "Errore: contribuente con codice fiscale " + cf
					+ " non presente nel sistema, svuotare il campo di ricerca o inserire un codice fiscale valido");
			request.getRequestDispatcher("/cartellaesattoriale/search.jsp").forward(request, response);
			return;
		}

		cartellaEsattoriale.setContribuente(contribuenteAssociato);

		List<CartellaEsattoriale> resultListAttr = cartellaEsattorialeService.findByExampleEager(cartellaEsattoriale);

		request.setAttribute("resultListAttr", resultListAttr);
		request.getRequestDispatcher("/cartellaesattoriale/result.jsp").forward(request, response);
	}

}
