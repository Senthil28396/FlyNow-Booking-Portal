import * as yup from "yup";
export const initialValues = {
  firstName: "",
  lastName: "",
  gender: "",
  phoneNumber: "",
  password: "",
  email: "",
  age: 0,
  address: "",
  passportNumber: "",
  nationality: "",
};
export const validation = yup.object({
  firstName: yup.string().required("fill this field"),
  lastName: yup.string().required("fill this field"),
  gender: yup
    .string()
    .required("fill this field")
    .oneOf(["male", "female", "others"],"invalid gender"),
  phoneNumber: yup
    .string()
    .required("fill this field")
    .length(10, "mobile number should be 10 characters"),
  password: yup.string().required("fill this field"),
  email: yup
    .string()
    .required("fill this field")
    .email("invalid email address"),
  age: yup.number().required("fill this field"),
  address: yup.string().required("fill this field"),
  passportNumber: yup.string().required("fill this field"),
  nationality: yup.string().required("fill this field"),
});
