
import Games from "./Games";
import Consoles from "./Consoles";
import Tshirts from"./Tshirts"
import Header from "./Header"
import { useState } from 'react';



function App() {
  const [currentPage, setCurrentPage] = useState("Games");

  // TODO: its rendering the pages
  const renderPage = () => {
    if (currentPage === "Games") {
      return <Games />;
    }
    if (currentPage === "Consoles") {
      return <Consoles />;
    }
    if (currentPage === "Tshirts") {
 
      return <Tshirts />;
    }

    return Header
 
  };

  const handlePageChange = (e, page) => {
    e.preventDefault();
    setCurrentPage(page);
  }

  return (
    <>
    <Header currentPage={currentPage} handlePageChange={handlePageChange} />
    {renderPage()}
 
  </>
  );
}

export default App;
