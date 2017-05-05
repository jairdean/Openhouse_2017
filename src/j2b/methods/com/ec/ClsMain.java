package j2b.methods.com.ec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import j2b.db.com.ec.ClsMetodos;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;

public class ClsMain extends JFrame implements SerialPortEventListener {

	
	//Variable de conexion del Arduino
    private OutputStream output=null;
    private BufferedReader input = null;
    SerialPort serialPort;
    private final String PUERTO="COM3";
    private static final int TIMEOUT=2000; //Milisegundos
    private static final int DATA_RATE=9600;
    //Fin de las Variables
	/**
	 * 
	 */
    //OTRAS VARIABLES
    List<Boolean>t;  
    StringBuilder claveDoor = new StringBuilder();
    String comparisonClave;
    String destinatorio_mail = "jhon.cast92@gmail.com";
    List<String> asuntos;
    //FIN OTRAS VARIABLES
    
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JToggleButton tglbtnLuzExteriorOn;
	private JToggleButton tglbtnLuzPiso;
	private JToggleButton tglbtnLuzPiso_1;
	private JToggleButton tglbtnLuzGarageOff;
	private JLabel labeltemepaturaactual;
	private JTextField txtactivarac;
	int acencendido=20;
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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lbl_smarthouse;
	private JLabel lblActivarAc;
	private JLabel lblLuz;
	private JLabel lblNewLabel_4;
	private JToggleButton tglbtnLuzPiso_2;
	private JButton btnApagar;
	private JButton btnLucesOn;
	private JButton btnLucesOff;
	private JLabel label_1;
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
		setTitle("SmartHouse J2B");
		
		//Llamar al metodo IniciarConexion
		//iniciarConexion();
		//FIN
		comparisonClave = "STST";
		lecturaEmail le = new lecturaEmail();
		le.start();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 364);
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
		
		lblLuz = new JLabel("Luz");
		lblLuz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLuz.setBounds(214, 0, 58, 23);
		panel.add(lblLuz);
		
		tglbtnLuzExteriorOn = new JToggleButton("Luz exterior OFF");
		tglbtnLuzExteriorOn.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		tglbtnLuzExteriorOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzExteriorOn.isSelected()){
					tglbtnLuzExteriorOn.setText("Luz exterior ON");
					System.out.println("Luz exterior ON");
					enviarDatos("K");
				}else{
					tglbtnLuzExteriorOn.setText("Luz exterior OFF");
					System.out.println("Luz exterior OFF");
					enviarDatos("L");
				}
			}
		});
		tglbtnLuzExteriorOn.setBounds(321, 46, 149, 23);
		panel.add(tglbtnLuzExteriorOn);
		
		tglbtnLuzPiso = new JToggleButton("Luz 1 piso OFF");
		tglbtnLuzPiso.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		tglbtnLuzPiso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzPiso.isSelected()){
					tglbtnLuzPiso.setText("Luz 1 piso ON");
					System.out.println("Luz 1 piso ON");
					enviarDatos("E");
				}else{
					tglbtnLuzPiso.setText("Luz 1 piso OFF");
					System.out.println("Luz 1 piso OFF");
					enviarDatos("F");
				}
				
			}
		});
		tglbtnLuzPiso.setBounds(12, 36, 149, 23);
		panel.add(tglbtnLuzPiso);
		
		tglbtnLuzPiso_1 = new JToggleButton("Luz 2 piso OFF");
		tglbtnLuzPiso_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		
		tglbtnLuzPiso_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzPiso_1.isSelected()){
					tglbtnLuzPiso_1.setText("Luz 2 piso ON");
					System.out.println("Luz 2 piso ON");
					enviarDatos("G");
				}else{
					tglbtnLuzPiso_1.setText("Luz 2 piso OFF");
					System.out.println("Luz 2 piso OFF");
					enviarDatos("H");
				}	
			}
		});
		tglbtnLuzPiso_1.setBounds(12, 69, 149, 23);
		panel.add(tglbtnLuzPiso_1);
		
		tglbtnLuzGarageOff = new JToggleButton("Luz parking OFF");
		tglbtnLuzGarageOff.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		tglbtnLuzGarageOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnLuzGarageOff.isSelected()){
					tglbtnLuzGarageOff.setText("Luz parking ON");
					System.out.println("Luz parking ON");
					enviarDatos("P");
				}else{
					tglbtnLuzGarageOff.setText("Luz parking OFF");
					System.out.println("Luz parking OFF");
					enviarDatos("O");
				}
			}
		});
		tglbtnLuzGarageOff.setBounds(321, 82, 149, 23);
		panel.add(tglbtnLuzGarageOff);
		
		tglbtnLuzPiso_2 = new JToggleButton("Luz 3 piso OFF");
		tglbtnLuzPiso_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tglbtnLuzGarageOff.isSelected()){
					tglbtnLuzGarageOff.setText("Luz parking ON");
					System.out.println("Luz parking ON");
					enviarDatos("I");
				}else{
					tglbtnLuzGarageOff.setText("Luz parking OFF");
					System.out.println("Luz parking OFF");
					enviarDatos("J");
				}
			}
		});
		tglbtnLuzPiso_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		tglbtnLuzPiso_2.setBounds(12, 104, 149, 25);
		panel.add(tglbtnLuzPiso_2);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(".\\imagen\\luz.jpg"));
		lblNewLabel_1.setBounds(0, 0, 507, 197);
		panel.add(lblNewLabel_1);
		
		
		
		panel_1 = new JPanel();
		tabbedPane.addTab("TEMPERATURA", null, panel_1, null);
		panel_1.setLayout(null);
		
		labeltemepaturaactual = new JLabel("0'");
		labeltemepaturaactual.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labeltemepaturaactual.setBounds(10, 46, 210, 70);
		panel_1.add(labeltemepaturaactual);
		
		lblActivarAc = new JLabel("Activar AC");
		lblActivarAc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActivarAc.setForeground(Color.WHITE);
		lblActivarAc.setBounds(288, 11, 91, 24);
		panel_1.add(lblActivarAc);
		movimiento();
		
		labelac = new JLabel("24'");
		labelac.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labelac.setBounds(232, 46, 100, 70);
		panel_1.add(labelac);
		
		txtactivarac = new JTextField();
		txtactivarac.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtactivarac.setBounds(300, 47, 79, 70);
		panel_1.add(txtactivarac);
		txtactivarac.setColumns(10);
		
		JButton btnAc = new JButton("AC");
		btnAc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 0, 0), new Color(153, 0, 0), new Color(204, 0, 0), new Color(255, 0, 0)));
		
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
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(".\\imagen\\calor.jpg"));
		lblNewLabel_2.setBounds(0, 0, 507, 197);
		panel_1.add(lblNewLabel_2);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("ABRIR / CERRAR", null, panel_2, null);
		panel_2.setLayout(null);
		
		tglabrirventana = new JToggleButton("Abrir ventana OFF");
		tglabrirventana.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 0), new Color(0, 153, 0), new Color(0, 255, 0), new Color(0, 153, 51)));
		tglabrirventana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglabrirventana.isSelected()){
					tglabrirventana.setText("Abrir ventana ON");
					System.out.println("Abrir ventana ON");
					abrirVentana();
				}else{
					tglabrirventana.setText("Abrir ventana OFF");
					System.out.println("Abrir ventana OFF");
					cerrarVentana();
				}
			}
		});
		tglabrirventana.setBounds(10, 11, 150, 23);
		panel_2.add(tglabrirventana);
		
		tglbtnAbrirPuertaOff = new JToggleButton("Abrir puerta OFF");
		tglbtnAbrirPuertaOff.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 0), new Color(0, 153, 0), new Color(0, 255, 0), new Color(0, 153, 51)));
		
		tglbtnAbrirPuertaOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnAbrirPuertaOff.isSelected()){
					tglbtnAbrirPuertaOff.setText("Abrir puerta ON");
					System.out.println("Abrir puerta ON");
					abrirPuerta();
				}else{
					tglbtnAbrirPuertaOff.setText("Abrir ventana OFF");
					System.out.println("Abrir puerta OFF");
				}
				
			}
		});
		tglbtnAbrirPuertaOff.setBounds(10, 60, 150, 23);
		
		panel_2.add(tglbtnAbrirPuertaOff);
		
		tglbtnAbrirParkingOff = new JToggleButton("Abrir parking OFF");
		tglbtnAbrirParkingOff.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 0), new Color(0, 153, 0), new Color(0, 255, 0), new Color(0, 153, 51)));
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
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(new ImageIcon(".\\imagen\\verde.jpg"));
		lblNewLabel_3.setBounds(0, 0, 507, 197);
		panel_2.add(lblNewLabel_3);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("MODULO SEGURIDAD", null, panel_3, null);
		panel_3.setLayout(null);
		
		tglbtnActivarModulo = new JToggleButton("Activar modulo OFF");
		tglbtnActivarModulo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		tglbtnActivarModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/////////////////////////////////////////////
				String valida_c="";
				 JPanel panel = new JPanel(new BorderLayout(5, 5));

				    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
				    label.add(new JLabel("Clave", SwingConstants.RIGHT));
				    panel.add(label, BorderLayout.WEST);

				    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
				    JPasswordField password = new JPasswordField();
				    controls.add(password);
				    panel.add(controls, BorderLayout.CENTER);
				    JFrame frame = null;
				    JOptionPane.showMessageDialog(frame, panel, "Validar clave", JOptionPane.QUESTION_MESSAGE);
				    valida_c=password.getText();
				///////////////////////////////////
				//String valida_c=JOptionPane.showInputDialog("Validar clave");
				if(tglbtnActivarModulo.isSelected() && valida_c.equals(clave_usuario) && !valida_c.equals("") ){
					tglbtnActivarModulo.setText("Activar modulo ON");
					System.out.println("Activar modulo ON");
					//agregar aqui la sentencia para habilita los setvisible(true)
					//MetMailing.send("temp92oral@gmail.com","casaAbierta","jhon.cast92@gmail.com","hello javatpoint","How r u?");
					
					
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
		
		JButton button = new JButton("Apagar Alarma");
		button.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(283, 11, 134, 25);
		panel_3.add(button);
		
		JButton button_1 = new JButton("Clave Puerta");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comparisonClave = JOptionPane.showInputDialog("Ingrese la nueva clave MAX: 4Dig");
				comparisonClave = comparisonClave.substring(0,5);
			}
		});
		button_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		
		button_1.setBounds(283, 47, 134, 25);
		panel_3.add(button_1);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setBounds(10, 111, 56, 16);
		panel_3.add(lblEmail);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.ORANGE);
		label_1.setBounds(78, 111, 143, 16);
		label_1.setText(destinatorio_mail);
		panel_3.add(label_1);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeDestination();
			}
		});
		btnCambiar.setBounds(283, 107, 134, 25);
		btnCambiar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 204), new Color(0, 102, 204), new Color(51, 0, 204), new Color(51, 204, 204)));
		panel_3.add(btnCambiar);
		
		lblNewLabel_4 = new JLabel();
		
		lblNewLabel_4.setIcon(new ImageIcon(".\\imagen\\pp.jpg"));
		lblNewLabel_4.setBounds(0, 0, 507, 197);
		panel_3.add(lblNewLabel_4);
		
		
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("AUTOMATIZACIÓN", null, panel_4, null);
		panel_4.setLayout(null);
		
		JCheckBox l1 = new JCheckBox("Luz 1");
		l1.setBounds(8, 9, 113, 25);
		panel_4.add(l1);
		
		JCheckBox l2 = new JCheckBox("Luz 2");
		l2.setBounds(8, 39, 113, 25);
		panel_4.add(l2);
		
		JCheckBox l3 = new JCheckBox("Luz 3");
		l3.setBounds(8, 69, 113, 25);
		panel_4.add(l3);
		
		JCheckBox l4 = new JCheckBox("Luz 4");
		l4.setBounds(8, 99, 113, 25);
		panel_4.add(l4);
		
		JButton btnProgramar = new JButton("Programar ON");
		btnProgramar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				t = new ArrayList<>();
				t.add(l1.isSelected());
				t.add(l2.isSelected());
				t.add(l3.isSelected());
				t.add(l4.isSelected());
				
				programarLucesOn(t);
				
			}
		});
		btnProgramar.setBounds(360, 31, 135, 25);
		panel_4.add(btnProgramar);
		
		JButton btnProgramarOff = new JButton("Programar OFF");
		btnProgramarOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				t = new ArrayList<>();
				t.add(l1.isSelected());
				t.add(l2.isSelected());
				t.add(l3.isSelected());
				t.add(l4.isSelected());
				
				programarLucesOff(t);
			}
		});
		btnProgramarOff.setBounds(360, 69, 135, 25);
		panel_4.add(btnProgramarOff);
		
		JButton btnEncender = new JButton("Encender");
		btnEncender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = new ArrayList<>();
				t.add(l1.isSelected());
				t.add(l2.isSelected());
				t.add(l3.isSelected());
				t.add(l4.isSelected());
				
				encenderLuces(t);
				
			}
		});
		btnEncender.setBounds(8, 133, 97, 25);
		panel_4.add(btnEncender);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = new ArrayList<>();
				t.add(l1.isSelected());
				t.add(l2.isSelected());
				t.add(l3.isSelected());
				t.add(l4.isSelected());
				apagarLuces(t);
			}
		});
		btnApagar.setBounds(115, 133, 97, 25);
		panel_4.add(btnApagar);
		
		btnLucesOn = new JButton("Luces ON");
		btnLucesOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todasLucesOn();
			}
		});
		btnLucesOn.setBounds(226, 133, 97, 25);
		panel_4.add(btnLucesOn);
		
		btnLucesOff = new JButton("Luces OFF");
		btnLucesOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todasLucesOff();
			}
		});
		btnLucesOff.setBounds(335, 133, 97, 25);
		panel_4.add(btnLucesOff);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(".\\imagen\\fondo1.jpg"));
		lblNewLabel.setBounds(0, 0, 584, 491);
		contentPane.add(lblNewLabel);
		
		
	}
	
	//=================METODOS===========================================
	public void encenderLuces(List<Boolean> tluces){
		
		if(tluces.get(0)){
			enviarDatos("E");
		}

		if(tluces.get(1)){
			enviarDatos("G");
		}

		if(tluces.get(2)){
			enviarDatos("I");
		}

		if(tluces.get(3)){
			enviarDatos("K");
		}
		
	}
	

	public void apagarLuces(List<Boolean> tluces){
		
		if(tluces.get(0)){
			enviarDatos("F");
		}

		if(tluces.get(1)){
			enviarDatos("H");
		}

		if(tluces.get(2)){
			enviarDatos("J");
		}

		if(tluces.get(3)){
			enviarDatos("L");
		}
		
	}
	
	public void todasLucesOn(){
		enviarDatos("E");
		enviarDatos("G");
		enviarDatos("I");
		enviarDatos("K");
	}
	
	public void todasLucesOff(){
		
		enviarDatos("F");
		enviarDatos("H");
		enviarDatos("J");
		enviarDatos("L");
		
	}
	
	public void programarLucesOn(List<Boolean> tluces){
		
		String tempo = JOptionPane.showInputDialog("Ingrese la hora \n Ejm: 14:35");
		int mis_horas = Integer.parseInt(tempo.substring(0, 2));
		int mis_minutos = Integer.parseInt(tempo.substring(3, 5));
		timerLuces temporizadorLuces = new timerLuces(mis_horas,mis_minutos,tluces,true);
		temporizadorLuces.start();
		
	}
	

	public void programarLucesOff(List<Boolean> tluces){
		
		String tempo = JOptionPane.showInputDialog("Ingrese la hora \n Ejm: 14:35");
		int mis_horas = Integer.parseInt(tempo.substring(0, 2));
		int mis_minutos = Integer.parseInt(tempo.substring(3, 5));
		timerLuces temporizadorLuces2 = new timerLuces(mis_horas,mis_minutos,tluces,false);
		temporizadorLuces2.start();
		
	}
	
	public void abrirVentana(){
		enviarDatos("A");
	}
	
	public void cerrarVentana(){
		enviarDatos("A");
	}
	
	public void abrirPuerta(){
		enviarDatos("A");
	}
	
	public void clavePuerta(){
		
	}
	
	public void changeDestination(){
		destinatorio_mail = JOptionPane.showInputDialog("Ingresar nuevo Email Destinatario");
		label_1.setText(destinatorio_mail);
	}
	
	//============================== H I L O ==================================================
	
	public void movimiento(){
		hilado mihilo2 = new hilado();
		mihilo2.start();
	}
	public class hilado extends Thread{
		public void run(){
			boolean t = true;
			int x=0,y=0;
			do {
				lblActivarAc.setBounds(-50+x, 11, 260, 14);//su borde seteado es: (288, 11, 71, 14);
				lblLuz.setBounds(-50+x, 11, 260, 14);//su borde seteado es: (214, 0, 58, 23);;
				x=x+2;
				y++;
				if(x>550){
					x=0;
				}
				if(y>170){
					y=0;
				}
				try {
					sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} while (t);
			
		}
		
	}
	
	public class Temperatura extends Thread{
		
		private String temp;
		
		public Temperatura(String temp){
			this.temp = temp;
		}
		
		public void run(){
			mostrar_Temperatura();
			double temp_actual = Double.parseDouble(temp.substring(0, 5));
			encenderVentilador(temp_actual);
		}
		
		public void mostrar_Temperatura(){
			labeltemepaturaactual.setText(temp);	
		}
		
		public void encenderVentilador(double actual_temp){
			
			if (actual_temp >= acencendido){
				enviarDatos("Q");
			}else{
				enviarDatos("R");
			}
			
		}
		
	}
	

	public class timerLuces extends Thread{
		
		private int hora,minuto;
		private List<Boolean>tluces;
		private boolean opcionON;
		
		public timerLuces(int hora, int minuto,List<Boolean> tluces,boolean opcionOn){
			this.hora = hora;
			this.minuto = minuto;
			this.tluces = tluces;
			this.opcionON = opcionOn;
		}
		
		public void run(){
			
			int hora_actual;
			int minuto_actual;
			
			
			while(true){
				Date date = new Date();
				hora_actual = date.getHours();
				minuto_actual = date.getMinutes();
				System.out.println(hora_actual+":"+minuto_actual);
				
				if(hora == hora_actual && minuto == minuto_actual){
					
					System.out.println("Timer Logrado enviar datos");
					
					if(opcionON){
						if(tluces.get(0)){
							enviarDatos("E");
						}

						if(tluces.get(1)){
							enviarDatos("G");
						}

						if(tluces.get(2)){
							enviarDatos("I");
						}

						if(tluces.get(3)){
							enviarDatos("K");
						}
					}else{
						if(tluces.get(0)){
							enviarDatos("F");
						}

						if(tluces.get(1)){
							enviarDatos("H");
						}

						if(tluces.get(2)){
							enviarDatos("J");
						}

						if(tluces.get(3)){
							enviarDatos("L");
						}
					}
					
					
					
					this.stop();
				}
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	
	public class lecturaEmail extends Thread{
		
		public void run(){
			
			
			while(true){
				asuntos = new ArrayList<>();
				asuntos = MetMailing.receiveEmail("pop.gmail.com", "pop3", "temp92oral@gmail.com", "casaAbierta");
				for (String asunto : asuntos) {
					String[] parts = asunto.split("-");
					for (String part : parts) {
						System.out.println(part);
						//generarComando(part);
					}
					
				}
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		public void generarComando(String comando){
			switch(comando){
			
				case "LIGHTS OFF":
					todasLucesOff();
				break;
				
				case "LIGHTS ON":
					todasLucesOn();
					break;
					
				case "L1 OFF":
					enviarDatos("F");
					break;
					
				case "L2 OFF":
					enviarDatos("H");
					break;
					
				case "L3 OFF":
					enviarDatos("J");
					break;
					
				case "L4 OFF":
					enviarDatos("L");
					break;
					
				case "L1 ON":
					enviarDatos("E");
					break;
					
				case "L2 ON":
					enviarDatos("G");
					break;
					
				case "L3 ON":
					enviarDatos("I");
					break;
					
				case "L4 ON":
					enviarDatos("K");
					break;
					
				case "D OPEN":
					
					break;
					
				case "W OPEN":
					
					break;
					
				case "W CLOSE":
					
					break;
					
				case "SEC ON":
					
					break;
					
				case "SEC OFF":
					
					break;
							
				default:
						
					break;
			}
		}
		
	}
	
	// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		// =================================== ARDUINO ===================================================
		//INICIO CODIGO ARDUINO
	public void iniciarConexion(){
		 CommPortIdentifier puertoID=null;
	        Enumeration puertoEnum=CommPortIdentifier.getPortIdentifiers();
	        
	        while(puertoEnum.hasMoreElements()){
	            CommPortIdentifier actualPuertoID=(CommPortIdentifier) puertoEnum.nextElement();
	            if(PUERTO.equals(actualPuertoID.getName())){
	                puertoID=actualPuertoID;
	                break;
	            }
	        }
	        
	        if(puertoID==null){
	            mostrarError("No se puede conectar al puerto");
	            //System.exit(ERROR);
	            System.exit(0);
	        }
	        
	        try{
	            serialPort = (SerialPort) puertoID.open(this.getClass().getName(), TIMEOUT);
	            //Parámetros puerto serie
	            
	            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	            
	            output = serialPort.getOutputStream();
	            input =  new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
	            serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
	            System.out.println("Exito");
	        } catch(Exception e){
	            mostrarError(e.getMessage());
	            //System.exit(ERROR);
	            System.exit(0);
	            
	        }
	        
	        
	}
	
  public void enviarDatos(String datos){
      try{
   	   System.out.println("Dato a enviar "+datos);
          output.write(datos.getBytes());
          //System.out.println(input.readLine());
      } catch(Exception e){
          mostrarError("ERROR");
          //System.exit(ERROR);
          System.exit(0);
      }
  }  
  
  public void enviarDatos(int datos){
      try{
   	   
          output.write(datos);
      } catch(Exception e){
          mostrarError("ERROR");
          //System.exit(ERROR);
          System.exit(0);
      }
  }  
  
  public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=input.readLine();
				if(inputLine.equalsIgnoreCase("fotocelda activa")){
					
				}
				System.out.println(inputLine);
				
				if(inputLine.length()==7 && inputLine.substring(6,7).equals("C")){
					/*Temperatura t = new Temperatura(inputLine);
					t.start();*/
				}
				
				if(inputLine.substring(0, 1).equals("S") || inputLine.substring(0, 1).equals("T")){
					String letra = inputLine.substring(0, 1);
					System.out.println("Entro a la parte de la clave "+letra);
					claveDoor.append(letra);
					if(claveDoor.length()==4){
						if(claveDoor.equals(comparisonClave)){
							abrirPuerta();
						}else{
							MetMailing.send("temp92oral@gmail.com","casaAbierta","jhon.cast92@gmail.com","Seguridad Forzada","Han colocado mal su clave en la puerta");
						}
						claveDoor = new StringBuilder();
					}
				}
				
				
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}

  
  public void mostrarError(String mensaje){
      System.out.println(mensaje+ "Error");
  }
  
  public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}
}