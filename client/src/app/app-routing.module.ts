import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ArticlesComponent } from './articles/articles.component';
import { OrdersComponent } from './orders/orders.component';
import { AddArticlesComponent } from './add-articles/add-articles.component';

const routes: Routes = [

  {path : "articles", component :ArticlesComponent},
  {path : "add", component :AddArticlesComponent},
  {path : "orders", component :OrdersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
     HttpClientModule,],
  exports: [RouterModule]
})
export class AppRoutingModule { }
