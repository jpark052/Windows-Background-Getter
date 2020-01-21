import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BackgroundGetter {

    public static File[] files;
    public static int currentFileNum;
    public static int newImagesNum = 0;

    public static void main(String[] args) throws IOException {

        // create a directory in the Desktop if it does not exist
        new File("C:\\Users\\jaepa\\Desktop\\Background_Images").mkdirs();
        getNumber();
        fetchFiles();
    }

    // get the number of the images that are already in the folder
    public static void getNumber() {

        File[] files = new File("C:\\Users\\jaepa\\Desktop\\Background_Images").listFiles();
        currentFileNum = files.length + 1;
    }

    // fetch the list raw image files from where they are stored in the system, and call copyFiles() method on the files
    // that are bigger than 340kb (lower bound of the image file)
    public static void fetchFiles() throws NullPointerException, IOException {

        // location of raw image files stored
        files = new File("C:\\Users\\jaepa\\AppData\\Local\\Packages\\" +
                "Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets").listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                if (files[i].length() >= 340000) {
                    copyFiles(files[i]);
                    currentFileNum++;
                    newImagesNum++;
                }
            }
        }
        System.out.println(newImagesNum + " images has been created");
    }

    // copy the file, convert it into jpeg, and store in the directory in the Destop
    public static void copyFiles(File file) throws IOException {

        File source = new File(file.getCanonicalPath());
        File dest = new File("C:\\Users\\jaepa\\Desktop\\Background_Images\\" + currentFileNum + ".jpg");
        Files.copy(source.toPath(), dest.toPath());
    }
}