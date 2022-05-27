import { createContext, ReactElement, useContext, useState } from "react";
import { auth } from "../services";

interface AuthContextData {
  user: any;
  login: (credentials: any) => any;
  logout: () => void;
}

const AuthContext = createContext<AuthContextData>({} as AuthContextData);

interface AuthProviderProps {
  children: ReactElement;
}

export function AuthProvider({ children }: AuthProviderProps) {
  const accessToken = localStorage.getItem("access_token");
  const refreshToken = localStorage.getItem("refresh_token");
  const [user, setUser] = useState<any>(
    accessToken ? { accessToken, refreshToken } : null
  );

  async function login({
    username,
    password,
  }: {
    username: string;
    password: string;
  }) {
    const result = await auth({ username, password });

    const { access_token, refresh_token } = result.data;

    setUser(result.data);

    localStorage.setItem("access_token", access_token);
    localStorage.setItem("refresh_token", refresh_token);

    return result;
  }

  function logout() {
    setUser(null);
  }

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}
