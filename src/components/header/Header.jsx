import React from "react";

const Header = () => {
  return (
    <header>
      <div className="container">
        <div className="row align-items-center">
          <div className="col-lg-8 col-md-12 col-sm-12 col-12">
            <div className="alterra">
              <a href="index.html">
                <img className="logo-atas" src="asset/img/logo-ALTA@2x.png" />
              </a>
            </div>
          </div>
          <div className="col-lg-4 col-md-12 col-sm-12 col-12">
            {/* <div class="container"> */}
            <div className="row align-items-center navig">
              <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-right">
                <a href="index.html" className="aktif">
                  HOME
                </a>
              </div>
              <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-center">
                <a href="about.html">ABOUT</a>
              </div>
              <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-left">
                <a href="#">EXPERIENCE</a>
              </div>
              <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-right">
                <a href="form.html">CONTACT</a>
              </div>
            </div>
            {/* </div> */}
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
