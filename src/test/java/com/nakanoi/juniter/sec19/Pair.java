package com.nakanoi.juniter.sec19;

class Pair<E, T> {
  private final E first;
  private final T last;

  Pair(E first, T last) {
    this.first = first;
    this.last = last;
  }

  public boolean different() {
    return !first.equals(last);
  }

  public E getFirst() {
    return first;
  }

  public T getLast() {
    return last;
  }
}
