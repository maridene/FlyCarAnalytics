import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

import { ChartDataSets, ChartOptions } from 'chart.js';
import { Label, Color } from 'ng2-charts';

import { DashboardService } from '../dashboard.service';

const monthLabels: string[] = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];

@Component({
  selector: 'jhi-work-season',
  templateUrl: './workSeason.component.html',
})
export class WorkSeasonComponent implements OnInit {
  isLoading = true;
  selectedYear: string;

  public lineChartData: ChartDataSets[] = [
    { data: [], label: 'Bookings' },
  ];
  public lineChartLabels: Label[] = monthLabels;
  public lineChartOptions = {
    responsive: true,
  };
  public lineChartColors: Color[] = [
    {
      borderColor: 'black',
      backgroundColor: 'rgb(245, 186, 33, 0.6)',
    },
  ];
  public lineChartLegend = true;
  public lineChartPlugins = [];
  public lineChartType = 'line';

  constructor(protected dashboardService: DashboardService, protected activatedRoute: ActivatedRoute, protected router: Router) {
      this.selectedYear = '2022';
  }

  ngOnInit(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }

  ngAfterViewInit(): void {
    this.dashboardService.getMonthlyBookings('2022').subscribe({
      next: (res: HttpResponse<any>) => {
        this.onSuccess(res.body);
      },
      error: () => {
        this.isLoading = false;
        this.onError();
      },
    });
  }

  onYearChange(event: any): void {
    this.selectedYear = event;
    this.dashboardService.getMonthlyBookings(this.selectedYear).subscribe({
      next: (res: HttpResponse<any>) => {
        this.onSuccess(res.body);
      },
      error: () => {
        this.isLoading = false;
        this.onError();
      },
    });
  }

  protected onSuccess(data: any): void {
    this.isLoading = false;
    this.lineChartData = [
      { data, label: 'Bookings' }
    ];
  }

  protected onError(): void {
    // eslint-disable-next-line no-console
    console.log('error');
  }
}
