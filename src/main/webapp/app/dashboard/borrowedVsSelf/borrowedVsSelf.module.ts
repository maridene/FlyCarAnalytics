import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';

import { BorrowedVsSelfComponent } from './borrowedVsSelf.component';
import { BorrowedVsSelfRoutingModule } from './borrowedVsSelf-routing.module';

import { ChartsModule } from 'ng2-charts';

@NgModule({
  imports: [SharedModule, BorrowedVsSelfRoutingModule, ChartsModule],
  declarations: [BorrowedVsSelfComponent],
  entryComponents: [],
})
export class BorrowedVsSelfModule {}
