import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  toDoState: [],
};

export const toDoSlice = createSlice({
  name: "toDoState",
  initialState,
  reducers: {
    addTodo: (state, { payload }) => {
      state.toDoState = [...state.toDoState, payload];
    },
    markTodo: (state, { payload }) => {
      state.toDoState = state.toDoState.map((data) => {
        if (payload !== data.id) {
          return data;
        }
        return {
          ...data,
          completed: !data.completed,
        };
      });
    },
    removeTodo: (state, { payload }) => {
      state.toDoState = state.toDoState.filter((data) => data.id !== payload);
    },
  },
});

export const { addTodo, markTodo, removeTodo } = toDoSlice.actions;

export default toDoSlice.reducer;
