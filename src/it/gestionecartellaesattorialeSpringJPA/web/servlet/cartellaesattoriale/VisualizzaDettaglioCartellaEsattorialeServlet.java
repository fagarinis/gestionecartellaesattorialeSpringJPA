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
 * Servlet implementation class VisualizzaDettaglioCartellaEsattorialeServlet
 */
@WebServlet("/VisualizzaDettaglioCartellaEsattorialeServlet")
public class VisualizzaDettaglioCartellaEsattorialeServlet extends HttpServlet {
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
	public VisualizzaDettaglioCartellaEsattorialeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		Long idCartellaEsattoriale = Long.parseLong(request.getParameter("idCartellaEsattoriale"));
		CartellaEsattoriale cartellaEsattoriale = cartellaEsattorialeService.caricaSingolaCartellaEsattorialeEager(idCartellaEsattoriale);

		request.setAttribute("cartellaEsattorialeAttr", cartellaEsattoriale);

		request.getRequestDispatcher("/cartellaesattoriale/dettaglio.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
