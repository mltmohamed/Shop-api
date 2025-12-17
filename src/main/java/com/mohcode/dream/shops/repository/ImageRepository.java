package com.mohcode.dream.shops.repository;

import com.mohcode.dream.shops.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
