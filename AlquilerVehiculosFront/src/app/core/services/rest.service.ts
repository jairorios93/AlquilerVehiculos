import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlRuta } from 'src/app/feature/shared/urlRuta';

@Injectable()
export class BaseService {

  constructor(private http: HttpClient, private urlRuta: UrlRuta) { }

  queryPost(path: string, body) {
    let repos = this.http.post(this.urlRuta.getRuta() + path, body);
    return repos;
  }

  queryGet(path: string, param) {
    let repos = this.http.get(this.urlRuta.getRuta() + path + "/" + param);
    return repos;
  }
}
