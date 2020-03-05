import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
import javax.swing.text.*;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import java.lang.*;

public class Trunfo extends JFrame
{
    int comandoBotao=0;
    Grafos grafos = new Grafos();
    Cadastro cadastro = new Cadastro();    
    JButton escolhaCarro,escolhaHeroi,escolhaJogos,escolhaTime,cartaverso1,cartaverso2,continuar1;
    JLabel indice1=new JLabel("Escolha qual Super Trunfo vocÃª Deseja Jogar:");JLabel indice2=new JLabel("Encontre a carta de Ouro Para ser o Primeiro Jogador:");JLabel indice3=new JLabel("Clique na carta Para gerar sua carta:");
    JPanel painel1,painel2,painel3;
    public ButtonHandler Handler =new ButtonHandler();
    ImageIcon imgCarro,imgHeroi,imgJogos,imgTime,imgCartaverso1,imgCartaverso2,img;
    ArrayList<CarroTrunfo> listaCarro=new ArrayList<CarroTrunfo> ();
    ArrayList<TimeTrunfo> listaTime=new ArrayList<TimeTrunfo> ();
    ArrayList<HeroiTrunfo> listaHeroi=new ArrayList<HeroiTrunfo> ();
    ArrayList<JogoTrunfo> listaJogo=new ArrayList<JogoTrunfo> ();
    
    
    /** Metodo Construtor **/
    public Trunfo (){
    setTitle("Super Trunfo");
    this.setIconImage(new ImageIcon("img\\trunfologo.png").getImage());
    Container tela = getContentPane();
    painel1 = new JPanel();
    painel1.setLayout(null);
    painel2 = new JPanel();
    painel2.setLayout(null);
    painel3 = new JPanel();
    painel3.setLayout(null);
    tela.setLayout(new BorderLayout());
    
    
    /** Painel 1 **/
    indice1.setFont(new Font("Times New Roman",Font.BOLD,32));
    indice1.setForeground(Color.BLUE);
    indice1.setBounds(80,5,700,150);
    indice1.setVisible(true);
    indice1.setFocusable(true);
    painel1.add(indice1);
    
    
    escolhaCarro=new JButton();                                 escolhaHeroi=new JButton();                                escolhaJogos=new JButton();                           escolhaTime=new JButton();     
    escolhaCarro.setBounds(150,150,150,150);                    escolhaHeroi.setBounds(500,150,150,150);                    escolhaJogos.setBounds(150,350,150,150);              escolhaTime.setBounds(500,350,150,150);  
    escolhaCarro.addActionListener(Handler);                    escolhaHeroi.addActionListener(Handler);                   escolhaJogos.addActionListener(Handler);              escolhaTime.addActionListener(Handler);   
    
    //Atribuindo imagens aos botoes e adicionando - os ao painel
    imgCarro= new ImageIcon ("img\\trunfocarro.png");                           imgHeroi= new ImageIcon ("img\\trunfoheroes.png");                          imgJogos= new ImageIcon ("img\\trunfojogos.png");                        imgTime= new ImageIcon ("img\\trunfotimes.png"); 
    imgCarro.setImage(imgCarro.getImage().getScaledInstance(150,150,100));      imgHeroi.setImage(imgHeroi.getImage().getScaledInstance(150,150,100));      imgJogos.setImage(imgJogos.getImage().getScaledInstance(150,150,100));   imgTime.setImage(imgTime.getImage().getScaledInstance(150,150,100));
    escolhaCarro.setIcon(imgCarro);                                             escolhaHeroi.setIcon(imgHeroi);                                             escolhaJogos.setIcon(imgJogos);                                          escolhaTime.setIcon(imgTime);
    escolhaCarro.setFocusable(true);                                            escolhaHeroi.setFocusable(true);                                            escolhaJogos.setFocusable(true);                                         escolhaTime.setFocusable(true);   
    escolhaCarro.setVisible(true);                                              escolhaHeroi.setVisible(true);                                              escolhaJogos.setVisible(true);                                           escolhaTime.setVisible(true);
    painel1.add(escolhaCarro);                                                  painel1.add(escolhaHeroi);                                                  painel1.add(escolhaJogos);                                               painel1.add(escolhaTime);                                                       
    
    painel1.setVisible(true);
    painel1.setFocusable(true);
    painel1.setSize(800,600);
    tela.add(BorderLayout.CENTER, painel1);
    
    /** Painel 2 **/
    indice3.setFont(new Font("Times New Roman",Font.BOLD,28));
    indice3.setForeground(Color.BLUE);
    indice3.setBounds(180,10,700,50);
    indice3.setVisible(true);
    indice3.setFocusable(true);
    painel2.add(indice3);    
    
    
    
    painel2.setVisible(false);    
    painel2.setSize(800,600);
    tela.add(BorderLayout.CENTER, painel2);
    
    
    /** Painel 3 **/
    
    indice2.setFont(new Font("Times New Roman",Font.BOLD,28));
    indice2.setForeground(Color.BLUE);
    indice2.setBounds(80,0,700,50);
    indice2.setVisible(true);
    indice2.setFocusable(true);
    painel3.add(indice2);
    painel3.setVisible(false);
    painel3.setFocusable(false);
    painel3.setSize(800,600);
    
    tela.add(BorderLayout.CENTER, painel3);
    
    cartaverso1=new JButton();                                 cartaverso2=new JButton();                  continuar1 = new JButton("Continuar"); continuar1.setVisible(true);
    cartaverso1.setBounds(50,90,300,450);                      cartaverso2.setBounds(450,90,300,450);      painel3.add(continuar1);
    cartaverso1.addActionListener(Handler);                    cartaverso2.addActionListener(Handler);     continuar1.addActionListener(Handler);
    
    imgCartaverso1=new ImageIcon ("Trunfo\\SuperTrunfoVerso.png");                       imgCartaverso2=new ImageIcon ("Trunfo\\SuperTrunfoVerso.png");   
    imgCartaverso1.setImage(imgCartaverso1.getImage().getScaledInstance(300,470,100));   imgCartaverso2.setImage(imgCartaverso2.getImage().getScaledInstance(300,470,100));
    cartaverso1.setIcon(imgCartaverso1);                                                 cartaverso2.setIcon(imgCartaverso2);
    painel3.add(cartaverso1);                                                            painel3.add(cartaverso2);
                                                                                                    
    //difiniÃ§Ãµes da tela
        this.setVisible(true);
        this.setSize(800,600);
        this.setDefaultCloseOperation(1);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.repaint();
      }
    
    
    /** Metodo geraTrunfo **///Metodo que Le o arquivo e preenche dados em uma lista de objeto especifica
    public void geraTrunfo(String TipoTrunfo){
       try{

          FileReader  file = new FileReader("Trunfo/"+TipoTrunfo+"/Map.txt");
          Scanner in = new Scanner (file);         
          
           while (in.hasNext()) {
             
             
             String aux = in.nextLine();
             String temp [] = aux.split(" - ");
             
             if(TipoTrunfo=="Carro"){             
             listaCarro.add(new CarroTrunfo(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]));}
             
             if(TipoTrunfo=="Time"){             
             listaTime.add(new TimeTrunfo(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]));}
             
             if(TipoTrunfo=="Heroi") {             
             listaHeroi.add(new HeroiTrunfo(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]));}
             
             if(TipoTrunfo=="Jogo"){
             listaJogo.add(new JogoTrunfo(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]));}
             
                             }
             
           
             
          
        }catch (Exception e){}
     }
    
     
     /** metodo Atributos **/
     
     
     public void atributos (String nome,String id,String nacional,String atributo1,final String atributo2,final String atributo3,final String atributo4,final String atributo5,final String TipoTrunfo){
        JLabel nomeCarta=new JLabel(nome);  JLabel nacionalidade=new JLabel(); final  JLabel att1=new JLabel(atributo1,SwingConstants.RIGHT);
        final JLabel att2=new JLabel(atributo2,SwingConstants.RIGHT);final JLabel att3=new JLabel(atributo3,SwingConstants.RIGHT);final JLabel att4=new JLabel(atributo4,SwingConstants.RIGHT);
        final JLabel att5=new JLabel(atributo5,SwingConstants.RIGHT);  JLabel IDcarta=new JLabel();
        JLabel carta; JLabel indicebotaoAtt=new JLabel("Atributos:");
        final JLabel indicaAtt1=new JLabel();final JLabel indicaAtt2=new JLabel();final JLabel indicaAtt3=new JLabel();final JLabel indicaAtt4=new JLabel();final JLabel indicaAtt5=new JLabel();
        indice3.setText("Escolha Um Atributo Para Desafiar seu Amigo:");
        indice3.setBounds(120,5,700,50);
        final JButton Batributo1=new JButton();final JButton Batributo2=new JButton();final JButton Batributo3=new JButton();
        final JButton Batributo4=new JButton();final JButton Batributo5=new JButton();final JButton Desafiar=new JButton("Desafiar");        
        ImageIcon imgCarta=new ImageIcon("Trunfo/"+TipoTrunfo+"/img/"+id+".jpg");  ImageIcon imgNacional=new ImageIcon("Trunfo/"+TipoTrunfo+"/img/"+nacional+".png");
        imgCarta.setImage(imgCarta.getImage().getScaledInstance(260,210,100));     imgNacional.setImage(imgNacional.getImage().getScaledInstance(35,35,100)); 
        IDcarta.setIcon(imgCarta);                                                    nacionalidade.setIcon(imgNacional);
        Desafiar.setVisible(false);
        
        att1.setFont(new Font("Arial",Font.PLAIN,16));att2.setFont(new Font("Arial",Font.PLAIN,16));att3.setFont(new Font("Arial",Font.PLAIN,16));att4.setFont(new Font("Arial",Font.PLAIN,16));att5.setFont(new Font("Arial",Font.PLAIN,16));
        att1.setBounds(262,350,260,18);att2.setBounds(262,386,260,18);att3.setBounds(262,422,260,18);att4.setBounds(262,460,260,18);att5.setBounds(262,498,260,18);
        att1.setForeground(Color.WHITE);att2.setForeground(Color.WHITE);att3.setForeground(Color.WHITE);att4.setForeground(Color.WHITE);att5.setForeground(Color.WHITE);
        nomeCarta.setForeground(Color.WHITE);
        
        indicaAtt1.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt2.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt3.setFont(new Font("Arial",Font.PLAIN,16));
        indicaAtt4.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt5.setFont(new Font("Arial",Font.PLAIN,16));
        indicaAtt1.setBounds(270,350,260,18);indicaAtt2.setBounds(270,386,260,18);indicaAtt3.setBounds(270,422,260,18);indicaAtt4.setBounds(270,460,260,18);
        indicaAtt5.setBounds(270,498,260,18);
        indicaAtt1.setForeground(Color.WHITE);indicaAtt2.setForeground(Color.WHITE);indicaAtt3.setForeground(Color.WHITE);indicaAtt4.setForeground(Color.WHITE);
        indicaAtt5.setForeground(Color.WHITE);
        indicebotaoAtt.setFont(new Font("Times New Roman",Font.BOLD,28));
        
        indicebotaoAtt.setForeground(Color.BLUE);
        indicebotaoAtt.setBounds(60,200,300,50);;        
        painel2.add(indicebotaoAtt);

        
        /** definiçao das cartas **/ //se sera ouro, prata ou padrao
        if(Integer.parseInt(id)<5){
        carta=new JLabel(new ImageIcon("Trunfo/SuperTrunfoOuro.png"));
        nomeCarta.setForeground(Color.BLACK); att1.setForeground(Color.BLACK);att2.setForeground(Color.BLACK);att3.setForeground(Color.BLACK);att4.setForeground(Color.BLACK);att5.setForeground(Color.BLACK);
        indicaAtt1.setForeground(Color.BLACK);indicaAtt2.setForeground(Color.BLACK);indicaAtt3.setForeground(Color.BLACK);indicaAtt4.setForeground(Color.BLACK);indicaAtt5.setForeground(Color.BLACK);
        }
        else if(Integer.parseInt(id)>4 && Integer.parseInt(id)<=10){
        carta=new JLabel(new ImageIcon("Trunfo/SuperTrunfoPrata.png"));
        nomeCarta.setForeground(Color.BLACK); att1.setForeground(Color.BLACK);att2.setForeground(Color.BLACK);att3.setForeground(Color.BLACK);att4.setForeground(Color.BLACK);att5.setForeground(Color.BLACK);
        indicaAtt1.setForeground(Color.BLACK);indicaAtt2.setForeground(Color.BLACK);indicaAtt3.setForeground(Color.BLACK);indicaAtt4.setForeground(Color.BLACK);indicaAtt5.setForeground(Color.BLACK);
        }
        else{
        carta=new JLabel(new ImageIcon("Trunfo/SuperTrunfo"+TipoTrunfo+".png"));
        }        
        
        
        if(TipoTrunfo=="Carro"){
            indicaAtt1.setText("Cilindrada"); indicaAtt2.setText("Potencia"); indicaAtt3.setText("PreÃ§o"); indicaAtt4.setText("Vel. maxima"); indicaAtt5.setText("Arranque");
            Batributo1.setText("Cilindrada"); Batributo2.setText("Potencia"); Batributo3.setText("PreÃ§o"); Batributo4.setText("Vel. maxima"); Batributo5.setText("Arranque");
        }
        if(TipoTrunfo=="Time"){
            indicaAtt1.setText("Preço"); indicaAtt2.setText("Titulo Internacional"); indicaAtt3.setText("Titulo Nacional"); indicaAtt4.setText("Entrosamento"); indicaAtt5.setText("Idade Media");
            Batributo1.setText("Preço"); Batributo2.setText("Titulo Internacional"); Batributo3.setText("Titulo Nacional"); Batributo4.setText("Entrosamento"); Batributo5.setText("Idade Media");
        }
        if(TipoTrunfo=="Heroi"){
            indicaAtt1.setText("Forca"); indicaAtt2.setText("Velocidade"); indicaAtt3.setText("Habilidade"); indicaAtt4.setText("Equipamento"); indicaAtt5.setText("Inteligencia");
            Batributo1.setText("Forca"); Batributo2.setText("Velocidade"); Batributo3.setText("Habilidade"); Batributo4.setText("Equipamento"); Batributo5.setText("Inteligencia");
         }
        if(TipoTrunfo=="Jogo"){
            indicaAtt1.setText("Força"); indicaAtt2.setText("Popularidade"); indicaAtt3.setText("Poder"); indicaAtt4.setText("Agilidade"); indicaAtt5.setText("Carisma");
            Batributo1.setText("Força"); Batributo2.setText("Popularidade"); Batributo3.setText("Poder"); Batributo4.setText("Agilidade"); Batributo5.setText("Carisma");
        }  
       
       
       
            /** Botoes Atributos **/            
        Batributo1.setBounds(40,250,160,30);Batributo1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,14));  Batributo1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg01) {
            indicaAtt1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));indicaAtt2.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt3.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt4.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt5.setFont(new Font("Arial",Font.PLAIN,16));
            Batributo1.setSelected(true);Batributo2.setSelected(true);Batributo3.setSelected(true);Batributo4.setSelected(true);Batributo5.setSelected(true);
            Desafiar.setVisible(true);att1.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));att2.setFont(new Font("Arial",Font.PLAIN,16));att3.setFont(new Font("Arial",Font.PLAIN,16));att4.setFont(new Font("Arial",Font.PLAIN,16));att5.setFont(new Font("Arial",Font.PLAIN,16));
            comandoBotao=1;
        }});
        Batributo2.setBounds(40,300,160,30);Batributo2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,14));  Batributo2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg01) {
            indicaAtt1.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));indicaAtt3.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt4.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt5.setFont(new Font("Arial",Font.PLAIN,16));
            Desafiar.setVisible(true);att1.setFont(new Font("Arial",Font.PLAIN,16));att2.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));att3.setFont(new Font("Arial",Font.PLAIN,16));att4.setFont(new Font("Arial",Font.PLAIN,16));att5.setFont(new Font("Arial",Font.PLAIN,16));
            Batributo1.setSelected(true);Batributo2.setSelected(true);Batributo3.setSelected(true);Batributo4.setSelected(true);Batributo5.setSelected(true);
            comandoBotao=2;
        }});
        Batributo3.setBounds(40,350,160,30);Batributo3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,14));  Batributo3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg01) {
            indicaAtt1.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt2.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));indicaAtt4.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt5.setFont(new Font("Arial",Font.PLAIN,16));
            Desafiar.setVisible(true);att1.setFont(new Font("Arial",Font.PLAIN,16));att2.setFont(new Font("Arial",Font.PLAIN,16));att3.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));att4.setFont(new Font("Arial",Font.PLAIN,16));att5.setFont(new Font("Arial",Font.PLAIN,16));
            Batributo1.setSelected(true);Batributo2.setSelected(true);Batributo3.setSelected(true);Batributo4.setSelected(true);Batributo5.setSelected(true);
            comandoBotao=3;
        }});
        Batributo4.setBounds(40,400,160,30);Batributo4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,14));  Batributo4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg01) {
            indicaAtt1.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt2.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt3.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));indicaAtt5.setFont(new Font("Arial",Font.PLAIN,16));
            Desafiar.setVisible(true);att1.setFont(new Font("Arial",Font.PLAIN,16));att2.setFont(new Font("Arial",Font.PLAIN,16));att3.setFont(new Font("Arial",Font.PLAIN,16));att4.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));att5.setFont(new Font("Arial",Font.PLAIN,16));
            Batributo1.setSelected(true);Batributo2.setSelected(true);Batributo3.setSelected(true);Batributo4.setSelected(true);Batributo5.setSelected(true);
            comandoBotao=4;
        }});
        Batributo5.setBounds(40,450,160,30);Batributo5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,14));  Batributo5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg01) {
            indicaAtt1.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt2.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt3.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt4.setFont(new Font("Arial",Font.PLAIN,16));indicaAtt5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));
            Desafiar.setVisible(true);att1.setFont(new Font("Arial",Font.PLAIN,16));att2.setFont(new Font("Arial",Font.PLAIN,16));att3.setFont(new Font("Arial",Font.PLAIN,16));att4.setFont(new Font("Arial",Font.PLAIN,16));att5.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,16));
            Batributo1.setSelected(true);Batributo2.setSelected(true);Batributo3.setSelected(true);Batributo4.setSelected(true);Batributo5.setSelected(true);
            comandoBotao=5;
        }});
        
         /** Botoes Desafiar **/
          
             Desafiar.setBounds(620,535,160,30); Desafiar.setFont(new Font("Arial",Font.BOLD + Font.PLAIN,14));  
             Desafiar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0) 
            {
                if(comandoBotao==1){
                 comparaAtt(indicaAtt1.getText(),att1.getText());System.out.println("funfo");
                 JOptionPane.showMessageDialog(null,"Desafio do atributo '"+att1.getText()+"' enviado! Aguarde seu Amigo!","Enviado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(comandoBotao==2){
                 comparaAtt(indicaAtt2.getText(),att2.getText());
                 JOptionPane.showMessageDialog(null,"Desafio do atributo '"+atributo2+"' enviado! Aguarde seu Amigo!","Enviado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(comandoBotao==3){
                 comparaAtt(indicaAtt3.getText(),att3.getText());
                 JOptionPane.showMessageDialog(null,"Desafio do atributo '"+atributo3+"' enviado! Aguarde seu Amigo!","Enviado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(comandoBotao==4){
                 comparaAtt(indicaAtt4.getText(),att4.getText());
                 JOptionPane.showMessageDialog(null,"Desafio do atributo '"+atributo4+"' enviado! Aguarde seu Amigo!","Enviado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(comandoBotao==5){
                 comparaAtt(indicaAtt5.getText(),att5.getText());
                 JOptionPane.showMessageDialog(null,"Desafio do atributo '"+atributo5+"' enviado! Aguarde seu Amigo!","Enviado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                JOptionPane.showMessageDialog(null,"Você não selecionou nenhum atributo","Erro",JOptionPane.ERROR_MESSAGE);
               }
                
            }});
            
            
        
        /** Adicionando Atributos ao Painel **/
        carta.setBounds(250,60,300,500);
        IDcarta.setBounds(270,130,260,210);
        nacionalidade.setBounds(505,92,35,35);
        nomeCarta.setBounds(265,100,250,20);  nomeCarta.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 18));
        painel2.add(IDcarta); painel2.add(nacionalidade); painel2.add(nomeCarta);        
        painel2.add(Batributo1); painel2.add(Batributo2); painel2.add(Batributo3); painel2.add(Batributo4); painel2.add(Batributo5);painel2.add(Desafiar);
        painel2.add(att1);painel2.add(att2);painel2.add(att3);painel2.add(att4);painel2.add(att5);
        painel2.add(indicaAtt1);painel2.add(indicaAtt2);painel2.add(indicaAtt3);painel2.add(indicaAtt4);painel2.add(indicaAtt5);painel2.add(carta);
        
        carta.setFocusable(false);
        att1.setFocusable(true);att2.setFocusable(true);att3.setFocusable(true);att4.setFocusable(true);att5.setFocusable(true);
        nomeCarta.setFocusable(true);
        nacionalidade.setFocusable(true);
        IDcarta.setFocusable(true);        
        painel2.repaint();
    }
    
    public void comparaAtt(String indice,String att){
    
    }
    
    
    /** Classe ButtonHandler **///classe extra q da atividade aos botoes do painel1
      public class ButtonHandler extends JFrame implements ActionListener {
      JButton cartaverso3;
        public void actionPerformed(ActionEvent event){
            Random random=new Random();
       
          if (event.getSource() == escolhaCarro){infoTrunfo("Carro");}        
          if (event.getSource() == escolhaHeroi){infoTrunfo("Heroi");}
          if (event.getSource() == escolhaJogos){infoTrunfo("Jogo");}
          if (event.getSource() == escolhaTime){infoTrunfo("Time");}
       
          if (event.getSource() == cartaverso1){cartaverso1.setEnabled(false);cartaverso2.setVisible(false);random.nextBoolean();         
              if(random.nextBoolean()==true){
            imgCartaverso1=new ImageIcon("Trunfo\\trunfo1.png");
            imgCartaverso1.setImage(imgCartaverso1.getImage().getScaledInstance(300,470,100));            
            cartaverso1.setDisabledIcon(imgCartaverso1);            
            cartaverso1.setBounds(250,90,300,450);                  
            indice2.setText("Voce encontrou a carta Ouro, Voce comeÃ§a jogando!");
            continuar1.setBounds(685,535,100,30);continuar1.setVisible(true);continuar1.setFocusable(true);
            
                }
                else{
            imgCartaverso1=new ImageIcon(getClass().getResource("Trunfo/trunfo2.png"));
            imgCartaverso1.setImage(imgCartaverso1.getImage().getScaledInstance(300,470,100));            
            cartaverso1.setDisabledIcon(imgCartaverso1);            
            cartaverso1.setBounds(250,90,300,450);
            indice2.setBounds(20,5,800,50);
            indice2.setText("Voce encontrou a carta Prata,seu Adversario comeÃ§a jogando!");
            continuar1.setBounds(685,535,100,30);continuar1.setVisible(true);continuar1.setFocusable(true);  
                }
            }
                
            if (event.getSource() == cartaverso2){cartaverso2.setEnabled(false); ;cartaverso1.setVisible(false); random.nextBoolean();         
              
                    if(random.nextBoolean()==true){
                        imgCartaverso2=new ImageIcon("Trunfo\\trunfo1.png");
                        imgCartaverso2.setImage(imgCartaverso2.getImage().getScaledInstance(300,470,100));           
                        cartaverso2.setDisabledIcon(imgCartaverso2);            
                        cartaverso2.setBounds(250,90,300,450);
                        indice2.setText("Voce encontrou a carta Ouro, Voce comeÃ§a jogando!");
                        continuar1.setBounds(685,535,100,30);continuar1.setVisible(true);continuar1.setFocusable(true);
                        painel3.setVisible(false);painel1.setVisible(true);     
                 }
            else{
                imgCartaverso2=new ImageIcon("Trunfo\\trunfo2.png");
                imgCartaverso2.setImage(imgCartaverso2.getImage().getScaledInstance(300,470,100));            
                cartaverso2.setDisabledIcon(imgCartaverso2);            
                cartaverso2.setBounds(250,90,300,450);            
                indice2.setBounds(20,5,800,50);
                indice2.setText("Voce encontrou a carta Prata, seu Adversario comeÃ§a jogando!");continuar1.setVisible(true); continuar1.setFocusable(true);continuar1.setBounds(685,535,100,30);
                painel3.setVisible(false);painel1.setVisible(true);          
            }}
        
           
       }
       
       /** Mtodo JanelaExtra **///este metodo gera Janelas indendicas para ambos trunfos
       private void JanelaExtra(){        
         JButton ok,cancelar;
         final JFrame telaAmigos;
         final JComboBox caixaAmigos=new JComboBox ();
          telaAmigos=new JFrame();          
          telaAmigos.setLayout(null);
         ok =new JButton("OK"); cancelar=new JButton("Cancelar");
         JLabel tituloAmigos=new JLabel("Escolha um Amigo para ser seu Adversario: ");
         telaAmigos.setVisible(false);                 
         
         caixaAmigos.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 16));
         
         /** funçao que resgata seus amigos **/
         for(int i = 0 ; i < grafos.todosAmigos(cadastro.getIndice()).size(); i++){            
            caixaAmigos.addItem(cadastro.getNomeUsuario(grafos.todosAmigos(cadastro.getIndice()).get(i)).toString());            
            } 
         
         if(caixaAmigos.getItemCount() == 0 ){caixaAmigos.addItem("vazio");}     
                  
         tituloAmigos.setBounds(40,10,400,20);
         ok.setBounds(60,230,100,30);
         cancelar.setBounds(240,230,100,30);
         tituloAmigos.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 16));tituloAmigos.setForeground(Color.BLUE);         
         caixaAmigos.setBounds(60,110,280,35);         
         telaAmigos.add(caixaAmigos);
         telaAmigos.add(tituloAmigos);telaAmigos.add(ok);telaAmigos.add(cancelar);
         telaAmigos.setVisible(true);
         telaAmigos.setSize(400,300);
         telaAmigos.setDefaultCloseOperation(1);
         telaAmigos.setLocationRelativeTo(null);
         telaAmigos.setResizable(false); 
         
          ok.addActionListener(new ActionListener()
          {public void actionPerformed(ActionEvent arg0) {
            if(caixaAmigos.getSelectedItem().toString()== "vazio"){
            JOptionPane.showMessageDialog(null,"VocÃª nÃ£o tem nenhum amigo!!!","Erro",JOptionPane.ERROR_MESSAGE);
            telaAmigos.setVisible(false);painel1.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Desafio para seu amigo "+caixaAmigos.getSelectedItem().toString()+" foi enviado!","Enviado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
                telaAmigos.setVisible(false);painel1.setVisible(false);painel2.setVisible(true);         
                                                                                                    }}});
        
         cancelar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0) {
         telaAmigos.setVisible(false);painel1.setVisible(true);painel2.setVisible(false);}});
      }
      
      
      /** Metodo infoTrunfo **///pega informaçoes das cartas geradas e atribue para outro metodo
      public void infoTrunfo(final String TipoTrunfo){
        JanelaExtra();       
            cartaverso3=new JButton();                            
            cartaverso3.setBounds(250,90,300,450);
            ImageIcon imgCartaverso3=new ImageIcon ("Trunfo\\SuperTrunfoVerso.png");               
            imgCartaverso3.setImage(imgCartaverso3.getImage().getScaledInstance(300,470,100));  
            cartaverso3.setIcon(imgCartaverso3);                                                 
            painel2.add(cartaverso3);
            
            /** Botao que Gera a carta **/ //esse passa parametros para o metodo atributo
            
             cartaverso3.addActionListener(new ActionListener()
           {  public void actionPerformed(ActionEvent arg0) {
                 Random random = new Random();
                 int nAleatorio = random.nextInt(31);              
                geraTrunfo(TipoTrunfo);
                  if(TipoTrunfo=="Carro"){
                   atributos(listaCarro.get(nAleatorio).getNome(),listaCarro.get(nAleatorio).getNumeroID(),listaCarro.get(nAleatorio).getNacionalidade(),listaCarro.get(nAleatorio).getCilindrada(),
                   listaCarro.get(nAleatorio).getForca(),listaCarro.get(nAleatorio).getPreco(),listaCarro.get(nAleatorio).getVelMax(),listaCarro.get(nAleatorio).getMetro(),TipoTrunfo);
                   painel2.remove(cartaverso3);
                   painel2.repaint();
                }
                  if(TipoTrunfo=="Time"){
                  atributos(listaTime.get(nAleatorio).getNome(),listaTime.get(nAleatorio).getNumeroID(),listaTime.get(nAleatorio).getNacionalidade(),listaTime.get(nAleatorio).getPreco(),listaTime.get(nAleatorio).getTituloInt(),
                  listaTime.get(nAleatorio).getTituloNac(),listaTime.get(nAleatorio).getIntrosamento(),listaTime.get(nAleatorio).getMediaIdade(),TipoTrunfo);
                  painel2.remove(cartaverso3);
                  painel2.repaint();
                }
                  if(TipoTrunfo=="Heroi"){
                  atributos(listaHeroi.get(nAleatorio).getNome(),listaHeroi.get(nAleatorio).getNumeroID(),listaHeroi.get(nAleatorio).getEditora(),listaHeroi.get(nAleatorio).getForca(),
                  listaHeroi.get(nAleatorio).getVelocidade(),listaHeroi.get(nAleatorio).getHabilidade(),listaHeroi.get(nAleatorio).getEquipamento(),listaHeroi.get(nAleatorio).getIteligencia(),TipoTrunfo);
                  painel2.remove(cartaverso3);
                  painel2.repaint();
                }
                  if(TipoTrunfo=="Jogo"){
                   atributos(listaJogo.get(nAleatorio).getNome(),listaJogo.get(nAleatorio).getNumeroID(),listaJogo.get(nAleatorio).getPlataforma(),listaJogo.get(nAleatorio).getForca(),
                  listaJogo.get(nAleatorio).getPopularidade(),listaJogo.get(nAleatorio).getPoder(),listaJogo.get(nAleatorio).getAgilidade(),listaJogo.get(nAleatorio).getCarisma(),TipoTrunfo);
                  painel2.remove(cartaverso3);
                  painel2.repaint();
                }
                           }});
        }
    
    }
}

