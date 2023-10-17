package screens;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LogIn extends JFrame{
	JPanel p;
	JButton b1,b2;
	TextField txt1,txt2;
	JLabel lb1,lb2,lb3;
	ImageIcon im;
	JPanel pp;
	ArrayList<String> ar;
	Border raisedbevel ;
        LogIn(){
        	super("inscrire");
        	setSize(600,455);
        	im=new ImageIcon("C:\\\\myprogrammes\\\\JeuEnJava\\\\free.jpg");
        	p=new ImagePanel(im.getImage());
        	b1=new JButton("Sign Up");
        	b2=new JButton("Log In");
        	txt1=new TextField();
        	txt2=new TextField();
        	lb1=new JLabel("Name");
        	lb1.setForeground(Color.white);
        	
        	lb3=new JLabel("OR");
        	p.setLayout(null);
        	pp=new JPanel();
        	
        	pp.setBounds(150, 60, 300, 320);
        	pp.setLayout(null);
        	lb1.setForeground(Color.white);
        	
        	lb3.setForeground(Color.white);
        	pp.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        	p.add(pp);
        	pp.add(lb1);
        	
        	pp.add(txt1);
   
        	
        	
        	
        	
        	pp.add(b1);
        	
        	pp.add(b2);
        	pp.add(lb3);
        	 raisedbevel=BorderFactory.createRaisedBevelBorder();
             
        	lb1.setBounds(50, 60,45, 30);
        	txt1.setBounds(100,60,100,30);
        	b2.setBounds(110, 140, 80, 30);
        	lb3.setBounds(140, 180, 20, 20);
        	b1.setBounds(110, 210, 80, 30);
        	
        	b1.setBorder(raisedbevel);
        	
        	b2.addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			if(txt1.getText().isEmpty()) {
        				JOptionPane.showMessageDialog(null, "Plz enter Your Name", "Attention", 0, null);
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
        	
        					ag=Integer.parseInt(ar.get(i).substring(j+1));
    			
        					if(str.equals(txt1.getText())) {
        						ag=Integer.parseInt(ar.get(i).substring(j+1));
        						System.out.println("age="+ag);
        						exist=true;
        						break;
        						
        					}
        				}
        				if(exist==true) {
        					 dispose();
        					if(ag<8) {
   							
						    	 
								try {
									 FenetrePrincipale fen;
									fen = new FenetrePrincipale("Niveau1.txt",txt1.getText(),ag);
									fen.setLocationRelativeTo(null); 
									fen.setVisible(true);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							     
   						}
   						else if(ag>8&&ag<12) {
   							 FenetrePrincipale fen;
   							try {
									fen = new FenetrePrincipale("Niveau2.txt",txt1.getText(),ag);
									fen.setLocationRelativeTo(null);
									fen.setVisible(true);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
   						}
   						else {
   							FenetrePrincipale fen;
   							try {
									fen = new FenetrePrincipale("Niveau3.txt",txt1.getText(),ag);
									fen.setLocationRelativeTo(null);
									fen.setVisible(true);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
   						}
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "that log in does not exist!PLZ SignUp!!", "Attention", 0, null);
        				}
					
    			}
        		}
        		
        		
        	});
        	b1.addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			dispose();
        			SignUp f=new SignUp();
        			f.setVisible(true);
        			f.setLocationRelativeTo(null);
        			
        		}
        	});
        	getContentPane().add(p);
        }
}
