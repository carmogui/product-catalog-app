import { Link } from "react-router-dom";

export function NotFound() {
  return (
    <main>
      <h1>Error 404</h1>
      <h2>Página não encontrada</h2>
      <Link to="/">Home</Link>
    </main>
  );
}
