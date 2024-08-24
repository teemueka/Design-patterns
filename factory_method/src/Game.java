public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.createMap(new CityMap());
    }
    public void createMap(GameMap map) {
        map.display();
    }
}
