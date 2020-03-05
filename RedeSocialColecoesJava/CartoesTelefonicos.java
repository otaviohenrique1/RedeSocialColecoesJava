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

public class CartoesTelefonicos extends ItensComp implements ActionListener, Cloneable
{
  private String caminho="";
  private String defeito;
  private String tema;
  private String operadora;
  Date d1;
  MaskFormatter  mascarat1;
  
  JPanel primeiratela,segundatela;JTabbedPane aba;
  JButton bt0,bt1,bt2,bt3,bt4,bt5,pt1,voltar;
  JLabel img= new JLabel(),jlCadas= new JLabel("Cartões Telefonicos"),jlCadas1= new JLabel("Cartões Telefonicos"),jlCadas2= new JLabel("Cartões Telefonicos"),jl1= new JLabel("Operadora:"),
  jl4=new JLabel("Tema:"),jl5=new JLabel("Algum defeito de fabricação?"),serie=new JLabel("Serie:"),fabricante=new JLabel("Fabricante:"),
  jl9=new JLabel("Nome:"),jl10=new JLabel("Valor:"),jl11=new JLabel("Tempo de Uso:"),jl12=new JLabel("Origem:"),jl13=new JLabel("Quantidade:"),jl14=new JLabel("Estado de Conservação:"),
  jl15=new JLabel("Tiragem:"),jl16=new JLabel("Data de Lançamento:"),jl19=new JLabel("Comentarios:");
  
  JTextField tf1 = new JTextField(""),tf2= new JTextField(""),tf3= new JTextField(""),tf4= new JTextField(""),tf5= new JTextField (""),
  tf6 = new JTextField(40),tf7 = new JTextField(40),tf8 = new JTextField(40),tf9 = new JTextField(40),tf10 = new JTextField(40),
  tf11 = new JTextField(40),tf12 = new JTextField(40),tf13 = new JTextField(40),tserie = new JTextField(40),tfabricante= new JTextField(40);
  JTextArea tf16 = new JTextArea( 4, 10);
  JComboBox combo_Patch;
  JScrollPane scrollPane = new JScrollPane(tf16);
  JFrame window;
  
  //**Construtor**//
  
  public CartoesTelefonicos(){}
  
  //**Metodo**// 
      
   public void setCadastrar(){     
  window = new JFrame("Cadastrar Cartões telefonicos"); 
  window.setIconImage(new ImageIcon("img\\minilogo.png").getImage()); 
  //**Criando Container**//
           
  //**Paineis**//
  primeiratela = new JPanel(); 
  primeiratela.setLayout (null);
  primeiratela.setSize(800,480);
  
      
  segundatela = new JPanel ();
  segundatela.setLayout (null);
  segundatela.setSize(800,500);
  
  
  //**Criando abas**//
  aba=new JTabbedPane();
        aba.addTab("Primeiras informações",null,primeiratela,"Primera Tela");
        aba.addTab("Informações adicionais",null,segundatela,"Segunda Tela");
        aba.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        aba.setVisible(true);
        aba.setSize(800,500);
   window.add(aba);
  
  //**Titulo**//
  
  //**1� Painel**//
  jlCadas.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas.setBounds(200, 30, 400, 35);//(distancia do canto, distancia do teto,largura , altura) em pixel
  jlCadas.setForeground(Color.BLUE);
  primeiratela.add(jlCadas);
  
  //**2� Painel**//
 
  jlCadas1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
  jlCadas1.setForeground(Color.BLUE);
  jlCadas1.setBounds(200, 30, 400, 35);
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
  JLabel obri5 = new JLabel("*");
  obri5.setBounds(29, 200,150, 30);
  obri5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri5.setForeground(Color.RED);
  primeiratela.add(obri5);
  jl13.setBounds(39, 200,150, 30);
  jl13.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(jl13); 
  tf10.setBounds(170, 200,240, 30);
  tf10.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(tf10);
  
  //**Estado**//
  JLabel obri6 = new JLabel("*");
  obri6.setBounds(29,160, 250, 30);
  obri6.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri6.setForeground(Color.RED);
  primeiratela.add(obri6);
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
  //Atualiza a data do textfield <-------------------------------
        String antiga = ""+super.getDataLancamento();
        String nova = antiga.replace("-", "");  
        if(!nova.equals("") && !nova.equals("null")){
         tf13.setText(nova);
        }
  
  //**Serie**//
  serie.setBounds(420,280, 300, 30);
  serie.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(serie);
  tserie.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  tserie.setBounds(500, 280, 250, 30);
  primeiratela.add(tserie);
  
  
  //**Fabricante**//
  JLabel obri0 = new JLabel("*");
  obri0.setBounds(29,320, 300, 30);
  obri0.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri0.setForeground(Color.RED);
  primeiratela.add(obri0);
  fabricante.setBounds(39,320, 300, 30);
  fabricante.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  primeiratela.add(fabricante);
  tfabricante.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  tfabricante.setBounds(160, 320, 590, 30);
  primeiratela.add(tfabricante);
  
  /*** Segundo Painel ***/
  
  //**Operadora**//
  jl1.setBounds(39, 80, 150, 30);
  jl1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl1); 
  tf1.setBounds(160, 80, 200, 30);
  tf1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf1);  
  
  
  //**tema**//
   JLabel obri11 = new JLabel("*");
  obri11.setBounds(410,80, 300, 30);
  obri11.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,20));
  obri11.setForeground(Color.RED);
  segundatela.add(obri11);
  jl4.setBounds(420,80, 300, 30);
  jl4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl4);
  tf3.setBounds(500, 80, 250, 30);
  tf3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(tf3);
  
  //**Defeito**//
  jl5.setBounds(39, 120,300, 30);
  jl5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl5);
  combo_Patch = new JComboBox();
  combo_Patch.addItem("Não");
  combo_Patch.addItem("Sim");
  combo_Patch.setBounds(330,120,150,30);
  combo_Patch.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(combo_Patch);
  
  //**Comentario**//
  tf16.setLineWrap(true);
  tf16.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  jl19.setBounds(39, 160, 200, 30);
  jl19.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  segundatela.add(jl19);
  scrollPane.setBounds(39,200,493,110);
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
  bt1.setBounds(140, 370, 250, 35);
  bt1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  bt1.setVisible(true);
  primeiratela.add(bt1);
        
  pt1 = new JButton("Prosseguir");
  pt1.addActionListener(this);  
  pt1.setBounds(400, 370, 250, 35);
  pt1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
  pt1.setVisible(true);
  primeiratela.add(pt1);
        
  bt2 = new JButton("Cancelar");
        bt2.addActionListener(this);  
        bt2.setBounds(39, 330, 245, 35);
        bt2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        segundatela.add(bt2);
        
        //**Botao diretorio**//
        
        bt5 = new JButton("Adicionar");
        bt5.addActionListener(this);       
        bt5.setBounds(550,330,200,35);
        bt5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        segundatela.add(bt5);
        
         bt3 = new JButton("Finalizar");
        bt3.addActionListener(this);  
        bt3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        bt3.setBounds(295, 330, 245, 35);
        bt3.setVisible(true);
        segundatela.add(bt3);
       
      
        voltar = new JButton();
        voltar.setIcon( new ImageIcon("img/voltar.png"));
        voltar.setBounds(5,5,45,45);  
        voltar.addActionListener(this);
        segundatela.add(voltar);
        
        
        img.setBounds(550,120,200,200);
        img.setBorder(new javax.swing.border.TitledBorder("Imagem do Cartão"));
        segundatela.add(img);
        
tf6.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(CartoesTelefonicos.this, "Informe o campo Nome!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
tf7.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(CartoesTelefonicos.this, "Informe o campo Valor!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
tf10.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(CartoesTelefonicos.this, "Informe o campo Quantidade!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
tf11.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(CartoesTelefonicos.this, "Informe o campo Estado de Conservação!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
tfabricante.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(CartoesTelefonicos.this, "Informe o campo Fabricante!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
tf3.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
JOptionPane.showMessageDialog(CartoesTelefonicos.this, "Informe o campo Tema!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
   
 combo_Patch.setSelectedItem(defeito);     
        //**Finalizando Container**//
        window.setVisible(true);
        window.setSize(800,500);
        window.setDefaultCloseOperation(1);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
}

 public void actionPerformed(ActionEvent e){
        if(e.getSource()== bt1 || e.getSource()== bt2 || e.getSource()== bt4)
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
        } else if (tf10.getText().isEmpty() || tf10.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Quantidade'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        } else if (tf11.getText().isEmpty() || tf11.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Estado'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             segundatela.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiratela.setVisible(true);
        }else  if (tfabricante.getText().isEmpty() || tfabricante.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Fabricante'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
            segundatela.setVisible(false); 
            aba.setSelectedIndex(0);
            aba.getComponentAt(0).setVisible(true);
            primeiratela.setVisible(true);
        }    /**validando campos tela 2**/
              
               else  if (tf3.getText().isEmpty() || tf3.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Tema'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             primeiratela.setVisible(false); 
             segundatela.setVisible(true);
        }   else{
                
             operadora=tf1.getText();
             tema=tf3.getText();              
             defeito=(String) combo_Patch.getSelectedItem();

             //**Convertendo String para data**//
             SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
             try { 
                d1 = new java.sql.Date(format.parse(tf13.getText()).getTime());}
             catch (ParseException x) { } 
             //valor, nome, tempoUso, origem, quantide,estadoConservacao, tiragens, comentario, dataLancamento, endrecoImg
             if(super.getNome() == null){
             super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf8.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),caminho,tf11.getText(),tf12.getText(), tf16.getText(),d1,tserie.getText(),tfabricante.getText());
             super.addEventoCadastrar("Cartões Telefonicos");
             JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
            }
            else{
             super.addEventoAlterar("Cartões Telefonicos",super.getNome(),tf6.getText());
             super.setAttDados(Double.parseDouble(tf7.getText()),tf6.getText(),tf8.getText(),tf9.getText(),Integer.parseInt(tf10.getText()),caminho,tf11.getText(),tf12.getText(), tf16.getText(),d1,tserie.getText(),tfabricante.getText());
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
     return super.getInfo()+",Operadora: "+operadora+",Defeito: "+defeito+",Tema: "+tema;
    }
   
  //metodo padrão com msm nome para alteração de dados
 public void atualizarDados(){
  tf1.setText(operadora);
  tf3.setText(tema);
  tf6.setText(super.getNome());
  tf7.setText(""+super.getValor());
  tf8.setText(super.getTempoUso());
  tf9.setText(super.getOrigem());
  tf10.setText(""+super.getQuantidade());
  tf11.setText(super.getEstadoConservacao());
  tf12.setText(super.getTiragens());
  tserie.setText(super.getSerie());
  tfabricante.setText(super.getFabricante());
  tf16.setText(super.getComentario());
  setCadastrar();
     }
     
      //permite que a classe seja clonada
    public Object clone() {
       Object x = new Object();
       try{
           CartoesTelefonicos c = (CartoesTelefonicos) super.clone(); 
           x=c;
        }catch (Exception e){}
       return x;
    } 
 
}