import { memo } from "react";
import { NavLink } from "react-router-dom";
import { clsx } from "clsx";
import { useAuth } from "../../context/AuthContextProvider";
const NavBar = ({ bg }) => {
  const { userAccessToken: token } = useAuth();
  return (
    <header
      className={clsx(
        "flex items-center justify-between  text-white h-[50px] px-10 capitalize",
        bg && "bg-indigo-600"
      )}
    >
      <h2 className="text-2xl uppercase tracking-wider font-extrabold">
        frenzo
      </h2>
      <nav className="flex gap-10">
        <NavLink to={"/"} className="">
          home
        </NavLink>
        <NavLink to={"/about"} className="">
          about
        </NavLink>
        {token ? (
          <>
            <NavLink to={"/passagers/bookings"} className="">
              bookings
            </NavLink>
            <NavLink to={"/passagers/search"} className="">
              search
            </NavLink>
            <NavLink to={"/admin/dashboard"} className="">
              dashboard
            </NavLink>
          </>
        ) : (
          <>
            <NavLink to={"/passagers/signup"} className="">
              signup
            </NavLink>
            <NavLink to={"/passagers/login"} className="">
              login
            </NavLink>
          </>
        )}
      </nav>
    </header>
  );
};

export default memo(NavBar);
