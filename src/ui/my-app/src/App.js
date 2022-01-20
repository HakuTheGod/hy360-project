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


function App() {
  return (
    <ChakraProvider theme = {theme}>
      <Router>
        <Box textAllign='center' fontSize='xl'>
          <VStack spacing={8}>
            <Routes>
              <Route path="/" element={<Main />}/>
            </Routes>
          </VStack>
        </Box>
      </Router>
    </ChakraProvider>
  );
}

export default App;
