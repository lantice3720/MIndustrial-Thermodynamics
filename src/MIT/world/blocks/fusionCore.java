package MIT.world.blocks;

import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.gen.Icon;
import mindustry.gen.Tex;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.world.blocks.power.PowerGenerator;

public class fusionCore extends PowerGenerator {

    public TextureRegionDrawable buttonRegion = new TextureRegionDrawable();
    public float forceRadius = 31f, forceStrength = 0.2f;

    public fusionCore(String name){
        super(name);
        hasPower = true;
        hasLiquids = true;
        configurable = true;
        drawDisabled = false;
        logicConfigurable = false;
        update = true;
        solid = true;

        Log.info("What Happened?");
    }

    @Override
    public void load(){
        super.load();

        if(Vars.ui != null){
            buttonRegion = Vars.ui.getIcon("router");
        }
    }

    public class fusionCoreBuild extends Building{

        Integer count = 1;

        @Override
        public void onDestroyed(){
            tile.getLinkedTilesAs(block, c->{Log.info(this);});
            super.onDestroyed();
        }

        @Override
        public void updateTile(){
            super.updateTile();

            team.data().tree().intersect(x - forceRadius/2f, y - forceRadius/2f, forceRadius, forceRadius, u -> {
                if(!u.isPlayer()){
                    float dst = dst(u);
                    float rs = forceRadius + u.hitSize/2f;
                    if(dst < rs){
                        u.vel.add(Tmp.v1.set(u).sub(x, y).setLength(1f - dst / rs).scl(forceStrength));
                    }
                }
            });
        }

        @Override
        public void buildConfiguration(Table table){
            table.button(Icon.edit, Styles.clearTransi, () -> {
                BaseDialog dialog = new BaseDialog("FRCP", Styles.fullDialog);
                dialog.cont.clear();
                dialog.addCloseListener();
                dialog.cont.pane(t->{
                    t.table(Tex.buttonEdge1, tab ->{
                        tab.row().left();
                        tab.button(Icon.menu, Styles.clearPartiali, () -> new BaseDialog(""){{
                                    addCloseButton();
                                }}.show()
                        );
                    });
                });
                dialog.show();
            }).size(40f);
            table.row();
        }
    }
}