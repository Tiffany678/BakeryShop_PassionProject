import React, { useContext } from "react";
import { sendPrice } from "../../data/Offer";
import { ProductContext } from "../../components/Context/ContextProvider";

export default function CompleteOrder() {
  const { state } = useContext(ProductContext);

  return (
    <div className="send_products">
      <div className="send_info_price">
          <span></span>
        <span>Thank You</span>
        <span>
        Your order has been successfully submitted!
            <h4>HELLO</h4>
        </span>
      </div>
    </div>
  );
}
