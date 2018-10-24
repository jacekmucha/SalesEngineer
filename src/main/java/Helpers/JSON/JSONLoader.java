//package Helpers.JSON;
//
//import Model.Product;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.Reader;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class JSONLoader <T> {
//
//    private void readJSON(List<T> fromJSONList, List<T> toInputList, String JSONPath){
//        Reader reader = null;
//        try {
//            reader = new FileReader(JSONPath);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Gson gson = new Gson();
//        Type productList = new TypeToken<ArrayList<Product>>() {}.getType();
//        fromJSONList = gson.fromJson(reader, productList);
//
//        for (int i = 0; i < toInputList.size(); i++) {
//            fromJSONList.get(i).setText(fromJSONList.get(i).getName());
//        }
//    }
//}
