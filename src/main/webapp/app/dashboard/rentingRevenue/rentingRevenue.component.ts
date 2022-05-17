import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';


import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label, Color } from 'ng2-charts';

import { DashboardService } from '../dashboard.service';

const monthLabels: string[] = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
const trimesterLabels: string[] = ['Trimester 1', 'Trimester 2', 'Trimester 3', 'Trimester 4'];

@Component({
  selector: 'jhi-renting-revenue',
  templateUrl: './rentingRevenue.component.html',
})
export class RentingRevenueComponent implements OnInit {
  isLoading = true;
  selectedYear: string;
  selectedPeriod: string;

  public barChartOptions: ChartOptions = {
    responsive: true,
  };
  public barChartLabels: Label[];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [];

  public chartColors: Color[] = [
      {
        borderColor: 'black',
        backgroundColor: 'rgb(245, 186, 33, 0.6)',
      },
      {
              borderColor: 'black',
              backgroundColor: 'rgba(0, 0, 0, 0.75)',
            }
    ];


  constructor(protected dashboardService: DashboardService, protected activatedRoute: ActivatedRoute, protected router: Router) {
    this.selectedYear = '2022';
    this.selectedPeriod = 'M';
    this.barChartLabels = monthLabels;
  }

  ngOnInit(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }

  ngAfterViewInit(): void {
    this.barChartLabels = monthLabels;
    this.dashboardService.getMonthlyRevenue(this.selectedYear).subscribe({
      next: (res: HttpResponse<any>) => {
        this.onSuccess(res.body);
      },
      error: () => {
        this.isLoading = false;
        this.onError();
      },
    });
  }

  onPeriodChange(event: any): void {
    this.selectedPeriod = event;
    if (this.selectedPeriod === 'M') {
      this.barChartLabels = monthLabels;
      this.dashboardService.getMonthlyRevenue(this.selectedYear).subscribe({
        next: (res: HttpResponse<any>) => {
          this.onSuccess(res.body);
        },
        error: () => {
          this.isLoading = false;
          this.onError();
        },
      });
    } else {
      this.barChartLabels = trimesterLabels;
      this.dashboardService.getTrimesterRevenue(this.selectedYear).subscribe({
        next: (res: HttpResponse<any>) => {
          this.onSuccess(res.body);
        },
        error: () => {
          this.isLoading = false;
          this.onError();
        },
      });
    }
  }

  onYearChange(event: any): void {
    this.selectedYear = event;
    if (this.selectedPeriod === 'M') {
      this.dashboardService.getMonthlyRevenue(this.selectedYear).subscribe({
        next: (res: HttpResponse<any>) => {
          this.onSuccess(res.body);
        },
        error: () => {
          this.isLoading = false;
          this.onError();
        },
      });
    } else {
      this.dashboardService.getTrimesterRevenue(this.selectedYear).subscribe({
        next: (res: HttpResponse<any>) => {
          this.onSuccess(res.body);
        },
        error: () => {
          this.isLoading = false;
          this.onError();
        },
      });
    }
  }

  protected onSuccess(data: any): void {
    const dataSize = data.length;
    this.isLoading = false;
    const data1: number[] = [];
    const data2: number[] = [];
    data.forEach((each: any) => {
      data1.push(each.rentingRevenue);
      data2.push(each.totalRevenue);
    });
    this.barChartData =
    [
      { data: data1, label: 'Renting Revenue' },
      { data: data2, label: 'Total Revenue' }
    ];
  }

  protected onError(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }
}
