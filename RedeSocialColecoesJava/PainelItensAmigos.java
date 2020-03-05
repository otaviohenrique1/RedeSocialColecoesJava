import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/** Classe destinada ao painel de itens de amigos*/
public class PainelItensAmigos
{
    JPanel painel_itens, painel_todos;
    JScrollPane scroll_panel;
    Usuario amigo;
    JComboBox cb_colecao;
    JButton procurar;
    Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
    
    PainelItensAmigos(Usuario amigo){
       this.amigo = amigo;
       painel_itens = new JPanel();
       painel_itens.setVisible(true);
       painel_itens.setLayout(null);
       painel_itens.setBounds(0,0,650,560);}
       
    //metodo destinado a mostrar as coleçoes e itens dos amigos
    public JPanel mostraItensAmigo(){
        
        JLabel lb_colecaoAmigo = new JLabel("Coleções do(a) "+amigo.getNome(),JLabel.CENTER);
        lb_colecaoAmigo.setBorder(new javax.swing.border.TitledBorder(""));
        lb_colecaoAmigo.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        lb_colecaoAmigo.setBounds(10, 10, 630, 30);
        painel_itens.add(lb_colecaoAmigo);
        
        cb_colecao = new JComboBox();
        if(amigo.getTodasColecoes().size() > 0){
        for(int i=0;i<amigo.getTodasColecoes().size();i++){
          cb_colecao.addItem(amigo.getNomeColecao(i)+" ("+amigo.getTamanho(i)+")");
        }}
        else{
          cb_colecao.addItem("Não há Coleções");
        }
        cb_colecao.setBounds(100, 50, 300, 30);
        cb_colecao.setFont(fonte2);
        painel_itens.add(cb_colecao);
        
        procurar = new JButton("Ver Itens");
        procurar.setBounds(410, 50, 150, 30);
        procurar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){
        if(amigo.getTodasColecoes().size() > 0){
            painel_todos.removeAll();
            gerarListaItens(cb_colecao.getSelectedIndex());}}});  
        procurar.setFont(fonte2);
        painel_itens.add(procurar);
        
        // painel find_friends
       painel_todos = new JPanel();
       painel_todos.setLayout(null);
       painel_todos.setBounds(0,0,560,510);
       painel_todos.setVisible(true);
 
       //scroll do panel add amigos
       scroll_panel = new JScrollPane(painel_todos);
       scroll_panel.setBounds(9,90,630,460);
       scroll_panel.setVisible(true);
       scroll_panel.setBorder(new javax.swing.border.TitledBorder(""));
       scroll_panel.setHorizontalScrollBarPolicy(scroll_panel.HORIZONTAL_SCROLLBAR_NEVER);
       painel_itens.add(scroll_panel);
        
        painel_itens.repaint();
        return painel_itens;
    }
    
    public void gerarListaItens(int pos){
     JLabel[] JL_todosItens = new JLabel[amigo.getItens(pos).size()]; //vetor de JLabeas para guardar itens
     JButton[] JB_detalhes = new JButton[amigo.getItens(pos).size()];  //vetor de JButtons para acesar odetale individual
     JButton[] JB_Comentar = new JButton[amigo.getItens(pos).size()]; //vetor de JButtons para excluir um item;
     JButton[] JB_naoCurtir = new JButton[amigo.getItens(pos).size()]; //vetor de JButtons para Alterar um item;
     JButton[] JB_Curtir = new JButton[amigo.getItens(pos).size()];//vetor de JButtons para trancar intem
     
     int x = 5;final int ps = pos; //o final guarda um valor para o botão entender
     String aux;
     String[] nomes;
     //---------este for coloca todas as coleçoes existentes-------
     for( int i=0;i<amigo.getItens(pos).size();i++){
      if(amigo.getVer(pos,i)){   
      aux = ""+amigo.getItens(pos).get(i);
      nomes = aux.split(",");  final int I =i;final String nome = nomes[0];//o final guarda um valor para o botão entender
      JL_todosItens[i] = new JLabel(nomes[0],JLabel.CENTER);                        JB_detalhes[i] = new JButton("Detalhes");   JB_Comentar[i] = new JButton("");      JB_naoCurtir[i] = new JButton(""); 
      JL_todosItens[i].setBounds(5,x,405,30);                                      JB_detalhes[i].setBounds(506,x,120,30);     JB_Comentar[i].setBounds(474,x,30,30); JB_naoCurtir[i].setBounds(443,x,30,30);
      JL_todosItens[i].setFont(fonte2);       JB_detalhes[i].setFont(fonte2);
      JL_todosItens[i].setBorder(new javax.swing.border.TitledBorder(""));
      JB_Curtir[i] = new JButton();
      JB_Curtir[i].setBounds(411,(x-1),30,30);
      ImageIcon img4;
      img4 = new ImageIcon ("img/gostei.png");
      img4.setImage(img4.getImage().getScaledInstance(31,30, 100)); 
      JB_Curtir[i].setIcon(img4);
      //imagens alterar
      ImageIcon img3 = new ImageIcon ("img/naogostei.png");  
      img3.setImage(img3.getImage().getScaledInstance(30,30, 100)); 
      JB_naoCurtir[i].setIcon(img3);
      //imagens lixo
      ImageIcon img2 = new ImageIcon ("img/comentar.png");  
      img2.setImage(img2.getImage().getScaledInstance(30,30, 100)); 
      JB_Comentar[i].setIcon(img2);
      
      final int X =x;
                
      painel_todos.add(JL_todosItens[i]);painel_todos.add(JB_detalhes[i]);painel_todos.add(JB_Comentar[i]);
      painel_todos.add(JB_naoCurtir[i]);painel_todos.add(JB_Curtir[i]);
      JB_Comentar[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){
         JTextField novoComentario = new JTextField(80);
         novoComentario.setBounds(5,X+30,500,30); 
         painel_todos.add(novoComentario);
         
         JButton enviar = new JButton("Enviar");
         enviar.setBounds(506,X+30,120,30); 
         enviar.setFont(fonte2); 
         painel_todos.add(enviar);
         painel_todos.repaint();
      }}); 
      
      JB_detalhes[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){
          gerarDetalhes(ps, I);
        }});    
     
      x += 40;
      painel_todos.repaint();
      }
     }
     painel_todos.setSize(640, x);
     painel_todos.setPreferredSize(painel_todos.getSize());
    }
    
    //gera detalhes de um item expecifico
    public void gerarDetalhes(final int pos, int pos2)
    {
        painel_todos.removeAll();
        String aux = ""+amigo.getItens(pos).get(pos2);
        String[] nomes = aux.split(",");  
        int x = 120;
        //imagem do item
        JLabel img = new JLabel();
        ImageIcon img2 = new ImageIcon (nomes[1]);  
        img2.setImage(img2.getImage().getScaledInstance(100,100, 100)); 
        img.setIcon(img2);
        img.setBounds(5,10,100,100);
        img.setBorder(new javax.swing.border.TitledBorder(""));
        painel_todos.add(img);
        
        //nome do item
        JLabel nome = new JLabel(nomes[0],JLabel.CENTER);
        nome.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 30));
        nome.setBounds(115,10,520,100);
        nome.setBorder(new javax.swing.border.TitledBorder(""));
        painel_todos.add(nome);
        
        JLabel[] JL_mostrarItens = new JLabel[nomes.length];
        for(int i = 2; i<nomes.length; i++){
            if(!(nomes[i].indexOf("null") >= 0) && nomes[i].matches("^.*\\: .+")){
             JL_mostrarItens[i] = new JLabel(nomes[i]);
             JL_mostrarItens[i].setBounds(5,x,630,30);
             JL_mostrarItens[i].setFont(fonte2);
             painel_todos.add(JL_mostrarItens[i]);
             x += 40;
            }
        }
        JButton retornar = new JButton("Voltar");
        retornar.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        retornar.setBounds(10,x,200,30); final int j = pos;
        retornar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0){
         painel_todos.removeAll();
              gerarListaItens(pos);
              painel_todos.repaint();
        }}); 
        x += 40;
        retornar.setToolTipText(" Retornar a lista de itens ");
        painel_todos.add(retornar);
        painel_todos.setSize(560, x);
        painel_todos.setPreferredSize(painel_todos.getSize());
        painel_todos.repaint();
    }
     
}
