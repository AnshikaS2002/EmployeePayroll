import java.io.File;
import java.io.IOException;

public class FileOperations {

    private static void checkFileExists(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File exists: " + filePath);
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    }

    private static void createAndWriteToFile(String filePath) {
        try {
            File file = new File(filePath);
            file.createNewFile();
            System.out.println("File created and written: " + filePath);
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    private static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File deleted: " + filePath);
        } else {
            System.out.println("File could not be deleted (might not exist): " + filePath);
        }
    }

    private static void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.mkdir()) {
            System.out.println("Directory created: " + directoryPath);
        } else {
            System.out.println("Directory already exists or could not be created: " + directoryPath);
        }
    }

    private static void createFileInDirectory(String directoryPath, String fileName) {
        try {
            File file = new File(directoryPath, fileName);
            file.createNewFile();
            System.out.println("Empty file created in directory: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating empty file: " + e.getMessage());
        }
    }

    private static void listFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        String[] files = directory.list();
        if (files != null) {
            System.out.println("Files in directory: " + directoryPath);
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("No files in directory: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        String filePath = "demoFile.txt";
        String directoryPath = "demoDirectory";

        checkFileExists(filePath);

        createAndWriteToFile(filePath);

        checkFileExists(filePath);

        deleteFile(filePath);

        checkFileExists(filePath);

        createDirectory(directoryPath);

        createFileInDirectory(directoryPath, "newFile.txt");

        listFilesInDirectory(directoryPath);

    }
}
