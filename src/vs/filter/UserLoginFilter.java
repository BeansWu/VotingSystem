package vs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserLoginFilter
 */
@WebFilter(
		description = "用户登录过滤器", 
		urlPatterns = { 
				"/UserLoginFilter", 
				"/*"
		}, 
		initParams = { 
				@WebInitParam(name = "noLoginPath", value = "login.jsp;LoginServlet"), 
				@WebInitParam(name = "charset", value = "utf-8")
		})
public class UserLoginFilter implements Filter {

	//初始化参数
	private FilterConfig config;
	
    /**
     * Default constructor. 
     */
    public UserLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String noLoginPath = config.getInitParameter("noLoginPath");
		String[] arr = noLoginPath.split(";");
		String uri = req.getRequestURI();
		//获取预设在初始化参数中的utf-8字符串，设置request的字符集，解决中文乱码问题
		req.setCharacterEncoding(config.getInitParameter("charset"));
		
		//通过获取预设在初始化参数中的值，来简化代码，设置初始化参数在注释中操作
		for(String s : arr){
			if(s == null || s.equals("")){
				continue;
			}
			if(uri.indexOf(s) != -1){
				chain.doFilter(request, response);
				return;
			}
		}
		/*
		if(req.getRequestURI().indexOf("userLogin.jsp")!= -1 || req.getRequestURI().indexOf("UserLogin")!= -1){
			chain.doFilter(request, response);
			return;
		}
		*/
		if(session.getAttribute("user") != null){
			chain.doFilter(request, response);
		}
		else{
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
