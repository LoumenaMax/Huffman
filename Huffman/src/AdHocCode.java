
public class AdHocCode {
	
	public AdHocCode() {
	}
	
	public CodeMap getAdHocCodeMap() {
		CodeMap codeMap = new CodeMap();
		for(char c = 'a'; c <= 'z'; c++) {
			String binaryString = Integer.toBinaryString(c - 'a' + 1);
			binaryString = binaryString.substring(binaryString.length() - 5);
			codeMap.assignCode(c, binaryString);
		}
		return codeMap;
	}
}
