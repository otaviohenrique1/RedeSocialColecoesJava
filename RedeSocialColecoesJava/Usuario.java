import java.lang.reflect.Method;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class Usuario
{
  /** atributos do usuario */
  private String nome;
  private String dataNasc;
  private String cidade = "------";
  private String estado = "------";
  private String relacionamento = "Solteiro";
  private String login;
  private String senha;
  private ArrayList<Colecao> colecao = new ArrayList<Colecao>(); 
  private String email;
  private String sexo;
  private String endFoto;
  private int id;
  private Historico historico;
  
  //atributos de configuraçoes no sistema
  private boolean guardaUndo = true;
  private int numeroAtt = 10;
  private int quemPodeVer = 1;//varia entre 2 - todos, 1 amigos, 0 ninguem
  
  // --------------------------------- Atributos unto -----------------------------------
  private ArrayList<String> ultimaAcao = new ArrayList<String>();
  private ArrayList<Object> item = new ArrayList<Object>();
  private ArrayList<Integer> ultimaColecao = new ArrayList<Integer>();
  private ArrayList<Integer> posicaoIten = new ArrayList<Integer>();
  //-------------------------------------------------------------------------------------
  // --------------------------------- Atributos redu -----------------------------------
  private ArrayList<String> reduAcao = new ArrayList<String>();
  private ArrayList<Object> reduitem = new ArrayList<Object>();
  private ArrayList<Integer> reduUltimaColecao = new ArrayList<Integer>();
  private ArrayList<Integer> reduPosicaoIten = new ArrayList<Integer>();
  private ArrayList<String> reduColecao = new ArrayList<String>();
  //-------------------------------------------------------------------------------------
  
  
  //cria um usuario-------------------------------------------------------------
  Usuario (String nome, String dataNasc, String endereco, String login,String senha,String email, String sexo,int indice){
     this.nome     = nome;
     this.dataNasc = dataNasc;
     this.cidade = endereco;
     this.login    = login;
     this.senha    = senha;
     this.email    = email;
     this.sexo     = sexo;
     this.id = indice;
     endFoto ="img/usuario1.jpg";
     historico = new Historico(nome);
     Grafos grafo = new Grafos();
     grafo.novoUsuario(); //parte importanticima para o grafos 
     //isto espande o grafos para cada novo usuario
  }
  
  Usuario (){}
  
  //Atualiza dados de um usuario-------------------------------------------------------------
  public void setUsuario(String nome, String dataNasc, String endereco, String login,String senha,String email, String sexo){
     this.nome=nome;
     this.dataNasc=dataNasc;
     this.cidade=endereco;
     this.login=login;
     this.senha=senha;
     this.email=email;
     this.sexo=sexo;
  }
  
  //Atualiza dados de um usuario ***************************************************
  public void updateData(String nome, String sexo, String email, String dataNasc,String cidade,String estado,String rela, String login,int i){
    this.nome     = nome;
    this.dataNasc = dataNasc;
    this.email    = email;
    this.sexo     = sexo;
    this.cidade   = cidade;
    this.estado   = estado;
    this.relacionamento = rela;
    this.login    = login;
    historico.addEventoAlteraDadosCliente();
    historico.setNome(i,this.nome);
    }
  
  //ronova a configuração referente a guardar 
  public void setGuardaUndo(boolean x){
    guardaUndo = x;
    }
  
  //atualiza a senha
  public void setSenha(String senha){
   this.senha = senha;  
    }
    
  //atualiza quem pode ver seus itens
  public void setQuemVe(int quem){
   this.quemPodeVer = quem; 
    }
    
  //atualiza o numero de evento a aparecer na tela  
  public void setNumeroAtt(int n){
    numeroAtt = n;
    }  
    
  //Cria uma Coleção-------------------------------------------------------------
  public void setColecao(String nome){
    Colecao x = new Colecao(nome);
    colecao.add(x);
    ultimaAcao.add("Nova Colecao");
    ultimaColecao.add(colecao.size()-1);
    item.add(null);
    posicaoIten.add(0);
    zeraRedu();
  }
  
  //Apaga um item da coleção caso for nula
  public void verifica(int pos){
    if(colecao.size() != 0){
    if(colecao.get(pos).verifica()){
     decremento();
    }}
        }
  
  //traz o array contento todas as inforções-------------------------------------------------------------
  public ArrayList getColecao(){
    return colecao;
    }
  
  //traz o nome da coleção-------------------------------------------------------------
  public String getNomeColecao(int pos){
    return colecao.get(pos).getNomeColecao();
    }
  
  //Adiciona um novo item a coleção-------------------------------------------------------------
  public void addNovo(int pos){
      colecao.get(pos).addNovo();
      ultimaAcao.add("Adicionou");
      ultimaColecao.add(pos);
      item.add(getItem(pos,getTamanho(ultimaColecao.get(ultimaColecao.size()-1))-1));
      posicaoIten.add(getTamanho(ultimaColecao.get(ultimaColecao.size()-1))-1);
      zeraRedu();
    }
    
  //retorna as coleçoes ja criadas-------------------------------------------------------------
  public ArrayList getTodasColecoes(){
    ArrayList<String> todas = new ArrayList<String>();
    if(colecao.size() != 0){for(int i=0;i<colecao.size();i++){
     todas.add(getNomeColecao(i));
    }}
    return todas;
    }
  
  //retorna o numero de intes de uma coleção-------------------------------------------------------------
  public int getTamanho(int pos){
    return colecao.get(pos).getTamanho();
    }
    
  //retorna a soma de todos os itens de todas as coelções
  public int getSomaTodosItens(){
   int total =0;
   for(int i=0;i<colecao.size();i++){
      total += getTamanho(i);
    }
   return total;
    }
  
  //retorna todos os itens em um arry de uma coleção
  public ArrayList getItens(int pos){
    ArrayList<String> lista = new ArrayList<String>();
    lista.clear();
    for(int i=0;i<colecao.get(pos).getTamanho();i++){
     lista.add(colecao.get(pos).getInfo(i));
    }
    return lista;
    }
 
  //atualiza a foto
  public void setEndFoto(String endFoto){
      this.endFoto = endFoto;
  }
   
  /** Metodos gets ------------------------------------------------------------- */
  public boolean getVer(int pos, int pos2){
    return colecao.get(pos).getVer(pos2);
    }
  
  public int getQuemVe(){
    return quemPodeVer;
    }  
    
  public ArrayList<Integer> getUltimaColecao(){
    return ultimaColecao;
    }
    
  public String getLogin(){
      return this.login;
  }
  
  public String getSenha(){
      return this.senha;
  }
  
  public String getNome(){
      return this.nome;
  }
  
  public String getCidade(){
      return this.cidade;
  }
  
   public String getEstado(){
      return this.estado;
  }
  
  public String getRelacionamento(){
      return this.relacionamento;
  }
  
  public String getEmail(){
    return email;
    }
    
  public String getNascimento(){
    return dataNasc;
    }
    
  public String getSexo(){
    return sexo;
    }
    
  public String getEndFoto(){
      return endFoto;
  }
  
  public boolean getGuardaUndo(){
    return guardaUndo;
    }
  
  public int getNumeroAtt(){
    return numeroAtt;
    }
  
  /** fim metodos gets ----------------------------------------------------------- */
  
  //metodo para alterar
  public void atualizarDados(int pos, int pos2){
    item.add(colecao.get(pos).clonarItem(pos2)); //pega o item q esta sendo alterado e o passa para o obejto
    ultimaAcao.add("Alterar");
    ultimaColecao.add(pos);
    posicaoIten.add(pos2);
    colecao.get(pos).atualizarDados(pos2);
    zeraRedu();
    }
  
  //Retorna um item para manipulação
  public Object getItem(int pos,int pos2){
      return colecao.get(pos).getItem(pos2);
    }
    
  //adiciona um elemento de um outro usuario
  public void setItem(int pos,Object elemento){
        colecao.get(pos).setItem(elemento);
    }
  
  //adiciona um elemento na posição apagada
  public void setItem(int pos,Object elemento,int pos2){
        colecao.get(pos).setItem(elemento,pos2);
    }
  
  //Remove um item da lista pasando a colecao e a posição do item
  public void delete(int pos,int pos2){colecao.get(pos).delete(pos2);}
  public void deleteSemHistorico(int pos,int pos2){colecao.get(pos).deletar(pos2);}
  
  //Remove o item e o guarda o undo
  public void deleteGuarda(int pos,int pos2){
      item.add(getItem(pos,pos2)); //pega o item q esta sendo alterado e o passa para o obejto
      ultimaAcao.add("deletar");
      ultimaColecao.add(pos);
      posicaoIten.add(pos2);
      delete(pos,pos2);
      zeraRedu();
    }
   
  //Ação para o untu funcionar
  public void undo(){
    if(ultimaAcao.size() == 0){
     JOptionPane.showMessageDialog(null,"Você não pode voltar mais ações");
    }
     else if(ultimaAcao.get(ultimaAcao.size()-1).equals("deletar")){
     setItem(ultimaColecao.get(ultimaColecao.size()-1),item.get(item.size()-1),posicaoIten.get(posicaoIten.size()-1));
     historico.addEventoUndoDeletar(getNomeIten());
     JOptionPane.showMessageDialog(null,"Você retornou o ultimo item '"+getNomeIten()+"' deletado!");
     undoPassaRedu("");
     decremento();
    }
    else if(ultimaAcao.get(ultimaAcao.size()-1).equals("Alterar")){
     JOptionPane.showMessageDialog(null,"Você desfez a ultima alteração referente ao item '"+getNomeIten()+"'!");
     historico.addEventoUndoAlterar(getNomeIten());
     Object x = colecao.get(ultimaColecao.get(ultimaColecao.size()-1)).clonarItem(posicaoIten.get(posicaoIten.size()-1));//clona para o redu
     undoVoltar(posicaoIten.get(posicaoIten.size()-1));
     item.set((item.size()-1),x);
     undoPassaRedu("");
     decremento();
    }
    else if(ultimaAcao.get(ultimaAcao.size()-1).equals("Adicionou")){
     JOptionPane.showMessageDialog(null,"Você apagou o ultimo item cadastrado '"+getNomeIten()+"'!");
     historico.addEventoUndoCadastrar(getNomeIten());
     Object x = colecao.get(ultimaColecao.get(ultimaColecao.size()-1)).clonarItem(getTamanho(ultimaColecao.get(ultimaColecao.size()-1))-1);//clona para o redu
     deleteSemHistorico(ultimaColecao.get(ultimaColecao.size()-1),(getTamanho(ultimaColecao.get(ultimaColecao.size()-1))-1)); 
     item.set((item.size()-1),x);
     undoPassaRedu("");
     decremento(); 
    }
    else{
      int temp = ultimaColecao.get(ultimaColecao.size()-1);
      JOptionPane.showMessageDialog(null,"Você apagou a ultima Coleção Adicionada '"+getNomeColecao(temp)+"'");
      undoPassaRedu(getNomeColecao(temp));
      decremento();
      historico.addEventoUndoAddColecao(getNomeColecao(temp));
      colecao.remove(temp);
    }
    }
  
  //redu -------------------
  public void redu(){
    if(reduAcao.size() == 0){
     JOptionPane.showMessageDialog(null,"Você não pode refazer mais ações");
    }
     else if(reduAcao.get(reduAcao.size()-1).equals("deletar")){
     JOptionPane.showMessageDialog(null,"Você refez a ação deletando o item '"+getNomeItenRedu()+"'!");
     historico.addEventoReduDeletar(getNomeItenRedu());
     deleteSemHistorico(reduUltimaColecao.get(reduUltimaColecao.size()-1),reduPosicaoIten.get(reduPosicaoIten.size()-1)); 
     reduPassaUnto();
     decrementoRedu();
    }
    else if(reduAcao.get(reduAcao.size()-1).equals("Alterar")){
     JOptionPane.showMessageDialog(null,"Você refez a alteração no item '"+getNomeItenRedu()+"'!");
     historico.addEventoReduAlterar(getNomeItenRedu());
     Object x = colecao.get(reduUltimaColecao.get(reduUltimaColecao.size()-1)).clonarItem(reduPosicaoIten.get(reduPosicaoIten.size()-1));//clona para o redu
     reduVoltar(reduPosicaoIten.get(reduPosicaoIten.size()-1));
     reduitem.set(reduitem.size()-1,x);
     reduPassaUnto();
     decrementoRedu();
    }
    else if(reduAcao.get(reduAcao.size()-1).equals("Adicionou")){
     setItem(reduUltimaColecao.get(reduUltimaColecao.size()-1),reduitem.get(reduitem.size()-1),reduPosicaoIten.get(reduPosicaoIten.size()-1));
     JOptionPane.showMessageDialog(null,"Você refez a ação re-cadastrando o item '"+getNomeItenRedu()+"'!");
     historico.addEventoReduCadastrar(getNomeItenRedu());
     reduPassaUnto();
     decrementoRedu();
    }
    else{
     int temp = reduUltimaColecao.get(reduUltimaColecao.size()-1);
     JOptionPane.showMessageDialog(null,"Você refez a ultima Coleção apagada");
     Colecao x = new Colecao(reduColecao.get(reduColecao.size()-1));
     colecao.add(x);
     historico.addEventoReduAddColecao(getNomeColecao(temp));
     reduPassaUnto();
     decrementoRedu();
    }
    }
  
   //Executa o reflection q traz o nome do item para o unto
   public String getNomeIten(){
     return colecao.get(ultimaColecao.get(ultimaColecao.size()-1)).getNomeIten(posicaoIten.get(posicaoIten.size()-1));
    }
   
   //Executa o reflection q traz o nome do item para o redu
   public String getNomeItenRedu(){
     return colecao.get(reduUltimaColecao.get(reduUltimaColecao.size()-1)).getNomeIten(reduPosicaoIten.get(reduPosicaoIten.size()-1));
    }
    
  //efetua a função de retornar uma alteração(undo)
  public void undoVoltar(int pos){
     colecao.get(ultimaColecao.get(ultimaColecao.size()-1)).undoVoltar(pos,item.get(item.size()-1));
    }  
    
  //efetua a função de refazer uma alteração(redu)
  public void reduVoltar(int pos){
     colecao.get(reduUltimaColecao.get(reduUltimaColecao.size()-1)).undoVoltar(pos,reduitem.get(reduitem.size()-1));
    }  
  
    //Decrementa todos o valores referente ao unto
  public void decremento(){
    item.remove(item.size()-1);
    ultimaAcao.remove(ultimaAcao.size()-1);
    int temp1 = ultimaColecao.size()-1;
    ultimaColecao.remove(temp1);
    int temp2 = posicaoIten.size()-1;
    posicaoIten.remove(temp2);
    //System.out.println(item.toString()+"\n"+ultimaAcao.toString()+"\n"+ultimaColecao.toString()+"\n"+posicaoIten.toString()+"\n \n");
    }
  
  //passa dados do unto para o redu
  public void reduPassaUnto(){
    item.add(reduitem.get(reduitem.size()-1));
    ultimaAcao.add(reduAcao.get(reduAcao.size()-1));
    int temp1 = reduUltimaColecao.size()-1;
    ultimaColecao.add(reduUltimaColecao.get(temp1));
    int temp2 = reduPosicaoIten.size()-1;
    posicaoIten.add(reduPosicaoIten.get(temp2));
    }
    
    
    //passa dados do unto para o redu
  public void undoPassaRedu(String nomeColecao){
    reduitem.add(item.get(item.size()-1));
    reduAcao.add(ultimaAcao.get(ultimaAcao.size()-1));
    int temp1 = ultimaColecao.size()-1;
    reduUltimaColecao.add(ultimaColecao.get(temp1));
    int temp2 = posicaoIten.size()-1;
    reduPosicaoIten.add(posicaoIten.get(temp2));
    reduColecao.add(nomeColecao);
    }
    
     //Decrementa todos o valores referente ao redu
  public void decrementoRedu(){
    reduitem.remove(reduitem.size()-1);
    reduAcao.remove(reduAcao.size()-1);
    int temp1 = reduUltimaColecao.size()-1;
    reduUltimaColecao.remove(temp1);
    int temp2 = reduPosicaoIten.size()-1;
    reduPosicaoIten.remove(temp2);
    reduColecao.remove(reduColecao.size()-1);
    //System.out.println(item.toString()+"\n"+ultimaAcao.toString()+"\n"+ultimaColecao.toString()+"\n"+posicaoIten.toString()+"\n \n");
    }
  
  //apaga os valores do unto caso usuario faça qual quer alteração
  public void zeraUndo(){
    item.clear();
    ultimaAcao.clear();
    ultimaColecao.clear();
    posicaoIten.clear();
    }
    
  //apaga os valores do redu caso usuario faça qual quer alteração
  public void zeraRedu(){
    reduitem.clear();
    reduAcao.clear();
    reduUltimaColecao.clear();
    reduPosicaoIten.clear();
    reduColecao.clear();
    }
    
  //Retorna um historico
   public ArrayList getHistorico(int pos){
    return historico.getHistorico(pos);
    }
   
   //retorna o historico geral da rede
   public ArrayList getHistoricoGeral(){
    return historico.getHistoricoGeral();
    } 
    
    //passa a nova posição do usuario para pegar o seu historico
   public void setIndice(int pos){
    historico.setIndice(pos);
    }
    
   //Adiciona o evento de criar uma nova coleção
   public void addEventoIncluirColecao(String colecao){
    historico.addEventoIncluirColecao(colecao);
    }
    
   //retorna a foto do usuario do historico
   public int fotoUser(int pos){
    return historico.fotoUser(pos);
    } 
     
   //retorna um array com indece de todas as fotos 
   public ArrayList<Integer> getIndicesFoto(){
    return historico.getIndiceTodasFotos();
    }
   
   
    //verifica todos valores para deletalos
   public void deletaNull(){
    for(int i=0;i<colecao.size();i++){
        if(colecao.get(i).getTamanho() >0){
         verifica(i);
        }
    }
    }
    
   //troca a visivilidade de um item
   public void setVer(int pos1, int pos2){
    colecao.get(pos1).setVer(pos2);
    }
    
   //add o evento + amigo
   public void addEvendoNovoAmigo(String novoAmigo){historico.addEventoNovaAmizade(novoAmigo);}
   
}

