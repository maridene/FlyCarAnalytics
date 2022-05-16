import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';

import { RentingRevenueComponent } from './rentingRevenue.component';
import { RentingRevenueRoutingModule } from './rentingRevenue-routing.module';

import { ChartsModule } from 'ng2-charts';

@NgModule({
  imports: [SharedModule, RentingRevenueRoutingModule, ChartsModule],
  declarations: [RentingRevenueComponent],
  entryComponents: [],
})
export class RentingRevenueModule {}
