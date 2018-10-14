package Controllers.Main;

import Helpers.JSON.JSONFilePaths;
import Helpers.JSON.ObjectMapperSingleton;
import Model.Member;
import Model.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class NewConversationController {

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
    private RadioButton subjectRadio1;
    @FXML
    private RadioButton subjectRadio2;
    @FXML
    private RadioButton subjectRadio3;
    @FXML
    private RadioButton subjectRadio4;
    @FXML
    private CheckBox importantCheckBox;
    @FXML
    private CheckBox delayCheckBox;


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

    List<ToggleButton> chosenProducts = new ArrayList<>();
    List<Member> membersFromJSON = new ArrayList<>();
    List<ToggleButton> sendToTeamMembers = new ArrayList<>();

    @FXML
    void initialize() {

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

        chosenProducts.add(catA_product01);
        chosenProducts.add(catA_product02);
        chosenProducts.add(catA_product03);
        chosenProducts.add(catA_product04);
        chosenProducts.add(catA_product05);
        chosenProducts.add(catA_product06);
        chosenProducts.add(catA_product07);
        chosenProducts.add(catA_product08);
        chosenProducts.add(catA_product09);
        chosenProducts.add(catA_product10);
        chosenProducts.add(catA_product11);
        chosenProducts.add(catA_product12);
        chosenProducts.add(catA_product13);
        chosenProducts.add(catA_product14);
        chosenProducts.add(catA_product15);
        chosenProducts.add(catA_product16);
        chosenProducts.add(catA_product17);
        chosenProducts.add(catA_product18);
        chosenProducts.add(catB_product01);
        chosenProducts.add(catB_product02);
        chosenProducts.add(catB_product03);
        chosenProducts.add(catB_product04);
        chosenProducts.add(catB_product05);
        chosenProducts.add(catB_product06);
        chosenProducts.add(catB_product07);
        chosenProducts.add(catB_product08);
        chosenProducts.add(catB_product09);
        chosenProducts.add(catB_product10);
        chosenProducts.add(catB_product11);
        chosenProducts.add(catB_product12);
        chosenProducts.add(catB_product13);
        chosenProducts.add(catB_product14);
        chosenProducts.add(catB_product15);
        chosenProducts.add(catB_product16);
        chosenProducts.add(catB_product17);
        chosenProducts.add(catB_product18);
        chosenProducts.add(catC_product01);
        chosenProducts.add(catC_product02);
        chosenProducts.add(catC_product03);
        chosenProducts.add(catC_product04);
        chosenProducts.add(catC_product05);
        chosenProducts.add(catC_product06);
        chosenProducts.add(catC_product07);
        chosenProducts.add(catC_product08);
        chosenProducts.add(catC_product09);
        chosenProducts.add(catC_product10);
        chosenProducts.add(catC_product11);
        chosenProducts.add(catC_product12);
        chosenProducts.add(catC_product13);
        chosenProducts.add(catC_product14);
        chosenProducts.add(catC_product15);
        chosenProducts.add(catC_product16);
        chosenProducts.add(catC_product17);
        chosenProducts.add(catC_product18);
        chosenProducts.add(catD_product01);
        chosenProducts.add(catD_product02);
        chosenProducts.add(catD_product03);
        chosenProducts.add(catD_product04);
        chosenProducts.add(catD_product05);
        chosenProducts.add(catD_product06);
        chosenProducts.add(catD_product07);
        chosenProducts.add(catD_product08);
        chosenProducts.add(catD_product09);

        readJSONToMembersList();
        fillSendToButtons();
    }

    private void readJSONToMembersList() {
        Reader reader = null;
        try {
            reader = new FileReader(JSONFilePaths.membersJSONFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        } else return subjectRadio4.getText();
    }

    private String getProductsInConversation() {
        StringBuilder sb = new StringBuilder();
        for (ToggleButton button : chosenProducts) {
            if (button.isSelected()) {
                sb.append(button.getText()).append(", ");
            }
        }
        return sb.toString();
    }


    private String sendToEmails() {
        StringBuilder sb = new StringBuilder();

        List<ToggleButton> selected = new ArrayList<>();

        for (ToggleButton toggleButton : sendToTeamMembers) {
            if (toggleButton.isSelected()) {
                //TODO: Fill logic
            }
        }


        return sb.toString();
    }


    public void send(ActionEvent actionEvent) {
        Message message = new Message();
        message.setCustomerName(customerName.getText());
        message.setCustomerCompany(customerCompany.getText());
        message.setCustomerBudget(customerBudget.getText());
        message.setCustomerPhone(customerPhone.getText());
        message.setCustomerEmail(customerEmail.getText());
        message.setCustomerDeliveryDate(customerDateOfDelivery.getText());
        message.setSubject(getSubject());
        message.setStatusImportant(importantCheckBox.isSelected());
        message.setStatusIsDelay(delayCheckBox.isSelected());
        message.setProducts(getProductsInConversation());
        message.setDetails(detailsTextArea.getText());
        message.setSendTo(sendToEmails());

        System.out.println(message);

    }


}
