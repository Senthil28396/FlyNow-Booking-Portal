import * as yup from "yup";
export const initialValues = {
  email: "",
  password: "",
};
export const validation = yup.object({
  email: yup.string().required("email must not be empty").trim(),
  password: yup.string().required("password must not be empty").trim(),
});
