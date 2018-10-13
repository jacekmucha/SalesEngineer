package Helpers.EmailServerSettings;

import Model.EmailServerSettings;

public class EmailServerSettingsSingleton {

    private static final EmailServerSettings instance = new EmailServerSettings();

    private EmailServerSettingsSingleton(){
    }

    public static EmailServerSettings getInstance(){
        return instance;
    }

}
