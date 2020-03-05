import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
import javax.swing.text.*;
import java.text.SimpleDateFormat;
import javax.swing.ActionMap;  
import javax.swing.InputMap;  
import javax.swing.AbstractAction;  

public class PainelItens
{
    Usuario usuario;
    JLabel lb_seusItens; 
    JPanel painel, painel_scroll;
    JScrollPane scroll_panel_itens;
    JButton bt_voltar, bt_atualizar;
    
    private int vAtual;
    
    Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
    
    PainelItens(Usuario eu, int valor,final JPanel voltar){
     vAtual = valor;
     usuario = eu;
     
     painel = new JPanel();
     painel.setLayout(null);
     painel.setBounds(0,0,650,560);
     painel.setVisible(true);
     
     painel_scroll = new JPanel();
     painel_scroll.setLayout(null);
     painel_scroll.setBounds(0,0,640,505);
     painel_scroll.setVisible(true);
     
       scroll_panel_itens = new JScrollPane(painel_scroll);
       scroll_panel_itens.setBounds(4,50,640,505);
       scroll_panel_itens.setVisible(true);
       scroll_panel_itens.setBorder(new javax.swing.border.TitledBorder(""));
       scroll_panel_itens.setHorizontalScrollBarPolicy(scroll_panel_itens.HORIZONTAL_SCROLLBAR_NEVER);
       scroll_panel_itens.validate();
       painel.add(scroll_panel_itens);
       //-------------------------------atributos do panel para visualizar itens------------------------------
       
       lb_seusItens = new JLabel("Voce Tem "+usuario.getTamanho(vAtual)+" iten(s)",JLabel.CENTER);
       lb_seusItens.setFont(fonte2);
       lb_seusItens.setBorder(new javax.swing.border.TitledBorder(""));
       lb_seusItens.setBounds(50,10,550,30);
       painel.add(lb_seusItens);
       
       //botão voltar a seu coleção
       bt_voltar = new JButton("");
       ImageIcon img3 = new ImageIcon ("img/voltar.png");  
       img3.setImage(img3.getImage().getScaledInstance(34,34, 100)); 
       bt_voltar.setIcon(img3);
       bt_voltar.setBounds(10,10,30,30);
       painel.add(bt_voltar);
       
       bt_voltar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
              voltar.removeAll();
              JPanel novo = new JPanel();
              novo = new PainelColecao(usuario).getPainel();
              novo.setBounds(0,0,650,560);
              voltar.add(novo);
              voltar.repaint();
            }
        });
      
       //botão atualizar lista de itens *************************
       bt_atualizar = new JButton("");
       bt_atualizar.setBounds(610,10,30,30);
       bt_atualizar.setIcon(new ImageIcon("img/atualizar.png"));
       painel.add(bt_atualizar);
       bt_atualizar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
              painel_scroll.removeAll();
              lb_seusItens.setText("Voce Tem "+usuario.getTamanho(vAtual)+" iten(s)");
              gerarListaItens(vAtual);
              painel_scroll.repaint();
            }
        });
        
       gerarListaItens(vAtual);
       bt_atualizar.setToolTipText(" Atualizar dados dos itens "); 
       bt_voltar.setToolTipText(" Voltar para as suas coleções "); 
    }
    
    //gerar lista de itens 
   public void gerarListaItens(int pos){
     JLabel[] JL_todosItens = new JLabel[usuario.getItens(pos).size()]; //vetor de JLabeas para guardar itens
     JButton[] JB_detalhes = new JButton[usuario.getItens(pos).size()];  //vetor de JButtons para acesar odetale individual
     JButton[] JB_Excluir = new JButton[usuario.getItens(pos).size()]; //vetor de JButtons para excluir um item;
     JButton[] JB_Alterar = new JButton[usuario.getItens(pos).size()]; //vetor de JButtons para Alterar um item;
     final JButton[] JB_Cadeado = new JButton[usuario.getItens(pos).size()];//vetor de JButtons para trancar intem
     
     int x = 5;final int ps = pos; //o final guarda um valor para o botão entender
     String aux;
     String[] nomes;
     //---------este for coloca todas as coleçoes existentes-------
     for( int i=0;i<usuario.getItens(pos).size();i++){
      aux = ""+usuario.getItens(pos).get(i);
      nomes = aux.split(",");  final int I =i;final String nome = nomes[0];//o final guarda um valor para o botão entender
      JL_todosItens[i] = new JLabel(nomes[0],JLabel.CENTER);                        JB_detalhes[i] = new JButton("Detalhes");   JB_Excluir[i] = new JButton("");      JB_Alterar[i] = new JButton(""); 
      JL_todosItens[i].setBounds(5,x,414,30);                                      JB_detalhes[i].setBounds(515,x,120,30);     JB_Excluir[i].setBounds(483,x,30,30); JB_Alterar[i].setBounds(452,x,30,30);
      JL_todosItens[i].setFont(fonte2);       JB_detalhes[i].setFont(fonte2);
      JL_todosItens[i].setBorder(new javax.swing.border.TitledBorder(""));
      JB_Cadeado[i] = new JButton();
      JB_Cadeado[i].setBounds(420,(x-1),30,30);
      ImageIcon img4;
      if(usuario.getVer(pos,i)){ img4 = new ImageIcon ("img/cadeadoverdeok.png");}
      else{img4 = new ImageIcon ("img/cadeadovermelho.png");}
      img4.setImage(img4.getImage().getScaledInstance(31,30, 100)); 
      JB_Cadeado[i].setIcon(img4);
      //imagens alterar
      ImageIcon img3 = new ImageIcon ("img/alterar.gif");  
      img3.setImage(img3.getImage().getScaledInstance(30,30, 100)); 
      JB_Alterar[i].setIcon(img3);
      //imagens lixo
      ImageIcon img2 = new ImageIcon ("img/lixo.png");  
      img2.setImage(img2.getImage().getScaledInstance(30,30, 100)); 
      JB_Excluir[i].setIcon(img2);
                
      painel_scroll.add(JL_todosItens[i]);painel_scroll.add(JB_detalhes[i]);painel_scroll.add(JB_Excluir[i]);
      painel_scroll.add(JB_Alterar[i]);painel_scroll.add(JB_Cadeado[i]);
      
      JB_detalhes[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){gerarDetalhes(ps, I); }});    
      JB_Excluir[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){
           JOptionPane.showMessageDialog(null,"O item '"+nome+"' foi removido com sucesso");
           usuario.deleteGuarda(ps,I);
           painel_scroll.removeAll();
           lb_seusItens.setText("Voce Tem "+usuario.getTamanho(vAtual)+" iten(s)");
           gerarListaItens(vAtual);
           painel_scroll.repaint();
       }}); 
      JB_Alterar[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){usuario.atualizarDados(ps,I); }});  
      JB_Cadeado[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){ 
          ImageIcon img4 = new ImageIcon ("img/cadeadovermelho.png");  
          img4.setImage(img4.getImage().getScaledInstance(31,30, 100)); 
         if(!JB_Cadeado[I].getIcon().toString().equals(img4.toString())){
             JB_Cadeado[I].setIcon(img4); usuario.setVer(ps,I);
            }
         else{
             img4 = new ImageIcon ("img/cadeadoverdeok.png");  
             img4.setImage(img4.getImage().getScaledInstance(31,30, 100)); 
             JB_Cadeado[I].setIcon(img4);usuario.setVer(ps,I);}
            }
        });
      
      x += 40;
      
      painel_scroll.setSize(560, x);
      painel_scroll.setPreferredSize(painel_scroll.getSize());
      
      JB_detalhes[i].setToolTipText(" Visualizar detalhes do item ");
      JB_Excluir[i].setToolTipText(" Excluir o item selecionado ");
      JB_Alterar[i].setToolTipText(" Alterar item selecionado ");
      
     }
     
    }
    
   
    //gera detalhes de um item expecifico
    public void gerarDetalhes(int pos, int pos2)
    {
        painel_scroll.removeAll();
        String aux = ""+usuario.getItens(pos).get(pos2);
        String[] nomes = aux.split(",");  
        int x = 120;
        //imagem do item
        JLabel img = new JLabel();
        ImageIcon img2 = new ImageIcon (nomes[1]);  
        img2.setImage(img2.getImage().getScaledInstance(100,100, 100)); 
        img.setIcon(img2);
        img.setBounds(5,10,100,100);
        img.setBorder(new javax.swing.border.TitledBorder(""));
        painel_scroll.add(img);
        
        //nome do item
        JLabel nome = new JLabel(nomes[0],JLabel.CENTER);
        nome.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 30));
        nome.setBounds(115,10,520,100);
        nome.setBorder(new javax.swing.border.TitledBorder(""));
        painel_scroll.add(nome);
        
        JLabel[] JL_mostrarItens = new JLabel[nomes.length];
        for(int i = 2; i<nomes.length; i++){
            if(!(nomes[i].indexOf("null") >= 0) && nomes[i].matches("^.*\\: .+")){
             JL_mostrarItens[i] = new JLabel(nomes[i]);
             JL_mostrarItens[i].setBounds(5,x,630,30);
             JL_mostrarItens[i].setFont(fonte2);
             painel_scroll.add(JL_mostrarItens[i]);
             x += 40;
            }
        }
        JButton retornar = new JButton("Voltar");
        retornar.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        retornar.setBounds(10,x,200,30); final int j = pos;
        retornar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){
         painel_scroll.removeAll();
              lb_seusItens.setText("Voce Tem "+usuario.getTamanho(vAtual)+" iten(s)");
              gerarListaItens(vAtual);
              painel_scroll.repaint();
        }}); 
        x += 40;
        retornar.setToolTipText(" Retornar a lista de itens ");
        painel_scroll.add(retornar);
        painel_scroll.setSize(560, x);
        painel_scroll.setPreferredSize(painel_scroll.getSize());
        painel_scroll.repaint();
    }
     
    
    public JPanel getPainel(){
     return painel;
    }
}
