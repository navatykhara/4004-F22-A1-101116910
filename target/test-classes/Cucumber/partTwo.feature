Feature: Does Part 2 work?

  Scenario: row77
    Given I have a hand of "DIAMOND,DIAMOND,SWORD,MONKEY,COIN,PARROT,PARROT,PARROT"
    When I reroll "PARROT,PARROT,PARROT" to "SKULL,MONKEY,MONKEY"
    And FC is "SORCERESS"
    And I reroll skull to "MONKEY"
    Then I should get a score of 500
