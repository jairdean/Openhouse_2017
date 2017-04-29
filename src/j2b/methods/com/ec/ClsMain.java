package j2b.methods.com.ec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import j2b.db.com.ec.ClsMetodos;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClsMain extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnLuzExteriorOn;
	private JToggleButton tglbtnLuzPiso;
	private JToggleButton tglbtnLuzPiso_1;
	private JToggleButton tglbtnLuzGarageOff;
	private JLabel labeltemepaturaactual;
	private JTextField txtactivarac;
	int acencendido=24;
	private JLabel labelac;
	private JPanel panel_2;
	private JPanel panel_1;
	private JPanel panel;
	private JToggleButton tglabrirventana;
	private JToggleButton tglbtnAbrirPuertaOff;
	private JToggleButton tglbtnAbrirParkingOff;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JToggleButton tglbtnActivarModulo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsMain frame = new ClsMain("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param clave_usuario 
	 */
	public ClsMain(String clave_usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 37, 512, 225);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("LUZ HOGAR", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblLuz = new JLabel("Luz");
		lblLuz.setBounds(214, 0, 46, 14);
		panel.add(lblLuz);
		
		tglbtnLuzExteriorOn = new JToggleButton("Luz exterior OFF");
		tglbtnLuzExteriorOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzExteriorOn.isSelected()){
					tglbtnLuzExteriorOn.setText("Luz exterior ON");
					System.out.println("Luz exterior ON");
				}else{
					tglbtnLuzExteriorOn.setText("Luz exterior OFF");
					System.out.println("Luz exterior OFF");
				}
			}
		});
		tglbtnLuzExteriorOn.setBounds(10, 11, 149, 23);
		panel.add(tglbtnLuzExteriorOn);
		
		tglbtnLuzPiso = new JToggleButton("Luz 1 piso OFF");
		tglbtnLuzPiso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzPiso.isSelected()){
					tglbtnLuzPiso.setText("Luz 1 piso ON");
					System.out.println("Luz 1 piso ON");
				}else{
					tglbtnLuzPiso.setText("Luz 1 piso OFF");
					System.out.println("Luz 1 piso OFF");
				}
				
			}
		});
		tglbtnLuzPiso.setBounds(10, 72, 149, 23);
		panel.add(tglbtnLuzPiso);
		
		tglbtnLuzPiso_1 = new JToggleButton("Luz 2 piso OFF");
		tglbtnLuzPiso_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzPiso_1.isSelected()){
					tglbtnLuzPiso_1.setText("Luz 2 piso ON");
					System.out.println("Luz 2 piso ON");
				}else{
					tglbtnLuzPiso_1.setText("Luz 2 piso OFF");
					System.out.println("Luz 2 piso OFF");
				}	
			}
		});
		tglbtnLuzPiso_1.setBounds(321, 11, 149, 23);
		panel.add(tglbtnLuzPiso_1);
		
		tglbtnLuzGarageOff = new JToggleButton("Luz parking OFF");
		tglbtnLuzGarageOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzGarageOff.isSelected()){
					tglbtnLuzGarageOff.setText("Luz parking ON");
					System.out.println("Luz parking ON");
				}else{
					tglbtnLuzGarageOff.setText("Luz parking OFF");
					System.out.println("Luz parking OFF");
				}
			}
		});
		tglbtnLuzGarageOff.setBounds(321, 72, 149, 23);
		panel.add(tglbtnLuzGarageOff);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("TEMPERATURA", null, panel_1, null);
		panel_1.setLayout(null);
		
		labeltemepaturaactual = new JLabel("0'");
		labeltemepaturaactual.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labeltemepaturaactual.setBounds(10, 46, 100, 70);
		panel_1.add(labeltemepaturaactual);
		
		JLabel lblActivarAc = new JLabel("Activar AC");
		lblActivarAc.setBounds(288, 11, 71, 14);
		panel_1.add(lblActivarAc);
		
		labelac = new JLabel("24'");
		labelac.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labelac.setBounds(190, 46, 100, 70);
		panel_1.add(labelac);
		
		txtactivarac = new JTextField();
		txtactivarac.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtactivarac.setBounds(300, 47, 79, 70);
		panel_1.add(txtactivarac);
		txtactivarac.setColumns(10);
		
		JButton btnAc = new JButton("AC");
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(!txtactivarac.getText().equals("")){
				acencendido=Integer.parseInt(txtactivarac.getText());
				labelac.setText(""+acencendido+"'");
				txtactivarac.setText("");
				}else{
					e.getSource();
				}
			}
		});
		btnAc.setBounds(420, 46, 65, 70);
		panel_1.add(btnAc);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("ABRIR / CERRAR", null, panel_2, null);
		panel_2.setLayout(null);
		
		tglabrirventana = new JToggleButton("Abrir ventana OFF");
		tglabrirventana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglabrirventana.isSelected()){
					tglabrirventana.setText("Abrir ventana ON");
					System.out.println("Abrir ventana ON");
				}else{
					tglabrirventana.setText("Abrir ventana OFF");
					System.out.println("Abrir ventana OFF");
				}
			}
		});
		tglabrirventana.setBounds(10, 11, 150, 23);
		panel_2.add(tglabrirventana);
		
		tglbtnAbrirPuertaOff = new JToggleButton("Abrir puerta OFF");
		tglbtnAbrirPuertaOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnAbrirPuertaOff.isSelected()){
					tglbtnAbrirPuertaOff.setText("Abrir puerta ON");
					System.out.println("Abrir puerta ON");
				}else{
					tglbtnAbrirPuertaOff.setText("Abrir ventana OFF");
					System.out.println("Abrir puerta OFF");
				}
				
			}
		});
		tglbtnAbrirPuertaOff.setBounds(10, 60, 150, 23);
		panel_2.add(tglbtnAbrirPuertaOff);
		
		tglbtnAbrirParkingOff = new JToggleButton("Abrir parking OFF");
		tglbtnAbrirParkingOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnAbrirParkingOff.isSelected()){
					tglbtnAbrirParkingOff.setText("Abrir parking ON");
					System.out.println("Abrir parking ON");
				}else{
					tglbtnAbrirParkingOff.setText("Abrir parking OFF");
					System.out.println("Abrir parking OFF");
				}
				
			}
		});
		tglbtnAbrirParkingOff.setBounds(240, 11, 150, 23);
		panel_2.add(tglbtnAbrirParkingOff);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("MODULO SEGURIDAD", null, panel_3, null);
		panel_3.setLayout(null);
		
		tglbtnActivarModulo = new JToggleButton("Activar modulo OFF");
		tglbtnActivarModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valida_c=JOptionPane.showInputDialog("Validar clave");
				if(tglbtnActivarModulo.isSelected() && valida_c.equals(clave_usuario) && !valida_c.equals("") ){
					tglbtnActivarModulo.setText("Activar modulo ON");
					System.out.println("Activar modulo ON");
				}else{
					JOptionPane.showMessageDialog(null, "EROR","Clave incorrecta",JOptionPane.ERROR_MESSAGE);
					tglbtnActivarModulo.setSelected(false);
					tglbtnActivarModulo.setText("Activar modulo OFF");
					System.out.println("Activar modulo OFF");
				}
			}
		});
		tglbtnActivarModulo.setBounds(10, 11, 149, 23);
		panel_3.add(tglbtnActivarModulo);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(".\\imagen\\fondo1.jpg"));
		lblNewLabel.setBounds(0, 0, 584, 491);
		contentPane.add(lblNewLabel);
	}
}
