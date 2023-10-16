import { memo } from "react";
import { NavLink } from "react-router-dom";
import { clsx } from "clsx";
import { useAuth } from "../../context/AuthContextProvider";
const NavBar = ({ bg }) => {
  const { userAccessToken: token } = useAuth();
  const role = localStorage.getItem("role");
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
        <NavLink to={"/"}>home</NavLink>
        {token ? (
          <>
            {role === "admin" ? (
              <NavLink to={"/admin/dashboard"}>dashboard</NavLink>
            ) : (
              <>
                <NavLink to={"/passagers/bookings"}>bookings</NavLink>
                <NavLink to={"/passagers/search"}>search</NavLink>
                <NavLink to={"/passagers/profile"}>profile</NavLink>
              </>
            )}
          </>
        ) : (
          <>
            <NavLink to={"/passagers/signup"}>signup</NavLink>
            <NavLink to={"/passagers/login"}>login</NavLink>
          </>
        )}
      </nav>
    </header>
  );
};

export default memo(NavBar);
