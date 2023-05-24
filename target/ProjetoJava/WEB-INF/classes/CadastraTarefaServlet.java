package com.example.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TarefaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Connection conn;

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tarefas", "root", "senha");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera os parâmetros da requisição
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String data = request.getParameter("data");

        // Insere a tarefa no banco de dados
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tarefas (titulo, descricao, data) VALUES (?, ?, ?)");
            ps.setString(1, titulo);
            ps.setString(2, descricao);
            ps.setDate(3, java.sql.Date.valueOf(data));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Erro ao inserir a tarefa no banco de dados", e);
        }

        // Envia a resposta para o usuário
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Tarefa cadastrada com sucesso!</h2>");
        out.println("</body></html>");
    }

    public void destroy() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
        }
    }
}
