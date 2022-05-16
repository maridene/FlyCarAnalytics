import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';

import { WorkSeasonComponent } from './workSeason.component';
import { WorkSeasonRoutingModule } from './workSeason-routing.module';

@NgModule({
  imports: [SharedModule, WorkSeasonRoutingModule],
  declarations: [WorkSeasonComponent],
  entryComponents: [],
})
export class WorkSeasonModule {}
