import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;


public class HuffmanCode {
	public int[] frequencies;
	
	public HuffmanCode(String filename) {
		frequencies = new int[26];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			char c;
			while((c = (char)reader.read()) != -1) {
				if(c <= 'z' && c >= 'a')
					frequencies[c-'a'] += 1;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public CodeMap getHuffmanCodeMap() {
		CodeMap codeMap = new CodeMap();
		PriorityQueue<HuffmanNode> minQueue = new PriorityQueue<HuffmanNode>();
		for(int i = 0; i < 26; i++) {
			if(frequencies[i] != 0) {
				minQueue.add(new HuffmanNode(frequencies[i], new Character((char)(i + 'a'))));
			}
		}
		while(minQueue.size() > 1) {
			HuffmanNode left, right;
			left = minQueue.poll();
			right = minQueue.poll();
			HuffmanNode newNode = new HuffmanNode(left.frequency + right.frequency);
			newNode.left = left;
			newNode.right = right;
		}
		pushAllNodes(minQueue.poll(), codeMap, "");
		return codeMap;
	}

	private void pushAllNodes(HuffmanNode root, CodeMap c, String s) {
		if(root.c != null) {
			c.assignCode(root.c, s);
		}
		if(root.left != null)
			pushAllNodes(root.left, c, s + "0");
		if(root.right != null)
			pushAllNodes(root.right, c, s + "1");
	}
	
	private class HuffmanNode implements Comparable<HuffmanNode>{
		public int frequency;
		public Character c;
		public HuffmanNode left,right;
		public HuffmanNode(int frequency) {
			this.frequency = frequency;
			c = null;
			left = right = null;
		}
		public HuffmanNode(int frequency, Character c) {
			this.frequency = frequency;
			this.c = c;
			left = right = null;
		}
		public int compareTo(HuffmanNode other) {
			return this.frequency - ((HuffmanNode)other).frequency;
		}
	}
}
