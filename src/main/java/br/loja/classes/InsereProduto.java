package br.loja.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsereProduto")
public class InsereProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int categoria = Integer.parseInt(request.getParameter("categoria")); 
		float preco = Float.parseFloat(request.getParameter("preco"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		
		List<Produto> bancoProdutos = (List<Produto>) getServletContext().getAttribute("banco");
		
		if (bancoProdutos == null) {
			bancoProdutos = new ArrayList<Produto>();
		}
		
		Produto novo_produto = new Produto();
		novo_produto.setNome(nome);
		novo_produto.setCategoria(categoria);
		novo_produto.setPreco(preco);
		novo_produto.setQuantidade(quantidade);
		
		bancoProdutos.add(novo_produto);
		getServletContext().setAttribute("banco", bancoProdutos);
		
		response.sendRedirect("paginas/listagem.jsp");
	}
}