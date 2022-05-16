import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';

import { MostWantedCategoriesComponent } from './mostWantedCategories.component';
import { MostWantedCategoriesRoutingModule } from './mostWantedCategories-routing.module';

import { ChartsModule } from 'ng2-charts';

@NgModule({
  imports: [SharedModule, MostWantedCategoriesRoutingModule, ChartsModule],
  declarations: [MostWantedCategoriesComponent],
  entryComponents: [],
})
export class MostWantedCategoriesModule {}
