import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { FeedComponent } from './feed/feed.component';
import {HomeComponent} from './home/home.component';
import { LoginComponent } from './login/login.component';
import {SobrenosComponent} from './sobrenos/sobrenos.component';
import { PostTemaComponent } from './post-tema/post-tema.component';
import { Feed2Component } from './feed2/feed2.component';

const routes: Routes = [
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path:'home', component: HomeComponent},
  {path:'sobrenos', component: SobrenosComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'feed', component: FeedComponent},
  {path: 'cadastro-tema', component: PostTemaComponent},
  {path: 'feed2', component: Feed2Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
