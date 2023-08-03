package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    //test

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddWithIncorrectMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    2_000,
                    1_000,
                    5
            );
        });

    }

    @Test
    public void shouldAddIncorrectRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -1
            );
        });
    }

    @Test
    public void shouldAddPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldAddPayNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-500);

        Assertions.assertEquals(1_500, 1_500);
    }

    @Test
    public void shouldAddPayZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddPayMoreThenMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_500);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldYearChange() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                10_000,
                15
        );

        Assertions.assertEquals(30, account.yearChange());
    }

    @Test
    public void shouldYearChangeZero() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeFractional() {
        SavingAccount account = new SavingAccount(
                2_444,
                100,
                10_000,
                15
        );

        Assertions.assertEquals(360, account.yearChange());
    }

    @Test
    public void shouldAddMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(1_000, account.getMinBalance());
    }

    @Test
    public void shouldAddMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

}
