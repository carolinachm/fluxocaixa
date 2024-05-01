import { Routes } from '@angular/router';
import {UsuarioComponent} from "./paginas/usuario/usuario.component";
import {ContaComponent} from "./paginas/conta/conta.component";
import {CategoriaComponent} from "./paginas/categoria/categoria.component";
import {TransacaoComponent} from "./paginas/transacao/transacao.component";


export const routes: Routes = [
  {path: 'usuario', component: UsuarioComponent},
  {path: 'conta', component: ContaComponent},
  {path: 'categoria', component: CategoriaComponent},
  {path: 'transacao', component: TransacaoComponent},

];
