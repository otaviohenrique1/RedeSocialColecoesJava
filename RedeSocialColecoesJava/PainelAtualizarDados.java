import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/** Classe destinada ao painel de atualizar dados pessoais*/
public class PainelAtualizarDados
{
    Usuario usuario;
    Cadastro cadastro = new Cadastro();
 
     // COMPONENTES UPDATE  
     
    JPanel painel_attDados;
    JTextField txt_nome, txt_email, txt_nascimento, txt_cidade, txt_estado, txt_login;
    JButton bt_att, bt_cancel,bt_attSenha;
    JComboBox cb_sexo,cb_relacionamento; 
    Font fonteT1 = new Font("Arial",Font.BOLD + Font.PLAIN, 16);
    Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
    MaskFormatter  mascarat1;
    
    
    PainelAtualizarDados(Usuario eu,final JLabel lb, final int indice, final int x){
        usuario = eu;
      //painel destinado as atualizações do cliente
      
       painel_attDados = new JPanel();
       painel_attDados.setVisible(true);
       painel_attDados.setLayout(null);
       painel_attDados.setBounds(0,0,650,560);
       
      
       //img com todas as atts
       JLabel imgAttDados = new JLabel();
       imgAttDados.setBounds(0,0,640,402);
       imgAttDados.setIcon(new ImageIcon("img/attdados.png"));
       painel_attDados.add(imgAttDados);
                          
        txt_nome = new JTextField(usuario.getNome());
        txt_nome.setBounds(100, 55, 500, 30);
        txt_nome.setFont(fonteT1);
        painel_attDados.add(txt_nome);
        
        txt_cidade = new JTextField(usuario.getCidade());
        txt_cidade.setBounds(100, 100, 270, 30);
        txt_cidade.setFont(fonteT1);
        painel_attDados.add(txt_cidade);
        
        txt_estado = new JTextField(usuario.getEstado());
        txt_estado.setBounds(465, 100, 135, 30);
        txt_estado.setFont(fonteT1);
        painel_attDados.add(txt_estado);
        
        txt_login = new JTextField(usuario.getLogin());
        txt_login.setBounds(100, 308, 200, 30);
        txt_login.setFont(fonteT1);
        painel_attDados.add(txt_login);
        
        txt_email = new JTextField(usuario.getEmail());
        txt_email.setBounds(100, 256, 500, 30);
        txt_email.setFont(fonteT1);
        painel_attDados.add(txt_email);
        
        txt_nascimento = new JTextField();
        try{
         mascarat1 = new MaskFormatter("  ##/##/####");
         mascarat1.setPlaceholderCharacter('_');
         } 
        catch(Exception excp){} 
        txt_nascimento = new JFormattedTextField(mascarat1);
        if(!usuario.getNascimento().equals("  /  /    ") && !usuario.getNascimento().equals("") &&!usuario.getNascimento().equals(null)){txt_nascimento.setText(usuario.getNascimento());}
        txt_nascimento.setBounds(220, 150, 120, 30);
        txt_nascimento.setFont(fonteT1);
        painel_attDados.add(txt_nascimento);
        
        cb_relacionamento = new JComboBox();
        cb_relacionamento.addItem(usuario.getRelacionamento());
        if(usuario.getRelacionamento().equals("Solteiro")){
            cb_relacionamento.addItem("Namorando");
            cb_relacionamento.addItem("Casado");
        } else if(usuario.getRelacionamento().equals("Casado")){
            cb_relacionamento.addItem("Namorando");
            cb_relacionamento.addItem("Solteiro");
        }
        else{
            cb_relacionamento.addItem("Casado");
            cb_relacionamento.addItem("Solteiro");
        }
        cb_relacionamento.setBounds(290, 205, 160, 30);
        cb_relacionamento.setFont(fonte2);
        painel_attDados.add(cb_relacionamento);
        
        cb_sexo = new JComboBox();
        cb_sexo.addItem(usuario.getSexo());
        
        if(usuario.getSexo().equals("Masculino")){ cb_sexo.addItem("Femenino");}
        else{cb_sexo.addItem("Masculino");}
        cb_sexo.setBounds(422, 150, 160, 30);
        cb_sexo.setFont(fonte2);
        painel_attDados.add(cb_sexo);
        
        ImageIcon img = new ImageIcon ("img\\chave.png");  
        img.setImage(img.getImage().getScaledInstance(30, 30, 100));
        JLabel imgTrocaSenha = new JLabel(img);
        imgTrocaSenha.setBounds(315, 308, 30, 30);painel_attDados.add(imgTrocaSenha); 
        
        bt_attSenha = new JButton("Trocar Senha");
        bt_attSenha.setBounds(360, 308, 200, 30);
        bt_attSenha.setFont(fonte2);
        bt_attSenha.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent arg0) {
                  String senhaAntiga = JOptionPane.showInputDialog("Digite a sua senha atual"); 
                  if(!senhaAntiga.equals(usuario.getSenha())){
                    JOptionPane.showMessageDialog(null,"Senha incorreta");
                    }
                  else{
                   String novaSenha = JOptionPane.showInputDialog("Digite a sua nova senha");
                   String repitNovaSenha = JOptionPane.showInputDialog("Digite novamente a sua nova senha"); 
                   if(!novaSenha.equals(repitNovaSenha)){JOptionPane.showMessageDialog(null,"A senhas não conferem");}
                   else{
                    usuario.setSenha(novaSenha);
                    JOptionPane.showMessageDialog(null,"Senha auterada com sucesso!");
                    }
                    }
                }});painel_attDados.add(bt_attSenha);             
        
        bt_att = new JButton("Atualizar");
        bt_att.setBounds(20, 360, 200, 30);
        bt_att.setFont(fonte2);
        bt_att.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0) {
          // chama fução update de usuarios
          usuario.updateData(txt_nome.getText(), cb_sexo.getSelectedItem().toString(),
          txt_email.getText(), txt_nascimento.getText(),txt_cidade.getText(),
          txt_estado.getText(),cb_relacionamento.getSelectedItem().toString(),txt_login.getText(),cadastro.getIndice());
                                                            
          JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
          lb.setText("Bem Vindo "+usuario.getNome());
          painel_attDados.removeAll();
          JPanel novo = new JPanel();
          novo = new PainelPerfil(usuario,indice,x,lb).getPanel();
          novo.setBounds(0,0,650,560);
          painel_attDados.add(novo);
          painel_attDados.repaint();
        }});painel_attDados.add(bt_att);
        
        bt_cancel = new JButton("Cancelar");
        bt_cancel.setBounds(230, 360, 200, 30);
        bt_cancel.setFont(fonte2);
        bt_cancel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){ 
                 painel_attDados.removeAll();
                 JPanel novo = new JPanel();
                 novo = new PainelPerfil(usuario,indice,x,lb).getPanel();
                 novo.setBounds(0,0,650,560);
                 painel_attDados.add(novo);
                 painel_attDados.repaint();
                }
        });
        painel_attDados.add(bt_cancel);       
        
       bt_att.setToolTipText(" Atualizar os dados editados ");
       painel_attDados.repaint();
    }
    
    public JPanel getPanel(){
     return painel_attDados;
    }
}
