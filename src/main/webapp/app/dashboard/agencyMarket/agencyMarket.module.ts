import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';

import { AgGridModule } from 'ag-grid-angular';

import { AgencyMarketComponent } from './agencyMarket.component';
import { AgencyMarketRoutingModule } from './agencyMarket-routing.module';

import { ChartsModule } from 'ng2-charts';

@NgModule({
  imports: [SharedModule, AgencyMarketRoutingModule, ChartsModule, AgGridModule.withComponents([])],
  declarations: [AgencyMarketComponent],
  entryComponents: [],
})
export class AgencyMarketModule {}
