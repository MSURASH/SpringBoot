import { Injectable } from "@angular/core";
import { Http, Headers, Response, RequestOptions } from "@angular/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/observable/of";

import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw";
import { Team } from "../team";

@Injectable({
  providedIn: "root"
})
export class TeamService {
  private baseUrl: string = "http://localhost:8080/springbootrestapi/team";
  private headers = new Headers({ "Content-Type": "application/json" });
  private options = new RequestOptions({ headers: this.headers });
  private team: Team;
  constructor(private _http: Http) {}

  getTeams() {
    return this._http
      .get(this.baseUrl + "/all", this.options)
      .map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  getTeam(team: string) {
    return this._http
      .get(this.baseUrl + "/teamname?name=" + team, this.options)
      .map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  deleteTeam(id: Number) {
    return this._http
      .delete(this.baseUrl + "/delete?id=" + id, this.options)
      .map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  createTeam(team: Team) {
    return this._http
      .post(this.baseUrl + "/save", JSON.stringify(team), this.options)
      .map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  updateTeam(team: Team) {
    return this._http
      .put(this.baseUrl + "/update", JSON.stringify(team), this.options)
      .map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  errorHandler(error: Response) {
    return Observable.throw(error || "SERVER ERROR");
  }

  setter(team: Team) {
    this.team = team;
  }

  getter() {
    return this.team;
  }
}
