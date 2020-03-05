
public class Notificacao {

	private String notificacao;
	private Usuario usuario;
	
	public Notificacao(String notificacao, Usuario usuario){
		this.notificacao = notificacao;
		this.usuario = usuario;
	}
	
	public String getNotificacao(){
		return notificacao;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
}
