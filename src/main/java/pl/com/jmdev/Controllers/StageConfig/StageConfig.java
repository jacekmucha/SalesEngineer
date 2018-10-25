package pl.com.jmdev.Controllers.StageConfig;

import pl.com.jmdev.Controllers.Assisstant.AssisstantController;
import pl.com.jmdev.Controllers.Main.LauncherController;
import pl.com.jmdev.Controllers.Main.NewConversationController;
import pl.com.jmdev.Controllers.TopMenuButtons.TopMenuButtonsController;

public class StageConfig {

    private static TopMenuButtonsController tmbc = null;
    private static AssisstantController ac = null;
    private static LauncherController lc = null;
    private static NewConversationController ncc = null;

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


    public static void setNewConversationController(NewConversationController nnc_val){
        StageConfig.ncc = nnc_val;
    }
    public static NewConversationController getNewConversationController(){
        return StageConfig.ncc;
    }

}
