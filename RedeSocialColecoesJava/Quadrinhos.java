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

public class Quadrinhos extends ItensComp implements ActionListener,Cloneable
{
    private String autor;
    private int npaginas;
    private String faixaEtaria;
    
    public String caminho= "";
    static JLabel img = new JLabel("");
    JButton terminado;
    JTextField valor = new JTextField(15),nomeQuadrinho = new JTextField(50),tempoUso = new JTextField(50),nomeAutor = new JTextField(50),nomeEditora = new JTextField(50),
    serie = new JTextField(50),idadeLeitura = new JTextField(5),estadoConservacao = new JTextField(50),dtLancamento = new JTextField(10),idioma = new JTextField(20),
    qtdExemplares = new JTextField(5),nPaginas = new JTextField(5),tiragem = new JTextField(10);
    
    JTextArea comentario = new JTextArea( 4, 10);
    JLabel Obrigatorio;
    Date d1;
    MaskFormatter  mascarat1;
    JPanel primeiraTela,segundaTela;
    JTabbedPane aba;
    JFrame window;
    Quadrinhos(){}
    
    public void setCadastrar(){
        window = new JFrame("Quadrinhos"); 
        window.setIconImage(new ImageIcon("img\\minilogo.png").getImage());
        
        //Primeira tela 
        primeiraTela = new JPanel(); 
        primeiraTela.setLayout(null);
        
        segundaTela = new JPanel(); 
        segundaTela.setLayout(null);
        segundaTela.setVisible(false); 
        
        JLabel nomeTela = new JLabel("Quadrinhos");
        JLabel msgInicio = new JLabel("Para conhecermos melhor a sua coleção, preencha os campos a seguir:");
        JLabel infoTela = new JLabel("<html>Nome do Quadrinho:<br><br>Tempo de Uso:<br><br>Nome do autor(a):<br><br>Nome da Editora:<br><br>Serie:<br><br>Idade recomendada para leitura:");
        
        JButton cancelar = new JButton("Cancelar");
        JButton prosseguir = new JButton("Prosseguir");
        aba=new JTabbedPane();
        
        nomeTela.setBounds(280,30,600,45);
        msgInicio.setBounds(45,50,860,80);
        infoTela.setBounds(39,110,450,300);
        
        nomeTela.setForeground(Color.BLUE);
        
        nomeQuadrinho.setBounds(260,127,470,35);
        tempoUso.setBounds(240,173,490,35);
        nomeAutor.setBounds(240,219,490,35);
        nomeEditora.setBounds(240,268,490,35);
        serie.setBounds(120,316,610,35);
        idadeLeitura.setBounds(360,364,370,35);
        
        Obrigatorio =new JLabel("*");        Obrigatorio.setBounds(30,127,470,35);        Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));        Obrigatorio.setForeground(Color.RED);        primeiraTela.add(Obrigatorio);
        Obrigatorio =new JLabel("*");        Obrigatorio.setBounds(30,219,490,35);        Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));        Obrigatorio.setForeground(Color.RED);        primeiraTela.add(Obrigatorio);
        Obrigatorio =new JLabel("*");        Obrigatorio.setBounds(30,364,610,35);        Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));        Obrigatorio.setForeground(Color.RED);        primeiraTela.add(Obrigatorio);
        
        nomeQuadrinho.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Quadrinhos.this, "Informe o campo Nome do Quadrinho!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        nomeAutor.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Quadrinhos.this, "Informe o campo Nome do autor(a)!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        idadeLeitura.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Quadrinhos.this, "Informe a idade para a leitura!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        cancelar.setBounds(150,420,250,35);
        prosseguir.setBounds(410,420,250,35);       
        
        cancelar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
             window.setVisible(false); 
             window.dispose();
            }
        }
        );
        prosseguir.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        nomeTela.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 40));
        msgInicio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        infoTela.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        nomeQuadrinho.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        tempoUso.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        nomeAutor.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        nomeEditora.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        serie.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        idadeLeitura.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        cancelar.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        
        prosseguir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
             primeiraTela.setVisible(false); 
             aba.setSelectedIndex(1);
             aba.getComponentAt(1).setVisible(true);
             segundaTela.setVisible(true); 
            }
        }
        );
        
        cancelar.setToolTipText(" Encerra a operação "); 
        prosseguir.setToolTipText(" Continua o preenchimento das questões ");
        UIManager.put("ToolTip.background",SystemColor.info); 
        
        window.add(nomeTela);
        primeiraTela.add(msgInicio);
        primeiraTela.add(infoTela);
        primeiraTela.add(nomeQuadrinho);
        primeiraTela.add(tempoUso);
        primeiraTela.add(nomeAutor);
        primeiraTela.add(nomeEditora);
        primeiraTela.add(serie);
        primeiraTela.add(idadeLeitura);
        primeiraTela.add(cancelar);
        primeiraTela.add(prosseguir);

        primeiraTela.setSize(800,550);
        primeiraTela.setVisible(true);
        window.add(primeiraTela);
        
        
        //Segunda tela ===========================================================================================
        
        JLabel msgInicio2 = new JLabel("Está terminando... Preencha só mais essas");
        JLabel texto1 = new JLabel("Estado de conservação:");
        JLabel texto2 = new JLabel("Data de lançamento:");
        JLabel texto3 = new JLabel("Idioma:");
        JLabel texto4 = new JLabel("Exemplares:");
        JLabel texto5 = new JLabel("Número de páginas:");
        JLabel texto6 = new JLabel("Tiragem:");
        JLabel texto8 = new JLabel("Valor:");
        JLabel texto7 = new JLabel("Cometario:");
        
        
        Obrigatorio =new JLabel("*");
        Obrigatorio =new JLabel("*");
        Obrigatorio =new JLabel("*");
        

        
        JScrollPane scrollPane = new JScrollPane(comentario);
        comentario.setLineWrap(true);
        JButton voltar = new JButton();
        terminado = new JButton("Terminado");
        JButton adicionar = new JButton("Adiconar");
        JButton cancelar2 = new JButton("Cancelar");
        
        voltar.setIcon( new ImageIcon("img/voltar.png"));
        
        voltar.setBounds(5,5,45,45);
        msgInicio2.setBounds(190,50,860,80);
        texto1.setBounds(39,110,250,35);
        texto2.setBounds(39,150,250,35);
        texto3.setBounds(39,190,250,35);
        texto4.setBounds(290,190,250,35);
        texto5.setBounds(39,230,250,35);
        texto6.setBounds(330,230,250,35);
        texto7.setBounds(39,270,250,35);
        texto8.setBounds(250,270,250,35);
        img.setBounds(570,145,150,125);
        estadoConservacao.setBounds(290,110,430,35);
        
          //**Adicionando mascara ao TextField em formato de Data(try obrigatorio antes do setBounds)**//
          try{
         mascarat1 = new MaskFormatter("  ##/##/####");
         mascarat1.setPlaceholderCharacter('_');
         } 
        catch(Exception excp){} 
        dtLancamento = new JFormattedTextField(mascarat1);
        //Atualiza a data do textfield <-------------------------------
        String antiga = ""+super.getDataLancamento();
        String nova = antiga.replace("-", "");  
        if(!nova.equals("") && !nova.equals("null")){
         dtLancamento.setText(nova);
        }
        dtLancamento.setBounds(260,150,300,35);
        idioma.setBounds(120,190,160,35);
        qtdExemplares.setBounds(430,190,130,35);
        nPaginas.setBounds(240,230,80,35);
        tiragem.setBounds(430,230,130,35);
        valor.setBounds(340,270,140,35);
        scrollPane.setBounds(39,310,680,100);
        adicionar.setBounds(570,270,150,35);
        terminado.setBounds(410,420,250,35);
        cancelar2.setBounds(150,420,250,35);
        
        
        texto1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        texto2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        texto3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        texto4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        texto5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        texto6.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        texto7.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        texto8.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        estadoConservacao.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        dtLancamento.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        idioma.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        qtdExemplares.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        nPaginas.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        tiragem.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        comentario.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        msgInicio2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        img.setBorder(new javax.swing.border.TitledBorder("Imagem"));
        terminado.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        cancelar2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        adicionar.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
        valor.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        
        voltar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {  
             primeiraTela.setVisible(true);
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             segundaTela.setVisible(false); 
            }
        }
        );
          
        terminado.addActionListener(this);
        adicionar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
             JFileChooser pasta= new JFileChooser();
             caminho = "";
             File file = null;
             int retorno = pasta.showSaveDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.
             if (retorno==JFileChooser.APPROVE_OPTION){
                 caminho = pasta.getSelectedFile().getAbsolutePath();  // o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereço.
                 ImageIcon img2 = new ImageIcon (caminho);  
                 img2.setImage(img2.getImage().getScaledInstance(150,125, 100)); 
                 img.setIcon(img2);
                                    }
              
            }
        }
        );
        
         cancelar2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
             window.setVisible(false); 
             window.dispose();
            }
        }
        );
        
        cancelar2.setToolTipText(" Encerra a operação "); 
        terminado.setToolTipText(" Finaliza a operação ");
        voltar.setToolTipText(" Retornar a primeira tela ");
        UIManager.put("ToolTip.background",SystemColor.info); 
        
        
        Obrigatorio =new JLabel("*");        Obrigatorio.setBounds(30,190,160,35);        Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));        Obrigatorio.setForeground(Color.RED);        segundaTela.add(Obrigatorio);
        Obrigatorio =new JLabel("*");        Obrigatorio.setBounds(30,230,80,35);         Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));        Obrigatorio.setForeground(Color.RED);        segundaTela.add(Obrigatorio);
        Obrigatorio =new JLabel("*");        Obrigatorio.setBounds(280,190,300,35);        Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));        Obrigatorio.setForeground(Color.RED);        segundaTela.add(Obrigatorio);
        Obrigatorio =new JLabel("*");        Obrigatorio.setBounds(240,270,300,35);        Obrigatorio.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));        Obrigatorio.setForeground(Color.RED);        segundaTela.add(Obrigatorio);
        
         qtdExemplares.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Quadrinhos.this, "Informe o campo Exemplares!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         idioma.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Quadrinhos.this, "Informe o campo Idioma!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
         nPaginas.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Quadrinhos.this, "Informe o campo Número de páginas!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        valor.setInputVerifier(new InputVerifier() {public boolean verify(JComponent input) {JTextField txtNome = (JTextField) input;if (txtNome.getText().length() <= 0) {
        JOptionPane.showMessageDialog(Quadrinhos.this, "Informe o campo Valor!", "Erro de validação!", JOptionPane.ERROR_MESSAGE);return false;}return true;}});
        
        
        segundaTela.add(voltar);
        segundaTela.add(texto1);
        segundaTela.add(texto2);
        segundaTela.add(texto3);
        segundaTela.add(texto4);
        segundaTela.add(texto5);
        segundaTela.add(texto6);
        segundaTela.add(texto7);
        segundaTela.add(texto8);
        segundaTela.add(img);
        segundaTela.add(valor);
        segundaTela.add(estadoConservacao);
        segundaTela.add(dtLancamento);
        segundaTela.add(terminado);
        segundaTela.add(cancelar2);
        segundaTela.add(idioma);
        segundaTela.add(nPaginas);
        segundaTela.add(qtdExemplares);
        segundaTela.add(tiragem);
        segundaTela.add(adicionar);
        segundaTela.add(scrollPane);
        segundaTela.add(msgInicio2);
        window.add(segundaTela);
        window.setSize(800,550);
        window.setVisible(true);
        window.setDefaultCloseOperation(1);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        
        
        aba.addTab("Primeiras informações",null,primeiraTela);
        aba.addTab("Informações adicionais",null,segundaTela);
        aba.setVisible(true);
        aba.setSize(800,550);
        aba.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        window.add(aba);
        
        
        
    }
   
    
    
    public void actionPerformed(ActionEvent e){

     if(e.getSource()== terminado){
        if (nomeQuadrinho.getText().isEmpty() || nomeQuadrinho.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Nome do Quadrinho!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             segundaTela.setVisible(false);
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiraTela.setVisible(true);
        } else if (nomeAutor.getText().isEmpty() || nomeAutor.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Nome do Autor(a)!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             segundaTela.setVisible(false);
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiraTela.setVisible(true);
        }  else if (idadeLeitura.getText().isEmpty() || idadeLeitura.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Idade para a leitura!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             segundaTela.setVisible(false);
             aba.setSelectedIndex(0);
             aba.getComponentAt(0).setVisible(true);
             primeiraTela.setVisible(true);
        } 
        else if (dtLancamento.getText().isEmpty() || dtLancamento.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Data de lançamento!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             primeiraTela.setVisible(false); 
             segundaTela.setVisible(true);
        
        } else if (idioma.getText().isEmpty() || idioma.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Idioma!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             primeiraTela.setVisible(false); 
             segundaTela.setVisible(true);
        

        }else if (qtdExemplares.getText().isEmpty() || qtdExemplares.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Exemplares!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             primeiraTela.setVisible(false); 
             segundaTela.setVisible(true);
        
        } else if (valor.getText().isEmpty() || valor.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Valor!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             primeiraTela.setVisible(false); 
             segundaTela.setVisible(true);
    
        } else if (nPaginas.getText().isEmpty() || nPaginas.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,"Informe o campo Número de páginas!", "Erro de validação!",JOptionPane.ERROR_MESSAGE);
             primeiraTela.setVisible(false); 
             segundaTela.setVisible(true);
        }
       else 
       { 
            double v = Double.parseDouble(valor.getText());
            int qtd = Integer.parseInt(qtdExemplares.getText());
            int np = Integer.parseInt(nPaginas.getText());
            autor = nomeAutor.getText();
            npaginas = np;
            faixaEtaria = idadeLeitura.getText();
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try { 
                d1 = new java.sql.Date(format.parse(dtLancamento.getText()).getTime());}
             catch (ParseException x) { } 
            
            if(super.getNome() == null){
             super.setAttDados(v,nomeQuadrinho.getText(),tempoUso.getText(),idioma.getText(),qtd,caminho,estadoConservacao.getText(),tiragem.getText(),comentario.getText(),d1,serie.getText(),nomeEditora.getText());
             super.addEventoCadastrar("Quadrinhos");
             JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
            }
            else{
             super.addEventoAlterar("Quadrinhos",super.getNome(),nomeQuadrinho.getText());
             super.setAttDados(v,nomeQuadrinho.getText(),tempoUso.getText(),idioma.getText(),qtd,caminho,estadoConservacao.getText(),tiragem.getText(),comentario.getText(),d1,serie.getText(),nomeEditora.getText());
             JOptionPane.showMessageDialog(null,"Dados alterados com suceso!");
                  }
            window.setVisible(false); 
            window.dispose();
        }
     }
    }
     public String getInfo(){
     return super.getInfo()+",Número de Paginas: "+npaginas+",Faixa Etaria: "+faixaEtaria+",Autor: "+autor;
    }
    
    //metodo padrão com msm nome para alteração de dados
    public void atualizarDados(){
     nomeQuadrinho.setText(super.getNome());
     valor.setText(""+super.getValor());
     tempoUso.setText(super.getTempoUso());
     nomeAutor.setText(autor);
     nomeEditora.setText(super.getFabricante());
     serie.setText(super.getSerie());
     idadeLeitura.setText(faixaEtaria);
     estadoConservacao.setText(super.getEstadoConservacao());
     idioma.setText(super.getOrigem());
     qtdExemplares.setText(""+super.getQuantidade());
     nPaginas.setText(""+npaginas); 
     tiragem.setText(super.getTiragens()); 
     comentario.setText(super.getComentario());
     ImageIcon img2 = new ImageIcon (super.getEndrecoImg());  
     img2.setImage(img2.getImage().getScaledInstance(150,125, 100)); 
     img.setIcon(img2);
     setCadastrar();
     }
     
     //permite que a classe seja clonada
    public Object clone() {
       Object x = new Object();
       try{
           Quadrinhos c = (Quadrinhos) super.clone(); 
           x=c;
        }catch (Exception e){}
       return x;
    }  
}