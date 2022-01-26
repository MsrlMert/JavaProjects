import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductLab06 {
    private String name;
    private int price ;
    private ArrayList<ProductLab06> array = new ArrayList<>();
    private String fileName = "C:\Users\Aleyna Furkan\Desktop\JAVA Projects\Lab06\\products.txt";
    private static int xCoord = 50;


    public ProductLab06(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public ProductLab06(){

    }
    public void generateWindow(){
        int width = 720;
        int height = 650;
        StdDraw.setCanvasSize(width,height);
        StdDraw.setXscale(0,width);
        StdDraw.setYscale(0,height);
    }
    public void addProduct() throws FileNotFoundException {
        File fileInput = new File(fileName);
        if (!fileInput.exists()){
            System.out.println("File is not found.");
            System.exit(1);
        }
        Scanner inputFile = new Scanner(fileInput);
        while (inputFile.hasNextLine()){
            name = inputFile.next();
            price = inputFile.nextInt();
            array.add(new ProductLab06(name,price));
        }
        inputFile.close();
    }
    public void drawBarChart(){
        StdDraw.setPenColor(Color.orange);
        StdDraw.filledRectangle(xCoord,price/2,25,price/2);
        writeLabel();
        xCoord += 80;

    }
    public void writeLabel(){
        StdDraw.setPenColor(StdDraw.BLACK);
        Font font = new Font("Arial",Font.PLAIN,24);
        StdDraw.setFont(font);
        StdDraw.text(xCoord,price+20,name);
    }


    public String toString(){
        return this.name+" "+this.price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public ArrayList<ProductLab06> getArray() {
        return this.array;
    }
}
