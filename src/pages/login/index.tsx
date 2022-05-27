import { useState } from "react";
import { useNavigate } from "react-router";
import { Button, Input } from "../../components";
import { useAuth } from "../../context/auth";
import * as S from "./styles";

export function Login() {
  const navigation = useNavigate();
  const { login } = useAuth();
  const [error, setError] = useState(false);
  const [loading, setLoading] = useState(false);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  async function handleSubmit(e: any) {
    e.preventDefault();
    setLoading(true);

    const data = await login({ username, password });

    setLoading(false);

    if (data?.status === 200) {
      navigation("/");
    } else {
      setError(true);
    }
  }

  return (
    <S.Main>
      <S.Wrapper onSubmit={handleSubmit}>
        <h1>Login</h1>

        <label htmlFor="username">username</label>
        <Input
          type="text"
          id="username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />

        <label htmlFor="password">password</label>
        <Input
          type="text"
          id="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <Button type="submit" disabled={loading}>
          Login
        </Button>

        {error && !loading && <p>credenciais incorretas</p>}
        {loading && <p>carregando</p>}
      </S.Wrapper>
    </S.Main>
  );
}
