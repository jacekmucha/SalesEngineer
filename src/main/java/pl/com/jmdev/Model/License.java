package pl.com.jmdev.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class License {

    private String ownerName;
    private String userName;
    private String BASIC_KEY;
    private String PRO_KEY;
    private String MAX_KEY;
    private String expiriationDate;

    @Override
    public String toString() {
        return "License{" +
                "ownerName='" + ownerName + '\'' +
                ", userName='" + userName + '\'' +
                ", BASIC_KEY='" + BASIC_KEY + '\'' +
                ", PRO_KEY='" + PRO_KEY + '\'' +
                ", MAX_KEY='" + MAX_KEY + '\'' +
                ", expiriationDate='" + expiriationDate + '\'' +
                '}';
    }
}
