import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { SingleDataSet, Label} from 'ng2-charts';

import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'jhi-most-wanted-categories',
  templateUrl: './mostWantedCategories.component.html',
})
export class MostWantedCategoriesComponent implements OnInit {
  isLoading = true;
  data = {};
  public pieChartOptions: ChartOptions = {
    responsive: true,
  };
  public pieChartLabels: Label[] = [];
  public pieChartData: SingleDataSet = [];
  public pieChartType: ChartType = 'doughnut';
  public pieChartLegend = true;
  public pieChartPlugins = [];

  constructor(protected dashboardService: DashboardService, protected activatedRoute: ActivatedRoute, protected router: Router) {

  }

  ngOnInit(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }

  ngAfterViewInit(): void {
    this.dashboardService.getMostWantedCategories().subscribe({
      next: (res: HttpResponse<any>) => {
        this.onSuccess(res.body, res.headers);
      },
      error: () => {
        this.isLoading = false;
        this.onError();
      },
    });
  }

  protected onSuccess(data: any, headers: HttpHeaders): void {
    const dataSize = data.length;
    for(let i = 0; i < dataSize; i++) {
      this.pieChartData[i] = data[i].count;
      this.pieChartLabels[i] = data[i].name;
    }
    this.isLoading = false;

    // eslint-disable-next-line no-console
    console.log('ok');
  }

  protected onError(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }
}
