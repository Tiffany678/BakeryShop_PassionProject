import React, {useContext} from "react";
import "./Basket.css";
import {Link} from "react-router-dom";
import { HiArrowRight } from "react-icons/hi";
import { ProductContext, ProductDispath } from "../../components/Context/ContextProvider";
import BasketItem from "./BasketItem";
import Offer from "./Offer";
import OfferBadge from "./OfferBadge";
import SendProducts from "./SendProducts";
import { sendPrice } from "../../data/Offer";


export default function Basket() {
  const { state } = useContext(ProductContext);
  const { dispath } = useContext(ProductDispath);

  return (
    <>
      <div className="favorite_container_linkBar">
        <div className="favorite_linkBar">
          <span>Shopping Cart</span>
          <Link className="favorite_backLink" to={"/"}>
            <HiArrowRight />
            Products Page
          </Link>
        </div>
        {state.basket.length > 0 && (
          <div className="favorite_linkBar">
            <div className="free_send_title">
              <img src="images/sound(1).jpg" alt="" />
              <span>
                Free Shipping for over $100 purchases.
              </span>
            </div>
          </div>
        )}
      </div>
      {state.basket.length > 0 ? (
        <div className="basket_container">
          <div className="basket_itemBox">
            {state.basket.map((product) => (
              <BasketItem key={product.id} {...product} />
            ))}
          </div>
          <div className="basket_priceBox">
            <OfferBadge />
            <div className="basket_price">

              <span>Subtotal</span>
              <span>${state.totalPrice.toLocaleString()}</span>
            </div>
            {state.totalPriceAfterOffer > 0 && (
              <div className="basket_offer">
                <span>Price After Discount</span>
                <span>${state.totalPriceAfterOffer.toLocaleString()}</span>
              </div>
            )}
            <Offer />
            <SendProducts />
            <div className="basket_send">
              <span>Total Price</span>
              <span>${state.totalPriceFainal.toLocaleString()}</span>


            </div>
            <button className="basket_button_buy"
                    onClick={
                    () => dispath({ type: "PURCHASE" })}
            >Continue to Check-out</button>
            {state.isPurchase && (
                <span className="thankyou_true">{state.ThankYouMessage}</span>
            )}

            <button
              onClick={() => dispath({ type: "EMPTY_BASKET" })}
              className="basket_button_remove"
            >
              Empty Shopping Cart
            </button>
          </div>
        </div>
      ) : (
        <div className="favorite_empty">
          <img
            className="favorite_empty_img"
            src="images/empty-cart.png"
            alt=""
          />
          <span className="favorite_empty_title">The Cart is Empty</span>
        </div>
      )}
    </>
  );
}

