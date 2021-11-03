package MIT.world.blocks;

import arc.util.Nullable;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.Block;

public class casingBlock extends Block {

    public casingBlock(String name) {
        super(name);
        hasPower = true;
        hasLiquids = true;
        configurable = true;
        drawDisabled = false;
        logicConfigurable = false;
        update = true;
        solid = true;
    }

    public class casingBuild extends Building {
        public @Nullable Building linkedFCore;

        @Override
        public void handleItem(Building source, Item item){
            if(linkedFCore != null){
                linkedFCore.handleItem(source, item);
            }else{
                super.handleItem(source, item);
            }
        }

        @Override
        public void itemTaken(Item item){
            if(linkedFCore != null){
                linkedFCore.itemTaken(item);
            }
        }
    }
}
