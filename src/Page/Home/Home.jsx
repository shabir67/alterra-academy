import Todo from "../../Components/Todo/Todo";
import Form from "../../Components/Form/Form";

function Home() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-indigo-100">
      <div className="flex flex-col gap-y-2 items-center justify-center w-full sm:w-1/2 md:w-1/2 max-w-sm rounded-lg p-5 shadow-md bg-gray-100 text-middle characters">
        {/* {console.log(datas)} */}
        <h1 className="my-10 text-5xl font-bold md:text-7xl text-purple-400 hover:text-indigo-100 ">
          To<span className="text-purple-800">D0</span>
        </h1>
        <Form />
        <Todo />
      </div>
    </div>
  );
}

export default Home;
