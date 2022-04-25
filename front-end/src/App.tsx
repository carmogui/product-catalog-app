import { Button } from "./components";

function App() {
  return (
    <div>
      <h1>product-catalog</h1>
      <Button onClick={() => alert("primary")}>primary button</Button>
      <Button onClick={() => alert("link")} variant="link">
        link button
      </Button>
    </div>
  );
}

export default App;
