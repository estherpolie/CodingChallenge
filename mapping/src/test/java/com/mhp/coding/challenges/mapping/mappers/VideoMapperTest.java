package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.mappers.VideoMapper;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType;
import com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlockDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VideoMapperTest {

    @Test
    public void testMap() {
        VideoBlock videoBlock = new VideoBlock();
        videoBlock.setSortIndex(1);
        videoBlock.setUrl("https://example.com/video.mp4");
        videoBlock.setType(VideoBlockType.YOUTUBE);

        VideoMapper videoMapper = new VideoMapper();
        VideoBlockDto videoBlockDto = videoMapper.map(videoBlock);

        Assertions.assertEquals(videoBlock.getSortIndex(), videoBlockDto.getSortIndex());
        Assertions.assertEquals(videoBlock.getUrl(), videoBlockDto.getUrl());
        Assertions.assertEquals(videoBlock.getType(), videoBlockDto.getType());
    }

    @Test
    public void testToEntity() {
        VideoBlockDto videoBlockDto = new VideoBlockDto();
        videoBlockDto.setSortIndex(1);
        videoBlockDto.setUrl("https://example.com/video.mp4");
        videoBlockDto.setType(VideoBlockType.YOUTUBE);

        VideoMapper videoMapper = new VideoMapper();
        VideoBlock videoBlock = videoMapper.toEntity(videoBlockDto);

        Assertions.assertEquals(videoBlockDto.getSortIndex(), videoBlock.getSortIndex());
        Assertions.assertEquals(videoBlockDto.getUrl(), videoBlock.getUrl());
        Assertions.assertEquals(videoBlockDto.getType(), videoBlock.getType());
    }

    @Test
    public void testUpdateEntity() {
        VideoBlock videoBlock = new VideoBlock();
        videoBlock.setSortIndex(1);
        videoBlock.setUrl("https://example.com/video.mp4");
        videoBlock.setType(VideoBlockType.YOUTUBE);

        VideoBlockDto videoBlockDto = new VideoBlockDto();
        videoBlockDto.setSortIndex(2);
        videoBlockDto.setUrl("https://example.com/updated-video.mp4");
        videoBlockDto.setType(VideoBlockType.VIMEO);

        VideoMapper videoMapper = new VideoMapper();
        videoMapper.updateEntity(videoBlock, videoBlockDto);

        Assertions.assertEquals(videoBlockDto.getSortIndex(), videoBlock.getSortIndex());
        Assertions.assertEquals(videoBlockDto.getUrl(), videoBlock.getUrl());
        Assertions.assertEquals(videoBlockDto.getType(), videoBlock.getType());
    }
}
