package screens;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
public class SignUp extends JFrame{
	JPanel p;
	JButton b1,b2,b3,b4,b5;
	TextField txt1,txt2,txt3,txt4;
	JLabel lb1,lb2,lb3;
	ImageIcon im;
	JPanel pp;
	ArrayList<String>ar;
	Border raisedbevel ;
        SignUp(){
        	super("inscrire");
        	setSize(600,455);
        	im=new ImageIcon("C:\\\\myprogrammes\\\\JeuEnJava\\\\free.jpg");
        	p=new ImagePanel(im.getImage());
        	b1=new JButton("Génerer");
        	b2=new JButton("copier");
        	b3=new JButton("Génerer");
        	b4=new JButton("vérifier");
        	b5=new JButton("terminer");
        	txt1=new TextField();
        	txt2=new TextField();
        	txt3=new TextField();
        	txt4=new TextField();
        	lb1=new JLabel("Name");
        	lb1.setForeground(Color.white);
        	lb2=new JLabel("Age");
        	lb3=new JLabel("OR");
        	p.setLayout(null);
        	pp=new JPanel();
        	
        	pp.setBounds(150, 60, 300, 320);
        	pp.setLayout(null);
        	lb1.setForeground(Color.white);
        	lb2.setForeground(Color.white);
        	lb3.setForeground(Color.white);
        	pp.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        	p.add(pp);
        	pp.add(lb1);
        	
        	pp.add(txt1);
   
        	pp.add(lb2);
        	pp.add(lb2);
        	
        	pp.add(txt2);
        	
        	pp.add(b1);
        	
        	pp.add(b2);
        	pp.add(lb3);
        	 raisedbevel=BorderFactory.createRaisedBevelBorder();
             
        	lb1.setBounds(50, 30,45, 30);
        	txt1.setBounds(100,30,100,30);
        	txt2.setBounds(100,90,100,30);
        	lb2.setBounds(50, 90,45, 30);
        	b1.setBounds(110, 150, 80, 30);
        	lb3.setBounds(140, 190, 20, 20);
        	b2.setBounds(110, 220, 80, 30);
        	
        	b1.setBorder(raisedbevel);
        	b2.addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			dispose();
        			LogIn f=new LogIn();
        			f.setVisible(true);
        			f.setLocationRelativeTo(null);
        		}
        		
        		
        	});
        	b1.addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			if(txt1.getText().isEmpty()||txt2.getText().isEmpty()) {
        				JOptionPane.showMessageDialog(null, "veuillez saisir tous le nom et l'age", "Attention", 0, null);
        			}
        			else {
        				
        				String str="";
        				int ag = 0;
        				boolean exist=false;
        				ar=new ArrayList<>();
        				try {
        					String ligne ;
        					
        					
        					BufferedReader entree = new BufferedReader (new FileReader ("users")) ; 
        					do { 
        						ligne = entree.readLine() ; 
        					   if (ligne != null) { 
        						   ar.add(ligne); }
        					   } while (ligne != null) ; 
        					entree.close () ; 
        				      
        				     
        				} catch (IOException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
        				for(int i=0;i<ar.size();i++) {
        					int j=0;
        					str="";
        					while(ar.get(i).charAt(j)!=':'&&j<ar.get(i).length()) {
        						str+=ar.get(i).charAt(j);
        					
        						j++;
        					}
        	
        					
    			
        					if(str.equals(txt1.getText())) {
        						
        						exist=true;
        						break;
        						
        					}
        				}
        				if(exist==false) {
        					dispose();
        					try {
								File file=new File("users");
								FileWriter fw=new FileWriter(file.getAbsoluteFile(),true);
								BufferedWriter bw=new BufferedWriter(fw);
							      bw.write(txt1.getText()+":"+txt2.getText());
							      bw.write("\n");
							      bw.close();
							      if(Integer.parseInt(txt2.getText())<=8) {
							    	  
							    	  FenetrePrincipale fen=new FenetrePrincipale("Niveau1.txt",txt1.getText(),Integer.parseInt(txt2.getText()));
								      
							    	  fen.setLocationRelativeTo(null);
							    	  fen.setVisible(true);
							      }
							      else if(Integer.parseInt(txt2.getText())>8&&Integer.parseInt(txt2.getText())<=12) {
							    	  
							    	  FenetrePrincipale fen=new FenetrePrincipale("Niveau2.txt",txt1.getText(),Integer.parseInt(txt2.getText()));
							    	
							    	  fen.setLocationRelativeTo(null);
							    	  fen.setVisible(true);
							      }
							      else {
							    	  
							    	  FenetrePrincipale fen=new FenetrePrincipale("Niveau3.txt",txt1.getText(),Integer.parseInt(txt2.getText()));
							    	
							    	  fen.setLocationRelativeTo(null);
							    	  fen.setVisible(true);
							      }
							     
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "that username is already taken plz try an other", "Attention", 0, null);
        				}
        				
        				
        				
        				
        				
        				
        				
        				
        				
							
						
        			}
        		}
        	});
        	getContentPane().add(p);
        }
}
