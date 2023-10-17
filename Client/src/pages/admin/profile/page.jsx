import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
import ProfileCard from "../../../components/profileCard/ProfileCard";
const AdminProfilePage = () => {
  return (
    <main>
      <DashboardHeader
        sectionClass="flex justify-between p-4"
        title="Admin Profile"
      />
      <ProfileCard
        sectionClass="p-5 h-[calc(100vh-170px)]"
        containerClass="h-[calc(100%-80px)] bg-gray-400/20 shadow rounded-md items-center px-10"
      />
    </main>
  );
};

export default AdminProfilePage;
