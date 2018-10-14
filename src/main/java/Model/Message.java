
package Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    boolean statusImportant;
    boolean statusIsDelay;
    String products;
    String details;
    String sendTo;

    @Override
    public String toString() {
        return "Message{" +
                "customerName='" + customerName + "\n" +
                ", customerCompany='" + customerCompany + "\n" +
                ", customerBudget=" + customerBudget +
                ", customerPhone='" + customerPhone + "\n" +
                ", customerEmail='" + customerEmail + "\n" +
                ", customerDeliveryDate='" + customerDeliveryDate + "\n" +
                ", subject='" + subject + "\n" +
                ", statusImportant=" + statusImportant + "\n" +
                ", statusIsDelay=" + statusIsDelay + "\n" +
                ", products=" + products + "\n" +
                ", details='" + details + "\n" +
                ", sendTo=" + sendTo +
                '}';
    }
}
