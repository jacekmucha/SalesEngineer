package Controllers.Mediator;

import Controllers.Assisstant.AssisstantController;
import Controllers.Main.LauncherController;
import Controllers.Main.NewConversationController;
import Controllers.Main.WaitingModeController;

public class ControllerMediator implements IMediateControllers{

    private LauncherController launcherController;
    private WaitingModeController waitingModeController;
    private AssisstantController assisstantController;
    private NewConversationController newConversationController;


    @Override
    public void registerLauncherController(LauncherController controller) {
        launcherController = controller;
    }

    @Override
    public void registerWaitingModeController(WaitingModeController controller) {
        waitingModeController = controller;
    }

    @Override
    public void registerAssisstantController(AssisstantController controller) {
        assisstantController = controller;
    }

    @Override
    public void registerNewConversationController(NewConversationController controller) {
        newConversationController = controller;
    }

    @Override
    public void launcherControllerOpenNewConversationTab() {
        launcherController.openNewConverationTab();
    }

    @Override
    public void openNewConversationTab() {

    }

    private ControllerMediator() {}

    public static ControllerMediator getInstance() {
        return ControllerMediatorHolder.INSTANCE;
    }

    private static class ControllerMediatorHolder {
        private static final ControllerMediator INSTANCE = new ControllerMediator();
    }
}
