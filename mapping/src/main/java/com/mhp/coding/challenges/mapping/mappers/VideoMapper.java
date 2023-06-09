package com.mhp.coding.challenges.mapping.mappers;


import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType;
import com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlockDto;

public class VideoMapper {

    public VideoBlockDto map(VideoBlock videoBlock) {
        VideoBlockDto videoBlockDto = new VideoBlockDto();
        videoBlockDto.setSortIndex(videoBlock.getSortIndex());
        videoBlockDto.setUrl(videoBlock.getUrl());
        videoBlockDto.setType(videoBlock.getType());
        return videoBlockDto;
    }

    public VideoBlock toEntity(VideoBlockDto videoBlockDto) {
        VideoBlock videoBlock = new VideoBlock();
        videoBlock.setSortIndex(videoBlockDto.getSortIndex());
        videoBlock.setUrl(videoBlockDto.getUrl());
        videoBlock.setType(videoBlockDto.getType());
        return videoBlock;
    }

    public void updateEntity(VideoBlock videoBlock, VideoBlockDto videoBlockDto) {
        videoBlock.setSortIndex(videoBlockDto.getSortIndex());
        videoBlock.setUrl(videoBlockDto.getUrl());
        videoBlock.setType(videoBlockDto.getType());
    }
}