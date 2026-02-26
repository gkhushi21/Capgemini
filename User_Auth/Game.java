package User_Auth;

public class Game {


        private String gameName ;
        private String authorName;
        private float price ;

        Game(String gameName,String authorName, float price ){
            this.gameName =gameName;
            this.authorName= authorName;
            this.price =price;

        }

        public String toString() {
            return "game name is "+gameName+", author name "+authorName+" , price is :"+price+"\n";
        }

        public String getGameName() {
            return gameName;
        }

        public String getAuthorName() {
            return authorName;
        }

        public float getPrice() {
            return price;
        }
    }

