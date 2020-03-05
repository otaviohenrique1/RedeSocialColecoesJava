
import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/**Classe destinada a guardar o painel de Configurações*/
public class PainelConfiguracao
{
     Usuario usuario;
    
     //grupo de botoes para configuraçoes
     JPanel painel_Configuracoes;
     JRadioButton b1, b2, b3, b4;
     JRadioButton ba1, ba2, ba3;
     JLabel lb_configuracao;
     JCheckBox rb_escolheUndo; 
     static boolean undo = false;
     
     PainelConfiguracao(){}
     
     PainelConfiguracao(Usuario eu){
       usuario = eu;
       //Panel destinado a configurações
       painel_Configuracoes = new JPanel();
       painel_Configuracoes.setBorder(new javax.swing.border.TitledBorder(""));
       painel_Configuracoes.setVisible(true);
       painel_Configuracoes.setLayout(null);
       painel_Configuracoes.setBounds(220,50,650,560);
       
       // -- titulo das configuraçoes
       JLabel lb_engrenagens = new JLabel("");
       lb_engrenagens.setBounds(153,0,91,70);
       lb_engrenagens.setIcon(new ImageIcon("img\\engrenagens1.gif"));
       painel_Configuracoes.add(lb_engrenagens);
       
       JLabel lb_engrenagens2 = new JLabel("");
       lb_engrenagens2.setBounds(407,0,91,70);
       lb_engrenagens2.setIcon(new ImageIcon("img\\engrenagens2.gif"));
       painel_Configuracoes.add(lb_engrenagens2);
       
       lb_configuracao = new JLabel("Configurações",JLabel.CENTER);
       lb_configuracao.setBounds(10,20,630,30);
       lb_configuracao.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 24));
       painel_Configuracoes.add(lb_configuracao);
       
       // JCheck box para escolher quarda ou não o undo
       rb_escolheUndo = new JCheckBox();
       rb_escolheUndo.setText("Deseja guardar Undo e Redu?");
       rb_escolheUndo.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
       rb_escolheUndo.setSelected(usuario.getGuardaUndo());
       rb_escolheUndo.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { undo = !undo;}} );
       rb_escolheUndo.setBounds(10,75,300,30);
       painel_Configuracoes.add(rb_escolheUndo);
       
       // -------------- label incando o numero de paginas
       lb_configuracao = new JLabel("Numero de atualizações por pagina");
       lb_configuracao.setBounds(13,110,540,30);
       lb_configuracao.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
       painel_Configuracoes.add(lb_configuracao);
       
       //grupo de botoes onde apenas um pode estra celecionado
       
       ButtonGroup bg = new ButtonGroup();  
       b1 = new JRadioButton("Mostrar 10 atualizaçoes");  
       b1.setBounds(10,145,200,28);
       b1.setFont(new Font("Arial",Font.PLAIN, 15));
       b1.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { usuario.setNumeroAtt(10);}} );
       bg.add(b1);  
       painel_Configuracoes.add(b1);  
       
       b2 = new JRadioButton("Mostrar 20 atualizaçoes");  
       b2.setBounds(10,170,200,28);
       b2.setFont(new Font("Arial",Font.PLAIN, 15));
       b2.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { usuario.setNumeroAtt(20);}} );
       bg.add(b2); 
       painel_Configuracoes.add(b2); 
       
       b3 = new JRadioButton("Mostrar 30 atualizaçoes");  
       b3.setBounds(10,195,200,28);
       b3.setFont(new Font("Arial",Font.PLAIN, 15));
       b3.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { usuario.setNumeroAtt(30);}} );
       bg.add(b3); 
       painel_Configuracoes.add(b3);
       
       b4 = new JRadioButton("Mostrar 50 atualizaçoes");  
       b4.setBounds(10,220,200,28);
       b4.setFont(new Font("Arial",Font.PLAIN, 15));
       b4.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { usuario.setNumeroAtt(50);}} );
       bg.add(b4);  
       painel_Configuracoes.add(b4);
       //copara os dados para ceber quandidades att o usuario escolheu
       if(usuario.getNumeroAtt() == 10){b1.setSelected(true);}
       else if(usuario.getNumeroAtt() == 20){b2.setSelected(true);}
       else if(usuario.getNumeroAtt() == 30){b3.setSelected(true);}
       else{b4.setSelected(true);}
       
       //imagem de acesso
       ImageIcon img = new ImageIcon ("img\\cadeado_configuracao.png");  
       img.setImage(img.getImage().getScaledInstance(95,95, 100)); 
       
       JLabel lb_protecao = new JLabel(img);
       lb_protecao.setBounds(9,260,95,95);
       painel_Configuracoes.add(lb_protecao);
       
       //labem quem pode ver as infomações
       JLabel lb_Acesso = new JLabel("Quem pode acessar suas informações?");
       lb_Acesso.setBounds(85,260,540,30);
       lb_Acesso.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
       painel_Configuracoes.add(lb_Acesso);
       
       //opições de acesso
       ButtonGroup bg2 = new ButtonGroup();  
       ba1 = new JRadioButton("Totalmente publico");  
       ba1.setBounds(85,285,200,28);
       ba1.setFont(new Font("Arial",Font.PLAIN, 15));
       ba1.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) {usuario.setQuemVe(2); }} );
       bg2.add(ba1);  
       painel_Configuracoes.add(ba1);  
       
       ba2 = new JRadioButton("Somente amigos");  
       ba2.setBounds(85,310,200,28);
       ba2.setFont(new Font("Arial",Font.PLAIN, 15));
       ba2.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) {usuario.setQuemVe(1); }} );
       bg2.add(ba2); 
       painel_Configuracoes.add(ba2); 
       
       ba3 = new JRadioButton("Apenas eu");  
       ba3.setBounds(85,335,200,28);
       ba3.setFont(new Font("Arial",Font.PLAIN, 15));
       ba3.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) {usuario.setQuemVe(0);}} );
       bg2.add(ba3); 
       painel_Configuracoes.add(ba3);
       
       if(usuario.getQuemVe() == 2){ba1.setSelected(true);}
       else if(usuario.getQuemVe() == 1){ba2.setSelected(true);}
       else{ba3.setSelected(true);}
         
        }
     
     public JPanel getPanel(){
        return painel_Configuracoes;
        }
     
     public boolean getGuarda(){
        return undo;
        }
}
