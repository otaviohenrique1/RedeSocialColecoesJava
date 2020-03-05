


import java.awt.Color;
import java.awt.Font;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PainelLogin {

	JLabel lb_titulo, lb_login, lb_senha, lb_cadastrar;
	JTextField txt_login;
	JPasswordField pw_senha;
	JButton bt_logar, bt_sair, bt_cadastrar;
	JSeparator  s2;
	Cadastro cadastro = new Cadastro();
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
    
     // setando skin	
     try {
		UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	  }  catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	  }
	  
     PainelLogin x = new PainelLogin();
     
    }
    
	public PainelLogin(){
		
		final JFrame window = new JFrame("Login");
		window.setLayout(null);
		window.setIconImage(new ImageIcon("img\\minilogo.png").getImage());
		//window.getContentPane().setBackground(Color.WHITE);    
		// ****
		// adicionando componenta janela
		// **
		
		// titulo
		lb_titulo = new JLabel("");
		ImageIcon img = new ImageIcon ("img/logo.png");  
        img.setImage(img.getImage().getScaledInstance(390, 293, 100)); 
        lb_titulo.setIcon(img);
		lb_titulo.setFont(new Font("Arial", Font.BOLD, 30));
		lb_titulo.setForeground(Color.BLUE);
		lb_titulo.setBounds(5, 5, 390, 293);
		window.add(lb_titulo);
		
		
		// campo de login
		lb_login = new JLabel("Login: ");
		lb_login.setBounds(20, 300, 70, 30);
		lb_login.setFont(new Font("Arial", Font.BOLD, 20));
		window.add(lb_login);
		
		txt_login = new JTextField();
		txt_login.setBounds(90,300, 280, 30);
		txt_login.setFont(new Font("Arial", Font.BOLD, 18));
		window.add(txt_login);
		
		// campo de senha
		lb_senha = new JLabel("Senha: ");
		lb_senha.setBounds(20, 340, 100, 30);
		lb_senha.setFont(new Font("Arial", Font.BOLD, 20));
		window.add(lb_senha);
		
		pw_senha = new JPasswordField();
		pw_senha.setBounds(90, 340, 280, 30);
		pw_senha.setFont(new Font("Arial", Font.BOLD, 18));
		window.add(pw_senha);
		
		// **** 
		// **bot�es
		
		// login
		bt_logar = new JButton("Login");
		bt_logar.setBounds(100, 380, 100, 30);
		bt_logar.setFont(new Font("Arial", Font.BOLD, 18));
		bt_logar.setToolTipText(" Entrar no sistema ");
		
		bt_logar.addActionListener(
				
				new ActionListener() {

					//@Override
					public void actionPerformed(ActionEvent f) {
						
						String campo_login = txt_login.getText();
						String campo_senha = new String(pw_senha.getPassword());
						txt_login.setText(null);
						pw_senha.setText(null);
						cadastro.verificarUsuario(campo_login, campo_senha, window);
						//System.out.println("Login ativo");
					}
					
				}
				
				);
		
		window.add(bt_logar);
		
		
		// sair
		bt_sair = new JButton("Sair");
		bt_sair.setBounds(210, 380, 100, 30);
		bt_sair.setFont(new Font("Arial", Font.BOLD, 18));
		bt_sair.setToolTipText(" Encerrar sessão ");
		bt_sair.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						window.dispose();
					}
					
				}
				);
		window.add(bt_sair);
		
		// separador
		s2 = new JSeparator();
		s2.setBounds(5, 442, 390, 1);
		window.add(s2);
		
		// cadastrar
		lb_cadastrar = new JLabel("Ainda não possui uma conta no Cloud Collections?");
		lb_cadastrar.setBounds(20, 420, 360, 30);
		lb_cadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		window.add(lb_cadastrar);
		
		bt_cadastrar = new JButton("Cadastre-se!");
		bt_cadastrar.setBounds(130, 455, 150, 30);
		bt_cadastrar.setFont(new Font("Arial", Font.BOLD, 18));
		bt_cadastrar.setToolTipText(" Cadastrar novo usuario ");
		bt_cadastrar.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {						
						cadastro.PainelCadastro();						
					}
				}
				);
		
		window.add(bt_cadastrar);
		
		window.setSize(410,523);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(1);
		
	}
		
}
