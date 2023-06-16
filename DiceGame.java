import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    static int winner = 0;
    static int[] sumOfWinner = new int[2];
    static int winnerSize = 0;
    static int gameCount = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of people that will play");
        int numPlayer = input.nextInt();
        Random random = new Random();
        int[][] numList = new int[numPlayer][3];
        for(int i=0;i<numPlayer;i++){
            int num1, num2, num3;
            num1 = random.nextInt(10);
            num2 = random.nextInt(10);
            num3 = random.nextInt(10);
            numList[i][0] = num1;
            numList[i][1] = num2;
            numList[i][2] = num3;
            System.out.print(num1+" "+num2+" "+num3);
            System.out.println();

        }


        for(int i=0;i<numPlayer;i++){
            game(i,numList[i][0],numList[i][1],numList[i][2],numPlayer);
        }


    }
    public static void game(int index, int num1, int num2, int num3, int playerNum){
        if(isThreeSame(num1, num2, num3)){
            int sumOfNumbers = num1 + num2 + num3;
            if(sumOfNumbers > sumOfWinner[1]){
                sumOfWinner[1] = sumOfNumbers;
                System.out.print(" "+sumOfWinner[1]+" ");
                winnerSize = 3;
                winner = index;
            }
        }
        /*
        3 1 3 7
        4 3 3 10
        1 7 1 9
        3 6 3 12
        8 7 7 22
        7 7 2 16
        2 6 6 14
         */
        else if(winnerSize < 3){
            if(isTwoSame(num1, num2, num3)){
                int sumOfNumbers = num1 + num2 + num3;
                if(sumOfNumbers > sumOfWinner[0]){
                    sumOfWinner[0] = sumOfNumbers;
                    System.out.print(" "+sumOfWinner[0]+" ");
                    winnerSize = 2;
                    winner = index;
                }

            }
        }

        if(index == playerNum-1){
            System.out.println("Winner :"+winner);
        }


    }
    public static boolean isTwoSame(int num1, int num2, int num3){
        if(num1 == num2 && num1 != num3){
            return true;
        }
        else if (num1 == num3 && num1 != num2){
            return true;
        }
        else if (num2 == num3 && num2 != num1){
            return true;
        }
        return false;
    }
    public static boolean isThreeSame(int num1,int num2, int num3){
        if (num1 == num2 && num2 == num3){
            return true;
        }
        return false;
    }


}
