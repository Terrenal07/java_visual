package visual_28042023_windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField txtCuando;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 49, 146, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCuando = new JTextField();
		txtCuando.setText("cuando");
		txtCuando.setBounds(5, 5, 131, 39);
		panel.add(txtCuando);
		txtCuando.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("patata");
		lblNewLabel.setBounds(55, 55, 46, 14);
		panel.add(lblNewLabel);
		
		JButton lodudo = new JButton("si, por favor");
		lodudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(txtCuando.getText());
			}
		});
		lodudo.setBounds(10, 81, 126, 23);
		panel.add(lodudo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(216, 49, 173, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 11, 153, 22);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("conectar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//registrar conector
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String cadena="jdbc:mysql://localhost/test";
					Connection conn=DriverManager.getConnection(cadena, "root", "");
					//lblNewLabel_1.setText(conn.toString());
					
					//consulta. create, update, delete CRUD
					PreparedStatement ps=conn.prepareStatement("select * from clientes");
					ResultSet rs=ps.executeQuery();
					//lblNewLabel_1.setText(rs.toString());
					String msj="";
					while(rs.next()) {
						 msj+=rs.getString(2);
						 
					}
					lblNewLabel_1.setText(msj);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(39, 37, 89, 23);
		panel_1.add(btnNewButton);
	}
}
