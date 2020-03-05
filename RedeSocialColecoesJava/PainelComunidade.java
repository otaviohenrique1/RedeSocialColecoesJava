import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class PainelComunidade
{
   JPanel painel_Comunidade; 
    
   PainelComunidade(){
       painel_Comunidade = new JPanel();
       painel_Comunidade.setLayout(null);
       painel_Comunidade.setBounds(220,50,650,560);
       painel_Comunidade.setBorder(new javax.swing.border.TitledBorder(""));
       painel_Comunidade.setVisible(true);
    }
   
   public JPanel getPainel(){
    return painel_Comunidade;
    } 
}
