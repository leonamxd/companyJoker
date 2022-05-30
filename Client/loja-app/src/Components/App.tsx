import { BrowserRouter } from 'react-router-dom';
import Rotas from '../Routes';
import BarraNavegacao from './BarraNavegacao';

function App() {
  return (
    <BrowserRouter>
      <BarraNavegacao/>
      <Rotas/>
    </BrowserRouter>
  );
}

export default App;
