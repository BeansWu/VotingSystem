package vs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "用户注册", urlPatterns = { "/servlet/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	{
		userService = new UserServiceImpl();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
		String[] hobbies = request.getParameterValues("hobby");
		String introduction = request.getParameter("introduction");
		
		StringBuilder strHobbies = new StringBuilder();
		for (String hobby : hobbies) {
			strHobbies.append(hobby + ";");
		}
		User user = new User(id, name, password, sex, city, strHobbies.toString(), introduction);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (userService.register(user)) {
			//注册成功
			ArrayList<User> candidates = userService.getCandidates();
			request.getSession().setAttribute("candidates", candidates);
			request.getSession().setAttribute("user", user);
			//out.print("<script type='text/javascript'>alert('注册成功，将在5秒后跳转到欢迎页面');window.location.href='" + request.getContextPath() + "/jsp/generalIndex.jsp';</script>");
			request.getRequestDispatcher("/jsp/registerSuccess.jsp").forward(request, response);
		} else {
			//注册失败
			out.print("<script type='text/javascript'>alert('注册失败');window.location.href='" + request.getContextPath() + "/jsp/register.jsp';</script>");
		}
		
		
	}

}
