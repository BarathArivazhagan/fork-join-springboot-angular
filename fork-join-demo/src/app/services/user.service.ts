import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../components/user/user.component';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  private  GET_USERS_ENDPOINT = '/userms/users';

  constructor(private _http: HttpClient) { }

  getUsers(): Observable<User[]> {

    const url = environment.gatewayurl.concat(this.GET_USERS_ENDPOINT);
    console.log(' get users url ',url);
    return this._http.get<User[]>(url);
  }

}
