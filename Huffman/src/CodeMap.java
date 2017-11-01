import java.util.HashMap;


public class CodeMap {
	HashMap<Character, String> codeMap;
	
	public CodeMap() {
		codeMap = new HashMap<Character, String>();
	}
	
	public void assignCode(char c, String s) {
		if(c >= 'a' && c <= 'z')
			codeMap.put(new Character(c), s);
	}
	
	public boolean isComplete() {
		for(char c = 'a'; c <= 'z'; c++) {
			if(codeMap.get(new Character(c)) == null) {
				return false;
			}
		}
		return true;
	}
	
	public String convertChar(char c) {
		String s = codeMap.get(new Character(c));
		return (s == null) ? "" : s;
	}
	
	public String convertText(String s) {
		StringBuilder sb = new StringBuilder();
		String encoding = null;
		int index = 0;
		while(index < s.length()) {
			encoding = codeMap.get(new Character(s.charAt(index)));
			if(encoding != null) {
				sb.append(encoding);
			}
		}
		return sb.toString();
	}
	
	public void print() {
		System.out.println("Encoding Table:");
		String encoding = null;
		for(char c = 'a'; c <= 'z'; c++) {
			if((encoding = codeMap.get(new Character(c))) == null) {
				continue;
			}
			System.out.println("   " + c + ": " + encoding);
		}
	}
}
