import java.util.Random;

public class WildernessMap extends GameMap {
    @Override
    Tile createTile() {
        Random rand = new Random();
        int random = rand.nextInt(3);
        return switch (random) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> null;
        };
    }
}
