Feature: Does Part 2 work?

  Scenario: row77
    Given I have a hand of "DIAMOND,DIAMOND,SWORD,MONKEY,COIN,PARROT,PARROT,PARROT"
    When I reroll "PARROT,PARROT,PARROT" to "SKULL,MONKEY,MONKEY"
    And FC is "SORCERESS"
    And I reroll skull to "MONKEY"
    Then I should get a score of 500

  Scenario: row78
    Given I have a hand of "SKULL,SKULL,SKULL,PARROT,PARROT,PARROT,SWORD,SWORD"
    When FC is "SORCERESS"
    And I reroll skull to "PARROT"
    And I reroll "SWORD,SWORD" to "PARROT,PARROT"
    Then I should get a score of 1000

  Scenario: row79
    Given I have a hand of "SKULL,PARROT,PARROT,PARROT,PARROT,MONKEY,MONKEY,MONKEY"
    When I reroll "MONKEY,MONKEY,MONKEY" to "SKULL,PARROT,PARROT"
    And FC is "SORCERESS"
    And I reroll skull to "PARROT"
    Then I should get a score of 2000

  Scenario: row82
    Given I have a hand of "MONKEY,MONKEY,MONKEY,PARROT,PARROT,PARROT,SKULL,COIN"
    When FC is "MONKEY BUSINESS"
    Then I should get a score of 1100

