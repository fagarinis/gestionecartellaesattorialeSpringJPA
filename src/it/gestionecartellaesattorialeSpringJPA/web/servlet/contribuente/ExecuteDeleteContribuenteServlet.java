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
 * Servlet implementation class ExecuteDeleteContribuenteServlet
 */
@WebServlet("/ExecuteDeleteContribuenteServlet")
public class ExecuteDeleteContribuenteServlet extends HttpServlet {
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
	public ExecuteDeleteContribuenteServlet() {
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

		Long idContribuente = Long.parseLong(request.getParameter("idContribuente"));
		Contribuente contribuente = contribuenteService.caricaSingoloContribuente(idContribuente);
		contribuenteService.rimuovi(contribuente);

		request.setAttribute("messaggioDelete", "Cancellazione avvenuta con successo");
		request.setAttribute("resultListAttr", contribuenteService.listAllContribuenti());
		request.getRequestDispatcher("/contribuente/result.jsp").forward(request, response);

	}

}
