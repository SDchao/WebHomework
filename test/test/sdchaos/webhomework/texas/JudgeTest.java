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
* @author <Authors name> 
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
} 


} 
