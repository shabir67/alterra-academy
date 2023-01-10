import React from "react";
import Registration from "../../Components/Registration/Registartion";

function UserForm() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-indigo-100">
      <div className="flex flex-col items-center justify-center w-full sm:w-3/4 md:w-full max-w-2xl px-5 rounded-lg p-5 shadow-md bg-gray-100 text-middle characters">
        <h1 className="my-5 text-xl font-bold md:text-3xl text-purple-800 hover:text-purple-400 animate-pulse">
          Conding Bootcamp{" "}
          <span className="text-#cc98ff-800">Registration!</span>
        </h1>
        <Registration />
      </div>
    </div>
  );
}
export default UserForm;
