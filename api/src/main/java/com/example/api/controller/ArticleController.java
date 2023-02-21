package com.example.api.controller;

import com.example.api.model.Article;
import com.example.api.repository.ArticleRepository;
import com.example.api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("POST/articles")
     //  @ResponseStatus(HttpStatus.MULTI_STATUS)
     public void createArticle(@RequestParam("nom") String nom,
                                  @RequestParam("price") int price,
                                  @RequestParam("image") MultipartFile file)  {
             articleService.saveArtcl(nom,price,file);

  //  return "tout pass bien";

    }
    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
   /*    public ImageModel uploadImage(MultipartFile file) throws IOException{
        ImageModel imageModel = new ImageModel(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes()
        );
        return imageModel;

       }    */
   @CrossOrigin(origins = "http://localhost:4200")
 @GetMapping("GET/articles")
 public Iterable<Article> getArticle(){

     return articleRepository.findAll();


 }
 @GetMapping("GET/articles/{id}")
    public Optional<Article> getOneArticle(@PathVariable Integer id){
     return articleRepository.findById(id);
 }
}
