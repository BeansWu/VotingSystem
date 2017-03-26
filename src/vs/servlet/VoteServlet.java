package vs.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import vs.entity.User;
import vs.service.UserService;
import vs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet(description = "用户投票", urlPatterns = { "/servlet/VoteServlet" })
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserService userService = null;
	{
		userService = new UserServiceImpl();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	protected void getAllCandidates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> candidates = userService.getCandidates();
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(candidates);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(result);
	}
	protected void vote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		userService.vote(id);
		ArrayList<User> candidates = userService.getCandidates();
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(candidates);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(result);
	}
}
