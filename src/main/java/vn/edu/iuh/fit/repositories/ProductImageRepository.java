package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}