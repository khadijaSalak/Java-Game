package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ScoreScreenWin extends JFrame{
	JPanel p;
	JButton bt1;
	JLabel lb1,lb2,lb3,lb4;
	ImageIcon im;
	Image img;
	String ligne;
	
	ArrayList<Float> array;
	ArrayList<String>  array2;
       ScoreScreenWin(String str1,String str2,String str3,int score,int con,int size) throws IOException{
    	   super("Votre Score");
    	   setSize(800,500);
    	   im=new ImageIcon("C:\\myprogrammes/JeuEnJava/src/win.jpg");
    	   img=im.getImage();
    	   p=new DrawImgPanel(im);
    	   array=new ArrayList<>();
    	   array2=new ArrayList<>();
    	   
    	   getContentPane().add(p);
    	   
    	   try {
				File file=new File("score");
				FileWriter fw;
				fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw=new BufferedWriter(fw);
				
			      bw.write(str3+":"+Integer.toString(score)+"/"+Integer.toString(size));
			      bw.write("\n");
			      bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   	   BufferedReader entree = new BufferedReader (new FileReader ("score")) ; 
     		do { 
     			ligne = entree.readLine() ; 
     			
     			
     		   if (ligne != null) {
     			   String st="";
     			 for(int i=0;i<ligne.length();i++) {
      				if(ligne.charAt(i)==':') {
      					
      					int j=i+1;
      					    while(ligne.charAt(j)!='/'&&j<ligne.length()) {
      							st+=ligne.charAt(j);
      							j++;
      							if(ligne.charAt(j)=='/') {
      								
      								array2.add(st+"/"+ligne.substring(j+1));
      								
      								array.add((float)(Integer.parseInt(st)/Integer.parseInt(ligne.substring(j+1))));
      								
      							}
      							
      							
      						}
      					}
      					
  
     		   } 
     		   }} while (ligne != null) ; 
     		entree.close () ;
      		p.setBackground(Color.white);
     	   lb1=new JLabel("congratulitions u are winner!!");
     	   lb3=new JLabel("Yeah! the sentence is:\""+str2+"\"");
     	  lb2=new JLabel("your score: "+score+"/"+size);
      	   
      	   lb4=new JLabel("best Score: "+array2.get(maximum(array)));
       	    bt1=new JButton("Ok");
       	    p.setLayout(null);
       	    p.add(lb1);
       	    lb1.setBounds(260,50,280,20);
       	    p.add(lb3);
       	    lb3.setBounds(300, 180, 520, 20);
       	    p.add(lb2);
       	    
       	    lb2.setBounds(320,260,130,30);
       	    p.add(lb4);
       	    lb4.setBounds(320,290,130,20);
       	    p.add(bt1);
       	    bt1.setBounds(330,340,70,30);
       	     bt1.addMouseListener(new MouseAdapter() {
       	    	 public void mouseClicked(MouseEvent e) {
       	    		dispose();
       	    	 }
       	     });
          }
   	  public int maximum(ArrayList<Float> ar) {
      	   float max=ar.get(0);
      	   int indexmax=1;
      	   for(int i=0;i<ar.size();i++) {
      		   if(max<ar.get(i)) {
      			   max=ar.get(i);
      			   indexmax=i;
      		   }
      	   }
      	   return indexmax;
         }
}
