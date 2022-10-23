package ma.enset.walletservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.walletservice.enums.TransactionType;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class WalletTransaction {
    @javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long timestamp;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ManyToOne()
    private Wallet wallet;
}
