package kz.practice.jUnit.task_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void shouldNotBeBlockedWhenCreated() {
        BankAccount account = new BankAccount("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        assertEquals(0, account.getAmount());
        assertEquals("KZT", account.getCurrency());
    }

    // должен проверять, что счёт заблокирован, после вызова метода block()
    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        BankAccount account = new BankAccount("a", "b");
        account.block();
        assertTrue(account.isBlocked());
    }

    // должен проверять, что при вызове метода getFullName() возвращается правильный массив строк
    @Test
    public void shouldReturnFirstNameThenSecondName() {
        BankAccount account = new BankAccount("a", "b");
        String[] expected = {"a", "b"};
        assertArrayEquals(expected, account.getFullName());
    }

    // должен проверять, что при вызове метода getAmount() для неактивного счёта,
    // значение currency равно null, а также выбрасывается исключение IllegalStateException с соответствующим сообщением.
    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        BankAccount account = new BankAccount("a", "b");
        assertNull(account.getCurrency());
        IllegalStateException exception = assertThrows(IllegalStateException.class, account::getAmount);
        assertEquals("Счёт не активирован.", exception.getMessage());
    }
}