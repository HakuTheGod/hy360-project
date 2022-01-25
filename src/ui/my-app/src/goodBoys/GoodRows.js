import {
    Tr,
    Td,
    IconButton,
    useColorModeValue
} from '@chakra-ui/react'
import { useState } from 'react';
import React from 'react';
import $ from 'jquery';
import { TiDelete } from "react-icons/ti";



const GoodRows = (info) =>{
    
    

    return(
        <Tr 
            h='65px'
        >
            <Td> { info.info.user_id }</Td>
            <Td> { info.info.user_name}</Td>
        </Tr>


    )
}


export default GoodRows;