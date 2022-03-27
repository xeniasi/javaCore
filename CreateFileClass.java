import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class CreateFileClass {

    public static ArrayList<FileObject> fileObjectArrayList = new ArrayList<>();
    public static final String pathToFile = "file.csv";
    public static final String title = "Value 1" + ";" + "Value 2" + ";" + "Value 3" + System.getProperty("line.separator");

    public static void main(String[] args) {
        createFileObjects();
        writeStream();
        readToObject();
    }

    public static void createFileObjects() {
        Random random = new Random();

        for(int i = 1; i < 100; i++){
            fileObjectArrayList.add(new FileObject(i, random.nextInt(10), random.nextInt(100)));
        }
    }

    public static void writeStream() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToFile)) {
            for(byte b : title.getBytes(StandardCharsets.UTF_8)) {
                fileOutputStream.write(b);
            }
            for(FileObject fileObject : fileObjectArrayList) {
                String raw = fileObject.getValue() + ";" + fileObject.getValueFrom() + ";" + fileObject.getValueTo() + System.getProperty("line.separator");
                for(byte b : raw.getBytes(StandardCharsets.UTF_8)) {
                    fileOutputStream.write(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData readToObject() {
        AppData appData = new AppData();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            String line = bufferedReader.readLine();
            System.out.println(line);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appData;
    }
}
