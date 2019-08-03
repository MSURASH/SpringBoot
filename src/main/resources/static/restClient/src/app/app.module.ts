import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HttpModule } from "@angular/http";
import { FormsModule } from "@angular/forms";
import { AppComponent } from "./app.component";
import { ListteamsComponent } from "./components/listteams/listteams.component";
import { TeamFormsComponent } from "./components/team-forms/team-forms.component";
import { TeamService } from "./shared_service/team.service";

const appRoutes: Routes = [
  { path: "", component: ListteamsComponent },
  { path: "op", component: TeamFormsComponent }
];
@NgModule({
  declarations: [AppComponent, ListteamsComponent, TeamFormsComponent],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [TeamService],
  bootstrap: [AppComponent]
})
export class AppModule {}
