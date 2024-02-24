package com.atm.atm_management;

import java.util.HashMap;
import java.util.Map;

public class AtmoperationImpl implements AtmoperationInterf {
    ATM atm = new ATM();
    Map<Double,String> mini_stat = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%500==0) {
            if(withdrawAmount<=atm.getBalance()) {
                mini_stat.put(withdrawAmount," Amount withdrawn");
                System.out.println(withdrawAmount+" Collect the cash !!!!!");
                atm.setBalance(atm.getBalance()-withdrawAmount);
                viewBalance();
            }
            else{
                System.out.println("Insufficient balance.......");
            }
        }
        else {
            System.out.println("Please Enter the Amount in multiple of 500S");
        }
    }
    @Override
    public void depositAmount(double depositAmount) {
        mini_stat.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        if(atm.getBalance()!=0) {
            for (Map.Entry<Double, String> m : mini_stat.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }
        } else{
            System.out.println("No Transactions to show....");
        }
    }
}
