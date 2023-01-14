import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const BASE_URL = "https://jsonplaceholder.typicode.com/todos";

const initialState = {
  todos: [],
  status: "idle",
  error: "",
};

export const fetchTodos = createAsyncThunk("todos/fetchTodos", async () => {
  let res = await axios.get(BASE_URL);
  res = res.data.slice(0, 2);
  console.log("ini res", res);
  return res;
});

export const todoSlice = createSlice({
  name: "todos",
  initialState,
  reducers: {
    addTodos: (state, { payload }) => {
      state.todos = [...state.todos, payload];
    },
    markTodos: (state, { payload }) => {
      state.todos = state.todos.map((data) => {
        if (payload !== data.id) {
          return data;
        }
        return {
          ...data,
          completed: !data.completed,
        };
      });
    },
    removeTodos: (state, { payload }) => {
      state.todos = state.todos.filter((data) => data.id !== payload);
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(fetchTodos.pending, (state) => {
        state.status = "loading";
      })
      .addCase(fetchTodos.fulfilled, (state, action) => {
        state.status = "succeeded";
        if (state.todos.length <= 0) {
          state.todos = action.payload;
        } else state.todos = [...state.todos];
      })
      .addCase(fetchTodos.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message;
      });
  },
});

export const { addTodos, markTodos, removeTodos } = todoSlice.actions;
export const selectAllTodos = (state) => state.todo.todos;
export const getPostsError = (state) => state.posts.error;
export const getPostsStatus = (state) => state.posts.status;

export default todoSlice.reducer;
