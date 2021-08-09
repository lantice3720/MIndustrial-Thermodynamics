package MIT.content;

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
            singe, blaze;

    @Override
    public void load(){
        singe = new ItemTurret("scorch"){{
            requirements(Category.turret, with(Items.copper, 72, Items.lead, 102, Items.graphite, 50));
            ammo(
                    Items.coal, Bullets.basicFlame
            );
            recoilAmount = 1f;
            reloadTime = 6f;
            coolantMultiplier = 1.7f;
            range = 60f;
            shootCone = 50f;
            targetAir = false;
            ammoUseEffect = Fx.none;
            health = 400;
            shootSound = Sounds.flame;
        }};
    }
}
