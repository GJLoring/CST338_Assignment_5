/*
 * Assignment M5 
 * Add Card Framework and create game "High Card".
 * Authors: Christian Guerrero, Jose Garcia, Grace Alvarez, Gabriel Loring
 * Last Changed: March 30th, 2018
 * 
 */
//import CardGameFramework.*;

public class Assig5Phase3
{  
   public static void main(String[] args)
   {
      
      Integer numPacksPerDeck = 1;
      Integer numJokersPerPack = 0;
      Integer numUnusedCardsPerPack = 0;
      Card[] unusedCardsPerPack = null;
      Integer NUM_PLAYERS= 2;
      Integer NUM_CARDS_PER_HAND= 2;

      CardGameFramework highCardGame = new CardGameFramework( 
         numPacksPerDeck, numJokersPerPack,  
         numUnusedCardsPerPack, unusedCardsPerPack, 
         NUM_PLAYERS, NUM_CARDS_PER_HAND);
      
      // Test Assignment
      System.out.println("Phase 3\n");
 
      }   
}      
