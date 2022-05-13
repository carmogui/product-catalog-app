import { createContext, ReactElement } from "react";
import { auth } from "../services";

interface AuthContextData {
  signed: boolean;
  login(credentials: any): any;
}

const AuthContext = createContext<AuthContextData>({} as AuthContextData);

async function login({
  username,
  password,
}: {
  username: string;
  password: string;
}) {
  const response = await auth({ username, password });
  const { access_token, refresh_token } = response.data;

  localStorage.setItem("access_token", access_token);
  localStorage.setItem("refresh_token", refresh_token);
}

export function AuthProvider({ children }: { children: ReactElement }) {
  return (
    <AuthContext.Provider value={{ signed: true, login }}>
      {children}
    </AuthContext.Provider>
  );
}

export default AuthContext;
