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

public class HotWheels extends ItensComp implements ActionListener,Cloneable
{
   private String categoria;
   private String tema;
   private int numeroSerie;
   private String montadora;
   private String cor;
   private String dimensao;
   MaskFormatter  mascarat1;
   Date d1;
   JButton bt1,bt2,bt3,bt4,bt5,pt1,voltar;
  private JLabel img= new JLabel(),jlCadas= new JLabel("Hot Wheels"),jlCadas1= new JLabel("Hot Wheels"),jlCadas2= new JLabel("Hot Wheels"),
  jl3=new JLabel("Tema:"),jl4=new JLabel("Categoria:"),jl5=new JLabel("Número da Série:"),jl6=new JLabel("Cor:"),jl7=new JLabel("Montadora:"),jl8=new JLabel("Dimensão:"),
  jl9=new JLabel("Nome:"),jl10=new JLabel("Valor:"),jl11=new JLabel("Tempo de Uso:"),jl12=new JLabel("Origem:"),jl13=new JLabel("Quantidade:"),jl14=new JLabel("Estado de Conservação:"),
  jl15=new JLabel("Tiragem:"),jl16=new JLabel("Data de Lançamento:"),jl17=new JLabel("Série:"),jl18=new JLabel("Fabricante:"),jl19=new JLabel("Comentários:");
  private JTextField tf1 = new JTextField(40),tf2= new JTextField(40),tf3= new JTextField(40),tf4= new JTextField(40),tf5= new JTextField(40),
  tf6 = new JTextField(40),tf7 = new JTextField(40),tf8 = new JTextField(40),tf9 = new JTextField(40),tf10 = new JTextField(40),
  tf11 = new JTextField(40),tf12 = new JTextField(40),tf13 = new JTextField(40),tf14 = new JTextField(40),tf15 = new JTextField(40);
  private JComboBox combo_Cat;
  private JLabel Obrigatorio;
  String caminho = "";
  JTextArea tf16 = new JTextArea( 4, 10);
  JScrollPane scrollPane = new JScrollPane(tf16);
  JPanel primeiratela,segundatela;
  JTabbedPane aba;
  JFrame window;
  
  //**Construtor**//
  
  public HotWheels(){}
  

  //**Metodo**//   
        
   public void setCadastrar(){
 
  window = new JFrame("Cadastrar Hot Wheels"); 
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
        aba.addTab("Primeiras informações",null,primeiratela,"Primera Tela");
        aba.addTab("Informações adicionais",null,segundatela,"Segunda Tela");
        aba.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        aba.setVisible(true);
        aba.setSize(800,550);
  window.add(aba);
  
  //**Titulo**//
  
  //**1� Painel**//
  jlCadas.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas.setBounds(270, 30, 400, 30);//(distancia do canto, distancia do teto,largura , altura) em pixel
  jlCadas.setForeground(Color.BLUE);
  jlCadas.setVisible(true);
  primeiratela.add(jlCadas);
  
  
  
  //**2� Painel**//
  jlCadas1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas1.setForeground(Color.BLUE);
  jlCadas1.setBounds(270, 30, 400, 30);
  
  segundatela.add(jlCadas1);
  
  
  /*** Primeiro Painel ***/
  
  //**Nome**//
  jl9.setBounds(39, 80, 150, 30);
  jl9.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl9); 
  tf6.setBounds(120, 80, 630, 30);
  tf6.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf6);
  tf6.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
  JOptionPane.showMessageDialog(HotWheels.this, "Informe o campo Nome!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
      Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,85,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              
            Obrigatorio.setForeground(Color.RED);           primeiratela.add(Obrigatorio);  
  //**Valor**//
  jl10.setBounds(420, 240, 150, 30);
  jl10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl10); 
  tf7.setBounds(510, 240, 240, 30);
  tf7.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf7);
  tf7.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
  JOptionPane.showMessageDialog(HotWheels.this, "Informe o campo Valor!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
      Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(410,245,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              
            Obrigatorio.setForeground(Color.RED);           primeiratela.add(Obrigatorio);  
  
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
  jl13.setBounds(39, 200,150, 30);
  jl13.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl13); 
  tf10.setBounds(170, 200,240, 30);
  tf10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf10);
  tf10.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
  JOptionPane.showMessageDialog(HotWheels.this, "Informe a Quantidade!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
  Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30, 200,150, 30);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              
  Obrigatorio.setForeground(Color.RED);                       primeiratela.add(Obrigatorio);
  
  //**Estado**//
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
  tf13.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  tf13.setBounds(260, 280, 150, 30);
  primeiratela.add(tf13);
  String antiga = ""+super.getDataLancamento();
  String nova = antiga.replace("-", "");  
  if(!nova.equals("") && !nova.equals("null")){
         tf13.setText(nova);
        }
  /*** Segundo Painel ***/
  
  //**Tema**//
  jl3.setBounds(39,320, 150, 30);
  jl3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl3); 
  tf1.setBounds(120, 320, 630,30);
  tf1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf1);
  tf1.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
  JOptionPane.showMessageDialog(HotWheels.this, "Informe o campo Tema!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
      Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,325,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              
            Obrigatorio.setForeground(Color.RED);           primeiratela.add(Obrigatorio);
  
  
  //**Categoria**//
  jl4.setBounds(39,360, 300, 30);
  jl4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl4);
  combo_Cat = new JComboBox();
  combo_Cat.addItem("Accele Racers");
  combo_Cat.addItem("Hot Wheels");
  combo_Cat.addItem("Battle Force 5");
  combo_Cat.addItem("World Race Beat That!");
  combo_Cat.addItem("The Stroyers");
  combo_Cat.addItem("Vandals");
  combo_Cat.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  combo_Cat.setBounds(160, 360, 590, 30);
  primeiratela.add(combo_Cat);
  
  //**N�mero de S�rie**//
  jl5.setBounds(39,160, 250, 30);
  jl5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl5);
  tf2.setBounds(220,160,150,30);
  tf2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf2);
  tf2.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
  JOptionPane.showMessageDialog(HotWheels.this, "Informe o campo Numero de Série!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
   Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,165,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              
         Obrigatorio.setForeground(Color.RED);           segundatela.add(Obrigatorio);
  
  
  
  //**Cor**//
  jl6.setBounds(430, 280, 150, 30);
  jl6.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl6);
  tf3.setBounds(510,280,240,30);
  tf3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf3);
  
  //**Montadora**//
  jl7.setBounds(39, 80, 200, 30);
  jl7.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl7);
  tf4.setBounds(160,80,590,30);
  tf4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf4); 
  tf4.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
  JOptionPane.showMessageDialog(HotWheels.this, "Informe o campo Montadora!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
       Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,85,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              
             Obrigatorio.setForeground(Color.RED);           segundatela.add(Obrigatorio);
  
  
  //**Dimenss�o**//
  jl8.setBounds(39, 120, 200, 30);
  jl8.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl8); 
  tf5.setBounds(160, 120,590, 30);
  tf5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf5); 
  
  //**Serie**//
  jl17.setBounds(390,160, 150, 30);
  jl17.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl17); 
  tf14.setBounds(470,160, 280, 30);
  tf14.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf14); 
  
  //**fabricante**//
  jl18.setBounds(39,200, 200, 30);
  jl18.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl18);
  tf15.setBounds(160,200, 379, 30);
  tf15.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf15);
  tf15.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
  JOptionPane.showMessageDialog(HotWheels.this, "Informe o campo Fabricante!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,205,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              
         Obrigatorio.setForeground(Color.RED);           segundatela.add(Obrigatorio);
  
  
  //**Comentario**//
  tf16.setLineWrap(true);
  tf16.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  jl19.setBounds(39, 240, 150, 30);
  jl19.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl19);
  scrollPane.setBounds(39,280,500,120);
  segundatela.add(scrollPane);
  
  //**Adicionando Imagem**//
  img.setBounds(550,200,200,200);
  img.setBorder(new javax.swing.border.TitledBorder("Imagem do Jogo"));
  segundatela.add(img);
  
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
  bt4.setBounds(29, 420, 245, 35);
  bt4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(bt4);
        
        //**Botao diretorio**//
        
       bt5 = new JButton("Adicionar");
        bt5.addActionListener(this);       
        bt5.setBounds(550,420,200,35);
        bt5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        segundatela.add(bt5);
        
         //**Botao Finalizar**//
         
        bt3 = new JButton("Finalizar");
        bt3.addActionListener(this);       
        bt3.setBounds(294, 420, 245, 35);
        bt3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        segundatela.add(bt3);
        
        voltar = new JButton();
        voltar.setIcon( new ImageIcon("img/voltar.png"));
        voltar.setBounds(5,5,45,45); 
        voltar.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20)); 
        voltar.addActionListener(this);
        segundatela.add(voltar);
        
        combo_Cat.setSelectedItem(categoria);
        
        //**Finalizando Container**//
        window.setVisible(true);
        window.setSize(800,550);
        window.setDefaultCloseOperation(1);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        
 }
 public void actionPerformed(ActionEvent e){
        if(e.getSource()== bt1 || e.getSource()== bt2 || e.getSource()== bt4)
       {
            window.setVisible(false); 
            dispose();
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
        
        else if (e.getSource()==voltar)
      {      segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);}
     else if(e.getSource()== bt3){       
        
             
         if (tf6.getText().isEmpty() || tf6.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Nome!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        } else if (tf7.getText().isEmpty() || tf7.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Valor!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        }  else if (tf10.getText().isEmpty() || tf10.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Quantidade!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        }  else if (tf1.getText().isEmpty() || tf1.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Tema!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
            segundatela.setVisible(false); 
            aba.setSelectedIndex(0);
            aba.getComponentAt(0).setVisible(true);
            primeiratela.setVisible(true);
        } else if (tf2.getText().isEmpty() || tf2.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Numero de Série!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        } else if (tf4.getText().isEmpty() || tf4.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Montadora!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }
        else  if (tf15.getText().isEmpty() || tf15.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Fabricante!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
            primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }
        else{
            tema=tf1.getText();
             montadora=tf4.getText();
             cor=tf3.getText();
             dimensao=tf5.getText();
             categoria=(String) combo_Cat.getSelectedItem();          
             numeroSerie = Integer.parseInt(tf2.getText());
             
             //**Convertendo String para data**//
             SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
             try { 
              d1 = new java.sql.Date(format.parse(tf13.getText()).getTime());}
             catch (ParseException x) { } 
          
             if(super.getNome() == null){
             super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf8.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),caminho,tf11.getText(),tf12.getText(), tf16.getText(),d1,tf14.getText(),tf15.getText());
             super.addEventoCadastrar("HotWheels");
             JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
            }
            else
            {
             super.addEventoAlterar("HotWheels",super.getNome(),tf6.getText());
             super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf8.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),caminho,tf11.getText(),tf12.getText(), tf16.getText(),d1,tf14.getText(),tf15.getText());
             JOptionPane.showMessageDialog(null,"Dados alterados com suceso!");
            }
             window.setVisible(false); 
             dispose();
        }
            
        } 
             
      }
      
 public String getInfo(){
     return super.getInfo()+",Tema: "+tema+",Montadora: "+montadora+",Cor: "+cor+",Dimenção: "+dimensao+",Categoria: "+categoria+",Numero Serie: "+numeroSerie;
    }
    
    //metodo padrão com msm nome para alteração de dados
 public void atualizarDados(){
     tf1.setText(tema);
     tf2.setText(""+numeroSerie);
     tf3.setText(cor);
     tf4.setText(montadora);
     tf5.setText(dimensao);
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
           HotWheels c = (HotWheels) super.clone(); 
           x=c;
        }catch (Exception e){}
       return x;
    } 
}