package com.rohit.dream_shops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rohit.dream_shops.model.Image;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProductId(Long id);
}