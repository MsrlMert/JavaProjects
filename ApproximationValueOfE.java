import java.util.Scanner;

public class ApproximationValueOfE {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the n value: ");
        int nValue = input.nextInt();
        System.out.println(valueE(nValue));

    }
    public static double valueE(int num){
        double result = 0;
        for(int i=1;i<= num;i++){
            result += 1/factorial(i);
        }
        return result+1;
    }



    public static double factorial(int num){
        double factorialValue = 1.0;
        if(num == 0){
            return 1;
        }
        for(int i =1;i<=num;i++){
            factorialValue *= i;
        }
        return factorialValue;
    }

}
