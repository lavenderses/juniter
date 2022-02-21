package com.nakanoi.juniter.sec8;

/** Rock papers scissors. */
public class RockPapersScissors {
  /**
   * Judge Rock Paper Scissors result.
   *
   * @param h1 Hand to be judged.
   * @param h2 Hand of the other person.
   * @return h1's Result.
   */
  public Result judge(Hand h1, Hand h2) {
    if (h1 == h2) {
      return Result.DRAW;
    }
    switch (h1) {
      case ROCK:
        return h2 == Hand.SCISSORS ? Result.WIN : Result.LOSE;
      case PAPERS:
        return h2 == Hand.ROCK ? Result.WIN : Result.LOSE;
      case SCISSORS:
        return h2 == Hand.PAPERS ? Result.WIN : Result.LOSE;
    }
    ;
    return null;
  }
}
