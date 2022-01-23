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

            </Routes>
          </VStack>
        </Box>
      </Router>
    </ChakraProvider>
  );
}

export default App;
