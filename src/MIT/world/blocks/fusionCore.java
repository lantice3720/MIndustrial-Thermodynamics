package MIT.world.blocks;

import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import mindustry.Vars;
import mindustry.gen.Icon;
import mindustry.gen.Tex;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.world.blocks.power.PowerGenerator;

public class fusionCore extends PowerGenerator {

    public TextureRegionDrawable buttonRegion = new TextureRegionDrawable();
    public float forceRadius = 31f, forceStrength = 0.2f;
    public int reactorSize = 6;

    public fusionCore(String name) {
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
    public void load() {
        super.load();

        if (Vars.ui != null) {
            // buttonRegion = Vars.ui.getIcon("router");
        }
    }

    public class fusionCoreBuild extends CustomBuilding {


        @Override
        public void onDestroyed() {
            tile.getLinkedTilesAs(block, c -> {
                Log.info(this);
            });
            super.onDestroyed();
        }

        @Override
        public void updateTile() {
            super.updateTile();
        }

        @Override
        public void buildConfiguration(Table table) {
            table.button(Icon.edit, Styles.clearTransi, () -> {
                BaseDialog dialog = new BaseDialog("Fusion Rector Control Panel", Styles.fullDialog);
                dialog.cont.clear();
                dialog.addCloseListener();
                dialog.cont.pane(t -> {
                    t.table(Tex.button, table1 -> {
                        table1.row().left();
                        table1.button(String.valueOf(reactorSize), () -> {});
                        table1.button(Icon.pencil, Styles.defaulti, () -> {
                            BaseDialog resizeDialog = new BaseDialog("Resize Fusion Reactor");
                            resizeDialog.cont.clear();
                            resizeDialog.addCloseListener();
                            resizeDialog.cont.pane(t2 -> {
                                t2.table(Tex.button, resizeButtons -> {
                                    resizeButtons.row().left();
                                    resizeButtons.button(Icon.up, Styles.defaulti, () -> {if(reactorSize<4) {reactorSize++;}});
                                    resizeButtons.button(Icon.down, Styles.defaulti, () -> {if(reactorSize>1) {reactorSize--;}});
                                });
                            }).grow().row();
                            resizeDialog.show();
                        }
                        );

                    });
                }).grow().row();
                dialog.cont.button("Back", Icon.left, Styles.cleart, dialog::hide).growX();
                dialog.show();
            }).size(40f);
            table.row();
        }
    }
}