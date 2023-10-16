import * as yup from "yup";
export const initialValues = {
  numberOfPassangers: 1,
  paymentMode: "",
  transactionId: "",
};

export const validation = yup.object({
  numberOfPassangers: yup
    .number()
    .positive("numberOfPassangers must be positive")
    .required("numberOfPassangers must be filled"),
  paymentMode: yup
    .string("paymentMode must be string")
    .required("paymentMode must be filled")
    .oneOf(["cash", "upi"], "invlaid payment method"),
  transactionId: yup.string().when("paymentMode", {
    is: (value) => value?.toLowerCase() === "upi",
    then: (schema) => schema.required("transactionId must be filled"),
    otherwise: (schema) => schema.notRequired(),
  }),
});
