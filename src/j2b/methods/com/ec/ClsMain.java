package j2b.methods.com.ec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ClsMain extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnLuzExteriorOn;
	private JToggleButton tglbtnLuzPiso;
	private JToggleButton tglbtnLuzPiso_1;
	private JToggleButton tglbtnLuzGarageOff;
	private JLabel labeltemepaturaactual;
	private JTextField txtactivarac;
	int acencendido=45;
	private JLabel labelac;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClsMain frame = new ClsMain();
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
	public ClsMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 37, 512, 225);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
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
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("TEMPERATURA", null, panel_1, null);
		panel_1.setLayout(null);
		
		labeltemepaturaactual = new JLabel("0'");
		labeltemepaturaactual.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labeltemepaturaactual.setBounds(10, 46, 100, 70);
		panel_1.add(labeltemepaturaactual);
		
		JLabel lblActivarAc = new JLabel("Activar AC");
		lblActivarAc.setBounds(288, 11, 71, 14);
		panel_1.add(lblActivarAc);
		
		labelac = new JLabel("45'");
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
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("panel_2", null, panel_2, null);
		panel_2.setLayout(null);
	}
}
