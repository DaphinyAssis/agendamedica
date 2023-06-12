/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet1;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author alunos
 */
import conexao.ConectaBanco;
import dao.agenda;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import util.conversao;

public class pesquisarPaciente extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
    ResultSet rsRegistro;
    PrintWriter out;
    String strOpcaoPesquisa,strNome,strRG,strCampoPesquisa,strValorPesquisa,strDataConsulta,strDataNascimento;
    int intCodigoConsulta;
    conversao Converter =new conversao();
    
    strOpcaoPesquisa=request.getParameter("rbOpcaoPesquisa");
    strNome=request.getParameter("txtNomePaciente");
    strRG=request.getParameter("txtRG");
    
    if(strOpcaoPesquisa.equals("Nome"))
    {
        strCampoPesquisa="NOME";
        strValorPesquisa=strNome;
    }
    else
    {
        strCampoPesquisa="RG";
        strValorPesquisa=strRG;
    }
    response.setContentType("text/html;charset=UTF-8");
    out=response.getWriter();
    
     out.println("<!DOCTYPE html>");
     out.println("<html>");
     out.println("<head>");
     out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
     out.println("<title>Sophistica Health - Agendar Consulta</title>"); 
     out.println("<link href='agenda_medica.css' rel='stylesheet' type='text/css'/>");
     out.println("</head>");
     out.println("<body class='FundoPagina2 Texto'>");
     out.println("<br><br><br><br><br><br>");
     out.println("<p class='TituloPagina'>Pesquisar Paciente</p>");
     
     try
     {
         ConectaBanco conexao=new ConectaBanco();
         agenda a = new agenda();
         
         if(conexao.abrirConexao())
         {
             a.configurarConexao(conexao.obterConexao());
             
             intCodigoConsulta=a.localizarRegistro(strCampoPesquisa,strValorPesquisa);
             
             if(intCodigoConsulta!=0)
             {
                 rsRegistro=a.lerRegistro(intCodigoConsulta);
                 strDataConsulta=Converter.DateToStringConsulta(rsRegistro.getDate("Data_Consulta"));
                 strDataNascimento=Converter.DateToStringNascimento(rsRegistro.getDate("Data_Nascimento"));
                 
                 out.println("Nome do Paciente: "+rsRegistro.getString("Nome_Completo")+"<br>");
                 out.println("<br>");
                 out.println("Data de nascimento: "+strDataNascimento+"<br>");
                 out.println("<br>");
                 out.println("RG:"+rsRegistro.getString("Numero_RG")+"<br>");
                 out.println("<br>");
                 out.println("Telefone: "+rsRegistro.getString("Telefone")+"<br>");
                 out.println("<br>");
                 out.println("Data da Consulta: "+strDataConsulta+"<br>");
                 out.println("<br>");
                 out.println("Hora da Consulta: "+rsRegistro.getString("Hora_Consulta")+"<br>");
                 out.println("<br>");
                 out.println("Doutor: "+rsRegistro.getString("Doutor")+"<br>");
                 out.println("<br>");
                 out.println("Especialidade: "+rsRegistro.getString("Especialidade")+"<br>");
                 out.println("<br>");
                 out.println("Valor da Consulta: "+rsRegistro.getString("Valor_Consulta")+"<br>");
                 out.println("<br><br>");
                 out.println("<a href='editar_consulta.jsp?codigo_consulta="+intCodigoConsulta+"'>[Editar]</a> <a href='excluir_consulta.jsp?codigo_consulta="+intCodigoConsulta+"'>[Excluir]</a>");
                 out.println("<span class='LinkVoltar'><a href='javascript:history.back()'>[Voltar]</a></p>");
             }
             conexao.fecharConexao();
         }
         else
             out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!</h2>");
     }
     catch (Exception erro)
     {
         erro.printStackTrace();
         out.println("<h2>Erro do sistema: processo de agendar consulta!</h2>");
     }
     out.println("</body>");
     out.println("</html>");
}
}
