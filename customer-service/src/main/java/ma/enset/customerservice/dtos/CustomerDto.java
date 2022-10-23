package ma.enset.customerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link ma.enset.customerservice.entities.Customer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto  {
    private  String id;
    private  String name;
    private  String email;
    private  String phone;
}
