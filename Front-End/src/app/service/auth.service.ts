import { environment } from './../../environments/environment.prod';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from '../model/UserLogin';
import { Observable } from 'rxjs';
import { UsuarioModel } from '../model/UsuarioModel';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  logar(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>('https://revitaroca.herokuapp.com/usuarios/logar', userLogin)
  }

  cadastrar(user: UsuarioModel): Observable<UsuarioModel> {
    return this.http.post<UsuarioModel>('https://revitaroca.herokuapp.com/usuarios/cadastrar', user)
  }

  btnSair() {
    let ok = false
    let token = environment.token

    if (token != '') {
      ok = true
    }

    return ok
  }

  btnLogin() {
    let ok = false
    let token = environment.token

    if (token == '') {
      ok = true
    }

    return ok
  }

}
