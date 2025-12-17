package com.mohcode.dream.shops.service.image;

import com.mohcode.dream.shops.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface iImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    Image saveImage(MultipartFile file, Long productId);
}
