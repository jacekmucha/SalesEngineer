
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
    List<String> products;
    String details;
    List<String> sendTo;

    @Override
    public String toString() {
        return "Message{" +
                "customerName='" + customerName + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                ", customerBudget=" + customerBudget +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerDeliveryDate='" + customerDeliveryDate + '\'' +
                ", subject='" + subject + '\'' +
                ", statusImportant=" + statusImportant +
                ", statusIsDelay=" + statusIsDelay +
                ", products=" + products +
                ", details='" + details + '\'' +
                ", sendTo=" + sendTo +
                '}';
    }
}
