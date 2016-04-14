/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelaIcone;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author joelribeiro
 */
public class Icone extends JFrame {
   
    private JLabel iconeLabel;
    private JLabel dsLabel=new JLabel();
    private JPanel panelGeral=new JPanel();
    private JPanel panelicon=new JPanel();
    private JPanel panelds=new JPanel();
   public Icone(){
       super("Logo & Desenvolvedores");
       
       //panelicon=new JPanel();
       panelicon.setLayout(new FlowLayout(FlowLayout.CENTER));
       Icon logo=new ImageIcon(getClass().getResource("LogoRJDraw.jpg"));
       try {  
                System.out.println(new File("LogoRJDraw.jpg").getCanonicalPath());  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
       iconeLabel=new JLabel(logo,SwingConstants.CENTER);
       iconeLabel.setToolTipText("Logo do Projeto");
       panelicon.add(iconeLabel);
       
       //panelds=new JPanel();
       panelds.setLayout(new FlowLayout(FlowLayout.CENTER));
       dsLabel=new JLabel();
       dsLabel.setText("Desenvolvedores: Rodrigo e Joel");
       panelds.add(dsLabel);
       
       //panelGeral=new JPanel();
       panelGeral.setLayout(new GridLayout(1,1,5,5));
       panelGeral.add(panelicon);panelGeral.add(panelds);
       getContentPane().add(panelGeral);

       setResizable(false);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       pack();
       //setResizable(false);
   }
   public void mostraGUI(){
       this.setLocationRelativeTo(null);
   }
  
}
