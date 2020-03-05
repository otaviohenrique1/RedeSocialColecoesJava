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

public class Moedas extends ItensColecionaveis implements ActionListener,Cloneable
{
  private String material;
    private double peso;
    private String erros;
    private String prensa;
    private String dimensao;
    private int vUnit;
 
    
    MaskFormatter  mascarat1;
    Date d1;
    
  String caminho = "";
  JButton bt1,bt2,bt3,bt5,pt1,voltar ;
  JLabel img= new JLabel(),jlCadas= new JLabel("Moedas"),jlCadas1= new JLabel("Moedas"),jl1= new JLabel("Material:"),jl2=new JLabel("Erro de fabricação?"),
  jl3=new JLabel("Peso:"),jl4=new JLabel("Dimensão:"), j15=new JLabel ("Valor Unitário:"),j16=new JLabel ("Prensa:"),
  jl9=new JLabel("Nome:"),jl10=new JLabel("Valor:"),jl12=new JLabel("Origem:"),jl13=new JLabel("Quantidade:"),jl14=new JLabel("Estado de Conservação:"),
  jl15=new JLabel("Tiragem:"),jl16=new JLabel("Data de Lançamento:"),jl19=new JLabel("Comentários:");
  JTextField tf1 = new JTextField(40),tf2= new JTextField(40),tf3= new JTextField(40),tf4= new JTextField(40),tf5= new JTextField(40),
  tf6 = new JTextField(40),tf7 = new JTextField(40),tf9 = new JTextField(40),tf10 = new JTextField(40),
  tf11 = new JTextField(40),tf12 = new JTextField(40),tf13 = new JTextField(40),tf14 = new JTextField(40),tf15 = new JTextField(40);
  JComboBox combo_Aut;
  JTextArea tf16 = new JTextArea( 4, 10);
  JScrollPane scrollPane = new JScrollPane(tf16);
  JPanel primeiratela,segundatela;JTabbedPane aba;
  JFrame window;
  //**Construtor**//
  
  public Moedas(){}
  
  //**Metodo**// 
  
      
 public void setCadastrar(){    
  window = new JFrame("Cadastrar Moedas"); 
  window.setIconImage(new ImageIcon("img\\minilogo.png").getImage()); 
 
  //**Paineis**//
  primeiratela = new JPanel ();
  primeiratela.setLayout (null);
  primeiratela.setSize(800,480);
      
  segundatela = new JPanel ();
  segundatela.setLayout (null);
  segundatela.setSize(800,480);
  
  //**Criando abas**//
        aba=new JTabbedPane();
        aba.addTab("Primeiras informações",null,primeiratela);
        aba.addTab("Informações adicionais",null,segundatela);
        aba.setVisible(true);
        aba.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        aba.setSize(800,480);
  window.add(aba);
  
  //**Titulo**//
  
  //**1� Painel**//
  jlCadas.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas.setBounds(300, 30, 400, 35);//(distancia do canto, distancia do teto,largura , altura) em pixel
  jlCadas.setForeground(Color.BLUE);
  primeiratela.add(jlCadas);
  
  //**2� Painel**//
  jlCadas1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas1.setBounds(300, 30, 400, 35);
  jlCadas1.setForeground(Color.BLUE);
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
  tf6.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  primeiratela.add(tf6);
  
  //**Valor**//
  JLabel obri2 = new JLabel("*");
  obri2.setBounds(410, 200, 200, 30);
  obri2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri2.setForeground(Color.RED);
  primeiratela.add(obri2);
  
  jl10.setBounds(420, 200, 150, 30);
  jl10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl10); 
  tf7.setBounds(510, 200, 240, 30);
  tf7.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  primeiratela.add(tf7);
  
  
  //**Origem**//
  jl12.setBounds(39,120, 150, 30);
  jl12.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl12); 
  tf9.setBounds(120,120, 630, 30);
  tf9.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
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
  tf10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  primeiratela.add(tf10);
  
  //**Estado**//
  jl14.setBounds(39,160, 250, 30);
  jl14.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl14); 
  tf11.setBounds(280,160, 470, 30);
  tf11.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  primeiratela.add(tf11);
  
  //**Tiragem**//
  jl15.setBounds(39,240, 200, 30);
  jl15.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl15); 
  tf12.setBounds(170, 240, 240, 30);
  tf12.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  primeiratela.add(tf12);
  
  //**Data**//
  //**Adicionando mascara ao TextField em formato de Data(try obrigatorio antes do setBounds)**//
  try{
         mascarat1 = new MaskFormatter("  ##/##/####");
         mascarat1.setPlaceholderCharacter('_');
         } 
        catch(Exception excp){} 
  
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
  tf13.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  tf13.setBounds(260, 280, 150, 30);
  primeiratela.add(tf13);
  
  
  
  //**Material**//
  jl1.setBounds(39, 320, 150, 30);
  jl1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl1); 
  tf1.setBounds(140, 320, 610, 30);
  tf1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  primeiratela.add(tf1);
  
  //**erro fabricaco**//
  jl2.setBounds(420, 240, 250, 30);
  jl2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl2);
  combo_Aut = new JComboBox();
  combo_Aut.addItem("Não");
  combo_Aut.addItem("Sim");
  combo_Aut.setBounds(620, 240, 130, 30);
  combo_Aut.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(combo_Aut);
  
tf6.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(Moedas.this, "Informe o campo Nome da moeda!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
tf7.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(Moedas.this, "Informe o campo valor!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
tf10.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(Moedas.this, "Informe o campo quantidade!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
  
  /*** Segundo Painel ***/
  
  //**peso**//
   JLabel obri5 = new JLabel("*");
  obri5.setBounds(30, 80, 150, 30);
  obri5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri5.setForeground(Color.RED);
  segundatela.add(obri5);
  
  jl3.setBounds(39,80,150, 30);
  jl3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl3);
  tf2.setBounds(110,80,240,30);
  tf2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  segundatela.add(tf2);
  
  //**Dimensao**//
    jl4.setBounds(39,120,150, 30);
  jl4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl4);
  tf3.setBounds(150,120,600,30);
  tf3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  segundatela.add(tf3);
  
  // ** valor unitario **//
  JLabel obri10 = new JLabel("*");
  obri10.setBounds(355, 80, 150, 30);
  obri10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri10.setForeground(Color.RED);
  segundatela.add(obri10);
  
  j15.setBounds (365, 80, 150 ,30);
  j15.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(j15);
  tf4.setBounds (510, 80, 240, 30);
  tf4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  segundatela.add(tf4);
  
  //**prensa**//
  
  j16.setBounds(39, 160, 200, 30);
  j16.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(j16);
  tf5.setBounds (150,160,600,30);
  tf5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  segundatela.add(tf5);
  
  /*** Terceiro Painel ***/
    
  //**Comentario**//
  tf16.setLineWrap(true);
  tf16.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
  jl19.setBounds(39, 200, 150, 30);
  jl19.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl19);
  scrollPane.setBounds(39,240,500,120);
  segundatela.add(scrollPane);
  //**Adicionando Imagem**//
 
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
  
  JLabel obri19 = new JLabel("Campo Obrigatorio!");
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
  
  JLabel obri18 = new JLabel("Campo Obrigatorio!");
  obri18.setBounds(640,30,180,20);
  obri18.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,12));
  obri18.setForeground(Color.BLACK);
  segundatela.add(obri18);
 
  
  
  
  
  //**Botao Cancelar**//
  
        bt1 = new JButton("Cancelar");
        bt1.addActionListener(this);  
        bt1.setBounds(140, 370, 250, 35);
        bt1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        bt1.setVisible(true);
        primeiratela.add(bt1);
        
        pt1 = new JButton("Prosseguir");
        pt1.addActionListener(this);  
        pt1.setBounds(400, 370, 250, 35);
        pt1.setVisible(true);
        pt1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        primeiratela.add(pt1);   
        
        
        bt2 = new JButton("Cancelar");
        bt2.addActionListener(this);  
        bt2.setBounds(39, 370, 245, 35);
        bt2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        bt2.setBackground(new Color(229,255,173));
        segundatela.add(bt2);
               
         //**Botao Finalizar**//
         
        bt3 = new JButton("Finalizar");
        bt3.addActionListener(this);  
        bt3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        bt3.setBounds(295, 370, 245, 35);
        bt3.setVisible(true);
        segundatela.add(bt3);
        
        voltar = new JButton();
        voltar.setIcon( new ImageIcon("img/voltar.png"));
        voltar.setBounds(5,5,45,45); 
        voltar.addActionListener(this);
        segundatela.add(voltar);
        
        //**Botao diretorio**//
        
        bt5 = new JButton("Adicionar");
        bt5.addActionListener(this);  
        bt5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        bt5.setBounds(550,370,200,35);
        bt5.setVisible(true);
        segundatela.add(bt5);
        
        img.setBounds(550,200,200,160);
        img.setBorder(new javax.swing.border.TitledBorder("Imagem da Moeda"));
        segundatela.add(img);
        
         //atualiza combox
        
            combo_Aut.setSelectedItem(erros);
            
tf2.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
 JOptionPane.showMessageDialog(Moedas.this, "Informe o campo peso!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
tf4.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(Moedas.this, "Informe o campo valor unitario!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});

  
        
        //**Finalizando Container**//
        window.setVisible(true);
        window.setSize(800,500);
        window.setDefaultCloseOperation(1);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
  }
  public void actionPerformed(ActionEvent e){
        if(e.getSource()== bt1 || e.getSource()== bt2 )
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
                 img2.setImage(img2.getImage().getScaledInstance(200,160, 100)); 
                 img.setIcon(img2); }
        }
        else if(e.getSource()== bt3){
            
             /**validando campos tela 1**/
               if (tf6.getText().isEmpty() || tf6.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"O Campo ''Nome''é obrigatorio! ","",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        
            }  else if (tf7.getText().isEmpty() || tf7.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"O Campo ''Valor'' é obrigatorio! ","",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        }  else if (tf10.getText().isEmpty() || tf10.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"O Campo ''Quantidade'' é obrigatorio!","",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        } 
    
           
         /**validando campos tela 2**/
        else  if (tf2.getText().isEmpty() || tf2.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"O Campo ''Peso '' é obrigatorio!","",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);  
                
        }  else  if (tf4.getText().isEmpty() || tf4.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"O Campo ''Valor Unitário '' é obrigatorio!","",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        } 
            
         else{   
            
             material=tf1.getText();
             dimensao=tf3.getText();
             prensa=tf5.getText();
             erros=(String) combo_Aut.getSelectedItem();         
             peso = Double.parseDouble(tf2.getText());
             vUnit = Integer.parseInt(tf4.getText());
             
             //**Convertendo String para data**//
             SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
             try { 
                d1 = new java.sql.Date(format.parse(tf13.getText()).getTime());}
             catch (ParseException x) { } 
             
             if(super.getNome() == null){
             super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),tf11.getText(),tf12.getText(), tf16.getText(),d1,caminho);
             super.addEventoCadastrar("Moedas");
             JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
            }
            else{
             super.addEventoAlterar("Moedas",super.getNome(),tf6.getText());
             super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),tf11.getText(),tf12.getText(), tf16.getText(),d1,caminho);
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
    return super.getInfo()+",Material: "+material+",Peso: "+peso+",Erro de fabricação: "+erros+",Prensa: "+prensa+",Dimenção: "+dimensao+",Valor unitario: "+vUnit;
    }
    
  //metodo padrão com msm nome para alteração de dados
  public void atualizarDados(){
   tf1.setText(material);
   tf2.setText(""+peso);
   tf3.setText(dimensao);
   tf4.setText(""+vUnit);
   tf5.setText(prensa);
   tf6.setText(super.getNome()); 
   tf7.setText(""+super.getValor());
   tf9.setText(super.getOrigem()); 
   tf10.setText(""+super.getQuantidade());
   tf11.setText(super.getEstadoConservacao()); 
   tf12.setText(super.getTiragens());
   tf16.setText(super.getComentario());
   ImageIcon img2 = new ImageIcon (super.getEndrecoImg());  
   img2.setImage(img2.getImage().getScaledInstance(200,160, 100)); 
   img.setIcon(img2);
   setCadastrar();
     }
  
  public Object clone() {
       Object x = new Object();
       try{
           Moedas c = (Moedas) super.clone(); 
           x=c;
        }catch (Exception e){}
       return x;
    } 
}
