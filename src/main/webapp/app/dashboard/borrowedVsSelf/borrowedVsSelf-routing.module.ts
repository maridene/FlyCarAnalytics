import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { BorrowedVsSelfComponent } from './borrowedVsSelf.component';

const borrowedVsSelfRoute: Routes = [
  {
    path: '',
    component: BorrowedVsSelfComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(borrowedVsSelfRoute)],
  exports: [RouterModule],
})
export class BorrowedVsSelfRoutingModule {}
