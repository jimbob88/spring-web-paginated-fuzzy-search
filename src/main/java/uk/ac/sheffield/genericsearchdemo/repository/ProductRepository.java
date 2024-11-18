package uk.ac.sheffield.genericsearchdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.sheffield.genericsearchdemo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
