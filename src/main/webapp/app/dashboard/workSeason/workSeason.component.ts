import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { ColDef } from 'ag-grid-community';

import { ChartType } from 'chart.js';
import { SingleDataSet, Label} from 'ng2-charts';

import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'jhi-work-season',
  templateUrl: './workSeason.component.html',
})
export class WorkSeasonComponent implements OnInit {
  isLoading = true;


  constructor(protected dashboardService: DashboardService, protected activatedRoute: ActivatedRoute, protected router: Router) {
  }

  ngOnInit(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }

  ngAfterViewInit(): void {
    this.dashboardService.getBookingsPerAgency('2022-01').subscribe({
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
    const dataSize = data.length;
    this.isLoading = false;

    // eslint-disable-next-line no-console
    console.log('ok');
  }

  protected onError(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }
}
