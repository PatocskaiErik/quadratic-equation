package com.epam.rd.autotasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        BigDecimal a = scanner.nextBigDecimal();
        BigDecimal b = scanner.nextBigDecimal();
        BigDecimal c = scanner.nextBigDecimal();

        BigDecimal four = BigDecimal.valueOf(4);
        BigDecimal two = BigDecimal.valueOf(2);
        BigDecimal zero = BigDecimal.ZERO;

        BigDecimal discriminant = b.pow(2).subtract(four.multiply(a).multiply(c));

        if (discriminant.compareTo(zero) > 0) {
            BigDecimal sqrtDiscriminant = sqrt(discriminant);
            BigDecimal root1 = b.negate().add(sqrtDiscriminant).divide(two.multiply(a), 10, RoundingMode.HALF_UP);
            BigDecimal root2 = b.negate().subtract(sqrtDiscriminant).divide(two.multiply(a), 10, RoundingMode.HALF_UP);

            if (root1.compareTo(root2) < 0) {
                System.out.println(root1.stripTrailingZeros() + " " + root2.stripTrailingZeros());
            } else {
                System.out.println(root2.stripTrailingZeros() + " " + root1.stripTrailingZeros());
            }
        } else if (discriminant.compareTo(zero) == 0) {
            BigDecimal root = b.negate().divide(two.multiply(a), 10, RoundingMode.HALF_UP);
            System.out.println(root.stripTrailingZeros());
        } else {
            System.out.println("no roots");
        }
    }

    private static BigDecimal sqrt(BigDecimal value) {
        BigDecimal two = BigDecimal.valueOf(2);
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal x1 = value.divide(two, 10, RoundingMode.HALF_UP);
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = value.divide(x0, 10, RoundingMode.HALF_UP);
            x1 = x1.add(x0).divide(two, 10, RoundingMode.HALF_UP);
        }
        return x1;
    }
}