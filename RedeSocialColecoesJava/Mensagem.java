
import java.util.*;

public class Mensagem
{
   ArrayList<Integer> id = new ArrayList<Integer>(); // guarda quem falo
   ArrayList<String> mensagen = new ArrayList<String>(); // quarda oque falo
   private int indice;
   boolean nvi = false;
   
   //contrutor que recebe o id
   Mensagem(int id){indice = id;}
   
   //toda nova fala passa por aqui para ser adiciona aos array
   public void addNovaconversa(int id, String fala){
    this.id.add(id);
    mensagen.add(fala);
    if(id == indice){nvi = true;}
    else{nvi = false;}
    }
    
   //retorna o id da mensagem
   public ArrayList<Integer> getIds(){
    return id;
    }
    
   //retorna todas as mensagens
   public ArrayList<String> getMensagens(){
    return mensagen;
    }
    
   //comfirma que esta mensagen foi visualizada
   public void setAgoraVi(){
    nvi = false;
    } 
    
   // retorna se esta conversa foi ou não visualizada
   public boolean getOqueNaoVi(){
    return nvi;
    }
}
