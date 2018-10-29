package pl.com.jmdev.Controllers.Main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.com.jmdev.Alerts.*;
import pl.com.jmdev.Controllers.StageConfig.StageConfig;
import pl.com.jmdev.Utils.JSON.JSONExistsValidator;
import pl.com.jmdev.Utils.JSON.JSONFilePaths;
import pl.com.jmdev.Model.*;
import pl.com.jmdev.Utils.EmailSender.SendMail;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class NewConversationController {

    @FXML
    private Label catName_A;
    @FXML
    private Label catName_B;
    @FXML
    private Label catName_C;
    @FXML
    private Label catName_D;
    @FXML
    private Label detailsLabel;
    @FXML
    private RadioButton subjectRadio1;
    @FXML
    private RadioButton subjectRadio2;
    @FXML
    private RadioButton subjectRadio3;
    @FXML
    private RadioButton subjectRadio4;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;

    @FXML
    private TextField customerName;
    @FXML
    private TextField customerCompany;
    @FXML
    private TextField customerPhone;
    @FXML
    private TextField customerEmail;
    @FXML
    private TextField customerBudget;
    @FXML
    private TextField customerDateOfDelivery;


    @FXML
    private ToggleButton sendToTMember01;
    @FXML
    private ToggleButton sendToTMember02;
    @FXML
    private ToggleButton sendToTMember03;
    @FXML
    private ToggleButton sendToTMember04;
    @FXML
    private ToggleButton sendToTMember05;
    @FXML
    private ToggleButton sendToTMember06;
    @FXML
    private ToggleButton sendToTMember07;
    @FXML
    private ToggleButton sendToTMember08;
    @FXML
    private ToggleButton sendToTMember09;
    @FXML
    private ToggleButton sendToTMember10;
    @FXML
    private ToggleButton sendToTMember11;
    @FXML
    private ToggleButton sendToTMember12;
    @FXML
    private ToggleButton sendToTMember13;
    @FXML
    private ToggleButton sendToTMember14;
    @FXML
    private ToggleButton sendToTMember15;
    @FXML
    private ToggleButton sendToTMember16;
    @FXML
    private ToggleButton sendToTMember17;
    @FXML
    private ToggleButton sendToTMember18;
    @FXML
    private ToggleButton sendToTMember19;
    @FXML
    private ToggleButton sendToTMember20;

    @FXML
    private ToggleButton catA_product01;
    @FXML
    private ToggleButton catA_product02;
    @FXML
    private ToggleButton catA_product03;
    @FXML
    private ToggleButton catA_product04;
    @FXML
    private ToggleButton catA_product05;
    @FXML
    private ToggleButton catA_product06;
    @FXML
    private ToggleButton catA_product07;
    @FXML
    private ToggleButton catA_product08;
    @FXML
    private ToggleButton catA_product09;
    @FXML
    private ToggleButton catA_product10;
    @FXML
    private ToggleButton catA_product11;
    @FXML
    private ToggleButton catA_product12;
    @FXML
    private ToggleButton catA_product13;
    @FXML
    private ToggleButton catA_product14;
    @FXML
    private ToggleButton catA_product15;
    @FXML
    private ToggleButton catA_product16;
    @FXML
    private ToggleButton catA_product17;
    @FXML
    private ToggleButton catA_product18;

    @FXML
    private ToggleButton catB_product01;
    @FXML
    private ToggleButton catB_product02;
    @FXML
    private ToggleButton catB_product03;
    @FXML
    private ToggleButton catB_product04;
    @FXML
    private ToggleButton catB_product05;
    @FXML
    private ToggleButton catB_product06;
    @FXML
    private ToggleButton catB_product07;
    @FXML
    private ToggleButton catB_product08;
    @FXML
    private ToggleButton catB_product09;
    @FXML
    private ToggleButton catB_product10;
    @FXML
    private ToggleButton catB_product11;
    @FXML
    private ToggleButton catB_product12;
    @FXML
    private ToggleButton catB_product13;
    @FXML
    private ToggleButton catB_product14;
    @FXML
    private ToggleButton catB_product15;
    @FXML
    private ToggleButton catB_product16;
    @FXML
    private ToggleButton catB_product17;
    @FXML
    private ToggleButton catB_product18;

    @FXML
    private ToggleButton catC_product01;
    @FXML
    private ToggleButton catC_product02;
    @FXML
    private ToggleButton catC_product03;
    @FXML
    private ToggleButton catC_product04;
    @FXML
    private ToggleButton catC_product05;
    @FXML
    private ToggleButton catC_product06;
    @FXML
    private ToggleButton catC_product07;
    @FXML
    private ToggleButton catC_product08;
    @FXML
    private ToggleButton catC_product09;
    @FXML
    private ToggleButton catC_product10;
    @FXML
    private ToggleButton catC_product11;
    @FXML
    private ToggleButton catC_product12;
    @FXML
    private ToggleButton catC_product13;
    @FXML
    private ToggleButton catC_product14;
    @FXML
    private ToggleButton catC_product15;
    @FXML
    private ToggleButton catC_product16;
    @FXML
    private ToggleButton catC_product17;
    @FXML
    private ToggleButton catC_product18;

    @FXML
    private ToggleButton catD_product01;
    @FXML
    private ToggleButton catD_product02;
    @FXML
    private ToggleButton catD_product03;
    @FXML
    private ToggleButton catD_product04;
    @FXML
    private ToggleButton catD_product05;
    @FXML
    private ToggleButton catD_product06;
    @FXML
    private ToggleButton catD_product07;
    @FXML
    private ToggleButton catD_product08;
    @FXML
    private ToggleButton catD_product09;

    @FXML
    private TextArea detailsTextArea;

    List<ToggleButton> products = new ArrayList<>();
    List<Member> membersFromJSON = new ArrayList<>();
    List<ToggleButton> sendToTeamMembers = new ArrayList<>();
    List<Label> labels = new ArrayList<>();
    SendMail sendMail = new SendMail();

    JSONExistsValidator jsonExistsValidator = new JSONExistsValidator();
    SettingsFileNotFoundAlert settingsFileNotFoundAlert = new SettingsFileNotFoundAlert();

    @FXML
    void initialize() {

        labels.add(catName_A);
        labels.add(catName_B);
        labels.add(catName_C);
        labels.add(catName_D);

        sendToTeamMembers.add(sendToTMember01);
        sendToTeamMembers.add(sendToTMember02);
        sendToTeamMembers.add(sendToTMember03);
        sendToTeamMembers.add(sendToTMember04);
        sendToTeamMembers.add(sendToTMember05);
        sendToTeamMembers.add(sendToTMember06);
        sendToTeamMembers.add(sendToTMember07);
        sendToTeamMembers.add(sendToTMember08);
        sendToTeamMembers.add(sendToTMember09);
        sendToTeamMembers.add(sendToTMember10);
        sendToTeamMembers.add(sendToTMember11);
        sendToTeamMembers.add(sendToTMember12);
        sendToTeamMembers.add(sendToTMember13);
        sendToTeamMembers.add(sendToTMember14);
        sendToTeamMembers.add(sendToTMember15);
        sendToTeamMembers.add(sendToTMember16);
        sendToTeamMembers.add(sendToTMember17);
        sendToTeamMembers.add(sendToTMember18);
        sendToTeamMembers.add(sendToTMember19);
        sendToTeamMembers.add(sendToTMember20);

        products.add(catA_product01);
        products.add(catA_product02);
        products.add(catA_product03);
        products.add(catA_product04);
        products.add(catA_product05);
        products.add(catA_product06);
        products.add(catA_product07);
        products.add(catA_product08);
        products.add(catA_product09);
        products.add(catA_product10);
        products.add(catA_product11);
        products.add(catA_product12);
        products.add(catA_product13);
        products.add(catA_product14);
        products.add(catA_product15);
        products.add(catA_product16);
        products.add(catA_product17);
        products.add(catA_product18);
        products.add(catB_product01);
        products.add(catB_product02);
        products.add(catB_product03);
        products.add(catB_product04);
        products.add(catB_product05);
        products.add(catB_product06);
        products.add(catB_product07);
        products.add(catB_product08);
        products.add(catB_product09);
        products.add(catB_product10);
        products.add(catB_product11);
        products.add(catB_product12);
        products.add(catB_product13);
        products.add(catB_product14);
        products.add(catB_product15);
        products.add(catB_product16);
        products.add(catB_product17);
        products.add(catB_product18);
        products.add(catC_product01);
        products.add(catC_product02);
        products.add(catC_product03);
        products.add(catC_product04);
        products.add(catC_product05);
        products.add(catC_product06);
        products.add(catC_product07);
        products.add(catC_product08);
        products.add(catC_product09);
        products.add(catC_product10);
        products.add(catC_product11);
        products.add(catC_product12);
        products.add(catC_product13);
        products.add(catC_product14);
        products.add(catC_product15);
        products.add(catC_product16);
        products.add(catC_product17);
        products.add(catC_product18);
        products.add(catD_product01);
        products.add(catD_product02);
        products.add(catD_product03);
        products.add(catD_product04);
        products.add(catD_product05);
        products.add(catD_product06);
        products.add(catD_product07);
        products.add(catD_product08);
        products.add(catD_product09);

        readJSONToMembersList();
        fillSendToButtons();
        readCategoriesAndProducts();
    }

    private void readCategoriesAndProducts() {
        Reader products = null;
        try {
            final String filePath = JSONFilePaths.productsFilePath;
            products = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            settingsFileNotFoundAlert.showAlert();
        }
        Gson gson = new Gson();
        Type productList = new TypeToken<ArrayList<Product>>() {
        }.getType();
        List<Product> loadedProducts = gson.fromJson(products, productList);

        for (int i = 0; i < this.products.size(); i++) {
            if (!loadedProducts.get(i).getName().equals("")) {
                this.products.get(i).setText(loadedProducts.get(i).getName());
            }
        }

        Reader categories = null;
        try {
            final String filepath = JSONFilePaths.categoriesFilePath;
            categories = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type categoryList = new TypeToken<ArrayList<ProductCategory>>() {
        }.getType();
        List<ProductCategory> loadedCategories = gson.fromJson(categories, categoryList);

        for (int i = 0; i < labels.size(); i++) {
            if (!loadedCategories.get(i).getName().equals("")) {
                labels.get(i).setText(loadedCategories.get(i).getName());
            }
        }
        if (!loadedCategories.get(4).getName().equals("")) {
            detailsLabel.setText(loadedCategories.get(4).getName());
        }
        if (!loadedCategories.get(5).getName().equals("")) {
            subjectRadio1.setText(loadedCategories.get(5).getName());
        }
        if (!loadedCategories.get(6).getName().equals("")) {
            subjectRadio2.setText(loadedCategories.get(6).getName());
        }
        if (!loadedCategories.get(7).getName().equals("")) {
            subjectRadio3.setText(loadedCategories.get(7).getName());
        }
        if (!loadedCategories.get(8).getName().equals("")) {
            subjectRadio4.setText(loadedCategories.get(8).getName());
        }
        if (!loadedCategories.get(9).getName().equals("")) {
            checkBox1.setText(loadedCategories.get(9).getName());
        }
        if (!loadedCategories.get(10).getName().equals("")) {
            checkBox2.setText(loadedCategories.get(10).getName());
        }
    }

    private void readJSONToMembersList() {
        Reader reader = null;
        try {
            final String filePath = JSONFilePaths.membersJSONFilePath;
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            settingsFileNotFoundAlert.showAlert();
        }
        Gson gson = new Gson();
        Type memberList = new TypeToken<ArrayList<Member>>() {
        }.getType();
        membersFromJSON = gson.fromJson(reader, memberList);
    }

    private void fillSendToButtons() {
        for (int i = 0; i < sendToTeamMembers.size(); i++) {
            sendToTeamMembers.get(i).setText(membersFromJSON.get(i).getName());
        }
    }

    private String getSubject() {
        if (subjectRadio1.isSelected()) {
            return subjectRadio1.getText();
        } else if (subjectRadio2.isSelected()) {
            return subjectRadio2.getText();
        } else if (subjectRadio3.isSelected()) {
            return subjectRadio3.getText();
        } else if (subjectRadio4.isSelected()){
            return subjectRadio4.getText();
        }
        return null;
    }


    private String getProducts() {
        String text = null;
        StringBuilder sb = new StringBuilder();
        for (ToggleButton button : products) {
            if (button.isSelected()) {
                sb.append(button.getText()).append(", ");
            }
        }
        text = sb.toString();
        if (text != null && text.length() > 0 && text.charAt(text.length() - 1) == ',') {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }

    private String getAddresses() {
        String text = null;
        StringBuilder sb = new StringBuilder();
        List<String> selected = new ArrayList<>();
        for (ToggleButton toggleButton : sendToTeamMembers) {
            if (toggleButton.isSelected()) {
                selected.add(toggleButton.getText());
            }
        }
        for (int i = 0; i < selected.size(); i++) {
            for (int k = 0; k < membersFromJSON.size(); k++) {
                if (selected.get(i).equals(membersFromJSON.get(k).getName())) {
                    sb.append(membersFromJSON.get(k).getEmail()).append(",");
                    break;
                }
            }
        }
        text = sb.toString();
        if (text != null && text.length() > 0 && text.charAt(text.length() - 1) == ',') {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }


    public void send(ActionEvent actionEvent) {
        CustomerInfoMissingAlert customerInfoMissingAlert = new CustomerInfoMissingAlert();
        if (customerName.getText().equals("")
                || customerCompany.getText().equals("")
                || customerPhone.getText().equals("")
                || customerEmail.getText().equals("")
                || customerBudget.getText().equals("")
                || customerDateOfDelivery.getText().equals("")) {
            customerInfoMissingAlert.showAlert();
            return;
        }

        SubjectMissingAlert subjectMissingAlert = new SubjectMissingAlert();
        if(getSubject() == null){
            subjectMissingAlert.showAlert();
            return;
        }

        ProductsMissingAlert productsMissingAlert = new ProductsMissingAlert();
        if(getProducts().equals("") || getProducts() == null){
            productsMissingAlert.showAlert();
            return;
        }

        SendToMissingAlert sendToMissingAlert = new SendToMissingAlert();
        if(getAddresses().equals("") || getProducts() == null){
            sendToMissingAlert.showAlert();
            return;
        }

        Message message = new Message();
        message.setCustomerName(customerName.getText());
        message.setCustomerCompany(customerCompany.getText());
        message.setCustomerBudget(customerBudget.getText());
        message.setCustomerPhone(customerPhone.getText());
        message.setCustomerEmail(customerEmail.getText());
        message.setCustomerDeliveryDate(customerDateOfDelivery.getText());
        message.setSubject(getSubject());
        message.setStatus1(checkBox1.isSelected());
        message.setStatus2(checkBox2.isSelected());
        message.setProducts(getProducts());
        message.setDetails(detailsTextArea.getText());
        message.setSendTo(getAddresses());
        sendMail.send(message, EmailServerSettings.loadSettingsFromJSON());

        MessageSuccessfulySendAlert messageSuccessfulySendAlert = new MessageSuccessfulySendAlert();
        messageSuccessfulySendAlert.showAlert();
        StageConfig.getLauncherController().openWaitingModeTab();
        clearAllFields();
    }


    public void sendQuickOffer(ActionEvent event) {
    }

    private void clearAllFields(){
        customerName.setText("");
        customerCompany.setText("");
        customerPhone.setText("");
        customerEmail.setText("");
        customerBudget.setText("");
        customerDateOfDelivery.setText("");
        detailsTextArea.setText("");
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        subjectRadio1.setSelected(false);
        subjectRadio2.setSelected(false);
        subjectRadio3.setSelected(false);
        subjectRadio4.setSelected(false);

        for (ToggleButton toggleButton : sendToTeamMembers) {
            toggleButton.setSelected(false);
        }
        for (ToggleButton toggleButton : products) {
            toggleButton.setSelected(false);
        }

    }
}
