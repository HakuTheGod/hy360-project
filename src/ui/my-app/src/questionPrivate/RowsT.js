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



const RowsT = (info) =>{
    
    

    return(
        <Tr 
            h='65px'
        >
            <Td> { info.info.t_date }</Td>
            <Td> { info.info.seller_name }</Td>
            <Td> { info.info.customer_name }</Td>
            <Td> { info.info.t_id }</Td>
            <Td> { info.info.amount }</Td>
            <Td> { info.info.t_type }</Td>
        </Tr>


    )
}


export default RowsT;