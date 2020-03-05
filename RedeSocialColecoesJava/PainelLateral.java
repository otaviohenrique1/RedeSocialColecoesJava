import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/** Classe destinada a guardar o painel lateral */
public class PainelLateral
{
   static Cadastro cadastro = new Cadastro();
   static Grafos grafos = new Grafos();
   static private JPanel painel_Lateral, painel_amigos_att, painel_conversa;
   static JScrollPane scroll_panel;
   static JLabel nomeConversa;
   Font fonteT1 = new Font("Arial",Font.BOLD + Font.PLAIN, 16);
   int controleConversa = 0;
   
   PainelLateral(int i){
    if(i < 0){ preencheAmigosLateral();}
    else{
     criaConversa(i);
    }
    }
    
   PainelLateral(){  
       
    painel_Lateral = new JPanel();
    painel_Lateral.setLayout(null);
    painel_Lateral.setBounds(875,50,200,560);
    painel_Lateral.setVisible(true);
    
    painel_amigos_att = new JPanel();
    painel_amigos_att.setBorder(new javax.swing.border.TitledBorder(""));
    painel_amigos_att.setVisible(true);
    painel_amigos_att.setLayout(null);
    painel_amigos_att.setBounds(0,0,200,350);
    painel_amigos_att.setPreferredSize(new Dimension(200,320));  
    
    // representa o nome de co quem se esta conversando
    nomeConversa = new JLabel("Amigo",JLabel.CENTER);
    nomeConversa.setBounds(5,335,190,15);
    nomeConversa.setFont(fonteT1);
    painel_Lateral.add(nomeConversa);
    
    // caisa de texto
    JLabel caixaConversa = new JLabel(new ImageIcon(getClass().getResource("img/quemFala.png")));
    caixaConversa.setBounds(0,330,200,25);
    painel_Lateral.add(caixaConversa);
    
    scroll_panel = new JScrollPane(painel_amigos_att);
    scroll_panel.setBounds(0,0,200,330);
    scroll_panel.setHorizontalScrollBarPolicy(scroll_panel.HORIZONTAL_SCROLLBAR_NEVER);
    painel_Lateral.add(scroll_panel);
    
    preencheAmigosLateral();//coloca amigos adicionados a tela
    
    //painel destinado a guardar a conversa de usuarios
    painel_conversa = new JPanel();
    painel_conversa.setBorder(new javax.swing.border.TitledBorder(""));
    painel_conversa.setVisible(true);
    painel_conversa.setLayout(null);
    painel_conversa.setBounds(0,355,200,205);
    painel_Lateral.add(painel_conversa);
    
    //JLabel informativo
    JLabel lb_clique = new JLabel("<html><Center>Clique em Falar<br>para iniciar o<br>bate papo",JLabel.CENTER);
    lb_clique.setFont(new Font("Times New Roman",Font.BOLD,25));
    lb_clique.setForeground(Color.BLUE);
    lb_clique.setBounds(0,0,200,205);
    painel_conversa.add(lb_clique);
    }
   
    public void preencheAmigosLateral(){
     painel_amigos_att.removeAll();
     int x = 0;
     for(int i =0;i < grafos.todosAmigos(cadastro.getIndice()).size();i++){
      final int I =i;   
      JLabel mensagem = new JLabel();mensagem.setBorder(new javax.swing.border.TitledBorder(""));
      mensagem.setBounds(4, x+3, 189, 60);
      painel_amigos_att.add(mensagem);
      
      //img do usuario
      ImageIcon img2; 
    
      if(cadastro.getFoto(grafos.todosAmigos(cadastro.getIndice()).get(i)).equals("")){
          img2 = new ImageIcon(getClass().getResource("img/usuario.jpg"));}
       else{img2 = new ImageIcon(cadastro.getFoto(grafos.todosAmigos(cadastro.getIndice()).get(i)));}
      
      img2.setImage(img2.getImage().getScaledInstance(51,51, 100)); 
      JLabel lb_img_amigo = new JLabel(img2);
      lb_img_amigo.setBounds(5,x+6,51, 51);
      painel_amigos_att.add(lb_img_amigo);
                     
      // nome
      JLabel lb_nome_amigo = new JLabel(cadastro.getNomeUsuario(grafos.todosAmigos(cadastro.getIndice()).get(i)),JLabel.CENTER);
      lb_nome_amigo.setBounds(58, x+11, 130, 20);lb_nome_amigo.setFont(fonteT1); 
      painel_amigos_att.add(lb_nome_amigo);
      
      //perfil
      JButton bt_Ver_Perfil = new JButton("Perfil");
      bt_Ver_Perfil.setBounds(60, x+35, 60, 20);  
      bt_Ver_Perfil.addActionListener( new ActionListener(){ @Override
      public void actionPerformed(ActionEvent e){
        if(cadastro.getQuemVe(grafos.todosAmigos(cadastro.getIndice()).get(I)) != 0) {
            new RedeSocial(grafos.todosAmigos(cadastro.getIndice()).get(I),10);
        }
         else{JOptionPane.showMessageDialog(null, "Informações restritas");}
          }});painel_amigos_att.add(bt_Ver_Perfil);
      
      JButton bt_novaConversa = new JButton("Falar");
      bt_novaConversa.addActionListener( new ActionListener(){ @Override
      public void actionPerformed(ActionEvent e){
          criaConversa(grafos.todosAmigos(cadastro.getIndice()).get(I));
        }});
      bt_novaConversa.setBounds(126, x+35, 60, 20);  
      painel_amigos_att.add(bt_novaConversa);
      x+=60;
     }
     painel_amigos_att.setSize(200,x);
     painel_amigos_att.setPreferredSize(painel_amigos_att.getSize());
     painel_amigos_att.repaint();
   }
    
   //carrega as conversas para o painel mais inferior da tela
   public void criaConversa(final int amigo){
    painel_conversa.removeAll();
    nomeConversa.setText(cadastro.getNomeUsuario(amigo));
    //area onde mostra tudo oque foi dito na conversa
    final JPanel painel_de_Falas = new JPanel();
    painel_de_Falas.setLayout(null);
    painel_de_Falas.setBounds(0, 0, 190, 140);
    painel_de_Falas.setPreferredSize(painel_de_Falas.getSize());
    final JScrollPane scrol_falas = new JScrollPane(painel_de_Falas);
    scrol_falas.setHorizontalScrollBarPolicy(scrol_falas.HORIZONTAL_SCROLLBAR_NEVER);
    scrol_falas.setBounds(0, 0, 200, 155); 
    painel_conversa.add(scrol_falas);
    
    //barra para enviar mensagens
    final JTextArea TA_mensagem = new JTextArea(1, 1);
    JScrollPane scrollPane = new JScrollPane(TA_mensagem);
    TA_mensagem.setLineWrap(true);
    scrollPane.setBounds(5, 160, 190, 36); 
    painel_conversa.add(scrollPane);
    
    //faz com que a mensagen seja envia atravez do Enter
    TA_mensagem.addKeyListener(new KeyListener(){
     @Override
     public void keyPressed(KeyEvent e){
       if(e.getKeyCode() == KeyEvent.VK_ENTER){
          grafos.novaFala(cadastro.getIndice(),amigo,TA_mensagem.getText());
          addUmaNovaMensagem(painel_de_Falas, TA_mensagem.getText(), scrol_falas);
         }
      }
     @Override public void keyTyped(KeyEvent e) {}
     @Override public void keyReleased(KeyEvent e) {
          if(e.getKeyCode() == KeyEvent.VK_ENTER){TA_mensagem.setText(null);}}
    });
    
    carregarMensagens(painel_de_Falas,amigo, scrol_falas);//imprime as conversas
    
    painel_conversa.revalidate();
    painel_conversa.repaint();
    
    TA_mensagem.grabFocus();
    }
    
   //imprime toda a conversa apartir de um uuario e o local na onde os dados vão aparecer
   public void carregarMensagens(JPanel painel,int amigo, JScrollPane scroll){
     controleConversa = 0;
     int x = controleConversa;
     for(int i = 0; i < grafos.getQuemMandou(cadastro.getIndice(),amigo).size();i++){
      //img do usuario
      ImageIcon img2; 
      if(cadastro.getFoto(grafos.getQuemMandou(cadastro.getIndice(),amigo).get(i)).equals("")){
          img2 = new ImageIcon(getClass().getResource("img/usuario.jpg"));}
       else{img2 = new ImageIcon(cadastro.getFoto(grafos.getQuemMandou(cadastro.getIndice(),amigo).get(i)));}
       
      img2.setImage(img2.getImage().getScaledInstance(51,51, 100)); 
      JLabel lb_img_amigo = new JLabel(img2);
      lb_img_amigo.setBounds(1,x,50, 50);
      lb_img_amigo.setToolTipText(cadastro.getNomeUsuario(grafos.getQuemMandou(cadastro.getIndice(),amigo).get(i))+" Disse ");
      painel.add(lb_img_amigo);
      
      //oque ele falo
      JTextArea falouIsso = new JTextArea(1,1);
      falouIsso.setText(grafos.getOqueMando(cadastro.getIndice(), amigo).get(i));
      JScrollPane scrollPane = new JScrollPane(falouIsso);
      falouIsso.setLineWrap(true);falouIsso.setEditable(false);
      scrollPane.setBounds(51, x, 138, 50); 
      painel.add(scrollPane);
      
      x+=60;
    }
    //redimenciona o peinel
    painel.setSize(190,x);
    painel.setPreferredSize(painel.getSize());
    controleConversa = x;
    
    //passa o scrollPane para o fim
    int maxValue = scroll.getVerticalScrollBar().getMaximum();  
    scroll.getViewport().setViewPosition(new Point(0,maxValue)); 
    } 
    
   //adiciona uma unica ultima mensagen enviada
   public void addUmaNovaMensagem(JPanel painel,String texto, JScrollPane scroll){
      //img do usuario
      ImageIcon img2 = new ImageIcon(cadastro.getFoto(cadastro.getIndice()));  
      if(cadastro.getFoto(cadastro.getIndice()).equals("")){
          img2 = new ImageIcon(getClass().getResource("img/usuario.jpg"));}
       else{img2 = new ImageIcon(cadastro.getFoto(cadastro.getIndice())); }
       
      img2.setImage(img2.getImage().getScaledInstance(51,51, 100)); 
      JLabel lb_img_amigo = new JLabel(img2);
      lb_img_amigo.setBounds(1,controleConversa,50, 50);
      lb_img_amigo.setToolTipText(cadastro.getNomeUsuario(cadastro.getIndice())+" Disse ");
      painel.add(lb_img_amigo);
      
      //oque o usuario falo
      JTextArea falouIsso = new JTextArea(1,1);
      falouIsso.setText(texto);
      JScrollPane scrollPane = new JScrollPane(falouIsso);
      falouIsso.setLineWrap(true);falouIsso.setEditable(false);
      scrollPane.setBounds(51, controleConversa, 138, 50); 
      painel.add(scrollPane);
      
      //redimencioando o scrollPane
      controleConversa +=60;
      painel.setSize(190,controleConversa);
      painel.setPreferredSize(painel.getSize());
      
      //passa o scrollPane para o fim
      int maxValue = scroll.getVerticalScrollBar().getMaximum();  
      scroll.getViewport().setViewPosition(new Point(0,maxValue));  
    } 
    
   public JPanel getPainel(){
    return painel_Lateral;
    }
}
