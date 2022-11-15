Feature: Does single player scoring work?

  Scenario: row45
    Given I have a hand of "SKULL,SKULL,SKULL,SWORD,SWORD,SWORD,SWORD,SWORD"
    When I die
    Then I should get a score of 0

  Scenario: row46
    Given I have a hand of "SKULL,PARROT,PARROT,PARROT,PARROT,SWORD,SWORD,SWORD"
    When I reroll "SWORD,SWORD,SWORD" to "SKULL,SKULL,SWORD"
    Then I die

  Scenario: row47
    Given I have a hand of "SKULL,SKULL,PARROT,PARROT,PARROT,PARROT,SWORD,SWORD"
    When I reroll "SWORD,SWORD" to "SKULL,SWORD"
    Then I die