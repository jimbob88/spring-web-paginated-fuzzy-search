package uk.ac.sheffield.genericsearchdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.sheffield.genericsearchdemo.model.Product;
import uk.ac.sheffield.genericsearchdemo.service.GenericSearchService;

import java.util.List;

@RestController
public class ProductController {
    private final GenericSearchService genericSearchService;

    @Autowired
    public ProductController(GenericSearchService productService) {
        this.genericSearchService = productService;
    }

    @GetMapping("/products")
    public List<Product> getPaginatedProducts(Pageable pageable, @RequestParam String columnName, @RequestParam String searchTerm, @RequestParam String sortBy, @RequestParam(defaultValue = "true") boolean ascending) {
        Sort sortingOrder = Sort.by(ascending ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy));
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortingOrder);
        Page<Product> productPage = genericSearchService.search(Product.class, columnName, searchTerm, pageRequest);
        return productPage.getContent();
    }
}
