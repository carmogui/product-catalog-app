import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login, NotFound } from "../../pages";

export function OtherRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default OtherRoutes;
