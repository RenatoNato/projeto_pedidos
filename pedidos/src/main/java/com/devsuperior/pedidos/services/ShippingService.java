package com.devsuperior.pedidos.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    //Calcula custo de envio
    public double calculateShippingCost(double orderValue){
        if(orderValue < 100.00){
            return 20.00;
        }else if (orderValue >= 100.00 && orderValue < 200.00){
            return 12.00;
        }else{
            return 0.00; //Frete grátis.
        }

    }

}
