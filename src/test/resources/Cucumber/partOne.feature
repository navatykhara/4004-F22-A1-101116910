Feature: Does single player scoring work?

  Scenario: row45
    Given I have a hand of "SKULL,SKULL,SKULL,SWORD,SWORD,SWORD,SWORD,SWORD"
    When I die
    Then I should get a score of 0