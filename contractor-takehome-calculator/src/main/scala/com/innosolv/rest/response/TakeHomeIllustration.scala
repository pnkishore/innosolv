package com.innosolv.rest.response

// displayedColumns = ['salary', 'expenses', 'employersNi', 'corpTax', 'distributableProfit', 'directorDividends', 'directorNi', 'directorPersonalTax',
//'directorTakeHome', 'spouseDividends', 'spousePersonalTax', 'spouseTakeHome', 'coupleTakeHome'];

case class TakeHomeIllustration(directorSalary: String,
                                expenses: String,
                                employerNi: String,
                                corpTax: String,
                                distributableProfit: String,
                                dividends: String,
                                ni: String,
                                payeTax: String,
                                takeHome: String,
                                spouseDividends: String,
                                spousePayeTax: String,
                                spouseTakeHome: String,
                                totalTakeHome: String
                               )
