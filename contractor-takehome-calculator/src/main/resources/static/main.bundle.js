webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".mat-toolbar {\r\n    background: #673ab7;\r\n    color: #F1F8E9;\r\n}\r\n\r\nbody {\r\n margin:0px;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<mat-toolbar><h1>{{title}}</h1></mat-toolbar>\n<div>\n  <table>\n    <tr>\n      <td><app-income-form></app-income-form></td>\n    </tr>\n  </table>\n</div>\n<footer>\n  <mat-toolbar >\n    <div style=\"font-size:15px\">Innosolv Private Limited. All Rights Reserved!</div>\n  </mat-toolbar>\n</footer>\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'Contractor Takehome Calculator';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__income_form_income_form_component__ = __webpack_require__("../../../../../src/app/income-form/income-form.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["H" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_6__income_form_income_form_component__["a" /* IncomeFormComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["a" /* MatAutocompleteModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["b" /* MatButtonModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["c" /* MatButtonToggleModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["d" /* MatCardModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["e" /* MatCheckboxModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["f" /* MatChipsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["g" /* MatDatepickerModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["h" /* MatDialogModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["i" /* MatExpansionModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["k" /* MatGridListModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["l" /* MatIconModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["m" /* MatInputModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["j" /* MatFormFieldModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["n" /* MatListModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["o" /* MatMenuModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["p" /* MatNativeDateModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["q" /* MatPaginatorModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["r" /* MatProgressBarModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["s" /* MatProgressSpinnerModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["t" /* MatRadioModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["u" /* MatRippleModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["v" /* MatSelectModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["w" /* MatSidenavModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["y" /* MatSliderModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["x" /* MatSlideToggleModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["z" /* MatSnackBarModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["A" /* MatSortModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["C" /* MatTableModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["D" /* MatTabsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["E" /* MatToolbarModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["F" /* MatTooltipModule */]
            ],
            providers: [],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/income-form/income-form.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".form-container {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n}\r\n\r\n.form-container > * {\r\n  width: 100%;\r\n}\r\n\r\n.mat-header-row {\r\n  -webkit-box-align: unset;\r\n      -ms-flex-align: unset;\r\n          align-items: unset\r\n}\r\n\r\n.example-container {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n  min-width: 300px;\r\n}\r\n\r\n.example-header {\r\n  min-height: 64px;\r\n  padding: 8px 24px 0;\r\n}\r\n\r\n.mat-table {\r\n  overflow: auto;\r\n  min-height: 450px;\r\n  max-height: 450px;\r\n}\r\n\r\n.mat-cell {font-size: 12px}\r\n.mat-header-cell{font-size: 14px}\r\n\r\n\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/income-form/income-form.component.html":
/***/ (function(module, exports) {

module.exports = "<table>\n  <tr>\n    <td style=\"vertical-align:top\">\n      <div class=\"form-container\">\n        <mat-form-field>\n          Company Annual Earnings*:  <input #earnings matInput placeholder=\"\">\n        </mat-form-field>\n\n        <mat-form-field>\n          Business Expenses (excluding salary): <input #expenses matInput placeholder=\"\">\n        </mat-form-field>\n\n        <mat-form-field>\n          Spouse Dividends Share(0-100%)<input #spouseShare matInput placeholder=\"\">\n        </mat-form-field>\n\n        <button mat-raised-button color=\"primary\" (click)=\"calculate(earnings.value, expenses.value, spouseShare.value)\">Calculate</button>\n\n      </div>\n    </td>\n    <td style=\"vertical-align:top\">\n      <div class=\"example-container mat-elevation-z8\">\n\n        <mat-spinner *ngIf=\"isLoadingResults\"></mat-spinner>\n\n        <mat-table #table [dataSource]=\"dataSource\">\n\n          <ng-container matColumnDef=\"directorSalary\">\n            <mat-header-cell *matHeaderCellDef> Salary </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.directorSalary}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"expenses\">\n            <mat-header-cell *matHeaderCellDef> Other Expenses </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.expenses}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"employerNi\">\n            <mat-header-cell *matHeaderCellDef> Employer's NI </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.employerNi}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"corpTax\">\n            <mat-header-cell *matHeaderCellDef> Corp.Tax </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.corpTax}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"distributableProfit\">\n            <mat-header-cell *matHeaderCellDef> Distributable Profit </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.distributableProfit}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"dividends\">\n            <mat-header-cell *matHeaderCellDef> Dividends </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.dividends}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"ni\">\n            <mat-header-cell *matHeaderCellDef> NI </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.ni}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"payeTax\">\n            <mat-header-cell *matHeaderCellDef> PAYE Tax </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.payeTax}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"takeHome\">\n            <mat-header-cell *matHeaderCellDef> Your TakeHome  </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.takeHome}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"spouseDividends\">\n            <mat-header-cell *matHeaderCellDef> Spouse Dividends </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.spouseDividends}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"spousePayeTax\">\n            <mat-header-cell *matHeaderCellDef> Spouse PAYE Tax </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.spousePayeTax}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"spouseTakeHome\">\n            <mat-header-cell *matHeaderCellDef> Spouse TakeHome </mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.spouseTakeHome}} </mat-cell>\n          </ng-container>\n\n          <ng-container matColumnDef=\"totalTakeHome\">\n            <mat-header-cell *matHeaderCellDef> Total TakeHome</mat-header-cell>\n            <mat-cell *matCellDef=\"let element\"> {{element.totalTakeHome}} </mat-cell>\n          </ng-container>\n\n          <mat-header-row *matHeaderRowDef=\"displayedColumns\"></mat-header-row>\n          <mat-row *matRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n        </mat-table>\n      </div>\n    </td>\n  </tr>\n</table>\n"

/***/ }),

/***/ "../../../../../src/app/income-form/income-form.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return IncomeFormComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var IncomeFormComponent = (function () {
    function IncomeFormComponent(http) {
        this.http = http;
        this.displayedColumns = ['directorSalary', 'expenses', 'employerNi', 'corpTax', 'distributableProfit',
            'dividends', 'ni', 'payeTax', 'takeHome', 'spouseDividends', 'spousePayeTax', 'spouseTakeHome', 'totalTakeHome'];
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_1__angular_material__["B" /* MatTableDataSource */]();
        this.isLoadingResults = false;
    }
    IncomeFormComponent.prototype.calculate = function (earnings, expenses, spouseShare) {
        var _this = this;
        var earningsParam = '10000';
        if (earnings) {
            earningsParam = earnings;
        }
        var expParam = '0';
        if (expenses) {
            expParam = expenses;
        }
        var spouseShareParam = '0';
        if (spouseShare) {
            spouseShareParam = spouseShare;
        }
        this.isLoadingResults = true;
        var url = 'http://localhost:8080/take-home-illustrations?companyEarnings=' + earningsParam + '&expenses=' + expParam + '&spouseShare=' + spouseShareParam;
        this.http.get(url)
            .subscribe(function (data) {
            _this.dataSource.data = data;
            _this.isLoadingResults = false;
        });
    };
    IncomeFormComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'app-income-form',
            template: __webpack_require__("../../../../../src/app/income-form/income-form.component.html"),
            styles: [__webpack_require__("../../../../../src/app/income-form/income-form.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], IncomeFormComponent);
    return IncomeFormComponent;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_12" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map