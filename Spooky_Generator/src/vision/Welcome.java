package vision;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Welcome {
	public static JFrame frame = new JFrame("JOptionPane showMessageDialog example");

	public static String showSpookyMessage () throws IOException {
		FileInputStream fs= new FileInputStream("spoopy.txt");
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