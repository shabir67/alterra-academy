import React from "react";
import AboutUsGif from "../../Assets/aboutUs.gif";

function AboutUs() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-indigo-100">
      <div className="astronaut">
        <img
          src={AboutUsGif}
          alt=""
          className="animate-waving"
          width={500}
          height={500}
        />
      </div>
      <h1 className="my-10 text-5xl font-bold md:text-7xl text-purple-800 hover:text-purple-400 animate-pulse">
        About <span className="text-#cc98ff-800">Us!</span>
      </h1>
    </div>
  );
}
export default AboutUs;
