import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http:HttpClient) { }
  public getAllArticle(){
    return this.http.get<any>("http://localhost:8080/GET/articles");
  }

  public ajouterArticle(data:any){
    return this.http.post<any>("http://localhost:8080/POST/articles",data);
  }
}
