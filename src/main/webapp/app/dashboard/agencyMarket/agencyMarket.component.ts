import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { ColDef } from 'ag-grid-community';

import { ChartType } from 'chart.js';
import { SingleDataSet, Label, Color} from 'ng2-charts';

import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'jhi-agency-market',
  templateUrl: './agencyMarket.component.html',
})
export class AgencyMarketComponent implements OnInit {
  isLoading = true;
  data = {};

  public polarAreaChartLabels: Label[] = [];
  public polarAreaChartData: SingleDataSet = [];
  public polarAreaLegend = true;

  public polarAreaChartType: ChartType = 'polarArea';

  selectedMonth: string;
  selectedYear: string;


  public columnDefs: ColDef[] = [
      { headerName: 'Agency name', field: 'name', sortable: true, filter: true},
      { headerName: 'Agency code', field: 'code', sortable: true, filter: true},
      { headerName: 'Bookings', field: 'bookings', sortable: true }
  ];

  public rowData: any[] = [];

  public chartColors: Color[] = [
      //add more colors
      {
        backgroundColor: ['rgba(0, 0, 0, 0.75)', 'rgba(245, 186, 33, 0.6)']
      }
  ];

  constructor(protected dashboardService: DashboardService, protected activatedRoute: ActivatedRoute, protected router: Router) {
    this.selectedYear = '2022';
    this.selectedMonth = '01';
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

  onMonthChange(event: any): void {
    this.reset();
    this.selectedMonth = event;
    this.dashboardService.getBookingsPerAgency(`${String(this.selectedYear)}-${String(this.selectedMonth)}`).subscribe({
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
    this.reset();
    this.selectedYear = event;
    this.dashboardService.getBookingsPerAgency(`${String(this.selectedYear)}-${String(this.selectedMonth)}`).subscribe({
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
    const rows = [];
    for(let i = 0; i < dataSize; i++) {
      this.polarAreaChartLabels[i] = `${String(data[i].agencyCode)} - ${String(data[i].agencyName)}`;
      this.polarAreaChartData[i] = data[i].bookingsCount;
      rows.push({
        name: data[i].agencyName,
        code: data[i].agencyCode,
        bookings: data[i].bookingsCount
      });
      this.rowData = rows;
    }
    this.isLoading = false;

    // eslint-disable-next-line no-console
    console.log('ok');
  }

  protected onError(): void {
    // eslint-disable-next-line no-console
    console.log('ok');
  }

  protected reset(): void {
    this.rowData = [];
    this.polarAreaChartData = [];
  }
}
