

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1).replace(" ", "");
		str2 = preProcess(str2).replace(" ", "");

		if(str1.length() != str2.length()){
			return false;
		}
		
		int [] counter = new int[26];
			for(int i = 0; i < str1.length(); i++){
				counter[str1.charAt(i) - 'a'] ++;
				counter[str2.charAt(i) - 'a'] --;
		}	
						for(int count : counter){
				        	if(count != 0){
                            return false;
				}
			}
			
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
        String result = "";
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if((c >='a' && c <= 'z') || (c >='A' && c <= 'Z')){
                if(c>= 'A'&& c<='Z'){
					c = (char) (c+'a'-'A');
				}
				result += c;
			} else if(c == ' '){
				result += c;
			}
		}
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		char[] chars = str.toCharArray();
            for(int i=0; i < str.length(); i++){
					int randomPlace = (int)(Math.random()*chars.length);
				char temp = chars[i];
				chars[i] = chars[randomPlace];
				chars[randomPlace]= temp;
            }
		return new String (chars);
	}
}