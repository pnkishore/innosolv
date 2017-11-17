import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-income-form',
  templateUrl: './income-form.component.html',
  styleUrls: ['./income-form.component.css']
})
export class IncomeFormComponent  {

 displayedColumns = ['directorSalary', 'expenses', 'employerNi', 'corpTax', 'distributableProfit',
 'dividends', 'ni', 'payeTax', 'takeHome', 'spouseDividends', 'spousePayeTax', 'spouseTakeHome', 'totalTakeHome'];

  dataSource = new MatTableDataSource();
  isLoadingResults = false

  constructor(private http: HttpClient) {}

  calculate(earnings: string, expenses: string, spouseShare: string) {
    let earningsParam = '10000';
    if (earnings){
      earningsParam = earnings;
    }

    let expParam = '0';
    if (expenses) {
      expParam = expenses;
    }
    let spouseShareParam = '0';
    if (spouseShare) {
      spouseShareParam = spouseShare;
    }
    this.isLoadingResults = true;
    let url = 'http://localhost:8080/take-home-illustrations?companyEarnings=' + earningsParam + '&expenses=' + expParam + '&spouseShare=' + spouseShareParam;
    this.http.get<Element[]>(url)
        .subscribe(data => {
          this.dataSource.data = data;
          this.isLoadingResults = false;
        });
  }
}

export interface Element {
        directorSalary: string;
        expenses: string;
        employerNi: string;
        corpTax: string;
        distributableProfit: string;
        dividends: string;
        ni: string;
        payeTax: string;
        takeHome: string;
        spouseDividends: string;
        spousePayeTax: string;
        spouseTakeHome: string;
        totalTakeHome: string;
}
