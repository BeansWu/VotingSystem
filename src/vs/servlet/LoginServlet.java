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
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "用户登陆", urlPatterns = { "/servlet/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserService userService = null;
	{
		userService = new UserServiceImpl();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "";
		String password = "";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		id = request.getParameter("id");
		password = request.getParameter("password");
		int result = userService.userLoginCheck(id, password);
		if (result >= 0) {
			//用户存在
			if (result > 0) {
				//密码正确
				User user = userService.getUser(id);
				request.getSession().setAttribute("user", user);
				if (result > 1) {
					//管理员
					ArrayList<User> candidates = userService.getCandidates();
					ArrayList<User> others = userService.getOthers();
					request.getSession().setAttribute("candidates", candidates);
					request.getSession().setAttribute("others", others);
					request.getRequestDispatcher("/jsp/adminIndex.jsp").forward(request, response);
				} else {
					//普通用户
					ArrayList<User> candidates = userService.getCandidates();
					request.getSession().setAttribute("candidates", candidates);
					request.getRequestDispatcher("/jsp/generalIndex.jsp").forward(request, response);
				}
			} else {
				//密码错误
				out.print("<script type='text/javascript'>alert('密码错误');window.location.href='" + request.getContextPath() + "/jsp/login.jsp';</script>");
			}
		} else {
			//用户不存在
			out.print("<script type='text/javascript'>alert('用户不存在');window.location.href='" + request.getContextPath() + "/jsp/login.jsp';</script>");
		}
	}
}
