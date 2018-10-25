package pl.com.jmdev.Utils.LicenseManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import pl.com.jmdev.Alerts.NoConnectionToLicenseServerAlert;
import pl.com.jmdev.Model.License;
import pl.com.jmdev.Utils.JSON.JSONFilePaths;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LicenseManager {

    public String licenseType;

    public static String LIBRARY = "http://jmdev.cba.pl/apps/sales_engineer/license/licenses.json";
    NoConnectionToLicenseServerAlert alert = new NoConnectionToLicenseServerAlert();


    private List<String> validateLicense() {

        License myLicense = loadMyLicense();
        List<License> serverResources = loadServerResources();
        List<String> result = new ArrayList<>();

        for (License license : serverResources) {
            if (license.getMAX_KEY().equals(myLicense.getMAX_KEY())) {
                result.add(0, license.getOwnerName());
                result.add(1, "MAX");
            } else if (license.getPRO_KEY().equals(myLicense.getPRO_KEY())) {
                result.add(0, license.getOwnerName());
                result.add(1, "PRO");
            } else if (license.getBASIC_KEY().equals(myLicense.getBASIC_KEY())) {
                result.add(0, license.getOwnerName());
                result.add(1, "BASIC");
            } else {
                result.add(0, "");
                result.add(1, "Okres testowy");
            }
        }
        return result;
    }

    public void saveMyLicense(String owner, String BASICkey, String PROkey, String MAXkey) {
        License license = new License();
        license.setOwnerName(owner);
        license.setBASIC_KEY(BASICkey);
        license.setPRO_KEY(PROkey);
        license.setMAX_KEY(MAXkey);
        Gson gson = new Gson();
        String json = gson.toJson(license);
        try (FileWriter writer = new FileWriter(JSONFilePaths.licenseFilePath)) {
            gson.toJson(license, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public License loadMyLicense() {
        License license = null;
        Gson gson = new Gson();
        try (Reader reader = new FileReader(JSONFilePaths.licenseFilePath)) {
            license = gson.fromJson(reader, License.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return license;
    }


    public List<License> loadServerResources() {

        BufferedReader in = null;
        String inputLine = null;
        try {
            URL serverResources = new URL(LIBRARY);
            in = new BufferedReader(
                    new InputStreamReader(serverResources.openStream()));

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Type licenses = new TypeToken<ArrayList<License>>() {
        }.getType();
        List<License> loadedLicenses = gson.fromJson(inputLine, licenses);
        return loadedLicenses;
    }

}
