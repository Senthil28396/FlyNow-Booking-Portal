import * as yup from "yup";
export const initialValues = {
  username: "",
  password: "",
};
export const validation = yup.object({
  username: yup
    .string()
    .required("username is required")
    .trim("no whitespace allowed"),
  password: yup
    .string()
    .required("password is required")
    .trim("no whitespace allowed"),
});
