import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookDetailComponent } from './components/book-detail/book-detail.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ReadlistComponent } from './components/readlist/readlist.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ProductsComponent } from './components/products/products.component';
import { RegisterComponent } from './components/register/register.component';
import { BookClubComponent } from './components/book-club/book-club.component';
import { BookClubCreateComponent } from './components/book-club-create/book-club-create.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch:'full' },
  { path: 'home', component: HomeComponent },
  { path: 'products', component: ProductsComponent},
  { path: 'products/:ISBN', component: BookDetailComponent},
  // { path: 'about', component: AboutComponent, canActivate: [AuthGuard] },
  // { path: 'contact', component: ContactComponent, canActivate: [AuthGuard] },
  // { path: 'products/:catName/:catId', component: SubCategoryComponent, canActivate: [AuthGuard] },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'readlist', component: ReadlistComponent },
  // { path: '**', component: PageNotFoundComponent }
  {path: 'bookclub', component: BookClubComponent},
  {path: 'bookclub/create', component: BookClubCreateComponent},
  {path: 'bookclub/:id', component: BookClubComponent},
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
