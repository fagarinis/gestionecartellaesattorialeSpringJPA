package it.gestionecartellaesattorialeSpringJPA.web.servlet.contribuente;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestionecartellaesattorialeSpringJPA.model.Contribuente;
import it.gestionecartellaesattorialeSpringJPA.service.ContribuenteService;

/**
 * Servlet implementation class ExecuteUpdateContribuenteServlet
 */
@WebServlet("/ExecuteUpdateContribuenteServlet")
public class ExecuteUpdateContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	public ExecuteUpdateContribuenteServlet() {
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

		Contribuente o = new Contribuente();
		o.setId(Long.parseLong(request.getParameter("idInput")));
		o.setNome(request.getParameter("nomeInput"));
		o.setCognome(request.getParameter("cognomeInput"));
		o.setCf(request.getParameter("cfInput"));
		o.setIndirizzo(request.getParameter("indirizzoInput"));

		// nel caso sia gia' presente un contribuente con lo stesso codice fiscale con
		// id diverso
		Contribuente contribuenteConStessoCodiceFiscale = contribuenteService.trovaDaCf(o.getCf());
		if (contribuenteConStessoCodiceFiscale != null && contribuenteConStessoCodiceFiscale.getId() != o.getId()) {
			request.setAttribute("messaggioErrore",
					"Errore: Un contribuente con codice fiscale " + o.getCf() + " è già presente sul sistema");
			request.setAttribute("contribuenteAttr", o);
			request.getRequestDispatcher("/contribuente/update.jsp").forward(request, response);
			return;
		}

		contribuenteService.aggiorna(o);

		request.setAttribute("resultListAttr", contribuenteService.listAllContribuenti());
		request.setAttribute("messaggioUpdate", "Modifica avvenuta con successo!");

		request.getRequestDispatcher("/contribuente/result.jsp").forward(request, response);
	}

}
