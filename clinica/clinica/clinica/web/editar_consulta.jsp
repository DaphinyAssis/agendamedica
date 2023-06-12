
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.consulta"%>
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
        <br><br><br><br><br><br><br>
        <div class="CaixaTransparente">
        <%
            ResultSet rsRegistro;
            Time tmHoraConsulta;
            int intHoraConsulta, intMinutoConsulta;
            Date dtDataConsulta;
            int intDiaConsulta,intMesConsulta,intAnoConsulta;
            boolean blnConectado;
            
            consulta c =new consulta();
            int intCodigoConsulta = Integer.parseInt(request.getParameter("codigo_consulta"));
            blnConectado=false;
            
            if(conexao.abrirConexao())
            {
            a.configurarConexao(conexao.obterConexao());
            
            rsRegistro=a.lerRegistro(intCodigoConsulta);
            
            dtDataConsulta=rsRegistro.getDate("Data_Consulta");
            
            intDiaConsulta=converter.DiaDataConsulta(dtDataConsulta);
            intMesConsulta=converter.MesDataConsulta(dtDataConsulta);
            intAnoConsulta=converter.AnoDataConsulta(dtDataConsulta);
            
            c.setDataConsulta(Integer.toString(intDiaConsulta),Integer.toString(intMesConsulta),Integer.toString(intAnoConsulta));

            tmHoraConsulta=rsRegistro.getTime("Hora_Consulta");
            
            intHoraConsulta=converter.HoraConsulta(tmHoraConsulta);
            intMinutoConsulta=converter.MinutoConsulta(tmHoraConsulta);
        
            c.setHoraConsulta(Integer.toString(intHoraConsulta),Integer.toString(intMinutoConsulta));
            
            conexao.fecharConexao();
            blnConectado=true;
        }
        else
       
        out.println("<p>Falha na conexão com o banco de dados!</p>");
        
        %>
        
        <% if (blnConectado){ %>
       
        <p class="TituloPagina">Editar Consulta</p>
        
        <form name="formEditaConsulta" method="post" action="atualizarConsulta" target="_parent">
            <p>Data da Consulta (dd/mm/aaaa):
                <input type="text" name="txtDiaConsulta" size="2" maxlength="2" 
                       value="<%=c.getDiaConsulta()%>"/>/
                <input type="text" name="txtMesConsulta" size="2" maxlength="2" 
                       value="<%=c.getMesConsulta()%>"/>/
                <input type="text" name="txtAnoConsulta" size="4" maxlength="4" 
                       value="<%=c.getAnoConsulta()%>"/>
            </p>
            <p>Hora da Consulta (hora:min)
                <input type="text" name="txtHora" size="2" maxlength="2"
                       value="<%=c.getHora()%>"/>:
                <input type="text" name="txtMinutos" size="2" maxlength="2"
                       value="<%=c.getMinuto()%>"/>
            </p>
            <p>
                <input type="hidden" name="codigo_consulta" value="<%=intCodigoConsulta%>">
            </p>
            <br>
            <input type="submit" name="btnAtualizar" value="Atualizar" class="Texto button" />
               <a class="LinkVoltar button" href="javascript:history.back()">Voltar</a>
            </p>
    </form>
         <%}%>     
    </body>
</html>
