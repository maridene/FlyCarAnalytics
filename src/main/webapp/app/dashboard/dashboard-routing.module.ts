import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'borrowedVsSelf',
        data: { pageTitle: 'global.menu.dashboard.selfVsBorrowed' },
        loadChildren: () => import('./borrowedVsSelf/borrowedVsSelf.module').then(m => m.BorrowedVsSelfModule),
      },
      {
        path: 'mostWantedCategories',
        data: { pageTitle: 'global.menu.dashboard.mostWantedCategories' },
        loadChildren: () => import('./mostWantedCategories/mostWantedCategories.module').then(m => m.MostWantedCategoriesModule),
      },
      {
        path: 'agencyMarket',
        data: { pageTitle: 'global.menu.dashboard.marketAgencyRepartition' },
        loadChildren: () => import('./agencyMarket/agencyMarket.module').then(m => m.AgencyMarketModule),
      },
      {
        path: 'rentingRevenue',
        data: { pageTitle: 'global.menu.dashboard.rentingRevenue' },
        loadChildren: () => import('./rentingRevenue/rentingRevenue.module').then(m => m.RentingRevenueModule),
      },
      {
        path: 'workSeason',
        data: { pageTitle: 'global.menu.dashboard.workSeason' },
        loadChildren: () => import('./workSeason/workSeason.module').then(m => m.WorkSeasonModule),
      },
    ]),
  ],
})
export class DashboardRoutingModule {}
