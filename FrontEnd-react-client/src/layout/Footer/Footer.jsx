import React from "react";
import { Link } from "react-router-dom";
import "./Footer.css";
import { FaArrowUp } from "react-icons/fa";

export default function Footer() {
  const handelToTop = () => {
    window.scrollTo(0, 0);
  };
  return (
    <footer className="footer">

      <div className="footer_first">
        <div className="footer_btn_title_box">
       <p> Author: Yingjie Yang</p>
         <a href="mailto:52Tiffany.yang@gmail.com">52Tiffany.yang@gmail.com</a>
        </div>
      </div>
      <div className="footer_last">
        <div className="footer_link_box">
        </div>
      </div>
    </footer>
  );
}
