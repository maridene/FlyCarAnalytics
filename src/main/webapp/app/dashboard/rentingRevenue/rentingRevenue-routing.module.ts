import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { RentingRevenueComponent } from './rentingRevenue.component';

const rentingRevenueRoute: Routes = [
  {
    path: '',
    component: RentingRevenueComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(rentingRevenueRoute)],
  exports: [RouterModule],
})
export class RentingRevenueRoutingModule {}
