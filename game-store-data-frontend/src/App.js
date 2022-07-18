
import './App.css';
import React, { useState } from "react";
import Games from "./Games.js"
import Consoles from "./Consoles.js"
import Tshirts from "./Tshirts.js"
import Header from "./Header"

function App() {
  const [currentPage, setCurrentPage] = useState("Header");

  // TODO: its rendering the pages
  const renderPage = () => {
    if (currentPage === "Games") {
      return <Games />;
    }
    if (currentPage === "Consoles") {
      return <Consoles />;
    }
    if (currentPage === "Tshirts") {
 
      alert("Tshirt")
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
