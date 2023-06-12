
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar; 
import java.util.Date;
import java.sql.Time;


public class conversao {
    public Date StringToDateNascimento(String strDataNascimento)
    {
        SimpleDateFormat formatoDataNascimento=new SimpleDateFormat("dd/MM/yyyy");
        
        try 
        {
            Date dtDataNascimento = new Date(formatoDataNascimento.parse(strDataNascimento).getTime());
    
            return dtDataNascimento;
        } 
        catch (Exception erro)
        {
            erro.printStackTrace();
            return null;
        }
    }
    
public String DataInvertidaNascimento(Date dtDataNascimento)
{
    if(dtDataNascimento !=null)
    {
       int intDiaNascimento,intMesNascimento,intAnoNascimento;
       String strDataNascimento;
       Calendar calendarioNascimento = Calendar.getInstance();
       
       calendarioNascimento.setTime(dtDataNascimento);
        
       intDiaNascimento = calendarioNascimento.get(Calendar.DAY_OF_MONTH);
       intMesNascimento=calendarioNascimento.get(Calendar.MONTH)+1;
       intAnoNascimento = calendarioNascimento.get(Calendar.YEAR);

       strDataNascimento=intAnoNascimento+"/"+intMesNascimento+"/"+intDiaNascimento;
       
        return strDataNascimento;
} 
    else
return "null";

}

public String DateToStringNascimento(Date dtDataNascimento)
{
    String strDataNascimento;
    SimpleDateFormat formatoDataNascimento = new SimpleDateFormat("dd/MM/yyyy");
    

try 
{
    strDataNascimento = formatoDataNascimento.format(dtDataNascimento);
    
    return strDataNascimento;
    
} 
catch (Exception erro) 
{
    erro.printStackTrace();
    return "null";
}
}
public int DiaDataNascimento(Date dtDataNascimento)
{
    if (dtDataNascimento != null)
    {

        int intDiaNascimento; 
        Calendar calendarioNascimento = Calendar.getInstance();
        
       calendarioNascimento.setTime(dtDataNascimento); 
       intDiaNascimento = calendarioNascimento.get(Calendar.DAY_OF_MONTH);
       return intDiaNascimento;
    }
    else
    return 0;
} 
public int MesDataNascimento(Date dtDataNascimento)
{
    if (dtDataNascimento != null)
    {
        int intMesNascimento; 
        Calendar calendarioNascimento = Calendar.getInstance();
        calendarioNascimento.setTime(dtDataNascimento);
        intMesNascimento = calendarioNascimento.get(Calendar.MONTH)+1;
      
        return intMesNascimento;
    }
    else
        return 0;   
} 
public int AnoDataNascimento(Date dtDataNascimento)
{

    if (dtDataNascimento != null)
    {
        int intAnoNascimento; 
        Calendar calendarioNascimento = Calendar.getInstance();
    calendarioNascimento.setTime(dtDataNascimento); intAnoNascimento = calendarioNascimento.get(Calendar.YEAR); return intAnoNascimento;
} 
    else
return 0;

    }
    
public Date StringToDateConsulta(String strDataConsulta)
    {
        SimpleDateFormat formatoDataConsulta=new SimpleDateFormat("dd/MM/yyyy");
        
        try 
        {
            Date dtDataConsulta = new Date(formatoDataConsulta.parse(strDataConsulta).getTime());
    
            return dtDataConsulta;
        } 
        catch (Exception erro)
        {
            erro.printStackTrace();
            return null;
        }
    }
    
public String DataInvertidaConsulta(Date dtDataConsulta)
{
    if(dtDataConsulta !=null)
    {
       int intDiaConsulta,intMesConsulta,intAnoConsulta;
       String strDataConsulta;
       Calendar calendarioConsulta = Calendar.getInstance();
       
       calendarioConsulta.setTime(dtDataConsulta);
        
       intDiaConsulta = calendarioConsulta.get(Calendar.DAY_OF_MONTH);
       intMesConsulta=calendarioConsulta.get(Calendar.MONTH)+1;
       intAnoConsulta = calendarioConsulta.get(Calendar.YEAR);

       strDataConsulta=intAnoConsulta+"/"+intMesConsulta+"/"+intDiaConsulta;
       
        return strDataConsulta;
} 
    else
return "null";

}

public String DateToStringConsulta(Date dtDataConsulta)
{
    String strDataConsulta;
    SimpleDateFormat formatoDataConsulta = new SimpleDateFormat("dd/MM/yyyy");
    

try 
{
    strDataConsulta = formatoDataConsulta.format(dtDataConsulta);
    
    return strDataConsulta;
    
} 
catch (Exception erro) 
{
    erro.printStackTrace();
    return "null";
}
}
public int DiaDataConsulta(Date dtDataConsulta)
{
    if (dtDataConsulta != null)
    {

        int intDiaConsulta; 
        Calendar calendarioConsulta = Calendar.getInstance();
        
       calendarioConsulta.setTime(dtDataConsulta); 
       intDiaConsulta = calendarioConsulta.get(Calendar.DAY_OF_MONTH);
       return intDiaConsulta;
    }
    else
    return 0;
} 
public int MesDataConsulta(Date dtDataConsulta)
{
    if (dtDataConsulta != null)
    {
        int intMesConsulta; 
        Calendar calendarioConsulta = Calendar.getInstance();
        calendarioConsulta.setTime(dtDataConsulta);
        intMesConsulta = calendarioConsulta.get(Calendar.MONTH)+1;
      
        return intMesConsulta;
    }
    else
        return 0;   
} 
public int AnoDataConsulta(Date dtDataConsulta)
{

    if (dtDataConsulta != null)
    {
        int intAnoConsulta; 
        Calendar calendarioConsulta = Calendar.getInstance();
    calendarioConsulta.setTime(dtDataConsulta); intAnoConsulta = calendarioConsulta.get(Calendar.YEAR); return intAnoConsulta;
} 
    else
return 0;

    }

public int HoraConsulta(Time tmHoraConsulta)
{

    if (tmHoraConsulta != null)
    {
        int intHoraConsulta; 
        Calendar calendarioConsulta = Calendar.getInstance();
    calendarioConsulta.setTime(tmHoraConsulta); intHoraConsulta = calendarioConsulta.get(Calendar.HOUR); return intHoraConsulta;
    
} 
     else
return 0;

    }
public int MinutoConsulta(Time tmHoraConsulta)
{

    if (tmHoraConsulta != null)
    {
        int intMinutoConsulta; 
        Calendar calendarioConsulta = Calendar.getInstance();
    calendarioConsulta.setTime(tmHoraConsulta); intMinutoConsulta = calendarioConsulta.get(Calendar.MINUTE); return intMinutoConsulta;
    
} 
     else
return 0;

    }
}
