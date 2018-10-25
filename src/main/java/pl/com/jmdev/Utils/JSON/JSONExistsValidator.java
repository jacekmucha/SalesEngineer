package pl.com.jmdev.Utils.JSON;

import pl.com.jmdev.Utils.FileManager.FileReaderSingleton;
import pl.com.jmdev.Utils.FileManager.FileWriterSingleton;
import java.io.Reader;

public class JSONExistsValidator {

    private FileWriterSingleton fileWriterSingleton;
    private JSONEmptyWriter jsonEmptyWriter;

    public void validateProductsJSONFilePath(String filePath){
        try{
            Reader reader = FileReaderSingleton.getInstance().getFileReader(filePath);
        } catch (NullPointerException e){
            fileWriterSingleton.getFileWriter(jsonEmptyWriter.writeEmptyProductsJSON());
        }
    }

    public void validateProductCategoriesJSONFilePath(String filePath){
            Reader reader = FileReaderSingleton.getInstance().getFileReader(filePath);
            if(reader == null){
                fileWriterSingleton.getFileWriter(jsonEmptyWriter.writeEmptyProductCategoriesJSON());
            }
    }

    public void validateMembersToNewConversationJSONFilePath(String filePath){
            Reader reader = FileReaderSingleton.getInstance().getFileReader(filePath);
            if(reader == null){
                fileWriterSingleton.getFileWriter(jsonEmptyWriter.writeEmptyMembersToNewConversationJSON());
            }
    }

    public void validateEmailServerSettingsJSONFilePath(String filePath){
            Reader reader = FileReaderSingleton.getInstance().getFileReader(filePath);
            if(reader == null){
                fileWriterSingleton.getFileWriter(jsonEmptyWriter.writeEmptyEmailServerSettings());
            }
    }

    public void validateComboBoxesIndexesJSONFilePath(String filePath){
            Reader reader = FileReaderSingleton.getInstance().getFileReader(filePath);
            if(reader == null){
                fileWriterSingleton.getFileWriter(jsonEmptyWriter.writeEmptyComboBoxesIndexes());
            }
    }

}
