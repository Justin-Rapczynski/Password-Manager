import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;



public class FirstFrame {
	public static String un;
	public static String pwe;
	public static String userdata;
	private JFrame frame;
	private JPasswordField passwordtxt;
	private JButton btnLogin;
	private JTextField userNametxt;
	private Scanner x;
	private final Action action = new SwingAction();
	private JButton btnSignUp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame window = new FirstFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void FirstFrameScreen() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame window = new FirstFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public FirstFrame() throws FileNotFoundException {
		initcomponents();
		createEvents();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	private void initcomponents() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1651, 1084);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 3;
		frame.getContentPane().add(lblUsername, gbc_lblUsername);
		
		userNametxt = new JTextField();
		userNametxt.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_userNametxt = new GridBagConstraints();
		gbc_userNametxt.gridwidth = 3;
		gbc_userNametxt.insets = new Insets(0, 0, 5, 5);
		gbc_userNametxt.fill = GridBagConstraints.BOTH;
		gbc_userNametxt.gridx = 6;
		gbc_userNametxt.gridy = 3;
		frame.getContentPane().add(userNametxt, gbc_userNametxt);
		userNametxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.VERTICAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 8;
		frame.getContentPane().add(lblPassword, gbc_lblPassword);
				
				passwordtxt = new JPasswordField();
				passwordtxt.setFont(new Font("Tahoma", Font.PLAIN, 60));
				GridBagConstraints gbc_passwordtxt = new GridBagConstraints();
				gbc_passwordtxt.gridwidth = 3;
				gbc_passwordtxt.insets = new Insets(0, 0, 5, 5);
				gbc_passwordtxt.fill = GridBagConstraints.BOTH;
				gbc_passwordtxt.gridx = 6;
				gbc_passwordtxt.gridy = 8;
				frame.getContentPane().add(passwordtxt, gbc_passwordtxt);
				
				btnLogin = new JButton("Login");
				btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 60));
				
					GridBagConstraints gbc_btnLogin = new GridBagConstraints();
					gbc_btnLogin.fill = GridBagConstraints.VERTICAL;
					gbc_btnLogin.gridwidth = 4;
					gbc_btnLogin.gridheight = 2;
					gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
					gbc_btnLogin.gridx = 3;
					gbc_btnLogin.gridy = 14;
					frame.getContentPane().add(btnLogin, gbc_btnLogin);
					
					btnSignUp = new JButton("Sign Up");
					btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 60));
					
						GridBagConstraints gbc_btnSignUp = new GridBagConstraints();
						gbc_btnSignUp.insets = new Insets(0, 0, 0, 5);
						gbc_btnSignUp.fill = GridBagConstraints.VERTICAL;
						gbc_btnSignUp.gridwidth = 4;
						gbc_btnSignUp.gridx = 3;
						gbc_btnSignUp.gridy = 18;
						frame.getContentPane().add(btnSignUp, gbc_btnSignUp);
		
		
		
		
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String encryptThisString(String input) 
    { 
        try { 
            // getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void createEvents() throws FileNotFoundException
{
	x = new Scanner(new File("credentials.txt"));
		
	btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		un = userNametxt.getText();
		@SuppressWarnings("deprecation")
		String pw = passwordtxt.getText();
		un = encryptThisString(un);
		pw = encryptThisString(pw);
		pwe = pw;
		userdata = un + " " + pw;
		while(x.hasNextLine()) {
			System.out.println(un + " " + pw);
			String test = x.nextLine();
			System.out.println(test);
			System.out.println(test.indexOf(userdata) != -1);
			if(test.indexOf(userdata) != -1) {
				MainApplication ma;
				try {
					ma = new MainApplication();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MainApplication.MainApplicationScreen();
				

		}
		}
		}
	});
	
	 
	btnSignUp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
			newuser nw;
			try {
				nw = new newuser();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newuser.newuserscreen();
		}
	});
	




}


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}