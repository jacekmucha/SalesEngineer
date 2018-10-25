package pl.com.jmdev.Utils.FileManager;

import pl.com.jmdev.Alerts.SettingsFileNotFoundAlert;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterSingleton {

    private static FileWriterSingleton fileWriterSingleton = new FileWriterSingleton();
    private static FileWriter fileWriter;

    private FileWriterSingleton() {
    }

    public static FileWriterSingleton getInstance( ) {
        return fileWriterSingleton;
    }

    public FileWriter getFileWriter(String filePath) {
        if(fileWriter == null){
            try {
                fileWriter = new FileWriter(filePath);
            } catch (FileNotFoundException e) {
                SettingsFileNotFoundAlert alert = new SettingsFileNotFoundAlert();
                alert.showAlert();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fileWriter != null){
            return fileWriter;
        }
        return fileWriter;
    }
}
