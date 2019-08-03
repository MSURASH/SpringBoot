import { Component, OnInit, Inject, forwardRef } from "@angular/core";
import { Team } from "../../team";
import { TeamService } from "../../shared_service/team.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-listteams",
  templateUrl: "./listteams.component.html",
  styleUrls: ["./listteams.component.sass"]
})
export class ListteamsComponent implements OnInit {
  private teams: Team[];
  constructor(private _teamService: TeamService, private _router: Router) {}

  ngOnInit() {
    this._teamService.getTeams().subscribe(
      teams => {
        console.log(teams);
        this.teams = teams;
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteTeam(team) {
    this._teamService.deleteTeam(team.id).subscribe(
      data => {
        this.teams.splice(this.teams.indexOf(team), 1);
      },
      error => {
        console.log(error);
      }
    );
  }

  updateTeam(team) {
    this._teamService.setter(team);
    this._router.navigate(["/op"]);
  }

  newTeam() {
    let team = new Team();
    this._teamService.setter(team);
    this._router.navigate(["/op"]);
  }
}
