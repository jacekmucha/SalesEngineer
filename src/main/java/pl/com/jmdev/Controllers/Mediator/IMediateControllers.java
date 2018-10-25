package pl.com.jmdev.Controllers.Mediator;

import pl.com.jmdev.Controllers.Assisstant.AssisstantController;
import pl.com.jmdev.Controllers.Main.LauncherController;
import pl.com.jmdev.Controllers.Main.NewConversationController;
import pl.com.jmdev.Controllers.Main.WaitingModeController;

public interface IMediateControllers {

    void registerLauncherController(LauncherController controller);
    void registerWaitingModeController (WaitingModeController controller);
    void registerAssisstantController(AssisstantController controller);
    void registerNewConversationController(NewConversationController controller);

    void launcherControllerOpenNewConversationTab();
    void openNewConversationTab();

}
