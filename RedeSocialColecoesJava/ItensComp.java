import java.util.*;

public class ItensComp extends ItensColecionaveis
{
   private String serie;
   private String fabricante;
   private String tempoUso;
   public ItensComp(){}
   
   public ItensComp(
            double valor, String nome, String tempoUso, String origem,int quantide,String endrecoImg, 
            String estadoConservacao, String tiragens, String comentario,Date dataLancamento,String serie,String fabricante
   ){
            super(valor, nome, origem, quantide,estadoConservacao, 
            tiragens, comentario, dataLancamento, endrecoImg);
            this.serie = serie;
            this.fabricante = fabricante;
   }
   
   public void setAttDados(
            double valor, String nome, String tempoUso, String origem,int quantide,String endrecoImg, 
            String estadoConservacao, String tiragens, String comentario,Date dataLancamento,String serie,String fabricante
   ){
            super.setAttDados(valor, nome, origem, quantide,estadoConservacao, 
            tiragens, comentario, dataLancamento, endrecoImg);
            this.serie = serie;
            this.fabricante = fabricante;
            this.tempoUso = tempoUso;
   }
   
   public String getInfo(){
    return super.getInfo()+",Serie: "+serie+",Fabricante: "+fabricante+",Tepo de uso: "+tempoUso;
    }
  
   //Metodos gets ----------------------------------------------------------------------------------------------------
    public String getSerie() {
    return serie;
   }

   public String getFabricante() {
    return fabricante;
   }

   public String getTempoUso() {
    return tempoUso;
   }
   //fim metodos gets ----------------------------------------------------------------------------------------------
}
