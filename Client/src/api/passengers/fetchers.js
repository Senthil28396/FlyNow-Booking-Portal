import axios from "../../libs/axios/index";

// registering a new passanger to app
export const create = async body => {
  const data = await axios.post("/passangers/signup", body);
  return data.data;
};

// logging  the current passanger into the app
export const login = async body => {
  const data = await axios.post("/passangers/login", body);
  return data.data;
};

// getting only the single passanger details
export const getOne = async id => {
  const data = await axios.get(`/passangers/${id}`);
  return data.data;
};

// getting all the passangers details
export const getAll = async () => {
  const data = await axios.get("/passangers");
  return data.data;
};

// updating the passanger details
export const update = async ({ id, ...body }) => {
  const data = await axios.put(`/passangers/${id}`, body);
  return data.data;
};

// deleting the passanger details
export const remove = async id => {
  const data = await axios.delete(`/passangers/${id}`);
  return data.data;
};
