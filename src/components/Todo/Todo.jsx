import { markTodos, removeTodos, fetchTodos } from "../../Store/toDo";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";

const Todo = () => {
  // const datas = useSelector((state) => state?.todo?.todos);
  const { todos, status } = useSelector((state) => ({
    todos: state.todo.todos,
    status: state.loading,
  }));
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchTodos());
    console.log("ini todos ", todos);
  }, []);

  // function initiate() {
  // }

  function toggle(index) {
    return dispatch(markTodos(index));
  }

  function deleteTodo(index) {
    return dispatch(removeTodos(index));
  }
  if (status) return <p>Loading...</p>;

  return (
    <>
      {todos &&
        todos.map((data) => (
          <div
            key={data.id}
            className="flex flex-col w-full rounded-lg p-bo shadow-md bg-gray-100 teext-middle characters"
          >
            <div className="border bg-gray-200 rounded flex flex-row items-center p-1 justify-between select-none">
              <label className="flex items-center justify-start space-x-3 overflow-auto">
                <input
                  type="checkbox"
                  id="topping"
                  name="topping"
                  onChange={() => {
                    toggle(data.id);
                  }}
                  checked={data.completed ? true : false}
                  className="form-tick flex-initial bg-white bg-check h-6 w-24px min-w-6 border border-gray-300 rounded-md checked:bg-blue-500 checked:border-transparent focus:outline-none"
                />
              </label>
              <span
                style={{
                  textDecoration: data.completed ? "line-through" : "",
                }}
                className="font-light truncate max-h-16"
              >
                {data.title}
              </span>
              <button
                type="button"
                className="flex justify-center items-center focus:ring-gray-400 focus:ring-offset-gray-200 text-white transition ease-in duration-200 text-center text-base font-semibold focus:outline-none focus:ring-2 focus:ring-offset-2  w-6 h-6 rounded-xl "
                onClick={() => deleteTodo(data.id)}
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  className="icon icon-tabler icon-tabler-square-x"
                  width="32"
                  height="32"
                  viewBox="0 0 24 24"
                  strokeWidth="1.5"
                  stroke="#999"
                  fill="none"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                >
                  <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                  <rect x="4" y="4" width="16" height="16" rx="2" />
                  <path d="M10 10l4 4m0 -4l-4 4" />
                </svg>
              </button>
            </div>
          </div>
        ))}
    </>
    // <></>
  );
};

export default Todo;
