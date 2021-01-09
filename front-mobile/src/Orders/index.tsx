import React, { useEffect, useState } from 'react';
import { StyleSheet, ScrollView, Alert, Text } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { useIsFocused, useNavigation } from '@react-navigation/native';

import Header from '../Header';
import OrderCard from '../OrderCard';
import { fetchOrders } from '../api';
import { Order } from '../types';

export default function Orders() {
  const [orders, setOrders] = useState<Order[]>([])
  const [isLoading, setIsLoading] = useState(false)
  const navigation = useNavigation()
  const isFocused = useIsFocused()

  const fetchData = () => {
    setIsLoading(true)
    fetchOrders()
      .then(response => setOrders(response.data))
      .catch(() => Alert.alert('Houve um erro ao buscar os pedidos!'))
      .finally(() => setIsLoading(false))
  }

  useEffect(() => {
    if (isFocused) {
      fetchData()
    }
  }, [isFocused]) // Toda vez que o valor do isFocused mudar o useEffect irá rodar o código novamente

  const handleOnPress = (order: Order) => {
    navigation.navigate('OrderDetails', { // Navega para o OrderDetails passando o pedido(Order) como parâmetro
      order
    })
  }

  return (
    <>
      <Header />
      <ScrollView style={ styles.container }>
        {isLoading ? (
          <Text>Buscando pedidos...</Text>
        ) : (
          orders.map(order => (
            <TouchableWithoutFeedback
              key={ order.id }
              onPress={ () => handleOnPress(order) }
            >
              <OrderCard order={ order } />
            </TouchableWithoutFeedback>
          ))
        )}
      </ScrollView>
    </>
  );
}

const styles = StyleSheet.create({
  container: {
    paddingLeft: '5%',
    paddingRight: '5%'
  }
});