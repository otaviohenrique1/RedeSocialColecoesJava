import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;


/** Classe destinada a guardar o painel do perfil*/
public class PainelPerfil
{
     Usuario usuario;
     Cadastro cadastro = new Cadastro();
     Grafos grafos = new Grafos();
     
     JPanel painel_perfil;
     JButton bt_attDados;
     JLabel lb_nome_friend, lb_sexo_friend, lb_ns_friend, lb_img_friend, lb_nColecao, lb_nItem;
     Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
     
     
     PainelPerfil(Usuario eu,final int indice,final int x,final JLabel lb){
      usuario = eu;
      //painel destinado ao perfil 
       painel_perfil = new JPanel();
       painel_perfil.setBorder(new javax.swing.border.TitledBorder(""));
       painel_perfil.setBounds(220,50,650,560);
       painel_perfil.setVisible(true);
       painel_perfil.setLayout(null);
       
       //-----Botão alterar dados-----
       bt_attDados = new JButton("Atualizar Dados");
       bt_attDados.setBounds(10,450,200,30);
       bt_attDados.setFont(fonte2); 
       bt_attDados.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0){
           painel_perfil.setLayout(new BorderLayout()); 
           painel_perfil.removeAll();
           painel_perfil.add(new PainelAtualizarDados(usuario,lb,indice,x).getPanel(), BorderLayout.CENTER);  
           painel_perfil.validate();  
        } } );
        
       bt_attDados.setToolTipText(" Atualizar os dados do usuario "); 
       prenchePerfil(indice,x);
    }
       
    //metodos perfil
    public void prenchePerfil(final int indice,int x){
       if(x == 10){
       //img do usuario 
       ImageIcon img2 = new ImageIcon(cadastro.getFoto(indice));  
       img2.setImage(img2.getImage().getScaledInstance(100,100, 100)); 
       lb_img_friend = new JLabel(img2);
       lb_img_friend.setBounds(10, x, 100, 100);
       painel_perfil.add(lb_img_friend);
       
       JLabel lb_nomeUsurio = new JLabel(cadastro.getNomeUsuario(indice),JLabel.CENTER);
       lb_nomeUsurio.setFont(fonte2);
       lb_nomeUsurio.setBorder(new javax.swing.border.TitledBorder(""));
       lb_nomeUsurio.setBounds(120,x,520,30);
       painel_perfil.add(lb_nomeUsurio);
       
       JButton bt_exibirIntes = new JButton("Ver Coleções");
       bt_exibirIntes.setBounds(460,50,180,30);
       bt_exibirIntes.setFont(fonte2);
       bt_exibirIntes.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
               painel_perfil.setLayout(new BorderLayout()); 
               painel_perfil.removeAll();
               painel_perfil.add(new PainelItensAmigos(cadastro.getUsuario(indice)).mostraItensAmigo(), BorderLayout.CENTER);  
               painel_perfil.validate();  
            }
        });
       painel_perfil.add(bt_exibirIntes); 
   
       x+=80;
      }
       //imgen do perfil
       JLabel imgPerfil = new JLabel();
       imgPerfil.setBounds(0,x+0,640,480);
       imgPerfil.setIcon(new ImageIcon("img/PERFILTRANS.png"));
       painel_perfil.add(imgPerfil);    JLabel lb_cidade = new JLabel(cadastro.getCidade(indice));
       lb_cidade.setFont(fonte2);
       lb_cidade.setBounds(180,x+53,290,30);
       painel_perfil.add(lb_cidade);
       
       //JLabel Estado
       JLabel lb_estado = new JLabel(cadastro.getEstado(indice));
       lb_estado.setFont(fonte2);
       lb_estado.setBounds(505,x+53,200,30);
       painel_perfil.add(lb_estado);
       
       //JLabel Data de Nascimento
       JLabel lb_dataNasc = new JLabel(cadastro.getNascimento(indice));
       lb_dataNasc.setFont(fonte2);
       lb_dataNasc.setBounds(310,x+130,200,30);
       painel_perfil.add(lb_dataNasc);
       
       //JLabel Status Relacionamento
       JLabel lb_relacionamento = new JLabel(cadastro.getRelacionamento(indice));
       lb_relacionamento.setFont(fonte2);
       lb_relacionamento.setBounds(370,x+286,300,30);
       painel_perfil.add(lb_relacionamento);
       
       //JLabel Status Sexo
       JLabel lb_sexo = new JLabel(cadastro.getSexoUsuario(indice));
       lb_sexo.setFont(fonte2);
       lb_sexo.setBounds(160,x+206,200,30);
       painel_perfil.add(lb_sexo);
       
       //JLabel mostra o numero de coleçoes
       JLabel lb_Ncolecao = new JLabel(""+cadastro.getNColecao(indice));
       lb_Ncolecao.setFont(fonte2);
       lb_Ncolecao.setBounds(462,x+181,200,30);
       painel_perfil.add(lb_Ncolecao);
       
       //JLabel mostra a noma de todso itens
       JLabel lb_todosItens = new JLabel(""+cadastro.getNItens(indice));
       lb_todosItens.setFont(fonte2);
       lb_todosItens.setBounds(540,x+220,200,30);
       painel_perfil.add(lb_todosItens);
       
       //JLabel Email
       JLabel lb_email = new JLabel(cadastro.getEmail(indice));
       lb_email.setFont(fonte2);
       lb_email.setBounds(200,x+370,500,30);
       painel_perfil.add(lb_email);
       
       if(x == 0){painel_perfil.add(bt_attDados);}
    }
    
    public JPanel getPanel(){
     return painel_perfil;
    }
}
