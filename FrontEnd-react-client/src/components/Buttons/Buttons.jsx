import React, { useContext, useState, useEffect } from "react";
import { AiOutlinePlus, AiOutlineMinus } from "react-icons/ai";
import { RiDeleteBinLine } from "react-icons/ri";
import { ProductContext, ProductDispath } from "../Context/ContextProvider";
import "./Buttons.css";


import BakeryDataService from "../../services/bakery.service";

export default function Buttons(props) {
  const { dispath } = useContext(ProductDispath);
  const { state } = useContext(ProductContext);
  const { id } = props;
  const countItem = state.basket.find((product) => product.id === id);
  const itemTotal = state.allProducts.find((product) => product.id === id);

  // const [loading, setLoading] = useState(true)
  // let itemCount=0;
  //
  // useEffect(() => {
  //   itemCount=getItemCount();
  // }, [])
  // async function getItemCount(){
  //   const request = await fetch(`http://localhost:8080/api/cakes/${id}`, {
  //   }).then((request => request.json()))
  //       .catch(err=>console.log(err))
  //   itemCount=request;
  //   setLoading(false);
  //   return request;
  // }

 // async function componentDidMount() {
 //  await loadData();
//  }
//  async function loadData() {
//     const request = fetch(`http://localhost:8080/api/cakes/${id}`, {
//     }).then((request => request.json()))
//         .catch(err=>console.log(err))
//     itemCount=request;
//     window.alert(itemCount);
//  }

  //let itemCount = BakeryDataService.get(id);
  //setTimeout(itemCount = BakeryDataService.get(id), 1000)
  //setTimeout(window.alert(itemCount),50000);
  //window.alert(id+" "+itemCount);
  // window.alert(itemCount);
  //debugger;

  //   return (
  //       <div className="full tr">
  //         <button className="product--cart-button">Add to Cart</button>
  //       </div>
  //   );
  // };

 //  if (loading){
 //    return (<div>loading...</div>);
 // }
  // else {
    // window.alert(itemCount);
    return (
        <div className="basket_buttons">
          {/*{countItem.count < itemTotal.limit ? (*/}
            {countItem.count < 5 ? (
              <span
                  onClick={() => dispath({type: "INCREASE", payload: id})}
                  className="basket_plus"
              >
          <AiOutlinePlus/>
        </span>
          ) : null
          }

          <span className="counter_number">{props.count}</span>
          {countItem.count === 1 ? (
              <span
                  onClick={() => dispath({type: "REMOVE_FROM_BASKET", payload: id})}
                  className="basket_minus"
              >
          <RiDeleteBinLine/>
        </span>
          ) : (
              <span
                  onClick={() => dispath({type: "DECREASE", payload: id})}
                  className="basket_minus"
              >
          <AiOutlineMinus/>
        </span>
          )}
        </div>
    );
    //);
  // }
}
