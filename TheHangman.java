import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TheHangman {
    static Random random ;
    static Boolean isGameOver ;
    static ArrayList<String> letterArray = new ArrayList();
    static int indexLetterArray = 0;
    static ArrayList<String> leList = new ArrayList<>();
    public static void main(String[] args) {
        isGameOver = false;
        String word = generateWord();
//        System.out.println(word);
        Scanner input = new Scanner(System.in);
        String returnedWord = "";
        int counter = 0;
        int counterIsTwice = 0;
        while(!isGameOver){
            System.out.println("Enter a letter to guess the word");
            String letter = input.next();
            for(String le : isWritten(letter)){
                if(le.equals(letter)){
                    counterIsTwice ++;
                    if(counterIsTwice >= 2){
                        System.out.println(letter+" daha önce yazıldı!!");
                        counterIsTwice  = 0;
                    }

                }
            }
            if(counter == 0) {
                returnedWord = takeLetter(letter,word);
                System.out.println(returnedWord);

            }
            else{
                returnedWord = takeLetter(letter, word, returnedWord);
                System.out.println(returnedWord);
            }
            isGameOver = isGameOverCheck(returnedWord);
            counter ++;




        }
        if(isGameOver){
            System.out.println(counter+" defada bildiniz.");
        }





    }
    public static String generateWord(){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String word = "";
        random = new Random();

        for(int i=0;i<10;i++){
            int randomIndex = random.nextInt(alphabet.length);
            word += Character.toString(alphabet[randomIndex]);
        }
        return word;
    }
    public static String takeLetter(String letter, String word){
        String wordStar = "";
        for(int i=0;i<word.length();i++){
            if(Character.toString(word.charAt(i)).equals(letter)){
                wordStar += Character.toString(word.charAt(i));
            }
            else{
                wordStar += "*";
            }
        }
        return wordStar;
    }
    public static String takeLetter(String letter, String word, String starWord){
        String[] letterList ;
        for (int i = 0; i < word.length(); i++) {
//            System.out.println(starWord);
            if(!Character.toString(starWord.charAt(i)).equals("*")){

                continue;

            }
            else{
                if(Character.toString(word.charAt(i)).equals(letter)){
                    // SORUN BURDA
                    letterList = new String[starWord.length()];
                    letterList = starWord.split("");
//                    for(String harf : letterList){
//                        System.out.println(harf);
//                    }
                    letterList[i] = letterList[i].replace(starWord.charAt(i),word.charAt(i));
//                    for(String harf : letterList){
//                        System.out.println(harf);
//                    }
//                    Character.toString(word.charAt(i)).replace(starWord.charAt(i),word.charAt(i));
                    starWord = "";
                    for(String harf : letterList){
                        starWord += harf;
                    }
                }
                else{

                    continue;

                }

            }
        }
        return starWord;

    }


    public static boolean isGameOverCheck(String starWord){
        int index = 0;
        for(int i=0;i<starWord.length();i++){
            if(Character.toString(starWord.charAt(i)).equals("*")){
                index ++;
            }
        }
        if(index == 0){
            System.out.println("Oyun Bitti!!!!!");
            return  true;
        }
        return false;
    }
    public static ArrayList<String> isWritten(String letter){
        leList.add(indexLetterArray,letter);
        indexLetterArray++;
        return leList;
    }

}
