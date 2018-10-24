package Controllers.Mediator;

import Controllers.Assisstant.AssisstantController;
import Controllers.Main.LauncherController;
import Controllers.Main.NewConversationController;
import Controllers.Main.WaitingModeController;

public interface IMediateControllers {

    void registerLauncherController(LauncherController controller);
    void registerWaitingModeController (WaitingModeController controller);
    void registerAssisstantController(AssisstantController controller);
    void registerNewConversationController(NewConversationController controller);

    void launcherControllerOpenNewConversationTab();
    void openNewConversationTab();

}
