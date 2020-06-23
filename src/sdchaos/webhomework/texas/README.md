# 德州扑克
## 概述
采用TDD开发流程，经过测试且通过后的德州扑克比点系统。

测试文件参加[test.sdchaos.webhomework.texas](https://github.com/SDchao/WebHomework/blob/master/test/test/sdchaos/webhomework/texas/JudgeTest.java)
## 类与方法说明
### Judge
用于判断两手牌的大小
#### 常量
##### Integer
* PLAYER1_WIN = 0;
* PLAYER2_WIN = 1;
* TIE = -1;
#### 方法
##### Compare(Card[] player1Cards, Card[] player2Cards)
* 参数1：玩家1的牌组
* 参数2：玩家2的牌组
* 返回值：Judge.PLAYER1_WIN 、 Judge.PLAYER2_WIN、 Judge.TIE 三种
### Card
用于存放卡牌信息的类
#### 成员
##### rank
整数型，存放卡牌的点数大小，可能的值为 2 - 14

仅有getter
##### suit
String，存放卡牌的花色，可能的值为"D"、"S"、"H"、"C"

仅有getter
### CardType
用于存放牌组判定后的类别
#### 常量
##### Integer
* LOOSE = 0;
* ONE_PAIR = 1;
* TWO_PAIRS = 2;
* THREE_OF_A_KIND = 3;
* STRAIGHT = 4;
* FLUSH = 5;
* STRAIGHT_FLUSH = 6;
#### 成员
##### type
整数型，用于存放卡组的类别，可能的值如下：
* LOOSE 散牌
* ONE_PAIR 对子
* TWO_PAIRS 两对
* THREE_OF_A_KIND 三条
* STRAIGHT 顺子
* FLUSH 同花
* STRAIGHT_FLUSH 同花顺

##### maxRank
整数型，用于存放牌组特征下的最大点数，可能的值为 2 - 14
