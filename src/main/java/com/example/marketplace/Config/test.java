package com.example.marketplace.Config;

public class test {
    public static void main(String[] args) {
        int a = 10;
        int b = 6;
        int c = a / b; // результат будет равен 3
        double percentage = ((double) b / a) * 100;
        int roundedPercentage = (int) Math.round(percentage);

        System.out.println("Процент: " + roundedPercentage + "%");
    }
}
// 15 - 100%
// 6 - x%