package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.mappers.TextMapper;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlockDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextMapperTest {

    @Test
    public void testMap() {
        // Given
        TextBlock textBlock = new TextBlock();
        textBlock.setSortIndex(1);
        textBlock.setText("Sample text");

        TextMapper textMapper = new TextMapper();

        // When
        TextBlockDto textBlockDto = textMapper.map(textBlock);

        // Then
        assertEquals(textBlock.getSortIndex(), textBlockDto.getSortIndex());
        assertEquals(textBlock.getText(), textBlockDto.getText());
    }

    @Test
    public void testToEntity() {
        // Given
        TextBlockDto textBlockDto = new TextBlockDto();
        textBlockDto.setSortIndex(1);
        textBlockDto.setText("Sample text");

        TextMapper textMapper = new TextMapper();

        // When
        TextBlock textBlock = textMapper.toEntity(textBlockDto);

        // Then
        assertEquals(textBlockDto.getSortIndex(), textBlock.getSortIndex());
        assertEquals(textBlockDto.getText(), textBlock.getText());
    }

    @Test
    public void testUpdateEntity() {
        // Given
        TextBlock textBlock = new TextBlock();
        textBlock.setSortIndex(1);
        textBlock.setText("Initial text");

        TextBlockDto textBlockDto = new TextBlockDto();
        textBlockDto.setSortIndex(2);
        textBlockDto.setText("Updated text");

        TextMapper textMapper = new TextMapper();

        // When
        textMapper.updateEntity(textBlock, textBlockDto);

        // Then
        assertEquals(textBlockDto.getSortIndex(), textBlock.getSortIndex());
        assertEquals(textBlockDto.getText(), textBlock.getText());
    }
}
