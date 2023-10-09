import * as yup from "yup";
export const initialValues = {
  username: "",
  password: "",
};
export const validation = yup.object({
  username: yup.string().required("username must not be empty").trim(),
  password: yup.string().required("password must not be empty").trim(),
});
