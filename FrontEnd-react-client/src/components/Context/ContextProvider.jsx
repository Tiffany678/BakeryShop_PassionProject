import React, { createContext, useReducer } from "react";
import allProducts from "../../data/Data";
import offerCode from "../../data/Offer";
import { sendPrice } from "../../data/Offer";
import BakeryDataService from "../../services/bakery.service";


const initialState = {
  allProducts,
  favorites: [],
  basket: [],
  totalPrice: 0,
  totalPriceAfterOffer: 0,
  offerPrice: 0,
  totalPriceFainal: 0,
  isFavorite: false,
  isEnterOfferCode: false,
  offerMessage: "",
  isPurchase: false,
  ThankYouMessage: "Thank you for your order!",
  count:0,
  limit:100
};

  const sumPriceWithSend = (totalPrice, offerPrice=0) => {
  let totalPriceFainal = null;
  if (totalPrice - offerPrice >= 100) {
    totalPriceFainal = totalPrice  - offerPrice;
  } else {
    totalPriceFainal = totalPrice - offerPrice + sendPrice;
  }
  return { totalPriceFainal };
};

const sumPrice = (items, isOffer) => {
  const totalPrice = items.reduce((totalPrice, product) => {
    return totalPrice + product.price * product.count;
  }, 0);

  if (isOffer) {
    const offerPrice = (totalPrice * offerCode.disCount) / 100;
    const totalPriceAfterOffer = totalPrice - offerPrice;

    return {
      totalPrice,
      offerPrice,
      totalPriceAfterOffer,
      ...sumPriceWithSend(totalPrice, offerPrice)
    };
  } else {
    return { totalPrice, ...sumPriceWithSend(totalPrice) };
  }
};



const reduce = (state, action) => {
  switch (action.type) {
    case "ADD_FAVORITE": {
      state.allProducts.forEach((product) => {
        if (product.id === action.payload) {
          product.isInterest = !product.isInterest;
          state.favorites = allProducts.filter((product) => product.isInterest);
          state.isFavorite = true;
        }
      });
      return {
        ...state
      };
    }
    case "REMOVE_ALL_FAVORITE": {
      state.favorites = [];
      state.allProducts.forEach((product) => {
        product.isInterest = false;
      });

      return {
        ...state
      };
    }
    case "ADD_TO_BASKET": {
      const hasProduct = state.basket.some(
        (product) => product.id === action.payload
      );
      if (!hasProduct) {
        const mainItem = state.allProducts.find(
          (product) => product.id === action.payload
        );
        state.basket.push(mainItem);
      }

      return {
        ...state,
        ...sumPrice(state.basket, state.isEnterOfferCode)
      };
    }
    case "REMOVE_FROM_BASKET": {
      const indexDelete = state.basket.findIndex(
        (product) => product.id === action.payload
      );
      state.basket[indexDelete].count = 1;
      state.basket = state.basket.filter(
        (product) => product.id !== action.payload
      );

      return {
        ...state,
        ...sumPrice(state.basket, state.isEnterOfferCode)
      };
    }
    case "INCREASE": {
      const indexPlus = state.basket.findIndex(
        (product) => product.id === action.payload
      );
      state.basket[indexPlus].count++;

      return {
        ...state,
        ...sumPrice(state.basket, state.isEnterOfferCode)
      };
    }
    case "DECREASE": {
      const indexMinus = state.basket.findIndex(
        (product) => product.id === action.payload
      );
      if (state.basket[indexMinus].count > 1) {
        state.basket[indexMinus].count--;
      }

      return {
        ...state,
        ...sumPrice(state.basket, state.isEnterOfferCode)
      };
    }
    case "EMPTY_BASKET": {
      state.basket = state.basket.forEach((product) => (product.count = 1));
      state.basket = [];
      state.isPurchase=false;
      return {
        ...state,
        ...sumPrice(state.basket, state.isEnterOfferCode)
      };
    }
    case "PURCHASE": {
      state.isPurchase=true;
      BakeryDataService.create(state.json);
      return {
        ...state,
        ...sumPrice(state.basket, state.isEnterOfferCode)
      };
    }
    case "REMOVE_CLASS": {
      state.isFavorite = false;
      return {
        ...state
      };
    }
    case "OFFER_CODE": {
      if (offerCode.code === action.payload) {
        state.isEnterOfferCode = true;
        state.offerMessage ="Coupon Code Has Been Applied" ;
      } else {
        state.offerMessage = "The Code Entered is not Correct";
      }
      return {
        ...state,
        ...sumPrice(state.basket, state.isEnterOfferCode)
      };
    }
    default:
      return state;
  }
};

export const ProductContext = createContext();
export const ProductDispath = createContext();

export default function ContextProvider({ children }) {
  const [state, dispath] = useReducer(reduce, initialState);

  let basketitems="";
  state.basket.forEach((product) => (basketitems += product.title+":"+product.count+","));
  state.json = {
    description: basketitems,
    shipping:state.totalPriceFainal-state.totalPrice,
    //shipping: { sendPrice },
    subtotal:state.totalPrice,
    total:state.totalPriceFainal
  };

  return (
    <ProductContext.Provider value={{ state }}>
      <ProductDispath.Provider value={{ dispath }}>
        {children}
      </ProductDispath.Provider>
    </ProductContext.Provider>
  );
}
