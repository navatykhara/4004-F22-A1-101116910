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

  Scenario: row52
    Given I have a hand of "MONKEY,MONKEY,PARROT,PARROT,DIAMOND,DIAMOND,COIN,COIN"
    When FC is "CAPTAIN"
    Then I should get a score of 800

  Scenario: row53
    Given I have a hand of "MONKEY,MONKEY,SKULL,SKULL,SWORD,SWORD,PARROT,PARROT"
    When I reroll "PARROT,PARROT" to "SWORD,MONKEY"
    Then I should get a score of 300

  Scenario: row54
    Given I have a hand of "MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,SKULL,SKULL"
    Then I should get a score of 300

  Scenario: row55
    Given I have a hand of "DIAMOND,DIAMOND,DIAMOND,SKULL,SKULL,MONKEY,SWORD,PARROT"
    Then I should get a score of 500

  Scenario: row56
    Given I have a hand of "COIN,COIN,COIN,COIN,SKULL,SKULL,SWORD,SWORD"
    When FC is "DIAMOND"
    Then I should get a score of 700

  Scenario: row57
    Given I have a hand of "SWORD,SWORD,SWORD,PARROT,PARROT,PARROT,PARROT,SKULL"
    Then I should get a score of 400

  Scenario: row58
    Given I have a hand of "SKULL,COIN,COIN,PARROT,PARROT,SWORD,SWORD,SWORD"
    When I reroll "PARROT,PARROT" to "COIN,SWORD"
    Then I should get a score of 800