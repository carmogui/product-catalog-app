import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Home } from "../../pages";

export function OtherRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
    </BrowserRouter>
  );
}

export default OtherRoutes;
