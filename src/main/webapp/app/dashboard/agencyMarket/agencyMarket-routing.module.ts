import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { AgencyMarketComponent } from './agencyMarket.component';

const agencyMarketRoute: Routes = [
  {
    path: '',
    component: AgencyMarketComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(agencyMarketRoute)],
  exports: [RouterModule],
})
export class AgencyMarketRoutingModule {}
