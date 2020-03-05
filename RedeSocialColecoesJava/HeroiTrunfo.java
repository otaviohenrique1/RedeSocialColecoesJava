//nome,ordem,origem,forca,velocidade,habilidade,equipamento,inteligencia
public class HeroiTrunfo
{
    private String editora,nomeHeroi,forca,velocidade,habilidade,equipamento,numeroID,inteligencia;
    
    public HeroiTrunfo(String nomeHeroi,String numeroID,String editora,String forca,String velocidade,String habilidade,String equipamento,String inteligencia){
    this.editora=editora;
    this.nomeHeroi=nomeHeroi;
    this.forca=forca;
    this.velocidade=velocidade;
    this.habilidade=habilidade;
    this.equipamento=equipamento;
    this.numeroID=numeroID;
    this.inteligencia=inteligencia;
    }
        
    public String getNome(){
    return this.nomeHeroi;
    }
    
    public String getEditora(){
    return this.editora;
    }
    
    public String getForca(){
    return this.forca;
    }
    
    public String getVelocidade(){
    return this.velocidade;
    }
    
    public String getHabilidade(){
    return this.habilidade;
    }
    
    public String getEquipamento(){
    return this.equipamento;
    }
    
    public String getNumeroID(){
    return this.numeroID;
    }
    
    public String getIteligencia(){
    return this.inteligencia;
    }
}
             