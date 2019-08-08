package vision;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Msg extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException
	 */
	public Msg() throws IOException {
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		this.setBounds(100, 100, 498, 245);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 11, 478, 104);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Frank Ruehl CLM", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setText(Welcome.showSpookyMessage());

		JButton btnTakeMeFoward = new JButton("Take me foward.");
		btnTakeMeFoward.setBackground(Color.LIGHT_GRAY);
		btnTakeMeFoward.setForeground(new Color(153, 0, 0));
		btnTakeMeFoward.setBounds(166, 106, 154, 23);
		btnTakeMeFoward.addActionListener(e -> {
			try {
				lblNewLabel.setText(Welcome.showSpookyMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnTakeMeFoward.setFont(new Font("Frank Ruehl CLM", Font.BOLD | Font.ITALIC, 13));

		JButton btnTakeMeBack = new JButton("Take me back.");
		btnTakeMeBack.setForeground(new Color(153, 0, 0));
		btnTakeMeBack.setBackground(Color.LIGHT_GRAY);
		btnTakeMeBack.setBounds(166, 140, 154, 23);
		btnTakeMeBack.addActionListener(e -> System.exit(0));
		btnTakeMeBack.setFont(new Font("Frank Ruehl CLM", Font.BOLD | Font.ITALIC, 13));
		this.setLayout(null);
		this.add(btnTakeMeFoward);
		this.add(btnTakeMeBack);
		this.add(lblNewLabel);

	}

}
