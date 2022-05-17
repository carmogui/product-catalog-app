import axios from "axios";
import { useState } from "react";
import { Link } from "react-router-dom";

export function Catalog() {
  const [product, setProduct] = useState<any>(null);

  async function getProduct() {
    const token = localStorage.getItem("access_token") || "";
    console.log(token);

    const result = await axios({
      method: "post",
      url: "http://productcatalog-api.herokuapp.com/api/product",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    console.log(result);
  }

  return (
    <main>
      <h1>Catalog</h1>
      <button onClick={getProduct}>request</button>
      <Link to="/">voltar</Link>
    </main>
  );
}
