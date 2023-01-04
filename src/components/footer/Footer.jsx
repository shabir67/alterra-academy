import React from "react";

const Footer = () => {
  return (
    <footer>
      <div className="container">
        <div className="row pt-5 pb-5">
          <div className="pl-5 col-lg-5 col-md-4 col-sm-12 col-12 text-lg-left text-md-left text-sm-center">
            <a href="index.html">
              <img className="logo-bawah" src="asset/img/logo-ALTA-v2.png" />
            </a>
          </div>
          <div className="col-lg-3 col-md-3 col-sm-12 col-12 text-lr-left text-md-center text-sm-center">
            <h6>Social Media:</h6>
            {/* <div class="col-3 text-center"> */}
            <a href="https://www.facebook.com/AlterraAcademy">
              <img className="logo-sosmed" src="asset/img/ic_fb@2x.png" />
            </a>
            {/* </div> */}
            {/* <div class="col-3 text-center"> */}
            <a href="https://twitter.com/">
              <img className="logo-sosmed" src="asset/img/ic-twitter@2x.png" />
            </a>
            {/* </div> */}
            {/* <div class="col-3 text-center"> */}
            <a href="https://www.instagram.com/alterra.academy/">
              <img
                className="logo-sosmed"
                src="asset/img/ic-instagram@2x.png"
              />
            </a>
            {/* </div> */}
            {/* <div class="col-3 text-center"> */}
            <a href="https://id.linkedin.com/">
              <img className="logo-sosmed" src="asset/img/ic-linkedin@2x.png" />
            </a>
            {/* </div> */}
          </div>
          <div className="col-lg-4 col-md-5 col-sm-12 col-12 pt-3">
            <h6 className="text-lg-right text-md-center text-sm-center kopi">
              Copyleft © 2019 - Unjelas Team
            </h6>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
