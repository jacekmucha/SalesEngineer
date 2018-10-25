package pl.com.jmdev.Utils.FileManager;

import pl.com.jmdev.Alerts.SettingsFileNotFoundAlert;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderSingleton {

    private static FileReaderSingleton fileReaderSingleton = new FileReaderSingleton();
    private static FileReader fileReader;

    private FileReaderSingleton() {
    }

    public static FileReaderSingleton getInstance( ) {
        return fileReaderSingleton;
    }

    public FileReader getFileReader(String filePath) {
        if(fileReader == null){
            try {
                fileReader = new FileReader(filePath);
            } catch (FileNotFoundException e) {
                SettingsFileNotFoundAlert alert = new SettingsFileNotFoundAlert();
                alert.showAlert();
            }
        }
         if(fileReader != null){
            return fileReader;
         }
        return fileReader;
    }
}
