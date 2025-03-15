import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule]
})
export class LoginComponent {
  loginForm: FormGroup;
  errorMessage = '';
  isLoading = false;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    this.clearError();
    
    if (this.loginForm.valid) {
      this.isLoading = true;
      const { username, password } = this.loginForm.value;

      // Show validation hints
      if (!username || !password) {
        this.errorMessage = 'Please enter both username and password';
        this.isLoading = false;
        return;
      }

      this.authService.login(username, password).subscribe({
        next: (response) => {
          this.isLoading = false;
          const user = this.authService.getCurrentUser();
          if (user?.role === 'PROVIDER') {
            this.router.navigate(['/provider-dashboard']);
          } else {
            this.router.navigate(['/user-dashboard']);
          }
        },
        error: (error) => {
          this.isLoading = false;
          this.errorMessage = error.message || 'Invalid username or password';
          console.error('Login error:', error);
        }
      });
    } else {
      if (this.loginForm.get('password')?.errors?.['minlength']) {
        this.errorMessage = 'Password must be at least 6 characters long';
      } else {
        this.errorMessage = 'Please fill in all required fields';
      }
    }
  }

  clearError(): void {
    this.errorMessage = '';
  }
}
