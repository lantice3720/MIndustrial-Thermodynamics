package MIT.content;

import MIT.world.blocks.fusionCore;
import arc.util.Log;
import mindustry.content.Bullets;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;

import static mindustry.type.ItemStack.with;

public class MITBlocks implements ContentList {
    public static Block
            //turrets
            singe,
            //power
            fusionCoreBlock;

    @Override
    public void load(){
        singe = new ItemTurret("singe"){{
            requirements(Category.turret, with(Items.copper, 72, Items.lead, 102, Items.graphite, 50));
            ammo(
                    Items.coal, Bullets.basicFlame
            );
            size = 2;
            recoilAmount = 1f;
            reloadTime = 6f;
            coolantMultiplier = 1.7f;
            range = 120f;
            shootCone = 50f;
            targetAir = false;
            ammoUseEffect = Fx.none;
            health = 1250;
            shootSound = Sounds.flame;
        }};

        fusionCoreBlock = new fusionCore("fusion-core"){{
            requirements(Category.power, with(Items.lead, 200));
            size = 4;
            health = 3560;
            Log.info("hehe?");
        }};
    }
}
