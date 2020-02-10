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
import it.gestionecartellaesattorialeSpringJPA.service.CartellaEsattorialeService;

/**
 * Servlet implementation class ExecuteDeleteCartellaEsattorialeServlet
 */
@WebServlet("/ExecuteDeleteCartellaEsattorialeServlet")
public class ExecuteDeleteCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	public ExecuteDeleteCartellaEsattorialeServlet() {
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

		Long idCartellaEsattoriale = Long.parseLong(request.getParameter("idCartellaEsattoriale"));
		CartellaEsattoriale cartellaEsattoriale = cartellaEsattorialeService.caricaSingolaCartellaEsattoriale(idCartellaEsattoriale);
		cartellaEsattorialeService.rimuovi(cartellaEsattoriale);

		request.setAttribute("resultListAttr", cartellaEsattorialeService.listAllCartelleEsattorialiEager());
		request.getRequestDispatcher("/cartellaesattoriale/result.jsp").forward(request, response);
	}

}
