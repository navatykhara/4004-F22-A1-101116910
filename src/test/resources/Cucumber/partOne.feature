Feature: Does single player scoring work?

  Scenario: row45
    Given I have a hand of "SKULL,SKULL,SKULL,SWORD,SWORD,SWORD,SWORD,SWORD"
    When I die
    Then I should get a score of 0

  Scenario: row46
    Given I have a hand of "SKULL,PARROT,PARROT,PARROT,PARROT,SWORD,SWORD,SWORD"
    When I reroll "SWORD,SWORD,SWORD"
    Then I get "SKULL,SKULL,SWORD"
    Then I die