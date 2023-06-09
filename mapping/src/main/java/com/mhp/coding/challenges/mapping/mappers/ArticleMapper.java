package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlockImpl;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
public class ArticleMapper {

    public ArticleDto map(Article article){
        //TODO
        ArticleDto articleDto = new ArticleDto();
        Set<ArticleBlock> articleBlocks = article.getBlocks();
        Collection<ArticleBlockDto> blocks = new ArrayList<>();
        // Creating Article Block Dto
        for (ArticleBlock articleBlock : articleBlocks) {
            ArticleBlockDto articleBlockDto = new ArticleBlockDto();
            articleBlockDto.setSortIndex(articleBlock.getSortIndex());
            blocks.add(articleBlockDto);
        }
        Collections.sort((ArrayList<ArticleBlockDto>) blocks, (a, b)->Integer.compare(a.getSortIndex(), b.getSortIndex()));
        articleDto.setAuthor(article.getAuthor());
        articleDto.setBlocks(blocks);
        articleDto.setId(article.getId());
        articleDto.setDescription(article.getDescription());
        articleDto.setTitle(article.getTitle());

        return articleDto;
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        Article article = new Article();
        article.setAuthor(articleDto.getAuthor());
        article.setId(articleDto.getId());
        article.setDescription(articleDto.getDescription());
        article.setTitle(articleDto.getTitle());

        //
        Collection<ArticleBlockDto> blocks = articleDto.getBlocks();
        Set<ArticleBlock> articleBlockSet = new HashSet<>();
        // Creating Article Block Dto
        for (ArticleBlockDto currentBlock : blocks) {
            ArticleBlock articleBlock = new ArticleBlockImpl();
            articleBlock.setSortIndex(currentBlock.getSortIndex());
            articleBlockSet.add(articleBlock);
        }

        article.setBlocks(articleBlockSet);
        return article;
    }
}
