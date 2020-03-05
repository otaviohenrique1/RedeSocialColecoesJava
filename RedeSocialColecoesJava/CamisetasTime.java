import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.TimeZone;


public class CamisetasTime extends ItensComp implements ActionListener,Cloneable 
{
  private String time;
  private String autJogador;
  private String jogador;
  private int numero;
  private String patchs;
  private String cor;  
  private String tamanho;
  private String per;
  MaskFormatter  mascarat1;
  Date d1;
  
  JButton bt1,bt3,bt4,bt5,pt1,voltar;
  static JLabel img= new JLabel("");
  private JLabel jlCadas= new JLabel("Camisetas de Times"),jlCadas1= new JLabel("Camisetas de Times"),jlCadas2= new JLabel("Camisetas de Times"),jl1= new JLabel("Time:"),jl2=new JLabel("Autografada?"),
  jl3=new JLabel("Jogador:"),jl4=new JLabel("Número do Jogador:"),jl5=new JLabel("Contém Patchs?"),jl6=new JLabel("Cor:"),jl7=new JLabel("Tamanho:"),jl8=new JLabel("Personalizada?"),
  jl9=new JLabel("Nome:"),jl10=new JLabel("Valor:"),jl11=new JLabel("Tempo de Uso:"),jl12=new JLabel("Origem:"),jl13=new JLabel("Quantidade:"),jl14=new JLabel("Estado de Conservação:"),
  jl15=new JLabel("Tiragem:"),jl16=new JLabel("Data de Lançamento:"),jl17=new JLabel("Série:"),jl18=new JLabel("Fabricante:"),jl19=new JLabel("Comentários:");
 
  private JTextField tf1 = new JTextField(40),tf2= new JTextField(40),tf3= new JTextField(40),tf4= new JTextField(40),tf5= new JTextField(40),
  tf6 = new JTextField(40),tf7 = new JTextField(40),tf8 = new JTextField(40),tf9 = new JTextField(40),tf10 = new JTextField(40),
  tf11 = new JTextField(40),tf12 = new JTextField(40),tf13 = new JTextField(40),tf14 = new JTextField(40),tf15 = new JTextField(40);
  private JComboBox combo_Aut,combo_Patch,combo_Per;
  String caminho = "";
  JTextArea tf16 = new JTextArea( 4, 10);
  JScrollPane scrollPane = new JScrollPane(tf16);
  JPanel primeiratela,segundatela;
  JTabbedPane aba;
  JFrame window;
  //**Construtor**//
  
  public CamisetasTime(){}
  
  //**Metodo**//   
        
   public void setCadastrar(){     
  window = new JFrame("Cadastrar Camisetas de Times");  
  window.setIconImage(new ImageIcon("img\\minilogo.png").getImage());
           
  //**Paineis**//
  primeiratela = new JPanel(); 
  primeiratela.setLayout (null);
  primeiratela.setSize(800,550);
  
      
  segundatela = new JPanel ();
  segundatela.setLayout (null);
  
  segundatela.setSize(800,550);
 
  //**Criando abas**//
        aba=new JTabbedPane();
        aba.addTab("Primeiras informações",null,primeiratela);
        aba.addTab("Informações adicionais",null,segundatela);
        aba.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        aba.setVisible(true);
        aba.setSize(800,550);
   window.add(aba);
  
  //**Titulo**//
  
  //**1� Painel**//
  jlCadas.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas.setBounds(180, 30, 400, 30);//(distancia do canto, distancia do teto,largura , altura) em pixel
  jlCadas.setForeground(Color.BLUE);
  jlCadas.setVisible(true);
  primeiratela.add(jlCadas);
  
  //**2� Painel**//
  jlCadas1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas1.setForeground(Color.BLUE);
  jlCadas1.setBounds(180, 30, 400, 30);
  segundatela.add(jlCadas1);
  
  /*** Primeiro Painel ***/
  
  //**Nome**//
  JLabel obri1 = new JLabel("*");
  obri1.setBounds(30, 80, 150, 30);
  obri1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri1.setForeground(Color.RED);
  primeiratela.add(obri1);
  jl9.setBounds(39, 80, 150, 30);
  jl9.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl9); 
  tf6.setBounds(120, 80, 630, 30);
  tf6.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf6);
  
 //**Valor**//
 JLabel obri2 = new JLabel("*");
 obri2.setBounds(410, 240, 150, 30);
  obri2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri2.setForeground(Color.RED);
  primeiratela.add(obri2);
  jl10.setBounds(420, 240, 150, 30);
  jl10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl10); 
  tf7.setBounds(510, 240, 240, 30);
  tf7.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf7);
  
  //**Uso**//
  jl11.setBounds(420, 200, 200, 30);
  primeiratela.add(jl11);
  jl11.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  //**Adicionando mascara ao TextField em formato de Data(try obrigatorio antes do setBounds)**//
  try{
         mascarat1 = new MaskFormatter("  ##/##/####");
         mascarat1.setPlaceholderCharacter('_');
         } 
        catch(Exception excp){} 
  tf8.setBounds(580, 200, 170, 30);
  tf8.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf8);
  
  //**Origem**//
  jl12.setBounds(39,120, 150, 30);
  jl12.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl12); 
  tf9.setBounds(120,120, 630, 30);
  tf9.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf9);
  
  //**Quantidade**//
  JLabel obri4 = new JLabel("*");
  obri4.setBounds(30, 200,150, 30);
  obri4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri4.setForeground(Color.RED);
  primeiratela.add(obri4);
  jl13.setBounds(39, 200,150, 30);
  jl13.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl13); 
  tf10.setBounds(170, 200,240, 30);
  tf10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf10);
  
  //**Estado**//
  JLabel obri5 = new JLabel("*");
  obri5.setBounds(30,160, 250, 30);
  obri5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri5.setForeground(Color.RED);
  primeiratela.add(obri5);
  jl14.setBounds(39,160, 250, 30);
  jl14.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl14); 
  tf11.setBounds(280,160, 470, 30);
  tf11.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf11);
  
  //**Tiragem**//
  jl15.setBounds(39,240, 200, 30);
  jl15.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl15); 
  tf12.setBounds(170, 240, 240, 30);
  tf12.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf12);
  
  //**Data**//
  jl16.setBounds(39,280, 300, 30);
  jl16.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl16);
  tf13 = new JFormattedTextField(mascarat1);
  //Atualiza a data do textfield <-------------------------------
        String antiga = ""+super.getDataLancamento();
        String nova = antiga.replace("-", "");  
        if(!nova.equals("") && !nova.equals("null")){
         tf13.setText(nova);
        }
  tf13.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  tf13.setBounds(260, 280, 150, 30);
  primeiratela.add(tf13);
  
  //**Time**//
  JLabel obri8 = new JLabel("*");
  obri8.setBounds(30,320, 150, 30);
  obri8.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri8.setForeground(Color.RED);
  primeiratela.add(obri8);
  jl1.setBounds(39, 320, 150, 30);
  jl1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl1); 
  tf1.setBounds(120, 320, 630, 30);
  tf1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf1);
  
  
  /*** Segundo Painel ***/
  
  
  //**Autografo**//
  jl2.setBounds(420, 280, 250, 30);
  jl2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl2);
  combo_Aut = new JComboBox();
  combo_Aut.addItem("Não");
  combo_Aut.addItem("Sim");
  combo_Aut.setBounds(600, 280, 150, 30);
  combo_Aut.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(combo_Aut);
  
  //**Jogador**//
  JLabel obri0 = new JLabel("*");
  obri0.setBounds(29, 80, 150, 30);
  obri0.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri0.setForeground(Color.RED);
  segundatela.add(obri0);
  jl3.setBounds(39, 80, 150, 30);
  jl3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl3);
  tf2.setBounds(140, 80, 610, 30);
  tf2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf2);
  
  //**Numero**//
  JLabel obri10 = new JLabel("*");
  obri10.setBounds(29, 120, 300, 30);
  obri10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri10.setForeground(Color.RED);
  segundatela.add(obri10);
  jl4.setBounds(39, 120, 300, 30);
  jl4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl4);
  tf3.setBounds(250,120,50,30);
  tf3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf3);
  
  //**Patchs**//
  
  jl5.setBounds(39, 360, 300, 30);
  jl5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl5);
  combo_Patch = new JComboBox();
  combo_Patch.addItem("Não");
  combo_Patch.addItem("Sim");
  combo_Patch.setBounds(220,360,170,30);
  combo_Patch.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(combo_Patch);
  
  //**Cor**//
  jl6.setBounds(310, 120, 150, 30);
  jl6.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl6); 
  tf4.setBounds(370, 120, 160, 30);
  tf4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf4);
  
  //**Tamanho**//
  JLabel obri12 = new JLabel("*");
  obri12.setBounds(29,160, 150, 30);
  obri12.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri12.setForeground(Color.RED);
  segundatela.add(obri12);
  jl7.setBounds(39,160, 150, 30);
  jl7.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl7); 
  tf5.setBounds(150, 160, 80, 30);
  tf5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf5);
  
  //**Personalizada**//
  jl8.setBounds(410, 360, 200, 30);
  jl8.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl8);
  combo_Per = new JComboBox();
  combo_Per.addItem("Não");
  combo_Per.addItem("Sim");
  combo_Per.setBounds(570, 360, 180, 30);
  combo_Per.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(combo_Per);
  
  //**Serie**//
  JLabel obri13 = new JLabel("*");
  obri13.setBounds(235, 160, 150, 30);
  obri13.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri13.setForeground(Color.RED);
  segundatela.add(obri13);
  jl17.setBounds(245, 160, 150, 30);
  jl17.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl17); 
  tf14.setBounds(330, 160, 200, 30);
  tf14.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf14);
  
  //**fabricante**//
  JLabel obri14 = new JLabel("*");
  obri14.setBounds(29,200,200, 30);
  obri14.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri14.setForeground(Color.RED);
  segundatela.add(obri14);
  jl18.setBounds(39,200,200, 30);
  jl18.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl18);
  tf15.setBounds(170,200,360,30);
  tf15.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf15);
  
  //**Comentario**//
  tf16.setLineWrap(true);
  tf16.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  jl19.setBounds(39, 240, 200, 30);
  jl19.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl19);
  scrollPane.setBounds(39,280,493,110);
  segundatela.add(scrollPane);
  
  
  /**Legenda Painel 1**/
  JLabel obri17 = new JLabel("*");
  obri17.setBounds(630,30,10,20);
  obri17.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));
  obri17.setForeground(Color.RED);
  primeiratela.add(obri17);
  
  JLabel obri20 = new JLabel("Legenda:");
  obri20.setBounds(670,8,180,20);
  obri20.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,12));
  obri20.setForeground(Color.BLACK);
  primeiratela.add(obri20);
  
  JLabel obri19 = new JLabel("= Campo Obrigatorio!");
  obri19.setBounds(640,30,180,20);
  obri19.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,12));
  obri19.setForeground(Color.BLACK);
  primeiratela.add(obri19);
  
  /**Legenda Painel 2**/
  JLabel obri16 = new JLabel("*");
  obri16.setBounds(630,30,10,20);
  obri16.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));
  obri16.setForeground(Color.RED);
  segundatela.add(obri16);
  
  JLabel obri21 = new JLabel("Legenda:");
  obri21.setBounds(670,8,180,20);
  obri21.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,12));
  obri21.setForeground(Color.BLACK);
  segundatela.add(obri21);
  
  JLabel obri18 = new JLabel("= Campo Obrigatorio!");
  obri18.setBounds(640,30,180,20);
  obri18.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,12));
  obri18.setForeground(Color.BLACK);
  segundatela.add(obri18);
  
  
  //**Botao Cancelar**//
  
  bt1 = new JButton("Cancelar");
  bt1.addActionListener(this);  
  bt1.setBounds(140, 420, 250, 35);
  bt1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  bt1.setVisible(true);
  primeiratela.add(bt1);
  
  pt1 = new JButton("Prosseguir");
  pt1.addActionListener(this);  
  pt1.setBounds(400, 420, 250, 35);
  pt1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  pt1.setVisible(true);
  primeiratela.add(pt1);
        
  bt4 = new JButton("Cancelar");
  bt4.addActionListener(this); 
  bt4.setBounds(140, 420, 250, 35);
  bt4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(bt4);
        
        //**Botao diretorio**//
        
        bt5 = new JButton("Adicionar");
        bt5.addActionListener(this);       
        bt5.setBounds(550,330,200,35);
        bt5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        segundatela.add(bt5);
        
         //**Botao Finalizar**//
         
        bt3 = new JButton("Finalizar");
        bt3.addActionListener(this);       
        bt3.setBounds(400, 420, 250, 35);
        bt3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        segundatela.add(bt3);
        
        voltar = new JButton();
        voltar.setIcon( new ImageIcon("img/voltar.png"));
        voltar.setBounds(5,5,45,45); 
        voltar.addActionListener(this);
        segundatela.add(voltar);
        
        img.setBounds(550,120,200,200);
        img.setBorder(new javax.swing.border.TitledBorder("Imagem da Camiseta"));
        segundatela.add(img);
        
        //atualiza combox
        
       combo_Aut.setSelectedItem(autJogador);
            combo_Patch.setSelectedItem(patchs);
            combo_Per.setSelectedItem(per);
        
        //**Finalizando window**//
       window.setVisible(true);
       window.setSize(800,550);
       window.setDefaultCloseOperation(1);
       window.setLocationRelativeTo(null);
       window.setResizable(true);
}

 public void actionPerformed(ActionEvent e){
        if(e.getSource()== bt1 || e.getSource()== bt4)
       {
            window.setVisible(false); 
            window.dispose();
        }
         else if(e.getSource()== pt1)
       {
             primeiratela.setVisible(false); 
             aba.setSelectedIndex(1);
             aba.getComponentAt(1).setVisible(true);
             segundatela.setVisible(true);
        }
     else if(e.getSource()== bt5)
       {
            JFileChooser pasta= new JFileChooser();
                caminho = ""; File file = null; int retorno = pasta.showSaveDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser ser� para salvar.
                if (retorno==JFileChooser.APPROVE_OPTION){ caminho = pasta.getSelectedFile().getAbsolutePath(); // o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endere�o.
                 ImageIcon img2 = new ImageIcon (caminho);  
                 img2.setImage(img2.getImage().getScaledInstance(200,200, 100)); 
                 img.setIcon(img2);  }
        }
        else if(e.getSource()== bt3){
                          
             /**validando campos tela 1**/
             
         if (tf6.getText().isEmpty() || tf6.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Nome'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        } else if (tf7.getText().isEmpty() || tf7.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Valor'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        }   else if (tf10.getText().isEmpty() || tf10.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Quantidade' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        } else if (tf11.getText().isEmpty() || tf11.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Estado de Conservação'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        } else  if (tf1.getText().isEmpty() || tf1.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Time'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
            segundatela.setVisible(false); 
            aba.setSelectedIndex(0);
            aba.getComponentAt(0).setVisible(true);
            primeiratela.setVisible(true);
        }
              /**validando campos tela 2**/
              
               else  if (tf2.getText().isEmpty() || tf2.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Jogador'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }       else  if (tf3.getText().isEmpty() || tf3.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Numero'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }       else  if (tf5.getText().isEmpty() || tf5.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Tamanho'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }       else  if (tf14.getText().isEmpty() || tf14.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Serie'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }       else  if (tf15.getText().isEmpty() || tf15.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Fabricante'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }    else{                 
             //**Convertendo String para data**//
             SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
             try { 
                d1 = new java.sql.Date(format.parse(tf13.getText()).getTime());}
             catch (ParseException x) { }  
             time=tf1.getText();
             jogador=tf2.getText();
             cor=tf4.getText();
             tamanho=tf5.getText();
             autJogador=(String) combo_Aut.getSelectedItem();
             per=(String) combo_Per.getSelectedItem();
             patchs=(String) combo_Patch.getSelectedItem();
             numero = Integer.parseInt(tf3.getText());
             if(super.getNome() == null){
              super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf8.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),caminho,tf11.getText(),tf12.getText(), tf16.getText(),d1,tf14.getText(),tf15.getText());
              super.addEventoCadastrar("Camisetas de Times");
              JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
             }
             else{
              super.addEventoAlterar("Camisetas de Times",super.getNome(),tf6.getText());
              super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf8.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),caminho,tf11.getText(),tf12.getText(), tf16.getText(),d1,tf14.getText(),tf15.getText());
              JOptionPane.showMessageDialog(null,"Dados alterados com suceso!");
                }
            
             window.setVisible(false); 
             window.dispose();
            }
            
        }
        else if (e.getSource()==voltar)
      {      segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);}
     }
 public String getInfo(){
     return super.getInfo()+",Nome do Jogador: "+jogador+",Cor: "+cor+",Tamanho: "+tamanho+",Autografo do jogador: "+autJogador+",Personalizada: "+per+",Contem patchs: "+patchs+",Numero: "+numero;
    }
  
 //metodo padrão com msm nome para alteração de dados
 public void atualizarDados(){
  tf1.setText(time);
  tf2.setText(jogador);
  tf3.setText(""+numero);
  tf4.setText(cor);
  tf5.setText(tamanho);
  tf6.setText(super.getNome());
  tf7.setText(""+super.getValor());
  tf8.setText(super.getTempoUso());
  tf9.setText(super.getOrigem());
  tf10.setText(""+super.getQuantidade());
  tf11.setText(super.getEstadoConservacao());
  tf12.setText(super.getTiragens());
  tf14.setText(super.getSerie());
  tf15.setText(super.getFabricante());
  tf16.setText(super.getComentario());
  ImageIcon img2 = new ImageIcon (super.getEndrecoImg());  
  img2.setImage(img2.getImage().getScaledInstance(200,200, 100)); 
  img.setIcon(img2);
  setCadastrar();
     }
     
   //permite que a classe seja clonada
    public Object clone() {
       Object x = new Object();
       try{
           CamisetasTime c = (CamisetasTime) super.clone(); 
           x=c;
        }catch (Exception e){}
       return x;
    }  
}