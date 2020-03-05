
import java.util.*;
import java.text.*;

public class Historico
{
  private static ArrayList<String> Geral = new ArrayList <String>();
  
  private static ArrayList<ArrayList> Usuario = new ArrayList<>(); 
  private static ArrayList<String> nome = new ArrayList<>(); 
  
  private static ArrayList<Integer> fotoAllUser = new ArrayList<>();
  
  private static int indice;
  private ArrayList<String> historico = new ArrayList<String>(); 

  //Metodos Construtores
  Historico(){}
  Historico(String nome){this.nome.add(nome); Usuario.add(historico); }
  
  //passa um novo nome caso o usuario o altere
  public void setNome(int pos, String novoNome){
    nome.set(pos, novoNome);
    }
  
  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<-Adiciona diferentes tipos de eventos ao historico->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  
  //Add o evento Cadastrar
  public void addEventoCadastrar(String colecao, String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" cadastrou na coleção<br>"+colecao+" o item "+"'"
    +item+"'");
   Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" cadastrou na coleção<br>"+colecao+" o item "+"'"
    +item+"'");
   fotoAllUser.add(indice);
 }
   
  //Add o evento Excluir
  public void addEventoExcluir(String colecao, String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" removeu da coleção<br>"+colecao+" o item "+"'"
    +item+"'");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" removeu da coleção<br>"+colecao+" o item "+"'"
    +item+"'");
    fotoAllUser.add(indice);
 }
  
  //Add o evento Adicionar Coleção
  public void addEventoIncluirColecao(String colecao){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Adicionou uma nova <br>coleção '"+colecao+"'");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Adicionou uma nova <br>coleção '"+colecao+"'");
    fotoAllUser.add(indice);
 }
 
  //Add o evento Alterar
  public void addEventoAlterar(String colecao, String item, String novoItem){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    if(!item.equals(novoItem)){
        Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Alterou o item '"+item+"'<br>da coleção '"+colecao+"'"+
        " para '"+novoItem+"'");
   
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Alterou o item '"+item+"'<br>da coleção '"+colecao+"'"+
        " para '"+novoItem+"'");
      fotoAllUser.add(indice);
    }
    else{
        Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Alterou informações do iten <br>'"+item+"' da coleção '"+colecao+"'");
   
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Alterou informações do iten <br>'"+item+"' da coleção '"+colecao+"'");
   fotoAllUser.add(indice);    
   }
    }  
   
  //Add o evento UntoDeletar
  public void addEventoUndoDeletar(String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Excluir, Retornando o '"+item+"'");
   Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Excluir, Retornando o '"+item+"'");    
   fotoAllUser.add(indice);
 }
  
  //Add o evento UntoCadastrar
  public void addEventoUndoCadastrar(String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Cadastrar, execluido o item '"+item+"'");
   Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Cadastrar, execluido o item '"+item+"'");
   fotoAllUser.add(indice);
 }
  
  //Add o evento UntoAlterar
  public void addEventoUndoAlterar(String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Alterar referente ao item '"+item+"'");
    
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Alterar referente ao item '"+item+"'");
   fotoAllUser.add(indice);
 }
   
  //Add o evento UndoAddColecao
  public void addEventoUndoAddColecao(String colecao){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Adicionar Coleção apagando '"+colecao+"'");
     Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Defez uma ação <br>Adicionar Coleção apagando '"+colecao+"'");
   fotoAllUser.add(indice);
 }
 
   //historico do Redu *********************************************************************************
   
  //Add o evento ReduDeletar
  public void addEventoReduDeletar(String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Excluindo o '"+item+"'");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Excluindo o '"+item+"'");
   fotoAllUser.add(indice); 
 }
  
  //Add o evento ReduCadastrar
  public void addEventoReduCadastrar(String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Re-cadastrando o item '"+item+"'");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Re-cadastrando o item '"+item+"'");
   fotoAllUser.add(indice);
 }
  
  //Add o evento ReduAlterar
  public void addEventoReduAlterar(String item){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Alterar referente ao item '"+item+"'");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Alterar referente ao item '"+item+"'");
     fotoAllUser.add(indice);  
 }
   
  //Add o evento ReduAddColecao
  public void addEventoReduAddColecao(String colecao){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Re-Adicionando a Coleção '"+colecao+"'");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Refez uma ação <br>Re-Adicionando a Coleção '"+colecao+"'");
   fotoAllUser.add(indice); 
 }
   
  //add o evento AlterarDadosCliente
  public void addEventoAlteraDadosCliente(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Alterou seus dados pessoais");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Alterou seus dados pessoais");
   fotoAllUser.add(indice); 
 }
 
 //add o evento nova Amizade
  public void addEventoNovaAmizade(String novoAmigo){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setLenient(false);
    Usuario.get(indice).add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+" Adicionou "+novoAmigo+" a sua lista <br>a sua lista de amigos");
    Geral.add("<html>"+sdf.format(new Date())+" "+nome.get(indice)+"  Adicionou "+novoAmigo+" a sua lista <br>a sua lista de amigos");
    fotoAllUser.add(indice); 
 }
  
  //Retorna o historico para ser impreço ao usuario
  public ArrayList getHistorico(int pos){
    return Usuario.get(pos);
    }
  
  //passa um novo indice para um historico de um usuario diferente
  public void setIndice(int pos){
    indice = pos;
    }
   
    // metodo que mostra historico geral
    public ArrayList getHistoricoGeral (){
        return Geral;
  }
 
  //retorna a foto do usuario q fez alguma ção
  public int fotoUser(int pos){
    return fotoAllUser.get(pos);
    }
    
  //retorna  array com todas as fotos paralelas ao historico geral
  public ArrayList<Integer> getIndiceTodasFotos(){
    return fotoAllUser;
    }  
}