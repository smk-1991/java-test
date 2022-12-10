package com.br.dorotech.app.services.impl;

import com.br.dorotech.app.helper.ProductsHelper;
import com.br.dorotech.app.models.dtos.ProductDTO;
import com.br.dorotech.app.models.entities.Products;
import com.br.dorotech.app.repositories.ProductRepository;
import com.br.dorotech.app.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO createNewProduct(ProductDTO productDTO) {
        Products product = new Products();
        product.setName(productDTO.getName());
        product.setAmount(productDTO.getAmount());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Products> productsList = productRepository.findAll();
        return productsList.stream()
                .map(ProductsHelper::productsDTOBuilder)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductById(Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public void updateProduct(Long id) {

    }
}
