import backdrop from "../../assets/images/close-up-hand-holding-plane-tickets.jpg";
import NavBar from "../../components/navbar/NavBar";
const HomePage = () => {
  return (
    <div className="h-[605px] overflow-hidden relative">
      <NavBar />
      <img src={backdrop} alt="backdrop" className="absolute z-[-15] inset-0" />
      <div className="absolute inset-0 z-[-10] bg-slate-500/0"></div>
    </div>
  );
};

export default HomePage;
