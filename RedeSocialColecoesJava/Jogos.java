import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.TimeZone;
import javax.swing.text.*; 

public class Jogos extends ItensComp implements ActionListener,Cloneable
{
   private String plataforma;
   private String genero;
   private String modoDeJogo;
   private String complemento;
   private String material;
   private String faixaEtaria;  
   
   JButton Sair1,Sair2,Sair3,AcidionarImagem,Prosseguir1,Prosseguir2,voltar;
    JPanel Aba_1,Aba_2;
    JLabel Cadastro1,Cadastro2,Cadastro3,Plataforma,Genero,ModoDeJogo,Nome,Material,FaixaEtaria,Datadelancamento,Valor,Desenvolvedor,Complemento,TempoUso,Tiragem;
    JLabel Origem,EstadoConservacao,Quantidade,Figura =new JLabel(""),ComentarioTexto,Obrigatorio;
    JTextField TextPlataforma = new JTextField(50),TextGenero = new JTextField(50),TextModoDeJogo = new JTextField(50),TextComplemento = new JTextField(50),
    TextMaterial = new JTextField(50),TextFaixaEtaria = new JTextField(50),TextDatadelancamento = new JTextField(50),TextNome  = new JTextField(50),TextTiragem = new JTextField(50);
    JTextField TextValor = new JTextField(50),TextDesenvolvedor = new JTextField(50),TextTempoUso = new JTextField(50),TextOrigem = new JTextField(50),TextEstadoConservacao = new JTextField(50),TextQuantidade = new JTextField(50);
    JTextArea Comentario =new JTextArea(); 
    JScrollPane ScrollBarra;
    JTabbedPane aba;
    MaskFormatter  Mascarat1;
    Date d1;
    String caminho = "";
    JFrame window;
   public Jogos(){}
   public Jogos(String material){ TextNome.setText(material);}
   
   public void setCadastrar(){
        window = new JFrame("Cadastrar jogos");  
        window.setIconImage(new ImageIcon("img\\minilogo.png").getImage());
       
        //------------JPanel------------
        Aba_1 =new JPanel();
        Aba_1.setLayout(null);
        Aba_2 =new JPanel();
        Aba_2.setLayout(null);
        
        //------------JTabbedPane------------
        aba=new JTabbedPane();
        aba.addTab("Primeiras informações",Aba_1);       
        aba.addTab("Informações adicionais",Aba_2);
        aba.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        window.add(aba); 
        
        //------------Tela 1---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //------------JLabel Tela 1------------
        Cadastro1 =new JLabel("Jogos");                             Cadastro1.setBounds(330,30,600,45);                 Cadastro1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));  Aba_1.add(Cadastro1);          Cadastro1.setForeground(Color.BLUE);
        Nome =new JLabel("Nome:");                                  Nome.setBounds(39,90,150,20);                       Nome.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(Nome);
        Genero =new JLabel("Genero:");                              Genero.setBounds(39,130,300,20);                    Genero.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20)); Aba_1.add(Genero);
        ModoDeJogo =new JLabel("Modo de jogo:");                    ModoDeJogo.setBounds(39,170,150,25);                ModoDeJogo.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(ModoDeJogo);
        Plataforma =new JLabel("Plataforma:");                      Plataforma.setBounds(39,210,150,25);                Plataforma.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(Plataforma);
        Desenvolvedor =new JLabel("Desenvolvedor:");                Desenvolvedor.setBounds(39,250,150,20);             Desenvolvedor.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(Desenvolvedor);
        FaixaEtaria =new JLabel("Faixa Etaria:");                   FaixaEtaria.setBounds(39,290,150,20);               FaixaEtaria.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(FaixaEtaria);
        Datadelancamento =new JLabel("Data de lançamento:");        Datadelancamento.setBounds(380,285,220,30);         Datadelancamento.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(Datadelancamento);
        Valor =new JLabel("Valor:");                                Valor.setBounds(39,330,150,20);                     Valor.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(Valor);
        TempoUso =new JLabel("Tempo de uso:");                      TempoUso.setBounds(380,330,220,20);                 TempoUso.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(TempoUso);
        Origem =new JLabel("Origem:");                              Origem.setBounds(39,367,300,30);                    Origem.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));  Aba_1.add(Origem);
        
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,90,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              Obrigatorio.setForeground(Color.RED);           Aba_1.add(Obrigatorio); 
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,130,20,20);                Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              Obrigatorio.setForeground(Color.RED);           Aba_1.add(Obrigatorio);
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,170,20,20);                Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              Obrigatorio.setForeground(Color.RED);           Aba_1.add(Obrigatorio);
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,210,20,25);                Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              Obrigatorio.setForeground(Color.RED);           Aba_1.add(Obrigatorio);
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,250,20,20);                Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              Obrigatorio.setForeground(Color.RED);           Aba_1.add(Obrigatorio);
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,290,20,20);                Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              Obrigatorio.setForeground(Color.RED);           Aba_1.add(Obrigatorio);
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,330,20,20);               Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                              Obrigatorio.setForeground(Color.RED);           Aba_1.add(Obrigatorio);
        
        //------------JTextField Tela 1------------
        TextNome.setBounds(120,85,625,30);                  TextNome.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));  Aba_1.add(TextNome);
        TextGenero.setBounds(125,130,620,30);               TextGenero.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));  Aba_1.add(TextGenero);
        TextModoDeJogo.setBounds(180,170,565,30);           TextModoDeJogo.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18)); Aba_1.add(TextModoDeJogo);
        TextPlataforma.setBounds(155,210,590,30);           TextPlataforma.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18)); Aba_1.add(TextPlataforma);
        TextDesenvolvedor.setBounds(195,250,550,30);        TextDesenvolvedor.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18)); Aba_1.add(TextDesenvolvedor);
        TextFaixaEtaria.setBounds(170,285,200,30);          TextFaixaEtaria.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18)); Aba_1.add(TextFaixaEtaria);
        try{Mascarat1 = new MaskFormatter("  ##/##/####");  Mascarat1.setPlaceholderCharacter('_');}            catch(Exception excp){}  
        TextDatadelancamento = new JFormattedTextField(Mascarat1);  TextDatadelancamento.setBounds(590,285,155,30);     TextDatadelancamento.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18)); Aba_1.add(TextDatadelancamento);
        String antiga = ""+super.getDataLancamento();
        String nova = antiga.replace("-","");
        if(!nova.equals("") && !nova.equals("null")) {
            TextDatadelancamento.setText(nova);
        }
        TextValor.setBounds(115,325,220,30);                TextValor.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));  Aba_1.add(TextValor);
        TextTempoUso.setBounds(540,325,205,30);             TextTempoUso.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18)); Aba_1.add(TextTempoUso);
        TextOrigem.setBounds(125,367,620,30);               TextOrigem.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));  Aba_1.add(TextOrigem);
        //------------JButton Tela 1------------
        Sair1 =new JButton("Cancelar");                             Sair1.setBounds(150,420,250,35);                    Sair1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20)); Aba_1.add(Sair1);  Sair1.addActionListener(this);
        Prosseguir1=new JButton("Prosseguir");                      Prosseguir1.setBounds(410,420,250,35);              Prosseguir1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20)); Aba_1.add(Prosseguir1); Prosseguir1.addActionListener(this);
        
        Sair1.setToolTipText(" Encerra a operação "); 
        Prosseguir1.setToolTipText(" Continua o preenchimento das questões ");
        UIManager.put("ToolTip.background",SystemColor.info); 
        
        //------------Tela 2---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //------------JLabel Tela 2------------
        Cadastro2 =new JLabel("Jogos");                             Cadastro2.setBounds(330,30,600,45);                 Cadastro2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));                   Aba_2.add(Cadastro2);                           Cadastro2.setForeground(Color.BLUE);
        EstadoConservacao =new JLabel("Estado de Conservacao:");    EstadoConservacao.setBounds(39,90,280,30);          EstadoConservacao.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));           Aba_2.add(EstadoConservacao);
        Material =new JLabel("Material:");                          Material.setBounds(39,130,150,30);                  Material.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                    Aba_2.add(Material);
        Complemento =new JLabel("Complemento:");                    Complemento.setBounds(39,170,150,30);               Complemento.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                 Aba_2.add(Complemento);
        Quantidade =new JLabel("Quantidade:");                      Quantidade.setBounds(39,210,150,30);                Quantidade.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                  Aba_2.add(Quantidade);
        Tiragem =new JLabel("Tiragem:");                            Tiragem.setBounds(39,250,150,30);                   Tiragem.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                     Aba_2.add(Tiragem);
        ComentarioTexto =new JLabel("Comentario :");                ComentarioTexto.setBounds(39,290,200,30);           ComentarioTexto.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));             Aba_2.add(ComentarioTexto);
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,90,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                 Obrigatorio.setForeground(Color.RED);           Aba_2.add(Obrigatorio);
        Obrigatorio =new JLabel("*");                               Obrigatorio.setBounds(30,210,20,20);                 Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));                 Obrigatorio.setForeground(Color.RED);           Aba_2.add(Obrigatorio);
        //------------JTextField Tela 2------------

        TextEstadoConservacao.setBounds(280,90,465,30);     TextEstadoConservacao.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));       Aba_2.add(TextEstadoConservacao);
        TextMaterial.setBounds(125,130,620,30);             TextMaterial.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));                Aba_2.add(TextMaterial);
        TextComplemento.setBounds(185,170,560,30);          TextComplemento.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));             Aba_2.add(TextComplemento);
        TextQuantidade.setBounds(185,210,301,30);           TextQuantidade.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));              Aba_2.add(TextQuantidade);
        TextTiragem.setBounds(185,250,301,30);              TextTiragem.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));                 Aba_2.add(TextTiragem);
        Figura.setBounds(520,210,225,200);                  Aba_2.add(Figura);
        Figura.setBorder(new javax.swing.border.TitledBorder("Imagem do Jogo"));                                       
        
        //------------JTextArea e JScrollPane Tela 3------------
        Comentario.setLineWrap(true);                       Comentario.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        ScrollBarra =new JScrollPane(Comentario);                   ScrollBarra.setBounds(39,330,450,80);               Aba_2.add(ScrollBarra);                             
        
        //------------JButton Tela 2------------
        Sair2 =new JButton("Cancelar");                             Sair2.setBounds(39,420,230,35);                     Sair2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20)); Aba_2.add(Sair2);              Sair2.addActionListener(this);
        Prosseguir2=new JButton("Terminado");                       Prosseguir2.setBounds(280,420,230,35);              Prosseguir2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20)); Aba_2.add(Prosseguir2);  Prosseguir2.addActionListener(this);
        voltar = new JButton();                                     voltar.setBounds(5,5,45,45);                        voltar.setIcon(new ImageIcon("img/voltar.png"));                                               voltar.addActionListener(this);      Aba_2.add(voltar);
        AcidionarImagem =new JButton("Adicionar Imagem");           AcidionarImagem.setBounds(520,420,225,35);          AcidionarImagem.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));   Aba_2.add(AcidionarImagem);                          AcidionarImagem.addActionListener(this);
        
        
        
        
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        TextNome.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Nome!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
        TextGenero.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Genero!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        TextModoDeJogo.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Modo de jogo!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
        TextPlataforma.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Plataforma!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
        TextEstadoConservacao.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Estado de conservacao!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         
        TextValor.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Valor!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        TextFaixaEtaria.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Faixa etaria!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        TextValor.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Valor!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        TextDesenvolvedor.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Desenvolvedor!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        TextQuantidade.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Jogos.this, "Informe o campo Quantidade!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        

        Sair2.setToolTipText(" Encerra a operação "); 
        Prosseguir2.setToolTipText(" Finaliza a operação ");
        voltar.setToolTipText(" Retornar a primeira tela "); 
        UIManager.put("ToolTip.background",SystemColor.info); 
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        window.setResizable(false);
        window.setSize(800,550);
        window.setVisible(true);
        window.setDefaultCloseOperation(1);
        window.setLocationRelativeTo(null);
            }
    
    
     public void actionPerformed(ActionEvent event)
     {
       
      if (event.getSource()==Sair1 || event.getSource()==Sair2 || event.getSource()==Sair3)
      {window.setVisible(false); window.dispose();}
      if (event.getSource()==AcidionarImagem)
      {JFileChooser pasta= new JFileChooser();
       caminho = ""; File file = null; int retorno = pasta.showSaveDialog(null);
      if (retorno==JFileChooser.APPROVE_OPTION)
      {caminho = pasta.getSelectedFile().getAbsolutePath();
       ImageIcon img2 = new ImageIcon (caminho);  
                 img2.setImage(img2.getImage().getScaledInstance(225,200, 100)); 
                 Figura.setIcon(img2); }}
      if (event.getSource()==Prosseguir1)
      {      Aba_1.setVisible(false); 
             aba.setSelectedIndex(1);
             aba.getComponentAt(1).setVisible(true);
             Aba_2.setVisible(true);}
      if (event.getSource()==voltar)
      {      Aba_2.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             Aba_1.setVisible(true);}
    
             
      else if(event.getSource()== Prosseguir2){       
        
             
         if (TextNome.getText().isEmpty() || TextNome.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Nome!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             Aba_2.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             Aba_1.setVisible(true);
        } else if (TextGenero.getText().isEmpty() || TextGenero.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Genero'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             Aba_2.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             Aba_1.setVisible(true);
        }  else if (TextModoDeJogo.getText().isEmpty() || TextModoDeJogo.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Modo de jogo'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             Aba_2.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             Aba_1.setVisible(true);
        }  else if (TextPlataforma.getText().isEmpty() || TextPlataforma.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Plataforma'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             Aba_2.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             Aba_1.setVisible(true);
        
        } else if (TextEstadoConservacao.getText().isEmpty() || TextEstadoConservacao.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Estado de conservação'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             Aba_2.setVisible(true); 
             aba.setSelectedIndex(1);
             aba.getComponentAt(1).setVisible(true);
             Aba_1.setVisible(false);
        } else if (TextValor.getText().isEmpty() || TextValor.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Valor'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             Aba_2.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             Aba_1.setVisible(true);
        }else  if (TextFaixaEtaria.getText().isEmpty() || TextFaixaEtaria.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Faixa etaria'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             Aba_2.setVisible(false); 
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             Aba_1.setVisible(true);
        }else  if (TextQuantidade.getText().isEmpty() || TextQuantidade.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Quantidade'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
             Aba_1.setVisible(false); 
             Aba_2.setVisible(true);
        }else  if (TextDesenvolvedor.getText().isEmpty() || TextDesenvolvedor.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Campo ''Desenvolvedor'' Atribuido Incorretamente","Erro de Validação!",JOptionPane.ERROR_MESSAGE);
            Aba_2.setVisible(false); 
            aba.setSelectedIndex(0);
            aba.getComponentAt(0).setVisible(true);
            Aba_1.setVisible(true);
        }    
        else{
            plataforma = TextPlataforma.getText();
            genero = TextGenero.getText();
            modoDeJogo = TextModoDeJogo.getText();
            complemento = TextComplemento.getText();
            material = TextMaterial.getText();
            faixaEtaria = TextFaixaEtaria.getText(); 
            //**Convertendo String para data**//
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try { 
                d1 = new java.sql.Date(format.parse(TextDatadelancamento.getText()).getTime());}
             catch (ParseException x) { } 
             
             //compara se essa tela é cadastrar ou alterar
             if(super.getNome() == null){
             super.setAttDados(Double.parseDouble(TextValor.getText()),TextNome.getText(),TextTempoUso.getText(),TextOrigem.getText(),Integer.parseInt(TextQuantidade.getText()),caminho,
             TextEstadoConservacao.getText(),TextTiragem.getText(),Comentario.getText(),d1,null,TextDesenvolvedor.getText());
             super.addEventoCadastrar("Jogos");
             JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
            }
            else{
             super.addEventoAlterar("Jogos",super.getNome(),TextNome.getText());
             super.setAttDados(Double.parseDouble(TextValor.getText()),TextNome.getText(),TextTempoUso.getText(),TextOrigem.getText(),Integer.parseInt(TextQuantidade.getText()),caminho,
             TextEstadoConservacao.getText(),TextTiragem.getText(),Comentario.getText(),d1,null,TextDesenvolvedor.getText());
             JOptionPane.showMessageDialog(null,"Dados alterados com suceso!");
            } 
                    
             window.setVisible(false);
             window.dispose();
                    }
              
        } 
     }       
    
     public String getInfo(){
     return super.getInfo()+",Plataforma: "+plataforma+",Genero: "+genero+",Modo de jogo: "+modoDeJogo+",Complemento: "+complemento+",Meterial: "+material+",Faixa Etaria: "+faixaEtaria;
    }
    
    //metodo padrão com msm nome para alteração de dados
     public void atualizarDados(){
     TextPlataforma.setText(plataforma);
     TextGenero.setText(genero); 
     TextModoDeJogo.setText(modoDeJogo); 
     TextComplemento.setText(complemento);
     TextMaterial.setText(material); 
     TextFaixaEtaria.setText(faixaEtaria);
     TextNome.setText(super.getNome());  
     TextTiragem.setText(super.getTiragens()); 
     TextValor.setText(""+super.getValor()); 
     TextDesenvolvedor.setText(super.getFabricante());
     TextTempoUso.setText(""+super.getTempoUso());
     TextOrigem.setText(super.getOrigem()); 
     TextEstadoConservacao.setText(super.getEstadoConservacao()); 
     TextQuantidade.setText(""+super.getQuantidade()); 
     Comentario.setText(super.getComentario()); 
     ImageIcon img2 = new ImageIcon (super.getEndrecoImg());  
     img2.setImage(img2.getImage().getScaledInstance(225,200, 100)); 
     Figura.setIcon(img2);
     setCadastrar();
     }
     
         //permite que a classe seja clonada
    public Object clone() {
       Object x = new Object();
       try{
           Jogos c = (Jogos) super.clone(); 
           x=c;
        }catch (Exception e){}
       return x;
    } 
     
     }
     
  
