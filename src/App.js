import "./App.css";
import { BrowserRouter } from "react-router-dom";
import Navigation from "./Navigations/Navigation";
import { Provider } from "react-redux";
import { persistor, store } from "./Store";
import { PersistGate } from "redux-persist/integration/react";

function App() {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <BrowserRouter>
          <Navigation />
        </BrowserRouter>
      </PersistGate>
    </Provider>
  );
}

export default App;
