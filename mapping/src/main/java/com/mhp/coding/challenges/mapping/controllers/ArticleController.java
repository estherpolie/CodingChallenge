package com.mhp.coding.challenges.mapping.controllers;

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping()
    public List<ArticleDto> list() { //get all articles

        return articleService.list();
    }

    @GetMapping("/{id}")
    public ArticleDto details(@PathVariable Long id) {//get by id

        return articleService.articleForId(id);
    }
//    @GetMapping("/{id}")
//    // added this
//    public ResponseEntity<ArticleDto> details(@PathVariable Long id) {
//        ArticleDto articleDto = articleService.articleForId(id);
//
//        if (articleDto == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(articleDto);
//    }


    @PostMapping()
    public ArticleDto create(@RequestBody ArticleDto articleDto) {

        return articleService.create(articleDto);
    }
}
