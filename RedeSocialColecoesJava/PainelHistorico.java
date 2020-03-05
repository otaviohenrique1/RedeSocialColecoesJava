import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/**Classe destinada ao painel Historico*/
public class PainelHistorico
{
   JPanel painel_feedNoticia;
   JScrollPane scroll_panel_att;
   ArrayList<Integer> fotoAllUser = new ArrayList<>();
   Usuario eu;
   Cadastro cadastro = new Cadastro();
   Grafos grafos = new Grafos();

   PainelHistorico(Usuario eu, int controle){
       this.eu = eu;
       //-----painel para Noticias e Historico do usuario-----
       painel_feedNoticia = new JPanel();
       painel_feedNoticia.setBorder(new javax.swing.border.TitledBorder(""));
       painel_feedNoticia.setVisible(true);
       painel_feedNoticia.setLayout(null);
       painel_feedNoticia.setPreferredSize(new Dimension(630,470));  
       
       scroll_panel_att = new JScrollPane(painel_feedNoticia);
       scroll_panel_att.setBounds(220,50,650,560);
       scroll_panel_att.setHorizontalScrollBarPolicy(scroll_panel_att.HORIZONTAL_SCROLLBAR_NEVER);
       
       if(controle == 1){
       gerarHistorico(historicoQuePossoVer(eu.getIndicesFoto(),eu.getHistoricoGeral()),1,eu.getNumeroAtt(),1);// mostra todo o historico do usuario 
      }
      else{gerarHistorico(eu.getHistorico(cadastro.getIndice()),0,eu.getNumeroAtt(),1);}
    }
    
   public JScrollPane getScrollPaneHistorico(){
    return scroll_panel_att;
    }
    
   //refaz o Array com somente as pessoas q podem ver
   private ArrayList historicoQuePossoVer(ArrayList<Integer> indices, ArrayList<String> hist){
        ArrayList<String> H = new ArrayList<String>(); fotoAllUser.clear();
        for(int i =0; i< indices.size();i++){
         if((cadastro.getQuemVe(indices.get(i)) == 2) || ((cadastro.getQuemVe(indices.get(i)) == 1 && grafos.eAmigo(cadastro.getIndice(), indices.get(i))))){
            H.add(hist.get(i));
            fotoAllUser.add(indices.get(i));
            }
        }
        return H;
    }
    
   
    
    //Gera o hitorico do usuario
    public void gerarHistorico(ArrayList H, int test, int max, int pg){
     JLabel[] historico = new JLabel[H.size()];
     JLabel[] imgOk = new JLabel[H.size()];
     JLabel[] fotoUser = new JLabel[H.size()];
     int x = 10;
     if(eu.getHistorico(cadastro.getIndice()).size() == 0){
         JLabel mensage = new JLabel("Você ainda não tem nenhuma Coleção Cadastrada!",JLabel.CENTER);
         mensage.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 16));
         mensage.setBounds(10,x,630,45);
         painel_feedNoticia.add(mensage);
          x += 55;
                 }
     //valor para saber se a função é para historico geral ou unitario
     final int op = test;
     final int m = max;
     final ArrayList passaHistorico = H;
     // mostra apenas a pagina selecionada
     int de = H.size()-(max*pg)+max;
     int ate= H.size()-(max*pg);
     if(ate < 0){ate =0;}
        
     //---------este for mostra todas os Historicos da rede de uma pagina até outra-------
     for( int i=de-1;i>=ate;i--){
      String confere = ""+H.get(i);
      fotoUser[i] = new JLabel();
      fotoUser[i].setBounds(10,x,45,45);
      fotoUser[i].setBorder(new javax.swing.border.TitledBorder(""));
      ImageIcon f;
      if(test==0){f = new ImageIcon(eu.getEndFoto()); }
      else{f = new ImageIcon(cadastro.getFotoH(fotoAllUser.get(i))); }  
      f.setImage(f.getImage().getScaledInstance(45,45, 100)); 
      fotoUser[i].setIcon(f);
      
      historico[i] = new JLabel(confere);imgOk[i] = new JLabel();
      historico[i].setBounds(80,x,700,45);imgOk[i].setBounds(57,x+20,20,20);
      historico[i].setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 16)); 
      if(confere.indexOf("removeu") >= 0)
      {
          ImageIcon img = new ImageIcon ("img/excluido.png");  
          img.setImage(img.getImage().getScaledInstance(20,20, 100)); 
          imgOk[i].setIcon(img);}
      else if(confere.indexOf("lista de amigos") >= 0)
      {
          ImageIcon img = new ImageIcon ("img/aceitar.png");  
          img.setImage(img.getImage().getScaledInstance(20,20, 100)); 
          imgOk[i].setIcon(img);}
      else if(confere.indexOf("Adicionou") >= 0)
      {
          ImageIcon img = new ImageIcon ("img/mais.png");  
          img.setImage(img.getImage().getScaledInstance(20,20, 100)); 
          imgOk[i].setIcon(img);}
      else if(confere.indexOf("Defez") >= 0)
      {
          ImageIcon img = new ImageIcon ("img/undo.png");  
          img.setImage(img.getImage().getScaledInstance(20,20, 100)); 
          imgOk[i].setIcon(img);}
      else if(confere.indexOf("Refez") >= 0)
      {
          ImageIcon img = new ImageIcon ("img/redu.png");  
          img.setImage(img.getImage().getScaledInstance(20,20, 100)); 
          imgOk[i].setIcon(img);}
       else if(confere.indexOf("Alterou") >= 0)
      {
          ImageIcon img = new ImageIcon ("img/alterar.png");  
          img.setImage(img.getImage().getScaledInstance(20,20, 100)); 
          imgOk[i].setIcon(img);}
      else{ 
          ImageIcon img = new ImageIcon ("img/ok.png");  
          img.setImage(img.getImage().getScaledInstance(20,20, 100)); 
          imgOk[i].setIcon(img);}
          
      painel_feedNoticia.add(historico[i]);painel_feedNoticia.add(imgOk[i]);painel_feedNoticia.add(fotoUser[i]);
      x += 55;
                                }
     
     //******************-gera botoes para pular a pagina-*****************************
     int lado = 10;
     //gera botão anterior caso aja uma pagina antes
     if(pg >= 2){
        JButton anterior = new JButton("<< Anterior");
        anterior.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 16));
        anterior.setBounds(lado, x, 125, 30);
        final int anteriorPage = pg-1;
        anterior.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
        painel_feedNoticia.removeAll();
        gerarHistorico(passaHistorico,op,m,anteriorPage);
        scroll_panel_att.getViewport().setViewPosition(new Point(0,0)); 
        painel_feedNoticia.repaint();
        }} );
        anterior.setToolTipText(" Leva para a pagina anterior ("+(pg-1)+") ");
        painel_feedNoticia.add(anterior);
        lado += 130;
        }
     
     int ate5 = pg-3;
     if(ate5 < 0){ate5 =0;}
     
     if(H.size() > max){
      for(int i =ate5;i<pg+2 && i<(1+(int)(H.size()/max));i++){
          
               JButton meio = new JButton(1+i+"");
               meio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 16));
               if(i==(pg-1)){meio.setForeground(Color.RED);}
               meio.setBounds(lado, x, 50, 30);
               final int page = i+1;
               meio.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
                painel_feedNoticia.removeAll();
                gerarHistorico(passaHistorico,op,m,page);
                scroll_panel_att.getViewport().setViewPosition(new Point(0,0)); 
                painel_feedNoticia.repaint();
                }} );
                meio.setToolTipText(" Leva para a pagina ("+(i+1)+") ");
               painel_feedNoticia.add(meio);
               lado += 55;
            
              }
       //gera o botão prox se caso ele seja nessesario       
      if(pg <= (int)(H.size()/max)){
        JButton prox = new JButton("Próximo >>");
        prox.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 16));
        prox.setBounds(lado, x, 125, 30);
        final int anteriorPage = pg+1;
        prox.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
        painel_feedNoticia.removeAll();
        gerarHistorico(passaHistorico,op,m,anteriorPage);
        scroll_panel_att.getViewport().setViewPosition(new Point(0,0)); 
        painel_feedNoticia.repaint();
        }} );
        painel_feedNoticia.add(prox);
        prox.setToolTipText(" Leva para a proxima pagina ("+(pg+1)+") ");
        }
      x += 55;
        }
     painel_feedNoticia.setSize(540, x);
     painel_feedNoticia.setPreferredSize(painel_feedNoticia.getSize());
    } 
}
