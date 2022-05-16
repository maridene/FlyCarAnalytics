import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { MostWantedCategoriesComponent } from './mostWantedCategories.component';

const mostWantedCategoriesRoute: Routes = [
  {
    path: '',
    component: MostWantedCategoriesComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(mostWantedCategoriesRoute)],
  exports: [RouterModule],
})
export class MostWantedCategoriesRoutingModule {}
