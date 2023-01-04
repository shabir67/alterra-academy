import "./App.css";
import Footer from "./components/footer/Footer";
import Header from "./components/header/Header";
import About from "./page/about/About";
import Form from "./page/form/Form";
import Home from "./page/home/Home";

function App() {
  return (
    <>
      <Header />
      <Home />
      <About />
      <Form />
      <Footer />
    </>
  );
}

export default App;
