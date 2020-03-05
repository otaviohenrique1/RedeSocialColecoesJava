import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class PainelJogos
{
   JPanel painel_Jogos; 
   JLabel Label1;
   PainelJogos(){
       painel_Jogos = new JPanel();
       painel_Jogos.setLayout(null);
       
       
       
       
       
       painel_Jogos.setBounds(220,50,650,560);
       painel_Jogos.setBorder(new javax.swing.border.TitledBorder(""));
       painel_Jogos.setVisible(true);
    }
   
   public JPanel getPainel(){
    return painel_Jogos;
    } 
}
