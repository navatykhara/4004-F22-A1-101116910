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

  Scenario: row83
    Given I have a hand of "MONKEY,MONKEY,SWORD,SWORD,PARROT,PARROT,COIN,COIN"
    When I reroll "SWORD,SWORD" to "MONKEY,PARROT"
    And FC is "MONKEY BUSINESS"
    Then I should get a score of 1700

  Scenario: row84
    Given I have a hand of "SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,PARROT,PARROT"
    When FC is "MONKEY BUSINESS"
    And I die
    Then I should get a score of 0

  Scenario: row90
    Given I have a hand of "PARROT,PARROT,PARROT,SWORD,SWORD,DIAMOND,DIAMOND,COIN"
    When FC is "TREASURE CHEST"
    And I put "DIAMOND,DIAMOND,COIN" in chest
    And I reroll "SWORD,SWORD" to "PARROT,PARROT"
    And I put "PARROT,PARROT,PARROT,PARROT,PARROT" in chest
    And I take out "DIAMOND,DIAMOND,COIN"
    And I reroll "DIAMOND,DIAMOND,COIN" to "SKULL,COIN,PARROT"
    And I put "COIN,PARROT" in chest
    Then I should get a score of 1100

  Scenario: row94
    Given I have a hand of "SKULL,SKULL,PARROT,PARROT,PARROT,COIN,COIN,COIN"
    When FC is "TREASURE CHEST"
    And I put "COIN,COIN,COIN" in chest
    And I reroll "PARROT,PARROT,PARROT" to "DIAMOND,DIAMOND,COIN"
    And I put "COIN" in chest
    And I reroll "DIAMOND,DIAMOND" to "SKULL,COIN"
    And I should get a score of 600
    Then I report death

  Scenario: row97
    Given I have a hand of "MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,DIAMOND,PARROT"
    When FC is "COIN"
    Then I should get a score of 400

  Scenario: row98
    Given I have a hand of "MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,COIN,COIN"
    When FC is "CAPTAIN"
    Then I should get a score of 1800

  Scenario: row99
    Given I have a hand of "MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,SWORD,DIAMOND"
    When FC is "COIN"
    Then I should get a score of 1000

  Scenario: row102
    Given I have a hand of "MONKEY,MONKEY,MONKEY,MONKEY,SWORD,PARROT,PARROT,COIN"
    When FC is "SEA BATTLE" 2
    And I reroll "PARROT,PARROT" to "COIN,SWORD"
    Then I should get a score of 1200

  Scenario: row103
    Given I have a hand of "MONKEY,MONKEY,PARROT,COIN,COIN,DIAMOND,DIAMOND,DIAMOND"
    When FC is "MONKEY BUSINESS"
    Then I should get a score of 1200

  Scenario: row106
    Given I have a hand of "SKULL,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD"
    When FC is "SKULLS" 2
    Then I die

  Scenario: row107
    Given I have a hand of "SKULL,SKULL,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD"
    When FC is "SKULLS" 1
    Then I die

  Scenario: row109
    Given I have a hand of "SKULL,SKULL,MONKEY,MONKEY,MONKEY,PARROT,PARROT,PARROT"
    When FC is "SKULLS" 2
    And I reroll "PARROT,PARROT,PARROT" to "SKULL,SKULL,SWORD"
    And I reroll "MONKEY,MONKEY,MONKEY,SWORD" to "SKULL,SKULL,SKULL,SWORD"
    And I deduct 900
    Then I should get a score of 0

  Scenario: row110
    Given I have a hand of "SKULL,SKULL,SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY"
    When FC is "CAPTAIN"
    And I reroll "MONKEY,MONKEY,MONKEY" to "SKULL,SKULL,COIN"
    Then I deduct 1400

  Scenario: row111
    Given I have a hand of "SKULL,SKULL,SKULL,SWORD,SWORD,SWORD,SWORD,SWORD"
    When FC is "SKULLS" 2
    And I reroll "SWORD,SWORD,SWORD,SWORD,SWORD" to "COIN,COIN,COIN,COIN,COIN"
    Then I deduct 500

  #For row114, it is important to note that score and total are different in this system
  #Score represents the points gained or loss in a round, Total represents the total points a player has
  #It is important to note that even though Player 1 has a score of -300, it does not mean that their total will go below zero

  Scenario: row114
    Given I have a hand of "MONKEY,MONKEY,MONKEY,MONKEY,SKULL,SKULL,SKULL,SWORD"
    When FC is "SEA BATTLE" 2
    And I die
    Then I should get a score of -300

  Scenario: row115
    Given I have a hand of "SWORD,SWORD,SKULL,SKULL,PARROT,PARROT,PARROT,PARROT"
    When FC is "SEA BATTLE" 3
    And I reroll "PARROT,PARROT,PARROT,PARROT" to "SKULL,SKULL,SKULL,SKULL"
    And I die
    Then I should get a score of -500

  Scenario: row116
    Given I have a hand of "MONKEY,MONKEY,SKULL,SKULL,SKULL,SWORD,SWORD,SWORD"
    When FC is "SEA BATTLE" 4
    And I die
    Then I should get a score of -1000

  Scenario: row117
    Given I have a hand of "MONKEY,MONKEY,MONKEY,SWORD,SWORD,COIN,PARROT,PARROT"
    When FC is "SEA BATTLE" 2
    Then I should get a score of 500

  Scenario: row119
    Given I have a hand of "MONKEY,MONKEY,MONKEY,MONKEY,SWORD,SKULL,PARROT,PARROT"
    When FC is "SEA BATTLE" 2
    And I reroll "PARROT,PARROT" to "SWORD,SKULL"
    Then I should get a score of 500

  Scenario: row120
    Given I have a hand of "MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,SWORD,SKULL"
    When FC is "SEA BATTLE" 3
    Then I should get a score of 800
