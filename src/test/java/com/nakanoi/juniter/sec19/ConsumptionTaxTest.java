package com.nakanoi.juniter.sec19;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** Simple consumption tax calculation test.. */
public class ConsumptionTaxTest {
  ConsumptionTax sut;
  double taxRate = 0.1;

  @BeforeEach
  void setUp() {
    sut = new ConsumptionTax(taxRate);
  }

  @ParameterizedTest
  @CsvSource({
          "100, 110",
          "844, 928",
          "8464863, 9311349"
  })
  void testCalculate(int yen, int expected) {
    int actual = sut.calculate(yen);

    assertThat(actual).isEqualTo(expected);
  }
}
