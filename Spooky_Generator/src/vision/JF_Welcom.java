package vision;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class JF_Welcom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) throws IOException {
		EventQueue.invokeLater(() -> {
			try {
				JF_Welcom frame = new JF_Welcom();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JF_Welcom() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 498, 245);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(0, 0, 0));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);

		JLabel lblWelcomeStranger = new JLabel("Welcome, stranger.");
		lblWelcomeStranger.setForeground(new Color(153, 0, 0));
		lblWelcomeStranger.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeStranger.setFont(new Font("Frank Ruehl CLM", Font.BOLD | Font.ITALIC, 26));

		JButton btnCreepMeOut = new JButton("Give me the creeps!");
		btnCreepMeOut.setBackground(Color.LIGHT_GRAY);
		btnCreepMeOut.setForeground(new Color(153, 0, 0));
		btnCreepMeOut.setFont(new Font("Frank Ruehl CLM", Font.BOLD | Font.ITALIC, 14));
		btnCreepMeOut.addActionListener(e -> {
			JPanel n = null;
			try {
				n = new Msg();
				n.setBounds(100, 100, 360, 245);
				n.setBorder(new EmptyBorder(5, 5, 5, 5));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JF_Welcom.this.contentPane.setVisible(false);
			this.setContentPane(n);
			n.setVisible(true);
		});
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(76)
						.addComponent(btnCreepMeOut, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addGap(80))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblWelcomeStranger, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(29)
						.addComponent(lblWelcomeStranger, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnCreepMeOut, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addGap(64))
				);
		this.contentPane.setLayout(gl_contentPane);
	}


	public String showSpookyMessage () throws IOException {
		FileInputStream fs= new FileInputStream("/Users/beatr/Documents/UFABC/QUAD 2019.2/P.O.O/Spooky_Generator/spoopy.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		ArrayList<String> array = new ArrayList<>();
		String line;


		while((line = br.readLine()) != null) {
			array.add(line);
		}
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is exclusive. Should be good with output for array.
		int randomIndex = rand.nextInt(array.size());

		br.close();

		return array.get(randomIndex);
	}
}
