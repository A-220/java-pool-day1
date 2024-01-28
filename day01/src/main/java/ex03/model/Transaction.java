package ex03.model;

import ex00.enums.TransferCategory;
import ex00.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Transaction {
    private UUID id;
    private ex00.model.User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private Double transferAmount;
}
