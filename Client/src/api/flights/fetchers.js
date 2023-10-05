import axios from "../../libs/axios/index";

// registering a new flight to app
export const create = async body => {
  const data = await axios.post("/flights", body);
  return data.data;
};

// getting only the single flight details
export const getOne = async id => {
  const data = await axios.get(`/flights/${id}`);
  return data.data;
};

// getting all the flights details
export const getAll = async () => {
  const data = await axios.get("/flights");
  return data.data;
};

// updating the flight details
export const update = async ({ id, ...body }) => {
  const data = await axios.put(`/flights/${id}`, body);
  return data.data;
};

// deleting the flight details
export const remove = async id => {
  const data = await axios.delete(`/flights/${id}`);
  return data.data;
};
