import { useState } from "react";
import "./App.css";
import Todo from "./components/Todo/Todo";
import Form from "./components/Form/Form";

function App() {
  const [datas, setDatas] = useState([
    {
      id: 1,
      title: "Mengerjakan Tugas Altera",
      completed: false,
    },
    {
      id: 2,
      title: "Tidur",
      completed: false,
    },
  ]);

  const addTodos = (input) => {
    const newDatas = [
      ...datas,
      {
        id: datas.length + 2,
        title: input,
        completed: false,
      },
    ];
    setDatas(newDatas);
  };

  const markTodos = (index, value) => {
    const newDatas = [...datas];
    newDatas[index].completed = value;
    setDatas(newDatas);
  };

  const editTodos = (index, data) => {
    const newDatas = [...datas];
    newDatas[index].title = data.title;
    setDatas(newDatas);
  };

  const removeTodos = (index) => {
    const newDatas = [...datas];
    newDatas.splice(index, 1);
    setDatas(newDatas);
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-indigo-100">
      <div className="flex flex-col gap-y-2 items-center justify-center w-full sm:w-5/7 md:w-1/2 max-w-sm rounded-lg p-5 shadow-md bg-gray-100 text-middle characters">
        {console.log(datas)}
        <h1 className="my-10 text-5xl font-bold md:text-7xl text-indigo-500 hover:text-indigo-700 ">
          To<span className="text-blue-500">D0</span>
        </h1>
        <Form addTodo={addTodos} />
        {datas.map((data, index) => (
          <Todo
            key={index}
            index={index}
            data={data}
            removeTodo={removeTodos}
            markTodo={markTodos}
          />
        ))}
      </div>
    </div>
  );
}

export default App;
