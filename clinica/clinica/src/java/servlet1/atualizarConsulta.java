/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import conexao.ConectaBanco;
import dao.agenda;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.consulta;
/**
 *
 * @author alunos
 */
public class atualizarConsulta extends HttpServlet {
@Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
       out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>");
            out.println("<title>Sophistica Health - Agenda Médica</title>"); 
            out.println("<link href='agenda_medica.css' rel='stylesheet' type='text/css'/>");
            out.println("</head>");
            out.println("<body class='FundoPagina2 Texto'>");
            out.println("<p class='TituloPagina'>Atualizar Consulta</p>");
            
            try
            {
                ConectaBanco conexao = new ConectaBanco();
                agenda a = new agenda();
                
                consulta c = new consulta (
                request.getParameter("txtDiaConsulta"),
                request.getParameter("txtMesConsulta"),
                request.getParameter("txtAnoConsulta"),
                request.getParameter("txtHora"),
                request.getParameter("txtMinutos"));
                
                c.setCodigoConsulta(Integer.parseInt(request.getParameter("codigo_consulta")));
                
                if (conexao.abrirConexao())
                {
                   a.configurarConexao(conexao.obterConexao());
                   if(a.alterarRegistro(c))
                   {
                       out.println("<h2>Consulta atualizada com sucesso!</h2>");
                      out.println("<a href='index.html'>Voltar</a>");
                   }
                   else
                       out.println("<h2>Não foi possível atualizar a consulta!</h2>");
                       conexao.fecharConexao();
                      
                    
                }
                else
                    out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!</h2>");
  
            }
            catch(Exception erro)
            {
                erro.printStackTrace();
                out.println("<h2>Erro do sistema: processo de atualizar consulta!");
            }
            
            out.println("</body>");
            out.println("</html>");
        
    }

}