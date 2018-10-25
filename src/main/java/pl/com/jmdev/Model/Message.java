
package pl.com.jmdev.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {

    String customerName;
    String customerCompany;
    String customerBudget;
    String customerPhone;
    String customerEmail;
    String customerDeliveryDate;
    String subject;
    boolean status1;
    boolean status2;
    String products;
    String details;
    String sendTo;

    @Override
    public String toString() {
        return "Nowy email:" + "\n" +
                "Imię i nazwisko: " + customerName + "\n" +
                "Nazwa firmy: " + customerCompany + "\n" +
                "Budżet netto" + customerBudget + "\n" +
                "Nr telefonu: " + customerPhone + "\n" +
                "Email: " + customerEmail + "\n" +
                "Termin dostawy" + customerDeliveryDate + "\n" +
                "Temat: " + subject + "\n" +
                "Czy bardzo ważne: " + status1 + "\n" +
                "Czy jest opóźnienie: " + status2 + "\n" +
                "Interesuje się produktami: " + products + "\n" +
                "Szczegóły: " + details + "\n" +
                "Wyślij powiadomienie do: " + sendTo + "\n";
    }
}
