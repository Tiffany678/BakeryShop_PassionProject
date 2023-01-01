import React, { useContext } from "react";
import { sendPrice } from "../../data/Offer";
import { ProductContext } from "../../components/Context/ContextProvider";

export default function SendProducts() {
  const { state } = useContext(ProductContext);

  return (
    <div className="send_products">
      <div className="send_info_price">
        <span>Shipping Cost</span>
        <span>
        { state.totalPrice - state.offerPrice <= 100
            ? `$${sendPrice.toLocaleString()}`
          : "free"}
        </span>
      </div>
      {state.totalPrice - state.offerPrice > 100 && (
        <div className="send_free_img">
          <img src="images/free.svg" alt="free" />
        </div>
      )}
    </div>
  );
}
