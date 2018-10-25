package pl.com.jmdev.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCategory {

    String id;
    String name;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
