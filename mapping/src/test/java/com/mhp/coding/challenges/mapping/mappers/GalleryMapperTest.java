package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.mappers.GalleryMapper;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalleryMapperTest {

    private GalleryMapper galleryMapper;
    private ImageMapper imageMapper;

    @Before
    public void setUp() {
        imageMapper = Mockito.mock(ImageMapper.class);
        galleryMapper = new GalleryMapper(imageMapper);
    }

    @Test
    public void testMapToDto() {
        // Create a sample GalleryBlock
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setSortIndex(1);

        Image image1 = new Image();
        Image image2 = new Image();

        List<Image> images = Arrays.asList(image1, image2);
        galleryBlock.setImages(images);

        // Mock the imageMapper.map() method
        ImageDto imageDto1 = new ImageDto();
        ImageDto imageDto2 = new ImageDto();
        Mockito.when(imageMapper.map(image1)).thenReturn(imageDto1);
        Mockito.when(imageMapper.map(image2)).thenReturn(imageDto2);

        // Map GalleryBlock to GalleryBlockDto
        GalleryBlockDto galleryBlockDto = galleryMapper.map(galleryBlock);

        // Assertions
        Assert.assertEquals(galleryBlock.getSortIndex(), galleryBlockDto.getSortIndex());
        Assert.assertEquals(images.size(), galleryBlockDto.getImages().size());
        Assert.assertEquals(imageDto1, galleryBlockDto.getImages().get(0));
        Assert.assertEquals(imageDto2, galleryBlockDto.getImages().get(1));
    }

    @Test
    public void testMapToEntity() {
        // Create a sample GalleryBlockDto
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto();
        galleryBlockDto.setSortIndex(1);

        ImageDto imageDto1 = new ImageDto();
        ImageDto imageDto2 = new ImageDto();

        List<ImageDto> imageDtos = Arrays.asList(imageDto1, imageDto2);
        galleryBlockDto.setImages(imageDtos);

        // Mock the imageMapper.map() method
        Image image1 = new Image();
        Image image2 = new Image();
        Mockito.when(imageMapper.map(imageDto1)).thenReturn(image1);
        Mockito.when(imageMapper.map(imageDto2)).thenReturn(image2);

        // Map GalleryBlockDto to GalleryBlock
        GalleryBlock galleryBlock = galleryMapper.map(galleryBlockDto);

        // Assertions
        Assert.assertEquals(galleryBlockDto.getSortIndex(), galleryBlock.getSortIndex());
        Assert.assertEquals(imageDtos.size(), galleryBlock.getImages().size());
        Assert.assertEquals(image1, galleryBlock.getImages().get(0));
        Assert.assertEquals(image2, galleryBlock.getImages().get(1));
    }
}
