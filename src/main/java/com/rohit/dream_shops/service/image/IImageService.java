package com.rohit.dream_shops.service.image;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.rohit.dream_shops.dto.ImageDto;
import com.rohit.dream_shops.model.Image;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);
    void updateImage(MultipartFile file,  Long imageId);
}
