package pl.com.jmdev.Utils.LicenseManager;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LicenseView {

    private String licenseViewOwner;
    private String licenseViewType;
    private LicenseManager licenseManager;


    public LicenseView showValidatedLicense(){
        LicenseView licenseView = new LicenseView();
        licenseView.setLicenseViewOwner(licenseManager.getValidatedOwner());
        licenseView.setLicenseViewType(licenseManager.getValidatedType());
        return licenseView;
    }


    @Override
    public String toString() {
        return "LicenseView{" +
                "licenseOwner='" + licenseViewOwner + '\'' +
                ", licenseType='" + licenseViewType + '\'' +
                '}';
    }
}
