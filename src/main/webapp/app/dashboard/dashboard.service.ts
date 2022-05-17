import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

// import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
// import { createRequestOption } from 'app/core/request/request-util';

export type EntityResponseType = HttpResponse<any>;
export type EntityArrayResponseType = HttpResponse<any[]>;

@Injectable({ providedIn: 'root' })
export class DashboardService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/bookings/self_vs_borrowed');
  protected mostWantedCategoriesResourceUrl = this.applicationConfigService.getEndpointFor('api/bookings/mostWantedCategories');
  protected bookingsPerAgencyResourceUrl = this.applicationConfigService.getEndpointFor('api/bookings/bookingsPerAgency?dateMask=');
  protected monthlyRevenueResourceUrl = this.applicationConfigService.getEndpointFor('api/bookings/revenueMonthly?year=');
  protected trimesterRevenueResourceUrl = this.applicationConfigService.getEndpointFor('api/bookings/revenueTrimester?year=');
  protected monthlyBookingsResourceUrl = this.applicationConfigService.getEndpointFor('api/bookings/bookingsMonthly?year=');
  // protected baseUrl = 'localhost:8080/api/';

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  getBorrowedVsSelf(): Observable<EntityResponseType> {
    return this.http.get(this.resourceUrl, { observe: 'response' });
  }

  getMostWantedCategories(): Observable<EntityResponseType> {
    return this.http.get(this.mostWantedCategoriesResourceUrl, { observe: 'response' });
  }

  getBookingsPerAgency(mask: string): Observable<EntityResponseType> {
    return this.http.get(`${this.bookingsPerAgencyResourceUrl}${mask}`, { observe: 'response' });
  }

  getMonthlyRevenue(year: string): Observable<EntityResponseType> {
    return this.http.get(`${this.monthlyRevenueResourceUrl}${year}`, { observe: 'response' });
  }

  getTrimesterRevenue(year: string): Observable<EntityResponseType> {
    return this.http.get(`${this.trimesterRevenueResourceUrl}${year}`, { observe: 'response' });
  }

  getMonthlyBookings(year: string): Observable<EntityResponseType> {
    return this.http.get(`${this.monthlyBookingsResourceUrl}${year}`, { observe: 'response' });
  }

}
