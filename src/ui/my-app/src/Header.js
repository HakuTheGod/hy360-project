import { useState, useEffect } from 'react';
import { 
    Grid, 
    GridItem, 
    Button,
    Menu,
  MenuButton,
  MenuList,
  MenuItem,
  MenuDivider,
  Box,
  Avatar,
  IconButton
    
} from '@chakra-ui/react'
import { TiThMenu } from "react-icons/ti";
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import './header.css';


const Header = () => {

    

    return (

      <Box className='Hfilter'  p={2} borderBottomWidth='1px'  sx={{ position: '-webkit-sticky', /* Safari */ position: 'sticky', top: '0',}}>
        <Grid templateColumns='repeat(12, 1fr)'  align='center' h='30px'>
            <GridItem colSpan={1} h='7' justifySelf="flex-start" />
            
            


            <GridItem colSpan={1} h='7' justifySelf="flex-start" />
 

            
            <GridItem colSpan={10} h='7'  justifySelf="flex-end" >
                

            <Menu closeOnSelect={true} direction= "rtl">
              <MenuButton h='50px' w='70px' top='-3' left='2'  as={IconButton} style={{display: 'flex', alignItems: 'left'}} icon={< TiThMenu color="white" w='30px'/>}>
              </MenuButton>
              <MenuList minWidth='240px'>
              <Link to="/main"><MenuItem>Register new account</MenuItem></Link>
              <Link to="/delete"><MenuItem>Terminate Account</MenuItem></Link>
              <Link to="/transaction"><MenuItem>Make a Transaction</MenuItem></Link>
              <Link to="/pay"><MenuItem>Pay your debt</MenuItem></Link>
              <MenuDivider />
                
              </MenuList>
            </Menu>
            
            </GridItem>


        </Grid>
        </Box>
    );
}

export default Header;