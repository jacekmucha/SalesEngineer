package pl.com.jmdev.Helpers.EmailServerSettings;

import pl.com.jmdev.Model.EmailServerSettings;

public class EmailServerSettingsSingleton {

    private static final EmailServerSettings instance = new EmailServerSettings();

    private EmailServerSettingsSingleton(){
    }

    public static EmailServerSettings getInstance(){
        return instance;
    }

}
