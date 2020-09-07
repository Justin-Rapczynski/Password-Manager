import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class helpme {

	private static SecretKeySpec secretKey;
    private static byte[] key;
    //final String secretKey = "help me";
	// String originalString = "howtodoinjava.com";
	JFrame frame;
	private JButton btnSubmit;
	private JTextField newWebsiteName2;
	private JTextField newWebsiteName1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private Scanner x;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JTextField newWebsiteName2_1;
	private JTextField newWebsiteName1_1;
	public static String ek;

	/**
	 * Launch the application.
	 */
	public static void helpmescreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helpme window = new helpme();
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
	public helpme() throws FileNotFoundException {
		initialize();

	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1039, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsername = new JLabel("Website:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 7;
		gbc_lblUsername.gridy = 5;
		frame.getContentPane().add(lblUsername, gbc_lblUsername);
		
		newWebsiteName1_1 = new JTextField();
		GridBagConstraints gbc_newWebsiteName1_1 = new GridBagConstraints();
		gbc_newWebsiteName1_1.insets = new Insets(0, 0, 5, 0);
		gbc_newWebsiteName1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_newWebsiteName1_1.gridx = 10;
		gbc_newWebsiteName1_1.gridy = 5;
		frame.getContentPane().add(newWebsiteName1_1, gbc_newWebsiteName1_1);
		newWebsiteName1_1.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Website");
		GridBagConstraints gbc_lblUsername_1 = new GridBagConstraints();
		gbc_lblUsername_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername_1.gridx = 7;
		gbc_lblUsername_1.gridy = 7;
		frame.getContentPane().add(lblUsername_1, gbc_lblUsername_1);
		
		newWebsiteName2_1 = new JTextField();
		GridBagConstraints gbc_newWebsiteName2_1 = new GridBagConstraints();
		gbc_newWebsiteName2_1.insets = new Insets(0, 0, 5, 0);
		gbc_newWebsiteName2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_newWebsiteName2_1.gridx = 10;
		gbc_newWebsiteName2_1.gridy = 7;
		frame.getContentPane().add(newWebsiteName2_1, gbc_newWebsiteName2_1);
		newWebsiteName2_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 7;
		gbc_lblPassword.gridy = 12;
		frame.getContentPane().add(lblPassword, gbc_lblPassword);
		
		passwordField_2 = new JPasswordField();
		GridBagConstraints gbc_passwordField_2 = new GridBagConstraints();
		gbc_passwordField_2.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_2.gridx = 10;
		gbc_passwordField_2.gridy = 12;
		frame.getContentPane().add(passwordField_2, gbc_passwordField_2);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword_1 = new GridBagConstraints();
		gbc_lblPassword_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_1.gridx = 7;
		gbc_lblPassword_1.gridy = 14;
		frame.getContentPane().add(lblPassword_1, gbc_lblPassword_1);
		
		passwordField_3 = new JPasswordField();
		GridBagConstraints gbc_passwordField_3 = new GridBagConstraints();
		gbc_passwordField_3.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_3.gridx = 10;
		gbc_passwordField_3.gridy = 14;
		frame.getContentPane().add(passwordField_3, gbc_passwordField_3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			new File(".").getAbsolutePath();
				String wn1 = newWebsiteName2_1.getText();
				String wn2 = newWebsiteName1_1.getText();
				@SuppressWarnings("deprecation")
				String pw1 = passwordField_2.getText();
				@SuppressWarnings("deprecation")
				String pw2 = passwordField_3.getText();


			//	writer.println(encryptedString);
				//writer.close();
		        
			
				if((wn1.contentEquals(wn2)) && (pw1.contentEquals(pw2))) {
					try {
						try {
							x = new Scanner(new File("credentials.txt"));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

						//String userdata = "7a38d8cbd20d9932ba948efaa364bb62651d5ad4 7a38d8cbd20d9932ba948efaa364bb62651d5ad4";
						while(x.hasNextLine()) {
							String test = x.nextLine();

							if(test.indexOf(FirstFrame.userdata) != -1) {
								String[] temp;
								String delimiter = " ";

								temp = test.split(delimiter);   
								ek = temp[2];
							}
						}
						

						String decryptedString = helpme.decrypt(ek, "Encryptkeytostore") ;
						final String secretKey = decryptedString;

				        String originalString = wn1;
				        String originalString1 = pw1;

				        
						String mydatafile =  new File(".").getAbsolutePath() + FirstFrame.un + ".txt"; 
						File userFile = new File(mydatafile);
						String encryptedString = AddNewWebsite.encrypt(originalString, FirstFrame.pwe) ;
						String encryptedString1 = AddNewWebsite.encrypt(originalString1, secretKey) ;
						

						
						FileWriter fw = new FileWriter(userFile, true);
						PrintWriter writer = new PrintWriter(fw);

						
						writer.println(encryptedString + " " + encryptedString1);
						writer.close();
						
						MainApplication map;
						try {
							map = new MainApplication();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						MainApplication.MainApplicationScreen();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}

						
					
				}
				else {
					JOptionPane.showMessageDialog(null,  "Website Or Passwords did NOT match. Please Try Again");
				}
			}
			});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 7;
		gbc_btnSubmit.gridy = 17;
		frame.getContentPane().add(btnSubmit, gbc_btnSubmit);

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

 public static String decrypt(String strToDecrypt, String secret) 
 {
     try
     {
         setKey(secret);
         Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
         cipher.init(Cipher.DECRYPT_MODE, secretKey);
         return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
     } 
     catch (Exception e) 
     {
         System.out.println("Error while decrypting: " + e.toString());
     }
     return null;
 }

	

	
}
