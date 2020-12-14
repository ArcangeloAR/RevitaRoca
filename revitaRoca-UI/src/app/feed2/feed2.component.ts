import { environment } from './../../environments/environment.prod';
import { Router } from '@angular/router';
import { TemaService } from './../service/tema.service';
import { PostagemService } from './../service/postagem.service';
import { Tema } from './../model/Tema';
import { Postagem } from './../model/Postagem';
import { Component, OnInit } from '@angular/core';
import { AlertasService } from '../service/alertas.service';

@Component({
  selector: 'app-feed2',
  templateUrl: './feed2.component.html',
  styleUrls: ['./feed2.component.css']
})
export class Feed2Component implements OnInit {

  key = 'date'
  reverse = true

  text:string;
  postagem: Postagem = new Postagem()
  listaPostagens: Postagem[]
  titulo: string
  nomeTema: string

  tema: Tema = new Tema()
  listaTemas: Tema[]
  idTema: number
  

  constructor(
    private postagemService: PostagemService,
    private temaService: TemaService,
    private alert: AlertasService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0, 0),
    this.findAllPostagens()
    this.findAllTemas()
    let token = environment.token
    if (token == '') {
      this.router.navigate(['/login'])
      this.alert.showAlertDanger('Faça o Login antes de entrar no Feed!')
    }
  }

  findAllPostagens() {
    this.postagemService.getAllPostagens().subscribe((resp: Postagem[]) => {
      this.listaPostagens = resp
    })
  }

  findAllTemas(){
    this.temaService.getAllTemas().subscribe((resp: Tema[]) => {
      this.listaTemas = resp
    })
  }

  findByIdTema() {
    this.temaService.getByIdTema(this.idTema).subscribe((resp: Tema) => {
      this.tema = resp
    })
  }

  findByTituloPostagem() {
    if (this.titulo === '') {
      this.findAllPostagens()
    } else {
      this.postagemService.getByTituloPostagem(this.titulo).subscribe((resp: Postagem[]) => {
        this.listaPostagens = resp
      })
    }
  }

  findByNomeTema() {
    if (this.nomeTema === '') {
      this.findAllTemas()
    } else {
      this.temaService.getByNomeTema(this.nomeTema).subscribe((resp: Tema[]) => {
        this.listaTemas = resp
      })
    }
  }

  publicar() {
    this.tema.id = this.idTema
    this.postagem.tema = this.tema
 

    if (this.postagem.titulo == null || this.postagem.texto == null || this.postagem.tema == null) {
      this.alert.showAlertInfo('Preencha todos os campos antes de publicar!')
    } else {
      this.postagemService.postPostagem(this.postagem).subscribe((resp: Postagem) => {
        this.postagem = resp
        this.postagem = new Postagem()
        this.alert.showAlertSuccess('Postagem realizada com sucesso!')
        this.findAllPostagens()
      })
    }
  }

}
