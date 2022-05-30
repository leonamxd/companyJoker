import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import ClientePage from "./Pages/Clientes/ClientePage";
import FornecedorPage from "./Pages/Fornecedor/FornecedorPage";
import ProdutoPage from "./Pages/Produto/ProdutoPage";

function Rotas(){
    return(
        <Routes>
            <Route path="/produtos" element={<ProdutoPage/>}/>
            <Route path="/clientes" element={<ClientePage/>}/>
            <Route path="/fornecedores" element={<FornecedorPage/>}/>
        </Routes>
    );
}

export default Rotas;