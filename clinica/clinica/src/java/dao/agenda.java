/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.text.ParseException;
import java.sql.*;
import java.util.Date; 
import model.consulta;
import util.conversao;


public class agenda {
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;
    
    public void configurarConexao(Connection conBanco) {this.conBanco=conBanco;}
    
    public boolean inserirRegistro(consulta c) throws ParseException
    {
        conversao Converter=new conversao();
        Date dtDataNascimento;
        Date dtDataConsulta;
        String strDataInvertidaNascimento,strDataInvertidaConsulta, strComandoSQL;
        
        try
        {
            dtDataNascimento=Converter.StringToDateNascimento(c.getDataNascimento());
            
            if (dtDataNascimento != null) 
              strDataInvertidaNascimento = Converter.DataInvertidaNascimento(dtDataNascimento); 
            else
                strDataInvertidaNascimento = "null";
          
          if (!(strDataInvertidaNascimento.equals("null")))
              strDataInvertidaNascimento="'"+strDataInvertidaNascimento+"'";
          
          
          dtDataConsulta=Converter.StringToDateConsulta(c.getDataConsulta());
            
            if (dtDataConsulta != null) 
              strDataInvertidaConsulta = Converter.DataInvertidaConsulta(dtDataConsulta); 
            else
                strDataInvertidaConsulta = "null";
          
          if (!(strDataInvertidaConsulta.equals("null")))
              strDataInvertidaConsulta="'"+strDataInvertidaConsulta+"'";
          
           
          
          strComandoSQL="INSERT INTO consulta(Nome_Completo,Numero_RG,Telefone,Doutor,Especialidade,Hora_Consulta,Valor_Consulta, Data_Nascimento,Data_Consulta)"+
                  "VALUES ('" + c.getNomeCompleto() + "', '" + c.getNumeroRG() + "', '" + c.getTelefone() + "', '" + c.getDoutor() + "', '" + c.getEspecialidade() + "', '" + c.getHoraConsulta() + "', '"+ c.getValorConsulta() + "', " + strDataInvertidaNascimento + ", " + strDataInvertidaConsulta + ")";
          psComando=conBanco.prepareStatement(strComandoSQL);
          psComando.executeUpdate();
          
          
          return true;
        }
        catch(SQLException erro)
        {
            return false;
        }
    }
    public int localizarRegistro(String strCampo,String strValor)
    {
        int intCodigoConsulta=0;
        String strComandoSQL;
        
        try
        {
            if (strCampo.equals("NOME"))
            {
                strComandoSQL = "SELECT Codigo_Consulta FROM consulta WHERE Nome_Completo='"+strValor+"'";
                psComando=conBanco.prepareStatement(strComandoSQL);
               rsRegistros = psComando.executeQuery(); rsRegistros.next();
                intCodigoConsulta = rsRegistros.getInt("Codigo_Consulta");
            }
            else{
            strComandoSQL="SELECT Codigo_Consulta FROM consulta WHERE Numero_RG='"+strValor+"'";
               psComando=conBanco.prepareStatement(strComandoSQL);
               rsRegistros = psComando.executeQuery(); rsRegistros.next();
                intCodigoConsulta = rsRegistros.getInt("Codigo_Consulta");
            }
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
            
        }
        return intCodigoConsulta;
    }
    public ResultSet lerRegistro(int intCodigoConsulta)
    {
        String strComandoSQL;
        
        try{
            strComandoSQL="SELECT * FROM consulta WHERE Codigo_Consulta="+intCodigoConsulta;
            
            psComando=conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery(); 
            rsRegistros.next();
            
            return rsRegistros;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
            return null;
        }
    }    
    
    public boolean alterarRegistro(consulta c)
    {
        conversao Converter=new conversao();
        Date dtDataConsulta;
        String strDataInvertidaConsulta,strComandoSQL;
        
        try
        {
    
            dtDataConsulta = Converter.StringToDateConsulta(c.getDataConsulta());
            
            if (dtDataConsulta != null) 
                strDataInvertidaConsulta = Converter.DataInvertidaConsulta(dtDataConsulta); 
                else
                    strDataInvertidaConsulta = "null"; 
            
            if (!(strDataInvertidaConsulta.equals("null")))
                strDataInvertidaConsulta="'"+strDataInvertidaConsulta+"'";
           
            
        
            strComandoSQL = "UPDATE consulta SET Data_Consulta = " + strDataInvertidaConsulta + ", Hora_Consulta = '" + c.getHoraConsulta() + "' WHERE Codigo_Consulta = " + c.getCodigoConsulta();

            psComando=conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            
            return true;    
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
            return false;
        }
    }
    
    public boolean excluirRegistro(int intCodigoConsulta)
    {
        String strComandoSQL;
        
        try
        {
            strComandoSQL="DELETE FROM consulta WHERE Codigo_Consulta="+intCodigoConsulta;
            psComando=conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            
            return true;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
            return false;
        }     
    }
    public ResultSet listarRegistros()
    {
        String strComandoSQL;
        
        try
        {
            strComandoSQL="SELECT * FROM consulta ORDER BY Nome_Completo";
            
            psComando=conBanco.prepareStatement(strComandoSQL);
            rsRegistros=psComando.executeQuery();
            return rsRegistros;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
            return null;
        }
    }
}
