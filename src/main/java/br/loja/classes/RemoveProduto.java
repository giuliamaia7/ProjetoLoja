package br.loja.classes;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RemoveProduto")
public class RemoveProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public RemoveProduto() {
	        super();
	        // TODO Auto-generated constructor stub
	    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<Produto> banco = (List<Produto>) getServletContext().getAttribute("banco");
		
		if (banco != null && id > 0 && id <= banco.size()) {
			banco.remove(id-1);
			getServletContext().setAttribute("banco", banco);
		}
			
		response.sendRedirect("paginas/listagem.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}