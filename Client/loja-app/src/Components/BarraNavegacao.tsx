import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';

const pages: string[] = ['produtos', 'fornecedores', 'clientes'];

const BarraNavegacao = () => {


  const navigate = useNavigate();
  const handleClick = (page: string) => {
    if(page){
      return navigate(`/${page}`);
    }
  };

  return (
    <AppBar position="static" style={{ background: '#2E3B55' }}>
      <Container>
        <Toolbar disableGutters style={{ display: 'flex' }}>  

          <Box>
            {pages.map((page) => (
              <Button
                key={page}
                onClick={() => handleClick(page)}
                style={{ color: 'white' }}
              >
                {page}
              </Button>
            ))}
          </Box>

        </Toolbar>
      </Container>
    </AppBar>
  );
};
export default BarraNavegacao;