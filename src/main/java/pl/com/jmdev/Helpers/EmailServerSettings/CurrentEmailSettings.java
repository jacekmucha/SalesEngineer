package pl.com.jmdev.Helpers.EmailServerSettings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentEmailSettings {

    String from;
    String username;
    String password;
    String host_TLS;
    String port_TLS;
    String host_SSL;
    String port_SSL;
    String connectionType;

}
