import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.swing.JPasswordField;
import java.awt.Font;
public class newuser {

	private static SecretKeySpec secretKey;
    private static byte[] key;
	JFrame frame;
	public static String un1e;
	private JButton btnSubmit;
	private JTextField newUserName2;
	private JTextField newUserName1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private Scanner x;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void newuserscreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newuser window = new newuser();
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
	public newuser() throws FileNotFoundException {
		initialize();
		createEvents();
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEvents() throws FileNotFoundException
	{
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			new File(".").getAbsolutePath();
				String un1 = newUserName1.getText();
				String un2 = newUserName2.getText();
				@SuppressWarnings("deprecation")
				String pw1 = passwordField.getText();
				@SuppressWarnings("deprecation")
				String pw2 = passwordField_1.getText();
				String un1e = encryptThisString(un1);
				String pw1e = encryptThisString(pw1);
				String un2e = encryptThisString(un2);
				String encryptkey = textField.getText();
				final String secretKey = "Encryptkeytostore";
				String encryptedString1 = newuser.encrypt(encryptkey, secretKey) ;
				System.out.println(encryptedString1);
				int isAvailable = 0;
				try {
					x = new Scanner(new File("credentials.txt"));
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				while(x.hasNextLine()) {
					String test = x.nextLine();
					if(test.indexOf(un1e) != -1 && test.indexOf(un2e) != -1 ) { 
						isAvailable = isAvailable + 1;
						System.out.println(isAvailable);
					}
				}
				
				
				PrintWriter writer = null;
				if((un1.contentEquals(un2)) && (pw1.contentEquals(pw2) && (isAvailable == 0))) {
					try {
						FileWriter fw = new FileWriter("credentials.txt", true);
					 writer = new PrintWriter(fw);
						
					 
					} catch (IOException e1) {
						e1.printStackTrace();
					}

						
				
					
					writer.println(un1e + " " + pw1e + " " + encryptedString1 );
					writer.close();
					String mydatafile =  new File(".").getAbsolutePath() + un1e + ".txt"; 
					File userFile = new File(mydatafile);
					try {
						userFile.createNewFile();
						FileWriter fw1 = new FileWriter(mydatafile, true);
						writer = new PrintWriter(fw1);
						
						writer.println(un1e + " " + pw1e   );
						writer.close();
						System.out.println(userFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					FirstFrame ff;
					try {
						ff = new FirstFrame();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					FirstFrame.FirstFrameScreen();
					
				}
				else if (isAvailable >= 1) {
					JOptionPane.showMessageDialog(null, "The Username you have choosen is already taken");
				}
				else {
					JOptionPane.showMessageDialog(null,  "Username Or Passwords did NOT match. Please Try Again");
				}
			}
			});
		
		
		
	}

	public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1039, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 3;
		frame.getContentPane().add(lblUsername, gbc_lblUsername);
		
		newUserName1 = new JTextField();
		newUserName1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_newUserName1 = new GridBagConstraints();
		gbc_newUserName1.gridwidth = 9;
		gbc_newUserName1.insets = new Insets(0, 0, 5, 0);
		gbc_newUserName1.fill = GridBagConstraints.HORIZONTAL;
		gbc_newUserName1.gridx = 2;
		gbc_newUserName1.gridy = 3;
		frame.getContentPane().add(newUserName1, gbc_newUserName1);
		newUserName1.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblUsername_1 = new GridBagConstraints();
		gbc_lblUsername_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername_1.gridx = 1;
		gbc_lblUsername_1.gridy = 5;
		frame.getContentPane().add(lblUsername_1, gbc_lblUsername_1);
		
		newUserName2 = new JTextField();
		newUserName2.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_newUserName2 = new GridBagConstraints();
		gbc_newUserName2.gridwidth = 9;
		gbc_newUserName2.insets = new Insets(0, 0, 5, 0);
		gbc_newUserName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_newUserName2.gridx = 2;
		gbc_newUserName2.gridy = 5;
		frame.getContentPane().add(newUserName2, gbc_newUserName2);
		newUserName2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 8;
		frame.getContentPane().add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 9;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 8;
		frame.getContentPane().add(passwordField, gbc_passwordField);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblPassword_1 = new GridBagConstraints();
		gbc_lblPassword_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_1.gridx = 1;
		gbc_lblPassword_1.gridy = 11;
		frame.getContentPane().add(lblPassword_1, gbc_lblPassword_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.gridwidth = 9;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 2;
		gbc_passwordField_1.gridy = 11;
		frame.getContentPane().add(passwordField_1, gbc_passwordField_1);
		
		lblNewLabel = new JLabel("Encryption Key");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 13;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 9;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 13;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridheight = 3;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 15;
		frame.getContentPane().add(btnSubmit, gbc_btnSubmit);
	}

}





