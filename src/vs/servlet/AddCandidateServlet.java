package vs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vs.entity.User;
import vs.service.UserService;
import vs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AddCandidateServlet
 */
@WebServlet(description = "添加候选人", urlPatterns = { "/servlet/AddCandidateServlet" })
public class AddCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	{
		userService = new UserServiceImpl();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		userService.addCandidate(id);
		ArrayList<User> candidates = userService.getCandidates();
		ArrayList<User> others = userService.getOthers();
		request.getSession().setAttribute("candidates", candidates);
		request.getSession().setAttribute("others", others);
		request.getRequestDispatcher("/jsp/adminIndex.jsp").forward(request, response);
	}

}
