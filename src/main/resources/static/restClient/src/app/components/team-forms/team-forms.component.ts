import { Component, OnInit } from "@angular/core";
import { TeamService } from "src/app/shared_service/team.service";
import { Team } from "../../team";
import { Router } from "@angular/router";

@Component({
  selector: "app-team-forms",
  templateUrl: "./team-forms.component.html",
  styleUrls: ["./team-forms.component.sass"]
})
export class TeamFormsComponent implements OnInit {
  private team: Team;
  constructor(private _teamService: TeamService, private _router: Router) {}

  ngOnInit() {
    this.team = this._teamService.getter();
  }

  processForm() {
    if (this.team.id == undefined) {
      this._teamService.createTeam(this.team).subscribe(
        team => {
          console.log(team);
          this._router.navigate(["/"]);
        },
        error => {
          console.log(error);
        }
      );
    } else {
      this._teamService.updateTeam(this.team).subscribe(
        team => {
          console.log(team);
          this._router.navigate(["/"]);
        },
        error => {
          console.log(error);
        }
      );
    }
  }
}
