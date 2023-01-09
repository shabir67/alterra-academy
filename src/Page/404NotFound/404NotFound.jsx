import React from "react";

function NotFound() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-indigo-100">
      <div className="astronaut">
        <img
          src="https://images.vexels.com/media/users/3/152639/isolated/preview/506b575739e90613428cdb399175e2c8-space-astronaut-cartoon-by-vexels.png"
          alt=""
          className="animate-bounce"
          width={100}
          height={100}
        />
      </div>
      <h1 className="my-10 text-5xl font-bold md:text-7xl text-indigo-500 hover:text-indigo-700 animate-pulse">
        ERROR <span className="text-#cc98ff-800">404</span>, Page not found
      </h1>
    </div>
  );
}
export default NotFound;
