import java.util.*;

public class Grafos
{    
    static ArrayList<ArrayList<Integer>> grafos = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Mensagem>> grafos_conversa = new ArrayList<ArrayList<Mensagem>>();
    
    //todo usuario adicionado aumenta o grafos em uma linha e uma coluna cheias de zeros
    public void novoUsuario(){
     ArrayList<Integer> novo = new  ArrayList<Integer>();
     ArrayList<Mensagem> falas = new ArrayList<Mensagem>();
     for(int i=0;i<grafos.size();i++){
      novo.add(0);
      falas.add(new Mensagem(i));
        }
     grafos.add(novo);
     grafos_conversa.add(falas);
     for(int i=0;i<grafos.size();i++){
      grafos.get(i).add(0);
      grafos_conversa.get(i).add(new Mensagem(grafos.size()-1));
        }
    }
    
    //mostra todas as pessoas que são amigos de um usuario apartir de um indice
    public ArrayList<Integer> todosAmigos(int eu){
        ArrayList<Integer> listaDeAmigos = new ArrayList<Integer>();
        for(int i=0;i<grafos.size();i++){
         if(grafos.get(eu).get(i)>0 && grafos.get(i).get(eu)>0 && (i != eu)){
            listaDeAmigos.add(i);
            }
        }
        return listaDeAmigos;
    }
    
    //mostra todos que não são amigos
    public ArrayList<Integer> todosNaoAmigos(int eu){
        ArrayList<Integer> listaDeNaoAmigos = new ArrayList<Integer>();
        for(int i=0;i<grafos.size();i++){
         if((grafos.get(eu).get(i)==0 || grafos.get(i).get(eu)==0) && (i != eu)){
            listaDeNaoAmigos.add(i);
            }
        }
        return listaDeNaoAmigos;
    }
    
    //mostra todas as solicitações
    public ArrayList<Integer> verSolicitacao(int eu){
        ArrayList<Integer> solisitacao = new ArrayList<Integer>();
        for(int i=0;i<grafos.size();i++){
         if(grafos.get(i).get(eu)>0 && i!=eu){
            solisitacao.add(i);
            }
        }
        return solisitacao;
    }
    
    //mostra o numero de coisas q o usuaro fez
    public int getNrankin(int eu){
     return grafos.get(eu).get(eu);
    }
    
    //soma todas as ações do usuario
    public int somaAcao(int eu){
        int x=0;
        for(int i=0;i<grafos.size();i++){
         if(grafos.get(eu).get(i)>0 && grafos.get(i).get(eu)>0){
            x+=grafos.get(eu).get(i);
            }
        }
        return x;
    }
    
    
    //traz o numero de amigos que inviarão convite
    public int getNumeroDesolicitacao(int eu){
        int x=0;
        for(int i=0;i<grafos.size();i++){
         if((grafos.get(i).get(eu)>0 && i != eu) && grafos.get(eu).get(i)==0){
            x+=1;
            }
        }
        return x;
    }
    
    //manda um pedido de amizade para um usuario
    public void fazerPedido(int eu,int amigo){
      grafos.get(eu).set(amigo,1);
    }
    
    //aceita o edido de um usuario
    public void aceitarPedido(int eu,int amigo){
     grafos.get(eu).set(amigo,1);   
    }
    
    //recusa o pedido de um usuario
    public void recusarPedido(int eu,int amigo){
     grafos.get(amigo).set(eu,0); 
     grafos.get(eu).set(amigo,0);
    }
    
    //apartir de um indice retorna se é amigo ou n
    public boolean eAmigo(int eu,int pessoaTest){
        if(grafos.get(eu).get(pessoaTest)>0 && grafos.get(pessoaTest).get(eu)>0){return true;}
        else{return false;}
    }
    
    // adiciona uma nova mensagem
    public void novaFala(int eu,int amigo,String fala){
        grafos_conversa.get(eu).get(amigo).addNovaconversa(eu, fala);
        grafos_conversa.get(amigo).get(eu).addNovaconversa(eu, fala);
    }
    
    // retorna um array de inteiro representando o indice de quem mandou
    public ArrayList<Integer> getQuemMandou(int eu,int amigo){
        return grafos_conversa.get(eu).get(amigo).getIds();
    }
    
    // retorna um array de String com oq mando
    public ArrayList<String> getOqueMando(int eu,int amigo){
        return grafos_conversa.get(eu).get(amigo).getMensagens();
    }
    
    //retorna a soma das conversas q não forão lidas
    public int getNumeroConversaNaoLidas(int eu){
     int x = 0;
     for(int i=0;i<grafos_conversa.size();i++){
       if(grafos_conversa.get(eu).get(i).getOqueNaoVi()){x+=1;}
        }
     return x;
    }
    
    //retorna o id de quem mando algo que não foi lido
    public ArrayList<Integer> getConvesasQueNaoLi(int eu){
       ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i=0;i<grafos_conversa.size();i++){
         if(grafos_conversa.get(eu).get(i).getOqueNaoVi()){lista.add(i);}
        }
       return lista;
    }
    
    //faz com que todas as conversas sejão vistas
    public void agoraVi(int eu){
     ArrayList<Integer> lista = getConvesasQueNaoLi(eu);
     for(int i =0; i< lista.size();i++){
        grafos_conversa.get(eu).get(lista.get(i)).setAgoraVi();
        }
    }
   
}
