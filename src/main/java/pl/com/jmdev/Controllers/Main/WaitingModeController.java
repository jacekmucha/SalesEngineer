package pl.com.jmdev.Controllers.Main;

import javafx.event.ActionEvent;
import pl.com.jmdev.Controllers.StageConfig.StageConfig;

public class WaitingModeController {
    public void openNewConvTab(ActionEvent event) {
        StageConfig.getLauncherController().openNewConverationTab();


    }
}
