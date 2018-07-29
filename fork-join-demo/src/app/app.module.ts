import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BankComponent } from './components/bank/bank.component';
import { UserComponent } from './components/user/user.component';
import { UserService } from './services/user.service';
import { BankService } from './services/bank.service';


@NgModule({
  declarations: [
    AppComponent,
    BankComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ UserService, BankService],
  bootstrap: [AppComponent]
})
export class AppModule { }
