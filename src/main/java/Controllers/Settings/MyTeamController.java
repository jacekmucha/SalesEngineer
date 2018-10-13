package Controllers.Settings;

import Helpers.ComboBox.MyTeamComboBoxHelper;
import Helpers.JSON.JSONFilePaths;
import Helpers.Member.MemberToTableViewHelper;
import Model.Member;
import Utils.CSVHelper.CSVReader;
import Helpers.JSON.ObjectMapperSingleton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyTeamController {

    @FXML
    private TableView<MemberToTableViewHelper> myTeamTable;
    @FXML
    private TableColumn myTeamName;
    @FXML
    private TableColumn myTeamEmail;

    @FXML
    private ComboBox viewBoxSet01;
    @FXML
    private ComboBox viewBoxSet02;
    @FXML
    private ComboBox viewBoxSet03;
    @FXML
    private ComboBox viewBoxSet04;
    @FXML
    private ComboBox viewBoxSet05;
    @FXML
    private ComboBox viewBoxSet06;
    @FXML
    private ComboBox viewBoxSet07;
    @FXML
    private ComboBox viewBoxSet08;
    @FXML
    private ComboBox viewBoxSet09;
    @FXML
    private ComboBox viewBoxSet10;
    @FXML
    private ComboBox viewBoxSet11;
    @FXML
    private ComboBox viewBoxSet12;
    @FXML
    private ComboBox viewBoxSet13;
    @FXML
    private ComboBox viewBoxSet14;
    @FXML
    private ComboBox viewBoxSet15;
    @FXML
    private ComboBox viewBoxSet16;
    @FXML
    private ComboBox viewBoxSet17;
    @FXML
    private ComboBox viewBoxSet18;
    @FXML
    private ComboBox viewBoxSet19;
    @FXML
    private ComboBox viewBoxSet20;

    private String indexesFilePath;

    List<ComboBox> myTeamComboBoxes = new ArrayList<>();
    List<Member> membersFromCSV = new ArrayList<>();


    /**
     * This method creates JSON file, that app needs to fill ToggleButtons in NewConversation tab.
     * Data needed to fill list of Member objects comes from MyTeam tab (combo boxes) in Settings.
     * This method compare names of members from list created form CSV file with items chosen in ComboBoxes to generate emails.
     */
    public void createMembersFromComboBoxList() {
        List<Member> members = new ArrayList<>();
        for (ComboBox comboBox : myTeamComboBoxes) {
            Member member = new Member();
            Integer index = comboBox.getSelectionModel().getSelectedIndex();
            member.setId(index);
            String name = (String) comboBox.getSelectionModel().getSelectedItem();
            member.setName(name);
            String email = null;

            for (Member readedMember : membersFromCSV) {
                if (readedMember.getName().equals(name)) {
                    email = readedMember.getEmail();
                }
            }
            member.setEmail(email);
            members.add(member);
        }
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(JSONFilePaths.membersJSONFilePath)) {
            gson.toJson(members, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize() {

        final ObservableList<MemberToTableViewHelper> myTeamRecords = FXCollections.observableArrayList();

        myTeamComboBoxes.add(viewBoxSet01);
        myTeamComboBoxes.add(viewBoxSet02);
        myTeamComboBoxes.add(viewBoxSet03);
        myTeamComboBoxes.add(viewBoxSet04);
        myTeamComboBoxes.add(viewBoxSet05);
        myTeamComboBoxes.add(viewBoxSet06);
        myTeamComboBoxes.add(viewBoxSet07);
        myTeamComboBoxes.add(viewBoxSet08);
        myTeamComboBoxes.add(viewBoxSet09);
        myTeamComboBoxes.add(viewBoxSet10);
        myTeamComboBoxes.add(viewBoxSet11);
        myTeamComboBoxes.add(viewBoxSet12);
        myTeamComboBoxes.add(viewBoxSet13);
        myTeamComboBoxes.add(viewBoxSet14);
        myTeamComboBoxes.add(viewBoxSet15);
        myTeamComboBoxes.add(viewBoxSet16);
        myTeamComboBoxes.add(viewBoxSet17);
        myTeamComboBoxes.add(viewBoxSet18);
        myTeamComboBoxes.add(viewBoxSet19);
        myTeamComboBoxes.add(viewBoxSet20);


        TableColumn name = myTeamName;
        TableColumn email = myTeamEmail;
        myTeamTable.getColumns().addAll(name, email);
        myTeamTable.setItems(myTeamRecords);

        createMembersLists(myTeamRecords);

        name.setCellValueFactory(new PropertyValueFactory<MemberToTableViewHelper, String>("name"));
        email.setCellValueFactory(new PropertyValueFactory<MemberToTableViewHelper, String>("email"));

        fillComboBox(myTeamRecords, myTeamComboBoxes);
        fillComboBoxByDefault();
    }

    /**
     * This method creates two lists: 1st for fill TableView in Settings tab, 2nd is
     * needed to create members to load them by default during app's launch in NewConversation tab
     *
     * @param dataList
     */
    private void createMembersLists(ObservableList<MemberToTableViewHelper> dataList) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(CSVReader.CSV_MY_TEAM));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(CSVReader.FIELD_DELIMITER, -1);
                MemberToTableViewHelper record = new MemberToTableViewHelper(fields[0], fields[1]);
                dataList.add(record);
                Member memberFromCSV = new Member();
                memberFromCSV.setName(fields[0]);
                memberFromCSV.setEmail(fields[1]);
                membersFromCSV.add(memberFromCSV);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVReader.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    private void fillComboBox(ObservableList<MemberToTableViewHelper> dataList, List<ComboBox> comboBoxes) {
        for (MemberToTableViewHelper record : dataList) {
            for (ComboBox comboBox : comboBoxes) {
                comboBox.getItems().add(record.getName());
            }
        }
    }


    private void fillComboBoxByDefault() {

        MyTeamComboBoxHelper indexes = null;
        try {
            indexes = ObjectMapperSingleton.getInstance().readValue(new File(JSONFilePaths.myIndexesFilePath), MyTeamComboBoxHelper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader reader = null;
        try {
            reader = new FileReader(JSONFilePaths.membersJSONFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type memberList = new TypeToken<ArrayList<Member>>() {}.getType();
        List<Member> members = gson.fromJson(reader, memberList);

        for (int i = 0; i < myTeamComboBoxes.size(); i++) {
                myTeamComboBoxes.get(i).getSelectionModel().select(members.get(i).getId().intValue());
        }
    }

}
