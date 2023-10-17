package screens;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;



public class Pannthread extends JPanel{
	String ligne,str=" ",nam,phrase=" ";
	JLabel player,lb2,lb3,lb4;
	ArrayList<String> lis;
	String st;
	JPanel pp,pl,pd,p3,pp1,jp;
	int click=0,num_mot=0;
	 int con=0,index=0,score=0,index1=0,left=800;
	 Timer t;
	 JLabel  l,jl;
	 JButton bt;
	int positionx,positiony,age;
	Border raisedbevel ,loweredbevel;
	private ArrayList<JLabel> players;
	ArrayList<String> lb,a;
	private int count = 0;
	int playerIndex;
	ImageIcon im;
	Image img;
       public Pannthread(ArrayList<String> ar,String name,int age) {
    	    a=ar;
    	    nam=name;
            this.age=age;
    	    Color coll=new Color(93,138,168);
    	    Color col=new Color(223,231,237);
    	   
    	    raisedbevel=BorderFactory.createRaisedBevelBorder();
        	   loweredbevel=BorderFactory.createLoweredBevelBorder();
     	  
    	   setLayout(null);
    	   pp=new JPanel();
    	   pl=new JPanel();
     	  pd=new JPanel();
     	
     	  p3=new RoundedPanel(20,col);
     	
     	  p3.setOpaque(false);
    	   pp.setBorder(raisedbevel);
    	  pl.setBorder(raisedbevel);
    	  
    	  int j=0;
    	  
    	   bt=new JButton("Resart");
    	   add(bt);
    	   add(pp);
    	   add(pl);
    	   
    	   add(p3);
    	  
    	   p3.setBounds(520, 8, 120,90);
    	   
    	  
    	   pp.setBounds(0, 500, 448, 50);
    	   pl.setBounds(450, 500, 60, 50);
    	   lb2=new JLabel("Counter:"+Integer.toString(con));
    	   lb4=new JLabel("left :"+800);
    	   lb2.setBounds(512, 20,60, 30);
    	   lb3=new JLabel("score"+Integer.toString(score));
    	  p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
    	  p3.add(Box.createRigidArea(new Dimension(10,10)));
    	   p3.add(lb2);
    	   p3.add(Box.createRigidArea(new Dimension(0,20)));
    	   p3.add(lb4);
    	   lb2.setSize(65,30);
    	   lb4.setSize(65, 30);
    	   
    	   
    	   
    	   pl.add(lb3);
    	   pl.setBorder(raisedbevel);
    	   pl.setBackground(coll);
    	   JLabel ll=new JLabel("Phrase:");
    	   
    	   pp.add(ll);
    	   pp.setLayout(new FlowLayout());
    	   pp.setBackground(coll);
    	  
    	 
    	  startt(ar,index1);
    	  
    	  
    	  
   	 bt.setBounds(524,450,116,40);
   	 im=new ImageIcon("C:\\myprogrammes\\JeuEnJava/ico2.png");
	   
	   bt.setIcon(im);
	   bt.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			  
			   
			   count=0;
			  num_mot=0;
			  phrase="";
			   restart();
			  
		   }
	   });
	   }
      public void cancel() {
    	  t.stop();
      }
      public void startt(ArrayList<String> ar, int inde) {
    	  lb=new ArrayList<>();
    	  ArrayList<JLabel> play;
    	  
    	  if(lb.size()<ar.size()) {
    		  int j=0;
        	  for(int i=0;i<ar.get(inde).length();i++) {
        		  if(i<ar.get(inde).length()-1) {
        			  if(ar.get(inde).charAt(i)==' '&&ar.get(inde).charAt(i+1)!=' '){
          				  str=ar.get(inde).substring(j, i);
          				
          				    lb.add(str);
          				  
          				  j+=str.length()+1;
          			  }
        		  }
        		  else if(i==ar.get(inde).length()-1) {
      				 str=ar.get(inde).substring(j, i+1);
      				 lb.add(str);
      				  
      			  }
      			  
      		  }  
        	   play=new ArrayList<>(lb.size());
        	   for(int i=0;i<lb.size();i++) {
        		   player=new JLabel();
        	    	  player.setText(lb.get(i));
        		   play.add(player);
        		   
        	   }
        	   for (JLabel player : play) {
      		      add(player, new Integer(0));
      		      player.addMouseListener(new MouseAdapter() {
      		    	  public void mouseClicked(MouseEvent e) {
      		    		  click+=1;
      		    		  l=new JLabel();
      		    		l.setText(player.getText());
      		    		 // pp.add(player);
      		    		phrase+=" "+l.getText();
      		    		 pp.add(l);
      		    		 num_mot++;
      		    		 player.hide();  
      		    		  if(l.getText().compareTo(lb.get(index))==0) { 
      		    			  score+=2;
      		    			  lb3.setText("Score:"+Integer.toString(score));
      		    		  }
      		    		  else {
      		    			  score-=1;
      		    			  lb3.setText("Score:"+Integer.toString(score));
      		    		  }
      		    		  index+=1;  
      		                
      		    	  }
      		      });
      		  }
        	   t=new Timer(90,new ActionListener(){
           		   //private int count = 0;
                      private Random rnd = new Random();
               
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					// TODO int j=0;
        					 playerIndex = count % play.size();
        					JLabel pla=play.get(playerIndex);
        					
        			      
        					positionx = pla.getX();
        					positiony=pla.getY();
        			        
        					
        						
        					
        							
        							positionx+=rnd.nextInt(40)+10;
        							positiony+=rnd.nextInt(40)+10;
        							 if(positionx>400) {
        			                    	positionx-=400;
        			                    }
        							 if(positiony>400) {
        			                    	positiony-=400;
        			                    }
        							pla.setBounds(positionx, positiony, 90, 30);
        							revalidate();
        		                   
        							//repaint();
        		                    count++;
        		                  
        		                    con++;
        		                    
        		                    lb2.setText("Counter:"+Integer.toString(con));
        		                   lb4.setText("left:"+Integer.toString(--left));
        		                   if(num_mot==lb.size()) {
        		                	   cancel();
           							if(score==2*lb.size()) {
           								ScoreScreenWin f;
										try {
											f = new ScoreScreenWin(tostring(lb),phrase,nam,score,count,2*lb.size());
											f.setLocationRelativeTo(null);
											f.setVisible(true);
											 phrase=" ";
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
           							    
           							}
           							else {
           								ScoreScreenLost f;
										try {
											f = new ScoreScreenLost(tostring(lb),phrase,nam,score,count,2*lb.size());
											f.setLocationRelativeTo(null);
											f.setVisible(true);
											phrase=" ";
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
     						           
           							}
           							count=0;
           							num_mot=0;
           						}
        					if(count==800) {
        						cancel();
        						
        						
        						if(num_mot==lb.size()) {
        							if(score==2*lb.size()) {
        								ScoreScreenWin f;
										try {
											f = new ScoreScreenWin(tostring(lb),phrase,nam,score,count,2*lb.size());
											f.setLocationRelativeTo(null);
											f.setVisible(true);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
        							     
        							}
        							else {
        								ScoreScreenLost f;
										try {
											f = new ScoreScreenLost(tostring(lb),phrase,nam,score,count,2*lb.size());
											f.setLocationRelativeTo(null);
											f.setVisible(true);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
     						           
        							}
        						}
        						else {
        							ScoreScreenLost f;
									try {
										f = new ScoreScreenLost(tostring(lb),phrase,nam,score,count,2*lb.size());
										f.setLocationRelativeTo(null);
										f.setVisible(true);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
        						           
        						}
        						index=0;
        						count=0;
        						con=0;
        						phrase=" ";
        					}
        				}
          		});
        	   
           	   t.start();
           	   if(play.size()==0) {
           		   t.stop();
           		   bt.enable(false);
           		JOptionPane.showMessageDialog(null, "vous avez terminer", "Attention", 0, null);
           	   }
           	   
    	  }
    	  else {
    		  inde=0;
    		  
    		  cancel();
    		  
    		  
    	  }
    	  
      }
      public void restart() {
    	  
    	  cancel();
		   
		   index1+=1;
		   score=0;
		   index=0;
		   con=0;
		   left=800;
		   lb3.hide();
		   lb3=new JLabel("Score:"+Integer.toString(score));
		  lb4.setText(Integer.toString(left));
		   lb2.setText(Integer.toString(con));
		  
		   pl.add(lb3);
		   java.awt.Component[] componentlist=pp.getComponents();
		   for( java.awt.Component c:componentlist) {
			 
			   c.hide();
		   }
		   pp.add(new JLabel("phrase:"));
		   java.awt.Component[] componentlst=getComponents();
		   for( java.awt.Component c:componentlst) {
			   
			  
			   if(c instanceof JLabel) {
				 
				  // remove(c);
				  c.hide();
			   }
			  
		   }
		   startt(a,index1);
      }
      
      public String tostring(ArrayList<String> l) {
    	  String str="";
    	  for(int i=0;i<l.size();i++) {
    		  str+=" "+l.get(i);
    	  }   
    	  return str;
    	  }
      
      
      
       public void paintComponent(Graphics g) {
    	   super.paintComponent(g);
    	   Graphics2D g2d = (Graphics2D) g.create();
          
    	   
       }
       
}
