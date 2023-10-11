import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContextProvider";
import { useEffect, useState } from "react";
import { getOne } from "../../api/passengers/fetchers";
import _ from "lodash";
const ProfileCard = () => {
  const { logout } = useAuth();
  const navigate = useNavigate();
  const [user, setUser] = useState(null);
  useEffect(() => {
    try {
      const id = Number(localStorage.getItem("currentUserId"));
      getOne(id).then((response) => {
        const updatedResponse = _.omit(response, []);
        setUser({ ...updatedResponse });
      });
    } catch (error) {
      alert(error.message);
    }
  }, []);
  console.log({ user });
  const handleLogout = () => {
    try {
      logout();
      alert("You have been logged out");
      return navigate("/");
    } catch (error) {
      return alert("Couldn't log out");
    }
  };

  return (
    <div>
      <h1>ProfileCard</h1>
      <button onClick={handleLogout}>logout</button>
    </div>
  );
};

export default ProfileCard;
