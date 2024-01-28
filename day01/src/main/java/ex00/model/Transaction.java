package ex00.model;

import ex00.enums.TransferCategory;
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
