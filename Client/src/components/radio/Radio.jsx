import clsx from "clsx";
import { ErrorMessage, Field } from "formik";
import { capitalize } from "lodash";

const RadioGroup = ({
  values = [],
  label = "",
  name,
  divClassName,
  groupClassName,
}) => {
  return (
    <div className={clsx(divClassName && divClassName)}>
      <label htmlFor={name}>
        {capitalize(label)}
        <div className={clsx(groupClassName && groupClassName)}>
          {values.map(value => (
            <label htmlFor={value} key={value}>
              <Field name={name} value={value} id={value} type="radio" />
              <span className="ml-[2px]">{capitalize(value)}</span>
            </label>
          ))}
        </div>
      </label>
      <ErrorMessage name={name}>
        {error => <small className="text-red-500">{error}</small>}
      </ErrorMessage>
    </div>
  );
};

export default RadioGroup;
