import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class HuffmanValidate {
	public static final String ENCODED_FILENAME = "Huff_Encoded.txt";

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Improper number of arguments.\n   Usage: java HuffmanValidate.java <filename>");
			System.exit(1);
		}
		String filename = args[1];
		HuffmanCode hc = new HuffmanCode(filename);
		CodeMap codeMap = hc.getHuffmanCodeMap();
		codeMap.print();
		System.out.print('\n');
		int huffmanLength = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			BufferedWriter bw = new BufferedWriter(new FileWriter(ENCODED_FILENAME));
			String line;
			while((line = reader.readLine()) != null) {
				line = codeMap.convertText(line);
				huffmanLength += line.length();
				System.out.println(line);
				bw.write(line, 0, line.length());
			}
			reader.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Huffman File Length(bits): " + huffmanLength);
		File oldFile = new File(filename);
		System.out.println("Old File Length(bits): " + (oldFile.length() * 8));
		System.out.println("Ratio (Old/New): " + (huffmanLength/(oldFile.length() * 8)));
	}

}
