package Suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages({"Dice", "FortuneCards", "Game", "AcceptanceTests"})
@Suite
public class TestSuite {
}
