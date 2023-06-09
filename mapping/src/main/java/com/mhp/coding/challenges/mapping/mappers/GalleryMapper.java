package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;

import java.util.ArrayList;
import java.util.List;

public class GalleryMapper {

    private final ImageMapper imageMapper;

    public GalleryMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public GalleryBlockDto map(GalleryBlock galleryBlock) {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto();
        galleryBlockDto.setSortIndex(galleryBlock.getSortIndex());
        galleryBlockDto.setImages(mapImagesToDto(galleryBlock.getImages()));
        return galleryBlockDto;
    }

    public GalleryBlock map(GalleryBlockDto galleryBlockDto) {
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setSortIndex(galleryBlockDto.getSortIndex());
        galleryBlock.setImages(mapImagesToEntity(galleryBlockDto.getImages()));
        return galleryBlock;
    }

    public void updateEntity(GalleryBlock galleryBlock, GalleryBlockDto galleryBlockDto) {
        galleryBlock.setSortIndex(galleryBlockDto.getSortIndex());
        galleryBlock.setImages(mapImagesToEntity(galleryBlockDto.getImages()));
    }

    private List<ImageDto> mapImagesToDto(List<Image> images) {
        List<ImageDto> imageDtos = new ArrayList<>();
        for (Image image : images) {
            imageDtos.add(imageMapper.map(image));
        }
        return imageDtos;
    }

    private List<Image> mapImagesToEntity(List<ImageDto> imageDtos) {
        List<Image> images = new ArrayList<>();
        for (ImageDto imageDto : imageDtos) {
            images.add(imageMapper.map(imageDto));
        }
        return images;
    }
}