// angular modules
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; 
// import { NgpSortModule } from "ngp-sort-pipe";

// routing module
import { AppRoutingModule } from './app-routing.module';

// components
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { LogoutComponent } from './components/logout/logout.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ReadlistComponent } from './components/readlist/readlist.component';

import { ProductsComponent } from './components/products/products.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { BookDetailComponent } from './components/book-detail/book-detail.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { SortDirective } from './directive/sort.directive';
import { SearchByUsernameComponent } from './components/search-by-username/search-by-username.component';
import { ListUsersComponent } from './components/list-users/list-users.component';
import { BestsellersComponent } from './components/bestsellers/bestsellers.component';
import { AdvSearchComponent } from './components/adv-search/adv-search.component';
import { ProfileComponent } from './components/profile/profile.component';
import { BookClubComponent } from './components/book-club/book-club.component';
import { BookClubCreateComponent } from './components/book-club-create/book-club-create.component';
import { BookClubUpdateComponent } from './components/book-club-update/book-club-update.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    ReadlistComponent,
    ProductsComponent,
    PageNotFoundComponent,
    BookDetailComponent,
    SidebarComponent,
    SearchByUsernameComponent,
    ListUsersComponent,
    ProfileComponent,
    SortDirective,
    BookClubComponent,
    BookClubCreateComponent,
    BookClubUpdateComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    CommonModule

  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
