package ma.enset.walletservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Wallet {
    @Id
    private String id;
    private Long createdAt;
    private Double balance;
    @ManyToOne
    private Currency currency;
    private String userId;
    @OneToMany(mappedBy = "wallet")
    List<WalletTransaction> transactions;
}
