import * as yup from "yup";
export const initialValue = {
  depature: "",
  arrival: "",
  arrivalDate: "",
};

export const validation = yup.object({
  depature: yup.string().required("depature must be specified"),
  arrival: yup.string().required("arrival must be specified"),
  arrivalDate: yup.date().required("arrivalDate must be specified"),
});
