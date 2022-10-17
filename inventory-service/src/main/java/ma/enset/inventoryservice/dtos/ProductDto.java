package ma.enset.inventoryservice.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ma.enset.inventoryservice.entities.Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final Long productId;
    private final String name;
    private final double price;
}
