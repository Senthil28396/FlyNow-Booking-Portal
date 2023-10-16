import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContextProvider";
import { useEffect, useState } from "react";
import { getOne } from "../../api/passengers/fetchers";
import _, { upperCase } from "lodash";
import clsx from "clsx";
const ProfileCard = ({ sectionClass, containerClass }) => {
  const { logout } = useAuth();
  const navigate = useNavigate();
  const [user, setUser] = useState(null);
  useEffect(() => {
    try {
      const id = Number(localStorage.getItem("currentUserId"));
      getOne(id).then((response) => {
        const updatedResponse = _.omit(response, [
          "id",
          "password",
          "admin",
          "reservations",
          "role",
        ]);
        setUser({ ...updatedResponse });
      });
    } catch (error) {
      alert(error.message);
    }
  }, []);
  const handleLogout = () => {
    try {
      logout();
      alert("You have been logged out");
      return navigate("/");
    } catch (error) {
      return alert("Couldn't log out");
    }
  };

  return user ? (
    <section className={`${clsx(sectionClass && sectionClass)}`}>
      <div className="flex justify-end pr-7">
        <button
          onClick={handleLogout}
          className="py-2 uppercase bg-red-600 text-white rounded-md px-4"
        >
          logout
        </button>
      </div>
      <section
        className={`w-[calc(100%-30px)] m-3  grid  gap-3 p-4 grid-cols-3 ${
          containerClass && containerClass
        }`}
      >
        {Object.keys(user).map((key) => (
          <Box key={key} label={key} value={user[key] ?? ""} />
        ))}
      </section>
    </section>
  ) : null;
};

export default ProfileCard;

const Box = ({ label, value }) => {
  return (
    <div className="flex flex-col gap-2">
      <h1 aria-describedby={label} className="font-bold  tracking-wide">
        {upperCase(label)}
      </h1>
      <span id={label} className="ml-2 font-semibold">
        {upperCase(value)}
      </span>
    </div>
  );
};
