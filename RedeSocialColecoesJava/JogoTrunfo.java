
public class JogoTrunfo
{
    private String plataforma,nome,forca,agilidade,popularidade,poder,numeroID,carisma;
    
    public JogoTrunfo(String nome,String numeroID,String plataforma,String forca,String popularidade,String poder,String agilidade,String carisma){
    this.plataforma=plataforma;
    this.nome=nome;
    this.forca=forca;
    this.agilidade=agilidade;
    this.popularidade=popularidade;
    this.poder=poder;
    this.numeroID=numeroID;
    this.carisma=carisma;
    }
        
    public String getNome(){
    return this.nome;
    }
    
    public String getPlataforma(){
    return this.plataforma;
    }
    
    public String getForca(){
    return this.forca;
    }
    
    public String getAgilidade(){
    return this.agilidade;
    }
    
    public String getPopularidade(){
    return this.popularidade;
    }
    
    public String getPoder(){
    return this.poder;
    }
    
    public String getNumeroID(){
    return this.numeroID;
    }
    
    public String getCarisma(){
    return this.carisma;
    }
}


