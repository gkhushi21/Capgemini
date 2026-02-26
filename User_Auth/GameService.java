package User_Auth;

import java.util.ArrayList;
    public class GameService {
        static ArrayList<Game> games = new ArrayList<>();

        static {
            games.add(new Game("SnowBird", "Danny", 300));
            games.add(new Game("FreshFood","Ram",450));
            games.add(new Game("Batsman","Kate",400));
            games.add(new Game("Pokiman","Steeve",600));
            games.add(new Game("YammyTommy","Narayan",350));
        }

        public static ArrayList<Game> viewAll() {
            return games;
        }

        static String authorSearch(String author) {
            String result="Display NOT FOUND";
            for( Game g : games) {
                if(g.getAuthorName().equals(author)) {
                    return g.getGameName();
                }
            }
            return "Author not found";
        }
    }

