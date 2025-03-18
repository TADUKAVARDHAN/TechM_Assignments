package com.example.bean.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bean.Cake;

@Service
public class CakeService {
    private static final Map<Integer, Cake> orderList = new HashMap<>();
    private static final Map<String, Integer> flavorList = new LinkedHashMap<>();
    private static int orderId = 1000;
    public CakeService() {
        flavorList.put("None($0)", 0);
        flavorList.put("Custard($5)", 5);
        flavorList.put("Raspberry($10)", 10);
        flavorList.put("Pineapple($5)", 5);
        flavorList.put("Cherry($6)", 6);
        flavorList.put("Apricot($8)", 8);
        flavorList.put("Buttercream($7)", 7);
        flavorList.put("Chocolate($10)", 10);
    }
    public static Integer addOrder(Cake cake) {
        orderList.put(++orderId, cake);
        return orderId;
    }
    public static Map<String, Integer> getFlavorList() {
        return flavorList;
    }
}
