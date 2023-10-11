import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
import ProfileCard from "../../../components/profileCard/ProfileCard";
const AdminProfilePage = () => {
  return (
    <main>
      <DashboardHeader
        sectionClass="flex justify-between p-4"
        title="Admin Profile"
      />
      <ProfileCard />
    </main>
  );
};

export default AdminProfilePage;
