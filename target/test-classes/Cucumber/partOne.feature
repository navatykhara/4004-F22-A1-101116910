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

  Scenario: row49
    Given I have a hand of "SKULL,PARROT,PARROT,PARROT,PARROT,SWORD,SWORD,SWORD"
    When I reroll "SWORD,SWORD,SWORD" to "SKULL,MONKEY,MONKEY"
    And I reroll "MONKEY,MONKEY" to "SKULL,MONKEY"
    Then I die

  Scenario: row51
    Given I have a hand of "SKULL,PARROT,PARROT,SWORD,SWORD,SWORD,COIN,COIN"
    When I reroll "PARROT,PARROT" to "COIN,COIN"
    And I reroll "SWORD,SWORD,SWORD" to "COIN,COIN,COIN"
    Then I should get a score of 4800