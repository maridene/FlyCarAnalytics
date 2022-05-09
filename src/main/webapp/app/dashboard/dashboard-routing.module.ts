import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'borrowedVsSelf',
        data: { pageTitle: 'flycarAnalyticsApp.job.home.title' },
        loadChildren: () => import('./borrowedVsSelf/borrowedVsSelf.module').then(m => m.BorrowedVsSelfModule),
      },
    ]),
  ],
})
export class DashboardRoutingModule {}
