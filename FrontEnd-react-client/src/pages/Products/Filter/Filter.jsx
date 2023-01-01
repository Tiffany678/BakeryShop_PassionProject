import React, { useContext } from "react";
import { FilterDispath } from "../../../components/Context/ContextFilter";
import "./Filter.css";

export default function Filter() {
  const { dispath } = useContext(FilterDispath);
  return (
    <div className="filter_container">
      <div className="filter_btnBox">
        <button onClick={() => dispath({ type: "Cake" })} className="filter_btn">
          ALL
        </button>
        <button
          onClick={() => dispath({ type: "Chocolate Cake" })}
          className="filter_btn"
        >
          CHOCOLATE
        </button>
        <button
          onClick={() => dispath({ type: "Cheese Cake" })}
          className="filter_btn"
        >
          CHEESE
        </button>
        <button
          onClick={() => dispath({ type: "Green Tea Cake" })}
          className="filter_btn"
        >
          GREENTEA
        </button>
        <button
          onClick={() => dispath({ type: "Strawberry Cake" })}
          className="filter_btn"
        >
          STRAWBERRY
        </button>
      </div>
    </div>
  );
}
