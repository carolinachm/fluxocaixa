// Importar o Injectable para prover a injeção de dependência
import { Injectable } from '@angular/core';

// Importar o HttpClient
import { HttpClient } from '@angular/common/http';

// Importar o modelo de usuario
import {Usuario} from "../modelo/Usuario";

// Importar o RxJS
import { Observable } from 'rxjs';


// Configuração do @Injectable
@Injectable({
  providedIn: 'root'
})

// Classe
export class UsuarioService {

  // URL da API
  url:string = 'http://localhost:3000/usuario';

  // Primeiro método a ser executado quando referenciada a classe de serviço
  constructor(private http:HttpClient) { }

  // Método para selecionar usuario
  selecionar():Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url);
  }

  // Método para cadastrar usuario
  cadastrar(obj:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>(this.url, obj);
  }

  // Método para alterar usuario
  alterar(obj:Usuario):Observable<Usuario>{
    return this.http.put<Usuario>(`${this.url}/${obj.id}`, obj);
  }

  // Método para remover usuario
  remover(id:number):Observable<any>{
    return this.http.delete<any>(`${this.url}/${id}`);
  }
}
