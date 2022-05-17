import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';

import { WorkSeasonComponent } from './workSeason.component';
import { WorkSeasonRoutingModule } from './workSeason-routing.module';

import { ChartsModule } from 'ng2-charts';

@NgModule({
  imports: [SharedModule, WorkSeasonRoutingModule, ChartsModule],
  declarations: [WorkSeasonComponent],
  entryComponents: [],
})
export class WorkSeasonModule {}
