package com.example.toyshop.service;

import com.example.toyshop.dto.product.ProductImageDTO;
import com.example.toyshop.entity.Product;
import com.example.toyshop.entity.ProductImage;
import com.example.toyshop.repository.ProductImageRepository;
import com.example.toyshop.mapper.ProductImageMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductImageService {

    private final ProductImageRepository repository;
    private final ProductImageMapper mapper;
    private final String IMAGES_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/images/";


    public ProductImage create(MultipartFile file, Product product) throws IOException {
        String fileName = product.getId().toString() + "_" + RandomStringUtils.random(20, true, true) + "." + file.getContentType().substring(6);
        Path fileNameAndPath = Paths.get(IMAGES_DIRECTORY, fileName);
        Files.write(fileNameAndPath, file.getBytes());
        ProductImage image = new ProductImage();
        image.setProduct(product);
        image.setUrl("images/" + fileName);
        return repository.save(image);
    }

    public List<ProductImageDTO> findAllByProductId(Long id) {
        return repository.findAllByProductId(id).stream().map(mapper::toDto).collect(Collectors.toList());
    }


    public void delete(Long id) throws IOException {
        Path fileNameAndPath = Paths.get(IMAGES_DIRECTORY, Objects.requireNonNull(repository.findById(id).orElse(null)).getUrl());
        Files.delete(fileNameAndPath);
        repository.deleteById(id);
    }
}
