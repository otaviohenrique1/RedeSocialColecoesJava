import java.util.*;
import javax.swing.*;

public class ItensColecionaveis extends JFrame
{
   private double valor;
   private String nome;
   private String origem;
   private int quantidade;
   private String estadoConservacao;
   private String tiragens;
   private String comentario;
   private Date dataLancamento;
   private String endrecoImg; 
   private boolean ver = true;
   
   private ArrayList<Integer> curtidas = new  ArrayList<Integer>(); //guarda todas as curtidas deste item
   private ArrayList<Integer> naoCurtidas = new  ArrayList<Integer>();//guarda todas as Nao curtidas deste item
   private ArrayList<String> comentarioAmigo = new  ArrayList<String>();//guarda todos os comentarios deste item
   
   //utilisada apenas para utilizar metodos do historico n recebendo nem uma variavel
   private Historico historico = new Historico();
   private String colecao;
   ItensColecionaveis () {}
   
   //contrutor com todos os atributos de um item
   ItensColecionaveis(
          double valor, String nome, String origem,int quantidade,String estadoConservacao, 
          String tiragens, String comentario,Date dataLancamento,String endrecoImg)
   {                       
          this.valor = valor;
          this.nome = nome;
          this.origem = origem;
          this.quantidade = quantidade;
          this.estadoConservacao = estadoConservacao;
          this.tiragens = tiragens;
          this.comentario = comentario;
          this.dataLancamento = dataLancamento;
          this.endrecoImg = endrecoImg;
             }
    
   //metodo para atualizar as informações de um item
   public void setAttDados(
          double valor, String nome, String origem,int quantidade, String estadoConservacao, 
          String tiragens, String comentario,Date dataLancamento,String endrecoImg){
          this.valor = valor;
          this.nome = nome;
          this.origem = origem;
          this.quantidade = quantidade;
          this.estadoConservacao = estadoConservacao;
          this.tiragens = tiragens;
          this.comentario = comentario;
          this.dataLancamento = dataLancamento;
          this.endrecoImg = endrecoImg;
    }
    
   //retorna todas as informações de um item
   public String getInfo(){
       String x = nome+","+endrecoImg+",Valor: R$ "+valor+",Origem: "+origem+",Quantidade: "+quantidade+",Conservação: "+estadoConservacao+",Tiragem: "+tiragens+",Comentario: "+comentario+",Data de Lançmento: "+dataLancamento;
       return x;
    }
   
   //metodo set para poder ver ou n o item
   public void setVer(){
    ver = !ver;
    }
    
   // metodo para cortir um item
   public void curtir(int id){
    curtidas.add(id);
    }
    
   //Metodos gets ------------------------------------------------------------------------------------------------------------------------
   
   public String getNome(){
    return nome;
    }
    
   public double getValor() {
    return valor;
   }

    public String getOrigem() {
    return origem;
   }
   
   //retorna um array de todos q curtirão
   public ArrayList<Integer> getCurtir(){
    return curtidas;
    }
    
   //retorna somente o numero de curtidas
   public int getNumeroCurtidas(){
    return curtidas.size();
    }
    
   //retorna quem não gostou
   public ArrayList<Integer> getNaoCurtir(){
    return naoCurtidas;
    }
    
   //retorna quando não gostaram
   public int getNumeroNaoCurtidas(){
    return naoCurtidas.size();
    }
    
   //retorna um array de todos os comentario
   public ArrayList<String> getComentarioAmigo(){
    return comentarioAmigo;
    }
    
   //retorna o numero de comentarios
   public int getNumeroComentario(){
    return comentarioAmigo.size();
    }

   //retorna quando itens o cara tem
    public int getQuantidade() {
    return quantidade;
   }

    public String getEstadoConservacao() {
    return estadoConservacao;
   }

    public String getTiragens() {
    return tiragens;
   }

    public String getComentario() {
    return comentario;
   }

    public Date getDataLancamento() {
    return dataLancamento;
   }

    public String getEndrecoImg() {
    return endrecoImg;
   }
   
   public boolean getVer(){
    return ver;
    }
   //Fim metodos gets ------------------------------------------------------------------------------------------------------------------------
   
   //add Evento cadastrar ao historico
   public void addEventoCadastrar(String colecao){
    this.colecao = colecao;
    historico.addEventoCadastrar(colecao,nome);
   }
  
   //add Evento excluir ao historico
   public void addEventoExcluir(){
    historico.addEventoExcluir(colecao,nome);
   }
   
   //add Evento alterar ao historico
   public void addEventoAlterar(String colecao, String item, String novoItem){
    historico.addEventoAlterar(colecao,item,novoItem);
    }
    
   
}
