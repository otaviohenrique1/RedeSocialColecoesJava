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
import javax.swing.ActionMap;  
import javax.swing.InputMap;  
import javax.swing.AbstractAction;  

public class RedeSocial extends JFrame
{
   
    /** Instancias */
    Cadastro cadastro = new Cadastro();
    Usuario y = cadastro.getUsuario();
    Grafos grafos = new Grafos();
    Container tela = getContentPane();
    
     RedeSocial(){
         y.setIndice(cadastro.getIndice());
         areaInicial();
              }
   
    
    /** ------------------------------- Variaveis Area Inicial ---------------------- */
    JLabel lb_bemVindo;
    
    JButton bt_Foto, bt_PaginaInicial, bt_colecao, bt_sair, bt_amigos, bt_comunidade, bt_eventos, bt_jogos, bt_leilao, bt_trocas, bt_meuHistorico, bt_perfil, bt_Configurar,
    bt_att_batpapo, bt_solitacoes;
    
    JPanel painel_amigos_att, painel_new_amigo, painel_conversa,painel_naoLidas, painel_geral;
    
    JScrollPane scroll_new_amigos;
    
    JScrollPane scroll_Geral;
   
    /** --------------------- variaveis de controle ---------------------- */
     JLabel alterarImg = new JLabel("<html>Clique aqui para <br> alterar a Imagem</html>");
     boolean aparece = true,aparece2 = true; //contrla paineis interativos
     int controleConversa = 0;
    /**----------------------------------------- Fontes -----------------------------------------*/
    
    Font fonte2 = new Font("Arial",Font.BOLD + Font.PLAIN, 18);
    Font fonteT1 = new Font("Arial",Font.BOLD + Font.PLAIN, 16);
    /** ------------------------------ Metodo para a telaInicial --------------- */
    public void areaInicial(){
       setTitle("Colecionadores");
       
       setLayout(null);        
       this.setIconImage(new ImageIcon("img\\minilogo.png").getImage());
       
       painel_geral = new JPanel();
       
       //painel interativo de solicitações
       painel_new_amigo = new JPanel();
       painel_new_amigo.setVisible(false);
       tela.add(painel_new_amigo);
       
       //painel interativo de conversas não lidas
       painel_naoLidas = new JPanel();
       painel_naoLidas.setVisible(false);
       tela.add(painel_naoLidas);
       
       //-----bt_Foto usuario-----      
       bt_Foto = new JButton();
       ImageIcon img = new ImageIcon (y.getEndFoto());  
       img.setImage(img.getImage().getScaledInstance(200,200, 100)); 
       bt_Foto.setIcon(img);
       bt_Foto.setBounds(10,10,200,200);
       bt_Foto.setBorder(new javax.swing.border.TitledBorder(""));
       
       //JLabel interativa que aparece ao pasar o mause em cima da foto
        alterarImg.setFont(new Font("Times New Roman",Font.BOLD,20));
        alterarImg.setForeground(Color.ORANGE);
        alterarImg.setBounds(40,20,180,200);
        alterarImg.setVisible(false);
        tela.add(alterarImg);
        //Mouse listener que implemeta o JLabel quano o maus passa em cima da foto
        bt_Foto.addMouseListener(new MouseAdapter() { @Override 
        public void mouseEntered(MouseEvent e){
         alterarImg.setVisible(true);
         alterarImg.setFocusable(true);
        }
        public void mouseExited(MouseEvent e){alterarImg.setVisible(false);
          alterarImg.setFocusable(false);}
        });
       
        //botão destinado a atualizar a foto do usuario
       bt_Foto.addActionListener(new ActionListener()
       {public void actionPerformed(ActionEvent arg0) {
             JFileChooser pasta= new JFileChooser();
             String caminho = ""; File file = null; int retorno = pasta.showSaveDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser ser� para salvar.
                if (retorno==JFileChooser.APPROVE_OPTION){
                 caminho = pasta.getSelectedFile().getAbsolutePath(); // o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endere�o.
                 ImageIcon img2 = new ImageIcon (caminho);  
                 img2.setImage(img2.getImage().getScaledInstance(200,200, 100)); 
                 bt_Foto.setIcon(img2);
                 y.setEndFoto(caminho);
             }}});tela.add(bt_Foto);
       
       //scrolPane geral iniciado na tela de atualizações de usuarios
       scroll_Geral = new JScrollPane();
       scroll_Geral = new PainelHistorico(y,1).getScrollPaneHistorico();  
       tela.add(scroll_Geral);
             
       
       //-----Mensagem de entrada usuario-----
       lb_bemVindo = new JLabel("Bem Vindo "+y.getNome(),JLabel.CENTER);
       lb_bemVindo.setBounds(220,10,400,30);
       lb_bemVindo.setBorder(new javax.swing.border.TitledBorder(""));
       lb_bemVindo.setFont(new Font("Arial",Font.BOLD + Font.PLAIN, 20));
       tela.add(lb_bemVindo);
       
       //botão que leva a tela inicial
       bt_PaginaInicial= new JButton("Inicio");
       bt_PaginaInicial.setBounds(785,10,105,30);
       bt_PaginaInicial.setFont(fonte2);
       tela.add(bt_PaginaInicial);
       bt_PaginaInicial.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                goInicio();
            }
        });
        
       //-----Botão para acesar coleçoes ja cadastradas implementar mais pra frente-----
       bt_colecao = new JButton("Sua Coleçâo");
       bt_colecao.setBounds(630,10,150,30);
       bt_colecao.setFont(fonte2);
       tela.add(bt_colecao);
       bt_colecao.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                 goColecao();
            }
        });
          
       //-----Botão Que mostra os amigos não aceitos-----
       bt_solitacoes = new JButton("");
       bt_solitacoes.setIcon(new ImageIcon("img/amigo1.png"));
       bt_solitacoes.setText(""+grafos.getNumeroDesolicitacao(cadastro.getIndice()));
       bt_solitacoes.setFont(fonteT1);
       bt_solitacoes.setBounds(895,10,70,30);
       bt_solitacoes.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                if(aparece){
                    limpaPaineisInterativos();
                    colocaPainel();aparece = !aparece;}
                else{aparece = !aparece; limpaPaineisInterativos();}
            }
        }); tela.add(bt_solitacoes);
       
       //-----Botão Que mostra as atualizações não lidas do bat papo-----
       bt_att_batpapo = new JButton("");
       bt_att_batpapo.setIcon(new ImageIcon("img/balao.gif"));
       bt_att_batpapo.setText(""+grafos.getNumeroConversaNaoLidas(cadastro.getIndice())); 
       bt_att_batpapo.setFont(fonteT1);
       bt_att_batpapo.setBounds(970,10,70,30);
       bt_att_batpapo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
              if(aparece2){
               limpaPaineisInterativos();
               colocaPainel_naolido();aparece2 = !aparece2;}
              else{aparece2 = !aparece2; limpaPaineisInterativos();}
              grafos.agoraVi(cadastro.getIndice());
              bt_att_batpapo.setText(""+grafos.getNumeroConversaNaoLidas(cadastro.getIndice()));
            }
        });tela.add(bt_att_batpapo);
       
       //-----Botão sair-----
       bt_sair = new JButton();
       bt_sair.setBounds(1045,10,30,30);
       bt_sair.setIcon(new ImageIcon("img/off.png"));
       tela.add(bt_sair);
       bt_sair.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                boolean text = new PainelConfiguracao().getGuarda();
                if(text){
                    y.zeraRedu();
                    y.zeraUndo();
                    y.setGuardaUndo(false);
                      }
                 else{y.setGuardaUndo(true);}     
                 
                cadastro.deslogar();
                setVisible(false);
                dispose();
            }
        });
       
       //-----painel amigos e atualizaçoes-----
       painel_amigos_att = new JPanel();
       painel_amigos_att.setBorder(new javax.swing.border.TitledBorder(""));
       painel_amigos_att.setVisible(true);
       painel_amigos_att.setLayout(null);
       painel_amigos_att.setBounds(875,50,200,350);
       tela.add(painel_amigos_att);
       preencheAmigosLateral();//coloca amigos adicionados a tela
       
       //painel destinado a guardar a conversa de usuarios
       painel_conversa = new JPanel();
       painel_conversa.setBorder(new javax.swing.border.TitledBorder(""));
       painel_conversa.setVisible(true);
       painel_conversa.setLayout(null);
       painel_conversa.setBounds(875,405,200,205);
       tela.add(painel_conversa);
       
       //JLabel informativo
       JLabel lb_clique = new JLabel("<html><Center>Clique em Falar<br>para iniciar o<br>bate papo",JLabel.CENTER);
       lb_clique.setFont(new Font("Times New Roman",Font.BOLD,25));
       lb_clique.setForeground(Color.BLUE);
       lb_clique.setBounds(0,0,200,205);
       painel_conversa.add(lb_clique);
       
       //botão que leva ao perfil
       bt_perfil = new JButton("Meu Perfil");
       bt_perfil.setFont(fonte2);
       bt_perfil.setBounds(10,220,200,30);
       tela.add(bt_perfil);
       bt_perfil.addActionListener(
       new ActionListener() {public void actionPerformed(ActionEvent arg0){
         goPerfil(cadastro.getIndice(),0);
       }});
       
       
       //------ botão Meu historico -----------
       bt_meuHistorico = new JButton("Meu Historico");
       bt_meuHistorico.setFont(fonte2);
       bt_meuHistorico.setBounds(10,260,200,30);
       tela.add(bt_meuHistorico);
       bt_meuHistorico.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent arg0) {goHistorico();}});
       
       //------ botão de trocas -------
       bt_trocas = new JButton("Trocas");
       bt_trocas.setFont(fonte2);
       bt_trocas.setBounds(10,300,200,30);
       tela.add(bt_trocas);
       
       //-----Botao Amigos------
       bt_amigos = new JButton("Amigos");
       bt_amigos.setFont(fonte2);
       bt_amigos.setBounds(10,340,200,30);
       bt_amigos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(    ActionEvent e) {
           limpaTela();
           painel_geral = new PainelAmigos(y,bt_solitacoes).getPainel();
           tela.add(painel_geral);
           painel_geral.repaint();
        }});
       tela.add(bt_amigos);
       
       //-----Botão que leva a comunidade-----
       bt_comunidade = new JButton("Comunidade");
       bt_comunidade.setBounds(10,380,200,30);
       bt_comunidade.setFont(fonte2); 
       bt_comunidade.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(    ActionEvent e) {
           limpaTela();
           painel_geral = new PainelComunidade().getPainel();
           tela.add(painel_geral);
           painel_geral.repaint();
        }});
       tela.add(bt_comunidade );
       
       //-----Botão que leva aos eventos-----
       bt_eventos = new JButton("Eventos");
       bt_eventos.setBounds(10,420,200,30);
       bt_eventos.setFont(fonte2); 
       tela.add(bt_eventos);
       
       //-----Botão que leva aos jogos-----
       bt_jogos = new JButton("Jogos");
       bt_jogos.setBounds(10,460,200,30);
       bt_jogos.setFont(fonte2); 
       bt_jogos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(    ActionEvent e) {
           limpaTela();
           painel_geral = new PainelJogos().getPainel();
           tela.add(painel_geral);
           painel_geral.repaint();
        }});
       tela.add(bt_jogos);
       
       //----Botão q da acesso ao leilão-----
       bt_leilao = new JButton("Leilão");
       bt_leilao.setBounds(10,500,200,30);
       bt_leilao.setFont(fonte2); 
       tela.add(bt_leilao);
       
       //botão configurar
       bt_Configurar = new JButton("Configurações");
       bt_Configurar.setBounds(10,540,200,30);
       bt_Configurar.setFont(fonte2); 
       tela.add(bt_Configurar);
       bt_Configurar.addActionListener(new ActionListener() {               
       @Override
       public void actionPerformed(ActionEvent e) {
          // chama função configuraçoes
            goConfiguracoes();
                }});
       
       
       //--------------------------------------ToolTip----------------------------------------------
       
       bt_Foto.setToolTipText(" Adicionar imagem do usuario ");
       bt_PaginaInicial.setToolTipText(" Ir para a pagina inicial ");
       bt_colecao.setToolTipText(" Ir para a sua coleção ");
       bt_sair.setToolTipText(" Encerrar sessão ");
       bt_amigos.setToolTipText(" Ir para a pagina de amigos ");
       bt_comunidade.setToolTipText(" Ir para os grupos de colecionadores ");
       bt_eventos.setToolTipText(" Ir para a pagina de eventos  ");
       bt_jogos.setToolTipText(" Ir para os jogos disponiveis ");
       bt_leilao.setToolTipText(" Ir para o leilão de itens ");
       bt_trocas.setToolTipText(" Realizar trocas de itens ");
       bt_meuHistorico.setToolTipText(" Visualizar minhas ações ");
       bt_Configurar.setToolTipText(" Configurações da conta ");
       UIManager.put("ToolTip.background",SystemColor.info);
       
       //re-formula o comando atual das teclas 
        ActionMap actionMap = painel_amigos_att.getActionMap();
        
        //Istancia de funçoes para o teclado
        Teclado tecladoUndo = new Teclado(0);
        Teclado tecladoRedu = new Teclado(1);
        Teclado tecladoDeslogar = new Teclado(2);
        
        //recebe o nome especifico e uma fução istanciada a cima
        actionMap.put("bt_undo", tecladoUndo); 
        actionMap.put("bt_redu", tecladoRedu); 
        actionMap.put("bt_sair", tecladoDeslogar); 
        painel_amigos_att.setActionMap(actionMap);
        
        //faz com q esta fnções n dependão do foco KeyStroke.getKeyStroke("ESC")
        InputMap imap = painel_amigos_att.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        
        //passa as letras de cada ação do teclado que ira executar um função passa no .put
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK), "bt_undo");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK), "bt_redu");
        imap.put(KeyStroke.getKeyStroke("ESCAPE"), "bt_sair");
        
        //difinições da tela
        this.setVisible(true);
        this.setSize(1090,650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.repaint();
    }
    
   //implemneta todas as função do teclado
    private class Teclado extends AbstractAction 
    {            
    private int funcao;
    //construtor que recebe uma função atravez de um numero 
    public Teclado(int funcao){
        this.funcao = funcao;
        }
      
      @Override  
        public void actionPerformed(ActionEvent e) {  
            if(funcao == 0){
            if(y.getUltimaColecao().size() != 0){
                int i = y.getUltimaColecao().get(y.getUltimaColecao().size()-1);
                 y.deletaNull();}
                y.undo();
                // aqui
           } 
          else if(funcao == 1){
            y.redu();
            // aqui
            }
          else {
            boolean text = new PainelConfiguracao().getGuarda();
            if(text){
                    y.zeraRedu();
                    y.zeraUndo();
                    y.setGuardaUndo(false);
                      }
                 else{y.setGuardaUndo(true);}     
            cadastro.deslogar();
            setVisible (false);
            dispose();
            }
    }  
   }
   
    
    //volta no inicio
    public void goInicio(){
        limpaTela();
        scroll_Geral = new PainelHistorico(y,1).getScrollPaneHistorico();
        tela.add(scroll_Geral);
        scroll_Geral.repaint();
    }
    
    //leva ao historico do usuario
    public void goHistorico(){
        limpaTela();
        scroll_Geral = new PainelHistorico(y,0).getScrollPaneHistorico();  
        tela.add(scroll_Geral);
        scroll_Geral.repaint();
    }
    
    //Acessa as coleçoes do usuario
    public void goColecao(){
        limpaTela();
        painel_geral = new PainelColecao(y).getPainel();
        tela.add(painel_geral);
        painel_geral.repaint();
    }
    
    //Acessa as configurações do usuario
    public void goConfiguracoes(){
        limpaTela();
        painel_geral = new PainelConfiguracao(y).getPanel();
        tela.add(painel_geral);
        painel_geral.repaint();
    }
    
    //leva a tela de perfil
    public void goPerfil(int indice,int x){
        limpaTela();
        painel_geral = new  PainelPerfil(y,indice,x,lb_bemVindo).getPanel();
        tela.add(painel_geral);
        painel_geral.repaint();
    }
    
    //remove os 2 paneis interativos
    public void limpaPaineisInterativos(){
        painel_new_amigo.setVisible(false);
        painel_naoLidas.setVisible(false);
        if(!aparece){aparece = !aparece;}
        if(!aparece2){aparece2 = !aparece2;}
    }
    
    //limpa todos os paineis
    public void limpaTela(){
        limpaPaineisInterativos();
        painel_geral.setVisible(false);
        tela.remove(painel_geral);
        tela.remove(scroll_Geral);
    }
    
    //gera o balão de amigos
    public void colocaPainel(){
       painel_new_amigo.setLayout(null);
       painel_new_amigo.setBounds(540,40,450,283);
       
       //JLabel enorme com a img do balão
       JLabel lb_caixa = new JLabel();
       lb_caixa.setIcon(new ImageIcon("img\\balaopronto.png"));
       lb_caixa.setBounds(0,0,450,283);
       painel_new_amigo.add(lb_caixa);
       
       //painel distinado a mostrar todas as solicitações de amizade interno de um scrollPane
       JPanel painel_lista = new JPanel();
       painel_lista.setLayout(null);
       painel_lista.setBounds(0,0,399,200);
       prenchePainelNotificacao(painel_lista);
       painel_lista.setPreferredSize(painel_lista.getSize());
       scroll_new_amigos = new JScrollPane(painel_lista);
       scroll_new_amigos.setBounds(25,59,399,210);
       scroll_new_amigos.setHorizontalScrollBarPolicy(scroll_new_amigos.HORIZONTAL_SCROLLBAR_NEVER);
       
       painel_new_amigo.add(scroll_new_amigos);
       
       painel_new_amigo.setVisible(true);
       painel_new_amigo.setFocusable(true);
    }
    
    //função q cria um painel interno das notificações (Interativo)
    public void prenchePainelNotificacao(final JPanel painel){
        int x = 5;
        for(int i=0;i< grafos.todosNaoAmigos(cadastro.getIndice()).size();i++){
         if(grafos.verSolicitacao(cadastro.getIndice()).contains(grafos.todosNaoAmigos(cadastro.getIndice()).get(i))){
          final int I = i;
          //img do usuario
          ImageIcon img2 = new ImageIcon(cadastro.getFoto(grafos.todosNaoAmigos(cadastro.getIndice()).get(i)));  
          img2.setImage(img2.getImage().getScaledInstance(60, 60, 100));
          JLabel caraUsuario = new JLabel(img2);
          caraUsuario.setBounds(7, x, 60, 60);
          
          //mensagen (quer seu sua amigo(a))
          JLabel mensagem = new JLabel(cadastro.getNomeUsuario(grafos.todosNaoAmigos(cadastro.getIndice()).get(i))+" Quer ser Seu amigo(a)",JLabel.CENTER);
          mensagem.setBounds(67, x, 320, 20);
          mensagem.setFont(fonteT1);
          painel.add(mensagem);
         
          //botão destndo a aceitar o pedido de amizade de um usuari x
          JButton bt_send_aceitar = new JButton(new ImageIcon("img\\aceitar.png"));
          bt_send_aceitar.setText("Aceitar");
          bt_send_aceitar.setFont(fonteT1);
          bt_send_aceitar.addActionListener( new ActionListener(){ @Override
             public void actionPerformed(ActionEvent e){
              JOptionPane.showMessageDialog(null,cadastro.getNomeUsuario(grafos.todosNaoAmigos(cadastro.getIndice()).get(I))+
              " É seu novo amigo(a)!");
              y.addEvendoNovoAmigo(cadastro.getNomeUsuario(grafos.todosNaoAmigos(cadastro.getIndice()).get(I)));
              grafos.fazerPedido(cadastro.getIndice(),grafos.todosNaoAmigos(cadastro.getIndice()).get(I));
              bt_solitacoes.setText(""+grafos.getNumeroDesolicitacao(cadastro.getIndice()));
              painel.removeAll();
              prenchePainelNotificacao(painel);
              painel.repaint();
              preencheAmigosLateral();
                 }                           
            });
          bt_send_aceitar.setBounds(80, x+25, 140, 35);
          painel.add(bt_send_aceitar);
         
          //botão destinado a ignora um pedido de amizade
          JButton bt_send_Recusar = new JButton(new ImageIcon("img\\br.png"));
          bt_send_Recusar.setText("Recusar");
          bt_send_Recusar.setFont(fonteT1);
          bt_send_Recusar.addActionListener( new ActionListener(){ @Override
             public void actionPerformed(ActionEvent e){
              grafos.recusarPedido(cadastro.getIndice(), grafos.todosNaoAmigos(cadastro.getIndice()).get(I));
              bt_solitacoes.setText(""+grafos.getNumeroDesolicitacao(cadastro.getIndice()));
              painel.removeAll();
              prenchePainelNotificacao(painel);
              painel.repaint();
                 }                           
            });
          bt_send_Recusar.setBounds(230, x+25, 140, 35);
          painel.add(bt_send_Recusar);
         
          painel.add(caraUsuario);
          x+=65;
          painel.setSize(210, x);
          painel.setPreferredSize(painel.getSize());
         }
        }
    }
    
    //cria o painel interativo q mostra as conversas não lidas
    public void colocaPainel_naolido(){
       painel_naoLidas.setLayout(null);
       painel_naoLidas.setBounds(615,40,450,283);
       
       //JLabel enorme com a img do balão
       JLabel lb_caixa = new JLabel();
       lb_caixa.setIcon(new ImageIcon("img\\balaopronto.png"));
       lb_caixa.setBounds(0,0,450,283);
       painel_naoLidas.add(lb_caixa);
       
       //painel que fica dentro do scroll para mostrar as conversas não lidas
       JPanel painel_lista = new JPanel();
       painel_lista.setLayout(null);
       painel_lista.setBounds(0,0,399,200);
       painel_lista.setPreferredSize(painel_lista.getSize());
       scroll_new_amigos = new JScrollPane(painel_lista);
       scroll_new_amigos.setBounds(25,59,399,210);
       scroll_new_amigos.setHorizontalScrollBarPolicy(scroll_new_amigos.HORIZONTAL_SCROLLBAR_NEVER);
       
       preencheNaoLidas(painel_lista,new ArrayList<Integer>());
       
       painel_naoLidas.add(scroll_new_amigos);
       
       painel_naoLidas.setVisible(true);
       painel_naoLidas.setFocusable(true);
    }
    
    //adiciona com foto das as ultimas conversas n lidas
    public void preencheNaoLidas(JPanel painel, ArrayList<Integer> lista){
        int x =0;
        
        for(int i = 0;i<grafos.getConvesasQueNaoLi(cadastro.getIndice()).size();i++){
        //img do usuario 
        ImageIcon img2 = new ImageIcon(cadastro.getFoto(grafos.getConvesasQueNaoLi(cadastro.getIndice()).get(i)));  
        img2.setImage(img2.getImage().getScaledInstance(60, 60, 100));
        JLabel caraUsuario = new JLabel(img2);
        caraUsuario.setToolTipText(cadastro.getNomeUsuario(grafos.getConvesasQueNaoLi(cadastro.getIndice()).get(i))+" Disse ");
        caraUsuario.setBounds(7, x+5, 60, 60);
        painel.add(caraUsuario);
        
        //oque ele falo
        JTextArea falouIsso = new JTextArea(1,1);
        final int amigo = grafos.getConvesasQueNaoLi(cadastro.getIndice()).get(i);
        int ultimaFala = grafos.getOqueMando(cadastro.getIndice(), amigo).size()-1;
        falouIsso.setText(grafos.getOqueMando(cadastro.getIndice(), amigo).get(ultimaFala));
        JScrollPane scrollPane = new JScrollPane(falouIsso);
        falouIsso.setLineWrap(true);falouIsso.setEditable(false);
        scrollPane.setBounds(70, x+5, 310, 39); 
        painel.add(scrollPane);
        
        //ver oque ele falo
        JButton bt_ver_oque_falo = new JButton();
        bt_ver_oque_falo.setText("Ver toda Conversa");
        bt_ver_oque_falo.setBounds(70, x+46, 310, 19); 
        bt_ver_oque_falo.addActionListener( new ActionListener(){ @Override
         public void actionPerformed(ActionEvent e){
          criaConversa(amigo);
        }});
        painel.add(bt_ver_oque_falo);
        
        x+=65;
     }
        
        painel.repaint();
        painel.setSize(210, x);
        painel.setPreferredSize(painel.getSize());
    }
    
    //prenche a barra lateral com amigos
    public void preencheAmigosLateral(){
     painel_amigos_att.removeAll();
     int x = 0;
     for(int i =0;i < grafos.todosAmigos(cadastro.getIndice()).size();i++){
      final int I =i;   
      JLabel mensagem = new JLabel();mensagem.setBorder(new javax.swing.border.TitledBorder(""));
      mensagem.setBounds(5, x+3, 189, 60);
      painel_amigos_att.add(mensagem);
      
      //img do usuario
      ImageIcon img2 = new ImageIcon(cadastro.getFoto(grafos.todosAmigos(cadastro.getIndice()).get(i)));  
      img2.setImage(img2.getImage().getScaledInstance(51,51, 100)); 
      JLabel lb_img_amigo = new JLabel(img2);
      lb_img_amigo.setBounds(6,x+6,51, 51);
      painel_amigos_att.add(lb_img_amigo);
                     
      // nome
      JLabel lb_nome_amigo = new JLabel(cadastro.getNomeUsuario(grafos.todosAmigos(cadastro.getIndice()).get(i)),JLabel.CENTER);
      lb_nome_amigo.setBounds(58, x+11, 130, 20);lb_nome_amigo.setFont(fonteT1); 
      painel_amigos_att.add(lb_nome_amigo);
      
      //perfil
      JButton bt_Ver_Perfil = new JButton("Perfil");
      bt_Ver_Perfil.setBounds(60, x+35, 60, 20);  
      bt_Ver_Perfil.addActionListener( new ActionListener(){ @Override
      public void actionPerformed(ActionEvent e){
        if(cadastro.getQuemVe(grafos.todosAmigos(cadastro.getIndice()).get(I)) != 0) {
         goPerfil(grafos.todosAmigos(cadastro.getIndice()).get(I),10);}
         else{JOptionPane.showMessageDialog(null, "Informações restritas");}
          }});painel_amigos_att.add(bt_Ver_Perfil);
      
      JButton bt_novaConversa = new JButton("Falar");
      bt_novaConversa.addActionListener( new ActionListener(){ @Override
      public void actionPerformed(ActionEvent e){
          criaConversa(grafos.todosAmigos(cadastro.getIndice()).get(I));
        }});
      bt_novaConversa.setBounds(126, x+35, 60, 20);  
      painel_amigos_att.add(bt_novaConversa);
      x+=60;
     }
     painel_amigos_att.repaint();
   }
   
   //carrega as conversas para o painel mais inferior da tela
   public void criaConversa(final int amigo){
    limpaPaineisInterativos();
    painel_conversa.removeAll();
    
    //area onde mostra tudo oque foi dito na conversa
    final JPanel painel_de_Falas = new JPanel();
    painel_de_Falas.setLayout(null);
    painel_de_Falas.setBounds(0, 0, 190, 140);
    painel_de_Falas.setPreferredSize(painel_de_Falas.getSize());
    final JScrollPane scrol_falas = new JScrollPane(painel_de_Falas);
    scrol_falas.setHorizontalScrollBarPolicy(scrol_falas.HORIZONTAL_SCROLLBAR_NEVER);
    scrol_falas.setBounds(0, 0, 200, 155); 
    painel_conversa.add(scrol_falas);
    
    //barra para enviar mensagens
    final JTextArea TA_mensagem = new JTextArea(1, 1);
    TA_mensagem.setFocusable(true);
    JScrollPane scrollPane = new JScrollPane(TA_mensagem);
    TA_mensagem.setLineWrap(true);
    scrollPane.setBounds(5, 160, 190, 36); 
    painel_conversa.add(scrollPane);
    
    //faz com que a mensagen seja envia atravez do Enter
    TA_mensagem.addKeyListener(new KeyListener(){
     @Override
     public void keyPressed(KeyEvent e){
       if(e.getKeyCode() == KeyEvent.VK_ENTER){
          grafos.novaFala(cadastro.getIndice(),amigo,TA_mensagem.getText());
          addUmaNovaMensagem(painel_de_Falas, TA_mensagem.getText(), scrol_falas);
         }
      }
     @Override public void keyTyped(KeyEvent e) {}
     @Override public void keyReleased(KeyEvent e) {
          if(e.getKeyCode() == KeyEvent.VK_ENTER){TA_mensagem.setText(null);}}
    });
    
    carregarMensagens(painel_de_Falas,amigo, scrol_falas);//imprime as conversas
    painel_conversa.revalidate();
    painel_conversa.repaint();
    }
    
   //imprime toda a conversa apartir de um uuario e o local na onde os dados vão aparecer
   public void carregarMensagens(JPanel painel,int amigo, JScrollPane scroll){
     controleConversa = 0;
     int x = controleConversa;
     for(int i = 0; i < grafos.getQuemMandou(cadastro.getIndice(),amigo).size();i++){
      //img do usuario
      ImageIcon img2 = new ImageIcon(cadastro.getFoto(grafos.getQuemMandou(cadastro.getIndice(),amigo).get(i)));  
      img2.setImage(img2.getImage().getScaledInstance(51,51, 100)); 
      JLabel lb_img_amigo = new JLabel(img2);
      lb_img_amigo.setBounds(1,x,50, 50);
      lb_img_amigo.setToolTipText(cadastro.getNomeUsuario(grafos.getQuemMandou(cadastro.getIndice(),amigo).get(i))+" Disse ");
      painel.add(lb_img_amigo);
      
      //oque ele falo
      JTextArea falouIsso = new JTextArea(1,1);
      falouIsso.setText(grafos.getOqueMando(cadastro.getIndice(), amigo).get(i));
      JScrollPane scrollPane = new JScrollPane(falouIsso);
      falouIsso.setLineWrap(true);falouIsso.setEditable(false);
      scrollPane.setBounds(51, x, 138, 50); 
      painel.add(scrollPane);
      
      x+=60;
    }
    //redimenciona o peinel
    painel.setSize(190,x);
    painel.setPreferredSize(painel.getSize());
    controleConversa = x;
    
    //passa o scrollPane para o fim
    int maxValue = scroll.getVerticalScrollBar().getMaximum();  
    scroll.getViewport().setViewPosition(new Point(0,maxValue)); 
    } 
   
    //adiciona uma unica ultima mensagen enviada
   public void addUmaNovaMensagem(JPanel painel,String texto, JScrollPane scroll){
      //img do usuario
      ImageIcon img2 = new ImageIcon(cadastro.getFoto(cadastro.getIndice()));  
      img2.setImage(img2.getImage().getScaledInstance(51,51, 100)); 
      JLabel lb_img_amigo = new JLabel(img2);
      lb_img_amigo.setBounds(1,controleConversa,50, 50);
      lb_img_amigo.setToolTipText(cadastro.getNomeUsuario(cadastro.getIndice())+" Disse ");
      painel.add(lb_img_amigo);
      
      //oque o usuario falo
      JTextArea falouIsso = new JTextArea(1,1);
      falouIsso.setText(texto);
      JScrollPane scrollPane = new JScrollPane(falouIsso);
      falouIsso.setLineWrap(true);falouIsso.setEditable(false);
      scrollPane.setBounds(51, controleConversa, 138, 50); 
      painel.add(scrollPane);
      
      //redimencioando o scrollPane
      controleConversa +=60;
      painel.setSize(190,controleConversa);
      painel.setPreferredSize(painel.getSize());
      
      //passa o scrollPane para o fim
      int maxValue = scroll.getVerticalScrollBar().getMaximum();  
      scroll.getViewport().setViewPosition(new Point(0,maxValue));  
    }
}