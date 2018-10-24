package Controllers.StageConfig;

import Controllers.Assisstant.AssisstantController;
import Controllers.Main.LauncherController;
import Controllers.TopMenuButtons.TopMenuButtonsController;

public class StageConfig {

    private static TopMenuButtonsController tmbc = null;
    private static AssisstantController ac = null;
    private static LauncherController lc = null;

    public static void setTopMenuButtonsController(TopMenuButtonsController tmbc_val) {
        StageConfig.tmbc = tmbc_val;
    }
    public static TopMenuButtonsController getTopMenuButtonsController() {
        return StageConfig.tmbc;
    }


    public static void setAssisstantController(AssisstantController ac_val) {
        StageConfig.ac = ac_val;
    }
    public static AssisstantController getAssisstantController() {
        return StageConfig.ac;
    }


    public static void setLauncherController(LauncherController lc_val){
        StageConfig.lc = lc_val;
    }
    public static LauncherController getLauncherController(){
        return StageConfig.lc;
    }

}
