import { useEffect, useReducer } from "react";
const reducer = (state, action) => {
  switch (action.type) {
    case "success": {
      return {
        data: action.payload,
        error: null,
      };
    }
    case "failure": {
      return {
        data: null,
        error: action.payload,
      };
    }
    default: {
      return state;
    }
  }
};
const initialState = {
  data: null,
  error: null,
};
const useQuery = fetcherMethod => {
  const [state, dispatch] = useReducer(reducer, initialState);
  useEffect(() => {
    fetcherMethod()
      .then(response => dispatch({ type: "success", payload: response }))
      .catch(error => dispatch({ type: "failure", payload: error }));
  }, [fetcherMethod]);
  return state;
};

export default useQuery;
