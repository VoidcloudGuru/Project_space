#include <stdio.h>
#include <stdlib.h>

struct Accountdetails
{
    char customername[50];
    int accountnumber;
    double account_balance;
    double amount_deposited;
    double amount_withdrawn;
};

int main()
{

    struct Accountdetails customer;
    int userinput;
    double after_deposit;
    double after_withdraw;

    customer.account_balance = 500000.0;

    printf("Enter name of the customer\n");
    fgets(customer.customername, sizeof(customer.customername), stdin);

    printf("Enter customer account number\n");
    scanf("%d", &customer.accountnumber);
    printf("\n");

    printf("Welcome %s", customer.customername);
    printf("\nAccount number:%d  \n", customer.accountnumber);

    printf("Choose any of the options below that fit your preference\n");
    printf("\n");

    // list all the options
    printf("1. If you would like to deposit on your account, choose option 1\n"
           "2. If you would like to withdraw money from your account , choose option 2\n"
           "3. If you would like to check for your account balance, choose option 3\n");


    scanf("%d", &userinput);

    switch (userinput)
    {
    case 1:
        printf("Please enter the amount you want to deposit \n");
        scanf("%lf", &customer.amount_deposited);

        printf("%.2lf , has been deposited on your account\n", customer.amount_deposited);
        after_deposit = customer.amount_deposited + customer.account_balance;

        customer.account_balance = after_deposit;
        printf("Your account balance is now %.2lf\n", customer.account_balance);

        break;
    case 2:
        printf("Please enter the amount you want to withdraw\n");
        scanf("%lf", &customer.amount_withdrawn);
        printf("%.2lf has been withdrawn from your account\n", customer.amount_withdrawn);

        if (customer.amount_withdrawn <= customer.account_balance)
        {
            after_withdraw = customer.account_balance - customer.amount_withdrawn;

            customer.account_balance = after_withdraw;
            printf("Your account balance is now %.2lf \n", customer.account_balance);
        }
        else
        {
            printf("Insufficient funds on your account. Please deposit money and try again\n");
        }
        break;

    case 3:
        printf("Your account balance is %.2lf \n", customer.account_balance);

        break;

    default:

        printf("Invalid options input. Please use options given in the list above\n");

        break;
    }

    return 0;
}
