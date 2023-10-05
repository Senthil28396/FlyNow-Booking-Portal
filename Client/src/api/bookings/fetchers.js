import axios from "../../libs/axios/index";

// registering a new reservation to passanger
export const create = async body => {
  const data = await axios.post("/reservations", body);
  return data.data;
};

// getting only the single reservation details
export const getOne = async id => {
  const data = await axios.get(`/reservations/${id}`);
  return data.data;
};

// getting all the reservations details
export const getAll = async () => {
  const data = await axios.get("/reservations");
  return data.data;
};

// updating the reservation details
export const update = async ({ id, ...body }) => {
  const data = await axios.put(`/reservations/${id}`, body);
  return data.data;
};

// deleting the reservation details
export const remove = async id => {
  const data = await axios.delete(`/reservations/${id}`);
  return data.data;
};
