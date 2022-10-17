package ma.enset.inventoryservice.services;

import ma.enset.inventoryservice.dtos.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {
    public ProductDto getProductById(Long productId);
    public ProductDto saveProduct(ProductDto productDto);
    public boolean deleteProduct(Long productId);
    public ProductDto updateProduct(Long productId, ProductDto productDto);
    public List<ProductDto> getAllProducts(int page, int size);
}
