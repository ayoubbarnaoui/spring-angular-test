import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/model/article';
import { ArticleService } from 'src/service/article/article.service';

@Component({
  selector: 'app-add-articles',
  templateUrl: './add-articles.component.html',
  styleUrls: ['./add-articles.component.css']
})
export class AddArticlesComponent {
  article = new Article();
  files:any;
  constructor(private rout:Router ,private articleServ:ArticleService) { }

  addArticle(){
    let formData =  new FormData();
    formData.append("nom",this.article.nom);
    formData.append("price",this.article.price);
    formData.append("image",this.files);
  
    this.articleServ.ajouterArticle(formData).subscribe(
      res => {
         console.log(res);
      }

    )

  }
  imageUpload(event:any){
    // console.log(event);
    this.files= event.target.files[0];
    if (event.target.files){
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
       reader.onload = (event:any) => {
      // this.imgUrl =  event.target.result;
      // console.log(this.imgUrl);
   }
    }
  }
}
