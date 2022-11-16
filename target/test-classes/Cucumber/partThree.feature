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