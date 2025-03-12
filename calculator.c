#include <stdio.h>
double result;

double add(double a, double b){
    result = a + b;

    return result;
}

double subtract(double a, double b){
    result = a - b;

    return result;
}

double multiply(double a, double b){
    result = a * b;

    return result;
}

double divide( double a, double b){
    result = a / b;

    return result;
}

int main(){
    double no_1;
    double no_2;
    char operator;

    printf("Enter first number to calculate\n");
    scanf("%lf", &no_1);

    //operators
    printf("Operators to use +,*, -, /  \n");
    printf("Input an operator of your choice\n");
    getchar();
    scanf("%c", &operator);

    printf("Enter second number to calculate\n");
    getchar();
    scanf("%lf", &no_2);

    switch (operator)
    {
    case '+':
        add(no_1, no_2);
        printf("The answer is %.2lf \n", result);
        break;

    case '-':
    subtract(no_1, no_2);
    printf("The answer is %.2lf \n", result);

    case '*':
    multiply(no_1, no_2);
    printf("The answer is %.2lf \n", result);

    case '/':
    divide(no_1, no_2);
    printf("The answer is %.2lf\n", result);

    default:
        break;
    }
}