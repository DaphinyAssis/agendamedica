
package model;
import java.sql.Time;

public class consulta {
    private int codigo_consulta;
    private String nome_completo,
            numero_rg,
            telefone,
            doutor,
            especialidade,
            hora_consulta,
            minuto_consulta,
            valor_consulta,
            dia_nascimento,
            mes_nascimento,
            ano_nascimento,
            dia_consulta,
            mes_consulta,
            ano_consulta;
   

    public consulta (String dia_consulta,String mes_consulta,String ano_consulta,String hora_consulta,String minuto_consulta)
    {
        this.dia_consulta=dia_consulta;
        this.mes_consulta=mes_consulta;
        this.ano_consulta=ano_consulta;
        this.hora_consulta=hora_consulta;
        this.minuto_consulta=minuto_consulta;
    }
    
     public consulta(){
         
     }
    public consulta(String nome_completo, String numero_rg, String telefone, String doutor, String especialidade, String hora_consulta,String minuto_consulta, String valor_consulta, String dia_nascimento, String mes_nascimento, String ano_nascimento, String dia_consulta, String mes_consulta, String ano_consulta) {
        this.nome_completo = nome_completo;
        this.numero_rg = numero_rg;
        this.telefone = telefone;
        this.doutor = doutor;
        this.especialidade = especialidade;
        this.hora_consulta = hora_consulta;
        this.minuto_consulta = minuto_consulta;
        this.valor_consulta = valor_consulta;
        this.dia_nascimento = dia_nascimento;
        this.mes_nascimento = mes_nascimento;
        this.ano_nascimento = ano_nascimento;
        this.dia_consulta = dia_consulta;
        this.mes_consulta = mes_consulta;
        this.ano_consulta = ano_consulta;
    }

    

    public int getCodigoConsulta() {return codigo_consulta;}
    public void setCodigoConsulta(int codigo_consulta) {this.codigo_consulta = codigo_consulta;}

    public String getHoraConsulta() {return hora_consulta+":"+minuto_consulta;}
    public void setHoraConsulta(String hora_consulta, String minuto_consulta) 
    {
        this.hora_consulta = hora_consulta;
        this.minuto_consulta = minuto_consulta;
    }
    
    
    
    
    public String getNomeCompleto() {return nome_completo;}
    public void setNomeCompleto(String nome_completo) {this.nome_completo = nome_completo;}

    public String getNumeroRG() {return numero_rg;}
    public void setNumeroRG(String numero_rg) {this.numero_rg = numero_rg;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getDoutor() {return doutor;}
    public void setDoutor(String doutor) {this.doutor = doutor;}

    public String getEspecialidade() {return especialidade;}
    public void setEspecialidade(String especialidade) {this.especialidade = especialidade;}

    public String getValorConsulta() {return valor_consulta;}
    public void setValorConsulta(String valor_consulta) {this.valor_consulta = valor_consulta;}
       
    public String getDataNascimento(){return dia_nascimento+"/"+mes_nascimento+"/"+ano_nascimento;}
    public void setDataNascimento(String dia_nascimento, String mes_nascimento, String ano_nascimento)
    {
        this.dia_nascimento=dia_nascimento;
        this.mes_nascimento=mes_nascimento;
        this.ano_nascimento=ano_nascimento;
    }

    public String getDiaNascimento() {return dia_nascimento;}
    public String getMesNascimento() {return mes_nascimento;}
    public String getAnoNascimento() {return ano_nascimento;}
   
    public String getDataConsulta(){return dia_consulta+"/"+mes_consulta+"/"+ano_consulta;}
    public void setDataConsulta(String dia_consulta, String mes_consulta, String ano_consulta)
    {
        this.dia_consulta=dia_consulta;
        this.mes_consulta=mes_consulta;
        this.ano_consulta=ano_consulta;
    }

    public String getDiaConsulta() {return dia_consulta;}
    public String getMesConsulta() {return mes_consulta;}
    public String getAnoConsulta() {return ano_consulta;}
    
    public String getHora() {return hora_consulta;}
    public String getMinuto() {return minuto_consulta;}  
}
