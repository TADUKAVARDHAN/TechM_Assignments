import { Routes } from '@angular/router';
import { inject } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';

// ✅ Role-based authentication guard
const authGuard = (role: 'USER' | 'PROVIDER' | 'ADMIN' | null = null) => {
  const authService = inject(AuthService);
  const router = inject(Router);
  const isLoggedIn = authService.isLoggedIn();
  const currentUser = authService.getCurrentUser();

  if (isLoggedIn && (!role || currentUser?.role === role)) {
    return true;
  }

  router.navigate(['/login']);
  return false;
};

// ✅ Define application routes
export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },

  { 
    path: 'login',
    loadComponent: () => import('./components/auth/login/login.component').then(m => m.LoginComponent) 
  },

  { 
    path: 'register',
    loadComponent: () => import('./components/auth/register/register.component').then(m => m.RegisterComponent) 
  },

  { 
    path: 'user-dashboard',
    loadComponent: () => import('./components/user/user-dashboard/user-dashboard.component').then(m => m.UserDashboardComponent),
    canActivate: [() => authGuard('USER')]  // ✅ Only users can access
  },

  { 
    path: 'provider-dashboard',
    loadComponent: () => import('./components/provider/provider-dashboard/provider-dashboard.component').then(m => m.ProviderDashboardComponent),
    canActivate: [() => authGuard('PROVIDER')] // ✅ Only providers can access
  },

  { 
    path: '**',
    loadComponent: () => import('./components/auth/login/login.component').then(m => m.LoginComponent) // Redirect unknown routes
  }
];
