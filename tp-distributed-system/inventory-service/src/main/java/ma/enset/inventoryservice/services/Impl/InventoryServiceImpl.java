package ma.enset.inventoryservice.services.Impl;

import lombok.AllArgsConstructor;
import ma.enset.inventoryservice.dtos.ProductDto;
import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.mappers.ObjectMapperUtils;
import ma.enset.inventoryservice.repositories.ProductRepository;
import ma.enset.inventoryservice.services.InventoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private ProductRepository productRepository;

    @Override
    public ProductDto getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return ObjectMapperUtils.map(product.get(), ProductDto.class);
        }
        return null;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productRepository.save(ObjectMapperUtils.map(productDto, Product.class));
        return ObjectMapperUtils.map(product, ProductDto.class);
    }

    @Override
    public boolean deleteProduct(Long productId) {
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        if(productRepository.existsById(productId)){
            Product product = productRepository.save(ObjectMapperUtils.map(productDto, Product.class));
            return ObjectMapperUtils.map(product, ProductDto.class);
        }
        return null;
    }

    @Override
    public List<ProductDto>  getAllProducts(int page, int size) {
        if (page > 0)
            page -= 1;
        Pageable pageableRequest = PageRequest.of(page, size);
        Page productPage = productRepository.findAll(pageableRequest);
        List<Product> products = productPage.getContent();
        return ObjectMapperUtils.mapAll(products, ProductDto.class);
    }
}
