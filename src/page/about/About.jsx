import React from "react";

const About = () => {
  return (
    <>
      <div>
        <meta charSet="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta httpEquiv="X-UA-Compatible" content="ie=edge" />
        <link href="asset/css/bootstrap.min.css" rel="stylesheet" />
        <link href="asset/css/main.css" rel="stylesheet" type="text/css" />
        <link href="asset/js/bootstrap.min.js" rel="stylesheet" />
        <title>Tentang Saya</title>
        <div className="container-fluid about-me">
          <h1 className="container pl-2 pt-5 pb-5">ABOUT ME.</h1>
        </div>
        <div className="container">
          <div className="row pt-5 pb-5 ">
            <div className="col-lg-7 col-md-12 col-sm-12 col-12 pl-5">
              <div className="about-anne">
                <p>
                  Hello! I’m Anne Sullivan, a full-stack engineer based in
                  Malang, IDN who enjoys building things that live on the
                  internet. I develop exceptional websites and web apps that
                  provide intuitive, pixel-perfect user interfaces with
                  efficient and modern backends. <br />
                  <br />
                  Shortly after graduating from Alterra Academy, I joined the
                  engineering team at Alterra where I work on a wide variety of
                  interesting and meaningful projects on a daily basis. <br />
                  <br />
                  Here’s few technologies I’ve been working with recently :
                </p>
              </div>
              <div>
                <table className="tabel-anne">
                  <tbody>
                    <tr>
                      <td>HTML &amp; CSS</td>
                      <td>Serverless</td>
                      <td>Scrum</td>
                    </tr>
                    <tr>
                      <td>Programming</td>
                      <td>Restful API</td>
                      <td>Test-Driven Dev</td>
                    </tr>
                    <tr>
                      <td>Database</td>
                      <td>Javascript</td>
                      <td>Software Testing</td>
                    </tr>
                    <tr>
                      <td>Git &amp; Github</td>
                      <td>Sigle Page App</td>
                      <td>UX/UI Designer</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div className="col-lg-5 col-md-12 col-sm-12 col-12 pr-5">
              <div className="foto-id text-lg-right text-md-center text-sm-center">
                <img src="asset/img/matthew-hamilton-tNCH0sKSZbA-unsplash.jpg" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default About;
