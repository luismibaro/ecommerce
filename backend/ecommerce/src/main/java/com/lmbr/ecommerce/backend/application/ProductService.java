package com.lmbr.ecommerce.backend.application;

import com.lmbr.ecommerce.backend.domain.model.Product;
import com.lmbr.ecommerce.backend.domain.port.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
public class ProductService {

    private static final String IMAGE_URL_PREFIX = "http://localhost:8085/images/";

    private final IProductRepository iProductRepository;
    private final UploadFile uploadFile;

    public ProductService(IProductRepository iProductRepository, UploadFile uploadFile) {
        this.iProductRepository = iProductRepository;
        this.uploadFile = uploadFile;
    }

    public Product save(Product product, MultipartFile multipartFile) throws IOException {
        if (product.getId() != 0) { // When a product is modified
            if (multipartFile == null) {
                product.setUrlImage(product.getUrlImage());
            } else {
                String nameFile = getFileNameFromUrl(product.getUrlImage());
                if (!"default.jpg".equals(nameFile)) {
                    uploadFile.delete(nameFile);
                }
                product.setUrlImage(uploadFile.upload(multipartFile));
            }
        } else {
            product.setUrlImage(uploadFile.upload(multipartFile));
        }
        return this.iProductRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    public Product findById(Integer id) {
        return this.iProductRepository.findById(id);
    }

    public void deleteById(Integer id) {
        Product product = findById(id);
        String nameFile = getFileNameFromUrl(product.getUrlImage());
        if (!"default.jpg".equals(nameFile)) {
            uploadFile.delete(nameFile);
        }
        this.iProductRepository.deleteById(id);
    }

    private String getFileNameFromUrl(String url) {
        if (url != null && url.startsWith(IMAGE_URL_PREFIX)) {
            return url.substring(IMAGE_URL_PREFIX.length());
        }
        return null;
    }
}
