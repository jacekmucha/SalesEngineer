package pl.com.jmdev.Utils.LicenseManager;

import lombok.Getter;
import lombok.Setter;
import pl.com.jmdev.Alerts.NoConnectionToLicenseServerAlert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LicenseManager {

    public String licenseType;

    public static String BASIC_VALIDATOR = "http://jmdev.cba.pl/apps/sales_engineer/license/basic.txt";
    public static String PRO_VALIDATOR = "http://jmdev.cba.pl/apps/sales_engineer/license/pro.txt";
    public static String MAX_VALIDATOR = "http://jmdev.cba.pl/apps/sales_engineer/license/max.txt";
    NoConnectionToLicenseServerAlert alert = new NoConnectionToLicenseServerAlert();


    public boolean validateBASIC(String key){
        return validateLicense(key, BASIC_VALIDATOR);
    }

    public boolean validatePRO(String key){
        return validateLicense(key, PRO_VALIDATOR);
    }

    public boolean validateMAX(String key){
        return validateLicense(key, MAX_VALIDATOR);
    }



    private boolean validateLicense(String key, String onLineLibrary) {
        List<String> readedLicenses = new ArrayList<>();
        BufferedReader in = null;
        try {
            URL licenseLibrary = new URL(onLineLibrary);
            in = new BufferedReader(new InputStreamReader(licenseLibrary.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                readedLicenses.add(inputLine);
            in.close();
        } catch (IOException e) {
            alert.showAlert();
        }
        for (int i = 0; i < readedLicenses.size(); i++) {
            if (readedLicenses.get(i).equals(key)) {
                return true;
            }
        }
        return false;
    }





}
