package pl.com.jmdev.Utils.LicenseManager;

import lombok.Getter;
import lombok.Setter;
import pl.com.jmdev.Model.License;
import java.util.List;

@Getter
@Setter
public class ServerResources {
    List<License> licenseServerResponse;

    @Override
    public String toString() {
        return "ServerResources{" +
                "licenseServerResponse=" + licenseServerResponse +
                '}';
    }
}
