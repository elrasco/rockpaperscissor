package it.lucarasconi.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * the web gate for the game
 * @author luca.rasconi
 *
 */
public class PlayServlet extends HttpServlet {

	private static final long serialVersionUID = 2931753802360560869L;
	
	protected void doGetPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sign = req.getParameter("sign");
		RPSGameManager manager = new RPSGameManager(req.getSession().getId());
		handleAsJson(manager.play(sign), resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGetPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGetPost(req, resp);
	}
	
	public void handleAsJson(Object bean, ServletResponse response) throws IOException  {

		response.setContentType("application/json; charset=UTF-8");

		if (bean == null) {
			return;
		}
		
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bean);
		
		out.print(json);
		out.flush();
	}

}
