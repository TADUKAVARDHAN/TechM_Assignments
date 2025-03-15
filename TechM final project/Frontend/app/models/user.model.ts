export interface User {
  id?: number;
  username: string;
  email: string;
  password?: string;
  role: 'USER' | 'PROVIDER' | 'ADMIN';
}

export interface AuthResponse {
  message: string;
  token?: string;
}

export interface LoginRequest {
  username: string;
  password: string;
}

export interface RegisterRequest {
  username: string;
  email: string;
  password: string;
  role: 'USER' | 'PROVIDER';
}
