import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';
import { ClientComponent } from './client/client.component';
import { StrintComponent } from './strint/strint.component';
import { PropbindComponent } from './propbind/propbind.component';
import { EventbindComponent } from './eventbind/eventbind.component';
import { AttDirectiveComponent } from './att-directive/att-directive.component';


@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    ClientComponent,
    StrintComponent,
    PropbindComponent,
    EventbindComponent,
    AttDirectiveComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
