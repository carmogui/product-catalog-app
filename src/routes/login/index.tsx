import { useState } from "react";
import { Button, Input } from "../../components";
import { auth } from "../../services/";
import * as S from "./styles";

export function LoginPage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  async function handleSubmit(e: any) {
    e.preventDefault();

    const data = await auth({ username, password });

    if (data.status === 200) {
      localStorage.setItem("access_token", data.data.access_token);
      localStorage.setItem("refresh_token", data.data.refresh_token);
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

        <Button type="submit">Login</Button>
      </S.Wrapper>
    </S.Main>
  );
}
