package test.sdchaos.webhomework.texas; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import sdchaos.webhomework.texas.Card;
import sdchaos.webhomework.texas.Judge;

/** 
* Judge Tester.
* 
* @author SDchao
* @since <pre>6月 23, 2020</pre> 
* @version 1.0 
*/ 
public class JudgeTest {
    Judge judge;

@Before
public void before() {
    judge = new Judge();
} 

@After
public void after() {
} 

/** 
* 
* Method: Compare(Card[] player1Cards, Card[] player2Cards) 
* 
*/ 
@Test
public void testCompare() {
    // 1
    Card[] player1 = {
            new Card("2","H"),
            new Card("3","D"),
            new Card("5","S"),
            new Card("9","C"),
            new Card("K","D")
    };

    Card[] player2 = {
            new Card("2","C"),
            new Card("3","H"),
            new Card("4","S"),
            new Card("8","C"),
            new Card("A","H")
    };

    int r = judge.Compare(player1,player2);
    Assert.assertEquals(r, Judge.PLAYER2_WIN);

    // 2
    player1 = new Card[] {
            new Card("2", "H"),
            new Card("4", "S"),
            new Card("4", "C"),
            new Card("2", "D"),
            new Card("4", "H")
    };

    player2 = new Card[] {
            new Card("2", "S"),
            new Card("8", "S"),
            new Card("A", "S"),
            new Card("Q", "S"),
            new Card("3", "S")
    };

    r = judge.Compare(player1,player2);
    Assert.assertEquals(r, Judge.PLAYER2_WIN);

    // 3
    player1 = new Card[] {
            new Card("2", "H"),
            new Card("3", "H"),
            new Card("5", "H"),
            new Card("9", "H"),
            new Card("K", "H")
    };

    player2 = new Card[] {
            new Card("2", "C"),
            new Card("3", "H"),
            new Card("4", "S"),
            new Card("5", "C"),
            new Card("6", "H")
    };

    r = judge.Compare(player1,player2);
    Assert.assertEquals(r, Judge.PLAYER1_WIN);

    // 4
    player1 = new Card[] {
            new Card("2", "H"),
            new Card("3", "D"),
            new Card("5", "S"),
            new Card("9", "C"),
            new Card("K", "D")
    };

    player2 = new Card[] {
            new Card("2", "D"),
            new Card("3", "H"),
            new Card("5", "C"),
            new Card("K", "H"),
            new Card("9", "S")
    };

    r = judge.Compare(player1,player2);
    Assert.assertEquals(r, Judge.TIE);
} 


} 
