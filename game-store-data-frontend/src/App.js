
import './App.css';
import React, { useState } from "react";
import Games from "./Games.js"
import Consoles from "./Consoles.js"
import Tshirts from "./Tshirts.js"
import Header from "./Header"

function App() {
  const [currentPage, setCurrentPage] = useState("Consoles");

  // TODO: its rendering the pages
  const renderPage = () => {
    if (currentPage === "Games") {
      console.log(Games, "games")
      return <Games />;
    }
    if (currentPage === "Consoles") {
      console.log(Consoles, "consoles")
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
    alert("changing page", page)
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
