package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SplashScreen 
{
  JFrame jf;
  JLabel img=new JLabel(new ImageIcon("C:\\Users\\Kartik\\Pictures\\images (1).jpg"));
  JLabel text=new JLabel("PASSWORD MANAGER");
  JLabel text1=new JLabel("Developer By VAISHNAVI GUPTA");
  JProgressBar progressBar=new JProgressBar()		;
  JLabel message=new JLabel();
 SplashScreen()
	{
		createGUI();
		addImage();
		addText();
		addProgressBar();
		addMessage();
		addTitle();
		runningPBar();
		
	}
 public void createGUI()
 {
	 jf=new JFrame();
	 jf.getContentPane().setLayout(null);
	 jf.setUndecorated(true);
	 jf.setSize(500,400);
	 jf.setLocationRelativeTo(null);
	 jf.getContentPane().setBackground( new Color(102,232,145));
	 jf.setVisible(true);
	 
	 
 }
 
public void addImage() 
 {
	 img.setSize(200,100);
     img.setBounds(140,100, 200, 100);
     jf.add(img);
 }
 public void addText()
 {
	 text.setFont(new Font("arial",Font.BOLD,30));
	 text.setBounds(80,190,450,100);
	 text.setForeground(Color.orange);
	 jf.add(text);
 }
 
 public void addProgressBar()
 {
	 progressBar.setBounds(100, 270, 300, 35);
	 progressBar.setBorderPainted(true);
	 progressBar.setStringPainted(true);
	 progressBar.setBackground(Color.black);
	 progressBar.setForeground(Color.orange);
	 progressBar.setValue(0);
	 jf.add(progressBar);
 }
	 
 public void addMessage()
 {
	 message.setBounds(180,310,200,40);
	 message.setForeground( new Color(217,44,96));
	 message.setFont(new Font("arial",Font.BOLD,20));
	 jf.add(message);
 }
 public void addTitle()
 {
	
	 text1.setFont(new Font("arial",Font.BOLD,20));
	 text1.setBounds(20,250,450,250);
	 text1.setForeground( new Color(212,117,213));
	 jf.add(text1);
 }
 public void runningPBar()
 {
	int i=0;
	while(i<=100)
	{
		try
		{
			Thread.sleep(40);
			progressBar.setValue(i);
			message.setText("LOADING....(" + (i) +"%)");
			i++;
			if(i==100)
			jf.dispose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 }
			
 }
	
 


	
	



