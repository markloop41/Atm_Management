package com.atm.atm_management;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ATM {

    // defining field
    private double balance;
    private double depositAmount;
    private double withdrawAmount;
}
