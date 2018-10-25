package pl.com.jmdev.Utils.FXMLLoader;

import javafx.fxml.FXMLLoader;

public class FXMLLoaderSingleton {

    private static FXMLLoaderSingleton instance = new FXMLLoaderSingleton();
    private FXMLLoaderSingleton(){}

    private static FXMLLoader loader = new FXMLLoader();

    public static FXMLLoaderSingleton getInstance(){
        if(instance == null){
            instance = new FXMLLoaderSingleton();
        } return instance;
    }

    public FXMLLoader getLoader(){
        return loader;
    }

}
