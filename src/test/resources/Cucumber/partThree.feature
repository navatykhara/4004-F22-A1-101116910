Feature: Does Part 3 work?

  Scenario: row132
    Given Player 1 has a hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL" with FC "CAPTAIN"
    When Player 1 should score 4000
    And Player 2 has a hand of "SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL" with FC "SKULL" 1
    And Player 2 should score 2000
    And Player 3 has a hand of "SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY" with FC "COIN"
    And Player 3 should score 0
    And Game stops
    Then Player 1 should win