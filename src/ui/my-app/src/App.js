import * as React from 'react';
import './App.css';
import {
  ChakraProvider,
  Box,
  VStack,
  theme,
} from '@chakra-ui/react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import Main from './mainForm/main'
import Dashboard from './Dashboard';
import Header from './Header';
import DeleteRows from './delete/DeleteRows';
import Transaction from './transaction/Transaction';


function App() {
  return (
    <ChakraProvider theme = {theme}>
      <Router>
      <Header/>
        <Box fontSize='xl'>
          <VStack spacing={8}>
            <Routes>
              <Route path="/" element={<Dashboard />}/>
              <Route path="/main" element={<Main />}/>
              <Route path="/delete" element={<DeleteRows />}/>
              <Route path="/transaction" element={<Transaction />}/>
            </Routes>
          </VStack>
        </Box>
      </Router>
    </ChakraProvider>
  );
}

export default App;
