package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

 public class PasswordManager implements  ActionListener
{
	
	//Store password class reference
    HashTablePassword data = new HashTablePassword(15,0.5F,0);
    
	JFrame f,f1,f2;
	Container con1,con2;
	JTextArea genPassArea,encryptPasswordArea,SrchArea,tNote,a;
	JButton PassGenBtn,PassEncryptBtn,PassSrchBtn,PassStoreBtn,b,PassDeleteBtn,AccAddBtn,addNote,AddNotesBtn,GetNotesBtn,DelNotesBtn;
	JLabel Acc ,Pass , addNoteLabel;
	JTextField tAcc,tPass;
	ArrayList<String> notes = new ArrayList<>(); // to store the notes in an array list of string type

	 	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	//  Frame Setting
	public static void FrameGUI(JFrame f)
	{
		f.setVisible(true);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
    }
	
	// Container Setting 
    public static void ContainerGUI(Container con1)
    {
    	con1.setVisible(true);
    	con1.setBackground( new Color(161,251,142));
    	con1.setLayout(null);
    }
    
    // Button Setting 
    public void GUIButtonsSetting(JButton btn)
    {
    	btn.setBackground(Color.LIGHT_GRAY);
    	btn.setForeground(Color.black);
    	Font f2=new Font("Arial",Font.PLAIN,15);
    	btn.setFont(f2);
    	Cursor cr=new Cursor(Cursor.HAND_CURSOR);
    	btn.setCursor(cr);
    }
    
    // GUI of store password 
    public void StoringGUI()
    {
    	f1 = new JFrame("Store your passwords");
    	f1.setBounds(1400,700,600,500);
    	f1.setSize(500,400);
    	FrameGUI(f1);
    	con2=f1.getContentPane();
    	ContainerGUI(con2);
    	Font fn= new Font ("Arial", Font.BOLD,20);
    	
    	//Account name textField and Label
    	Acc = new JLabel ("ENTER ACCOUNT NAME");
    	Acc.setBounds(100, 23, 480, 50);
    	Acc.setFont(fn);
    	con2.add(Acc);
    	
    	tAcc=new JTextField();
    	tAcc.setBounds(100,70,300,80);
    	tAcc.setFont(fn);
    	tAcc.setForeground(Color.DARK_GRAY);
    	con2.add(tAcc);
    	
    	 
    	// Account password textField and Label
    	Pass= new JLabel("ENTER ACCOUNT PASSWORD ");
    	Pass.setBounds(100, 160, 480, 50);
    	Pass.setFont(fn);
    	con2.add(Pass);
    	
    	
    	tPass = new JTextField();
    	tPass.setBounds(100, 200, 300, 80);
    	tPass.setFont(fn);
    	tPass.setForeground(Color.DARK_GRAY);
    	con2.add(tPass);
    	
    	
    	AccAddBtn =new JButton("STORE");
    	AccAddBtn.setBounds(170, 290, 150, 50);
    	con2.add(AccAddBtn);
    	GUIButtonsSetting(AccAddBtn);
    	
    }
    
    // GUI of notes
    private void NoteGUI()
    {
    	f2 = new JFrame ("Add Note");
    	f2.setSize(450,450);
    	f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	f2.setLocationRelativeTo(null);
    	f2.setLayout(null);
    	f2.setVisible(true);
    	f2.setResizable(false);
    	
    	// add note Label
    	addNoteLabel = new JLabel("ADD NOTE");
    	Font fn= new Font ("Arial", Font.BOLD,20);
    	addNoteLabel.setFont(fn);
    	addNoteLabel.setBounds(170,10,150,100);
    	f2.add(addNoteLabel);
    	
    	
    	//add note text area
    	tNote = new JTextArea(0,0);
    	tNote.setBounds(50, 100, 350, 230);
    	f2.add(tNote);

        //add note button
         addNote = new JButton("ADD NOTE");
        GUIButtonsSetting(addNote);
        addNote.setBounds(120, 380, 220, 30);
        f2.add(addNote);
    	}

    // for password generator and encryption
    public void textArea( String Pass, JTextArea T)
    {
    	T.setText(Pass);
    	Font fn = new Font("Arial", Font.BOLD, 20);
    	T.setWrapStyleWord(true);
    	T.setLineWrap(true);
    	T.setCaretPosition(0);
    	T.setEditable(false);
    	T.setFont(fn);
    }
    PasswordManager()
     {
        f = new JFrame("Password Manager");
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kartik\\Pictures\\images (1).jpg"));
        f.setBounds(300, 100, 700, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,950);
        FrameGUI(f);

        con1 = f.getContentPane();
        ContainerGUI(con1);


        //Generator buttons settings
        PassGenBtn = new JButton("GENERATE PASSWORD");
        PassGenBtn.setBounds(140, 50, 220, 70);
        con1.add(PassGenBtn);
        GUIButtonsSetting(PassGenBtn);
//----------------------------------------------------------------------------------------------------------------------
        //generating password
        PassGenBtn.addActionListener(e -> {
        if(PassGenBtn ==e.getSource())
        {
            try{
                int len = Integer.parseInt(JOptionPane.showInputDialog("Enter the password length"));
                if(len>8)
                {
                    //  password generator class reference
                    PasswordGenerator pass = new PasswordGenerator();
                    String passwd = pass.generatePsw(len);
                    genPassArea = new JTextArea(5,4);
                    textArea(passwd,genPassArea);
                    JOptionPane.showMessageDialog(con1,new JScrollPane(genPassArea),"Copy your password",JOptionPane.INFORMATION_MESSAGE);

                }
                else JOptionPane.showMessageDialog (con1,"Password length must be greater than 8!","Invalid Input Error",JOptionPane.WARNING_MESSAGE);

            }
            catch(Exception ex){JOptionPane.showMessageDialog(con1,ex.getMessage(),"EXIT!",JOptionPane.ERROR_MESSAGE);}
        }
    }
    );
//----------------------------------------------------------------------------------------------------------------------
        
      //Encryption Button
        PassEncryptBtn = new JButton("ENCRYPT PASSWORD");
        GUIButtonsSetting(PassEncryptBtn);
        PassEncryptBtn.setBounds(140, 150, 220, 70);
        con1.add(PassEncryptBtn);
        PassEncryptBtn.addActionListener(e -> {
                    if (PassEncryptBtn == e.getSource()) {
                        try {
                            String simplePasswd = JOptionPane.showInputDialog("Enter your Password");
                            if (!simplePasswd.isEmpty()) {
                                byte[] salt = PasswordEncryption.getSalt();
                                String encPass = PasswordEncryption.get_SHA_1_SecurePassword(simplePasswd, salt);
                                //txtArea adding in the panel
                                encryptPasswordArea = new JTextArea(7, 4);
                                textArea(encPass, encryptPasswordArea);
                                JOptionPane.showMessageDialog(con1, new JScrollPane(encryptPasswordArea), "Copy your Encrypted password", JOptionPane.INFORMATION_MESSAGE);
                            } else JOptionPane.showMessageDialog(con1, "Please enter password!");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(con1, ex.getMessage(), "EXIT", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );
//----------------------------------------------------------------------------------------------------------------------
        //Stored Button
        PassStoreBtn= new JButton("STORE PASSWORD");
        GUIButtonsSetting(PassStoreBtn);
        PassStoreBtn.setBounds(140, 250, 220, 70);
        con1.add(PassStoreBtn);
        PassStoreBtn.addActionListener(e-> {
        	if(PassStoreBtn==e.getSource())
        	{
        		try 
        		{
        			StoringGUI();
        			AccAddBtn.addActionListener(e1->
        			{
        				if(AccAddBtn==e1.getSource())
            			{
            				String acc_name=tAcc.getText();
            				String acc_pass=tPass.getText();
            				if(acc_name.isEmpty()&& acc_pass.isEmpty())
            				{
            					JOptionPane.showMessageDialog(con2,"Unable To  Store Your Password !","ERROR",JOptionPane.ERROR_MESSAGE);
            				}
            				else
            				{
            					data.add_Acc(acc_name,acc_pass);
            					JOptionPane.showMessageDialog(con2, "Account added Successfully !");
            					tAcc.setText(null);
            					tPass.setText(null);
            				}
            			}
        			
        			});
        		}
        		catch(Exception ex)
        		{
        			JOptionPane.showMessageDialog(con2, ex.getMessage(),"EXIT",JOptionPane.ERROR_MESSAGE);
        		}
        	}
        	
        });
//----------------------------------------------------------------------------------------------------------------------
        //Search Button
        PassSrchBtn= new JButton("SEARCH PASSWORD");
        GUIButtonsSetting(PassSrchBtn);
        PassSrchBtn.setBounds(140,350,220,70);
        con1.add(PassSrchBtn);
        PassSrchBtn.addActionListener(e-> {
        	if(PassSrchBtn==e.getSource()) {
        		try {
        			String acc_name=JOptionPane.showInputDialog("Enter Your Account Name");
        			if(!acc_name.isBlank()) {
        				Object pass=data.get_Acc(acc_name.toLowerCase());
        				if( pass != null)
        				{ 
        					SrchArea= new JTextArea(4,5);
        					textArea(String.valueOf(pass),SrchArea);
        					JOptionPane.showMessageDialog(con1, new JScrollPane(SrchArea),"Copy Your Password", JOptionPane.INFORMATION_MESSAGE);
        				}
        				else JOptionPane.showMessageDialog(con1,"Account not Found!");
        			}
        					
        		}
        		catch(Exception ex)
        		{
        			JOptionPane.showMessageDialog(con1, ex.getMessage(),"EXIT",JOptionPane.ERROR_MESSAGE);
        		}
        	}
        
        });
//----------------------------------------------------------------------------------------------------------------------
        //Delete Button
        PassDeleteBtn = new JButton("DELETE PASSWORD");
        GUIButtonsSetting(PassDeleteBtn);
        PassDeleteBtn.setBounds(140, 450, 220, 70);
        con1.add(PassDeleteBtn);
        PassDeleteBtn.addActionListener( e-> {
        	if(PassDeleteBtn == e.getSource())
        	{
        		try 
        		{
        			String acc_name = JOptionPane.showInputDialog("Enter The Account Name");
        			if(!acc_name.isBlank())
        			{
        				data.remove_Acc(acc_name.toLowerCase());
        				JOptionPane.showMessageDialog(con1,"Delete Successfully !");
        			}
        			else JOptionPane.showMessageDialog(con1,"Account not Found!", "INFO", JOptionPane.INFORMATION_MESSAGE);
        			
        		}
        		catch(Exception ex)
        		{
        			JOptionPane.showMessageDialog(con1, ex.getMessage(),"EXIT",JOptionPane.ERROR_MESSAGE);
        		}
        	}
        	
        });
//----------------------------------------------------------------------------------------------------------------------
        //AddNotes Button
        AddNotesBtn = new JButton("ADD NOTE");
        GUIButtonsSetting(AddNotesBtn);
        AddNotesBtn.setBounds(140, 550, 220, 70);
        con1.add(AddNotesBtn);
        AddNotesBtn.addActionListener(e -> {
            if (AddNotesBtn == e.getSource()) {
                try {
                    NoteGUI();
                    
					// action on the add note button
                    addNote.addActionListener(e4 -> {
                        if (addNote == e4.getSource()) {
                            String note = tNote.getText(); // getting the note
                            if (note.isEmpty()) {
                                JOptionPane.showMessageDialog(f2, "Unable To Store your Note!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else {
                               
								//calling put method of the hashtablePassword class
                                notes.add(note); // adding the note to the arrayList
                                JOptionPane.showMessageDialog(f2, "Note added Successfully !");
                                f2.setVisible(false);
                                tNote.setText(null);
                            }
                        }
                    });
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(f2, "Write something", "EXIT", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );
//----------------------------------------------------------------------------------------------------------------------
        // Get Notes Button
        GetNotesBtn= new JButton("GET NOTE");
        GUIButtonsSetting(GetNotesBtn);
        GetNotesBtn.setBounds(140, 650, 220, 70);
        con1.add(GetNotesBtn);
        GetNotesBtn.addActionListener( e -> {
        	if(GetNotesBtn == e.getSource())
        	{
        		try {
        			// getting the last note added
        			String allnotes = notes.get(notes.size()-1);
        			//  checking  if note is empty or not
        			if(allnotes.isEmpty())
        			{
        				JOptionPane.showMessageDialog(con1,"NO Note Found !", "INFO",JOptionPane.INFORMATION_MESSAGE);
        				
        			}else
        			{
        				SrchArea = new JTextArea(5,4);
        				textArea(allnotes, SrchArea);
        				JOptionPane.showMessageDialog(con1, new JScrollPane(SrchArea),"Get your note",JOptionPane.INFORMATION_MESSAGE);
        			}
        		} catch (Exception ex)
        		{
        			JOptionPane.showMessageDialog(con1, "Add a  Note Before Trying To Retrive ",ex.getMessage(),JOptionPane.ERROR_MESSAGE);
        		}
        	}
        }); 
//----------------------------------------------------------------------------------------------------------------------
        
       DelNotesBtn= new JButton("DELETE NOTE");
       GUIButtonsSetting(DelNotesBtn);
       DelNotesBtn.setBounds(140, 740, 220, 70);
       con1.add(DelNotesBtn);
        DelNotesBtn.addActionListener(e-> {
        	if(DelNotesBtn == e.getSource())
        	{
        		try {
        			// getting the last note added
        			String allnotes = notes.get(notes.size()-1);
        			//  checking  if note is empty or not
        			if(allnotes.isEmpty())
        			{
        				JOptionPane.showMessageDialog(con1," No Note Present At Time !", null, JOptionPane.INFORMATION_MESSAGE);
        				
        			}else
        			{
        				JOptionPane.showMessageDialog(con1,"Note Deleted Successfully !",allnotes, JOptionPane.INFORMATION_MESSAGE);
        			}
        		} catch (Exception ex)
        		{
        			JOptionPane.showMessageDialog(con1,"Add a  Note Before Trying To Delete ! ",null, JOptionPane.ERROR_MESSAGE, null);
        		}
        	}
        });  
        }
    public static void main(String[] args) 
    {
        //loading screen class
        new SplashScreen();
        try {
        	
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            new PasswordManager();
        }
        catch (Exception ex)
        { 
        	ex.printStackTrace(); 
        	}
 }
}
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      	
