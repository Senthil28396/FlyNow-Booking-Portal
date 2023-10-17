import NavBar from "../../../components/navbar/NavBar";
import ProfileCard from "../../../components/profileCard/ProfileCard";
const ProfilePage = () => {
  return (
    <main className="bg-laggauage bg-cover h-screen bg-blend-multiply bg-black/40 text-white">
      <NavBar />
      <ProfileCard
        sectionClass="p-5 h-[calc(100vh-50px)]"
        containerClass="h-[calc(100%-80px)] bg-gray-400/20 shadow rounded-md items-center px-10"
      />
    </main>
  );
};

export default ProfilePage;
