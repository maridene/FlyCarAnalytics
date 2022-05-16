import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { WorkSeasonComponent } from './workSeason.component';

const workSeasonRoute: Routes = [
  {
    path: '',
    component: WorkSeasonComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(workSeasonRoute)],
  exports: [RouterModule],
})
export class WorkSeasonRoutingModule {}
