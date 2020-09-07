import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class revealPassword {

	private static SecretKeySpec secretKey;
    private static byte[] key;
	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAddWebsite;
	private JButton btnRevealPassword;
	private JTextField textField;
	private JLabel lblEncryptionKey;
	public static String ek;
	private Scanner x1;

	/**
	 * Launch the application.
	 */
	public static void revealPasswordScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					revealPassword window = new revealPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public revealPassword() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
	
	
	
	
	
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1651, 1084);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		lblEncryptionKey = new JLabel("Encryption Key:");
		lblEncryptionKey.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_lblEncryptionKey = new GridBagConstraints();
		gbc_lblEncryptionKey.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncryptionKey.anchor = GridBagConstraints.EAST;
		gbc_lblEncryptionKey.gridx = 7;
		gbc_lblEncryptionKey.gridy = 0;
		frame.getContentPane().add(lblEncryptionKey, gbc_lblEncryptionKey);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 8;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnAddWebsite = new JButton("Add Website");
		
		btnAddWebsite.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_btnAddWebsite = new GridBagConstraints();
		gbc_btnAddWebsite.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddWebsite.gridx = 1;
		gbc_btnAddWebsite.gridy = 1;
		frame.getContentPane().add(btnAddWebsite, gbc_btnAddWebsite);
		
		btnRevealPassword = new JButton("Hide Password");
		btnRevealPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRevealPassword.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GridBagConstraints gbc_btnRevealPassword = new GridBagConstraints();
		gbc_btnRevealPassword.gridwidth = 2;
		gbc_btnRevealPassword.insets = new Insets(0, 0, 5, 5);
		gbc_btnRevealPassword.gridx = 7;
		gbc_btnRevealPassword.gridy = 1;
		frame.getContentPane().add(btnRevealPassword, gbc_btnRevealPassword);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Website", "Password"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		
		String filePath = new File(".").getAbsolutePath() + FirstFrame.un + ".txt";
        File file = new File(filePath);
        
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(" ");
            DefaultTableModel model = (DefaultTableModel)table.getModel();

            try {
				x1 = new Scanner(new File("credentials.txt"));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			//String userdata = "7a38d8cbd20d9932ba948efaa364bb62651d5ad4 7a38d8cbd20d9932ba948efaa364bb62651d5ad4";
			while(x1.hasNextLine()) {
				String test = x1.nextLine();

				if(test.indexOf(FirstFrame.userdata) != -1) {
					String[] temp;
					String delimiter = " ";

					temp = test.split(delimiter);   
					ek = temp[2];
				}
			}
			

			String decryptedString = helpme.decrypt(ek, "Encryptkeytostore") ;
			final String secretKey = decryptedString;

            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] temp;
				String delimiter = " ";

				temp = line.split(delimiter);   
				String line2 = temp[0];
                String line3 = temp[1];
                String decryptedString1 = MainApplication.decrypt(line2, FirstFrame.pwe) ;
                String decryptedString12 = MainApplication.decrypt(line3, secretKey) ;
                String line4 = decryptedString1 + " " + decryptedString12;
                System.out.println(line);
                System.out.println(line4);
                String[] dataRow = line4.split(" ");
                //System.out.println(dataRow[0]);
                //System.out.println(dataRow[1]);
                model.addRow(dataRow);
            }
            
            

	
	
	scrollPane.setViewportView(table);
	}

}