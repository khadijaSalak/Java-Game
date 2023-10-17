package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class FenetrePrincipale extends JFrame{
	  JPanel p1,p2,p3;
	  String ligne;
	  ArrayList<String> arr;
	  ArrayList<Thread> t;
	  JButton ex;
	  JLabel lb1,lb2,lb3,jl1,jl2,jl3;
	  int index=0;
	  ImageIcon im;
	  Border raisedbevel ,loweredbevel;
		Image img;
        FenetrePrincipale(String filaname,String name,int age) throws IOException{
        	super("jouer!!");
        	setSize(667,590);
        	
       	   raisedbevel=BorderFactory.createRaisedBevelBorder();
       	   loweredbevel=BorderFactory.createLoweredBevelBorder();
       	   p2=new JPanel();
       	   
       	   
       	  jl1=new JLabel("let' go!!"+name);
           	jl2=new JLabel("AgE  :  "+age+"       ");
           	if(age<=8) {
           		jl3=new JLabel("Level : Easy       ");
           	}
           	else if(age>8&&age<=12) {
           	jl3=new JLabel("Level:Average         ");
           	}
           	else {
           		jl3=new JLabel("Level : Difficult        ");
           	}
        	jl1.setBorder(raisedbevel);
           	jl2.setBorder(raisedbevel);
           	jl3.setBorder(raisedbevel);
           	
           	jl1.setSize(130, 60);
        	
        	
        	
        	 im=new ImageIcon("C:\\myprogrammes\\JeuEnJava/exit1.jpg");
      	   img=im.getImage();
        	
        	
        	p3=new JPanel();
      
        	ex=new JButton("Exit");
        	setLayout(null);
        	
               p3.setLayout(null);
               jl1.setBounds(2, 150, 138, 50);
              	jl2.setBounds(2, 200, 138, 50);
              	jl3.setBounds(2, 250, 138, 50);
              	p3.add(jl1);
              	p3. add(jl2);
              	p3. add(jl3);
        	
        	 ex.setIcon(im);
          	
        	ArrayList<String> ar=new ArrayList<>();
        	p3.setBounds(510, 0, 140, 550);
        	
            	
        	BufferedReader entree = new BufferedReader (new FileReader (filaname)) ; 
    		String str="";
    		
        	do { 
    			ligne = entree.readLine() ; 
    		   if (ligne != null) {
    			   ar.add(ligne);
    			  
    		   }
    			   
    		   } while (ligne != null) ; 
        	int j=0;
        	arr=new ArrayList<>();
     	  
     	   Pannthread p=new Pannthread(ar,name,age);
     	  
     	  add(p);
  	    Color coll=new Color(93,138,168);
     	  p3.setBackground(coll);
     	  p.setBounds(0, 0,670, 590);
     	  ex.setBounds(524, 400, 116, 40);
     	  p.add(ex);
     	 ex.addMouseListener(new MouseAdapter() {
       		public void mouseClicked(MouseEvent e) {
       			p.t.stop();
       			dispose();
       		}
       	});
     	
        	 p.add(p3);
     	  p3.setBorder(raisedbevel);
 
        	
}}
