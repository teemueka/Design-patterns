import java.util.Random;

public class CityMap extends GameMap {
    @Override
    Tile createTile() {
        Random rand = new Random();
        int random = rand.nextInt(3);
        return switch (random) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            case 2 -> new BuildingTile();
            default -> null;
        };
    }
}
