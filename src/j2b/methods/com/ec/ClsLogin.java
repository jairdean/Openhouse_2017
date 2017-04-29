package j2b.methods.com.ec;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import j2b.db.com.ec.ClsMetodos;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClsLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JTextField txtpassword;
	private JButton btnLogIn;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBounds(188, 100, 86, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(188, 131, 86, 20);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClsMetodos obj=new ClsMetodos(); 
				
				if(obj.ComprobarLoguin(txtuser.getText(),txtpassword.getText())){
					System.out.println("correcto");
				}else{
					JOptionPane.showMessageDialog(null, "error","no reconocido",JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnLogIn.setBounds(188, 182, 89, 23);
		contentPane.add(btnLogIn);
	}
}
