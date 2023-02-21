import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleService } from 'src/service/article/article.service';
import { DomSanitizer } from '@angular/platform-browser';


@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})

export class ArticlesComponent {
  articleList:any =[];
  artictNewList:any=[];
  constructor(private rout:Router
    ,private articleServ:ArticleService,private sanitizer: DomSanitizer) { }
    ngOnInit(): void {
      console.log("test debut");
      this. getProduits();
    }
    getProduits(){
      this.articleServ.getAllArticle().subscribe(
        result=>{
          this.articleList=result;
          this.changeList(this.articleList);
          console.log(result);
        }
      )
    }
    changeList( list:any[]){
      for(let i of this.articleList)
      i.image = this.sanitizer.bypassSecurityTrustResourceUrl(`data:image/png;base64, ${i.image}`);
    }

}
