package pl.com.jmdev.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    String id;
    String name;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
