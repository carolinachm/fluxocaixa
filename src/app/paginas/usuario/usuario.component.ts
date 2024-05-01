import { Component } from '@angular/core';
import {JsonPipe, NgForOf} from "@angular/common";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Usuario} from "../../modelo/Usuario";
import {RouterLink} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {UsuarioService} from "../../servico/usuario.service";

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [
    NgForOf,
    ReactiveFormsModule,
    RouterLink,
    JsonPipe
  ],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent {

  //Criando objeto formulario
  formulario = new FormGroup({
    nome: new FormControl('', [Validators.required,Validators.minLength(6)]),
    email: new FormControl('',[Validators.required, Validators.min(0), Validators.max(120)]),
    password: new FormControl('', [Validators.required,Validators.minLength(6)]),
  });
  //vibilidade dos botoes
  btnCadastrar:boolean = true;
  //vetor para armazenar usuarios
  vetor:Usuario[] = [];

  constructor(private usuarioServico:UsuarioService) { }

  //inicializacçao do componente
  ngOnInit(){
    this.selecionar();
  }

  //Metodo para selecionar todos usuarios
  selecionar(){
      this.usuarioServico.selecionar().subscribe(retorno => this.vetor = retorno);
  }
  //funcao de cadastro
  cadastrar(){
    //Cadastro do vetor
    this.vetor.push(this.formulario.value as Usuario);
    //limpar os inputs
    this.formulario.reset();
    //visualizar no console
    //console.table(this.vetor)
  }
}
