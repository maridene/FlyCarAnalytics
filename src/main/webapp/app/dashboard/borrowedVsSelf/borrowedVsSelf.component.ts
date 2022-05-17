import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

import { ChartOptions, ChartType } from 'chart.js';
import { SingleDataSet, Label, Color, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';

import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'jhi-borrowed-vs-self',
  templateUrl: './borrowedVsSelf.component.html',
})
export class BorrowedVsSelfComponent implements OnInit {
  isLoading = true;
  data = {};
  public pieChartOptions: ChartOptions = {
    responsive: true,
  };
  public pieChartLabels: Label[] = [['Empruntée'], ['Locale']];
  public pieChartData: SingleDataSet = [50, 50];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins = [];

  public chartColors: Color[] = [
    {
      borderColor: ['black', 'black'],
      backgroundColor: ['rgba(0, 0, 0, 0.75)', 'rgb(245, 186, 33, 0.6)']
    }
  ];

  constructor(protected dashboardService: DashboardService, protected activatedRoute: ActivatedRoute, protected router: Router) {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }

  ngOnInit(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }

  ngAfterViewInit(): void {
    this.dashboardService.getBorrowedVsSelf().subscribe({
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
    this.pieChartData[0] = data.borrowed;
    this.pieChartData[1] = data.self;
    this.isLoading = false;

    // eslint-disable-next-line no-console
    console.log('ok');
  }

  protected onError(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }
}
