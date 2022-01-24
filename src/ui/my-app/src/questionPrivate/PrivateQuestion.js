import React, { useState } from 'react';
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
    Table,
    Thead,
    Tbody,
    Tr,
    Th,
    Td,
    Skeleton,
    Text
} from '@chakra-ui/react'
import $ from 'jquery';
import RowsT from './RowsT';
import dayjs from 'dayjs';


const PrivateQuestion = () => {


    const [show, toggleShow] = React.useState(true);

    const [responseMessage, setResponseMessage] = useState('');
    const [color, setColor] = useState('');
    const [transactions, setTransactions] = useState([]);
    const [dates, setDates] = useState({
        date1: '',
        date2: ''
    })

    const [values, setValues] = useState({
        p_account_name: '',
        seller_name: '',
        product: '',
        quantity: 0,
        total_price: 0.0
    })

 
    let type = 'Private';
    const [final, setFinal] = useState('Private');

    const handleState = e => {
        console.log(e.target.value);
        const {name, value} = e.target;
        setDates({
            ...dates,
            [name]: dayjs(value).format('YYYY/MM/DD')
        });
        console.log(type);
    }

    const handleChange = e => {
        const {name, value} = e.target;
        console.log(e.target.value);
        setValues({
            ...values,
            [name]: value
        });
        console.log(values);
    }
    

    const handleSubmit = e => {
        e.preventDefault();

        var urlEnd;
        var json_vals;

            console.log(final);
             json_vals = JSON.stringify(dates);
            console.log("JSON  " + json_vals);
            urlEnd = 'http://localhost:8080/WebApp/DateQuestion';

            $.ajax({
                url: urlEnd,
                type: "POST",
                contentType: "application/json",
                data: json_vals,
                success: function (result) {
                    toggleShow(false);
                    console.log("SUCCESS");
                    setTransactions(result);
                    setColor('green');
                  },
                  error: function (result) {
                    console.log("FAIL");
                    var response = JSON.parse(result.responseText);
                    setResponseMessage(response.fail);
                    setColor('red');
                  }
        
            })

        
    }


    return(
        <>
        {show && <div>
        <form method='POST' onSubmit={handleSubmit} noValidate>
            <Stack maxWidth={1000} margin='auto' spacing={7} margin-top={5}>
                <Text fontSize='5xl' >Transaction</Text>
                <FormControl isRequired id='date1'>
                <FormLabel>Date1</FormLabel>
                            <Input
                                type='date'
                                name='date1'
                                autoComplete='on'
                                onChange={handleState}
                                placeholder='1999/27/01'
                            >
                        </Input>
                </FormControl>

                <FormControl isRequired id='date2'>
                <FormLabel>Date2</FormLabel>
                            <Input
                                type='date'
                                name='date2'
                                autoComplete='on'
                                onChange={handleState}
                                placeholder='1999/27/01'
                            >
                        </Input>
                </FormControl>

                <Button
                    mt={2}
                    type="submit"
                 >
                Submit
                </Button>
            </Stack>
        </form>
        </div>
        }
        {
            !show && <Table variant='striped' colorScheme='grey'>
            <Thead>
            <Tr>
            <Th>t_date</Th>
            <Th>seller_name</Th>
            <Th>customer_name</Th>
            <Th>t_id</Th>
            <Th>amount</Th>
            <Th>t_type</Th>
            </Tr>
        </Thead>
        <Tbody>
            {transactions.map(transaction => <RowsT info={transaction} key={transaction.t_date} />)}
        </Tbody>
        </Table>
    }
    </>
    )

}

export default PrivateQuestion;