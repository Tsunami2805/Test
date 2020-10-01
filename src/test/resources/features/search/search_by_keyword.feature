Feature: Search by keyword
  
Scenario: Giang wants to buy apple products on Tiki
    Given Giang is on the Tiki home page
    When he is looking for "apple" products to buy as gift to "Hà Nội", "Quận Hoàng Mai", "Phường Tương Mai"
    And he picked the 6 th item on the search result
    Then he adds 2 items to the cart to check out