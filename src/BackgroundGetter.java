import java.io.File;
import java.io.IOException;

public class BackgroundGetter {

    public static void main(String[] args) {

        new File("C:\\Users\\jaepa\\Desktop\\Background_Images").mkdirs(); // creating a folder to store images

        try {
            File myObj = new File("C:\\Users\\jaepa\\Desktop\\Background_Images\\testA.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    }
