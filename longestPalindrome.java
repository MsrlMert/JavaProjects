public class longestPalindrome {
    public static void main(String[] args){
        String example = "abcba mertrem kohgyghok mamamamam";
        System.out.println(findLongestPalindrome(example));

    }
    public static String findLongestPalindrome(String word){
        String[] wordList = word.split(" ");
        int palindromeWordLen = 0;
        String longestPalindromeWord = " ";
        for(String obj : wordList){
            String reverseWord = new StringBuilder(obj).reverse().toString();

            if(obj.equals(reverseWord)){
                if(obj.length() > palindromeWordLen) {
                    palindromeWordLen = obj.length();
                    longestPalindromeWord = obj;
                }
            }
        }
        return longestPalindromeWord;
    }
}
