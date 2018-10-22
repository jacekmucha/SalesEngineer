package Utils.AutoUpdate;

import Launcher.Launcher;
import jdk.nashorn.api.scripting.URLReader;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AutoUpdate {

    private static Double CURRENT_VERSION = Launcher.AppVersion;
    public static Double UPDATE_VERSION = 0D;
    public static String LAST_RELEASE_DATE;
    public static String UPDATE_CONTROLLER = "http://jmdev.cba.pl/apps/sales_engineer/autoupdate.txt";
    public static String NEW_VERSION_URL;


    public AutoUpdate() {

        validateVersion();

    }


    public static List<String> readCurrentVersionFromWeb() {

        List<String> onlineInfo = new ArrayList<>();
        try {
            URL updateURL = new URL(UPDATE_CONTROLLER);
            BufferedReader updateReader = new BufferedReader(new URLReader(updateURL));
            for (int i = 0; i < 4; i++) {
                onlineInfo.add(updateReader.readLine());
            }
            LAST_RELEASE_DATE = onlineInfo.get(1);
            UPDATE_VERSION = Double.parseDouble(onlineInfo.get(2));
            NEW_VERSION_URL = onlineInfo.get(3);

        } catch (FileNotFoundException e) {
            System.out.println("Błąd autoupdate - nie można odczytać pliku z aktualną wersją programu");
            e.printStackTrace();
            System.out.println("Błąd wczytywania pliku z wiytyny producenta");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return onlineInfo;
    }


    public static boolean validateVersion() {
        String s = readCurrentVersionFromWeb().get(2);
        UPDATE_VERSION = Double.parseDouble(s);
        if (UPDATE_VERSION > CURRENT_VERSION) {
            return true;
        }
        return false;
    }

    public static void downloadNewVersion() {

        Desktop d = Desktop.getDesktop();
        try {
            d.browse(URI.create(readCurrentVersionFromWeb().get(3)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
