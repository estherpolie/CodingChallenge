package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.mappers.ImageMapper;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImageMapperTest {
    private ImageMapper imageMapper;

    @Before
    public void setup() {
        imageMapper = new ImageMapper();
    }

    @Test
    public void testMapImageToDto() {
        Image image = new Image();
        image.setId(1L);
        image.setUrl("https://example.com/image.jpg");
//        image.setImageSize(1024);

        ImageDto imageDto = imageMapper.map(image);

        Assert.assertEquals(image.getId(), imageDto.getId());
        Assert.assertEquals(image.getUrl(), imageDto.getUrl());
        Assert.assertEquals(image.getImageSize(), imageDto.getImageSize());
    }

    @Test
    public void testMapDtoToImage() {
        ImageDto imageDto = new ImageDto();
        imageDto.setId(1L);
        imageDto.setUrl("https://example.com/image.jpg");
//        imageDto.setImageSize(1024);

        Image image = imageMapper.map(imageDto);

        Assert.assertEquals(imageDto.getId(), image.getId());
        Assert.assertEquals(imageDto.getUrl(), image.getUrl());
        Assert.assertEquals(imageDto.getImageSize(), image.getImageSize());
    }

    @Test
    public void testMapImageToDtoInPlace() {
        Image image = new Image();
        image.setId(1L);
        image.setUrl("https://example.com/image.jpg");
//        image.setImageSize(1024);

        ImageDto imageDto = new ImageDto();

        imageMapper.map(image, imageDto);

        Assert.assertEquals(image.getId(), imageDto.getId());
        Assert.assertEquals(image.getUrl(), imageDto.getUrl());
        Assert.assertEquals(image.getImageSize(), imageDto.getImageSize());
    }
}
