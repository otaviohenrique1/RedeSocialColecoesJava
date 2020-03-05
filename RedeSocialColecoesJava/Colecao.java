import java.util.*;
import java.text.*;
import java.lang.reflect.Method;
public class Colecao
{
    private ArrayList item = new ArrayList(); 
    private String nomeColecao;
    
    private Object elemento;
    private String nomeTempIntem;
    public Colecao(String nomeColecao){this.nomeColecao = nomeColecao;}
    
    public void addNovo(){
     if(nomeColecao.equals("HotWheels")){
         HotWheels x = new HotWheels();  x.setCadastrar(); item.add(x);
        }
     else if(nomeColecao.equals("Jogos")){
         Jogos x = new Jogos(); x.setCadastrar();item.add(x);
        }
     else if(nomeColecao.equals("Cartoes Telefonicos")){
         CartoesTelefonicos x = new CartoesTelefonicos(); x.setCadastrar();item.add(x);
        }
     else if(nomeColecao.equals("Camisetas de Times")){
         CamisetasTime x = new CamisetasTime();  x.setCadastrar();item.add(x);
        }
     else if(nomeColecao.equals("Quadrinhos")){
         Quadrinhos x = new Quadrinhos();  x.setCadastrar();item.add(x);
        }
     else {
         Moedas x = new Moedas();  x.setCadastrar();item.add(x);
        }
    }
    
    //compara o ultimo elemento caso for null ele o apaga
    public boolean verifica(){
       boolean x = false;
       if (getNomeIten(item.size()-1).equals("null")){
        item.remove(item.size()-1);
        x = true;
        }
        return x;
    }
    
    //retorna o nome da um item apratir da posicao
    public String getNomeIten(int pos){
      String x = "";
     if(item.size() != 0){
      Class cls = item.get(pos).getClass();
      try{
       Method mtd = cls.getMethod("getNome", new Class[] {} );
       x = ""+mtd.invoke(item.get(pos), new Object[] {});
      }catch(Exception e){
        e.printStackTrace();
      }
       } 
      return x;
    }
    
    //retorna um boleano com para q ver se pode ou n mostrar este item
    public boolean getVer(int pos){
      boolean x = true;
     if(item.size() != 0){
      Class cls = item.get(pos).getClass();
      try{
       Method mtd = cls.getMethod("getVer", new Class[] {} );
       x = (boolean)mtd.invoke(item.get(pos), new Object[] {});
      }catch(Exception e){}
       } 
      return x;
    }
    
    //troca o boleano para q le n torne mais visivel
    public void setVer(int pos){
     if(item.size() != 0){
      Class cls = item.get(pos).getClass();
      try{
       Method mtd = cls.getMethod("setVer", new Class[] {} );
       mtd.invoke(item.get(pos), new Object[] {});
      }catch(Exception e){}
       } 
    }
    // retorna o nome da colecao
    public String getNomeColecao(){
      return nomeColecao;
    }
    
    //retorna um interiro com o numero de itens da colecao
    public int getTamanho(){
     return item.size();
    }   
    
    //metodo para retornar informações de qual qer umas das classes
    public String getInfo(int pos){
     Class cls = item.get(pos).getClass();
     String x = "";
      try{
       Method mtd = cls.getMethod("getInfo", new Class[] {} );
       x = ""+mtd.invoke(item.get(pos), new Object[] {});
       
      }catch(Exception e){
        e.printStackTrace();
      }
      return x;
    }
    
    //Deleta um intem da lista
    public void delete(int pos){
      Class cls = item.get(pos).getClass();
      try{
       Method mtd = cls.getMethod("addEventoExcluir", new Class[] {} );
       mtd.invoke(item.get(pos), new Object[] {});
      }catch(Exception e){
        e.printStackTrace();
       } 
      deletar(pos);
    }
    
    //deleta um item aprtir  sua posição
    public void deletar(int pos){
     item.remove(pos);
    }
    
    //metodo q altera dados ja cadastrados
    public void atualizarDados(int pos){
      Class cls = item.get(pos).getClass();
      try{
       Method mtd1 = cls.getMethod("atualizarDados", new Class[] {} );
       mtd1.invoke(item.get(pos), new Object[] {});
      }catch(Exception e){
        e.printStackTrace();
       } 
    }
    
    //metodo para undo retorna o item alterado
    public void undoVoltar(int pos,Object x){
     deletar(pos);
     item.add(pos,x);
    }
    
    
    //Retorna um item para a troca
    public Object getItem(int pos){
     elemento = item.get(pos);
     return elemento;
    }
    
    //adiciona um elemento de um outro usuario
    public void setItem(Object elemento){
        this.elemento = elemento;
        item.add(this.elemento);
    }
    
    //adiciona um itenm em uma posição espesificada
    public void setItem(Object elemento,int pos){
        this.elemento = elemento;
        
         item.add(pos,this.elemento);
        
    }
    
    //faz um clone do item ara gardalo no undo e redu
    public Object clonarItem(int pos){
      Object x = new Object(); 
      Class cls = item.get(pos).getClass();
      try{
       Method mtd1 = cls.getMethod("clone", new Class[] {} );
       x = mtd1.invoke(item.get(pos), new Object[] {});
      }catch(Exception e){
        e.printStackTrace();
       } 
      return x;
    }
}
