package com.example.api.service;

import com.example.api.model.Article;
import com.example.api.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public void saveArtcl(String nom,int price, MultipartFile file){
        Article article=new Article();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("not has file");
        }
        try{
            article.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch (IOException e){
                e.printStackTrace();
        }
        article.setNom(nom);
        article.setPrice(price);
        articleRepository.save(article);
    }

}
