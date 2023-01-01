import React from "react";
import ReactDOM from "react-dom";
import { useRoutes, Navigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import Basket from './pages/Basket/Basket';
import ContextFilter from './components/Context/ContextFilter';
import ContextProvider from './components/Context/ContextProvider';
import Details from './pages/Details/Details';
import FavoritePage from './components/Favorite/FavoritePage';
import Header from './layout/Header/Header';
import Products from './pages/Products/Products';

import Bakery from './components/bakery-inventory';
import Order from './components/add-order';
import CompleteOrder from './pages/Basket/Orderpage';
function App() {
  let router = useRoutes([
    { path: '/', element: <Products /> },
    { path: '/:id', element: <Details /> },
    { path: '/favorite', element: <FavoritePage /> },
    { path: '/basket', element: <Basket /> },
    { path: '*', element: <Navigate to={'/'} /> },
    { path: '/bakery', element: <Bakery /> },
    { path: '/addorder', element: <Order /> },
    { path: '/completeorder', element: <CompleteOrder /> },
  ])
  return (
      <ContextProvider>
        <ContextFilter>
          <Header />
          {router}
        </ContextFilter>
      </ContextProvider>
  );
}

export default App;

if(document.getElementById('app')){

  ReactDOM.render(<App/>,document.getElementById('app'));

}