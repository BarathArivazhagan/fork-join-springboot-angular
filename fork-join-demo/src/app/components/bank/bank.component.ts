import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.css']
})
export class BankComponent implements OnInit {

  public banks: Bank[];

  constructor() { }

  ngOnInit() {

  }

  

}

export interface Bank{
  bankId:number;
  bankName:string;
}
