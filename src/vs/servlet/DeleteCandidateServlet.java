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
 * Servlet implementation class DeleteCandidateServlet
 */
@WebServlet(description = "删除候选人", urlPatterns = { "/servlet/DeleteCandidateServlet" })
public class DeleteCandidateServlet extends HttpServlet {
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
		userService.delCandidate(id);
		ArrayList<User> candidates = userService.getCandidates();
		ArrayList<User> others = userService.getOthers();
		request.getSession().setAttribute("candidates", candidates);
		request.getSession().setAttribute("others", others);
		request.getRequestDispatcher("/jsp/adminIndex.jsp").forward(request, response);
	}

}
