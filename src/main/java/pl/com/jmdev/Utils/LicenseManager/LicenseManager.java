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
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LicenseManager {

    public String licenseType;
    final static String MAX = "MAX";
    final static String PRO = "PRO";
    final static String BASIC = "BASIC";
    final static String noOwner = "";
    final static String TEST_PERIOD = "OKRES TESTOWY";
    private String validatedOwner = null;
    private String validatedType = null;

    public static String LIBRARY = "http://jmdev.cba.pl/apps/sales_engineer/license/licenses.json";
    NoConnectionToLicenseServerAlert alert = new NoConnectionToLicenseServerAlert();


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

    public String connectToLicenseServer() {
        URLConnection connection = null;
        StringBuilder response = new StringBuilder();
        String inputLine;

        try {
            URL library = new URL(LIBRARY);
            connection = library.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = response.toString();
        return result;
    }


    public List<License> getServerResponse() {
        List<License> fromServer = new ArrayList<>();
        final String serverResponse = connectToLicenseServer();
        Gson gson = new Gson();

        Reader reader = null;
        reader = new StringReader(serverResponse);
        Type licenseList = new TypeToken<ArrayList<License>>() {
        }.getType();
        fromServer = gson.fromJson(reader, licenseList);

        //TODO delete below, when method completed!
        System.out.println("Server response as JSON LIST: \n");
        for (License license : fromServer) {
            System.out.println(license);
        }
        //TODO delete above, when method completed!
        return fromServer;

    }


    public LicenseView validateLicense() {
        LicenseView licenseView = new LicenseView();
        License myLicense = loadMyLicense();
        List<License> serverResources = getServerResponse();

        for (License license : serverResources) {
            if (license.getMAX_KEY().equals(myLicense.getMAX_KEY()) && !license.getMAX_KEY().equals(" ")) {
                licenseView.setLicenseViewOwner(license.getOwnerName());
                licenseView.setLicenseViewType(MAX);

            } else if (license.getPRO_KEY().equals(myLicense.getPRO_KEY())&& !license.getPRO_KEY().equals(" ")) {
                licenseView.setLicenseViewOwner(license.getOwnerName());
                licenseView.setLicenseViewType(PRO);

            } else if (license.getBASIC_KEY().equals(myLicense.getBASIC_KEY()) && !license.getBASIC_KEY().equals(" ")) {
                licenseView.setLicenseViewOwner(license.getOwnerName());
                licenseView.setLicenseViewType(BASIC);

            } else {
                licenseView.setLicenseViewOwner(noOwner);
                licenseView.setLicenseViewType(TEST_PERIOD);

            }
        }
        return  licenseView;
    }

}
