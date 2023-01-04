import React from "react";

const Home = () => {
  return (
    <>
      <div>
        <meta charSet="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta httpEquiv="X-UA-Compatible" content="ie=edge" />
        <link href="asset/css/bootstrap.min.css" rel="stylesheet" />
        <link href="asset/css/main.css" rel="stylesheet" type="text/css" />
        <link href="asset/js/bootstrap.min.js" rel="stylesheet" />
        <title>Beranda</title>

        <div className="container h-100">
          <div className="row align-items-center isi-home">
            <div className="col-lg-4 col-md-12 col-sm-12  col-12">
              <img
                id="foto-profil"
                src="asset/img/matthew-hamilton-tNCH0sKSZbA-unsplash.jpg"
              />
            </div>
            <div className="col-lg-8 col-md-12 col-sm-12 col-12">
              <div className="main-p">
                <p className="sapaan">Hi, my name is </p>
                <p className="nama">Anne Sullivan</p>
                <p className="hobi">I build things for the web</p>
                <p className="tombol">
                  <a href="about.html">Get In Touch</a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};
export default Home;
