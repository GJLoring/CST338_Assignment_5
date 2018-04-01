/*
 * Assignment M5 Phase 2
 * Add Card Framework and create game "High Card".
 * Authors: Christian Guerrero, Jose Garcia, Grace Alvarez, Gabriel Loring
 * Last Changed: March 30th, 2018
 * 
 */
//import CardGameFramework.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Assig5Phase2
{  
   public static void main(String[] args)
   {
      
      Integer numPacksPerDeck = 1;
      Integer numJokersPerPack = 0;
      Integer numUnusedCardsPerPack = 0;
      Card[] unusedCardsPerPack = null;
      Integer NUM_PLAYERS= 2;
      Integer NUM_CARDS_PER_HAND= 2;
      
      // Test Assignment
      System.out.println("Phase 2\n");
 
      }   
}  

class CardTable{
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
   
   private int numCardsPerHand;
   private int numPlayers;

   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;
   
   CardTable(String title, int numCardsPerHand, int numPlayers) {
      // Todo
   }
}
   
class GUICard{   
   private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
    private static Icon iconBack;
    static boolean iconsLoaded = false;
   
   static void loadCardIcons()
   {
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      // in a SHORT loop.  For each file name, read it in and use it to
      // instantiate each of the 57 Icons in the icon[] array.
      int count = 0;
      for(int j = 0; j < 4; j++)
      {
         for(int k = 0; k <= 13; k++)
         {
            iconCards[k][j] = new ImageIcon("images/" + turnIntIntoCardValue(k) 
            + turnIntIntoCardSuit(j) + ".gif");
         }
      }
      iconBack = new ImageIcon("images/BK.gif");
   }
   
   
   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int k)
   {
      // an idea for a helper method (do it differently if you wish)
      String returnVal = null;
      String[] value = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
                        "T", "J", "Q", "K", "X"};
      if(k >= 0 && k <= 13)
      {
         returnVal = value[k];
      }
      else
      {
         System.out.println("returning default value A");
         return value[0];
      }
      return returnVal;
   }
   
   
   static private int valueAsInt(Card card){
      int returnVal = 0;
      String[] value = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
            "T", "J", "Q", "K", "X"};
      for(int i = 0; i < value.length; i++){
         if(value[i].equals(card.getValue()))
            returnVal = i;
      }   
      return returnVal; 
   }

   
   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int j)
   {
      // an idea for another helper method (do it differently if you wish)
      String returnSuit = null;
      String[] value = {"C", "D", "H", "S"};
      
      if(j >= 0 && j <= 3)
      {
         returnSuit = value[j];
      }
      else
      {
         System.out.println("returning default suit C");
         return value[0];
      }
      return returnSuit;
   }
   
   static private int suitAsInt(Card card){
      int returnVal = 0;
      String[] value = {"C", "D", "H", "S"};
      for(int i = 0; i < value.length; i++){
         if(value[i].equals(card.getSuit()))
            returnVal = i;
      }   
      return returnVal; 
   }

   static public Icon getIcon(Card card) {
      return iconCards[valueAsInt(card)][suitAsInt(card)];  //TOD Check ME
   }
   
   static public Icon getBackCardIcon(){
      return iconBack;
   }

}    

//Classes copied ofver from assignment M3
class Card
{
   //A Public enum Type with added members
   public enum Suit{clubs, diamonds, hearts, spades};
   
   //card values, T for ten
   public static final char[] cardValue = {'A', '2', '3', '4', '5', '6', '7', 
      '8', '9', 'T', 'J', 'Q', 'K'};
   
   //private member data
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   //Constructor with parameters value and suit
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }
   
   //Default constructor sets value to "A" and suit to "spades" when value and suit not supplied
   public Card()
   {
      set('A', Suit.spades);
   }
   
   /*
    * Stringizer that client can use prior to displaying card
    * provides clean representation of the card
    */
   public String toString()
   {
      if (errorFlag == true)
      {
         return("** illegal **");
      }
      return String.valueOf(value) + " of " + suit;
   }
   
   /*
    * Mutator that accepts legal values.
    * When bad values are passed, errorFlag is set to true
    * When good values are passed they are stored and errorFlag is set to false 
   */
   public boolean set(char value, Suit suit)
   {
      if (isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         errorFlag = false;
         return true;
      }
      else
      {
         errorFlag = true;
         return false;
      }
   }
 
   //Accessor that returns a cards value
   public char getValue()
   {
      return value;
   }
   
    //Accessor that returns a cards suit
   public Suit getSuit()
   {
      return suit;
   }
   
   //Accessor that returns errorFlag
   public boolean getErrorFlag()
   {
      return errorFlag;
   }
   
   //Returns true if all the fields(members) are identical and false, otherwise
   public boolean equals(Card card)
   {
      if (suit.equals(card.getSuit()) && value == card.getValue())
      {
         return true;
      }
      return false;
   }
   
   /*
    * Private method that returns true or false, depending on the legality of the parameters.
    * Note that, although it may be impossible for suit to be illegal (due to its enum-ness),
    * we pass it, anyway, in anticipation of possible changes to the type from enum to, say,
    * char or int, someday.  We only need to test value, at this time.
    * */
   

   private boolean isValid(char value, Suit suit)
   {
      for (int i = 0; i < cardValue.length; i++)
      {
         if (value == cardValue[i])
            return true;
      }
      return false;
   }
}


class Hand
{
   public static final int MAX_CARDS = 52;
   private Card[] myCards = new Card[MAX_CARDS];
   private int numCards = 0;

   // Default constructor
   public Hand()
   {
      Deck deck = new Deck();
      myCards = new Card[MAX_CARDS];
      for (int i = 1; i <= MAX_CARDS; i++)
      {
         takeCard(deck.dealCard());
      }
   }

   // Remove all cards from the hand
   void resetHand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
      return;
   }

   // Adds a card to the next available position in the myCards array
   public boolean takeCard(Card card)
   {
      if(numCards == MAX_CARDS)
         return false;
      myCards[numCards] = card;
      numCards++;
      return true;
   }
   
   public boolean sort(){
      return true;   //Todo write me
   }

   public Card playCard(int k)
   {
      return myCards[k];  //Todo write me
   }
   
   // Returns and removes the card in the top occupied position of the myCards
   // array
   public Card playCard()
   {
      Card handTopCard = new Card();
      handTopCard = myCards[numCards - 1];
      System.out.println("Playing " + handTopCard);
      myCards[numCards - 1] = null;
      numCards--;
      return handTopCard;
   }

   // Prints out the array of cards.
   public String toString()
   {
      System.out.print("Hand = ( ");
      for (int index = 0; index <= numCards - 1; index++)
         System.out.print(myCards[index] + ", ");
      System.out.println(")");
      return "";
   }

   // Accessor for number of cards
   public int getNumCards()
   {
      return numCards;
   }

   // Inspect a single card
   Card inspectCard(int k)
   {
      if(k >= numCards)
      {
         Card x = new Card();
         x.set('F', Card.Suit.clubs);
         return x;
      }
      else
      {
         return myCards[k];
      }
   }
}


class Deck
{
   //Deck capacity set to six packs by 52 cards per pack
   public static final int MAX_CARDS = 6 * 52;
   
   //Private static member data
   private static Card[] masterPack;
   private static boolean isExecuted;
   
   //Private member data
   private Card[] cards;
   private int topCard;
   private int numPacks;
   
   //Constructor to initialize masterpack
   public Deck(int numPacks)
   {
      allocateMasterPack();
      this.cards = masterPack;
      init(numPacks);
   } 
   
   //if no parameters are passed 1 pack is assumed
   public Deck()
   {
      this(1);  //Todo write me
   }
   
   // Accessor for number of cards
   public int getNumCards()
   {
      return cards.length;
   }
   
   // 
   public void init(int numPacks)
   {
      this.numPacks = numPacks;
      getTopCard();
      if(topCard <= MAX_CARDS && numPacks != 0)
      {
         cards = new Card[topCard];
         for(int k = 0; k < cards.length; k++)
         {
            cards[k] = new Card();
            for(int k1 =0; k1 < numPacks; k1++)
            {
               for(int i = 52 * k1, j = 0; i < 52 * k1 + 52; i++, j++)
               {
                  cards[i] = masterPack[j];
               }
            }
         }
      }
      else
      {
         return;
      }
   } 
   
   // Used to shuffle the cards[] 
   public void shuffle()
   {
      Random rand = new Random();
      for(int k = cards.length - 1; k > 0; k--)
      {
         int randomIndex = rand.nextInt(k + 1);
         Card tempCard = cards[randomIndex];
         cards[randomIndex] = cards[k];
         cards[k] = tempCard;
      }
   } 
   
   // Used to deal cards 
   public Card dealCard()
   {
      if(topCard == 0)
      {
         return null;
      }
      Card returnCard = cards[topCard -1];
      cards[topCard -1] = null;
      topCard--;
      return returnCard;
   }
   
   // Accessor returns the value of numPacks * 52 using topCard 
   public int getTopCard ()
   {
      topCard = numPacks * 52;
      return topCard;
   }

   
   public boolean addCard(Card x)
   {
      return true;    //TOD FIX ME
   }   
   public Card removeCard( Card k)
   {
      return this.inspectCard(1);    //TOD FIX ME
   }

   
   // Accessor inspects card and returns them or returns illegal message
   public Card inspectCard(int k) 
   {
      if(topCard == 0 || k < 0 || k > topCard)
      {
         return new Card('F', Card.Suit.spades);
      }
      else
      {
         return cards[k];
      }
   }
   
   // Place holder 
   private static void allocateMasterPack()
   {
      if(!isExecuted)
      {
         masterPack = new Card[52];
         Card.Suit suit;
         int k;
         int j;
         char value;
         
         for( k = 0; k < masterPack.length; k++)
         {
            masterPack[k] = new Card();
         }
         for(k = 0; k < 4; k++)
         {
            switch(k)
            {
               case 0: suit = Card.Suit.clubs;
                       break;
               case 1: suit = Card.Suit.diamonds;
                       break;
               case 2: suit = Card.Suit.hearts;
                       break;
               case 3: suit = Card.Suit.spades;
                       break;
               default: suit = Card.Suit.spades;
                       break;
            }
            masterPack[13 * k].set('A', suit);
            for(value = '2', j = 1; value <= '9'; value++, j++)
            {
               masterPack[13 * k + j].set(value, suit);
               masterPack[13 * k + 9].set('T', suit);
               masterPack[13 * k + 10].set('J', suit);
               masterPack[13 * k + 11].set('Q', suit);
               masterPack[13 * k + 12].set('K', suit);
            }
         }
         isExecuted = true;
      }
      else
      {
         return;
      }
   }
}