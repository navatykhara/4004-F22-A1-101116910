Feature: Does Part 3 work?

  Scenario: row132
    Given Player 1 has a hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL"
    When Player 1 FC is "CAPTAIN"
    And Player 1 should score of 4000
    And Player 2 has a hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL"
    And Player 2 FC is "SKULLS" 1
    And Player 2 should score of 2000
    And Player 3 has a hand of "SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY"
    And Player 3 FC is "COIN"
    And Player 3 should score of 0
    And Game stops
    Then Player 1 should win

  Scenario: row140
    Given Player 1 has a hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL"
    When Player 1 FC is "CAPTAIN"
    And Player 1 should score of 4000
    And Player 2 has a hand of "SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY"
    And Player 2 FC is "COIN"
    And Player 2 should score of 0
    And Player 3 has a hand of "SKULL,SKULL,SKULL,SKULL,SKULL,SKULL,PARROT,PARROT"
    And Player 3 FC is "CAPTAIN"
    And Player 3 deduct 1200
    And Player 1 should total 2800
    And Player 2 should total 0
    And Player 1 has a new hand of "MONKEY,MONKEY,MONKEY,MONKEY,PARROT,PARROT,PARROT,PARROT"
    And Player 1 FC is "COIN"
    And Player 1 should score of 1000
    And Player 1 should total 3800
    And Player 2 has a new hand of "SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY"
    And Player 2 FC is "CAPTAIN"
    And Player 2 should score of 0
    And Player 3 has a new hand of "SKULL,SKULL,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY"
    And Player 3 FC is "SKULLS" 1
    Then Player 1 should win

  Scenario: row145
    Given Player 1 has a hand of "SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY"
    When Player 1 FC is "CAPTAIN"
    And Player 1 should score of 0
    And Player 2 has a hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL"
    And Player 2 FC is "CAPTAIN"
    And Player 2 should score of 4000
    And Player 3 has a hand of "SKULL,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD"
    And Player 3 FC is "SKULLS" 2
    And Player 3 should score of 0
    And Player 1 has a new hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD"
    And Player 1 FC is "CAPTAIN"
    And Player 1 should score of 9000
    Then Player 1 should win

  Scenario: row150
    Given Player 1 has a hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL,SKULL"
    When Player 1 FC is "COIN"
    And Player 1 should score of 1100
    And Player 2 has a hand of "SKULL,SKULL,SKULL,SKULL,SKULL,SKULL,SKULL,COIN"
    And Player 2 FC is "SORCERESS"
    And Player 2 reroll skull to "PARROT"
    And Player 2 reroll "COIN,PARROT" to "SKULL,SKULL"
    And Player 2 deduct 800
    And Player 1 should total 300
    And Player 2 should total 0
    Then Player 3 should total 0