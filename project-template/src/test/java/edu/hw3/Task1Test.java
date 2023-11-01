package edu.hw3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    static String alphabetSortedEn;

    @BeforeAll
    static void setUp() {
        alphabetSortedEn = Task1.getEnAlphabet();
    }

    @Test
    void testEncodeAtbashEn1() {
        var task1 = new Task1(alphabetSortedEn);
        String initStr = "Hello world!";
        String encodedStr = "Svool dliow!";

        assertEquals(encodedStr, task1.encodeAtbash(initStr));
    }

    @Test
    void testEncodeAtbashEn2() {
        var task1 = new Task1(alphabetSortedEn);
        String initStr = "Any fool can write code that a computer can understand. " +
            "Good programmers write code that humans can understand. ― Martin Fowler";
        String encodedStr = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. " +
            "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        assertEquals(encodedStr, task1.encodeAtbash(initStr));
    }

    @Test
    void testEncodeAtbashEmptyInput() {
        var task1 = new Task1(alphabetSortedEn);
        String initStr = "";
        String encodedStr = "";

        assertEquals(encodedStr, task1.encodeAtbash(initStr));
    }

    @Test
    void testEncodeAtbashRu() {
        // В задании говориться только про работу с латинским алфавитом,
        // поэтому для генерации остальных специальный функционал не предусмотрен
        String alphabetSortedRu = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФЦЧШЩЪЫЬЭЮЯ";
        var task1 = new Task1(alphabetSortedRu);
        String initStr = "Съешь Этих Мягких Булочек";
        String encodedStr = "Меъжг Влцх Саьуцх Юктпзъу";

        assertEquals(encodedStr, task1.encodeAtbash(initStr));
    }
}
