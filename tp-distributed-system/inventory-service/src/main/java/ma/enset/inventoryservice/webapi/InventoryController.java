package ma.enset.inventoryservice.webapi;

import lombok.AllArgsConstructor;
import ma.enset.inventoryservice.dtos.ProductDto;
import ma.enset.inventoryservice.services.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private InventoryService inventoryService;

    @PostMapping
    public ProductDto addProduct( @RequestBody ProductDto productDto) {
        return inventoryService.saveProduct(productDto);
    }

    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size) {
        List<ProductDto> productDtos = inventoryService.getAllProducts(page, size);
        return productDtos;
    }
    @GetMapping("/productId")
    public ProductDto getProductById(@PathVariable Long productId) {
        ProductDto productDto= inventoryService.getProductById(productId);
        return productDto;
    }

    @PutMapping("/productId")
    public ProductDto updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
        ProductDto product= inventoryService.updateProduct(productId,productDto);
        return product;
    }

    @DeleteMapping("/productId")
    public boolean deleteProduct(@PathVariable Long productId) {
        return inventoryService.deleteProduct(productId);
    }


}
