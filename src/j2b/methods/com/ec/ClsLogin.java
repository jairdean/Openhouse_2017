package j2b.methods.com.ec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import j2b.db.com.ec.ClsMetodos;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClsLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JButton btnLogIn;
	private JPasswordField txtpassword;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsLogin frame = new ClsLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClsLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		ImageIcon iconolbl = new ImageIcon(".\\imagen\\user.png");
		ImageIcon iconolbl2 = new ImageIcon(".\\imagen\\pass.png");
		
		JLabel lblNewLabel = new JLabel(iconolbl);
		lblNewLabel.setBounds(114, 94, 44, 35);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel(iconolbl2);
		label.setBounds(114, 149, 44, 35);
		contentPane.add(label);
		
		 Border border = BorderFactory.createDashedBorder(Color.DARK_GRAY); //createLineBorder(Color.GRAY, 3);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Franklin Gothic Book", Font.BOLD | Font.ITALIC, 13));
		txtuser.setBackground(new Color(0, 0, 255));
		txtuser.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)), "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtuser.setBounds(167, 85, 172, 43);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
		
						 if (e.getKeyCode()==KeyEvent.VK_ENTER){
					            entrada();
					        }
					}
				});
				
		
		txtpassword.setBackground(new Color(30, 144, 255));
		txtpassword.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contrase\u00F1a", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtpassword.setBounds(168, 141, 172, 43);
		contentPane.add(txtpassword);
		
		
		btnLogIn = new JButton("Entrar");
		btnLogIn.setBackground(new Color(102, 205, 170));
		btnLogIn.setIcon(new ImageIcon(".\\imagen\\casa.png")); 
		btnLogIn.setRolloverIcon(new ImageIcon(".\\imagen\\casa2.png"));
		btnLogIn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 240), null, null, null));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrada();
			
			}
		});
		btnLogIn.setBounds(203, 205, 114, 35);
		contentPane.add(btnLogIn);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(".\\imagen\\mar.jpg"));
		lblNewLabel_1.setBounds(0, 0, 484, 294);
		contentPane.add(lblNewLabel_1);
		
	
		
		
	}
	//Metodo local
	public void entrada(){
		ClsMetodos obj=new ClsMetodos(); 
		
		if(txtuser.getText().equals("")|| txtpassword.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ingrese datos","ERROR",JOptionPane.ERROR_MESSAGE);
			txtuser.requestFocus();
		} else 
		if(obj.ComprobarLoguin(txtuser.getText(),txtpassword.getText())){
			System.out.println("correcto");
			setVisible(false);
		        new ClsMain().setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "error","no reconocido",JOptionPane.ERROR_MESSAGE);
			txtuser.requestFocus();
			txtuser.setText("");
			txtpassword.setText("");
		}
	}
	
}
