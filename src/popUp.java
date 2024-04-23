import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class popUp  {

	/**
	 * 
	 */
	private JFrame frmMtmb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					popUp window = new popUp();
					window.frmMtmb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// to connect your class to other class
	public void showWindow() {
		// TODO Auto-generated method stub
			JFrame frmMtmb2 = frmMtmb;
			frmMtmb2.show();
	}

	

	/**
	 * Create the application.
	 */
	public popUp() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 void initialize() {
		frmMtmb = new JFrame();
		frmMtmb.setTitle("MTMB");
		frmMtmb.setBounds(100, 100, 337, 279);
		frmMtmb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMtmb.getContentPane().setLayout(null);
		frmMtmb.setResizable(false);
		frmMtmb.getContentPane().setLayout(null);
		frmMtmb.setLocationRelativeTo(null);
		
		
		
		Font PrimaryFont = FontLoader.getFont("Primary", 30);
		Font SecondaryFont = FontLoader.getFont("Secondary", 15);
		Font PrimaryEBFont = FontLoader.getFont("PrimaryEB32", 24);
		Font SemiB = FontLoader.getFont("SemiB", 24);
		Font PrimaryEB48Font = FontLoader.getFont("PrimaryEB32", 24); // FONT SIZE 48
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 323, 232);
		frmMtmb.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(162, 10, 71, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SUCCESS");
		lblNewLabel_1.setBounds(92, 81, 210, 47);
		lblNewLabel_1.setBackground(new Color(11, 30, 51));
		lblNewLabel_1.setFont(PrimaryFont);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Added a new user!");
		lblNewLabel_2.setFont(SecondaryFont);
		lblNewLabel_2.setBackground(new Color(11, 30, 51));
		lblNewLabel_2.setBounds(92, 121, 145, 39);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MTMBLogin log = new MTMBLogin();
				log.showWindow2();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(11, 30, 51));
		btnNewButton.setFont(PrimaryEB48Font);
		btnNewButton.setBounds(10, 170, 302, 44);
		panel.add(btnNewButton);
	}


}



