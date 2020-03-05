
public class CarroTrunfo
{
    private String nacionalidade,nomeCarro,cilindrada,velMax,forca,preco,numeroID,metro;
    
    public CarroTrunfo(String nomeCarro,String numeroID,String nacionalidade,String cilindrada,String forca,String preco,String velMax,String metro){
    this.nacionalidade=nacionalidade;
    this.nomeCarro=nomeCarro;
    this.cilindrada=cilindrada;
    this.velMax=velMax;
    this.forca=forca;
    this.preco=preco;
    this.numeroID=numeroID;
    this.metro=metro;
    }
        
    public String getNome(){
    return this.nomeCarro;
    }
    
    public String getNacionalidade(){
    return this.nacionalidade;
    }
    
    public String getCilindrada(){
    return this.cilindrada;
    }
    
    public String getVelMax(){
    return this.velMax;
    }
    
    public String getForca(){
    return this.forca;
    }
    
    public String getPreco(){
    return this.preco;
    }
    
    public String getNumeroID(){
    return this.numeroID;
    }
    
    public String getMetro(){
    return this.metro;
    }
}
