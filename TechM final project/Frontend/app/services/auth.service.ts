import { Injectable, PLATFORM_ID, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { isPlatformBrowser } from '@angular/common';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router'; 

interface User {
  id: number;
  username: string;
  email: string;
  role: string;
}

interface AuthResponse {
  message: string;
  token?: string;
  user?: User;
}

interface RegisterRequest {
  username: string;
  email: string;
  password: string;
  role: string;
}

interface LoginRequest {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8282/api/auth'; // ✅ Use environment API URL
  private currentUser: User | null = null;
  private token: string | null = null;
  private isBrowser: boolean;
  private jwtHelper = new JwtHelperService(); // ✅ JWT Helper for decoding tokens

  constructor(
    private http: HttpClient,
    private router: Router,  // ✅ Inject Router
    @Inject(PLATFORM_ID) platformId: Object
  ) {
    this.isBrowser = isPlatformBrowser(platformId);
  }

  // ✅ REGISTER USER
  register(username: string, email: string, password: string, role: string): Observable<AuthResponse> {
    const request: RegisterRequest = { username, email, password, role };
    return this.http.post<AuthResponse>(`${this.apiUrl}/register`, request).pipe(
      tap(response => {
        if (response.token && response.user) {
          this.saveUserSession(response.token, response.user);
        }
      }),
      catchError(error => this.handleError(error, 'Registration failed'))
    );
  }

  // ✅ LOGIN USER
  login(username: string, password: string): Observable<AuthResponse> {
    const request: LoginRequest = { username, password };
  
    return this.http.post<AuthResponse>(`${this.apiUrl}/login`, request).pipe(
      tap(response => {
        if (response.token && response.user) {
          this.token = response.token;
          this.currentUser = response.user;
          
          // ✅ Store correct user data
          localStorage.setItem('token', response.token);
          localStorage.setItem('user', JSON.stringify(response.user));
  
          console.log("✅ User successfully stored:", response.user);
          
          // ✅ Redirect based on role
          if (response.user.role === 'USER') {
            this.router.navigate(['/user-dashboard']);
          } else if (response.user.role === 'PROVIDER') {
            this.router.navigate(['/provider-dashboard']);
          } else {
            this.router.navigate(['/']);
          }
        }
      }),
      catchError(error => {
        console.error('Login error:', error);
        return throwError(() => new Error(error.error?.message || 'Login failed'));
      })
    );
  }  

  // ✅ LOGOUT USER
  logout(): void {
    console.log('🚪 Logging out user...');
    this.token = null;
    this.currentUser = null;

    if (this.isBrowser) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
    }

    this.router.navigate(['/login']);  // ✅ Redirect to login page
  }

  // ✅ CHECK IF USER IS LOGGED IN
  isLoggedIn(): boolean {
    const token = this.getToken();
    return token !== null && !this.jwtHelper.isTokenExpired(token);
  }

  // ✅ GET JWT TOKEN
  getToken(): string | null {
    if (!this.token && this.isBrowser) {
      this.token = localStorage.getItem('token');
    }
    return this.token;
  }

  // ✅ GET LOGGED-IN USER DETAILS
  getCurrentUser(): User | null {
    if (!this.currentUser && this.isBrowser) {
      const userStr = localStorage.getItem('user');
      if (userStr) {
        this.currentUser = JSON.parse(userStr);
      }
    }
    return this.currentUser;
  }

  // ✅ CHECK IF USER HAS A SPECIFIC ROLE
  hasRole(role: string): boolean {
    const user = this.getCurrentUser();
    return user ? user.role === role : false;
  }

  // ✅ PRIVATE METHODS
  private saveUserSession(token: string, user: User): void {
    this.token = token;
    this.currentUser = user;
    if (this.isBrowser) {
      localStorage.setItem('token', token);
      localStorage.setItem('user', JSON.stringify(user));
    }
  }

  private getUserFromToken(token: string): User {
    try {
      const decodedToken: any = this.jwtHelper.decodeToken(token);
      return {
        id: decodedToken.id || 0,
        username: decodedToken.sub,
        email: decodedToken.email || '',
        role: decodedToken.role || 'USER'
      };
    } catch (error) {
      return { id: 0, username: 'unknown', email: '', role: 'USER' };
    }
  }

  private handleError(error: any, defaultMessage: string) {
    console.error(defaultMessage, error);
    return throwError(() => new Error(error.error?.message || defaultMessage));
  }
}
