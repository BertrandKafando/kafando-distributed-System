package ma.enset.inventoryservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.NamedEntityGraph;
import java.io.Serializable;

/**
 * A DTO for the {@link ma.enset.inventoryservice.entities.Product} entity
 */
@Data @AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private  Long productId;
    private  String name;
    private  double price;
}
