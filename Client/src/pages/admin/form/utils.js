import * as yup from "yup";
export const addTripInitialValue = {
  departure: "",
  arrival: "",
  depatureDate: "",
  arrivalDate: "",
  depatureTime: "",
  arrivalTime: "",
  status: true,
  pricePerSeat: 0,
};
export const addFlightInitialValue = {
  flightNumber: "",
  flightName: "",
  totalSeats: 0,
  status: true,
};
export const addFlightValidation = yup.object({
  flightNumber: yup.string().required("fill this field"),
  flightName: yup.string().required("fill this field"),
  totalSeats: yup
    .number()
    .positive("availableSeats must be positive")
    .required("fill this field"),
  status: yup.boolean().required("fill this field"),
});
export const validation = yup.object({
  departure: yup.string().required("fill this field"),
  arrival: yup.string().required("fill this field"),
  depatureDate: yup.string().required("fill this field"),
  arrivalDate: yup.string().required("fill this field"),
  depatureTime: yup.string().required("fill this field"),
  arrivalTime: yup.string().required("fill this field"),
  status: yup.boolean().required("fill this field"),
  pricePerSeat: yup
    .number()
    .positive("pricePerSeat must be positive")
    .required("fill this field"),
});
