package pl.com.jmdev.Helpers.Member;

import javafx.beans.property.SimpleStringProperty;
import java.util.Objects;

public class MemberToTableViewHelper {

    private SimpleStringProperty name;
    private SimpleStringProperty email;

    public MemberToTableViewHelper(String name, String email) {
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberToTableViewHelper memberToTableViewHelper = (MemberToTableViewHelper) o;
        return Objects.equals(name, memberToTableViewHelper.name) &&
                Objects.equals(email, memberToTableViewHelper.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
