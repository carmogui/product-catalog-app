import { AuthProvider } from "./context/auth";
import { Routes } from "./routes";

function App() {
  return (
    <AuthProvider>
      <Routes />
    </AuthProvider>
  );
}
// function App() {
//   return (
//     <BrowserRouter>
//       <Routes>
//         <Route path="/" element={<Login />} />
//         <Route path="home" element={<Home />} />
//         <Route path="catalog" element={<Catalog />} />
//         <Route path="product" element={<Product />} />

//         <Route path="*" element={<NotFound />} />
//       </Routes>
//     </BrowserRouter>
//   );
// }

export default App;
