import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Classe destina ao painel de amigos de um amigo */
public class PainelAmigosDoAmigo
{
   Cadastro cadastro = new Cadastro();
   Grafos grafos = new Grafos();
   
    // componentes amigos;
    JLabel lbf_titulo1;
    JButton bt_irProcurar, bt_buscarJaCadastrado, bt_mostrarTudo, bt_voltar;
    JTextField tf_buscar;
    JPanel painel_amigos,painel_find_friends;
    JScrollPane scroll_panel_add_amigos;
    JLabel lb_nome_friend, lb_img_friend, lb_nColecao, lb_nItem;
    
    
    Font fonteT1 = new Font("Arial",Font.BOLD + Font.PLAIN, 16);
    Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
   
   PainelAmigosDoAmigo(final int idAmigo){
       painel_amigos = new JPanel();
       painel_amigos.setLayout(null);
       painel_amigos.setBounds(220,50,650,560);
       painel_amigos.setVisible(true);
       
       final JTextField jt_Buscar = new JTextField(40);
       jt_Buscar.setFont(fonteT1);
       jt_Buscar.setBounds(10, 60, 190, 30);
       jt_Buscar.setForeground(Color.gray);
       jt_Buscar.setText("Pesquise aqui");
       jt_Buscar.addMouseListener(new MouseAdapter() { @Override 
        public void mouseClicked(MouseEvent e){
         jt_Buscar.setText(null);
         jt_Buscar.setForeground(Color.black);
        }});
       jt_Buscar.addKeyListener(new KeyListener(){
       @Override
       public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){mostrarAmigos(jt_Buscar.getText(),idAmigo); }
       }
       @Override public void keyTyped(KeyEvent e) {}
       @Override public void keyReleased(KeyEvent e) {}
      }); 
       painel_amigos.add(jt_Buscar);
       
       bt_buscarJaCadastrado = new JButton(new ImageIcon(getClass().getResource("img/lupa1.png")));
       bt_buscarJaCadastrado.setFont(fonte2);
       bt_buscarJaCadastrado.setBounds(210, 60, 32, 30);
       painel_amigos.add(bt_buscarJaCadastrado); 
       bt_buscarJaCadastrado.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
         mostrarAmigos(jt_Buscar.getText(),idAmigo);
        }});
       
       bt_irProcurar = new JButton("Amigos em Comum");
       bt_irProcurar.setFont(fonte2);
       bt_irProcurar.setBounds(250, 60, 210, 30);
       painel_amigos.add(bt_irProcurar);
       bt_irProcurar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(    ActionEvent e) {
            mostrarAmigosEmComum(idAmigo);
        }});
        
       bt_mostrarTudo = new JButton("Mostrar todos");
       bt_mostrarTudo.setFont(fonte2);
       bt_mostrarTudo.setBounds(470, 60, 170, 30);
       painel_amigos.add(bt_mostrarTudo);
       bt_mostrarTudo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(    ActionEvent e) {
          mostrarAmigos("",idAmigo);  
        }});
        
        bt_voltar = new JButton();
       ImageIcon img3 = new ImageIcon (getClass().getResource("img/voltar.png"));  
       img3.setImage(img3.getImage().getScaledInstance(34,34, 100)); 
       bt_voltar.setIcon(img3);
       bt_voltar.setBounds(10,10,30,30);
       painel_amigos.add(bt_voltar);
       
       bt_voltar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
              painel_amigos.setLayout(new BorderLayout()); 
              painel_amigos.removeAll();
              painel_amigos.add(new PainelPerfil(idAmigo,10,new JLabel(),0).getPanel());
              painel_amigos.revalidate();
            }
        });
       
       lbf_titulo1 = new JLabel("Amigos ( "+grafos.todosAmigos(idAmigo).size()+" ) do(a) "+cadastro.getNomeUsuario(idAmigo),JLabel.CENTER);
       lbf_titulo1.setBounds(50, 10, 590, 30);
       lbf_titulo1.setBorder(new javax.swing.border.TitledBorder(""));
       lbf_titulo1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
       painel_amigos.add(lbf_titulo1);      
      
            
       // painel find_friends
       painel_find_friends = new JPanel();
       painel_find_friends.setLayout(null);
       painel_find_friends.setBounds(0,0,560,510);
       painel_find_friends.setVisible(true);
 
       //scroll do panel add amigos
       scroll_panel_add_amigos = new JScrollPane(painel_find_friends);
       scroll_panel_add_amigos.setBounds(10,110,630,440);
       scroll_panel_add_amigos.setVisible(true);
       scroll_panel_add_amigos.setBorder(new javax.swing.border.TitledBorder(""));
       scroll_panel_add_amigos.setHorizontalScrollBarPolicy(scroll_panel_add_amigos.HORIZONTAL_SCROLLBAR_NEVER);
       painel_amigos.add(scroll_panel_add_amigos);
       
    mostrarAmigos("",idAmigo);
    }
   
   //metodo espesifico para mostrar os amigos do usuario
    public void mostrarAmigos(String nome,final int idAmigo){
        painel_find_friends.removeAll(); // reseta painel
        painel_find_friends.setVisible(true);   scroll_panel_add_amigos.setVisible(true);  
        String nome_friend, numeroColecao, img_friend, nItens;
        
        int x = 20;int conta = -1;
        int y = 140;
        for(int i = 0; i < grafos.todosAmigos(idAmigo).size(); i++){
             nome_friend = cadastro.getNomeUsuario(grafos.todosAmigos(idAmigo).get(i));
             numeroColecao = ""+cadastro.getNColecao(grafos.todosAmigos(idAmigo).get(i));
             nItens = ""+cadastro.getNItens(grafos.todosAmigos(idAmigo).get(i));
             img_friend = cadastro.getFoto(grafos.todosAmigos(idAmigo).get(i));
             final int indice_users = i;
            
             if(nome_friend.toLowerCase().contains(nome.toLowerCase())) {
                  conta++;
                     // imagem
                    
                     ImageIcon img2;
                     if(img_friend.equals("")){img2 = new ImageIcon(getClass().getResource("img/usuario.jpg"));}
                     else{ img2 = new ImageIcon(img_friend);}
                      
                     img2.setImage(img2.getImage().getScaledInstance(100,100, 100)); 
                     lb_img_friend = new JLabel(img2);
                     lb_img_friend.setBounds(y-120, x, 100, 100);
                     painel_find_friends.add(lb_img_friend);
                     
                     // nome
                     lb_nome_friend = new JLabel(nome_friend);
                     lb_nome_friend.setBounds(y, x, 400, 20);
                     painel_find_friends.add(lb_nome_friend);
                     
                     // Numero de coleções 
                     lb_nColecao = new JLabel("Coleção(es): "+numeroColecao);
                     lb_nColecao.setBounds(y, x+25, 200, 20);
                     painel_find_friends.add(lb_nColecao);
                     
                     // Numero de Itens
                     lb_nItem = new JLabel("Total de Itens: "+nItens);
                     lb_nItem.setBounds(y, x+50, 200, 20);
                     painel_find_friends.add(lb_nItem);
                     
                     JButton bt_Ver_Perfil = new JButton("Perfil");
                     bt_Ver_Perfil.addActionListener( new ActionListener(){ @Override
                     public void actionPerformed(ActionEvent e){
                      if(cadastro.getQuemVe(grafos.todosAmigos(idAmigo).get(indice_users)) != 0) {
                        painel_amigos.removeAll();
                        JPanel novo = new JPanel();
                        if(cadastro.getIndice() != grafos.todosAmigos(idAmigo).get(indice_users)){
                         novo = new PainelPerfil(grafos.todosAmigos(idAmigo).get(indice_users),10,new JLabel(),0).getPanel();}
                        else{
                         novo = new PainelPerfil(cadastro.getIndice(),0,new JLabel(),0).getPanel();   
                        }
                        novo.setBounds(0,0,650,560);
                        painel_amigos.add(novo);
                        painel_amigos.repaint();
                      }
                       else{JOptionPane.showMessageDialog(null, "Informações restritas");}
                         }                           
                    });
                     bt_Ver_Perfil.setBounds(y, x+75, 70, 20);                    
                     painel_find_friends.add(bt_Ver_Perfil);
                     
                     
                    
                     if(conta%2 == 0){y +=310;}
                     else{y -=310;x += 120;  } 
                    }
            }
        if(grafos.todosAmigos(cadastro.getIndice()).size()%2 != 0){x += 120;}
        painel_find_friends.setSize(560, x);
        painel_find_friends.setPreferredSize(painel_find_friends.getSize());
        painel_find_friends.repaint();
    }  
    
    //metodo espesifico para mostrar os amigos em comum do usuario logado com o usuario que estiver no perfil
    public void mostrarAmigosEmComum(final int idAmigo){
        painel_find_friends.removeAll(); // reseta painel
        painel_find_friends.setVisible(true);   scroll_panel_add_amigos.setVisible(true);  
        String nome_friend, numeroColecao, img_friend, nItens;
        
        int x = 20;int conta = -1;
        int y = 140;
        for(int i = 0; i < grafos.amigosEmComum(cadastro.getIndice(),idAmigo).size(); i++){
             nome_friend = cadastro.getNomeUsuario(grafos.amigosEmComum(cadastro.getIndice(),idAmigo).get(i));
             numeroColecao = ""+cadastro.getNColecao(grafos.amigosEmComum(cadastro.getIndice(),idAmigo).get(i));
             nItens = ""+cadastro.getNItens(grafos.amigosEmComum(cadastro.getIndice(),idAmigo).get(i));
             img_friend = cadastro.getFoto(grafos.amigosEmComum(cadastro.getIndice(),idAmigo).get(i));
             final int indice_users = i;
            
             
                  conta++;
                     // imagem
                    
                     ImageIcon img2;
                     if(img_friend.equals("")){img2 = new ImageIcon(getClass().getResource("img/usuario.jpg"));}
                     else{ img2 = new ImageIcon(img_friend);}
                      
                     img2.setImage(img2.getImage().getScaledInstance(100,100, 100)); 
                     lb_img_friend = new JLabel(img2);
                     lb_img_friend.setBounds(y-120, x, 100, 100);
                     painel_find_friends.add(lb_img_friend);
                     
                     // nome
                     lb_nome_friend = new JLabel(nome_friend);
                     lb_nome_friend.setBounds(y, x, 400, 20);
                     painel_find_friends.add(lb_nome_friend);
                     
                     // Numero de coleções 
                     lb_nColecao = new JLabel("Coleção(es): "+numeroColecao);
                     lb_nColecao.setBounds(y, x+25, 200, 20);
                     painel_find_friends.add(lb_nColecao);
                     
                     // Numero de Itens
                     lb_nItem = new JLabel("Total de Itens: "+nItens);
                     lb_nItem.setBounds(y, x+50, 200, 20);
                     painel_find_friends.add(lb_nItem);
                     
                     JButton bt_Ver_Perfil = new JButton("Perfil");
                     bt_Ver_Perfil.addActionListener( new ActionListener(){ @Override
                     public void actionPerformed(ActionEvent e){
                      if(cadastro.getQuemVe(grafos.amigosEmComum(cadastro.getIndice(),idAmigo).get(indice_users)) != 0) {
                        painel_amigos.removeAll();
                        JPanel novo = new JPanel();
                        if(cadastro.getIndice() != grafos.amigosEmComum(cadastro.getIndice(),idAmigo).get(indice_users)){
                         novo = new PainelPerfil(grafos.amigosEmComum(cadastro.getIndice(),idAmigo).get(indice_users),10,new JLabel(),0).getPanel();}
                        else{
                         novo = new PainelPerfil(cadastro.getIndice(),0,new JLabel(),0).getPanel();   
                        }
                        novo.setBounds(0,0,650,560);
                        painel_amigos.add(novo);
                        painel_amigos.repaint();
                      }
                       else{JOptionPane.showMessageDialog(null, "Informações restritas");}
                         }                           
                    });
                     bt_Ver_Perfil.setBounds(y, x+75, 70, 20);                    
                     painel_find_friends.add(bt_Ver_Perfil);
                     
                     
                    
                     if(conta%2 == 0){y +=310;}
                     else{y -=310;x += 120;  } 
                    
            }
        if(grafos.amigosEmComum(cadastro.getIndice(),idAmigo).size()%2 != 0){x += 120;}
        painel_find_friends.setSize(560, x);
        painel_find_friends.setPreferredSize(painel_find_friends.getSize());
        painel_find_friends.repaint();
    }  
    
   public JPanel getPainel(){
    return painel_amigos;
    }
}
