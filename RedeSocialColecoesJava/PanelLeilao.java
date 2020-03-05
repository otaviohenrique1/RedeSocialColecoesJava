import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelLeilao
{
    JLabel TituloTelaJogos,TituloTelaMoeda,TituloTelaQuadrinhos,TituloTelaHotwheels,TituloTelaCartoes,TituloTelaCamisa;
    
    JButton ButtonJogos,ButtonMoeda,ButtonQuadrinhos,ButtonHotwheels,ButtonCartoes,ButtonCamisa;
    
    JButton LeilaoLanceProposto,LeilaoVoltar,LeilaoCancelar,LeilaoVoltarTela,LeilaoComprar,LeilaoLanceTela;
    
    JButton ButtonBuscaJogos,ButtonBuscaMoeda,ButtonBuscaQuadrinhos,ButtonBuscaHotwheels,ButtonBuscaCartoes,ButtonBuscaCamisa;
    
    JPanel Panel_Leilao,PaneLTelaLeilao,PanelAreaJogos,PanelAreaMoeda,PanelAreaQuadrinhos,PanelAreaHotwheels,PanelAreaCartoes,PanelAreaCamisa,PanelLeilaoPainel,PanelBotoes;
    
    JPanel PanelBuscaJogos,PanelBuscaMoeda,PanelBuscaQuadrinhos,PanelBuscaHotwheels,PanelBuscaCartoes,PanelBuscaCamisa,PanelTelaLance,PanelValorLance;
    
    JFrame TelaLance,ValorLance;
    
    JTextField BuscaJogos,BuscaMoeda,BuscaQuadrinhos,BuscaHotwheels,BuscaCartoes,BuscaCamisa,TextLance;
    
    ButtonHandler handler = new ButtonHandler();
    public PanelLeilao()
    {
       Panel_Leilao = new JPanel();
       Panel_Leilao.setLayout(null);
       
       
       
       PaneLTelaLeilao = new JPanel();                              PaneLTelaLeilao.setBounds(120,0,530,560);                       PaneLTelaLeilao.setBorder(BorderFactory.createTitledBorder(""));         Panel_Leilao.add(PaneLTelaLeilao); 
       PaneLTelaLeilao.setVisible(true);
       
       PanelLeilaoPainel = new JPanel();                            PanelLeilaoPainel.setBounds(0,0,120,560);                       PanelLeilaoPainel.setBorder(BorderFactory.createTitledBorder(""));       Panel_Leilao.add(PanelLeilaoPainel); 
       PanelBotoes = new JPanel();                                  PanelBotoes.setBounds(10,50,120,560);                           PanelBotoes.setBorder(BorderFactory.createTitledBorder(""));             PanelLeilaoPainel.add(PanelBotoes);                            PanelBotoes.setLayout(new GridLayout(6,1,1,5));
       PanelLeilaoPainel.setVisible(true);
       PanelBotoes.setVisible(true);
       ButtonJogos = new JButton("Jogos");                          ButtonJogos.setPreferredSize(new Dimension(100,50));            ButtonJogos.setBorder(BorderFactory.createTitledBorder(""));             PanelBotoes.add(ButtonJogos);                                  ButtonJogos.addActionListener(handler);
       ButtonMoeda = new JButton("Moeda");                          ButtonMoeda.setPreferredSize(new Dimension(100,50));            ButtonMoeda.setBorder(BorderFactory.createTitledBorder(""));             PanelBotoes.add(ButtonMoeda);                                  ButtonMoeda.addActionListener(handler);
       ButtonQuadrinhos = new JButton("Quadrinhos");                ButtonQuadrinhos.setPreferredSize(new Dimension(100,50));       ButtonQuadrinhos.setBorder(BorderFactory.createTitledBorder(""));        PanelBotoes.add(ButtonQuadrinhos);                             ButtonQuadrinhos.addActionListener(handler);
       ButtonHotwheels = new JButton("Hotwheels");                  ButtonHotwheels.setPreferredSize(new Dimension(100,50));        ButtonHotwheels.setBorder(BorderFactory.createTitledBorder(""));         PanelBotoes.add(ButtonHotwheels);                              ButtonHotwheels.addActionListener(handler);
       ButtonCartoes = new JButton("Catoes");                       ButtonCartoes.setPreferredSize(new Dimension(100,50));          ButtonCartoes.setBorder(BorderFactory.createTitledBorder(""));           PanelBotoes.add(ButtonCartoes);                                ButtonCartoes.addActionListener(handler);
       ButtonCamisa = new JButton("Camisa");                        ButtonCamisa.setPreferredSize(new Dimension(100,50));           ButtonCamisa.setBorder(BorderFactory.createTitledBorder(""));            PanelBotoes.add(ButtonCamisa);                                 ButtonCamisa.addActionListener(handler);
       ButtonJogos.setVisible(true);                                ButtonMoeda.setVisible(true);                                   ButtonMoeda.setVisible(true);                                            ButtonQuadrinhos.setVisible(true); 
       ButtonCartoes.setVisible(true);                              ButtonCamisa.setVisible(true); 
       
       
       Panel_Leilao.setBounds(220,50,650,560);
       Panel_Leilao.setBorder(BorderFactory.createTitledBorder(""));
       Panel_Leilao.setVisible(true);
    }
    public class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == ButtonJogos){PanelAreaJogos();}
            if(event.getSource() == ButtonMoeda){PanelAreaMoeda();}
            if(event.getSource() == ButtonQuadrinhos){PanelAreaQuadrinhos();}
            if(event.getSource() == ButtonHotwheels){PanelAreaHotwheels();}
            if(event.getSource() == ButtonCartoes){PanelAreaCartoes();}
            if(event.getSource() == ButtonCamisa){PanelAreaCamisa();}
        }
    }
    
    
    public void PanelAreaJogos()
    {
        PanelAreaJogos = new JPanel();                       PanelAreaJogos.setBounds(120,0,530,560);                        PanelAreaJogos.setBorder(BorderFactory.createTitledBorder(""));          Panel_Leilao.add(PanelAreaJogos); 
        PanelAreaJogos.setVisible(true);                     PanelAreaJogos.setLayout(null);
        LimapaTela();
        PanelBuscaJogos = new JPanel();                      PanelBuscaJogos.setBounds(100,80,400,60);                       PanelBuscaJogos.setBorder(BorderFactory.createTitledBorder(""));         Panel_Leilao.add(PanelBuscaJogos); 
        ButtonBuscaJogos = new JButton("Busca");             ButtonBuscaJogos.setBounds(300,60,120,30);                      ButtonBuscaJogos.setBorder(BorderFactory.createTitledBorder(""));        PanelBuscaJogos.add(ButtonBuscaJogos);
        BuscaJogos = new JTextField();                       BuscaJogos.setBounds(100,60,100,30);                            PanelBuscaJogos.add(BuscaJogos);                                         BuscaJogos.setVisible(true);
        TituloTelaJogos = new JLabel("Jogos");               TituloTelaJogos.setBounds(200,20,100,30);                       TituloTelaJogos.setBorder(BorderFactory.createTitledBorder(""));         PanelAreaJogos.add(TituloTelaJogos);                   TituloTelaJogos.setFont(new Font("Arial",Font.BOLD, 20));
        TituloTelaJogos.setVisible(true);                    ButtonBuscaJogos.setVisible(true);                              PanelBuscaJogos.setVisible(true); 
    }
    public void PanelAreaMoeda()
    {
        PanelAreaMoeda = new JPanel();                       PanelAreaMoeda.setBounds(120,0,530,560);                        PanelAreaMoeda.setBorder(BorderFactory.createTitledBorder(""));          Panel_Leilao.add(PanelAreaMoeda);
        PanelAreaMoeda.setVisible(true);                     PanelAreaMoeda.setLayout(null);
        LimapaTela();
        PanelBuscaMoeda = new JPanel();                      PanelBuscaMoeda.setBounds(100,80,400,60);                       PanelBuscaMoeda.setBorder(BorderFactory.createTitledBorder(""));         Panel_Leilao.add(PanelBuscaMoeda); 
        ButtonBuscaMoeda = new JButton("Busca");             ButtonBuscaMoeda.setBounds(300,60,120,30);                      ButtonBuscaMoeda.setBorder(BorderFactory.createTitledBorder(""));        PanelBuscaMoeda.add(ButtonBuscaMoeda);
        BuscaMoeda = new JTextField();                       BuscaMoeda.setBounds(100,60,100,30);                            PanelBuscaMoeda.add(BuscaMoeda);
        TituloTelaMoeda = new JLabel("Moeda");               TituloTelaMoeda.setBounds(200,20,100,30);                       TituloTelaMoeda.setBorder(BorderFactory.createTitledBorder(""));         PanelAreaMoeda.add(TituloTelaMoeda);                    TituloTelaMoeda.setFont(new Font("Arial",Font.BOLD, 20));
    }
    public void PanelAreaQuadrinhos()
    {
         PanelAreaQuadrinhos = new JPanel();                  PanelAreaQuadrinhos.setBounds(120,0,530,560);                   PanelAreaQuadrinhos.setBorder(BorderFactory.createTitledBorder(""));     Panel_Leilao.add(PanelAreaQuadrinhos); 
         PanelAreaQuadrinhos.setVisible(true);                PanelAreaQuadrinhos.setLayout(null);
         LimapaTela();
         PanelBuscaQuadrinhos = new JPanel();                 PanelBuscaQuadrinhos.setBounds(100,80,400,60);                  PanelBuscaQuadrinhos.setBorder(BorderFactory.createTitledBorder(""));    PanelBuscaQuadrinhos.add(PanelBuscaJogos); 
         ButtonBuscaQuadrinhos = new JButton("Busca");        ButtonBuscaQuadrinhos.setBounds(300,60,120,30);                 ButtonBuscaQuadrinhos.setBorder(BorderFactory.createTitledBorder(""));   PanelBuscaQuadrinhos.add(ButtonBuscaQuadrinhos);
         BuscaQuadrinhos = new JTextField();                  BuscaQuadrinhos.setBounds(100,60,100,30);                       PanelAreaQuadrinhos.add(BuscaQuadrinhos);
         TituloTelaQuadrinhos = new JLabel("Quadrinhos");     TituloTelaQuadrinhos.setBounds(200,20,100,30);                  TituloTelaQuadrinhos.setBorder(BorderFactory.createTitledBorder(""));    PanelAreaQuadrinhos.add(TituloTelaQuadrinhos);          TituloTelaQuadrinhos.setFont(new Font("Arial",Font.BOLD, 20));
    }
    public void PanelAreaHotwheels()
    {
        PanelAreaHotwheels = new JPanel();                   PanelAreaHotwheels.setBounds(120,0,530,560);                    PanelAreaHotwheels.setBorder(BorderFactory.createTitledBorder(""));      Panel_Leilao.add(PanelAreaHotwheels); 
        PanelAreaHotwheels.setVisible(true);                 PanelAreaHotwheels.setLayout(null);
        LimapaTela();
        PanelBuscaHotwheels = new JPanel();                  PanelBuscaHotwheels.setBounds(100,80,400,60);                   PanelBuscaHotwheels.setBorder(BorderFactory.createTitledBorder(""));     PanelBuscaHotwheels.add(PanelBuscaJogos); 
        ButtonBuscaHotwheels = new JButton("Busca");         ButtonBuscaHotwheels.setBounds(300,60,120,30);                  ButtonBuscaHotwheels.setBorder(BorderFactory.createTitledBorder(""));    PanelBuscaHotwheels.add(ButtonBuscaHotwheels);
        BuscaHotwheels = new JTextField();                   BuscaHotwheels.setBounds(100,60,100,30);                        PanelAreaHotwheels.add(BuscaHotwheels);
        TituloTelaHotwheels = new JLabel("Hotwheels");       TituloTelaHotwheels.setBounds(200,20,100,30);                   TituloTelaHotwheels.setBorder(BorderFactory.createTitledBorder(""));     PanelAreaHotwheels.add(TituloTelaHotwheels);            TituloTelaHotwheels.setFont(new Font("Arial",Font.BOLD, 20));
    }
    public void PanelAreaCartoes()
    {
        PanelAreaCartoes = new JPanel();                     PanelAreaCartoes.setBounds(120,0,530,560);                      PanelAreaCartoes.setBorder(BorderFactory.createTitledBorder(""));        Panel_Leilao.add(PanelAreaCartoes); 
        PanelAreaCartoes.setVisible(true);                   PanelAreaCartoes.setLayout(null);
        LimapaTela();
        PanelBuscaCartoes = new JPanel();                    PanelBuscaCartoes.setBounds(100,80,400,60);                     PanelBuscaCartoes.setBorder(BorderFactory.createTitledBorder(""));       Panel_Leilao.add(PanelBuscaCartoes); 
        ButtonBuscaCartoes = new JButton("Busca");           ButtonBuscaCartoes.setBounds(300,60,120,30);                    ButtonBuscaCartoes.setBorder(BorderFactory.createTitledBorder(""));      PanelAreaCartoes.add(ButtonBuscaCartoes);
        BuscaCartoes = new JTextField();                     BuscaCartoes.setBounds(100,60,100,30);                          PanelAreaCartoes.add(BuscaCartoes);
        TituloTelaCartoes = new JLabel("Catoes");            TituloTelaCartoes.setBounds(200,20,100,30);                     TituloTelaCartoes.setBorder(BorderFactory.createTitledBorder(""));       PanelAreaCartoes.add(TituloTelaCartoes);                TituloTelaCartoes.setFont(new Font("Arial",Font.BOLD, 20));
    }
    public void PanelAreaCamisa()
    {
        PanelAreaCamisa = new JPanel();                      PanelAreaCamisa.setBounds(120,0,530,560);                       PanelAreaCamisa.setBorder(BorderFactory.createTitledBorder(""));         Panel_Leilao.add(PanelAreaCamisa); 
        PanelAreaCamisa.setVisible(true);                    PanelAreaCamisa.setLayout(null);
        LimapaTela();
        PanelBuscaCartoes = new JPanel();                    PanelBuscaCartoes.setBounds(100,80,400,60);                     PanelBuscaCartoes.setBorder(BorderFactory.createTitledBorder(""));       Panel_Leilao.add(PanelBuscaCartoes); 
        TelaLance();
        ValorLance();
        ButtonBuscaCamisa = new JButton("Busca");            ButtonBuscaCamisa.setBounds(300,60,120,30);                     ButtonBuscaCamisa.setBorder(BorderFactory.createTitledBorder(""));       PanelBuscaCartoes.add(ButtonBuscaCamisa);
        BuscaCamisa = new JTextField();                      BuscaCamisa.setBounds(100,60,100,30);                           PanelBuscaCartoes.add(BuscaCamisa);
        TituloTelaCamisa = new JLabel("Camisa");             TituloTelaCamisa.setBounds(200,20,100,30);                      TituloTelaCamisa.setBorder(BorderFactory.createTitledBorder(""));        PanelAreaCamisa.add(TituloTelaCamisa);                  TituloTelaCamisa.setFont(new Font("Arial",Font.BOLD, 20));
    }
    
    
    
    
    public void TelaLance()
    {
        TelaLance = new JFrame("Lance");                    
        TelaLance.setLayout(null);                          
        TelaLance.setSize(300,300);                         
        TelaLance.setVisible(true);                    
        TelaLance.setResizable(false);                          
        TelaLance.setLocationRelativeTo(null);
        
        PanelTelaLance = new JPanel();                      PanelTelaLance.setBounds(0,0,300,300);              PanelTelaLance.setLayout(null);                     TelaLance.add(PanelTelaLance);
        LeilaoLanceTela = new JButton("Lance");             LeilaoLanceTela.setBounds(10,10,120,30);            PanelTelaLance.add(LeilaoLanceTela);
        LeilaoComprar = new JButton("Comprar");             LeilaoComprar.setBounds(10,50,120,30);              PanelTelaLance.add(LeilaoComprar);
        LeilaoVoltarTela = new JButton("Lance");            LeilaoVoltarTela.setBounds(10,90,120,30);           PanelTelaLance.add(LeilaoVoltarTela);
    }
    
    
    
    
    public void ValorLance()
    {
        ValorLance = new JFrame("Valor do Lance");          ValorLance.setLayout(null);                         ValorLance.setSize(300,300);                        ValorLance.setVisible(true);                   ValorLance.setResizable(false);                         ValorLance.setLocationRelativeTo(null);
        PanelValorLance = new JPanel();                     PanelValorLance.setBounds(0,0,300,300);             PanelValorLance.setLayout(null);                    ValorLance.add(PanelValorLance);
        TextLance = new JTextField();                       TextLance.setBounds(100,60,100,30);                 PanelValorLance.add(TextLance);                     TextLance.setVisible(true);
        LeilaoLanceProposto = new JButton("Lance");         LeilaoLanceProposto.setBounds(10,60,120,30);        PanelValorLance.add(LeilaoLanceProposto);
        LeilaoCancelar = new JButton("Cancelar");           LeilaoCancelar.setBounds(10,60,120,30);             PanelValorLance.add(LeilaoCancelar);
        LeilaoVoltar = new JButton("Voltar");               LeilaoVoltar.setBounds(10,60,120,30);               PanelValorLance.add(LeilaoVoltar);
    }
    public void LimapaTela()
    {PaneLTelaLeilao.setVisible(false);}
    public JPanel getPainel(){return Panel_Leilao;} 
}
