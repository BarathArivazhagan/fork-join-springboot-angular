import { Component, ViewChild, OnInit } from '@angular/core';
import { Bank, BankComponent } from './components/bank/bank.component';
import { User, UserComponent } from './components/user/user.component';
import { BankService } from './services/bank.service';
import { UserService } from './services/user.service';
import { forkJoin } from "rxjs/observable/forkJoin";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  @ViewChild(BankComponent) bank: BankComponent;
  @ViewChild(UserComponent) user: UserComponent;

  constructor(private bankService: BankService, private userService: UserService ){

  }

  ngOnInit() {
    forkJoin([this.bankService.getBanks(),this.userService.getUsers()])
      .subscribe( results => {
          console.log('fork join results ',results);
          console.log('bank results ',results[0]);
          this.bank.banks= results[0];
          console.log('user results ',results[1]);
          this.user.users = results[1];
      });
  }
}
