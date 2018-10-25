package pl.com.jmdev.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {

    private Integer id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
