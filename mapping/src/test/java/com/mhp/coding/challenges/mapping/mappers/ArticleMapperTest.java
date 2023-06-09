package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlockImpl;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ArticleMapperTest {
    private ArticleMapper articleMapper;

    @Before
    public void setUp() {
        articleMapper = new ArticleMapper();
    }

    @Test
    public void testMapToDto() {
        // Create a sample Article
        Article article = new Article();
        article.setId(1L);
        article.setTitle("Test Article");
        article.setAuthor("John Doe");
        article.setDescription("This is a test article");

        // Create sample ArticleBlocks
        ArticleBlock block1 = new ArticleBlockImpl();
        block1.setSortIndex(1);

        ArticleBlock block2 = new ArticleBlockImpl();
        block2.setSortIndex(2);

        Set<ArticleBlock> blocks = new HashSet<>(Arrays.asList(block1, block2));
        article.setBlocks(blocks);

        // Map Article to ArticleDto
        ArticleDto articleDto = articleMapper.map(article);

        // Assertions
        Assert.assertEquals(article.getId(), articleDto.getId());
        Assert.assertEquals(article.getTitle(), articleDto.getTitle());
        Assert.assertEquals(article.getAuthor(), articleDto.getAuthor());
        Assert.assertEquals(article.getDescription(), articleDto.getDescription());
        Assert.assertEquals(blocks.size(), articleDto.getBlocks().size());
    }

    @Test
    public void testMapToEntity() {
        // Create a sample ArticleDto
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(1L);
        articleDto.setTitle("Test Article");
        articleDto.setAuthor("poli esther");
        articleDto.setDescription("This is a test article");

        // Create sample ArticleBlockDtos
        ArticleBlockDto blockDto1 = new ArticleBlockDto();
        blockDto1.setSortIndex(1);

        ArticleBlockDto blockDto2 = new ArticleBlockDto();
        blockDto2.setSortIndex(2);

        Collection<ArticleBlockDto> blockDtos = Arrays.asList(blockDto1, blockDto2);
        articleDto.setBlocks(blockDtos);

        // Map ArticleDto to Article
        Article article = articleMapper.map(articleDto);

        // Assertions
        Assert.assertEquals(articleDto.getId(), article.getId());
        Assert.assertEquals(articleDto.getTitle(), article.getTitle());
        Assert.assertEquals(articleDto.getAuthor(), article.getAuthor());
        Assert.assertEquals(articleDto.getDescription(), article.getDescription());
        Assert.assertEquals(blockDtos.size(), article.getBlocks().size());
    }
}
