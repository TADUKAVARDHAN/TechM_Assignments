import { Component, OnInit, PLATFORM_ID, Inject } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  standalone: true,
  imports: [RouterModule, CommonModule]
})
export class AppComponent implements OnInit {
  isLoggedIn = false;
  username = '';
  private isBrowser: boolean;

  constructor(
    private authService: AuthService,
    private router: Router, // ✅ Inject Router for navigation
    @Inject(PLATFORM_ID) platformId: Object
  ) {
    this.isBrowser = isPlatformBrowser(platformId);
  }

  ngOnInit() {
    if (this.isBrowser) {
      this.checkAuthStatus();
    }
  }

  // ✅ Check user authentication status
  checkAuthStatus() {
    this.isLoggedIn = this.authService.isLoggedIn();
    const user = this.authService.getCurrentUser();
    if (user) {
      this.username = user.username;
    }
  }

  // ✅ Logout and navigate to login page
  logout() {
    this.authService.logout();
    this.isLoggedIn = false;
    this.username = '';

    // ✅ Redirect to login page after logout
    this.router.navigate(['/login']);
  }
}
