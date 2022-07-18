import React from "react";
import Navigation from "./Navigation";

// TODO: Modify this function so that it accepts props from the parent component
export default function Header({ currentPage, handlePageChange }) {
  console.log("navigation")
  return (
    <header className="">
      <h1 className="text-center">Game Store App</h1>
      <Navigation
        currentPage={currentPage}
        handlePageChange={handlePageChange}
      />
    </header>
  );
}