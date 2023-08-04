package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldCreate0Balance() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);

        int expected = 0;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayIfAmountNegative() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        boolean expected = false;
        boolean actual = account.pay(-900);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayIfTransactionIsNotOverLimit() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        boolean expected = true;
        boolean actual = account.pay(900);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseBalanceByPayment() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(900);

        int expected = 100;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseBalanceByPaymentIfResultNegative() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(1200);

        int expected = -200;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayIfTransactionIsOverLimit() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        boolean expected = false;
        boolean actual = account.pay(6_500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotChangeBalanceIfPaymentIsOverLimit() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(6500);

        int expected = 1_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddIfAmountNegative() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        boolean expected = false;
        boolean actual = account.add(-900);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIfBalancePositive() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        boolean expected = true;
        boolean actual = account.add(3_000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseBalanceByAdding() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.add(3_000);

        int expected = 4_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateInterestAmount() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(1_200);

        int expected = -30;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCalculateInterestAmountIfBalancePositive() {
        CreditAccount account = new CreditAccount(200, 5_000, 15);

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfRateIncorrect() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(1_000, 5_000, -15);
        });
    }

    @Test
    public void shouldThrowExceptionIfInitialBalanceIncorrect() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-200, 5_000, 15);
        });
    }

    @Test
    public void shouldThrowExceptionIfCreditLimitIncorrect() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(1_000, -1_000, 15);
        });
    }

    @Test
    public void shouldNotThrowExceptionIfRate0() {
            CreditAccount account = new CreditAccount(1_000, 5_000, 0);

            int expected = 0;
            int actual = account.getRate();
            Assertions.assertEquals(expected, actual);
    }
}
