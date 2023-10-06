import clsx from "clsx";
import { ErrorMessage, useField } from "formik";
import _ from "lodash";
const AppInput = ({
  type = "text",
  name,
  label,
  required,
  helper,
  className,
  divClassName,
  labelClassName,
  ...props
}) => {
  const [field] = useField({
    name,
    type,
    className,
    required,
    ...props,
  });
  return (
    <div className={clsx(divClassName && `${divClassName}`)}>
      <label
        htmlFor={name}
        className={clsx(labelClassName && `${labelClassName}`)}
      >
        {`${_.capitalize(label)}`}
        {required && <span>*</span>}
      </label>
      <input
        type={type}
        id={name}
        name={name}
        {...props}
        {...field}
        className={clsx(className && `${className}`)}
      />
      {helper && <span>{_.capitalize(helper)}</span>}
      <ErrorMessage name={name}>{error => <span>{error}</span>}</ErrorMessage>
    </div>
  );
};

export default AppInput;
