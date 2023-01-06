import { useState } from "react";

const Form = (props) => {
  const [value, setValue] = useState("");
  const [active, setActive] = useState(false);

  const handleActivation = (e) => {
    setActive(!!e.target.value);
  };

  let addTodo = props.addTodo;
  const handleSubmit = (event) => {
    event.preventDefault();
    if (value.length <= 0) {
      alert(`Oops, sepertinya kamu lupa mengisi inputan`);
    } else {
      addTodo(value);
      setValue("");
      event.target.reset();
    }
  };

  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
      handleSubmit();
    }
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="flex flex-row w-full justify-center gap-x-1"
    >
      <label>
        <input
          placeholder="Add todo..."
          type="text"
          onChange={(e) => {
            setValue((value) => (value = e.target.value));
            handleActivation();
          }}
          className=" rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-1 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
        ></input>
      </label>
      <button
        type="submit"
        className="px-2 py-1 text-base font-semibold text-white bg-indigo-600 rounded-lg shadow-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 focus:ring-offset-purple-200"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          className="h-6 w-6"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          strokeWidth="2"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="M12 4v16m8-8H4"
          />
        </svg>
      </button>
    </form>
  );
};

export default Form;
