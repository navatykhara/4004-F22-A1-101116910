package Suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages({"Dice", "FortuneCards"})
@Suite
public class UTestSuite {
}
