import { Link } from "react-router-dom";
import { Button } from "../../components";

export function Home() {
  return (
    <main>
      <h1>product-catalog</h1>

      <Link to="/catalog">
        <Button>Catalog</Button>
      </Link>

      <Link to="/product">
        <Button>Product</Button>
      </Link>
    </main>
  );
}
