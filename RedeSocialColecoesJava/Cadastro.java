import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Cadastro {
    // lista com usuarios
    private static LinkedList <Usuario> contas = new LinkedList <Usuario>();
    private static int indice;
    
    // cadastrar novo
    public void cadastrarNovo(Usuario novo, JFrame janela){
        
        contas.add(novo);
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
        janela.dispose(); // fecha janela de cadastro
        
    }
        
    // verifica se existe o usuario dentro da lista
    public void verificarUsuario(String login, String senha, JFrame janela){            
        boolean x = true;
        if(login.equals("t")){
            Usuario us = new Usuario("Testes", "24/12/2024", "Canas", "logim", "1234", "ticoeteco@gmail.com", "Masculino",contas.size());
            contas.add(us); CriaAmigos();
                RedeSocial rede = new RedeSocial();             
                janela.dispose();
            }
            else{
        for(int i = 0; i < contas.size(); i++){
            
            if(contas.get(i).getLogin().equals(login) && contas.get(i).getSenha().equals(senha)){
                zerar(i);
                RedeSocial rede = new RedeSocial();             
                janela.dispose();
                x= false;
            } 
            
        }
        if(x){JOptionPane.showMessageDialog(null, "O Login e(ou) Senha esta(ão) errada(os)");}
    }
 }
    
 //função para testes
 public void CriaAmigos(){
  Usuario us = new Usuario("Rafael Favalli", "24/12/2024", "Canas", "1", "1", "ticoeteco@gmail.com", "Masculino",contas.size());
  contas.add(us); 
  Usuario us1 = new Usuario("Amanda", "24/12/2024", "Cachoeira Paulista", "2", "2", "ticoeteco@gmail.com", "Feminino",contas.size());
  contas.add(us1);  
  Usuario us2 = new Usuario("Rafael Giornes", "24/12/2024", "Cruzeiro", "3", "3", "ticoeteco@gmail.com", "Masculino",contas.size());
  contas.add(us2);  
  Usuario us3 = new Usuario("Thalles", "24/12/2024", "Cruzeiro", "4", "4", "ticoeteco@gmail.com", "Masculino",contas.size());
  contas.add(us3);  
  Usuario us4 = new Usuario("Otavio", "24/12/2024", "Cachoeira Paulista", "5", "5", "ticoeteco@gmail.com", "Masculino",contas.size());
  contas.add(us4);  
  Usuario us5 = new Usuario("Lucas", "24/12/2024", "Lorena", "6", "6", "ticoeteco@gmail.com", "Masculino",contas.size());
  contas.add(us5);  
  Usuario us6 = new Usuario("Jonatas", "24/12/2024", "Lorena", "7", "7", "ticoeteco@gmail.com", "Masculino",contas.size());
  contas.add(us6);  
    }

    //renova o indice
    void zerar(int novo){
        indice = novo;
    }
    
    //retorna o nome do usuario logado
    public String getNomeUsuario(){
        return contas.get(indice).getNome();
    }
    
    //retorna o nome do usuario apartir de um indice
    public String getNomeUsuario(int indice){
        return contas.get(indice).getNome();
    }
    
    //retorna a cidade de um usuario apartir de um indice
    public String getCidade(int indice){
        return contas.get(indice).getCidade();
    }
    
    //retorna o estado do usuario apartir de um indice
    public String getEstado(int indice){
        return contas.get(indice).getEstado();
    }
    
    //retorna o email do usuario apartir de um indice
    public String getEmail(int indice){
        return contas.get(indice).getEmail();
    }
    
    //retorna o relacionamento do usuario apartir de um indice
    public String getRelacionamento(int indice){
        return contas.get(indice).getRelacionamento();
    }
    
    //retorna quem pode ver as ações do usuario apartir de um indice
    public int getQuemVe(int indice){
        return contas.get(indice).getQuemVe();
    }
    
    //retorna o sexo do usuario apartir de um indice
    public String getSexoUsuario(int indice){
        return contas.get(indice).getSexo();
    }
    
    //retorna a foto do usuario apartir de um indice
    public String getFoto(int indice){
        return contas.get(indice).getEndFoto();
    }
    
    //retorna o data de nascimento do usuario apartir de um indice
    public String getNascimento(int indice){
        return contas.get(indice).getNascimento();
    }
        
    //retorna quantos usuarios existem
    public int getCounts(){
        return contas.size();
    }
    
    //retorna um objeto inteiro do usuario logado
    public Usuario getUsuario(){
        return contas.get(indice);
    }
    
    //retorna im objeto inteiro de um usuario apartir de um indece
    public Usuario getUsuario(int amigo){
        return contas.get(amigo);
    }
    
    //chama o painel de logim saindo do painel logado
    public void deslogar(){
        PainelLogin x = new PainelLogin();
    }   
    
    //retorna o indice do usuario logado
    public int getIndice(){
        return this.indice;
    }
    
    //retorna a foto do usuario apartir de um indice
    public String getFotoH(int pos){
        return contas.get(pos).getEndFoto();
    }
    
    //retorna o numero de coleções do usuario apartir de um indice
    public int getNColecao(int indice_user){
     return contas.get(indice_user).getColecao().size();
    }
    
    //retorna o numero de itens do usuario apartir de um indice
    public int getNItens(int indice_user){
     return contas.get(indice_user).getSomaTodosItens();
    }
    
    // retorna array com contas
    public int getNumContas(){
        return contas.size();
    }
    
    
    /** Atributos da area que cadastra os usuarios */
    
    // dados para cadastro
    JLabel lb_titulo, lb_nome, lb_nascimento, lb_endereco, lb_login, lb_email, lb_sexo, lb_senha;
    JTextField txt_nome, txt_endereco, txt_login, txt_email;
    JPasswordField pw_senha;
    JFormattedTextField ftxt_nascimento;
    JSeparator s1;
    JComboBox cb_sexo;
    JButton bt_cadastrar, bt_cancelar;
    MaskFormatter mascara;
    
    // void q cria o painel
    
    public void PainelCadastro(){
        
        final JFrame window = new JFrame("Cadastro de Novo Usuario");
        window.setSize(550, 340);
        window.setLayout(null);
        window.setIconImage(new ImageIcon("img\\minilogo.png").getImage());
        // adicionando componentes
        lb_titulo = new JLabel("Criar Nova Conta");
        lb_titulo.setFont(new Font("Arial", Font.BOLD, 30));
        lb_titulo.setForeground(Color.BLUE);
        lb_titulo.setBounds(20, 20, 400, 30);
        window.add(lb_titulo);
        
        s1 = new JSeparator();
        s1.setBounds(5, 60, 520, 1);
        window.add(s1);
        // ****
        // campos de texto
        
        // nome
        lb_nome = new JLabel("Nome:");
        lb_nome.setBounds(20, 80, 70, 30);
        lb_nome.setFont(new Font("Arial", Font.BOLD, 20));
        window.add(lb_nome);
        
        txt_nome = new JTextField();
        txt_nome.setBounds(90, 75, 420, 30);
        txt_nome.setFont(new Font("Arial", Font.BOLD, 18));
        window.add(txt_nome);
        
        // data de nascimento
        lb_nascimento = new JLabel("Data Nasc:");
        lb_nascimento.setBounds(260, 155, 180, 30);
        lb_nascimento.setFont(new Font("Arial", Font.BOLD, 20));
        window.add(lb_nascimento);
        
        try{
            mascara = new MaskFormatter("##/##/####");
        }
         catch(Exception e){
            JOptionPane.showMessageDialog(null, "Impossível carregar configurações de data. \n"+e);
        }
        
        ftxt_nascimento = new JFormattedTextField(mascara);             
        ftxt_nascimento.setBounds(380, 155, 130, 30);
        ftxt_nascimento.setFont(new Font("Arial", Font.BOLD, 18));
        window.add(ftxt_nascimento);
        
        // email
        lb_endereco = new JLabel("Email:");
        lb_endereco.setBounds(20, 120, 70, 30);
        lb_endereco.setFont(new Font("Arial", Font.BOLD, 20));
        window.add(lb_endereco);
        
        txt_endereco = new JTextField();
        txt_endereco.setBounds(90, 115, 420, 30);
        txt_endereco.setFont(new Font("Arial", Font.BOLD, 18));
        window.add(txt_endereco);
        
        // sexo
        lb_sexo = new JLabel("Sexo:");
        lb_sexo.setBounds(20, 160, 70, 30);
        lb_sexo.setFont(new Font("Arial", Font.BOLD, 20));
        window.add(lb_sexo);
        
        cb_sexo = new JComboBox();
        cb_sexo.removeAllItems();
        cb_sexo.addItem("Masculino");
        cb_sexo.addItem("Femenino");
        cb_sexo.setBounds(90, 155, 150, 30);
        cb_sexo.setFont(new Font("Arial", Font.BOLD, 18));
        window.add(cb_sexo);
        
        // login
        lb_login = new JLabel("Login:");
        lb_login.setBounds(20, 200, 70, 30);
        lb_login.setFont(new Font("Arial", Font.BOLD, 20));
        window.add(lb_login);
        
        txt_login = new JTextField();
        txt_login.setBounds(90, 195, 150, 30);
        txt_login.setFont(new Font("Arial", Font.BOLD, 18));
        window.add(txt_login);
        
        // senha
        lb_senha = new JLabel("Senha:");
        lb_senha.setBounds(260, 200, 70, 30);
        lb_senha.setFont(new Font("Arial", Font.BOLD, 20));
        window.add(lb_senha);
        
        pw_senha = new JPasswordField();
        pw_senha.setBounds(340, 195, 170, 30);
        pw_senha.setFont(new Font("Arial", Font.BOLD, 18));
        window.add(pw_senha);
        
        //******
        // bot�es
        
        // cadastrar
        bt_cadastrar = new JButton("Cadastrar");
        bt_cadastrar.setBounds(120, 255, 150, 30);
        bt_cadastrar.setFont(new Font("Arial", Font.BOLD, 18));
        bt_cadastrar.setToolTipText(" Cadastrar usuario ");
        
        bt_cadastrar.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent f) {
                        // TODO Auto-generated method stub

                        String nome = txt_nome.getText();
                        String dataNasc = ftxt_nascimento.getText();
                        String login = txt_login.getText();
                        String senha = new String(pw_senha.getPassword());
                        String email = txt_endereco.getText();
                        String sexo = cb_sexo.getSelectedItem().toString();                     
                        boolean x = false;
                      for(int i =0;i<contas.size();i++){
                         if(login.equals(contas.get(i).getLogin())){
                          x=true;
                            }
                        }
                      if(x){JOptionPane.showMessageDialog(null, "Usuario ja existente");}
                        else if(!nome.matches(".{1,}")){
                         JOptionPane.showMessageDialog(null, "Por favor informe o seu nome");
                        }
                        else if(!login.matches(".{4,}")){
                         JOptionPane.showMessageDialog(null, "O Login Deve ter 4 ou mais Caracteres");
                        }
                        else if(!senha.matches(".{4,}")){
                         JOptionPane.showMessageDialog(null, "A Senha Deve ter 4 ou mais Caracteres");
                        }
                        else{
                        Usuario us = new Usuario(nome, dataNasc, "-----", login, senha, email, sexo,contas.size());
                        cadastrarNovo(us, window);
                      } 
                    }
                }
                );
                
        window.add(bt_cadastrar);
        
        // cancelar
        bt_cancelar = new JButton("Cancelar");
        bt_cancelar.setBounds(290, 255, 150, 30);
        bt_cancelar.setFont(new Font("Arial", Font.BOLD, 18));
        bt_cancelar.setToolTipText(" Cancelar operação ");
        
        bt_cancelar.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            window.dispose();
                        }
                }
                );
        
        window.add(bt_cancelar);
        
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(1);
        
    }
}
