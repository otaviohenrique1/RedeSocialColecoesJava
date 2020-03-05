
public class TimeTrunfo
{
    String nome,id,naci,precoTime,tituloInt,tituloNac,introsamento,mediaIdade;
    public TimeTrunfo(String nome,String id,String naci,String precoTime,String tituloInt,String tituloNac,String introsamento,String mediaIdade)
    {
      this.nome=nome;
      this.id=id;
      this.naci=naci;
      this.precoTime=precoTime;
      this.tituloInt=tituloInt;
      this.tituloNac=tituloNac;
      this.introsamento=introsamento;
      this.mediaIdade=mediaIdade;
    }
    
    public String getNome(){
      return this.nome;
      }
    
      public String getNumeroID(){
      return this.id;
    }
    
    public String getNacionalidade(){
      return this.naci;
     }
    
    public String getPreco(){
      return this.precoTime;
    }
    
    public String getTituloInt(){
       return this.tituloInt;
    }
    
    public String getTituloNac(){
      return this.tituloNac;
    }
    
    public String getIntrosamento(){
    return this.introsamento;
    }
    
    public String getMediaIdade(){
    return this.mediaIdade;
    }
    
    
    }
