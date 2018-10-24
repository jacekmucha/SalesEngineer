package Controllers.Settings;

import Helpers.JSON.JSONFilePaths;
import Model.Product;
import Model.ProductCategory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ProductsController implements Initializable {

    @FXML
    private TextField catA;
    @FXML
    private TextField catB;
    @FXML
    private TextField catC;
    @FXML
    private TextField catD;
    @FXML
    private TextField details;
    @FXML
    private TextField subject1;
    @FXML
    private TextField subject2;
    @FXML
    private TextField subject3;
    @FXML
    private TextField subject4;
    @FXML
    private TextField status1;
    @FXML
    private TextField status2;


    @FXML
    private TextField productA01;
    @FXML
    private TextField productA02;
    @FXML
    private TextField productA03;
    @FXML
    private TextField productA04;
    @FXML
    private TextField productA05;
    @FXML
    private TextField productA06;
    @FXML
    private TextField productA07;
    @FXML
    private TextField productA08;
    @FXML
    private TextField productA09;
    @FXML
    private TextField productA10;
    @FXML
    private TextField productA11;
    @FXML
    private TextField productA12;
    @FXML
    private TextField productA13;
    @FXML
    private TextField productA14;
    @FXML
    private TextField productA15;
    @FXML
    private TextField productA16;
    @FXML
    private TextField productA17;
    @FXML
    private TextField productA18;

    @FXML
    private TextField productB01;
    @FXML
    private TextField productB02;
    @FXML
    private TextField productB03;
    @FXML
    private TextField productB04;
    @FXML
    private TextField productB05;
    @FXML
    private TextField productB06;
    @FXML
    private TextField productB07;
    @FXML
    private TextField productB08;
    @FXML
    private TextField productB09;
    @FXML
    private TextField productB10;
    @FXML
    private TextField productB11;
    @FXML
    private TextField productB12;
    @FXML
    private TextField productB13;
    @FXML
    private TextField productB14;
    @FXML
    private TextField productB15;
    @FXML
    private TextField productB16;
    @FXML
    private TextField productB17;
    @FXML
    private TextField productB18;

    @FXML
    private TextField productC01;
    @FXML
    private TextField productC02;
    @FXML
    private TextField productC03;
    @FXML
    private TextField productC04;
    @FXML
    private TextField productC05;
    @FXML
    private TextField productC06;
    @FXML
    private TextField productC07;
    @FXML
    private TextField productC08;
    @FXML
    private TextField productC09;
    @FXML
    private TextField productC10;
    @FXML
    private TextField productC11;
    @FXML
    private TextField productC12;
    @FXML
    private TextField productC13;
    @FXML
    private TextField productC14;
    @FXML
    private TextField productC15;
    @FXML
    private TextField productC16;
    @FXML
    private TextField productC17;
    @FXML
    private TextField productC18;

    @FXML
    private TextField productD01;
    @FXML
    private TextField productD02;
    @FXML
    private TextField productD03;
    @FXML
    private TextField productD04;
    @FXML
    private TextField productD05;
    @FXML
    private TextField productD06;
    @FXML
    private TextField productD07;
    @FXML
    private TextField productD08;
    @FXML
    private TextField productD09;


    List<TextField> productsTextFieldList = new ArrayList<>();
    List<TextField> categoriesTextFieldList = new ArrayList<>();


    public void saveData(ActionEvent event) {

        List<Product> productsList = new ArrayList<>();

        for (int i = 0; i < productsTextFieldList.size(); i++) {
            Product product = new Product();
            product.setId(productsTextFieldList.get(i).getId());
            product.setName(productsTextFieldList.get(i).getText());
            productsList.add(product);
        }

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(JSONFilePaths.productsFilePath)) {
            gson.toJson(productsList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ProductCategory> productCategories = new ArrayList<>();

        for (int i = 0; i < categoriesTextFieldList.size(); i++) {
            ProductCategory category = new ProductCategory();
            category.setId(categoriesTextFieldList.get(i).getId());
            category.setName(categoriesTextFieldList.get(i).getText());
            productCategories.add(category);
        }

        try (FileWriter writer = new FileWriter(JSONFilePaths.categoriesFilePath)) {
            gson.toJson(productCategories, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void loadData() {
        Reader productsReader = null;
        try {
            productsReader = new FileReader(JSONFilePaths.productsFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type productList = new TypeToken<ArrayList<Product>>() {}.getType();
        List<Product> loadedProducts = gson.fromJson(productsReader, productList);

        for (int i = 0; i < productsTextFieldList.size(); i++) {
            productsTextFieldList.get(i).setText(loadedProducts.get(i).getName());
        }

        Reader categoryReader = null;
        try {
            categoryReader = new FileReader(JSONFilePaths.categoriesFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type categoryList = new TypeToken<ArrayList<ProductCategory>>() {}.getType();
        List<ProductCategory> loadedCategories = gson.fromJson(categoryReader, categoryList);

        for (int i = 0; i < categoriesTextFieldList.size(); i++) {
            categoriesTextFieldList.get(i).setText(loadedCategories.get(i).getName());
        }
}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoriesTextFieldList.add(catA);
        categoriesTextFieldList.add(catB);
        categoriesTextFieldList.add(catC);
        categoriesTextFieldList.add(catD);
        categoriesTextFieldList.add(details);
        categoriesTextFieldList.add(subject1);
        categoriesTextFieldList.add(subject2);
        categoriesTextFieldList.add(subject3);
        categoriesTextFieldList.add(subject4);
        categoriesTextFieldList.add(status1);
        categoriesTextFieldList.add(status2);

        productsTextFieldList.add(productA01);
        productsTextFieldList.add(productA02);
        productsTextFieldList.add(productA03);
        productsTextFieldList.add(productA04);
        productsTextFieldList.add(productA05);
        productsTextFieldList.add(productA06);
        productsTextFieldList.add(productA07);
        productsTextFieldList.add(productA08);
        productsTextFieldList.add(productA09);
        productsTextFieldList.add(productA10);
        productsTextFieldList.add(productA11);
        productsTextFieldList.add(productA12);
        productsTextFieldList.add(productA13);
        productsTextFieldList.add(productA14);
        productsTextFieldList.add(productA15);
        productsTextFieldList.add(productA16);
        productsTextFieldList.add(productA17);
        productsTextFieldList.add(productA18);

        productsTextFieldList.add(productB01);
        productsTextFieldList.add(productB02);
        productsTextFieldList.add(productB03);
        productsTextFieldList.add(productB04);
        productsTextFieldList.add(productB05);
        productsTextFieldList.add(productB06);
        productsTextFieldList.add(productB07);
        productsTextFieldList.add(productB08);
        productsTextFieldList.add(productB09);
        productsTextFieldList.add(productB10);
        productsTextFieldList.add(productB11);
        productsTextFieldList.add(productB12);
        productsTextFieldList.add(productB13);
        productsTextFieldList.add(productB14);
        productsTextFieldList.add(productB15);
        productsTextFieldList.add(productB16);
        productsTextFieldList.add(productB17);
        productsTextFieldList.add(productB18);

        productsTextFieldList.add(productC01);
        productsTextFieldList.add(productC02);
        productsTextFieldList.add(productC03);
        productsTextFieldList.add(productC04);
        productsTextFieldList.add(productC05);
        productsTextFieldList.add(productC06);
        productsTextFieldList.add(productC07);
        productsTextFieldList.add(productC08);
        productsTextFieldList.add(productC09);
        productsTextFieldList.add(productC10);
        productsTextFieldList.add(productC11);
        productsTextFieldList.add(productC12);
        productsTextFieldList.add(productC13);
        productsTextFieldList.add(productC14);
        productsTextFieldList.add(productC15);
        productsTextFieldList.add(productC16);
        productsTextFieldList.add(productC17);
        productsTextFieldList.add(productC18);

        productsTextFieldList.add(productD01);
        productsTextFieldList.add(productD02);
        productsTextFieldList.add(productD03);
        productsTextFieldList.add(productD04);
        productsTextFieldList.add(productD05);
        productsTextFieldList.add(productD06);
        productsTextFieldList.add(productD07);
        productsTextFieldList.add(productD08);
        productsTextFieldList.add(productD08);
        productsTextFieldList.add(productD09);

        loadData();
    }
}
