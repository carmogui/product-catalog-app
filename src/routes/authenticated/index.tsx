import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Catalog, Home, NotFound, Product } from "../../pages";

export function AuthenticatedRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="catalog" element={<Catalog />} />
        <Route path="product" element={<Product />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
