package ma.enset.walletservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    private String code;
    private String name;
    private String symbol;
    private Double salePrice;
    private Double purchasePrice;

    @OneToMany(mappedBy = "currency")
    List<Wallet> wallets;
}
