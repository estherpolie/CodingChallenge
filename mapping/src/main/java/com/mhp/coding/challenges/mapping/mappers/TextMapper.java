package com.mhp.coding.challenges.mapping.mappers;


import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlockDto;

public class TextMapper {

    public TextBlockDto map(TextBlock textBlock) {
        TextBlockDto textBlockDto = new TextBlockDto();
        textBlockDto.setSortIndex(textBlock.getSortIndex());
        textBlockDto.setText(textBlock.getText());
        return textBlockDto;
    }

    public TextBlock toEntity(TextBlockDto textBlockDto) {
        TextBlock textBlock = new TextBlock();
        textBlock.setSortIndex(textBlockDto.getSortIndex());
        textBlock.setText(textBlockDto.getText());
        return textBlock;
    }

    public void updateEntity(TextBlock textBlock, TextBlockDto textBlockDto) {
        textBlock.setSortIndex(textBlockDto.getSortIndex());
        textBlock.setText(textBlockDto.getText());
    }
}
