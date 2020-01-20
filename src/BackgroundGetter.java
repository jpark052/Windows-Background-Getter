import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.commons.io.filefilter.FileFilterUtils;


public class BackgroundGetter {

    public static File[] files;
    public static File[] suitFiles;
    public static int currentFileNum;
    public static int suit;

    public static void main(String[] args) throws IOException {

        new File("C:\\Users\\jaepa\\Desktop\\Background_Images").mkdirs(); // creating a folder to store images

       // fetchFiles();
       // copyFiles();
        getNumber();

    }

    public static void getNumber(){

        File[] files = new File("C:\\Users\\jaepa\\Desktop\\Background_Images").listFiles();
        currentFileNum = files.length + 1;
        //System.out.println(currentFileNum);

    }

    public static void createFile(){
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

    public static void fetchFiles() throws NullPointerException, IOException {
        files = new File("C:\\Users\\jaepa\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets").listFiles();

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (files[i].length() >= 340000) {
                        copyFiles(files[i]);
                        //System.out.println(files[i].length());

                    }
                }
        }

    }

    public static void copyFiles(File file) throws IOException {
//        Path origin = Paths.get("C:\\Users\\jaepa\\Desktop\\folderA");
//        Path des = Paths.get("C:\\Users\\jaepa\\Desktop\\FolderB");

        File source = new File(file.getCanonicalPath());
        File dest = new File("C:\\Users\\jaepa\\Desktop\\FolderB\\" + currentFileNum + ".jpg");
        Files.copy(source.toPath(), dest.toPath());
    }
    }
