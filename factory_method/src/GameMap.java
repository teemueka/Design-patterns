public abstract class GameMap {
    abstract Tile createTile();

    void display() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(createTile().getCharacter() + " ");
            }
            System.out.println();
        }

    }
}