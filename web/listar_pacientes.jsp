

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Date"%>
<jsp:useBean id="conexao" scope="page" class="conexao.ConectaBanco"/>
<jsp:useBean id="a" scope="page" class="dao.agenda"/>
<jsp:useBean id="converter" scope="page" class="util.conversao"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sophistica Health - Agenda Médica</title>
        <link href="agenda_medica.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="FundoPagina2 Texto">
        <br><br><br><br><br><br>
        <div class="CaixaTransparente">
        <%
            ResultSet rsRegistros;
            
            if(conexao.abrirConexao())
            {
            a.configurarConexao(conexao.obterConexao());
            
            rsRegistros=a.listarRegistros();
            
            if(rsRegistros!=null)
            {
            
            out.println("<p class='TituloPagina'>Lista de Consultas</p>");
            out.println("<br>");
            out.println("<table align='center' bgcolor='white'>");
            out.println("<tr><th>Nome</th><th>Telefone</th><th>Data</th><th>Hora</th><th>Doutor</th></tr>");
            
            while(rsRegistros.next())
            {
            out.print("<tr>");
            out.print("<td>"+rsRegistros.getString("Nome_Completo")+"</td>");
            out.print("<td>"+rsRegistros.getString("Telefone")+"</td>");
            out.print("<td>"+converter.DateToStringConsulta(rsRegistros.getDate("Data_Consulta"))+"</td>");
            out.print("<td>"+rsRegistros.getString("Hora_Consulta")+"</td>");
            out.print("<td>"+rsRegistros.getString("Doutor")+"</td>");
            out.print("</tr>");
        }
        out.println("</table>");
        out.println("<br>");
            
        }
        else
        out.println("<p>Falha na exebição dos registros!</p>");
        
        conexao.fecharConexao();
        }
        else
        out.println("<p>Falha na conexão com o banco de dados!</p>");
        %>
           <a class="LinkVoltar button" href="javascript:history.back()">Voltar</a>
    </body>
</html>
