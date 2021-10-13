package MIT.world.blocks;

import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.world.Block;

public class CustomBuilding extends Building {
    public int reactorSize;

    @Override
    public Building create(Block block, Team team){
        super.create(block, team);
        this.reactorSize = 1;
        return this;
    }
}
