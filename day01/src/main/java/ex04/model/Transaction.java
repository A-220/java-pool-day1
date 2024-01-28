package ex04.model;

import ex04.enums.TransferCategory;
import ex04.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private Double transferAmount;
}
