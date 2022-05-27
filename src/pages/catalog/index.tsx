import { useState } from "react";
import { Link } from "react-router-dom";
import { productService } from "../../services/product";

export function Catalog() {
  const [productList, setProductList] = useState<any>(null);

  async function getProduct() {
    const result = await productService.getList();

    setProductList(result);
  }

  return (
    <main>
      <h1>Catalog</h1>
      <button onClick={getProduct}>request</button>
      <Link to="/">voltar</Link>
      <p>{productList?.content?.map((product: any) => product?.name)}</p>
    </main>
  );
}
