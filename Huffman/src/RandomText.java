import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class RandomText {
	public static final String DATASET_FILENAME = "dataset.txt";

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Improper number of arguments.\n   Usage: java RandomText.java <size>");
			System.exit(1);
		}
		int size = 0;
		try {
			size = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException e) {
			System.out.println("Argument must be an integer.\n   Usage: java RandomText.java <size>");
			System.exit(1);
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(DATASET_FILENAME));
			Random ran = new Random();
			for(int i = 0; i < size; i++) {
				bw.write(ran.nextInt(26) + 'a');
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
