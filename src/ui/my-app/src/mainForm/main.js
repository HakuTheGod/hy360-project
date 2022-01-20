import React, { useState } from 'react';
import "./main.css";
import { 
    Stack, 
    Button, 
    FormControl, 
    FormLabel, 
    FormHelperText,
    Input, 
    FormErrorMessage,
    InputGroup,
    InputRightElement,
    Radio,
    HStack,
    RadioGroup,
    Select,
    Grid,
    NumberInput,
    NumberInputField,
    Checkbox,
    Textarea,
    Text
} from '@chakra-ui/react'


const Main = () => {

    const [values, setValues] = useState({
        user_id: 0,
        username: '',
        Credit_line: 0.0,
        Debt: 0.0,
        Credit_balance: 0.0
    })


    return(
        <div>The Form Will GO HERE</div>
    )




};
export default Main;