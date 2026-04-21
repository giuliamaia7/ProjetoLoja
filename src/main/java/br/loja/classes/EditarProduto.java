package br.loja.classes;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditaProduto")
public class EditaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Produto> banco = (List<Produto>) getServletContext().getAttribute("banco");
		
		// Pega o produto pelo índice (id - 1)
		Produto p = banco.get(id - 1);
		
		request.setAttribute("produtoAtributo", p);
		request.setAttribute("idAtributo", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("paginas/edicao.jsp");
		rd.forward(request, response);
	}
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Produto> banco = (List<Produto>) getServletContext().getAttribute("banco");
		
		Produto p = banco.get(id - 1);
		p.setNome(request.getParameter("nome"));
		p.setCategoria(Integer.parseInt(request.getParameter("categoria")));
		p.setPreco(Float.parseFloat(request.getParameter("preco")));
		p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		
		getServletContext().setAttribute("banco", banco);
		response.sendRedirect("paginas/listagem.jsp");
	}
}






