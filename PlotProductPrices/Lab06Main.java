import java.io.FileNotFoundException;

public class Lab06Main {
    public static void main(String[] args) throws FileNotFoundException {
        ProductLab06 productLab06 = new ProductLab06();
        productLab06.addProduct();
        productLab06.generateWindow();
        for (ProductLab06 object : productLab06.getArray()){
            System.out.println(object.getPrice());
            object.drawBarChart();

        }
        StdDraw.show();
    }
}
