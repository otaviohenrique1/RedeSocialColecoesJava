import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/** Classe destinada ao painel de coleções*/
public class PainelColecao
{
   Usuario usuario;
   JPanel painel_newColecao;  
   JLabel  lb_suasColecoes; 
   JButton bt_undo, bt_redu, bt_addNovaColecao;
   
   JButton[] botoesColecao = new JButton[7];
   JButton[] addColecao = new JButton[7];
   
   private int vAtual;
      
   Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
   
   PainelColecao(Usuario eu){
    usuario = eu;
    //-----painel para add colecao-----
    painel_newColecao = new JPanel();
    painel_newColecao.setBorder(new javax.swing.border.TitledBorder(""));
    painel_newColecao.setVisible(true);
    painel_newColecao.setLayout(null);
    painel_newColecao.setBounds(220,50,650,560);
       
       //-------------------------------atributos do panel para add colecao------------------------------
       
    lb_suasColecoes = new JLabel("Voce Tem "+usuario.getColecao().size()+" coleçâo(es)",JLabel.CENTER);
    lb_suasColecoes.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
    lb_suasColecoes.setBorder(new javax.swing.border.TitledBorder(""));
    lb_suasColecoes.setBounds(10,10,550,30);
    painel_newColecao.add(lb_suasColecoes);
       
     //----------------------------------botão undo ------------------------------------------------------
       
     bt_undo = new JButton("");
     bt_undo.setBounds(570,10,30,30);
     bt_undo.setIcon(new ImageIcon("img/undo.jpg"));
     painel_newColecao.add(bt_undo);
     bt_undo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
               if(usuario.getUltimaColecao().size() != 0){
                int i = usuario.getUltimaColecao().get(usuario.getUltimaColecao().size()-1);
                 usuario.deletaNull();}
                usuario.undo();
                attGoColecao();
            }
        });
       
       bt_redu = new JButton("");
       bt_redu.setBounds(610,10,30,30);
       bt_redu.setIcon(new ImageIcon("img/redu.jpg"));
       painel_newColecao.add(bt_redu);
       bt_redu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                usuario.redu();
                attGoColecao();
            }
        });
       //--------botão para adicinar um coleção nova--------------
       bt_addNovaColecao = new JButton("Nova coleção");
       bt_addNovaColecao.setBounds(450,50,190,30);
       bt_addNovaColecao.setFont(fonte2);
       painel_newColecao.add(bt_addNovaColecao );
       bt_addNovaColecao.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                Object[] itens = { "Jogos", "HotWheels", "Cartoes Telefonicos","Camisetas de Times","Quadrinhos","Moedas" };
                Object selectedValue = JOptionPane.showInputDialog(null,
                "Escolha um item", "Opçao",
                JOptionPane.INFORMATION_MESSAGE, null,
                itens, itens [0]);
                String selecionado =""+selectedValue;
                if(selectedValue == null){JOptionPane.showMessageDialog(null,"Operação cancelada");}
                else if(!usuario.getTodasColecoes().contains(selecionado)){
                 usuario.setColecao(selecionado);
                 usuario.addEventoIncluirColecao(selecionado);
                }
                else{
                 JOptionPane.showMessageDialog(null,"Você ja tem esta coleção");
                }
                selecionado ="";
                lb_suasColecoes.setText("Voce Tem "+usuario.getColecao().size()+" coleçâo(es)");
                painel_newColecao.repaint();
                gerarBotoes();
            }
        });
      bt_undo.setToolTipText(" Desfazer ação ");
      bt_redu.setToolTipText(" Refazer ação ");  
      bt_addNovaColecao.setToolTipText(" Adicionar uma nova coleção ");
      gerarBotoes();
    }
    
   //gera os botões na tela
    public void gerarBotoes(){
      int x = 50;
      //---------este for coloca todas as coleçoes existentes-------
      for( int i=0;i<usuario.getColecao().size();i++){
          JLabel lb_imgColecao = new JLabel();
          lb_imgColecao.setBounds(10,x,90,30);
          ImageIcon img = new ImageIcon ("img/"+usuario.getNomeColecao(i)+".png");  
          img.setImage(img.getImage().getScaledInstance(90,30, 100)); 
          lb_imgColecao.setIcon(img);
          
          botoesColecao[i] = new JButton(usuario.getNomeColecao(i)); addColecao[i] = new JButton("Add+");
          botoesColecao[i].setFont(fonte2); addColecao[i].setFont(fonte2);
          botoesColecao[i].setBounds(100,x,250,30); addColecao[i].setBounds(360,x,80,30);
          x += 40;final int j = i;//usado para o botão inteder
          botoesColecao[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){
           usuario.deletaNull();
           vAtual = j;//guarda a colecao atual
           
           painel_newColecao.setLayout(new BorderLayout()); 
           painel_newColecao.removeAll();
           painel_newColecao.add(new PainelItens(usuario,vAtual,painel_newColecao).getPainel(), BorderLayout.CENTER);  
           painel_newColecao.validate();  
          }});
                   
          addColecao[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){usuario.deletaNull();usuario.addNovo(j); }});
                        
          painel_newColecao.add(botoesColecao[i]);painel_newColecao.add(addColecao[i]);
          painel_newColecao.add(lb_imgColecao);
          botoesColecao[i].setToolTipText(" Visualizar itens ");
          addColecao[i].setToolTipText(" Adicionar item a coleção ");
                                   }
           } 
                        
    //atualiza a tela de Colecao
    public void attGoColecao(){
     painel_newColecao.removeAll();
     painel_newColecao.add(bt_undo);
     painel_newColecao.add(bt_redu);
     painel_newColecao.add(bt_addNovaColecao);
     lb_suasColecoes.setText("Voce Tem "+usuario.getColecao().size()+" coleçâo(es)");
     painel_newColecao.add(lb_suasColecoes);
     gerarBotoes();
     painel_newColecao.repaint();
    }       
           
    public JPanel getPainel(){
     return painel_newColecao;
    }                   
}
