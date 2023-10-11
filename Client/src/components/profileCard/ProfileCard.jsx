import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContextProvider";

const ProfileCard = () => {
  const { logout } = useAuth();
  const navigate = useNavigate();
  const handleLogout = () => {
    try {
      logout();
      alert("You have been logged out");
      navigate("/");
    } catch (error) {
      alert("Couldn't log out");
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
