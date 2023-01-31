package ru.kalan.smartshop.product.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kalan.smartshop.exception.NotFoundEntityException;
import ru.kalan.smartshop.product.ProductMapper;
import ru.kalan.smartshop.product.ProductRepository;
import ru.kalan.smartshop.product.ProductService;
import ru.kalan.smartshop.product.dto.ProductDto;
import ru.kalan.smartshop.product.model.Product;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> searchProduct(String text, Integer from, Integer size) {
        int page = from / size;
        Pageable pageable = PageRequest.of(page, size);
        return ProductMapper.toDtoList(productRepository.findByTitle(text, pageable));
    }

    @Override
    public ProductDto getById(Long productId) {
        final Product inDb = productRepository.findById(productId).orElseThrow(() ->
                new NotFoundEntityException(String
                        .format("Product with id=%d was not found.", productId)));
        log.info("Get product {}", productId);
        return ProductMapper.toDto(inDb);
    }

    @Override
    public List<ProductDto> getProductByIds(List<Long> productIds) {
        return ProductMapper.toDtoList(productRepository.findAllById(productIds));
    }
}
