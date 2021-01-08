import { useEffect, useState } from 'react'

import StepsHeader from './StepsHeader'
import ProductsList from './ProductsList'
import { fetchProducts } from '../api'
import OrderLocation from './OrderLocation'
import { OrderLocationdata, Product } from './types'

import './styles.css'

function Orders() {
    const [products, setProducts] = useState<Product[]>([]) // Estado que vai armazenar a lista de produtos
    const [orderLocation, setOrderLocation] = useState<OrderLocationdata>()

    useEffect(() => {
        fetchProducts()
            .then(response => setProducts(response.data)) // .data vai retornar a lista de produtos
            .catch(error => console.log(error))
    }, [])

    return (
        <div className="orders-container">
            <StepsHeader />
            <ProductsList products={ products } />
            <OrderLocation onChangeLocation={ location => setOrderLocation(location) } />
        </div>
    )
}

export default Orders