import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/** Classe destinada ao paiel de amigos*/
public class PainelAmigos
{
    //intencias necessarias
    Usuario usuario;
    Cadastro cadastro = new Cadastro();
    Grafos grafos = new Grafos();
   
    // componentes friends;
    JLabel lbf_titulo1,lbf_titulo2,lb_lupa;
    JButton bt_buscar, adicionar_amigo, bt_mostrarPosiveisAmigos, bt_irProcurar, bt_buscarJaCadastrado, bt_voltar, bt_solitacoes;
    JTextField tf_buscar;
    JPanel painel_find_friends , painel_meus_amigos;
    JScrollPane scroll_panel_add_amigos;
    JLabel lb_nome_friend, lb_img_friend, lb_nColecao, lb_nItem;
    
    
    Font fonteT1 = new Font("Arial",Font.BOLD + Font.PLAIN, 16);
    Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
    
    //painel com todos os amigos ja addicionados
    
    PainelAmigos(Usuario eu, JButton bt_solitacoes){
        this.bt_solitacoes = bt_solitacoes;
       usuario = eu;
       painel_meus_amigos = new JPanel();
       painel_meus_amigos.setLayout(null);
       painel_meus_amigos.setBounds(220,50,650,560);
       painel_meus_amigos.setBorder(new javax.swing.border.TitledBorder(""));
       painel_meus_amigos.setVisible(true);
       
       final JTextField jt_Buscar = new JTextField(40);
       jt_Buscar.setFont(fonteT1);
       jt_Buscar.setBounds(10, 60, 210, 30);
       painel_meus_amigos.add(jt_Buscar);
       
       bt_buscarJaCadastrado = new JButton(new ImageIcon("img\\lupa1.png"));
       bt_buscarJaCadastrado.setFont(fonte2);
       bt_buscarJaCadastrado.setBounds(230, 60, 32, 30);
       painel_meus_amigos.add(bt_buscarJaCadastrado); 
       bt_buscarJaCadastrado.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
         mostrarMeusAmigos(jt_Buscar.getText());
        }});
       
       bt_irProcurar = new JButton("Procar Novos");
       bt_irProcurar.setFont(fonte2);
       bt_irProcurar.setBounds(355, 60, 220, 30);
       painel_meus_amigos.add(bt_irProcurar);
       bt_irProcurar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(    ActionEvent e) {
            painel_find_friends.removeAll();
            painel_find_friends.repaint();
            painel_meus_amigos.remove(lb_lupa);
            painel_meus_amigos.remove(lbf_titulo1);
            painel_meus_amigos.remove(bt_irProcurar);
            painel_meus_amigos.remove(jt_Buscar);
            painel_meus_amigos.remove(bt_buscarJaCadastrado);
            painel_meus_amigos.add(bt_buscar);
            painel_meus_amigos.add(lbf_titulo2);
            painel_meus_amigos.add(tf_buscar);
            painel_meus_amigos.add(bt_mostrarPosiveisAmigos);
            painel_meus_amigos.add(bt_voltar);
            painel_meus_amigos.repaint();
        }});
        
        lb_lupa = new JLabel(new ImageIcon("img\\lupa.png"));
        lb_lupa.setBounds(583, 50, 57, 50);
        painel_meus_amigos.add(lb_lupa);
        
       lbf_titulo1 = new JLabel("Meus Amigos ("+grafos.todosAmigos(cadastro.getIndice()).size()+")",JLabel.CENTER);
       lbf_titulo1.setBounds(10, 10, 630, 30);
       lbf_titulo1.setBorder(new javax.swing.border.TitledBorder(""));
       lbf_titulo1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
       painel_meus_amigos.add(lbf_titulo1);
       
       lbf_titulo2 = new JLabel("Novos Amigos",JLabel.CENTER);
       lbf_titulo2.setBounds(10, 10, 630, 30);
       lbf_titulo2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
       
       tf_buscar = new JTextField("");
       tf_buscar.setBounds(20, 60, 200, 30);
       
       bt_buscar = new JButton(new ImageIcon("img\\lupa1.png"));
       bt_buscar.setFont(fonte2);
       bt_buscar.setBounds(229, 60, 32, 30);
       
       bt_buscar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent arg0){
              findFriend(tf_buscar.getText());
          }
       });
       
       bt_mostrarPosiveisAmigos = new JButton("Mostrar Todos");
       bt_mostrarPosiveisAmigos.setFont(fonte2);
       bt_mostrarPosiveisAmigos.setBounds(272, 60, 170, 30);
       
       bt_mostrarPosiveisAmigos.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent arg0){
              findFriend("");
          }
       });
       
       bt_voltar = new JButton(new ImageIcon("img\\voltar.png"));
       bt_voltar.setBounds(600, 10, 43, 43);
       bt_voltar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent arg0){
            painel_meus_amigos.remove(bt_buscar);
            painel_meus_amigos.remove(lbf_titulo2);
            painel_meus_amigos.remove(tf_buscar);
            painel_meus_amigos.remove(bt_mostrarPosiveisAmigos);
            painel_meus_amigos.remove(bt_voltar);
             painel_meus_amigos.add(lb_lupa);
            painel_meus_amigos.add(lbf_titulo1);
            painel_meus_amigos.add(bt_irProcurar);
            painel_meus_amigos.add(jt_Buscar);
            painel_meus_amigos.add(bt_buscarJaCadastrado);
            painel_meus_amigos.repaint();
            mostrarMeusAmigos("");
          }});

       
       // painel find_friends
       painel_find_friends = new JPanel();
       painel_find_friends.setLayout(null);
       painel_find_friends.setBounds(0,0,560,510);
       painel_find_friends.setVisible(true);
 
       //scroll do panel add amigos
       scroll_panel_add_amigos = new JScrollPane(painel_find_friends);
       scroll_panel_add_amigos.setBounds(10,110,630,440);
       scroll_panel_add_amigos.setVisible(false);
       scroll_panel_add_amigos.setBorder(new javax.swing.border.TitledBorder(""));
       scroll_panel_add_amigos.setHorizontalScrollBarPolicy(scroll_panel_add_amigos.HORIZONTAL_SCROLLBAR_NEVER);
       painel_meus_amigos.add(scroll_panel_add_amigos);
       
       mostrarMeusAmigos("");
   }
   
   //metodo espesifico para mostrar os amigos do usuario
    public void mostrarMeusAmigos(String nome){
        painel_find_friends.removeAll(); // reseta painel
        painel_find_friends.setVisible(true);   scroll_panel_add_amigos.setVisible(true);  
        String nome_friend, numeroColecao, img_friend, nItens;
        
        int x = 20;int conta = -1;
        int y = 140;
        for(int i = 0; i < grafos.todosAmigos(cadastro.getIndice()).size(); i++){
             nome_friend = cadastro.getNomeUsuario(grafos.todosAmigos(cadastro.getIndice()).get(i));
             numeroColecao = ""+cadastro.getNColecao(grafos.todosAmigos(cadastro.getIndice()).get(i));
             nItens = ""+cadastro.getNItens(grafos.todosAmigos(cadastro.getIndice()).get(i));
             img_friend = cadastro.getFoto(grafos.todosAmigos(cadastro.getIndice()).get(i));
             final int indice_users = i;
            
             if(nome_friend.toLowerCase().contains(nome.toLowerCase())) {
                  conta++;
                     // imagem
                     ImageIcon img2 = new ImageIcon(img_friend);  
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
                      if(cadastro.getQuemVe(grafos.todosAmigos(cadastro.getIndice()).get(indice_users)) != 0) {
                        painel_meus_amigos.removeAll();
                        JPanel novo = new JPanel();
                        novo = new PainelPerfil(usuario,grafos.todosAmigos(cadastro.getIndice()).get(indice_users),10,new JLabel("")).getPanel();
                        novo.setBounds(0,0,650,560);
                        painel_meus_amigos.add(novo);
                        painel_meus_amigos.repaint();
                      }
                       else{JOptionPane.showMessageDialog(null, "Informações restritas");}
                         }                           
                    });
                     bt_Ver_Perfil.setBounds(y, x+75, 70, 20);                    
                     painel_find_friends.add(bt_Ver_Perfil);
                     
                     JButton bt_Excluir_amigo = new JButton("Excluir");
                     bt_Excluir_amigo.addActionListener( new ActionListener(){ @Override
                     public void actionPerformed(ActionEvent e){
                      int x = JOptionPane.showConfirmDialog(null,"Tem serteza que deseja excluir este amigo?");
                      if(x == 0){
                      grafos.recusarPedido(cadastro.getIndice(), grafos.todosAmigos(cadastro.getIndice()).get(indice_users));
                      JOptionPane.showMessageDialog(null, "Amigo excluido com sucesso!");
                      mostrarMeusAmigos("");//preencheAmigosLateral();
                      lbf_titulo1.setText("Meus Amigos ("+grafos.todosAmigos(cadastro.getIndice()).size()+")");}
                         }                           
                    });
                     
                     bt_Excluir_amigo.setBounds(y+80, x+75, 70, 20);                    
                     painel_find_friends.add(bt_Excluir_amigo);
                    
                     if(conta%2 == 0){y +=310;}
                     else{y -=310;x += 120;  } 
                    }
            }
        if(grafos.todosAmigos(cadastro.getIndice()).size()%2 != 0){x += 120;}
        painel_find_friends.setSize(560, x);
        painel_find_friends.setPreferredSize(painel_find_friends.getSize());
        painel_find_friends.repaint();
    }
    
    // Métodos firendly
    public void findFriend(String nome){ 
        painel_find_friends.removeAll(); // reseta painel
        painel_find_friends.setVisible(true);   scroll_panel_add_amigos.setVisible(true);       
        String nome_friend, numeroColecao, img_friend, nItens;
        
        int x = 20; int conta = -1;
        int w = 140;
        for(int i = 0; i < grafos.todosNaoAmigos(cadastro.getIndice()).size(); i++){
            
             nome_friend = cadastro.getNomeUsuario(grafos.todosNaoAmigos(cadastro.getIndice()).get(i));
             numeroColecao = ""+cadastro.getNColecao(grafos.todosNaoAmigos(cadastro.getIndice()).get(i));
             nItens = ""+cadastro.getNItens(grafos.todosNaoAmigos(cadastro.getIndice()).get(i));
             img_friend = cadastro.getFoto(grafos.todosNaoAmigos(cadastro.getIndice()).get(i));
             final int indice_users = i;
                         
             final JButton bt_send_invitation = new JButton("Enviar Solicitação");
             bt_send_invitation.addActionListener( new ActionListener(){ @Override
             public void actionPerformed(ActionEvent e){
              grafos.fazerPedido(cadastro.getIndice(), grafos.todosNaoAmigos(cadastro.getIndice()).get(indice_users));
              JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");
              findFriend("");
              bt_solitacoes.setText(""+grafos.getNumeroDesolicitacao(cadastro.getIndice()));
              if(bt_send_invitation.getText().equals("Aceitar Pedido")){  
               usuario.addEvendoNovoAmigo(cadastro.getNomeUsuario(grafos.todosNaoAmigos(cadastro.getIndice()).get(indice_users)));
               //preencheAmigosLateral();
              }
                 }                           
            });
             
             if(nome_friend.toLowerCase().contains(nome.toLowerCase())) {
                 conta++;
                     // imagem
                     ImageIcon img2 = new ImageIcon (img_friend);  
                     img2.setImage(img2.getImage().getScaledInstance(100,100, 100)); 
                     lb_img_friend = new JLabel(img2);
                     lb_img_friend.setBounds(w-120, x, 100, 100);
                     painel_find_friends.add(lb_img_friend);
                     
                     // nome
                     lb_nome_friend = new JLabel(nome_friend);
                     lb_nome_friend.setBounds(w, x, 400, 20);
                     painel_find_friends.add(lb_nome_friend);
                     
                     // Numero de coleções 
                     lb_nColecao = new JLabel("Coleção(es): "+numeroColecao);
                     lb_nColecao.setBounds(w, x+25, 200, 20);
                     painel_find_friends.add(lb_nColecao);
                     
                     // Numero de Itens
                     lb_nItem = new JLabel("Total de Itens: "+nItens);
                     lb_nItem.setBounds(w, x+50, 200, 20);
                     painel_find_friends.add(lb_nItem);
                     
                     // send           
                    if(grafos.verSolicitacao(cadastro.getIndice()).contains(grafos.todosNaoAmigos(cadastro.getIndice()).get(i))){
                        bt_send_invitation.setText("Aceitar Pedido");
                        }
                     if(!grafos.verSolicitacao(grafos.todosNaoAmigos(cadastro.getIndice()).get(i)).contains(cadastro.getIndice())){
                      bt_send_invitation.setBounds(w, x+75, 150, 20);                    
                      painel_find_friends.add(bt_send_invitation);
                    }
                 
                 if(conta%2 == 0){w +=310;}
                 else{w -=310;x += 120;  }         
            }
        }
        if(grafos.todosNaoAmigos(cadastro.getIndice()).size()%2 != 0){x += 120;}
        painel_find_friends.setSize(560, x);
        painel_find_friends.setPreferredSize(painel_find_friends.getSize());
        painel_find_friends.repaint();
    }
    
    public JPanel getPainel(){
      return painel_meus_amigos;
    }
}
