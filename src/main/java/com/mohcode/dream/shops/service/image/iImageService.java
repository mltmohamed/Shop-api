package com.mohcode.dream.shops.service.image;

import com.mohcode.dream.shops.dto.ImageDto;
import com.mohcode.dream.shops.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface iImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
     List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);

}
