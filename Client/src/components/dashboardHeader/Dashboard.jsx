import { upperCase } from "lodash";
import { Link } from "react-router-dom";
import clsx from "clsx";

const DashboardHeader = ({
  to = "/",
  title = "",
  sectionClass,
  headerClass,
  buttonClass,
  buttonLabel,
  notHas,
}) => {
  return (
    <section className={`${clsx(sectionClass && sectionClass)} h-[100px]`}>
      <h2
        className={`${
          (clsx(headerClass && headerClass),
          "font-bold tracking-wide text-2xl text-gray-800")
        }`}
      >
        {upperCase(title)}
      </h2>
      {notHas ?? (
        <Link
          to={to}
          className={`${clsx(
            buttonClass && buttonClass
          )},"block  shadow-md self-start shadow-gray-300 font-semibold"`}
        >
          {upperCase(buttonLabel)}
        </Link>
      )}
    </section>
  );
};

export default DashboardHeader;
