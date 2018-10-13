package Helpers.ComboBox;

import Helpers.JSON.ObjectMapperSingleton;
import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.io.IOException;

@Getter
@Setter
public class MyTeamComboBoxHelper {

    private int viewBoxSet01Index;
    private int viewBoxSet02Index;
    private int viewBoxSet03Index;
    private int viewBoxSet04Index;
    private int viewBoxSet05Index;
    private int viewBoxSet06Index;
    private int viewBoxSet07Index;
    private int viewBoxSet08Index;
    private int viewBoxSet09Index;
    private int viewBoxSet10Index;
    private int viewBoxSet11Index;
    private int viewBoxSet12Index;
    private int viewBoxSet13Index;
    private int viewBoxSet14Index;
    private int viewBoxSet15Index;
    private int viewBoxSet16Index;
    private int viewBoxSet17Index;
    private int viewBoxSet18Index;
    private int viewBoxSet19Index;
    private int viewBoxSet20Index;
    private String SettingsFilePath = "src/main/resources/AppSettings/comboBoxesIndexes.json";

    public void saveIndexesToJSON(MyTeamComboBoxHelper indexes){

        try {
            ObjectMapperSingleton.getInstance().writeValue(new File(SettingsFilePath), indexes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
