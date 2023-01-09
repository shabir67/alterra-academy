//Nav dep
import { Outlet, Routes, Route } from "react-router-dom";
//Layout
import Footer from "../Components/Footer/Footer";
import Navbar from "../Components/Navbar/NavBar";
//Page
import Home from "../Page/Home/Home";
import AboutUs from "../Page/AboutUs/AboutUs";
import NotFound from "../Page/404NotFound/404NotFound";
import UserForm from "../Page/UserForm/UserForm";

function BasicLayout() {
  return (
    <>
      <Navbar />
      <Outlet />
      <Footer />
    </>
  );
}

function Navigation() {
  return (
    <>
      <Routes>
        <Route path="/" element={<BasicLayout />}>
          <Route index element={<Home />} />
          <Route path="about-us" element={<AboutUs />} />
          <Route path="form" element={<UserForm />} />
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </>
  );
}

export default Navigation;
