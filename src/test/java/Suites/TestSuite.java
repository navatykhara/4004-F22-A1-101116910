package Suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages({"Dice", "FortuneCards", "Game", "Part1", "Part2"})
@Suite
public class TestSuite {
}
