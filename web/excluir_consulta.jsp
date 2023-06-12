
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Time"%>
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
        <br><br><br><br><br><br>
         <div class="CaixaTransparente">
        <%
            ResultSet rsRegistro;
            Time tmHoraConsulta;
            Date dtDataNascimento, dtDataConsulta;
            int intDiaNascimento, intMesNascimento, intAnoNascimento, intDiaConsulta, intMesConsulta,intAnoConsulta, intHoraConsulta, intMinutoConsulta;
            boolean blnConectado;
            
            consulta c =new consulta();
            int intCodigoConsulta = Integer.parseInt(request.getParameter("codigo_consulta"));
            blnConectado=false;
            
if (conexao.abrirConexao())
{
a.configurarConexao(conexao.obterConexao());

rsRegistro=a.lerRegistro(intCodigoConsulta);

dtDataNascimento=rsRegistro.getDate("Data_Nascimento");

intDiaNascimento=converter.DiaDataNascimento(dtDataNascimento);
intMesNascimento=converter.MesDataNascimento(dtDataNascimento);
intAnoNascimento=converter.AnoDataNascimento(dtDataNascimento);

dtDataConsulta=rsRegistro.getDate("Data_Consulta");

intDiaConsulta=converter.DiaDataConsulta(dtDataConsulta);
intMesConsulta=converter.MesDataConsulta(dtDataConsulta);
intAnoConsulta=converter.AnoDataConsulta(dtDataConsulta);

tmHoraConsulta=rsRegistro.getTime("Hora_Consulta");
            
intHoraConsulta=converter.HoraConsulta(tmHoraConsulta);
intMinutoConsulta=converter.MinutoConsulta(tmHoraConsulta);
        
           

c.setNomeCompleto(rsRegistro.getString("Nome_Completo"));
c.setNumeroRG(rsRegistro.getString("Numero_RG"));
c.setTelefone(rsRegistro.getString("Telefone"));
c.setDoutor(rsRegistro.getString("Doutor"));
c.setEspecialidade(rsRegistro.getString("Especialidade"));
c.setValorConsulta(rsRegistro.getString("Valor_Consulta"));
c.setDataNascimento(Integer.toString(intDiaNascimento),Integer.toString(intMesNascimento),Integer.toString(intAnoNascimento));
c.setDataConsulta(Integer.toString(intDiaConsulta),Integer.toString(intMesConsulta),Integer.toString(intAnoConsulta));
c.setHoraConsulta(Integer.toString(intHoraConsulta),Integer.toString(intMinutoConsulta));
conexao.fecharConexao();
blnConectado=true;
        }
        else
        out.println("<p class='Texto'>Falha na conexão com o banco de dados!</p>");
        
        %>
        
        <% if (blnConectado) {%>
        <p class="TituloPagina">Desmarcar Consulta</p>
        
        <form name="formDesmarcaConsulta" method="post" action="desmarcarConsulta" target="_parent">
            <p>Nome do Paciente: <%=c.getNomeCompleto()%></p>
            <p>Data de nascimento (dd/mm/aaaa): <%=c.getDiaNascimento()%>/<%=c.getMesNascimento()%>/<%=c.getAnoNascimento()%></p>
            <p>Número do RG: <%=c.getNumeroRG()%></p>
            <p>Telefone: <%=c.getTelefone()%></p>
            <p>Data da Consulta (dd/mm/aaaa): <%=c.getDiaConsulta()%>/<%=c.getMesConsulta()%>/<%=c.getAnoConsulta()%></p>
            <p>Hora da Consulta (hora:min): <%=c.getHora()%>:<%=c.getMinuto()%></p>
            <p>Doutor: <%=c.getDoutor()%></p>
            <p>Especialidade: <%=c.getEspecialidade()%></p>
            <p>Valor da Consulta: R$ <%=c.getValorConsulta()%></p>
            
            <p>
                <input type="hidden" name="codigo_consulta" value="<%=intCodigoConsulta%>">
            </p>
            <br>
           <input type="submit" name="btnExcluir" value="Excluir" class="Texto button" />
           <a class="LinkVoltar button" href="javascript:history.back()">Voltar</a>
            </p>
        </form>
<%}%>
    </body>
</html>

    
