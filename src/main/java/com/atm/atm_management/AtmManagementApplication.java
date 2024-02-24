package com.atm.atm_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AtmManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmManagementApplication.class, args);

		AtmoperationInterf op = new AtmoperationImpl();

		final int atm_number = 7355;
		final int atm_pin = 738046;
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to Atm Machine!!! ");
		System.out.println("Enter Atm Number : ");
		int atm_Number = scn.nextInt();
		System.out.println("Enter Atm Pin : ");
		int atm_Pin = scn.nextInt();

		if((atm_number==atm_Number)&&(atm_pin==atm_Pin)) {
			System.out.println("Validation Done");

			while(true) {
				System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
				System.out.println("Enter Choice : ");
				int ch = scn.nextInt();
				if(ch == 1) {
					op.viewBalance();
				}
				else if(ch == 2) {
					System.out.println("Enter Amount to Withdraw : ");
					double withdrawAmount = scn.nextDouble();
					op.withdrawAmount(withdrawAmount);
				}
				else if(ch == 3) {
					System.out.println("Enter Amount to Deposit : ");
					double depositAmount = scn.nextDouble();
					op.depositAmount(depositAmount);
				}
				else if (ch == 4) {
					op.viewMiniStatement();
				}
				else if (ch == 5) {
					System.out.println("Collect your card..... Thank you for using ATM Machine");
					System.exit(0);
				}
				else {
					System.out.println("Please Enter Correct Choice");
				}
			}
		}
		else {
			System.out.println("Incorrect Number or ATM Pin");
		}
	}
}
