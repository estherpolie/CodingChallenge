package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import org.springframework.stereotype.Component;

@Component

public class ImageMapper {

    public ImageDto map(Image image) {
        ImageDto imageDto = new ImageDto();
        imageDto.setId(image.getId());
        imageDto.setUrl(image.getUrl());
        imageDto.setImageSize(image.getImageSize());
        return imageDto;
    }

    public Image map(ImageDto imageDto) {
        Image image = new Image();
        image.setId(imageDto.getId());
        image.setUrl(imageDto.getUrl());
        image.setImageSize(imageDto.getImageSize());
        return image;
    }

    public void map(Image image, ImageDto imageDto) {
        image.setId(imageDto.getId());
        image.setUrl(imageDto.getUrl());
        image.setImageSize(imageDto.getImageSize());
    }
}