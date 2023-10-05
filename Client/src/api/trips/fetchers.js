import axios from "../../libs/axios/index";

// registering a new trip to flight
export const create = async body => {
  const data = await axios.post("/trips", body);
  return data.data;
};

// getting only the single trip details
export const getOne = async id => {
  const data = await axios.get(`/trips/${id}`);
  return data.data;
};

// getting all the trips details
export const getAll = async () => {
  const data = await axios.get("/trips");
  return data.data;
};

// updating the trip details
export const update = async ({ id, ...body }) => {
  const data = await axios.put(`/trips/${id}`, body);
  return data.data;
};

// deleting the trip details
export const remove = async id => {
  const data = await axios.delete(`/trips/${id}`);
  return data.data;
};
