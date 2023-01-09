import { BrowserRouter } from "react-router-dom";
import "./App.css";
import Navigation from "./Navigations/Navigation";

function App() {
  return (
    <BrowserRouter>
      <Navigation />
    </BrowserRouter>
  );
}

export default App;
