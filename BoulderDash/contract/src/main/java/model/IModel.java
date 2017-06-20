package model;

import java.util.ArrayList;

public interface IModel {

    ArrayList getBlock();

    ArrayList getAlive();

    ArrayList getTile();

    void addBlock(Block block);

    void removeBlock(Block block);

    void addAlive(Alive alive);

    void removeAlive(Alive alive);

    void addTile(Tile tile);

    void removeTile(Tile tile);
    
}
