import React from "react";

function Footer() {
  return (
    <div className="flex flex-col items-center justify-center bg-gray-100  p-5 text-center">
      <h1 className="text-base font-semibold text-gray-800">
        © 2022 All rights reserved | Build with ❤ by{"Shobir "}
        <span className="cursor-pointer font-semibold hover:text-pasmur-green-base">
          Syncdev{" "}
        </span>
      </h1>
    </div>
  );
}

export default Footer;
