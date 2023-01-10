import { useState } from "react";
import { useForm } from "react-hook-form";

const Registration = () => {
  const {
    formState: { errors },
    handleSubmit,
    register,
    reset,
  } = useForm();

  const courseData = [
    { name: "Coding Backend with Golang", value: 1 },
    { name: "Coding Frontend with ReactJs", value: 2 },
    { name: "Fullstack Developer", value: 2 },
  ];
  const backgroundData = [
    { name: "IT", value: 1 },
    { name: "No IT", value: 2 },
  ];

  const formSubmit = (data, e) => {
    alert(`Congrats ${data.name}, ur registration is succeded`);
    e.preventDefault();
    reset();
  };

  return (
    <form
      onSubmit={handleSubmit(formSubmit)}
      className=" w-full justify-center gap-x-1 gap-y-1"
    >
      <div>
        <label className="block mb-2 text-lg font-xl text-gray-900 dark:text-gray">
          Name:
          <input
            placeholder="john doe"
            {...register("name", {
              required: {
                value: true,
                message: "Full Name must be filled",
              },
              pattern: {
                value: /^[A-Za-z ]+$/,
                message: "Name cannot be number or other character",
              },
              minLength: {
                value: 4,
                message: "Name minimium 4 chacracter",
              },
            })}
            className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-1 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-400 focus:border-transparent"
          ></input>
        </label>
      </div>
      <div>
        <label className="block mb-2 text-lg font-xl text-gray-900 dark:text-gray">
          Email:
          <input
            placeholder="ex johndoe@larymail.com"
            {...register("email", {
              pattern: {
                value: /\S+@\S+\.\S+/,
                message: "Not an email",
              },
              required: {
                value: true,
                message: "Email must be filled",
              },
              minLength: {
                value: 7,
                message: "Email number minimium 5 chacracter",
              },
            })}
            className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-1 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-400 focus:border-transparent"
          ></input>
        </label>
      </div>
      <div>
        <label className="inline mb-2 text-lg font-xl text-gray-900 dark:text-gray">
          Phone Number:
          <input
            placeholder="ex: 14045"
            {...register("phoneNumber", {
              pattern: {
                value: /^[0-9,+]+$/,
                message: "Not a number",
              },
              required: {
                value: true,
                message: "Phone number must be filled",
              },
              minLength: {
                value: 5,
                message: "Phone number minimium 5 chacracter",
              },
              maxLength: {
                value: 20,
                message: "Phone number max 12 character",
              },
            })}
            className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-1 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-400 focus:border-transparent"
          ></input>
        </label>
      </div>
      <div>
        <h4 className="mr-5 mt-5 inline mb-2 text-lg font-xl text-gray-900 dark:text-gray">
          Background:
        </h4>
        {backgroundData.map((data, index) => (
          <label
            key={index}
            className="mr-5 inline mb-2 text-lg font-xl text-gray-900 dark:text-gray gap-x-1 gap-y-1"
          >
            <input
              {...register("background", {
                required: {
                  value: true,
                  message: "Background must be selected",
                },
              })}
              placeholder="it"
              type="radio"
              value={data.name}
              className="mr-1 rounded-lg border-transparent flex-1 appearance-none border border-gray-300 py-1 px-1 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-400 focus:border-transparent"
            ></input>
            {data.name}
          </label>
        ))}
      </div>
      <div>
        <label className="block mb-2 text-lg font-xl text-gray-900 dark:text-gray">
          Selected Course:{"   "}
          <select
            {...register("course", {
              required: {
                value: true,
                message: "Course must be selected",
              },
            })}
            name="course"
            className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 py-1 px-2 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-400 focus:border-transparent w-full"
          >
            {courseData.map((data, index) => (
              <option key={index} name={data.name} value={data.name}>
                {data.name}
              </option>
            ))}
          </select>
        </label>
      </div>
      <div>
        <label className="block mb-2 text-lg font-xl text-gray-900 dark:text-gray">
          Motivation letter:
          <input
            placeholder=""
            type="file"
            {...register("letter", {
              required: {
                value: true,
                message: "Motivation letter must be uploaded",
              },
            })}
            className="rounded-lg border-transparent w-full appearance-none border border-gray-300 cursor-pointer bg-white dark:text-gray-700 placeholder-gray-400 shadow-sm focus:outline-non dark:placeholder-purple-400 focus:ring-2 focus:ring-purple-400 focus:border-transparent"
          ></input>
        </label>
      </div>
      <div>
        <label className="block mb-2 text-lg font-xl text-gray-900 dark:text-gray">
          Wishes:
          <textarea
            {...register("wish", {
              required: {
                value: true,
                message: "Wish must be filled!",
              },
            })}
            rows="4"
            cols="50"
            placeholder="Whats ur wishes?"
            className="rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-1 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-400 focus:border-transparent"
          ></textarea>
        </label>
      </div>
      <div>
        {errors.name && (
          <label className="block text-red-800 font-bold">
            {errors.name.message}
          </label>
        )}
        {errors.email && (
          <label className="block text-red-800 font-bold">
            {errors.email.message}
          </label>
        )}
        {errors.phoneNumber && (
          <label className="block text-red-800 font-bold">
            {errors.phoneNumber.message}
          </label>
        )}
      </div>
      <div className="py-1">
        <button
          type="submit"
          className="px-5 mr-5 py-1 text-base font-semibold text-white bg-purple-400 rounded-lg shadow-md hover:bg-purple-200 focus:outline-none focus:ring-2 focus:ring-purple-200 focus:ring-offset-2 focus:ring-offset-purple-200"
        >
          Submit
        </button>
        <button
          type="reset"
          className="px-5 py-1 text-base font-semibold text-white bg-red-800 rounded-lg shadow-md hover:bg-red-200 focus:outline-none focus:ring-2 focus:ring-purple-200 focus:ring-offset-2 focus:ring-offset-purple-200"
        >
          Reset
        </button>
      </div>
    </form>
  );
};

export default Registration;
